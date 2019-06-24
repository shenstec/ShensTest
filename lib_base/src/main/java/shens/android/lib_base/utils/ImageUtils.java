package shens.android.lib_base.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;

/**
 * @ProjectName: lib_bae
 * @Package: shens.android.lib_base.utils
 * @ClassName: ImageUtils
 * @Description: 图片处理和显示工具
 * @Author: 申世雷
 * @CreateDate: 2019/6/10 9:15 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/6/10 9:15 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class ImageUtils {

    /**
     * 加载网络图片
     * @param context
     * @param url 图片链接
     * @param imageView 图片控件
     * @param resId 占位资源id
     */
    public static void displayImage(Context context, String url, ImageView imageView,int resId){
        Glide.with(context).load(url).placeholder(resId)
                .error(resId)
                .into(imageView);
    }






}
