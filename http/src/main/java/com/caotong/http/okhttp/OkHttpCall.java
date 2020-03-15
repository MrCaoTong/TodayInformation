package com.caotong.http.okhttp;

import android.util.Log;

import com.caotong.http.request.IRequest;
import com.caotong.http.request.call.ICall;
import com.caotong.http.response.IResponse;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class OkHttpCall implements ICall {
    private IRequest request;
    private Call call;

    public OkHttpCall(IRequest request, Call call) {
        this.call = call;
        this.request = request;
    }

    @Override
    public Object execute() {
        Response response = null;
        try {
            response = call.execute();
//            Log.e("test:",response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public IRequest getRequest() {
        return request;
    }
}
