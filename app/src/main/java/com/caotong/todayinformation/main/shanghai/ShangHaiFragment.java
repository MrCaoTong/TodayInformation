package com.caotong.todayinformation.main.shanghai;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.caotong.todayinformation.R;
import com.caotong.todayinformation.base.BaseFragment;
import com.caotong.todayinformation.base.ViewInject;
import com.caotong.todayinformation.main.shanghai.adapter.ShangHaiAdapter;
import com.caotong.todayinformation.main.shanghai.dto.ShangHaiBean;
import com.caotong.todayinformation.main.shanghai.dto.ShangHaiDataManager;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.fragment_shanghai)
public class ShangHaiFragment extends BaseFragment {
    @BindView(R.id.tv_shanghai_welcome)
    TextView tvShanghaiWelcome;
    @BindView(R.id.shanghai_app_barlayout)
    AppBarLayout shanghaiAppBarlayout;
    @BindView(R.id.shanghai_recyclerview)
    RecyclerView shanghaiRecyclerview;

    @Override
    public void afterBindView() {
        initRecyclerView();
        initListener();
    }

    private void initRecyclerView() {
        shanghaiRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        shanghaiRecyclerview.setAdapter(new ShangHaiAdapter(mContext, ShangHaiDataManager.getData()));
    }

    private void initListener() {
        shanghaiAppBarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (-i < appBarLayout.getMeasuredHeight() / 2) {
                    tvShanghaiWelcome.setVisibility(View.INVISIBLE);
                } else {
                    tvShanghaiWelcome.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
