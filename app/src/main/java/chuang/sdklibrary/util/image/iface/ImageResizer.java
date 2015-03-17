package chuang.sdklibrary.util.image.iface;


import chuang.sdklibrary.util.image.ImageTask;

/**
 * A ImageResizer process the resize logical when loading image from network an disk.
 */
public interface ImageResizer {

    /**
     * Return the {@link android.graphics.BitmapFactory.Options#inSampleSize}, which will be used when load the image from the disk.
     * <p/>
     * You should better calculate this value according the hard device of the mobile.
     */
    public int getInSampleSize(ImageTask imageTask);

    public String getRemoteUrl(ImageTask imageTask);
}