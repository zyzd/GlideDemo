package com.zyzd.glidedemo;

import android.content.Context;

import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.zyzd.glidedemo.view.CustomImageSizeUrlLoader;

import java.io.InputStream;

/**
 * Created by 李宗源 on 2016/9/8.
 */
public class CustomImageSizeModelFactory implements ModelLoaderFactory<CustomImageSizeModel, InputStream> {
    @Override
    public ModelLoader<CustomImageSizeModel, InputStream> build(Context context, GenericLoaderFactory factories) {
        return new CustomImageSizeUrlLoader( context );
    }

    @Override
    public void teardown() {

    }
}
