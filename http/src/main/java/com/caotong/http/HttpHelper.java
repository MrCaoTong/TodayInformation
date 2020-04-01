package com.caotong.http;

import com.caotong.http.okhttp.OkHttpScheduler;
import com.caotong.http.request.IRequest;
import com.caotong.http.request.call.ICall;
import com.caotong.http.result.IResult;

import java.util.Map;

public class HttpHelper {

    //https://www.jianshu.com/p/3a7c7a54ed0b volatile的作用
    private volatile static HttpScheduler httpScheduler;

    public static <T> IResult<T> execute(IRequest request, Map<String, Object> params) {
        request.setParams(params);
        ICall iCall = getHttpScheduler().newCall(request);
        return getHttpScheduler().execute(iCall);
    }

    private static HttpScheduler getHttpScheduler() {
        if (httpScheduler == null) {
            synchronized (HttpHelper.class) {
                if (httpScheduler == null) {
                    httpScheduler = new OkHttpScheduler();
                }
            }
        }
        return httpScheduler;
    }
}
