package shens.android.lib_base.http;

import android.content.Context;
import android.net.ParseException;
import android.widget.Toast;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

import javax.net.ssl.SSLHandshakeException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;
import shens.android.base.R;
import shens.android.lib_base.http.bean.HttpResult;
import shens.android.lib_base.http.config.HttpConfig;
import shens.android.lib_base.http.excetion.ServerResultException;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.lib_base.http
 * @ClassName: HttpSubscribe2
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/4 2:42 PM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/4 2:42 PM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public abstract class HttpSubscribe2<T> implements Observer<T> {
    private static final String TAG = "HttpSubscriber";

    private Context mContext;
    private boolean mShowToastFlag;

    public HttpSubscribe2(Context context, boolean isShowToast) {
        this.mContext = context;
        this.mShowToastFlag = isShowToast;
    }
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T tHttpResult) {
        onSuccess(tHttpResult);
    }

    @Override
    public void onError(Throwable e) {
        Throwable throwable = e;
        // get root exception
        while (throwable.getCause() != null) {
            e = throwable;
            throwable = throwable.getCause();
        }
        if (e instanceof HttpException) {
            // http exception
            HttpException httpException = (HttpException) e;
            switch (httpException.code()) {
                // permission exception
                case HttpConfig.FORBIDDEN:
                    onFailure(HttpConfig.PERMISSION_ERROR, mContext.getString(R.string.string_permission_error));
                    break;
                // net exception
                case HttpConfig.NOT_FOUND:
                case HttpConfig.REQUEST_TIMEOUT:
                case HttpConfig.GATEWAY_TIMEOUT:
                case HttpConfig.INTERNAL_SERVER_ERROR:
                case HttpConfig.BAD_GATEWAY:
                case HttpConfig.SERVICE_UNAVAILABLE:
                default:
                    onFailure(HttpConfig.HTTP_EXCEPTION, mContext.getString(R.string.string_please_net_error));
                    break;
            }
        } else if (e instanceof JsonParseException || e instanceof JSONException || e instanceof
                ParseException) {
            // json exception
            onFailure(HttpConfig.PARSE_ERROR, mContext.getString(R.string.string_parse_data));
        } else if (e instanceof SocketTimeoutException) {
            // time out exception
            onFailure(HttpConfig.SOCKET_TIMEOUT_EXCEPTION, mContext.getString(R.string.string_req_time_out));
        } else if (e instanceof ConnectException) {
            // connect exception
            onFailure(HttpConfig.CONNECT_EXCEPTION, mContext.getString(R.string.string_connect_error));
        } else if (e instanceof ServerResultException) {
            ServerResultException serverResultException = (ServerResultException) e;
            // connect exception
            onFailure(serverResultException.getCode(), e.getMessage());
        } else if (e instanceof UnknownHostException || e instanceof UnknownServiceException) {
            // not net
            onFailure(HttpConfig.NOT_NET_EXCEPTION, mContext.getString(R.string.string_not_net_error));
        } else if (e instanceof SSLHandshakeException) {
            // ssl handshake exception
            onFailure(HttpConfig.SSL_EXCEPTION, mContext.getString(R.string.string_ssl_error));
        } else {
            // unknown exception
            onFailure(HttpConfig.UNKNOWN_ERROR, mContext.getString(R.string.string_unknown_error));
        }

    }

    @Override
    public void onComplete() {

    }
    public void onFailure(int code, String msg) {
        if (mShowToastFlag) {
            showToastMsg(msg);
        }
        onCodeEror(code,msg);
    }
    public abstract void onSuccess(T data);

    public void onCodeEror(int code,String msg){

    }

    /**
     * toast tip
     *
     * @param msg tip inform
     */
    private void showToastMsg(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
