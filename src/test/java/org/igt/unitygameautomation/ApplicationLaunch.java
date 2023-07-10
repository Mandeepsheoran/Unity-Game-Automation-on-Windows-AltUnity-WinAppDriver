package org.igt.unitygameautomation;

import org.igt.annotations.FrameworkAnnotations;
import org.igt.drivermanager.local.desktop.WinAppDriverManager;
import org.igt.enums.CategoryType;
import org.igt.enums.TestType;
import org.igt.pompages.GamePlayPage;
import org.igt.pompages.MainMenuPage;
import org.igt.pompages.PauseResumePage;
import org.igt.pompages.RerunGamePage;
import org.igt.reports.ExtentReport;
import org.igt.utils.DateFormatUtils;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplicationLaunch {
	
	 @BeforeMethod
	    public void loadLevel(ITestResult result) throws Exception {
	        System.out.println("TEST STARTED : " + result.getMethod().getMethodName() + " at ["
					+ DateFormatUtils.currentDateTime() + "]");
	    }
	
	@Test(description="Launch TrashCat app")
	@FrameworkAnnotations(author="Mandeep", category=CategoryType.SMOKE, baseType=TestType.DESKTOP)
	public static void trashCatAppLaunch() {
	//	WinAppDriverManager.getDriver();
		
		 String filepath = System.getProperty("user.dir") + "/windows/TrashCat.exe";
         try{
               Process p = Runtime.getRuntime().exec(filepath);  
         } catch(Exception e) {
             e.printStackTrace();
         }
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
