package shens.android.lib_base.utils.image.luban;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import java.io.File;
import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName: Luban
 * @Description: 图片压缩
 * @Author: shenshilei
 * @CreateDate: 2019/6/29 9:52 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/6/29 9:52 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class Luban {
    public static final int FIRST_GEAR = 1;
    public static final int THIRD_GEAR = 3;
    public static final int CUSTOM_GEAR = 4;
    private static final String TAG = "Luban";
    private static String DEFAULT_DISK_CACHE_DIR = "luban_disk_cache";
    private File mFile;
    private List<File> mFileList;
    private LubanBuilder mBuilder;

    private Luban(File cacheDir) {
        this.mBuilder = new LubanBuilder(cacheDir);
    }

    public static Luban compress(Context context, File file) {
        Luban luban = new Luban(getPhotoCacheDir(context));
        luban.mFile = file;
        luban.mFileList = Collections.singletonList(file);
        return luban;
    }

    public static Luban compress(Context context, List<File> files) {
        Luban luban = new Luban(getPhotoCacheDir(context));
        luban.mFileList = files;
        luban.mFile = (File)files.get(0);
        return luban;
    }

    public Luban putGear(int gear) {
        this.mBuilder.gear = gear;
        return this;
    }

    public Luban setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.mBuilder.compressFormat = compressFormat;
        return this;
    }

    public Luban setMaxSize(int size) {
        this.mBuilder.maxSize = size;
        return this;
    }

    public Luban setMaxWidth(int width) {
        this.mBuilder.maxWidth = width;
        return this;
    }

    public Luban setMaxHeight(int height) {
        this.mBuilder.maxHeight = height;
        return this;
    }

    public void launch(final OnCompressListener listener) {
        this.asObservable().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<File>() {
            public void onSubscribe(Disposable d) {
                listener.onStart();
            }

            public void onNext(File file) {
                listener.onSuccess(file);
            }

            public void onError(Throwable e) {
                listener.onError(e);
            }

            public void onComplete() {
            }
        });
    }

    public void launch(final OnMultiCompressListener listener) {
        this.asListObservable().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<File>>() {
            public void onSubscribe(Disposable d) {
                listener.onStart();
            }

            public void onNext(List<File> files) {
                listener.onSuccess(files);
            }

            public void onError(Throwable e) {
                listener.onError(e);
            }

            public void onComplete() {
            }
        });
    }

    public Observable<File> asObservable() {
        LubanCompresser compresser = new LubanCompresser(this.mBuilder);
        return compresser.singleAction(this.mFile);
    }

    public Observable<List<File>> asListObservable() {
        LubanCompresser compresser = new LubanCompresser(this.mBuilder);
        return compresser.multiAction(this.mFileList);
    }

    private static File getPhotoCacheDir(Context context) {
        return getPhotoCacheDir(context, DEFAULT_DISK_CACHE_DIR);
    }

    private static File getPhotoCacheDir(Context context, String cacheName) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            if (Log.isLoggable("Luban", 6)) {
                Log.e("Luban", "default disk cache dir is null");
            }

            return null;
        } else {
            File result = new File(cacheDir, cacheName);
            return result.mkdirs() || result.exists() && result.isDirectory() ? result : null;
        }
    }

    public Luban clearCache() {
        if (this.mBuilder.cacheDir.exists()) {
            this.deleteFile(this.mBuilder.cacheDir);
        }

        return this;
    }

    private void deleteFile(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            File[] var2 = fileOrDirectory.listFiles();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                File file = var2[var4];
                this.deleteFile(file);
            }
        }

        fileOrDirectory.delete();
    }
}
