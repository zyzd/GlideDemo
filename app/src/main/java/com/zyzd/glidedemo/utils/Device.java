package com.zyzd.glidedemo.utils;

import android.app.Activity;

import com.zyzd.glidedemo.MyApp;

/**
 * Created by 李宗源 on 2016/9/7.
 */
public class Device {
    public static int getWidth(Activity activity){
        return activity.getWindowManager().getDefaultDisplay().getWidth();
    }
}
