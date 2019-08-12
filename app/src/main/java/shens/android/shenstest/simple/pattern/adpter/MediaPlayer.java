package shens.android.shenstest.simple.pattern.adpter;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.simple.pattern.adpter
 * @ClassName: MediaPlayer
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/25 10:23 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/25 10:23 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */

//创建多媒体播放器 假设只能播放Mp3
public interface MediaPlayer {

    public void play(String type,String filePath);
}
