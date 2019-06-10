package shens.android.lib_http.config;

/**
 * Created by shenshilei on 2019/4/22.
 * email ssl_java@163.com
 * site http://www.houziyou.com
 */
public interface HttpConfig {

    // http code
    int SUCCESS = 1;
    int FORBIDDEN = 403;
    int NOT_FOUND = 404;
    int REQUEST_TIMEOUT = 408;
    int INTERNAL_SERVER_ERROR = 500;
    int BAD_GATEWAY = 502;
    int SERVICE_UNAVAILABLE = 503;
    int GATEWAY_TIMEOUT = 504;

    // error code
    int UNKNOWN_ERROR = -100;
    int PARSE_ERROR = -101;
    int PERMISSION_ERROR = -102;
    int HTTP_EXCEPTION = -103;
    int SOCKET_TIMEOUT_EXCEPTION = -104;
    int CONNECT_EXCEPTION = -105;
    int NOT_NET_EXCEPTION = -106;
    int SSL_EXCEPTION = -107;

    // timeout period
    int TIME_OUT = 15 * 1000;
}
