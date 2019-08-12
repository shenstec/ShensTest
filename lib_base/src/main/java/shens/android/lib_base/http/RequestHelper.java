package shens.android.lib_base.http;


import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.RxFragment;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * created by shenshilei
 * email 18201639975@163.com
 * site http://www.houziyou.com
 */
public class RequestHelper {

    /**
     * @param provider lifecycle provider
     */
    public static <T> ObservableTransformer<T, T> applySchedulers(final LifecycleProvider provider) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(RequestHelper.<T>bindToLifecycle(provider));
            }
        };
    }

    /**
     * bind lifecycle
     *
     * @param provider lifecycle provider
     * @return LifecycleTransformer
     */
    private static <T> LifecycleTransformer<T> bindToLifecycle(LifecycleProvider provider) {
        if (provider instanceof RxAppCompatActivity) {
            return provider.bindUntilEvent(ActivityEvent.DESTROY);
        } else if (provider instanceof RxFragment) {
            return ((RxFragment) provider).bindUntilEvent(FragmentEvent.DESTROY);
        } else {
            throw new IllegalArgumentException("class must extents RxAppCompatActivity or RxFragment");
        }
    }
}
