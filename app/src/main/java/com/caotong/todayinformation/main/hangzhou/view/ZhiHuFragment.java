package com.caotong.todayinformation.main.hangzhou.view;

import android.view.animation.AnimationUtils;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.caotong.todayinformation.R;
import com.caotong.todayinformation.base.BaseFragment;
import com.caotong.todayinformation.base.ViewInject;
import com.caotong.todayinformation.main.hangzhou.adapter.ZhiHuAdapter;
import com.caotong.todayinformation.main.shanghai.dto.ShangHaiDetailBean;
import com.caotong.todayinformation.main.shanghai.lf.IShanghaiDetailContract;
import com.caotong.todayinformation.main.shanghai.presenter.ShanghaiDetailPresenter;
import com.google.android.material.appbar.AppBarLayout;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.fragment_zhihu)
public class ZhiHuFragment extends BaseFragment implements IShanghaiDetailContract.Iview {
    IShanghaiDetailContract.IPresenter mPresenter = new ShanghaiDetailPresenter(this);

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.zhihu_app_barlayot)
    AppBarLayout zhihuAppBarlayot;
    @BindView(R.id.zhihu_recyclerview)
    RecyclerView zhihuRecyclerview;

    @Override
    public void afterBindView() {
        zhihuRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        zhihuRecyclerview.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.zhihu_recyclerview_show));
        mPresenter.getNetData(20);
    }

    @Override
    public void showData(ShangHaiDetailBean data) {
        if (zhihuRecyclerview.getAdapter() == null) {
            ZhiHuAdapter adapter = new ZhiHuAdapter(data.result.data);
            zhihuRecyclerview.setAdapter(adapter);
        }
    }
}
