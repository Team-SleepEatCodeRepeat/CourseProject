package com.telerikproject.tvshowcalendar.data;

import com.telerikproject.tvshowcalendar.constants.base.IApiConstants;
import com.telerikproject.tvshowcalendar.data.base.IUserData;
import com.telerikproject.tvshowcalendar.models.user.base.IUserModel;
import com.telerikproject.tvshowcalendar.utils.base.IJsonParser;
import com.telerikproject.tvshowcalendar.utils.base.IOkHttpRequester;
import com.telerikproject.tvshowcalendar.utils.base.IOkHttpResponse;
import com.telerikproject.tvshowcalendar.utils.userSession.base.IUserSession;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class UserData implements IUserData {

    private final IOkHttpRequester okHttpRequester;
    private final IJsonParser jsonParser;
    private final Type userModelType;
    private final IUserSession userSession;
    private final IApiConstants apiConstants;


    @Inject
    public UserData(IOkHttpRequester okHttpRequester, IJsonParser jsonParser,
                    IUserSession userSession, IApiConstants apiConstants, Type userModelType) {
        this.okHttpRequester = okHttpRequester;
        this.jsonParser = jsonParser;
        this.userModelType = userModelType;
        this.userSession = userSession;
        this.apiConstants = apiConstants;
    }


    @Override
    public Observable<IUserModel> login(String username, String password) {
        Map<String, String> user = new HashMap<>();
        user.put("username", username);
        user.put("password", password);

        return okHttpRequester.post(apiConstants.getLoginUrl(), user)
                .map(new Function<IOkHttpResponse, IUserModel>() {
                    @Override
                    public IUserModel apply(IOkHttpResponse okHttpResponse) throws Exception {
                        String respBody = okHttpResponse.getBody().string();
                        String userJson = jsonParser.getDirectMember(respBody, "user");
                        IUserModel user = jsonParser.fromJson(userJson, userModelType);

                        userSession.setUsername(user.getUsername());

                        return user;
                    }
                });
    }

    @Override
    public Observable<IUserModel> register(String username, String password) {
        Map<String, String> user = new HashMap<>();
        user.put("username", username);
        user.put("password", password);

        return okHttpRequester.post(apiConstants.getRegisterUrl(), user)
                .map(new Function<IOkHttpResponse, IUserModel>() {
                    @Override
                    public IUserModel apply(IOkHttpResponse okHttpResponse) throws Exception {
                        String respBody = okHttpResponse.getBody().string();
                        IUserModel user = jsonParser.fromJson(respBody, userModelType);

                        return user;
                    }
                });
    }
}
