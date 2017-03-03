package com.telerikproject.tvshowcalendar.models;


import com.telerikproject.tvshowcalendar.models.base.IGuestStarModel;

public class GuestStarModel implements IGuestStarModel {
    private int id;
    private String name;
    private String credit_id;
    private String character;
    private int order;
    private String profile_path;

    public GuestStarModel() {

    }

    public GuestStarModel(int id, String name, String credit_id, String character, int order, String profile_path) {
        this.id = id;
        this.name = name;
        this.character = character;
        this.credit_id = credit_id;
        this.order = order;
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
    public String getCreditId() {
        return credit_id;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public String getProfilePath() {
        return profile_path;
    }
}
