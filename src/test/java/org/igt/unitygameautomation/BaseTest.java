package org.igt.unitygameautomation;

import java.io.IOException;
import org.igt.config.ConfigFactory;
import org.igt.drivers.Driver;
import org.igt.reports.ExtentReport;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.alttester.AltDriver;

public class BaseTest {
	
	  public static AltDriver driver;
	  
	@BeforeSuite
    public static void reportinit() {
    	 try {
 			ExtentReport.initReport();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
    } 
	
	 @BeforeClass
	    public static AltDriver setUp() throws IOException {
	   return Driver.getDriver();
	    }
	 
	  @AfterClass
	    public static void tearDown() throws Exception {
	  //    Driver.quitDriver();
	    }
    
    @AfterSuite
    public static void reportflush() {
    	  Driver.quitDriver();
    	ExtentReport.tearDownReport();
    } 

}
