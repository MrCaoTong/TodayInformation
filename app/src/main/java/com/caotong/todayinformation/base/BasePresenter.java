package com.caotong.todayinformation.base;

import com.caotong.annotation.MvpEmptyViewFactory;
import com.caotong.mvp.mvp.IMvpView;
import com.caotong.mvp.mvp.base.BaseMvpPresenter;
import com.caotong.task.LfTask;
import com.caotong.task.TaskHelper;

/**
 * 集成mvp 及 网络请求 快捷方式
 */
public class BasePresenter<T extends IMvpView> extends BaseMvpPresenter<T> {

    public BasePresenter(T view) {
        super(view);
    }

    public void submitTask(LfTask task) {
        TaskHelper.submitTask(task,task);
    }

    @Override
    protected T getEmptyView() {
        T t = null;
        Class superClassGenricType = GenericsUtils.getSuperClassGenricType(this.getClass(), 0);
//        t = (T) MvpEmptyViewFactory.create(superClassGenricType);
        return t;
    }
}
