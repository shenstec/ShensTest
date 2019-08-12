package shens.android.shenstest.simple.pattern.build;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.simple.pattern.build
 * @ClassName: Director
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/22 2:47 PM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/22 2:47 PM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class Director {

    private ConcreateBuilder mBuilder = null;

    public Director(ConcreateBuilder builder){
        this.mBuilder = builder;
    }

    public  Computer build(String cpu,String disk,String board){
        if(mBuilder!=null){
            mBuilder.buildBoard(board);
            mBuilder.buildCPU(cpu);
            mBuilder.buildDisk(disk);
            mBuilder.create();
        }
        return null;
    }

}
