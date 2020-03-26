package com.caotong.todayinformation.main.hangzhou;

import androidx.viewpager.widget.ViewPager;

import com.caotong.todayinformation.R;
import com.caotong.todayinformation.base.BaseFragment;
import com.caotong.todayinformation.base.ViewInject;
import com.caotong.todayinformation.main.hangzhou.adapter.HangZhouViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.fragment_hangzhou)
public class HangZhouFragment extends BaseFragment {
    @BindView(R.id.tl_tablayout)
    TabLayout tlTablayout;
    @BindView(R.id.vp_viewpager)
    ViewPager vpViewpager;

    @Override
    public void afterBindView() {
        tlTablayout.setupWithViewPager(vpViewpager);
        vpViewpager.setAdapter(new HangZhouViewPagerAdapter(getChildFragmentManager()));
    }
}
