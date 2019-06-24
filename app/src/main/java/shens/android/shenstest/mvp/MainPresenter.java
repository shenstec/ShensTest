package shens.android.shenstest.mvp;

import java.util.HashMap;
import java.util.List;

import shens.android.lib_base.http.HttpSubscribe;
import shens.android.lib_base.mvp.BasePresenter;
import shens.android.shenstest.bean.TopImageBean;
import shens.android.shenstest.App;

/**
 * Created by shenshilei on 2019/4/22.
 * email ssl_java@163.com
 * site http://www.houziyou.com
 */
public class MainPresenter extends BasePresenter<MainModel.View,MainModel> {


    public void getTopImage (){
        HashMap<String,String> map  = new HashMap<>();
        mModel.getTopImage(map,getLifecyleProvide(),new HttpSubscribe<List<TopImageBean>>(App.getInstance(),true){


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


    @Override
    protected MainModel createModel() {
        return new MainModel();
    }
}
