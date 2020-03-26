package com.caotong.http.parser;

import com.caotong.http.request.IRequest;
import com.caotong.http.response.IResponse;
import com.caotong.http.result.IResult;

public interface IParser {
    IResult parseResponse(IRequest request, IResponse response);

}
