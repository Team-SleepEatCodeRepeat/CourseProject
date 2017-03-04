package com.telerikproject.tvshowcalendar.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
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
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.views.login.LoginActivity;
import com.telerikproject.tvshowcalendar.views.home.HomeActivity;
import com.telerikproject.tvshowcalendar.activities.ProfileActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToolbarFragment extends Fragment {

    Toolbar toolbar;
    private AppCompatActivity currentActivity;

    public ToolbarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);

        currentActivity = (AppCompatActivity) getActivity();
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

        SecondaryDrawerItem options = new SecondaryDrawerItem()
                .withIdentifier(3)
                .withName("Options")
                .withIcon(FontAwesome.Icon.faw_cogs);

        SecondaryDrawerItem login = new SecondaryDrawerItem()
                .withIdentifier(4)
                .withName("Sign In")
                .withIcon(FontAwesome.Icon.faw_sign_in);

        Drawer result = new DrawerBuilder()
                .withActivity(getActivity())
                .withToolbar(toolbar)
                .addDrawerItems(
                        home,
                        new DividerDrawerItem(),
                        profile,
                        options,
                        login
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch (position) {
                            case 0:
                                Intent home = new Intent(getActivity(), HomeActivity.class);
                                startActivity(home);
                                break;
                            case 2:
                                Intent profile = new Intent(getActivity(), ProfileActivity.class);
                                startActivity(profile);
                                break;
                            case 3:
                                Toast.makeText(getActivity(), "Options", Toast.LENGTH_LONG).show();
//                                Intent options = new Intent(getActivity(), OptionsActivity.class);
//                                startActivity(options);
                                break;
                            case 4:
                                Intent login = new Intent(getActivity(), LoginActivity.class);
                                startActivity(login);
                                break;
                        }
                        return false;
                    }
                })
                .build();
    }
}
