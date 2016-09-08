package com.zyzd.glidedemo.ui;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.ViewTarget;
import com.zyzd.glidedemo.R;
import com.zyzd.glidedemo.view.FutureView;

public class TargetsActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mTargetsImageView;
    private FutureView mFutureView;
    String internetUrl = "http://i.imgur.com/DvpvklR.png";
    String targetUrl ="http://i.imgur.com/fUX7EIB.jpg";
    private Button mBtnSimpleTarget;
    private Button mBtnViewTarget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_targets);
        mTargetsImageView = (ImageView) findViewById(R.id.image_simpetarget);
        mFutureView = (FutureView) findViewById(R.id.futureView);

        mBtnSimpleTarget = (Button) findViewById(R.id.btn_simple_target);
        mBtnViewTarget = (Button) findViewById(R.id.btn_view_target);

        mBtnSimpleTarget.setOnClickListener(this);
        mBtnViewTarget.setOnClickListener(this);
    }

    private SimpleTarget target = new SimpleTarget<Bitmap>() {
        @Override
        public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
            // do something with the bitmap
            // for demonstration purposes, let's just set it to an ImageView
            mTargetsImageView.setImageBitmap( bitmap );
            //这样可以得到bigmap，对其进行任意操作
        }
    };


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_simple_target:
                loadImageSimpleTarget();
                break;
            case R.id.btn_view_target:
                loadImageViewTarget();
                break;
        }
    }

    private void loadImageSimpleTarget() {
        Glide.with( this ) // could be an issue!
                .load(internetUrl)
                .asBitmap()
                .into( target );
    }

    //不可以放在成员变量的位置，因为onCreate还没执行，mFutureView为null
//    ViewTarget<FutureView,GlideDrawable> viewTarget = new ViewTarget<FutureView, GlideDrawable>(mFutureView) {
//        @Override
//        public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
//            view.setImage(resource.getCurrent());
//        }
//    };
    /**
     * ViewTarget用于自定义视图加载图片
     */
    public void loadImageViewTarget(){
        //不可以放在成员变量的位置，因为onCreate还没执行，mFutureView为null
        ViewTarget<FutureView,GlideDrawable> viewTarget = new ViewTarget<FutureView, GlideDrawable>(mFutureView) {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                view.setImage(resource.getCurrent());
            }
        };
        Glide.with(this)
                .load(targetUrl)
                .into(viewTarget);
    }
}
