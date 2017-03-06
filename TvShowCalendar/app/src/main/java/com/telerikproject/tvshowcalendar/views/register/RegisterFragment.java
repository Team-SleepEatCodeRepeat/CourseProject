package com.telerikproject.tvshowcalendar.views.register;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.home.HomeActivity;
import com.telerikproject.tvshowcalendar.views.login.LoginActivity;
import com.telerikproject.tvshowcalendar.views.register.base.IRegisterContract;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements IRegisterContract.View {


    public RegisterFragment() {
        // Required empty public constructor
    }

    private IRegisterContract.Presenter presenter;

    EditText usernameET;

    EditText passwordET;

    @Inject
    ILoadingFragment loadingFragment;

    private ILoadingFragment loading;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        usernameET = (EditText) view.findViewById(R.id.username);
        passwordET = (EditText) view.findViewById(R.id.password);

        BaseApplication.bind(this, view);
        Button register = (Button) view.findViewById(R.id.sign_up_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();

                presenter.register(username, password);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.loading = this.loadingFragment.create(getActivity());

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.injectDependencies();

    }

    @Override
    public void setPresenter(IRegisterContract.Presenter presenter) {
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

    @Override
    public void redirectToLogin() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void successfullyRegistered(String username) {
        Toast.makeText(getActivity(), username + " successfully registered", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registrationFailed() {
        Toast.makeText(getActivity(), "Username already exists", Toast.LENGTH_SHORT).show();
    }

}
