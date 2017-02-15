package com.telerikproject.tvshowcalendar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.telerikproject.tvshowcalendar.R;
import com.telerikproject.tvshowcalendar.activities.MainActivity;

public class GridAdapter extends BaseAdapter {

    String[] titles;
    String[] series;
    Context context;
    int[] imageId;

    private static LayoutInflater inflater = null;

    public GridAdapter(MainActivity mainActivity, String[] moviesTitles, String[] moviesSeasons, int[] moviesImages) {
        titles = moviesTitles;
        series = moviesSeasons;
        context = mainActivity;
        imageId = moviesImages;

        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return titles.length;
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
        TextView series;
        ImageView images;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.grid_list, null);
        holder.titles = (TextView) rowView.findViewById(R.id.tv_title);
        holder.images = (ImageView) rowView.findViewById(R.id.iv_movie_image);
        holder.series = (TextView) rowView.findViewById(R.id.tv_seasons);

        holder.titles.setText(titles[position]);
        holder.images.setImageResource(imageId[position]);
        holder.series.setText(series[position]);

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Toast.makeText(context, "You Clicked " + titles[position], Toast.LENGTH_SHORT).show();
            }
        });

        return rowView;
    }
}
