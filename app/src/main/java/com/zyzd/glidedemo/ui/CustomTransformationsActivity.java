package com.zyzd.glidedemo.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zyzd.glidedemo.R;
import com.zyzd.glidedemo.transformation.RotateTransformation;

public class CustomTransformationsActivity extends Activity {

    private ImageView mImageViewHorizontal;
    private ImageView mImageViewVertical;
    public static final String imageUrl = "http://i.imgur.com/rFLNqWI.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_transformations);
        mImageViewHorizontal = (ImageView) findViewById(R.id.imageView_horizontal);
        mImageViewVertical = (ImageView) findViewById(R.id.imageView_vertical);
        loadImageOriginal();
        loadImageRotated();
    }

    private void loadImageOriginal() {
        Glide.with(this)
                .load(imageUrl)
                .into(mImageViewHorizontal);
    }

    private void loadImageRotated() {
        Glide.with(this)
                .load(imageUrl)
                .transform(new RotateTransformation(this, 90f))
                .into(mImageViewVertical);
    }
}
