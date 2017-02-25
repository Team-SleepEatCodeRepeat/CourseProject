package com.telerikproject.tvshowcalendar.models;

import com.telerikproject.tvshowcalendar.models.base.ICrewMemberModel;

public class CrewMemberModel implements ICrewMemberModel {
    private int id;
    private String credit_id;
    private String name;
    private String department;
    private String job;
    private String profile_path;

    public CrewMemberModel() {

    }

    public CrewMemberModel(int id, String credit_id, String name, String department, String job, String profile_path) {
        this.id = id;
        this.credit_id = credit_id;
        this.name = name;
        this.department = department;
        this.job = job;
        this.profile_path = profile_path;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getCreditId() {
        return credit_id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public String getJob() {
        return job;
    }

    @Override
    public String getProfilePath() {
        return profile_path;
    }
}
