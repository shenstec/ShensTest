package shens.android.lib_base.utils.image.luban;

import java.io.File;

/**
 * @ProjectName: tucao
 * @Package: shens.library.base.utils.image.luban
 * @ClassName: OnCompressListener
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/6/29 9:54 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/6/29 9:54 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public interface OnCompressListener {
    /**
     * 开始压缩
     */
    void onStart();

    /**
     * 压缩成功回掉
     */
    void onSuccess(File file);

    /**
     * 压缩失败回掉
     */
    void onError(Throwable e);
}
