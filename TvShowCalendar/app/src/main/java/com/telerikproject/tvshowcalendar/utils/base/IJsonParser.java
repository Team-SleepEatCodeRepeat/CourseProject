package com.telerikproject.tvshowcalendar.utils.base;

import java.lang.reflect.Type;

public interface IJsonParser {

    <T> T fromJson(String json, Type ClassOfT);

}
