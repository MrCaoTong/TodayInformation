package com.caotong.todayinformation.main.shanghai.manager;

import android.os.AsyncTask;
import android.util.Log;

import com.caotong.todayinformation.main.shanghai.module.ShangHaiDetailHttpTask;

import java.io.IOException;

import okhttp3.Response;

public class GetXiaoHuaTask extends AsyncTask<Object, Object, Object> {

    //运行在子线程中
    @Override
    protected Object doInBackground(Object... objects) {
        Object object = new ShangHaiDetailHttpTask().getXiaoHuaList((String) objects[0], (String) objects[1], (String) objects[2]);
        Response response = (Response) object;
        Object str = null;
        try {
            str = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    //运行在主线程 用于更新数据
    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Log.e("GetXiaoHuaTask", "onResponse" + o);
    }
}
