package com.zyzd.glidedemo.view;

import android.content.Context;

import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;
import com.zyzd.glidedemo.CustomImageSizeModel;

/**
 * Created by 李宗源 on 2016/9/8.
 */
public class CustomImageSizeUrlLoader extends BaseGlideUrlLoader<CustomImageSizeModel> {
    public CustomImageSizeUrlLoader(Context context) {
        super( context );
    }

    @Override
    protected String getUrl(CustomImageSizeModel model, int width, int height) {
        return model.requestCustomSizeUrl( width, height );
    }
}
