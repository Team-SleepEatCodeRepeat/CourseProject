package com.telerikproject.tvshowcalendar.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.telerikproject.tvshowcalendar.utils.base.IJsonParser;

import java.lang.reflect.Type;


public class GsonParser implements IJsonParser{

    @Override
    public <T> T fromJson(String json, Type classOfT) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        T result = gson.fromJson(json, classOfT);

        return result;

    }

}
