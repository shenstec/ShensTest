package shens.android.lib_http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import shens.android.lib_http.config.HttpConfig;
import shens.android.lib_http.gson.GsonConverterFactory;
import shens.android.lib_http.gson.GsonIntegerDefaultAdapter;

/**
 * retrofit 工厂处理
 * created by shenshilei
 * email 18201639975@163.com
 * site http://www.houziyou.com
 */
public class RetrofitFactory {


    private ApiService apiService;

    /**
     * 创建内部类实现单例得唯一性
     */
    private static class SingleFactory{
        static  RetrofitFactory retrofitFactory = new RetrofitFactory();
    }

    /**
     * 获取单例对象
     * @return
     */
    public static RetrofitFactory getInstance(){
        return SingleFactory.retrofitFactory;
    }


    /**
     * 构造方法  通过代理模式进行对请求方法进行反射得到对象
     */
    public RetrofitFactory(){
        apiService = getRetrofit().create(ApiService.class);
    }

    private Retrofit getRetrofit(){
        return new Retrofit.Builder().baseUrl(ApiService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(buildGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
    }
    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(HttpConfig.TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(HttpConfig.TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(HttpConfig.TIME_OUT, TimeUnit.SECONDS)
                .build();
    }
    /**
     * 初始化gson对象
     * @return
     */
    public static Gson buildGson() {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .registerTypeAdapter(int.class, new GsonIntegerDefaultAdapter())
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();
        return gson;
    }



    /**
     * 获取service
     * @return
     */
    public ApiService getApiService() {
        return apiService;
    }
}
