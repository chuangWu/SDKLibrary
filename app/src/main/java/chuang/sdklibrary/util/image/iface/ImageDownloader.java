package chuang.sdklibrary.util.image.iface;


import java.io.OutputStream;

import chuang.sdklibrary.util.image.ImageTask;


public interface ImageDownloader {

    public boolean downloadToStream(ImageTask imageTask,
                                    String url,
                                    OutputStream outputStream,
                                    ProgressUpdateHandler progressUpdateHandler);
}