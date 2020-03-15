package com.caotong.todayinformation.main.shanghai.dto;

import java.util.ArrayList;

public class ShangHaiDataManager {

    private static ArrayList<ShangHaiBean> getVerticalData(int length) {
        ArrayList<ShangHaiBean> mDatas = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            ShangHaiBean shangHaiBean = new ShangHaiBean();
            shangHaiBean.setShowImg(false);
            shangHaiBean.setmDec("welcome to shanghai");
            mDatas.add(shangHaiBean);
        }
        return mDatas;
    }

    private static ArrayList<ShangHaiBean> getHorizontalData(int length) {
        ArrayList<ShangHaiBean> mDatas = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            ShangHaiBean shangHaiBean = new ShangHaiBean();
            shangHaiBean.setShowImg(true);
            shangHaiBean.setmDec("上海魔都");
            mDatas.add(shangHaiBean);
        }
        return mDatas;
    }

    public static ArrayList<ShangHaiBean> getData() {
        ArrayList<ShangHaiBean> data = new ArrayList<>();
        data.addAll(getVerticalData(5));
        ShangHaiBean shangHaiBean = new ShangHaiBean();
        shangHaiBean.setData(getHorizontalData(10));
        shangHaiBean.setmItemType(ShangHaiBean.IShangHaiItemType.HORIZANTAL);
        data.add(shangHaiBean);
        data.addAll(getVerticalData(5));
        data.add(shangHaiBean);
        return data;
    }
}
