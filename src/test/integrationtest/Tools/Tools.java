package test.integrationtest.Tools;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Tools {
	
	public static final String actualbasedir = "C:\\SER216\\Testing\\"; //Must edit to your chosen directory
	
	public static boolean saveImageToFile(BufferedImage buf, String dir, String filename){
		try {
			File file = new File(actualbasedir+dir+filename);
			if(!file.exists()) {
				file.mkdirs();
			}
			ImageIO.write(buf,"jpg",file);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

}
