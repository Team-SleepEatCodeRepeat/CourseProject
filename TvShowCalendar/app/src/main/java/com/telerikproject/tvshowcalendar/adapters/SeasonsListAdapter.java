package com.telerikproject.tvshowcalendar.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.telerikproject.tvshowcalendar.R;

import java.util.ArrayList;

public class SeasonsListAdapter extends BaseAdapter {

    private final Activity mActivity;
    private final int numOfSeasons;

    ArrayList<Integer> seasons;

    private LayoutInflater inflater = null;

    public SeasonsListAdapter(Activity activity, int numOfseasons) {
        this.mActivity = activity;
        this. numOfSeasons = numOfseasons;
        this.seasons = new ArrayList<>();
        inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        fillSeasons(numOfseasons);
    }

    @Override
    public int getCount() {
        return seasons.size();
    }

    @Override
    public Object getItem(int position) {
        return seasons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class Holder {
        TextView season;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.seasons_list, null);

        holder.season = (TextView) rowView.findViewById(R.id.tv_seasons_list);

        String text = "Season " + seasons.get(position);

        holder.season.setText(text);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity, "you clicked " + seasons.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        return rowView;
    }

    private void fillSeasons(int numOfSeasons) {
        for(int i = 1; i <= numOfSeasons; i++) {
            this.seasons.add(i);
        }
    }
}
