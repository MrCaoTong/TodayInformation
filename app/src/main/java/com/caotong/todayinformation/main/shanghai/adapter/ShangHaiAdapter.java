package com.caotong.todayinformation.main.shanghai.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.caotong.todayinformation.R;
import com.caotong.todayinformation.main.shanghai.dto.ShangHaiBean;
import com.caotong.todayinformation.main.shanghai.view.ShangHaiDetailActivity;

import java.util.ArrayList;

public class ShangHaiAdapter extends RecyclerView.Adapter {

    private RecyclerView.RecycledViewPool recyclerViewPool;
    private ArrayList<ShangHaiBean> mData;
    private Activity mContext;

    public ShangHaiAdapter(Activity context, ArrayList<ShangHaiBean> mData) {
        recyclerViewPool = new RecyclerView.RecycledViewPool();
        this.mContext = context;
        this.mData = mData;
    }

    //创建View 然后进行缓存
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ShangHaiBean.IShangHaiItemType.VERTICAL) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment, parent, false);
            ShangHaiViewHolder shangHaiViewHolder = new ShangHaiViewHolder(inflate);
            return shangHaiViewHolder;
        } else if (viewType == ShangHaiBean.IShangHaiItemType.HORIZANTAL) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment_rv, parent, false);
            ShangHaiViewHolderRv shangHaiViewHolderRv = new ShangHaiViewHolderRv(inflate);
            return shangHaiViewHolderRv;
        }
        return null;
    }

    //绑定数据
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShangHaiBean shangHaiBean = mData.get(position);
        if (holder instanceof ShangHaiViewHolder) {
            ((ShangHaiViewHolder) holder).textView.setText(shangHaiBean.getmDec());
            ((ShangHaiViewHolder) holder).imageView.setVisibility(shangHaiBean.isShowImg() ? View.VISIBLE : View.GONE);
            holder.itemView.setTag(position);
        } else if (holder instanceof ShangHaiViewHolderRv) {
            ((ShangHaiViewHolderRv) holder).recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            ((ShangHaiViewHolderRv) holder).recyclerView.setAdapter(new ShangHaiAdapter(mContext, shangHaiBean.getData()));

        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getmItemType();
    }


    public class ShangHaiViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public ShangHaiViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_shanghai_iv);
            textView = itemView.findViewById(R.id.item_shanghai_tv);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShangHaiDetailActivity.start_5_0(mContext, imageView);
                }
            });
        }
    }

    public class ShangHaiViewHolderRv extends RecyclerView.ViewHolder {

        private RecyclerView recyclerView;

        public ShangHaiViewHolderRv(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.item_shanghai_recyclerview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
            linearLayoutManager.setRecycleChildrenOnDetach(true);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setRecycledViewPool(recyclerViewPool);
        }
    }
}
