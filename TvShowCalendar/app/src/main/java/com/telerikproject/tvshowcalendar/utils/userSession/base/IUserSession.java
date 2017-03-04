package com.telerikproject.tvshowcalendar.utils.userSession.base;

public interface IUserSession {
    String getUsername();

    void setUsername(String username);

    boolean isUserLoggedIn();

    void clearSession();
}
