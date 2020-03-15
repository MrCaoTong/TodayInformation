package com.caotong.todayinformation.base;

import com.caotong.http.annotation.RequestMethod;
import com.caotong.http.request.IRequest;
import com.caotong.http.request.LfRequest;

public class JHRequest extends LfRequest {

    public static IRequest sendHttp(String path, @RequestMethod int requestMethod) {
        JHRequest request = new JHRequest();
        request.host = HostManager.jhHost;
        request.path = path;
        request.requestMethod = requestMethod;
        return request;
    }
}
