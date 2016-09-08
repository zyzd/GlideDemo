package com.zyzd.glidedemo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by 李宗源 on 2016/9/8.
 * 模糊加载
 */
public class BlurTransformation extends BitmapTransformation {
    private RenderScript rs;

    public BlurTransformation(Context context) {
        super( context );

        rs = RenderScript.create( context );
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap blurredBitmap = toTransform.copy( Bitmap.Config.ARGB_8888, true );

        // Allocate memory for Renderscript to work with
        Allocation input = Allocation.createFromBitmap(
                rs,
                blurredBitmap,
                Allocation.MipmapControl.MIPMAP_FULL,
                Allocation.USAGE_SHARED
        );
        Allocation output = Allocation.createTyped(rs, input.getType());

        // Load up an instance of the specific script that we want to use.
        ScriptIntrinsicBlur script = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            script.setInput(input);
        }

        // Set the blur radius
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            script.setRadius(10);
        }

        // Start the ScriptIntrinisicBlur
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            script.forEach(output);
        }

        // Copy the output to the blurred bitmap
        output.copyTo(blurredBitmap);

        toTransform.recycle();

        return blurredBitmap;
    }

    @Override
    public String getId() {
        return "blur";//Glide 使用该键作为缓存系统的一部分，为了避免意外的问题，你要确保它是唯一的
    }
}
