package com.zyzd.glidedemo.utils;

import android.util.Log;

import com.zyzd.glidedemo.CustomImageSizeModel;

/**
 * Created by 李宗源 on 2016/9/8.
 */
public class CustomImageSizeModelFutureStudio implements CustomImageSizeModel {
    private final String name;
    String baseImageUrl;

    public CustomImageSizeModelFutureStudio(String baseImageUrl,String name) {
        this.baseImageUrl = baseImageUrl;
        this.name = name;
    }

    /**
     * width和height是Glide根据具体情况返回的，无需自己去提供
     * @param width
     * @param height
     * @return
     */
    @Override
    public String requestCustomSizeUrl(int width, int height) {
        // previous way: we directly accessed the images
        // https://futurestud.io/images/logo.png

        // new way, server could handle additional parameter and provide the image in a specific size
        // in this case, the server would serve the image in 400x300 pixel size
        // https://futurestud.io/images/logo.png?w=400&h=300
//        return baseImageUrl + "?w=" + width + "&h=" + height;
        //https://res.cloudinary.com/cncommdata/image/upload/c_scale,w_720/mrzy_ri0ib1.jpg
        Log.d("zyzd", "requestCustomSizeUrl: "+baseImageUrl + "w_" + width+"/"+name);
        return baseImageUrl + "w_" + width+"/"+name;
    }
}
