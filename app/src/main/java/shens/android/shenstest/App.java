package shens.android.shenstest;

import android.app.Application;
import android.util.Log;

import shens.android.shenstest.utils.DeviceUtils;

/**
 * Created by shenshilei on 2019/4/22.
 * email ssl_java@163.com
 * site http://www.houziyou.com
 */
public class App extends Application {

    private final String TAG = "Application";

    private static App _instance;

    public static synchronized App getInstance() {
        return _instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;
        Log.d(TAG, DeviceUtils.getCurProcessName(this));
    }
}
