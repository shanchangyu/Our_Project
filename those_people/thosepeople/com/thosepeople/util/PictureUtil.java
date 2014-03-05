/**
 * 
 */
package com.thosepeople.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.fileupload.FileItem;

/**
 * @author chenzhuo
 * 
 */
public class PictureUtil {

	public static String saveTmpImg(FileItem fileItem, String suffix,
			String uid, String serverPath) {
		String name = String.valueOf(System.currentTimeMillis() + "_" + uid);
		StringBuffer sourcePath = new StringBuffer();
		sourcePath.append(serverPath);
		sourcePath.append(File.separator);
		sourcePath.append("uploadtmp");
		sourcePath.append(File.separator);
		sourcePath.append(name);
		sourcePath.append(suffix);
		File imageFile = new File(sourcePath.toString());
		if (!imageFile.getParentFile().exists()) {
			imageFile.getParentFile().mkdirs();
		}
		try {
			fileItem.write(imageFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sourcePath.toString();
	}

	public static void cutImg(String suffix, String sourcePath,
			String targetPath, int x, int y, int width, int height){
		try {  
            Image img;  
            ImageFilter cropFilter;  
            File sourceImgFile = new File(sourcePath);  
            BufferedImage bi = ImageIO.read(sourceImgFile);  
            int srcWidth = bi.getWidth();  
            int srcHeight = bi.getHeight(); 
            System.out.println(srcWidth);
            if (srcWidth >= width && srcHeight >= height) {  
                Image image = bi.getScaledInstance(srcWidth, srcHeight,  
                        Image.SCALE_DEFAULT);  
                cropFilter = new CropImageFilter(x, y, width, height);  
                img = Toolkit.getDefaultToolkit().createImage(  
                        new FilteredImageSource(image.getSource(), cropFilter));  
                BufferedImage tag = new BufferedImage(width, height,  
                        BufferedImage.TYPE_INT_RGB);  
                Graphics g = tag.getGraphics();  
                g.drawImage(img, 0, 0, null);  
                g.dispose(); 
                ImageIO.write(tag, suffix, new File(targetPath));
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}

	public static String getSuffix(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	public static String getTargetPath(String suffix, String fileName,
			String serverPath, String savePath) {
		StringBuffer targetPath = new StringBuffer();
		targetPath.append(serverPath);
		targetPath.append(File.separator);
		targetPath.append(savePath);
		targetPath.append(File.separator);
		targetPath.append(fileName);
		targetPath.append(suffix);
		return targetPath.toString();
	}
}
