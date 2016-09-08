package com.zyzd.glidedemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zyzd.glidedemo.R;

public class GifActivity extends AppCompatActivity {
    private String gifUrl = "http://i.kinja-img.com/gawker-media/image/upload/s--B7tUiM5l--/gf2r69yorbdesguga10i.gif";

    private ImageView mGifIamgeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        mGifIamgeView = (ImageView) findViewById(R.id.gifImageView);
        Glide.with(this)
                .load(gifUrl)
                //.asBitmap()//加载为Bitmap
                .asGif()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//缓存策略：仅缓存原来全分辨率图像//能提高gif加载速度
                //.diskCacheStrategy(DiskCacheStrategy.NONE)//缓存策略：禁用磁盘缓存//能提高gif加载速度
                //.diskCacheStrategy(DiskCacheStrategy.RESULT)//缓存策略：仅缓存最终的图像//降低分辨率或转化后的
                //.diskCacheStrategy(DiskCacheStrategy.ALL)//缓存策略：缓存所有版本的图像（more行为）
                //.skipMemoryCache(true)//禁用内存缓存
                .priority(Priority.HIGH)//Priority.LOW、Priority.NORMAL、Priority.HIGH、Priority.IMMEDIATE（立即）
                .into(mGifIamgeView);
    }
}
