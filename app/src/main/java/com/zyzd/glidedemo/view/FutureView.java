package com.zyzd.glidedemo.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyzd.glidedemo.R;

/**
 * Created by 李宗源 on 2016/9/7.
 */
public class FutureView extends FrameLayout {

    ImageView iv;
    TextView tv;

    public void initialize(Context context) {
        inflate( context, R.layout.layout_future, this );

        iv = (ImageView) findViewById( R.id.custom_view_image );
        tv = (TextView) findViewById( R.id.custom_view_text );
    }

    public FutureView(Context context, AttributeSet attrs) {
        super( context, attrs );
        initialize( context );
    }

    public FutureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super( context, attrs, defStyleAttr );
        initialize( context );
    }

    public void setImage(Drawable drawable) {
        iv = (ImageView) findViewById( R.id.custom_view_image );

        iv.setImageDrawable( drawable );
    }
}
