package com.caotong.todayinformation.splash;

import com.caotong.mvp.mvp.base.BaseMvpPresenter;

public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.Iview> implements ISplashActivityContract.IPresenter {

    private CustomCountDownTimer timer;

    public SplashTimerPresenter(ISplashActivityContract.Iview view) {
        super(view);
    }

    @Override
    public void initTimer() {
        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTvTimer(time + "秒");
            }

            @Override
            public void onFinish() {
                getView().setTvTimer("跳过");
            }
        });
        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
    }

    @Override
    protected ISplashActivityContract.Iview getEmptyView() {
        return ISplashActivityContract.emptyView;
    }
}
