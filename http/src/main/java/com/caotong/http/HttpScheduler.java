package com.caotong.http;

import com.caotong.http.request.IRequest;
import com.caotong.http.request.call.ICall;
import com.caotong.http.response.IResponse;

public abstract class HttpScheduler {

    public abstract ICall newCall(IRequest request);

    public Object execute(ICall iCall) {
        return iCall.execute();
    }
}
