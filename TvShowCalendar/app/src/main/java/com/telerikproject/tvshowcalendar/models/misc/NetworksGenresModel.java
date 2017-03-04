package com.telerikproject.tvshowcalendar.models.misc;

import com.telerikproject.tvshowcalendar.models.misc.base.INetworksGenresModel;

public class NetworksGenresModel implements INetworksGenresModel {
    private int id;
    private String name;

    public NetworksGenresModel() {

    }

    public NetworksGenresModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }
}
