package com.caotong.todayinformation.main.shanghai.lf;

import com.caotong.annotation.MvpEmptyViewFactory;
import com.caotong.mvp.mvp.ILifeCircle;
import com.caotong.mvp.mvp.IMvpView;
import com.caotong.todayinformation.main.shanghai.dto.ShangHaiDetailBean;

public interface IShanghaiDetailContract {

    @MvpEmptyViewFactory
    interface Iview extends IMvpView {
        void showData(ShangHaiDetailBean data);
    }

    interface IPresenter extends ILifeCircle {
        void getNetData(int pagesize);
    }
}
