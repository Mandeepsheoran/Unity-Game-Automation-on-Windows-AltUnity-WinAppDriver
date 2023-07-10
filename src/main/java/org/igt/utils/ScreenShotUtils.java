package org.igt.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.igt.constants.FrameworkConstant;
import org.igt.drivermanager.local.desktop.WinAppDriverManager;
import org.igt.drivers.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import com.alttester.AltDriver;


/**
 * Provide screenshot functionality during execution. Feb 1, 2023
 * 
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 */
public final class ScreenShotUtils {
	
	public static String targetfilepath;

	private ScreenShotUtils() {
	}

	/**
	 * Take screenshot using driver method and change it from Base64 to String
	 * format.
	 * 
	 * @return screenshot
	 */
	public static String getScreenshot() {
		String targetfilepath = FrameworkConstant.getScreenshotpath();
		File screenshotfile = ((TakesScreenshot) WinAppDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenshotfile, new File(targetfilepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return targetfilepath;
	} 

	public static String getAltScreenshot() {
		 targetfilepath = "trashcat.jpeg";
		 Driver.getDriver().getPNGScreenshot(FrameworkConstant.getScreenshotpath());
	//	Driver.getDriver().getPNGScreenshot(targetfilepath);
/**		File screenshotfile = ((TakesScreenshot) WinAppDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenshotfile, new File(targetfilepath));
		} catch (IOException e) {
			e.printStackTrace();
		} **/
		 Path path =Paths.get(FrameworkConstant.getScreenshotpath());	
				try {
					return new String(Files.readAllBytes(path));
				} catch (IOException e) {
					e.printStackTrace();
				}
		return null ;
	}

	public static String getBase64Image() {
		return ((TakesScreenshot) WinAppDriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
