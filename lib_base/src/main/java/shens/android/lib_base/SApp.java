package shens.android.lib_base;

import android.app.Application;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.lib_base
 * @ClassName: SApp
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/6/12 10:32 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/6/12 10:32 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class SApp extends Application {
    private static SApp _instance;

    public static synchronized SApp getInstance() {
        return _instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;
    }
}
