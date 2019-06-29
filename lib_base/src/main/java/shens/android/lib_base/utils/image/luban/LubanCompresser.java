package shens.android.lib_base.utils.image.luban;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.support.annotation.NonNull;
import android.support.v4.util.Preconditions;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName: LubanCompresser
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/6/29 10:33 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/6/29 10:33 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class LubanCompresser {
    private static final String TAG = "Luban Compress";
    private final LubanBuilder mLuban;
    private ByteArrayOutputStream mByteArrayOutputStream;

    LubanCompresser(LubanBuilder luban) {
        this.mLuban = luban;
    }

    Observable<File> singleAction(final File file) {
        return Observable.fromCallable(new Callable<File>() {
            public File call() throws Exception {

                return LubanCompresser.this.compressImage(LubanCompresser.this.mLuban.gear, file);
            }
        }).subscribeOn(Schedulers.computation());
    }

    public Observable<List<File>> multiAction(List<File> files) {
        List<Observable<File>> observables = new ArrayList(files.size());
        Iterator var3 = files.iterator();

        while(var3.hasNext()) {
            final File file = (File)var3.next();
            observables.add(Observable.fromCallable(new Callable<File>() {
                public File call() throws Exception {
                    return LubanCompresser.this.compressImage(LubanCompresser.this.mLuban.gear, file);
                }
            }));
        }

        return Observable.zip(observables, new Function<Object[], List<File>>() {
            public List<File> apply(Object[] objects) throws Exception {
                List<File> files = new ArrayList(objects.length);
                Object[] var3 = objects;
                int var4 = objects.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    Object o = var3[var5];
                    files.add((File)o);
                }

                return files;
            }
        });
    }

    private File compressImage(int gear, File file) throws IOException {
        switch(gear) {
            case 1:
                return this.firstCompress(file);
            case 2:
            default:
                return file;
            case 3:
                return this.thirdCompress(file);
            case 4:
                return this.customCompress(file);
        }
    }

    private File thirdCompress(@NonNull File file) throws IOException {
        String thumb = this.getCacheFilePath();
        String filePath = file.getAbsolutePath();
        int angle = this.getImageSpinAngle(filePath);
        int width = getImageSize(filePath)[0];
        int height = getImageSize(filePath)[1];
        boolean flip = width > height;
        int thumbW = width % 2 == 1 ? width + 1 : width;
        int thumbH = height % 2 == 1 ? height + 1 : height;
        width = thumbW > thumbH ? thumbH : thumbW;
        height = thumbW > thumbH ? thumbW : thumbH;
        double scale = (double)width / (double)height;
        double size;
        int multiple;
        if (scale <= 1.0D && scale > 0.5625D) {
            if (height < 1664) {
                if (file.length() / 1024L < 150L) {
                    return file;
                }

                size = (double)(width * height) / Math.pow(1664.0D, 2.0D) * 150.0D;
                size = size < 60.0D ? 60.0D : size;
            } else if (height >= 1664 && height < 4990) {
                thumbW = width / 2;
                thumbH = height / 2;
                size = (double)(thumbW * thumbH) / Math.pow(2495.0D, 2.0D) * 300.0D;
                size = size < 60.0D ? 60.0D : size;
            } else if (height >= 4990 && height < 10240) {
                thumbW = width / 4;
                thumbH = height / 4;
                size = (double)(thumbW * thumbH) / Math.pow(2560.0D, 2.0D) * 300.0D;
                size = size < 100.0D ? 100.0D : size;
            } else {
                multiple = height / 1280 == 0 ? 1 : height / 1280;
                thumbW = width / multiple;
                thumbH = height / multiple;
                size = (double)(thumbW * thumbH) / Math.pow(2560.0D, 2.0D) * 300.0D;
                size = size < 100.0D ? 100.0D : size;
            }
        } else if (scale <= 0.5625D && scale > 0.5D) {
            if (height < 1280 && file.length() / 1024L < 200L) {
                return file;
            }

            multiple = height / 1280 == 0 ? 1 : height / 1280;
            thumbW = width / multiple;
            thumbH = height / multiple;
            size = (double)(thumbW * thumbH) / 3686400.0D * 400.0D;
            size = size < 100.0D ? 100.0D : size;
        } else {
            multiple = (int)Math.ceil((double)height / (1280.0D / scale));
            thumbW = width / multiple;
            thumbH = height / multiple;
            size = (double)(thumbW * thumbH) / (1280.0D * (1280.0D / scale)) * 500.0D;
            size = size < 100.0D ? 100.0D : size;
        }

        return this.compress(filePath, thumb, flip ? thumbH : thumbW, flip ? thumbW : thumbH, angle, (long)size);
    }

    private File firstCompress(@NonNull File file) throws IOException {
        int minSize = 60;
        int longSide = 720;
        int shortSide = 1280;
        String thumbFilePath = this.getCacheFilePath();
        String filePath = file.getAbsolutePath();
        long size = 0L;
        long maxSize = file.length() / 5L;
        int angle = this.getImageSpinAngle(filePath);
        int[] imgSize = getImageSize(filePath);
        int width = 0;
        int height = 0;
        double scale;
        if (imgSize[0] <= imgSize[1]) {
            scale = (double)imgSize[0] / (double)imgSize[1];
            if (scale <= 1.0D && scale > 0.5625D) {
                width = imgSize[0] > shortSide ? shortSide : imgSize[0];
                height = width * imgSize[1] / imgSize[0];
                size = (long)minSize;
            } else if (scale <= 0.5625D) {
                height = imgSize[1] > longSide ? longSide : imgSize[1];
                width = height * imgSize[0] / imgSize[1];
                size = maxSize;
            }
        } else {
            scale = (double)imgSize[1] / (double)imgSize[0];
            if (scale <= 1.0D && scale > 0.5625D) {
                height = imgSize[1] > shortSide ? shortSide : imgSize[1];
                width = height * imgSize[0] / imgSize[1];
                size = (long)minSize;
            } else if (scale <= 0.5625D) {
                width = imgSize[0] > longSide ? longSide : imgSize[0];
                height = width * imgSize[1] / imgSize[0];
                size = maxSize;
            }
        }

        return this.compress(filePath, thumbFilePath, width, height, angle, size);
    }

    private File customCompress(@NonNull File file) throws IOException {
        String thumbFilePath = this.getCacheFilePath();
        String filePath = file.getAbsolutePath();
        int angle = this.getImageSpinAngle(filePath);
        long fileSize = this.mLuban.maxSize > 0 && (long)this.mLuban.maxSize < file.length() / 1024L ? (long)this.mLuban.maxSize : file.length() / 1024L;
        int[] size = getImageSize(filePath);
        int width = size[0];
        int height = size[1];
        float scale;
        if (this.mLuban.maxSize > 0 && (float)this.mLuban.maxSize < (float)file.length() / 1024.0F) {
            scale = (float)Math.sqrt((double)((float)file.length() / 1024.0F / (float)this.mLuban.maxSize));
            width = (int)((float)width / scale);
            height = (int)((float)height / scale);
        }

        if (this.mLuban.maxWidth > 0) {
            width = Math.min(width, this.mLuban.maxWidth);
        }

        if (this.mLuban.maxHeight > 0) {
            height = Math.min(height, this.mLuban.maxHeight);
        }

        scale = Math.min((float)width / (float)size[0], (float)height / (float)size[1]);
        width = (int)((float)size[0] * scale);
        height = (int)((float)size[1] * scale);
        return (float)this.mLuban.maxSize > (float)file.length() / 1024.0F && scale == 1.0F ? file : this.compress(filePath, thumbFilePath, width, height, angle, fileSize);
    }

    private String getCacheFilePath() {
        StringBuilder name = new StringBuilder("Luban_" + System.currentTimeMillis());
        if (this.mLuban.compressFormat == Bitmap.CompressFormat.WEBP) {
            name.append(".webp");
        } else {
            name.append(".jpg");
        }

        return this.mLuban.cacheDir.getAbsolutePath() + File.separator + name;
    }

    public static int[] getImageSize(String imagePath) {
        int[] res = new int[2];
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeFile(imagePath, options);
        res[0] = options.outWidth;
        res[1] = options.outHeight;
        return res;
    }

    private Bitmap compress(String imagePath, int width, int height) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imagePath, options);
        int outH = options.outHeight;
        int outW = options.outWidth;

        int inSampleSize;
        for(inSampleSize = 1; outH / inSampleSize > height || outW / inSampleSize > width; inSampleSize *= 2) {
            ;
        }

        options.inSampleSize = inSampleSize;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(imagePath, options);
    }

    private int getImageSpinAngle(String path) throws IOException {
        int degree = 0;
        ExifInterface exifInterface = new ExifInterface(path);
        int orientation = exifInterface.getAttributeInt("Orientation", 1);
        switch(orientation) {
            case 3:
                degree = 180;
                break;
            case 6:
                degree = 90;
                break;
            case 8:
                degree = 270;
        }

        return degree;
    }

    private File compress(String largeImagePath, String thumbFilePath, int width, int height, int angle, long size) throws IOException {
        Bitmap thbBitmap = this.compress(largeImagePath, width, height);
        thbBitmap = rotatingImage(angle, thbBitmap);
        return this.saveImage(thumbFilePath, thbBitmap, size);
    }

    private static Bitmap rotatingImage(int angle, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float)angle);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private File saveImage(String filePath, Bitmap bitmap, long size) throws IOException {
        Preconditions.checkNotNull(bitmap, "Luban Compressbitmap cannot be null");
        File result = new File(filePath.substring(0, filePath.lastIndexOf("/")));
        if (!result.exists() && !result.mkdirs()) {
            return null;
        } else {
            if (this.mByteArrayOutputStream == null) {
                this.mByteArrayOutputStream = new ByteArrayOutputStream(bitmap.getWidth() * bitmap.getHeight());
            } else {
                this.mByteArrayOutputStream.reset();
            }

            int options = 100;
            bitmap.compress(this.mLuban.compressFormat, options, this.mByteArrayOutputStream);

            while((long)(this.mByteArrayOutputStream.size() / 1024) > size && options > 6) {
                this.mByteArrayOutputStream.reset();
                options -= 6;
                bitmap.compress(this.mLuban.compressFormat, options, this.mByteArrayOutputStream);
            }

            bitmap.recycle();
            FileOutputStream fos = new FileOutputStream(filePath);
            this.mByteArrayOutputStream.writeTo(fos);
            fos.close();
            return new File(filePath);
        }
    }
}
