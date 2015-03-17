package chuang.sdklibrary;

import android.app.Application;
import android.os.Environment;

import java.io.File;

import chuang.sdklibrary.util.CLog;
import chuang.sdklibrary.util.CubeDebug;
import chuang.sdklibrary.util.Env;
import chuang.sdklibrary.util.cache.CacheManagerFactory;
import chuang.sdklibrary.util.diskcache.lru.SimpleDiskLruCache;
import chuang.sdklibrary.util.image.ImageLoaderFactory;
import chuang.sdklibrary.util.image.impl.DefaultImageLoadHandler;


public class CubeDemoApplication extends Application {

    public static CubeDemoApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        String environment = "dev";
        Env.setEnvTag(environment);

        // init log level
        if (Env.isProd()) {
            CLog.setLogLevel(CLog.LEVEL_ERROR);
        } else if (Env.isPre()) {
            CLog.setLogLevel(CLog.LEVEL_WARNING);
        } else {
            CLog.setLogLevel(CLog.LEVEL_VERBOSE);
        }

        // debug options
        SimpleDiskLruCache.DEBUG = true;
        CubeDebug.DEBUG_LIFE_CYCLE = true;
        CubeDebug.DEBUG_CACHE = true;
        CubeDebug.DEBUG_IMAGE = true;
        CubeDebug.DEBUG_REQUEST = true;

        Cube.onCreate(this);

            initImageLoader();
             initRequestCache();
        CacheManagerFactory.initDefaultCache(this, null, -1, -1);
    }

    private void initImageLoader() {

        File path1 = Environment.getExternalStoragePublicDirectory("cube/test1/a/b/c");
        ImageLoaderFactory.customizeCache(
                this,
                // memory size
                1024 * 10,
                // disk cache directory
                path1.getAbsolutePath(),
                // disk cache size
                ImageLoaderFactory.DEFAULT_FILE_CACHE_SIZE_IN_KB
        );

        DefaultImageLoadHandler handler = new DefaultImageLoadHandler(this);
        handler.setLoadingImageColor("#999999");

        ImageLoaderFactory.setDefaultImageLoadHandler(handler);
      //  ImageLoaderFactory.setDefaultImageResizer(DemoDuiTangImageResizer.getInstance());
    }

    private void initRequestCache() {
        String dir = "request-cache";
     //   RequestCacheManager.init(this, dir, 1024 * 10, 1024 * 10);
    }

}