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
import com.telerikproject.tvshowcalendar.models.ITvShow;
import com.telerikproject.tvshowcalendar.views.serialInfo.SerialInfoActivity;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends BaseAdapter {

    private static LayoutInflater inflater;

    private final Context context;
    private List<ITvShow> tvShows;

    //TODO  setVisibility on Imageviews with id isWatched and IsFollowed
    public GridAdapter(Context context, List<ITvShow> tvShows) {
        this.context = context;
        this.tvShows = tvShows;

        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void swap(List<ITvShow> tvShows) {
        this.tvShows = tvShows;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return tvShows.size();
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

        final ITvShow currentTvShow = tvShows.get(position);

        holder.titles.setText(currentTvShow.getName());
        Glide.with(context).load(currentTvShow.getPoster()).into(holder.images);
        holder.ratings.setText(currentTvShow.getVote());

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SerialInfoActivity.class);
                String id = currentTvShow.getId();
                intent.putExtra("id", currentTvShow.getId());
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
