package com.zyzd.glidedemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zyzd.glidedemo.CustomImageSizeModel;
import com.zyzd.glidedemo.R;
import com.zyzd.glidedemo.utils.CustomImageSizeModelFutureStudio;
import com.zyzd.glidedemo.view.CustomImageSizeUrlLoader;

public class CustomImageSizeModelActivity extends AppCompatActivity {

    private ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_image_size_model);
        mImageView = (ImageView) findViewById(R.id.imageView);
    }

    public void startRequest(View view) {
//        String baseImageUrl = "https://futurestud.io/images/example.png";
        String baseImageUrl = "https://res.cloudinary.com/cncommdata/image/upload/";
        String name = "mrzy_ri0ib1.jpg";
        //https://res.cloudinary.com/cncommdata/image/upload/c_scale,w_720/mrzy_ri0ib1.jpg
        CustomImageSizeModel customImageRequest = new CustomImageSizeModelFutureStudio(baseImageUrl,name);

        Glide.with(this)
                .using(new CustomImageSizeUrlLoader(this))//动态使用 Model Loader,如果没有就得在清单文件中CustomImageSizeGlideModule
                .load(customImageRequest)
                .into(mImageView);
    }
}
