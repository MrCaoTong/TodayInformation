package com.caotong.todayinformation.main.shanghai.module;

import com.caotong.http.annotation.RequestMethod;
import com.caotong.http.request.IRequest;
import com.caotong.todayinformation.base.JHRequest;

public interface ShangHaiDetailRequest {
    IRequest xiaoHuaRequest = JHRequest.sendHttp("/joke/content/list.php", RequestMethod.Get);
}
