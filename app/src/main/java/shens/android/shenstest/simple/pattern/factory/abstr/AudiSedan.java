package shens.android.shenstest.simple.pattern.factory.abstr;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.simple.pattern.factory.abstr
 * @ClassName: AudiSedan
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/19 4:36 PM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/19 4:36 PM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class AudiSedan implements Sedan {
    @Override
    public void run() {
        System.out.println("奥迪轿车启动");
    }
}