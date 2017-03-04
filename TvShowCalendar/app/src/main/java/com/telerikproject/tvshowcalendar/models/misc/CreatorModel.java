package com.telerikproject.tvshowcalendar.models.misc;

import com.telerikproject.tvshowcalendar.models.misc.base.ICreatorModel;

public class CreatorModel implements ICreatorModel {
    private int id;
    private String name;
    private String profile_path;

    public CreatorModel() {

    }

    public CreatorModel(int id, String name, String profile_path) {
        this.id = id;
        this.name = name;
        this.profile_path = profile_path;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getProfilePath() {
        return profile_path;
    }
}
