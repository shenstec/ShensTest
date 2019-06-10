package shens.android.lib_http;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import shens.android.lib_http.bean.HttpResult;
import shens.android.lib_http.bean.TopImageBean;

/**
 * created by shenshilei
 * email 18201639975@163.com
 * site http://www.houziyou.com
 */
public interface ApiService {

    String BASE_URL="https://www.houziyou.com/";

    String topImg = "/monkeyoo/API/Joke/getTopJokeImg";

    @GET(topImg)
    Observable<HttpResult<List<TopImageBean>>> getTest(@QueryMap HashMap<String, String> params);

}
