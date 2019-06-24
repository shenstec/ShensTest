package shens.android.lib_base.utils;

import android.view.Gravity;
import android.widget.Toast;

import shens.android.lib_base.SApp;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.lib_base.utils
 * @ClassName: ToastUtils
 * @Description: 土司显示信息提示工具
 * @Author: 申世雷
 * @CreateDate: 2019/6/12 10:30 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/6/12 10:30 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class ToastUtils {


    /**
     * 短时提醒
     * @param msg
     */
    public static void showShort(String msg){
        getToast(msg,Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时提醒
     * @param msg
     */
    public static void showLong(String msg){
        getToast(msg,Toast.LENGTH_LONG).show();
    }

    /**
     * 居中显示提示内容
     * @param msg
     */
    public static void showMiddleShort(String msg){
        Toast toast = getToast(msg,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    public static Toast getToast(String msg,int flag){
        Toast toast = Toast.makeText(SApp.getInstance(),msg,flag);
        return  toast;
    }


}
