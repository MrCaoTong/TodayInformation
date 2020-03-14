package com.caotong.http.request;

import com.caotong.http.annotation.RequestMethod;
import com.caotong.http.request.host.IHost;

import java.lang.reflect.Type;
import java.util.Map;

public class LfRequest implements IRequest {

    protected String path;

    protected IHost host;

    protected Map<String, Object> params;

    protected Type type;

    @RequestMethod
    protected int requestMethod;

    @Override
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public int getRequestMethod() {
        return requestMethod;
    }

    @Override
    public IHost getHost() {
        return host;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public Type getType() {
        return type;
    }
}
