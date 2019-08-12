package shens.android.shenstest.simple.pattern.single;


/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.simple.pattern.single
 * @ClassName: Singleton
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/19 6:36 PM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/19 6:36 PM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class Singleton {




     private Singleton (){

    }

     //饿汉 类初始化时就完成初始化
//     private static Singleton singleton = new Singleton();
//     public static Singleton getInstance(){
//         return singleton;
//     }

//     private static Singleton singleton;
//     static {
//         //静态代码块的方式实现
//         singleton = new Singleton();
//     }
//    public static Singleton getInstance(){
//         return singleton;
//     }

    //懒汉式加载，在多线程环境中可能会生成多个对象，非线程安全
    private static Singleton singleton = null;
    public static Singleton getInstacn(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    //静态内部类 在主动使用的时候才会加载
    private static class InnerSingleton{
        static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance(){
        return  InnerSingleton.singleton;
    }

}
