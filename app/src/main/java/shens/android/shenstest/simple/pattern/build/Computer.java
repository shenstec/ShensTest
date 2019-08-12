package shens.android.shenstest.simple.pattern.build;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.simple.pattern.build
 * @ClassName: Computer
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/22 11:26 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/22 11:26 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class Computer {

    private String cpu;//cpu
    private String disk;//硬盘
    private String board;//主板

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", disk='" + disk + '\'' +
                ", board='" + board + '\'' +
                '}';
    }
}

//    public static class CopBuilder{
//
//        private Computer c = new Computer();
//
//        public CopBuilder buildCpu(String cpu){
//            c.setCpu(cpu);
//            return this;
//        }
//        public CopBuilder buildDisk(String disk){
//            c.setDisk(disk);
//            return  this;
//        }
//
//        public CopBuilder buildBoard(String board){
//            c.setBoard(board);
//            return this;
//        }
//
//        public Computer build(){
//            return  c;
//        }
//
//    }
//}
