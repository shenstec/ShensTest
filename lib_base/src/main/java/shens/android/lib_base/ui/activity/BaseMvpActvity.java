package shens.android.lib_base.ui.activity;

import android.os.Bundle;

import shens.android.lib_base.mvp.BasePresenter;
import shens.android.lib_base.mvp.IView;

/**
 * Created by shenshilei on 2019/4/22.
 * email ssl_java@163.com
 * site http://www.houziyou.com
 */
public abstract class BaseMvpActvity<T extends BasePresenter> extends BaseActivity implements IView {

    protected T mPresenter;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        mPresenter = createPresenter();
        if(mPresenter!=null){
            mPresenter.attachView(this);
        }
        super.onCreate(savedInstanceState);
    }

    protected abstract T createPresenter();

    @Override
    protected void onDestroy() {
        if(mPresenter!=null){
            mPresenter.detachView();
        }
        super.onDestroy();

    }
}