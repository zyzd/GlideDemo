package com.zyzd.glidedemo.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.NotificationTarget;
import com.zyzd.glidedemo.R;
import com.zyzd.glidedemo.provider.FSAppWidgetProvider;
import com.zyzd.glidedemo.utils.UIHelper;

public class MainUI extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnLoadMethod;
    private Button mBtnList;
    private Button mBtnGridview;
    private Button mBtnGif;
    private Button mBtnTargets;
    private Button mBtnNotificationTarget;
    private Button btnCustomImageSizeModel;
    private Button btnCustomTransformations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_ui);
        initView();
        initListener();
    }

    private void initView() {
        mBtnLoadMethod = (Button) findViewById(R.id.btn_load_method);
        mBtnList = (Button) findViewById(R.id.btn_list);
        mBtnGridview = (Button) findViewById(R.id.btn_gridview);
        mBtnGif = (Button) findViewById(R.id.btn_gif);
        mBtnTargets = (Button) findViewById(R.id.btn_targets);
        mBtnNotificationTarget = (Button) findViewById(R.id.btn_NotificationTarget);
        btnCustomImageSizeModel = (Button) findViewById(R.id.btn_CustomImageSizeModel);
        btnCustomTransformations = (Button) findViewById(R.id.btn_CustomTransformations);
    }

    private void initListener() {
        mBtnLoadMethod.setOnClickListener(this);
        mBtnList.setOnClickListener(this);
        mBtnGridview.setOnClickListener(this);
        mBtnGif.setOnClickListener(this);
        mBtnTargets.setOnClickListener(this);
        mBtnNotificationTarget.setOnClickListener(this);
        btnCustomImageSizeModel.setOnClickListener(this);
        btnCustomTransformations.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_load_method:
                UIHelper.openLoadMethod(this);
                break;
            case R.id.btn_list:
                UIHelper.openList(this);
                break;
            case R.id.btn_gridview:
                UIHelper.openGridList(this);
                break;
            case R.id.btn_gif:
                UIHelper.openGif(this);
                break;
            case R.id.btn_targets:
                UIHelper.openTargets(this);
                break;
            case R.id.btn_NotificationTarget:
                crateNotification();
                break;
            case R.id.btn_CustomImageSizeModel:
                UIHelper.openCustomImageSizeModel(this);
                break;
            case R.id.btn_CustomTransformations:
                UIHelper.openCustomTransformations(this);
                break;

        }
    }


    public static final String notificationIconUrl = "http://i.imgur.com/aC9OjaM.jpg";

    private void crateNotification() {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.layout_remoteview_notification);
        remoteViews.setImageViewResource(R.id.remoteview_notification_icon,R.mipmap.ic_launcher);
        remoteViews.setTextViewText(R.id.remoteview_notification_headline,"headline");
        remoteViews.setTextViewText(R.id.remoteview_notification_short_message,"short Message");

        NotificationCompat.Builder mBuilder
                = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Content Title")
                .setContentText("Content Text")
                .setContent(remoteViews)
                .setPriority(NotificationCompat.PRIORITY_MIN);

        Notification notification = mBuilder.build();
        if(Build.VERSION.SDK_INT>=16){
            notification.bigContentView = remoteViews;
        }

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1,notification);

        NotificationTarget notificationTarget = new NotificationTarget(this, remoteViews, R.id.remoteview_notification_icon, notification, 1);

        Glide.with(getApplicationContext())//safer!
            .load(notificationIconUrl)
                .asBitmap()
                .into(notificationTarget);
    }


}
