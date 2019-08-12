package shens.android.shenstest.simple.pattern.factory.abstr;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.simple.pattern.factory.abstr
 * @ClassName: ProduceFactory
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/19 4:37 PM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/19 4:37 PM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class ProduceFactory implements CarFatory {

    @Override
    public Trunk crateTrunk(Class cls) {
        try {
            Trunk trunk = (Trunk) Class.forName(cls.getName()).newInstance();
            return trunk;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Sedan crateSedan(Class cls) {
        try {
            Sedan sedan = (Sedan) Class.forName(cls.getName()).newInstance();
            return sedan;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
