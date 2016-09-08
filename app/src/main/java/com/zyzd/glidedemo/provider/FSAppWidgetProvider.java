package com.zyzd.glidedemo.provider;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.AppWidgetTarget;
import com.zyzd.glidedemo.R;

/**
 * Created by 李宗源 on 2016/9/7.
 */
public class FSAppWidgetProvider extends AppWidgetProvider {
    public static final String appWidgetUrl = "http://i.imgur.com/S963yEM.jpg";
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.layout_custom_view_future);
        AppWidgetTarget appWidgetTarget = new AppWidgetTarget(context, remoteViews, R.id.custom_view_image, appWidgetIds);

        Glide.with(context.getApplicationContext())//safer!
            .load(appWidgetUrl)
            .asBitmap()
            .into(appWidgetTarget);
        pushWidgetUpdate(context,remoteViews);

    }

    public static void pushWidgetUpdate(Context context, RemoteViews rv) {
        ComponentName myWidget = new ComponentName(context, FSAppWidgetProvider.class);
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        manager.updateAppWidget(myWidget, rv);
    }
}
