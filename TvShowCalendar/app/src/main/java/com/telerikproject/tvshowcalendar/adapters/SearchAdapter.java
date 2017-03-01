package com.telerikproject.tvshowcalendar.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.telerikproject.tvshowcalendar.R;

import java.util.ArrayList;

public class SearchAdapter extends BaseAdapter {

    ArrayList<String> titles;
    ArrayList<String> images;
    Context context;

    private static LayoutInflater inflater = null;

    public SearchAdapter(Activity choosenActivity, ArrayList<String> moviesTitles, ArrayList<String> moviesImages) {
        titles = moviesTitles;
        images = moviesImages;
        context = choosenActivity;

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
        ImageView images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.search_list, null);

        holder.titles = (TextView) rowView.findViewById(R.id.tv_serial_title);
        holder.images = (ImageView) rowView.findViewById(R.id.iv_serial_image);

        holder.titles.setText(titles.get(position));
        Glide.with(context).load(images.get(position)).into(holder.images);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context , "Clicked Search Adapter" , Toast.LENGTH_LONG);
            }
        });
        return rowView;
    }
}
