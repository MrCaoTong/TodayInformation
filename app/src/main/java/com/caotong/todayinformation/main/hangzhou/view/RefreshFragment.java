package com.caotong.todayinformation.main.hangzhou.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.caotong.refresh.GodRefreshLayout;
import com.caotong.todayinformation.R;
import com.caotong.todayinformation.base.BaseFragment;
import com.caotong.todayinformation.base.ViewInject;
import com.caotong.todayinformation.main.hangzhou.adapter.ZhiHuAdapter;
import com.caotong.todayinformation.main.hangzhou.refresh.MeiTuanRefreshManager;
import com.caotong.todayinformation.main.shanghai.dto.ShangHaiDetailBean;
import com.caotong.todayinformation.main.shanghai.lf.IShanghaiDetailContract;
import com.caotong.todayinformation.main.shanghai.presenter.ShanghaiDetailPresenter;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.fragment_refresh)
public class RefreshFragment extends BaseFragment implements IShanghaiDetailContract.Iview {

    IShanghaiDetailContract.IPresenter mPresenter = new ShanghaiDetailPresenter(this);
//    @BindView(R.id.refresh_recyclerview)
//    RecyclerView refreshRecyclerview;
    @BindView(R.id.god_refresh)
    GodRefreshLayout godRefresh;

    @Override
    public void afterBindView() {
        initRecyclerView();
        initRefreshLayout();
    }

    private void initRefreshLayout() {
        //1、采用默认的方式
        //2、自定义方式
        godRefresh.setRefreshManager(new MeiTuanRefreshManager(mContext));
        godRefresh.setRefreshListener(new GodRefreshLayout.RefreshingListener() {
            @Override
            public void onRefreshing() {
                godRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        godRefresh.refreshOver();
                    }
                }, 2000);
            }
        });
    }

    private void initRecyclerView() {
//        refreshRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
//        mPresenter.getNetData(20);
    }

    @Override
    public void showData(ShangHaiDetailBean data) {
//        if (refreshRecyclerview.getAdapter() == null) {
//            ZhiHuAdapter adapter = new ZhiHuAdapter(data.result.data);
//            refreshRecyclerview.setAdapter(adapter);
//        }
//        godRefresh.refreshOver();
    }
}
