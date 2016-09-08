package com.zyzd.glidedemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by 李宗源 on 2016/9/7.
 */
public class MyApp extends Application {
    public static Context getContext(){
        return getContext().getApplicationContext();
    }
}
