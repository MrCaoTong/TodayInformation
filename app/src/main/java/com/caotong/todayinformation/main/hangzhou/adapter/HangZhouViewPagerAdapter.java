package com.caotong.todayinformation.main.hangzhou.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.caotong.todayinformation.main.hangzhou.view.JiKeFragment;
import com.caotong.todayinformation.main.hangzhou.view.RefreshFragment;
import com.caotong.todayinformation.main.hangzhou.view.ZhiHuFragment;

import java.util.ArrayList;

public class HangZhouViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<String> mTitleList = new ArrayList<>();

    public HangZhouViewPagerAdapter(FragmentManager childFragmentManager) {
        super(childFragmentManager);
        mTitleList.add("知乎");
        mTitleList.add("即刻");
        mTitleList.add("下拉刷新");
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ZhiHuFragment();
            case 1:
                return new JiKeFragment();
            case 2:
                return new RefreshFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTitleList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }
}
