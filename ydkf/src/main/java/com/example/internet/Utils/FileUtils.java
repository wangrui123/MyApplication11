package com.example.internet.Utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

/**
 * author: wangrui
 * date : 2017/8/30
 * description :
 */

public class FileUtils {
    public static void getLj(Context mContext) {
        String path = Environment.getExternalStorageDirectory().getPath();
        InputStream is = mContext.getClass().getClassLoader().getResourceAsStream("assets/2.ppt");
        try {
            FileOutputStream fos = new FileOutputStream(new File(path + "/2.ppt"));
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                fos.flush();
            }
            is.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //判断外部存储是否可写
    public static boolean isMount() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return true;
        } else {
            return false;
        }
    }


    // 获取SD卡公有目录的路径
    public static String getSDCardPublicDir(String type) {
        return Environment.getExternalStoragePublicDirectory(type).getAbsoluteFile().toString();
    }

    //获取相册目录下的路径
    public static String getStorageDcimDir(Context mContext) {
        String path = null;
        if (isMount()) {
            path = getSDCardPublicDir(Environment.DIRECTORY_DCIM);
        } else {
            path = mContext.getFilesDir().getAbsolutePath();
        }
        return path;
    }

    //在DCIM目录下创建文件夹
    public static void createDCIMPublicFile(Context mContext) {
        File mediaStorageDir = new File(getStorageDcimDir(mContext) + "/wangrui1111");
        if (!mediaStorageDir.exists()) {
            mediaStorageDir.mkdirs();
        }
    }

    //在根目录创建文件
    public static void createSDCardDir(String filePath, String fileName, String content) {
        if (isMount()) {
            // 创建一个文件夹对象，赋值为外部存储器的目录
            String getDiretoryName = Environment.getExternalStorageDirectory().getPath() + filePath;
            File file = new File(getDiretoryName);
            if (!file.exists()) {
                //若不存在，创建目录，可以在应用启动的时候创建
                file.mkdirs();
            }
            try {
                String getFileName = getDiretoryName + fileName;
                File targetFile = new File(getFileName);
                if (!targetFile.exists()) {
                    targetFile.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(getFileName);
                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                //保证输出缓冲区中的所有内容
                osw.write(content);
                osw.flush();
                fos.flush();
                //后打开的先关闭，逐层向内关闭
                fos.close();
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //读取assets下面的文件
    public static String readFile2(Context mContext, String file) {
        int len = 0;
        byte[] buf = null;
        String result = "";
        try {
            InputStream in = mContext.getAssets().open(file);
            len = in.available();
            buf = new byte[len];
            in.read(buf, 0, len);
            result = new String(buf, "UTF-8");
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
