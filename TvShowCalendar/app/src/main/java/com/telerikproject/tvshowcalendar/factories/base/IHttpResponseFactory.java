package com.telerikproject.tvshowcalendar.factories.base;

import com.telerikproject.tvshowcalendar.utils.base.IHttpResponse;

public interface IHttpResponseFactory {
    IHttpResponse createResponse(final String body);
}
