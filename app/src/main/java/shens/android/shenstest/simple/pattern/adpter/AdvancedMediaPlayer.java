package shens.android.shenstest.simple.pattern.adpter;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.simple.pattern.adpter
 * @ClassName: AdvancedMediaPlayer
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/25 10:25 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/25 10:25 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
//创建适配 适配可以播放 val 和mp4格式
public class AdvancedMediaPlayer {

    public void playVlc(String type,String filePath){
        System.out.println("播放vlc"+filePath);
    }

    public void playMp4(String type,String filePath){
        System.out.println("播放mp4"+filePath);
    }

}
