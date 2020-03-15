package com.caotong.todayinformation.splash;

import com.caotong.mvp.mvp.ILifeCircle;
import com.caotong.mvp.mvp.IMvpView;
import com.caotong.mvp.mvp.MvpControler;

public interface ISplashActivityContract {
    interface Iview extends IMvpView {
        void setTvTimer(String timer);
    }

    interface IPresenter extends ILifeCircle {
        void initTimer();
    }

    Iview emptyView = new Iview() {
        @Override
        public void setTvTimer(String timer) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
