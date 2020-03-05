package com.caotong.todayinformation;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@ViewInject(mainlayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @BindView(R.id.fab_main_center)
    FloatingActionButton fabMainCenter;
    @BindView(R.id.fl_main_center)
    FrameLayout flMainCenter;
    @BindView(R.id.rb_main_shanghai)
    RadioButton rbMainShanghai;
    @BindView(R.id.rb_main_hangzhou)
    RadioButton rbMainHangzhou;
    @BindView(R.id.rg_main_top)
    RadioGroup rgMainTop;
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
        changeAnimation(rgMainBottom,rgMainTop);
    }

    @OnClick(R.id.fab_main_center)
    public void onViewClicked(View view) {
        isChangeTopOrBottom = !isChangeTopOrBottom;
        if (isChangeTopOrBottom) {
            changeAnimation(rgMainTop,rgMainBottom);
        } else {
            changeAnimation(rgMainBottom,rgMainTop);
        }
    }

    private void changeAnimation(RadioGroup gone, RadioGroup show) {
        gone.clearAnimation();
        Animation animationGone = AnimationUtils.loadAnimation(this,R.anim.main_tab_tanslate_gone);
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);

        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this,R.anim.main_tab_translate_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }
}
