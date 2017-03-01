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

public class EpisodeListAdapter extends BaseAdapter {

    ArrayList<String> titles;
    ArrayList<String> episodeNumbers;
    ArrayList<String> datesRelease;
    ArrayList<String> yearsRelease;

    Context context;

    private static LayoutInflater inflater = null;

    public EpisodeListAdapter(Activity choosenActivity, ArrayList<String> episodesTitle, ArrayList<String> episodesNum, ArrayList<String> episodesDateRelease, ArrayList<String> episodeYearsRelease) {
        titles = episodesTitle;
        episodeNumbers = episodesNum;
        datesRelease = episodesDateRelease;
        yearsRelease = episodeYearsRelease;
        context = choosenActivity;

        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

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
        TextView episodeNumber;
        TextView titles;
        TextView datesRelease;
        TextView yearsRelease;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        EpisodeListAdapter.Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.episode_list, null);

        holder.titles = (TextView) rowView.findViewById(R.id.tv_episode_name);
        holder.episodeNumber = (TextView) rowView.findViewById(R.id.tv_episode_number);
        holder.datesRelease = (TextView) rowView.findViewById(R.id.tv_date);
        holder.yearsRelease = (TextView) rowView.findViewById(R.id.tv_date_year);

        holder.titles.setText(titles.get(position));
        holder.episodeNumber.setText(episodeNumbers.get(position));
        holder.datesRelease.setText(datesRelease.get(position));
        holder.yearsRelease.setText(yearsRelease.get(position));

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Toast.makeText(context, "Clicked Episode List Adapter", Toast.LENGTH_LONG);
            }
        });

        return rowView;
    }
}
