package com.telerikproject.tvshowcalendar.models.user;


import com.telerikproject.tvshowcalendar.models.user.base.IUserModel;

public class UserModel implements IUserModel {
    private String username;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }
}
