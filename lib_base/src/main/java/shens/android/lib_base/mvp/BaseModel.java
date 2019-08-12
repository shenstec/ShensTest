package shens.android.lib_base.mvp;

import java.lang.reflect.ParameterizedType;

import shens.android.lib_base.http.RetrofitFactory;

/**
 * Created by shenshilei on 2019/4/22.
 * email ssl_java@163.com
 * site http://www.houziyou.com
 */
public class BaseModel<T> {


    private T apiService ;



    public BaseModel(String baseUrl){
        apiService = (T) RetrofitFactory.getInstance((Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0],baseUrl).getApiService();
    }

    public T getApiService() {
        return apiService;
    }
}
