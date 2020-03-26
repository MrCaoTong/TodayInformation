package com.caotong.http;

import com.caotong.http.request.IRequest;
import com.caotong.http.result.IResult;

import java.util.Map;

public class LfHttpServer {

    protected <T> IResult<T> execute(IRequest request, Map<String, Object> params) {
        return HttpHelper.execute(request, params);
    }
}
