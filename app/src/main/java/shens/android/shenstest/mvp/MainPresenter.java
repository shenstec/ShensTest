package shens.android.shenstest.mvp;

import java.util.HashMap;
import java.util.List;

import shens.android.lib_base.mvp.BasePresenter;
import shens.android.lib_http.HttpSubscribe;
import shens.android.lib_http.bean.TopImageBean;
import shens.android.shenstest.App;

/**
 * Created by shenshilei on 2019/4/22.
 * email ssl_java@163.com
 * site http://www.houziyou.com
 */
public class MainPresenter extends BasePresenter<MainModel.View> {

    private MainModel model ;
    @Override
    protected void createModel() {
        model = new MainModel();
    }

    public void getTopImage (){
        HashMap<String,String> map  = new HashMap<>();
        model.getTopImage(map,getLifecyleProvide(),new HttpSubscribe<List<TopImageBean>>(App.getInstance(),true){


            @Override
            public void onSuccess(List<TopImageBean> data) {
                getView().getSuccess(data);
            }

            @Override
            public void onCodeEror(int code, String msg) {
                super.onCodeEror(code, msg);
                getView().showError(msg);
            }
        });
    }



}
