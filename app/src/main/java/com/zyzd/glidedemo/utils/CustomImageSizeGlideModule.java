package com.zyzd.glidedemo.utils;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.module.GlideModule;
import com.zyzd.glidedemo.CustomImageSizeModel;
import com.zyzd.glidedemo.CustomImageSizeModelFactory;

import java.io.InputStream;

/**
 * Created by 李宗源 on 2016/9/8.
 */
public class CustomImageSizeGlideModule implements GlideModule {
    @Override public void applyOptions(Context context, GlideBuilder builder) {
        // nothing to do here
    }

    @Override public void registerComponents(Context context, Glide glide) {
        glide.register(CustomImageSizeModel.class, InputStream.class, new CustomImageSizeModelFactory());
    }
}
