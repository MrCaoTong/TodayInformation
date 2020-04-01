package com.caotong.todayinformation.main.shanghai.presenter;

import com.caotong.http.result.IResult;
import com.caotong.todayinformation.base.BasePresenter;
import com.caotong.todayinformation.base.JHTask;
import com.caotong.todayinformation.main.shanghai.dto.ShangHaiDetailBean;
import com.caotong.todayinformation.main.shanghai.lf.IShanghaiDetailContract;
import com.caotong.todayinformation.main.shanghai.module.ShangHaiDetailHttpTask;

public class ShanghaiDetailPresenter extends BasePresenter<IShanghaiDetailContract.Iview> implements IShanghaiDetailContract.IPresenter {

    public ShanghaiDetailPresenter(IShanghaiDetailContract.Iview view) {
        super(view);
    }

    @Override
    public void getNetData(int pagesize) {
            /*架构师的必备条件
              1、合理利用继承关系
              2、合理利用抽象编程
              3、合理利用泛型传递数据
              4、合理利用一些设计模式
            */
        submitTask(new JHTask<ShangHaiDetailBean>() {
            @Override
            public IResult<ShangHaiDetailBean> onBackground() {
                return new ShangHaiDetailHttpTask<ShangHaiDetailBean>().getXiaoHuaList("desc", "1", pagesize + "");
            }

            @Override
            public void onSuccess(IResult<ShangHaiDetailBean> t) {
                ShangHaiDetailBean data = t.data();
//                   Gson gson = new Gson();
//                   String s = gson.toJson(data);
//                   Log.e("ShanghaiDetailPresenter", s);
                getView().showData(data);
            }
        });
    }
}
