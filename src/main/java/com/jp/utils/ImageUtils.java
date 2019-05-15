package com.jp.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @ClassName:  ImageUtils   
 * @Description:TODO(图片工具类)   
 * @author      ZJP
 * @date:2018年2月4日 上午11:30:08
 */
public class ImageUtils {
	
	public static String ProjectLocation = "E:\\JavaWeb\\project\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\BookStore";
	public static String BookImageFolderName = "book_img";
	/*** 
     * 功能 :调整图片大小 开发
     * @param srcImgPath 原图片路径 
     * @param distImgPath  转换大小后图片路径 
     * @param width   转换后图片宽度 
     * @param height  转换后图片高度 
     */  
    public static void resizeImage_JPG(String srcImgPath, String distImgPath,  
            int width, int height) throws IOException {  
  
        File srcFile = new File(srcImgPath);  
        Image srcImg = ImageIO.read(srcFile);  
        BufferedImage buffImg = null;  
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        buffImg.getGraphics().drawImage(  
                srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0,  
                0, null);  
  
        ImageIO.write(buffImg, "JPEG", new File(distImgPath));  
    } 
    
    public static void deleteBookImage(String fileName){
    	File file = new File(ProjectLocation + "/" + BookImageFolderName + "/" + fileName);
    	file.delete();
    }
    
//    public static void main(String[] ar) throws IOException{
//    	File file = new File(ProjectLocation + "/images/test1.png");
//    	if(file.exists()){
//    		file.delete();
//    	}
//    }
}
