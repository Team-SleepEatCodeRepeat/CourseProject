package com.telerikproject.tvshowcalendar.views.register;

import android.widget.Toast;

import com.telerikproject.tvshowcalendar.data.base.IUserData;
import com.telerikproject.tvshowcalendar.models.user.base.IUserModel;
import com.telerikproject.tvshowcalendar.views.register.base.IRegisterContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterPresenter implements IRegisterContract.Presenter {

    private IRegisterContract.View view;

    private IUserData userData;

    @Inject
    public RegisterPresenter(IUserData userData) {
        this.userData = userData;
    }


    @Override
    public void load() {

    }


    @Override
    public void setView(IRegisterContract.View view) {
        this.view = view;
    }

    @Override
    public void register(String username, String password) {
        userData.register(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IUserModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        view.showLoading();
                    }

                    @Override
                    public void onNext(IUserModel value) {
                            view.successfullyRegistered(value.getUsername());
                    }

                    @Override
                    public void onError(Throwable e) {

                        Throwable c = e;
                        view.registrationFailed();
                        view.hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        view.hideLoading();
                        view.redirectToLogin();
                    }
                });
    }
}
