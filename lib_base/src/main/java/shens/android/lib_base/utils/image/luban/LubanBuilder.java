package shens.android.lib_base.utils.image.luban;

import android.graphics.Bitmap;

import java.io.File;

/**
 * @ClassName: LubanBuilder
 * @Description: 压缩属性
 * @Author: shenshilei
 * @CreateDate: 2019/6/29 9:53 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/6/29 9:53 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class LubanBuilder {
    int maxSize; //最大大小
    int maxWidth;//最大宽度
    int maxHeight;//最大高度
    File cacheDir;//文件缓存地址
    Bitmap.CompressFormat compressFormat;//压缩格式
    int gear;//压缩程度

    LubanBuilder(File cacheDir) {
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.gear = 3;
        this.cacheDir = cacheDir;
    }
}
