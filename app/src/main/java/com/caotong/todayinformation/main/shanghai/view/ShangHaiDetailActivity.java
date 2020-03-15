package com.caotong.todayinformation.main.shanghai.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.caotong.todayinformation.R;
import com.caotong.todayinformation.base.BaseActivity;
import com.caotong.todayinformation.base.ViewInject;
import com.caotong.todayinformation.main.shanghai.manager.GetXiaoHuaTask;
import com.caotong.todayinformation.main.shanghai.module.ShangHaiDetailHttpTask;
import com.caotong.todayinformation.main.shanghai.module.ShangHaiDetailRequest;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@ViewInject(mainlayoutid = R.layout.activity_shanghai_detail)
public class ShangHaiDetailActivity extends BaseActivity {

    public static String mActivityOptionsCompat = "ShanghaiDetailActivity";
    @BindView(R.id.detail_shanghai_iv)
    ImageView detailShanghaiIv;

    @Override
    public void afterBindView() {
        initAnima();
        initGetNetData();
//        initPostNetData();
    }

    private void initPostNetData() {
        OkHttpClient client = new OkHttpClient(); // okhttp 配置一些默认
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("key", "0f08cd674792667feb5ce236ea028747");
        Request request = new Request.Builder()
                .url("http://apis.juhe.cn/lottery/types")
                .post(builder.build())
                .build(); //建造者设计模式
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("initGetNetData","onFailure" + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("initGetNetData","onResponse" + response.body().string());
            }
        });
    }

    private void initGetNetData() {
        GetXiaoHuaTask task = new GetXiaoHuaTask();
        task.execute("desc", "1", "1");
    }

    private void initAnima() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            ViewCompat.setTransitionName(ivShanghaiDetail,mActivityOptionsCompat);
            //开启转场动画
            startPostponedEnterTransition();
        }
    }

    /**
     * 用于 Android 5.0 系统的 界面转场动画  ：共享元素动画
     */
    public static void start_5_0(Activity activity, View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Intent intent = new Intent(activity, ShangHaiDetailActivity.class);
            Pair pair = new Pair(view, mActivityOptionsCompat);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pair);
            ActivityCompat.startActivity(activity, intent, optionsCompat.toBundle());
        }
    }
}
