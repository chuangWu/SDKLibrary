package chuang.sdklibrary.util.image.iface;


import chuang.sdklibrary.util.image.CubeImageView;
import chuang.sdklibrary.util.image.ImageTask;

/**
 * Define load progress
 */
public interface ImageLoadProgressHandler {

    void onProgressChange(ImageTask imageTask, CubeImageView cubeImageView, int loaded, int total);
}
