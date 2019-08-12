package shens.android.shenstest.simple.pattern.build;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.simple.pattern.build
 * @ClassName: Builder
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/22 2:40 PM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/22 2:40 PM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public abstract class Builder {

    public abstract void buildCPU(String cpu);//组装CPu

    public abstract void buildDisk(String disk);//组装硬盘

    public abstract void buildBoard(String board);//组装主板

    public abstract Computer create();//返回组装好的电脑


}
