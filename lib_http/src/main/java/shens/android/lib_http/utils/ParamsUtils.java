package shens.android.lib_http.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by shenshilei on 2019/5/21.
 * email ssl_java@163.com
 * site http://www.houziyou.com
 */
public class ParamsUtils {

    public static FormBody postParams(HashMap<String,String> reqMap){
        HashMap<String, String> dataMap = new HashMap<>();
        if (reqMap != null && reqMap.size() > 0) {
            dataMap.putAll(reqMap);
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            builder.add(entry.getKey(), AesUtil.encrypt(entry.getValue()));
        }

        return builder.build();
    }

    /**
     * 文件上传 请求参数
     */
    public static MultipartBody getUploadFileParams(HashMap<String, String> reqMap, String file) {
        HashMap<String, String> dataMap = new HashMap<>();
        if (reqMap != null && reqMap.size() > 0) {
            dataMap.putAll(reqMap);
        }


        File tempFile = new File(file);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile);
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            builder.addFormDataPart(entry.getKey(), AesUtil.encrypt(entry.getValue()));
        }
        if (tempFile != null) {
            builder.addFormDataPart("file", tempFile.getName(), requestFile).build();
        }
        return builder.build();
    }
}
