package shens.android.shenstest.simple.pattern.factory.abstr;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.simple.pattern.factory.abstr
 * @ClassName: CarFatory
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/19 4:27 PM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/19 4:27 PM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */

/**
 * 抽象（车）
 */
public interface CarFatory {


    public Trunk crateTrunk(Class cls);

    public Sedan crateSedan(Class cls);
}
