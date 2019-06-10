package shens.android.shenstest.mvp;


import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import shens.android.lib_base.mvp.BaseModel;
import shens.android.lib_base.mvp.IView;
import shens.android.lib_http.HttpSubscribe;
import shens.android.lib_http.RequestHelper;
import shens.android.lib_http.bean.HttpResult;
import shens.android.lib_http.bean.TopImageBean;

/**
 * Created by shenshilei on 2019/4/22.
 * email ssl_java@163.com
 * site http://www.houziyou.com
 */
public class MainModel extends BaseModel {



    public void getTopImage(HashMap<String,String> map, LifecycleProvider provider, HttpSubscribe<List<TopImageBean>> observer) {
        getApiService().getTest(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RequestHelper.<HttpResult<List<TopImageBean>>>applySchedulers(provider))
                .subscribe(observer);
    }


    public interface View extends IView{
        void getSuccess(List<TopImageBean> data);
    }



}
