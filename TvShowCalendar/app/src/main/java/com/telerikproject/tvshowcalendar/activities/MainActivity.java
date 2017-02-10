package com.telerikproject.tvshowcalendar.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.GridView;

import com.telerikproject.tvshowcalendar.Adapter.GridAdapter;
import com.telerikproject.tvshowcalendar.R;

import java.util.ArrayList;

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
        gridView = (GridView) findViewById(R.id.gv_top_10);
        gridView.setAdapter(new GridAdapter(this, moviesTitles, moviesSeasons, moviesImages));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
    }

//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }
}
