package shens.android.lib_base.mvp;


import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * Created by shenshilei on 2019/4/22.
 * email ssl_java@163.com
 * site http://www.houziyou.com
 */
public abstract class BasePresenter<V extends IView,M extends BaseModel> implements IPresenter<V> {

    private V mView;

    protected M mModel;

    public BasePresenter(){
        createModel();
    }

    protected abstract M createModel();

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    public V getView(){
        return  mView;
    }

    protected boolean isViewAttached(){
        return mView !=null;
    }


    /**
     * 获取当前生命周期
     * @param <T>
     * @return
     */
    protected <T> LifecycleProvider<T> getLifecyleProvide(){
        LifecycleProvider<T> provider = null;

        if(mView!=null){
            if(mView instanceof LifecycleProvider){
                provider = (LifecycleProvider<T>) mView;
            }
        }
        return  provider;

    }

}
