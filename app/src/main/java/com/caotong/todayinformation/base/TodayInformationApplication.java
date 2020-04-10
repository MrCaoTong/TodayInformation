package com.caotong.todayinformation.base;

import android.app.Application;

import com.caotong.todayinformation.base.crash.CrashProtectManager;

public class TodayInformationApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashProtectManager.getInstance(this).init();
    }
}
