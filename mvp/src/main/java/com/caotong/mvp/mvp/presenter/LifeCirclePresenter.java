package com.caotong.mvp.mvp.presenter;

import com.caotong.mvp.mvp.ILifeCircle;
import com.caotong.mvp.mvp.IMvpView;
import com.caotong.mvp.mvp.MvpControler;

import java.lang.ref.WeakReference;

public abstract class LifeCirclePresenter<T extends IMvpView> implements ILifeCircle {

    protected WeakReference<T> weakReference;

    protected LifeCirclePresenter() {
        super();
    }

    public LifeCirclePresenter(IMvpView iMvpView) {
        super();
        attachView(iMvpView);
        MvpControler mvpControler = iMvpView.getMvpControler();
        mvpControler.savePresenter(this);
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        if (weakReference == null) {
            weakReference = new WeakReference(iMvpView);
        } else {
            T view = weakReference.get();
            if (view != iMvpView) {
                weakReference = new WeakReference(iMvpView);
            }
        }
    }

    @Override
    public void onDestroy() {
        weakReference = null;
    }

    protected T getView() {
        T view = weakReference != null ? (T) weakReference.get() : null;
        if (view == null) {
            return getEmptyView();
        }
        return view;
    }

    protected abstract T getEmptyView();
}
