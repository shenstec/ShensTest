package shens.android.shenstest.mvp;


import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import shens.android.lib_base.http.HttpSubscribe;
import shens.android.lib_base.http.RequestHelper;
import shens.android.lib_base.http.bean.HttpResult;
import shens.android.lib_base.mvp.BaseModel;
import shens.android.lib_base.mvp.IView;
import shens.android.shenstest.bean.TopImageBean;
import shens.android.shenstest.url.ApiService;

/**
 * Created by shenshilei on 2019/4/22.
 * email ssl_java@163.com
 * site http://www.houziyou.com
 */
public class MainModel extends BaseModel<ApiService> {


    public MainModel() {
        super(ApiService.BASE_URL);
    }

    public void getTopImage(HashMap<String,String> map, LifecycleProvider provider, HttpSubscribe<List<TopImageBean>> observer) {
        getApiService().getTest(map)
                .compose(RequestHelper.applySchedulers(provider))
                .subscribe(observer);
    }


    public interface View extends IView{
        void getSuccess(List<TopImageBean> data);
    }



}
