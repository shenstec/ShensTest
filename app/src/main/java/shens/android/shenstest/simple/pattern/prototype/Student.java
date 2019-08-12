package shens.android.shenstest.simple.pattern.prototype;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.simple.pattern.prototype
 * @ClassName: Student
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/23 10:31 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/23 10:31 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class Student implements Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
