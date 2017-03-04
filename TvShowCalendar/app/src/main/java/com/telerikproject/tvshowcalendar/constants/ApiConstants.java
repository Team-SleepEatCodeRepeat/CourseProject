package com.telerikproject.tvshowcalendar.constants;

import com.telerikproject.tvshowcalendar.constants.base.IApiConstants;

public final class ApiConstants implements IApiConstants {
    String baseUrl = "https://tvshow-server.herokuapp.com/";
    String loginUrl = String.format("%s%s", baseUrl, "auth/login/");
    String registerUrl = String.format("%s%s", baseUrl, "auth/register/");

    @Override
    public String getRegisterUrl() {
        return registerUrl;
    }

    @Override
    public String getLoginUrl() {
        return loginUrl;
    }
}
