package shens.android.lib_base.utils.image.luban;

import java.io.File;
import java.util.List;

/**
 * @ProjectName: tucao
 * @Package: shens.library.base.utils.image.luban
 * @ClassName: OnMultiCompressListener
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/6/29 10:39 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/6/29 10:39 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public interface OnMultiCompressListener {

    void onStart();

    void onSuccess(List<File> var1);

    void onError(Throwable var1);
}
