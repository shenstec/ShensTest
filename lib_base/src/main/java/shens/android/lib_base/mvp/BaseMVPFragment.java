package shens.android.lib_base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import shens.android.lib_base.mvp.BasePresenter;
import shens.android.lib_base.mvp.IView;
import shens.android.lib_base.ui.fragment.BaseFragment;

public abstract class BaseMVPFragment <T extends BasePresenter> extends BaseFragment implements IView {

    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        mPresenter = cratePresenter();
        if(mPresenter!=null){
            mPresenter.attachView(this);
        }
        super.onCreate(savedInstanceState);

    }

    protected abstract T cratePresenter();

    @Override
    public void onDestroy() {
        if(mPresenter!=null){
            mPresenter.detachView();
        }
        super.onDestroy();
    }
}
