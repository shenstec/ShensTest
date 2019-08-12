package shens.android.shenstest.simple.pattern.adpter;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.simple.pattern.adpter
 * @ClassName: MediaAdapter
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/25 10:35 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/25 10:35 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String type){
        if(type.equalsIgnoreCase("vlc")||type.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new AdvancedMediaPlayer();
        }
    }

    @Override
    public void play(String type, String filePath) {
        if(type.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file. Name: "+ filePath);
        }else if(type.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(type,filePath);
        }else if(type.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(type,filePath);
        }else{
            System.out.println("没有支持的格式"+type+ filePath);
        }
    }
}
