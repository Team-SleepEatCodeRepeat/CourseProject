package com.telerikproject.tvshowcalendar.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.utils.base.IJsonParser;
import com.telerikproject.tvshowcalendar.utils.userSession.UserSession;
import com.telerikproject.tvshowcalendar.utils.userSession.base.IUserSession;
import com.telerikproject.tvshowcalendar.views.login.LoginActivity;
import com.telerikproject.tvshowcalendar.views.home.HomeActivity;
import com.telerikproject.tvshowcalendar.activities.ProfileActivity;
import com.telerikproject.tvshowcalendar.views.logout.LogoutActivity;

import javax.inject.Inject;

public class ToolbarFragment extends Fragment {

    Toolbar toolbar;

    @Inject
    FragmentManager fragmentManager;

    @Inject
    IUserSession userSession;

    public ToolbarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);
        this.injectDependencies();

        AppCompatActivity currentActivity = (AppCompatActivity) getActivity();
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        currentActivity.setSupportActionBar(toolbar);

        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        PrimaryDrawerItem home = new PrimaryDrawerItem()
                .withIdentifier(1)
                .withName("Home")
                .withIcon(FontAwesome.Icon.faw_home);

        SecondaryDrawerItem profile = new SecondaryDrawerItem()
                .withIdentifier(2)
                .withName("Profile")
                .withIcon(FontAwesome.Icon.faw_user);

        SecondaryDrawerItem login = new SecondaryDrawerItem()
                .withIdentifier(3)
                .withName("Sign In")
                .withIcon(FontAwesome.Icon.faw_sign_in);

        final SecondaryDrawerItem logout = new SecondaryDrawerItem()
                .withIdentifier(5)
                .withName("Logout")
                .withIcon(FontAwesome.Icon.faw_sign_out);

        Drawer result = new DrawerBuilder()
                .withActivity(getActivity())
                .withToolbar(toolbar)
                .addDrawerItems(
                        home,
                        new DividerDrawerItem(),
                        profile,
                        this.userSession.isUserLoggedIn() ? logout : login
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch (position) {
                            case 1:
                                Intent home = new Intent(getActivity(), HomeActivity.class);
                                startActivity(home);
                                break;
                            case 2:
                                Intent profile = new Intent(getActivity(), ProfileActivity.class);
                                startActivity(profile);
                                break;
                            case 3:
                                if(userSession.isUserLoggedIn()) {
                                    userSession.clearSession();
                                    Intent logout = new Intent(getActivity(), LogoutActivity.class);
                                    startActivity(logout);
                                } else {
                                    Intent login = new Intent(getActivity(), LoginActivity.class);
                                    startActivity(login);
                                }
                                break;
                        }
                        return false;
                    }
                })
                .build();
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
}
