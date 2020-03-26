package com.caotong.http.parser;

import com.caotong.http.request.IRequest;
import com.caotong.http.response.IResponse;
import com.caotong.http.result.IResult;
import com.caotong.http.result.Result;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by anson on 2019/1/26.
 */
public class DefaultResultParser implements IParser{

    private static DefaultResultParser mInstance;
    private final Gson mGson;

    private DefaultResultParser() {
        mGson = new Gson();
    }

    public static IParser getInstance() {
        if (mInstance == null) {
            mInstance = new DefaultResultParser();
        }
        return mInstance;
    }


    @Override
    public IResult parseResponse(IRequest request, IResponse response) {
        Type type = request.getType();
        String bodyStr = response.getBodyStr();
        Object object = mGson.fromJson(bodyStr, type);
        return Result.success(object);

    }
}
