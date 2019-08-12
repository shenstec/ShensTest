package shens.android.shenstest.simple.pattern.prototype;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.simple.pattern.prototype
 * @ClassName: Resume
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/23 9:57 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/23 9:57 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class Resume implements Cloneable{

    private String name;
    private int age;
    private String sex;

    private Student student;

    String[] msg;

    public Resume(){
        System.out.print("无参数构造");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        Resume resume = (Resume) super.clone();
        resume.student = (Student) resume.getStudent().clone();

        return resume;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", student=" + student +
                '}';
    }
}
