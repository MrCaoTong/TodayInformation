package com.caotong.todayinformation.splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.caotong.todayinformation.base.BaseActivity;
import com.caotong.todayinformation.main.MainActivity;
import com.caotong.todayinformation.R;
import com.caotong.todayinformation.base.ViewInject;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainlayoutid = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityContract.Iview {

    @BindView(R.id.video_splash)
    FullVideoView mVideoView;
    @BindView(R.id.text_splash)
    TextView mTextView;

    private ISplashActivityContract.IPresenter timerPresenter;

    @Override
    public void afterBindView() {
        initTimerPresenter();
        initListener();
        initVideo();
    }

    private void initTimerPresenter() {
        timerPresenter = new SplashTimerPresenter(this);
        timerPresenter.initTimer();
    }

    private void initVideo() {
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    @OnClick({R.id.video_splash, R.id.text_splash})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.video_splash:
                break;
            case R.id.text_splash:
                break;
        }
    }

    private void initListener() {
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }


    @Override
    public void setTvTimer(String s) {
        mTextView.setText(s);
    }
}
