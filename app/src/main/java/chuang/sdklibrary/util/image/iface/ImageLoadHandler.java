package chuang.sdklibrary.util.image.iface;

import android.graphics.drawable.BitmapDrawable;

import chuang.sdklibrary.util.image.CubeImageView;
import chuang.sdklibrary.util.image.ImageTask;


public interface ImageLoadHandler {

    /**
     * When begin to load the image from disk or network.
     */
    void onLoading(ImageTask imageTask, CubeImageView cubeImageView);

    /**
     * After image is loaded.
     */
    void onLoadFinish(ImageTask imageTask, CubeImageView cubeImageView, BitmapDrawable drawable);

    /**
     * Some errors has occurred
     */
    void onLoadError(ImageTask imageTask, CubeImageView imageView, int errorCode);
}