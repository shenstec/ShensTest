package shens.android.shenstest.simple.pattern.factory;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.mode.factory
 * @ClassName: Factory
 * @Description: 抽象工厂
 * @Author: 作者名
 * @CreateDate: 2019/7/17 11:03 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/17 11:03 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public abstract class Factory {
    /**
     *
     * @param cls 产品对象类型
     * @param <T> 具体的产品类型
     * @return
     */
    public abstract <T extends Product> T createProduct(Class<T> cls);

}
