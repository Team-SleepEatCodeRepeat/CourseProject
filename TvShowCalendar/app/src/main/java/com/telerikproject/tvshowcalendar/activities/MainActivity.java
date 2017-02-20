package com.telerikproject.tvshowcalendar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.telerikproject.tvshowcalendar.Adapter.GridAdapter;
import com.telerikproject.tvshowcalendar.BaseApplication;
import com.telerikproject.tvshowcalendar.R;

public class MainActivity extends AppCompatActivity {
    GridView gridView;

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

        gridView = (GridView) findViewById(R.id.gv_top_10);
        gridView.setAdapter(new GridAdapter(this, moviesTitles, moviesSeasons, moviesImages));
    }

    private void injectDependencies() {
        ((BaseApplication) getApplication()).getAppComponent().inject(this);
    }
}
