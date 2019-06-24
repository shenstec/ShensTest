package shens.android.lib_base.utils;

import android.text.TextUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.lib_base.utils
 * @ClassName: FIleUtils
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/6/24 5:47 PM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/6/24 5:47 PM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class FIleUtils {

    /**
     * 续写本地文件
     * @param filePath 文件路径
     * @param fileName 文件名
     * @param content 写入的文件内容
     * @param autoLine 是否换行 true 换行
     * @throws IOException
     */
    public static void writeAppendStringToFile(String filePath, String fileName, String content, boolean autoLine) throws IOException {

        File fileDir = new File(filePath);
        if (!fileDir.exists()) {
            if (!fileDir.mkdirs()) {
                return;
            }
        }
        File file;
        //判断文件名是否为空
        if (TextUtils.isEmpty(fileName)) {
            throw new NullPointerException("文件名不能为空");
        } else {
            file = new File(filePath + fileName);
        }
        RandomAccessFile raf = null;
        //如果为追加则在原来的基础上继续写文件
        raf = new RandomAccessFile(file, "rw");
        raf.seek(file.length());
        raf.write(content.getBytes());
        if (autoLine) {
            raf.write("\n".getBytes());
        }
        raf.close();
    }

    /**
     * 写文本到本地文件
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @param content 文件内容
     * @throws IOException
     */
    public static void writeStringToFIle(String filePath,String fileName,String content) throws IOException {
        File fileDir = new File(filePath);
        if (!fileDir.exists()) {
            if (!fileDir.mkdirs()) {
                return;
            }
        }
        File file;
        //判断文件名是否为空
        if (TextUtils.isEmpty(fileName)) {
            throw new NullPointerException("文件名不能为空");
        } else {
            file = new File(filePath + fileName);
        }
        FileOutputStream out = null;
        //重写文件，覆盖掉原来的数据
        out = new FileOutputStream(file);
        out.write(content.getBytes());
        out.flush();
    }
}

