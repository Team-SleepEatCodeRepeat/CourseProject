package com.telerikproject.tvshowcalendar.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.views.serialInfo.SerialInfoActivity;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    ArrayList<String> titles;
    ArrayList<String> ratings;
    Context context;
    ArrayList<String> images;
    ArrayList<String> ids;



    private static LayoutInflater inflater = null;

    public GridAdapter(Activity choosenActivity, ArrayList<String> moviesTitles, ArrayList<String> moviesRating, ArrayList<String> moviesImages, ArrayList<String> ids) {
        titles = moviesTitles;
        ratings = moviesRating;
        context = choosenActivity;
        images = moviesImages;
        this.ids = ids;

        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView titles;
        TextView ratings;
        ImageView images;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.grid_list, null);
        holder.titles = (TextView) rowView.findViewById(R.id.tv_title);
        holder.images = (ImageView) rowView.findViewById(R.id.iv_movie_image);
        holder.ratings = (TextView) rowView.findViewById(R.id.tv_seasons);

        holder.titles.setText(titles.get(position));
        Glide.with(context).load(images.get(position)).into(holder.images);
        holder.ratings.setText(ratings.get(position));

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SerialInfoActivity.class);
                String id = ids.get(position);
                intent.putExtra("id", ids.get(position));
                context.startActivity(intent);
            }
        });

        return rowView;
    }

}
