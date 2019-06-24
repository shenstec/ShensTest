package shens.android.shenstest;

import android.app.Application;
import android.util.Log;

import shens.android.lib_base.SApp;
import shens.android.shenstest.utils.DeviceUtils;

/**
 * Created by shenshilei on 2019/4/22.
 * email ssl_java@163.com
 * site http://www.houziyou.com
 */
public class App extends SApp {

    private final String TAG = "Application";


    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, DeviceUtils.getCurProcessName(this));


    }
}
