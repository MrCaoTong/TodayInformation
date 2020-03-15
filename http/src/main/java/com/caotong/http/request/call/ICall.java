package com.caotong.http.request.call;

import com.caotong.http.request.IRequest;
import com.caotong.http.response.IResponse;

public interface ICall {

    Object execute();

    IRequest getRequest();
}
