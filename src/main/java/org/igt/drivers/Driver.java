package org.igt.drivers;

import java.io.IOException;
import java.util.Objects;

import org.igt.config.ConfigFactory;

import com.alttester.AltDriver;



public class Driver {
	 public static AltDriver driver;
	
	public static AltDriver getDriver() {
		if (Objects.isNull(driver)) {
		 String deviceIP= ConfigFactory.getConfig().deviceIp();
         Integer portno =Integer.valueOf(ConfigFactory.getConfig().portno());
         driver = new AltDriver(deviceIP,portno);
		} 
		 return driver;
	}
	
	public static void quitDriver() {
		  try {
			driver.stop();
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}       
	}
}
