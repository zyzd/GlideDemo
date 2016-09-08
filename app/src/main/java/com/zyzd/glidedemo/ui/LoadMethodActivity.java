package com.zyzd.glidedemo.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.zyzd.glidedemo.R;

import java.io.File;

public class LoadMethodActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView targetImageView;
    private Button mBtnLoadImageFromUrl;
    private Button mBtnLoadImageFromRes;
    private Button mBtnLoadImageFromFile;
    private Button mBtnLoadImageFromUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        targetImageView = (ImageView) findViewById(R.id.imageView);
        mBtnLoadImageFromUrl = (Button) findViewById(R.id.btn_from_url);
        mBtnLoadImageFromRes = (Button) findViewById(R.id.btn_from_res);
        mBtnLoadImageFromFile = (Button) findViewById(R.id.btn_from_file);
        mBtnLoadImageFromUri = (Button) findViewById(R.id.btn_from_uri);

        mBtnLoadImageFromUrl.setOnClickListener(this);
        mBtnLoadImageFromRes.setOnClickListener(this);
        mBtnLoadImageFromFile.setOnClickListener(this);
        mBtnLoadImageFromUri.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_from_url:
                thumbnailRequest();
                break;
            case R.id.btn_from_res:
                int resourceId = R.mipmap.ic_launcher;
                Glide.with(this)
                        .load(resourceId)
                        .into(targetImageView);
                break;
            case R.id.btn_from_file:
                //这个文件可能不存在于你的设备中。然而你可以用任何文件路径，去指定一个图片路径。
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Running.jpg");
                Glide.with(this).load(file).into(targetImageView);
                break;
            case R.id.btn_from_uri:
                //这可能是任何 Uri。为了演示的目的我们只是用一个 launcher icon 去创建了一个 Uri
                Uri uri = resourceIdToUri(this, R.mipmap.ic_launcher);
                Glide.with(this).load(uri).into(targetImageView);
                break;
        }
    }

    private void thumbnailRequest() {
        String internetUrl = "http://i.imgur.com/DvpvklR.png";
        String thumbnailUrl = "http://i.imgur.com/rT5vXE1.jpg";
        DrawableRequestBuilder<String> thumbnailRequest = Glide.with(this).load(thumbnailUrl);
        Glide.with(this)
            .load(internetUrl)
            //.thumbnail(thumbnailRequest)//缩略图独立于原图
            .thumbnail(0.01f)//
            .into(targetImageView);
    }

    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    private static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }
}
