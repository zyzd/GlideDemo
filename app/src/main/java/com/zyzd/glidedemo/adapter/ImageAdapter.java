package com.zyzd.glidedemo.adapter;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.bumptech.glide.request.target.Target;
import com.zyzd.glidedemo.R;
import com.zyzd.glidedemo.utils.BlurTransformation;
import com.zyzd.glidedemo.utils.Device;


/**
 * Created by 李宗源 on 2016/9/7.
 */
public class ImageAdapter extends BaseAdapter {

    private final Context mContext;
    private final String[] mDatas;
    private final int mType;

    public ImageAdapter(Context context, String[] datas,int type){
        mContext = context;
        mDatas = datas;
        mType = type;
    }

    @Override
    public int getCount() {
        return mDatas.length;
    }

    @Override
    public String getItem(int i) {
        return mDatas[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_image,viewGroup,false);
        }

        ViewHolder holder = ViewHolder.getViewHolder(view);
        if(mType==0){
            Glide.with(mContext)
                    .load(mDatas[position])
                    //.placeholder(R.mipmap.ic_launcher)//占位图
                    .error(R.mipmap.ic_launcher)//错误填充
                    .listener(requestListener)
                    .crossFade()//使图片加载改变是更加平滑和养眼，淡入淡出动画——重载方法 .crossFade(int duration)
                    //.dontAnimate()//直接显示图片而没有任何淡入淡出效果
                    //.override(50,50)
                    .centerCrop()
                    .animate(R.anim.slide_in_left)//从左进入
                    //.animate(R.anim.aniyou'xiaom_scale)//由小放大，0.1-1.0
                    .animate(animationObject)//代码中的自定义动画、透明度动画
                    //.fitCenter()
                    .into(holder.imageView);//备注：当跟布局为ImageView时不可以设置tag，在RecyclerView中没有这问题
        }else if(mType==1){
            Glide.with(mContext)
                    .load(mDatas[position])
                    .thumbnail(0.1f)//缩略图
                    .placeholder(R.mipmap.ic_launcher)
                    .crossFade()
                    .centerCrop()//当时bitmapTransform时，会失效
                    //.bitmapTransform(new jp.wasabeef.glide.transformations.BlurTransformation(mContext,25,2))//使用三方的依赖模糊加载
                    //.bitmapTransform(new BlurTransformation(mContext))//模糊加载
                    .into(holder.imageView);
            /**
             * 提示：当你用了转换后你就不能使用 .centerCrop() 或 .fitCenter() 了。
             *
             * transform:可以使用任何转换，无论它是否是用于图像还是 Gif
             * bitmapTransform:只能用于 bitmap 的转换
             * --单个转换
             * .bitmapTransform(new BlurTransformation(mContext))
             * .transform(new BlurTransformation(mContext))
             * --多种转换
             * .transform(new GreyscaleTransformation( context ), new BlurTransformation(context))
             */
        }
       return view;
    }

    static class ViewHolder{
        public ImageView imageView;

        private ViewHolder(View view){
            imageView = (ImageView) view.findViewById(R.id.imageView);
        }

        public static ViewHolder getViewHolder(View view){
            ViewHolder holder = (ViewHolder) view.getTag();
            if(holder==null){
                holder = new ViewHolder(view);
                view.setTag(holder);
            }
            return holder;
        }
    }

    private RequestListener<String, GlideDrawable> requestListener = new RequestListener<String, GlideDrawable>() {
        @Override
        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
            // todo log exception
            Log.d("zyzd", "ImageAdapter>>onException--> "+"加载失败时调用：可以捕获错误、显示一个错误的占位符");
            // important to return false so the error placeholder can be placed
            return false;//返回false会执行error图加载，true不加载错误图
        }

        @Override
        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
            Log.d("zyzd", "onResourceReady: ");
            return false;
        }
    };

    ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
        @Override
        public void animate(View view) {
            // if it's a custom view class, cast it here
            // then find subviews and do the animations
            // here, we just use the entire view for the fade animation
            view.setAlpha( 0f );

            ObjectAnimator fadeAnim = ObjectAnimator.ofFloat( view, "alpha", 0f, 1f );
            fadeAnim.setDuration( 2500 );
            fadeAnim.start();
        }
    };
}
