package com.telerikproject.tvshowcalendar.views.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.factories.base.ILoadingFactory;
import com.telerikproject.tvshowcalendar.fragments.base.ILoadingFragment;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.home.HomeActivity;
import com.telerikproject.tvshowcalendar.views.login.base.ILoginContract;
import com.telerikproject.tvshowcalendar.views.register.RegisterActivity;

import javax.inject.Inject;

public class LoginFragment extends Fragment implements ILoginContract.View {

    private ILoginContract.Presenter presenter;

    EditText usernameET;

    EditText passwordET;

    @Inject
    ILoadingFactory loadingFactory;

    private ILoadingFragment loading;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        usernameET = (EditText) view.findViewById(R.id.username);
        passwordET = (EditText) view.findViewById(R.id.password);

        BaseApplication.bind(this, view);
        Button login = (Button) view.findViewById(R.id.sign_in_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();

                presenter.login(username, password);
            }
        });

        TextView register = (TextView) view.findViewById(R.id.sign_up);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToRegister();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.loading = this.loadingFactory.create();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.injectDependencies();

    }

    @Override
    public void setPresenter(ILoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    private void injectDependencies() {
        BaseApplication
                .from(getContext())
                .getAppComponent()
                .getControllerComponent(new ControllerModule(
                        getActivity(), getFragmentManager()
                ))
                .inject(this);
    }


//
//    @OnClick(R.id.sign_in_button)
//    public void login() {
//        String username = usernameET.getText().toString();
//        String password = passwordET.getText().toString();
//
//        this.presenter.login(username, password);
//    }

    @Override
    public void setLoadingFragment(ILoadingFragment loadingFragment) {
        this.loading = loadingFragment;
    }

    @Override
    public void showLoading() {
        this.loading.show();
    }

    @Override
    public void hideLoading() {
        this.loading.hide();
    }

    public void redirectToRegister() {
        Intent intent = new Intent(getActivity(), RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void redirectToHome() {
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginSuccessful(String username) {
        Toast.makeText(getActivity(), username + " successfully logged in!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(getActivity(), "Wrong username or password", Toast.LENGTH_SHORT).show();
    }
}
