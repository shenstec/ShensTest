package shens.android.shenstest.simple.pattern.build;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.simple.pattern.build
 * @ClassName: ConcreateBuilder
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/22 2:44 PM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/22 2:44 PM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class ConcreateBuilder extends Builder {
    Computer computer = new Computer();
    @Override
    public void buildCPU(String cpu) {
        computer.setCpu(cpu);
    }

    @Override
    public void buildDisk(String disk) {
        computer.setDisk(disk);
    }

    @Override
    public void buildBoard(String board) {
        computer.setBoard(board);
    }

    @Override
    public Computer create() {
        return computer;
    }
}
