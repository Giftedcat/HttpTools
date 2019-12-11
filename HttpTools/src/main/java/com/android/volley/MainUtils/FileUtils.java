package com.android.volley.MainUtils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 作者: 徐诚聪
 * 时间: 17-2-9
 * 描述: 文件处理类
 */
public class FileUtils {
    public static final String POSTFIX = ".JPEG";
    public static String MAIL_NAME = "Images";
    public static String CAMERA_PATH ="/CameraImage/";
    public static String CROP_PATH =  "/CropImage/";
    public static String SMALLIMG_PATH="/SmallImg/";
    public static String ROOT_PATH="";

    /**
     * 初始化时，创建所有的文件夹
     */
    public static void initFiles(Context context,String fileTmpName){
        MAIL_NAME=fileTmpName;

        String state = Environment.getExternalStorageState();
        File rootDir = state.equals(Environment.MEDIA_MOUNTED)?Environment.getExternalStorageDirectory():context.getCacheDir();
        ROOT_PATH=rootDir.getAbsolutePath();
        CAMERA_PATH=ROOT_PATH+"/"+MAIL_NAME+CAMERA_PATH;
        CROP_PATH=ROOT_PATH+"/"+MAIL_NAME+CROP_PATH;
        SMALLIMG_PATH=ROOT_PATH+"/"+MAIL_NAME+SMALLIMG_PATH;


        String[] fileNames={CAMERA_PATH,CROP_PATH,SMALLIMG_PATH};
        for(String fileName:fileNames){
            File file=new File(fileName);
            if(!file.exists())
                file.mkdirs();
        }
    }

    public static String getFilePath(){
        return ROOT_PATH+"/"+MAIL_NAME;
    }

    public static String getFileName(String filePath){
        return filePath.substring(filePath.lastIndexOf("/") + 1);
    }
    public static String getSmallImg(){
        return SMALLIMG_PATH;
    }

    public static File createCameraFile() {
        return createMediaFile(CAMERA_PATH);
    }
    public static File createCropFile() {
        return createMediaFile(CROP_PATH);
    }

    public static File createMediaFile(String parentPath){
        File folderDir = new File(parentPath);
        if (!folderDir.exists() && folderDir.mkdirs()){

        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date());
        File tmpFile = new File(folderDir, timeStamp + POSTFIX);
        return tmpFile;
    }

    public static String getCacheFilePath(String fileName){
        return MAIL_NAME+"/"+fileName;
    }
}
