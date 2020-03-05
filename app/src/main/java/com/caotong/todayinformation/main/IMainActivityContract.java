package com.caotong.todayinformation.main;

import androidx.fragment.app.Fragment;

import com.caotong.todayinformation.mvp.ILifeCircle;
import com.caotong.todayinformation.mvp.IMvpView;
import com.caotong.todayinformation.mvp.MvpControler;
import com.caotong.todayinformation.splash.ISplashActivityContract;

public interface IMainActivityContract {
    interface Iview extends IMvpView {

        void showFragment(Fragment mFragment);

        void addFragment(Fragment mFragment);

        void hideFragment(Fragment mFragment);
    }

    interface IPresenter extends ILifeCircle {

        void initHomeFragment();

        int getCurrentCheckId();

        void replaceFragment(int mCurrentFragmentIndex);

        int getCurrentCheckedIndex();

        int getTopPosition();

        int getBottomPosition();
    }

    IMainActivityContract.Iview emptyView = new IMainActivityContract.Iview() {

        @Override
        public void showFragment(Fragment mFragment) {

        }

        @Override
        public void addFragment(Fragment mFragment) {

        }

        @Override
        public void hideFragment(Fragment mFragment) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
