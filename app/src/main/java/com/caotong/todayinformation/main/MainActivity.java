package com.caotong.todayinformation.main;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.caotong.todayinformation.R;
import com.caotong.todayinformation.base.BaseActivity;
import com.caotong.todayinformation.base.ViewInject;
import com.caotong.todayinformation.main.tools.MainConstantTool;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainlayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.Iview {

    IMainActivityContract.IPresenter presenter = new MainActivityPresenter(this);

    @BindView(R.id.fab_main_center)
    FloatingActionButton fabMainCenter;
    @BindView(R.id.fl_main_center)
    FrameLayout flMainCenter;
    @BindView(R.id.rb_main_shanghai)
    LottieAnimationView rbMainShanghai;
    @BindView(R.id.rb_main_hangzhou)
    LottieAnimationView rbMainHangzhou;
    @BindView(R.id.rg_main_top)
    LinearLayout rgMainTop;
    @BindView(R.id.rb_main_beijing)
    RadioButton rbMainBeijing;
    @BindView(R.id.rb_main_shenzhen)
    RadioButton rbMainShenzhen;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;
    @BindView(R.id.fl_main_bottom)
    FrameLayout flMainBottom;

    private boolean isChangeTopOrBottom;

    @Override
    public void afterBindView() {
        initHomeFragment();
        changeAnimation(rgMainBottom, rgMainTop);
        initCheckListener();
    }

    private void initCheckListener() {
        rbMainShanghai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbMainShanghai.getId() == presenter.getCurrentCheckId()) {
                    return;
                }
                presenter.replaceFragment(MainConstantTool.SHANGHAI);
                rbMainShanghai.playAnimation();
                rbMainHangzhou.pauseAnimation();
            }
        });
        rbMainHangzhou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbMainHangzhou.getId() == presenter.getCurrentCheckId()) {
                    return;
                }
                presenter.replaceFragment(MainConstantTool.HANGZHOU);
                rbMainHangzhou.playAnimation();
                rbMainShanghai.pauseAnimation();
            }
        });
        rbMainBeijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbMainBeijing.getId() == presenter.getCurrentCheckId()) {
                    return;
                }
                presenter.replaceFragment(MainConstantTool.BEIJING);
                rbMainBeijing.setChecked(true);
            }
        });
        rbMainShenzhen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbMainShenzhen.getId() == presenter.getCurrentCheckId()) {
                    return;
                }
                presenter.replaceFragment(MainConstantTool.SHENZHEN);
                rbMainShenzhen.setChecked(true);
            }
        });
    }

    private void initHomeFragment() {
        presenter.initHomeFragment();
    }

    @OnClick(R.id.fab_main_center)
    public void onViewClicked(View view) {
        isChangeTopOrBottom = !isChangeTopOrBottom;
        if (isChangeTopOrBottom) {
            changeAnimation(rgMainTop, rgMainBottom);
            handleTopPosition();
        } else {
            changeAnimation(rgMainBottom, rgMainTop);
            handleBottomPosition();
        }
    }

    //上海 杭州
    private void handleBottomPosition() {
        if (presenter.getTopPosition() != 1) {
            presenter.replaceFragment(MainConstantTool.SHANGHAI);
            rbMainShanghai.playAnimation();
        } else {
            presenter.replaceFragment(MainConstantTool.HANGZHOU);
            rbMainHangzhou.playAnimation();
        }
    }

    //北京 深圳
    private void handleTopPosition() {
        if (presenter.getBottomPosition() != 3) {
            presenter.replaceFragment(MainConstantTool.BEIJING);
            rbMainBeijing.setChecked(true);
        } else {
            presenter.replaceFragment(MainConstantTool.SHENZHEN);
            rbMainShenzhen.setChecked(true);
        }
    }

    private void changeAnimation(ViewGroup gone, ViewGroup show) {
        gone.clearAnimation();
        Animation animationGone = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_gone);
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);

        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }

    @Override
    public void showFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().show(mFragment).commit();
    }

    @Override
    public void addFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_center, mFragment).commit();
    }

    @Override
    public void hideFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().hide(mFragment).commit();
    }
}
