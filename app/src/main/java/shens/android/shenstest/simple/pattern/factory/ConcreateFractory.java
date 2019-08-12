package shens.android.shenstest.simple.pattern.factory;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.mode.factory
 * @ClassName: ConcreateFractory
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/17 11:06 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/17 11:06 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class ConcreateFractory extends Factory {
    @Override
    public <T extends Product> T createProduct(Class<T> cls) {

        Product product = null;

        try {
            product = (Product) Class.forName(cls.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return (T) product;
    }
}
