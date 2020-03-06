package com.caotong.todayinformation.main.shanghai.dto;

import java.util.ArrayList;

public class ShangHaiBean {
    private int mItemType = IShangHaiItemType.VERTICAL;
    private String mDec;
    private boolean isShowImg;
    private ArrayList<ShangHaiBean> data;

    public int getmItemType() {
        return mItemType;
    }

    public void setmItemType(int mItemType) {
        this.mItemType = mItemType;
    }

    public String getmDec() {
        return mDec;
    }

    public void setmDec(String mDec) {
        this.mDec = mDec;
    }

    public boolean isShowImg() {
        return isShowImg;
    }

    public void setShowImg(boolean showImg) {
        isShowImg = showImg;
    }

    public ArrayList<ShangHaiBean> getData() {
        return data;
    }

    public void setData(ArrayList<ShangHaiBean> data) {
        this.data = data;
    }

    public interface IShangHaiItemType {
        int VERTICAL = 0;
        int HORIZANTAL = 1;
    }

}
