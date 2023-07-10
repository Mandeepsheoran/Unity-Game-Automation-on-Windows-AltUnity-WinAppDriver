package org.igt.constants;

import java.time.Duration;

import org.igt.config.ConfigFactory;

import lombok.Getter;

/**
 * Constant class to provide folder and file path for framework detailed files.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see lombok
 */
public class FrameworkConstant {
			
		static long waitTimeOut =30;	
	public static final String configFilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
		public static final String iosAppFilePath = System.getProperty("user.dir")+"/src/test/resources/mobile-app/ios-app.zip";
		public static final String androidAppFilePath = System.getProperty("user.dir")+"/src/test/resources/mobile-app/ApiDemos-debug.apk";
		public static final String extentconfigFilePath = System.getProperty("user.dir")+"/src/test/resources/extentconfig.xml";	
		private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources";
		private static final String EXTENTREPORTFOLDERPATH =System.getProperty("user.dir") + "/ExtentTest-Output/";
		private static final String screenshotpath =System.getProperty("user.dir") + "/trashcat.png";
		private static final String altscreenshotpath =System.getProperty("user.dir")+"/src/test/resources/trashcat.jpeg";
		private static String extentreportfilepath="";
		private static final Duration EXPLICITWAITTIME = Duration.ofMinutes(30);
	
		public static Duration getExplicitwaittime() {
			return EXPLICITWAITTIME;
		}
		
		public static String getScreenshotpath() {
			return screenshotpath;
		}

		public static String getExtentreportfilepath() {
			if(extentreportfilepath.isEmpty()) { 
				extentreportfilepath = createExtentReportPath();
			}
			return extentreportfilepath;
		}	
		private static String createExtentReportPath()  {
			if(ConfigFactory.getConfig().isOverrideRequired().equalsIgnoreCase("no")) {
				return EXTENTREPORTFOLDERPATH + System.currentTimeMillis()+"/index.html";
			}
			else {
				return EXTENTREPORTFOLDERPATH + "/index.html";
			}
		}
	}

