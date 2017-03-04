package com.telerikproject.tvshowcalendar.views.login;

import com.telerikproject.tvshowcalendar.data.base.IUserData;
import com.telerikproject.tvshowcalendar.models.user.base.IUserModel;
import com.telerikproject.tvshowcalendar.views.login.base.ILoginContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements ILoginContract.Presenter {

    private ILoginContract.View view;

    private IUserData userData;

    @Inject
    public LoginPresenter(IUserData userData) {
        this.userData = userData;
    }


    @Override
    public void load() {

    }

    @Override
    public void setView(ILoginContract.View view) {
        this.view = view;
    }

    @Override
    public void login(String username, String password) {
        userData.login(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IUserModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        view.showLoading();
                    }

                    @Override
                    public void onNext(IUserModel value) {
                        IUserModel testVal = value;
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        view.hideLoading();
                    }
                });
    }
}
