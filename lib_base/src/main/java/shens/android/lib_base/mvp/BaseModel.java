package shens.android.lib_base.mvp;

import shens.android.lib_http.ApiService;
import shens.android.lib_http.RetrofitFactory;

/**
 * Created by shenshilei on 2019/4/22.
 * email ssl_java@163.com
 * site http://www.houziyou.com
 */
public class BaseModel {


    private ApiService apiService ;

    public BaseModel(){
        apiService = RetrofitFactory.getInstance().getApiService();
    }

    public ApiService getApiService() {
        return apiService;
    }
}
