package com.telerikproject.tvshowcalendar.data.base;


import com.telerikproject.tvshowcalendar.models.user.base.IUserModel;

import io.reactivex.Observable;

public interface IUserData {
    Observable<IUserModel> login(String username, String password);

    Observable<IUserModel> register(String username, String password);
}
