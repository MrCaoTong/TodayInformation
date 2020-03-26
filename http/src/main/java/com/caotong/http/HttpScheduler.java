package com.caotong.http;

import com.caotong.http.parser.IParser;
import com.caotong.http.request.IRequest;
import com.caotong.http.request.call.ICall;
import com.caotong.http.response.IResponse;
import com.caotong.http.result.IResult;

public abstract class HttpScheduler {

    public abstract ICall newCall(IRequest request);

    public IResult execute(ICall iCall) {
        //IRespnse 和  IResult 进行一个转换
        IResponse iResponse = iCall.execute();
        IRequest request = iCall.getRequest();
        IParser parser = request.getParser();
        return parser.parseResponse(request,iResponse);
    }
}
