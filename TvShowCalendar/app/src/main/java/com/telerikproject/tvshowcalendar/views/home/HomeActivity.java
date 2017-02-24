package com.telerikproject.tvshowcalendar.views.home;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.modules.ControllerModule;
import com.telerikproject.tvshowcalendar.views.home.base.IHomeContract;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity {
    @Inject
    IHomeContract.Presenter contentPresenter;

    @Inject
    FragmentManager fragmentManager;

    private HomeContentFragment content;

    public static int[] moviesImages = {R.drawable.the_originals, R.drawable.game_of_thrones,
            R.drawable.mr_robot, R.drawable.the_big_bang_theory,
            R.drawable.the_vampire_diaries, R.drawable.un_barco_en_el_espejo};
    public static String[] moviesTitles = {"The Originals", "Game Of Thrones", "Mr. Robot", "The Big Bang Theory", "The Vampire Diaries", "El Barco"};
    public static String[] moviesSeasons = {"4 seasons", "7 seasons", "3 seasons", "10 seasons", "8 seasons", "3 seasons"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.injectDependencies();

        content = (HomeContentFragment) fragmentManager.findFragmentById(R.id.fragment_home_content);

        contentPresenter.setView(content);
//        content.setPresenter(contentPresenter);

    }

    private void injectDependencies() {
        BaseApplication.bind(this)
                .from(this)
                .getAppComponent()
                .getControllerComponent(new ControllerModule(this, getSupportFragmentManager()))
                .inject(this);
    }
}
