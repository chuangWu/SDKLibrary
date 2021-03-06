package chuang.sdklibrary.util.image.impl;


import chuang.sdklibrary.util.image.ImageTask;
import chuang.sdklibrary.util.image.iface.ImageResizer;

/**
 * A default implementation of {@link }
 *
 * @author http://www.liaohuqiu.net
 */
public class DefaultImageResizer implements ImageResizer {

    private static DefaultImageResizer sInstance;

    public static DefaultImageResizer getInstance() {
        if (sInstance == null) {
            sInstance = new DefaultImageResizer();
        }
        return sInstance;
    }

    @Override
    public int getInSampleSize(ImageTask imageTask) {
        int size = calculateInSampleSize(imageTask.getBitmapOriginSize().x, imageTask.getBitmapOriginSize().y, imageTask.getRequestSize().x, imageTask.getRequestSize().y);
        return size;
    }

    @Override
    public String getRemoteUrl(ImageTask imageTask) {
        return imageTask.getRemoteUrl();
    }

    /**
     * Calculate an inSampleSize for use in a {@link android.graphics.BitmapFactory.Options} object when decoding bitmaps using the decode* methods from {@link android.graphics.BitmapFactory}.
     * <p/>
     * This implementation calculates the closest inSampleSize that is a times of 2 and will result in the final decoded bitmap having a width and height equal to or larger than the requested width and height.
     */
    public static int calculateInSampleSize(int originWidth, int originHeight, int reqWidth, int reqHeight) {

        int inSampleSize = 1;

        if (reqHeight <= 0 || reqHeight <= 0 || reqHeight == Integer.MAX_VALUE || reqWidth == Integer.MAX_VALUE) {
            return inSampleSize;
        }

        if (originWidth > reqHeight || originHeight > reqWidth) {

            final int halfHeight = originWidth / 2;
            final int halfWidth = originHeight / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}