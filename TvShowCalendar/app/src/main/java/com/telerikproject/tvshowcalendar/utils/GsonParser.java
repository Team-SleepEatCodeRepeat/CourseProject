package com.telerikproject.tvshowcalendar.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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


    @Override
    public String getDirectMember(String json, String memberName) {
        JsonParser jsonParser = new JsonParser();
        JsonObject parent = jsonParser
                .parse(json)
                .getAsJsonObject();

        JsonElement memberElement = parent.get(memberName);
        if (memberElement instanceof JsonNull) {
            return null;
        } else {
            return parent.getAsJsonObject(memberName).toString();
        }
    }

}
