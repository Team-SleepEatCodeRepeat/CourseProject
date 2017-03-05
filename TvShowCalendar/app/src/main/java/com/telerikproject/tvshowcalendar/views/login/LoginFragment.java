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
import android.widget.Toast;

import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.fragments.ILoadingFragment;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.login.base.ILoginContract;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements ILoginContract.View {

    private ILoginContract.Presenter presenter;

    EditText usernameET;

    EditText passwordET;

    @Inject
    ILoadingFragment loadingFragment;

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
}
