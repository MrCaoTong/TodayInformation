package com.caotong.todayinformation.main.hangzhou.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.caotong.todayinformation.R;
import com.caotong.todayinformation.main.shanghai.dto.ShangHaiDetailBean;

import java.util.ArrayList;

public class ZhiHuAdapter extends RecyclerView.Adapter {
    private ArrayList<ShangHaiDetailBean.XiaoHuaBean> mLists;

    public ZhiHuAdapter(ArrayList<ShangHaiDetailBean.XiaoHuaBean> mLists) {
        this.mLists = mLists;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment, null);
        ShanghaiViewHolder viewHolder = new ShanghaiViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShangHaiDetailBean.XiaoHuaBean xiaoHuaBean = mLists.get(position);
        ((ShanghaiViewHolder) holder).mTv.setText(xiaoHuaBean.content);
        ((ShanghaiViewHolder) holder).mIv.setVisibility(View.GONE);
    }

    // 条目的数量
    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public class ShanghaiViewHolder extends RecyclerView.ViewHolder{

        public TextView mTv;
        public ImageView mIv;

        public ShanghaiViewHolder(View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.item_shanghai_tv);
            mIv = itemView.findViewById(R.id.item_shanghai_iv);
        }
    }
}
