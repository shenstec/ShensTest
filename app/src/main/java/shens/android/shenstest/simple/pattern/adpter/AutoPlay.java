package shens.android.shenstest.simple.pattern.adpter;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.simple.pattern.adpter
 * @ClassName: AutoPlay
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/25 10:28 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/25 10:28 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class AutoPlay implements MediaPlayer {

    private MediaAdapter mediaAdapter;


    @Override
    public void play(String type, String filePath) {
        mediaAdapter = new MediaAdapter(type);
        mediaAdapter.play(type,filePath);



    }
}
