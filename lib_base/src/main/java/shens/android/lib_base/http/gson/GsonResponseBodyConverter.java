package shens.android.lib_base.http.gson;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * created by shenshilei
 * email 18201639975@163.com
 * site http://www.houziyou.com
 */
public class GsonResponseBodyConverter<T> implements Converter<ResponseBody,T> {

    private Gson gson;
    private Type type;
    public GsonResponseBodyConverter(Gson gson, Type type){
        this.gson = gson;
        this.type =type;

    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String responseStr = value.string();
        return  gson.fromJson(responseStr,type);
    }
}
