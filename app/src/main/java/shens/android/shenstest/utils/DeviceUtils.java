package shens.android.shenstest.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

public class DeviceUtils {

    public static final String TAG = "DeviceUtils";
    /**
     * 获取当前进程名字
     * @param context
     * @return
     */
    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager.getRunningAppProcesses()) {
            Log.d(TAG,appProcess.processName);
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }

        }
        return null;
    }
}
