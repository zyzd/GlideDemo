package com.zyzd.glidedemo.utils;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by 李宗源 on 2016/9/8.
 */
public class SimpleGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        // todo
        //如果你认为你的 app 需要 20% 大的缓存作为 Glide 的默认值
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();
        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);

        // set size & external vs. internal:磁盘缓存
        int cacheSize100MegaBytes = 104857600;//100M
        // In case you want to specify a cache sub folder (i.e. "glidecache")://指定缓存文件夹
        //builder.setDiskCache(
        //    new DiskLruCacheFactory( downloadDirectoryPath, "glidecache", cacheSize100MegaBytes )
        //);


        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888)//解码格式
                .setMemoryCache(new LruResourceCache(customMemoryCacheSize))//内存缓存
                .setBitmapPool(new LruBitmapPool(customBitmapPoolSize))
                .setDiskCache(new InternalCacheDiskCacheFactory(context, cacheSize100MegaBytes));//磁盘缓存
        //.setDiskCacheService(ExecutorService service)
        //.setResizeService(ExecutorService service)


    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        // todo
    }


}
