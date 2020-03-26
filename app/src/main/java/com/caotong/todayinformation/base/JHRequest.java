package com.caotong.todayinformation.base;

import com.caotong.http.annotation.RequestMethod;
import com.caotong.http.parser.DefaultResultParser;
import com.caotong.http.request.IRequest;
import com.caotong.http.request.LfRequest;

import java.lang.reflect.Type;

public class JHRequest extends LfRequest {

    public static IRequest sendHttp(String path, @RequestMethod int requestMethod, Type type) {
        JHRequest request = new JHRequest();
        request.host = HostManager.jhHost;
        request.path = path;
        request.requestMethod = requestMethod;
        request.type = type;
        request.resultParser = DefaultResultParser.getInstance();
        return request;
    }
}
