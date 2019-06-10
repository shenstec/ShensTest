package shens.android.lib_base.mvp;

/**
 * Created by shenshilei on 2019/4/22.
 * email ssl_java@163.com
 * site http://www.houziyou.com
 */
public interface IPresenter<V extends IView> {
    /**
     * 绑定
     * @param view
     */
    void attachView(V view);

    /**
     * 解绑
     */
    void detachView();

}
