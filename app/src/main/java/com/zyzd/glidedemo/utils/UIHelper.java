package com.zyzd.glidedemo.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.GridView;

import com.zyzd.glidedemo.ui.CustomImageSizeModelActivity;
import com.zyzd.glidedemo.ui.CustomTransformationsActivity;
import com.zyzd.glidedemo.ui.GifActivity;
import com.zyzd.glidedemo.ui.GridViewActivity;
import com.zyzd.glidedemo.ui.ListActivity;
import com.zyzd.glidedemo.ui.LoadMethodActivity;
import com.zyzd.glidedemo.ui.MainUI;
import com.zyzd.glidedemo.ui.TargetsActivity;

/**
 * Created by 李宗源 on 2016/9/7.
 */
public class UIHelper {
    public static void openLoadMethod(Context context) {
        Intent intent = new Intent(context, LoadMethodActivity.class);
        context.startActivity(intent);
    }

    public static void openList(Context context) {
        Intent intent = new Intent(context, ListActivity.class);
        context.startActivity(intent);
    }

    public static void openGridList(Context context) {
        Intent intent = new Intent(context, GridViewActivity.class);
        context.startActivity(intent);
    }

    public static void openGif(Context context) {
        Intent intent = new Intent(context, GifActivity.class);
        context.startActivity(intent);
    }

    public static void openTargets(Context context) {
        Intent intent = new Intent(context, TargetsActivity.class);
        context.startActivity(intent);
    }

    public static void openCustomImageSizeModel(Context context) {
        Intent intent = new Intent(context, CustomImageSizeModelActivity.class);
        context.startActivity(intent);
    }

    public static void openCustomTransformations(Context context) {
        Intent intent = new Intent(context, CustomTransformationsActivity.class);
        context.startActivity(intent);
    }
}
