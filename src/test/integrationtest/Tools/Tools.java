package test.integrationtest.Tools;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.naming.ConfigurationException;

public class Tools {
	
	public static String actualbasedir; //Enter your base directory path into integrationtest.config
	
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
	
	public static void initialize(){
		if(actualbasedir != null) return;
		BufferedReader buf = null;
		try{
			System.out.println(System.getProperty("user.dir"));
			buf = new BufferedReader(new FileReader(new File("integrationtestconfig.properties")));
			String[] config = buf.readLine().split("=");
			if(config != null && config.length >= 2){
				if(config[0].equals("TEST_OUTPUT_DIR")){
					actualbasedir = config[1];
				}
				else{
					throw new ConfigurationException("integrationtestconfig.properties format error");
				}
			}
			else{
				throw new ConfigurationException("integrationtestconfig.properties format error");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(buf != null) buf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
