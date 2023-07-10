package org.igt.drivermanager.local.desktop;

import org.igt.config.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;

/**
 * Class to contain methods for local desktop automation setup.
 * Feb 11, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see WindowsDriver
 */
public class WinAppDriverManager {

	private WinAppDriverManager() {}
	/**
	 * Method to get Windows driver for desktop application automation on local.
	 * Feb 11, 2023
	 * @author Mandeep Sheoran
	 */
	public static WindowsDriver getDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("app", "D:\\eclipseworkspace\\UnityDesktopGameAutomation- AltUnity & WinAppDriver\\windows\\TrashCat.exe");
		caps.setCapability("platformName", "Windows");
		caps.setCapability("deviceName", "WindowsPC");
		return new WindowsDriver(ConfigFactory.getConfig().localWinAppDriverServerURL(), caps);
	}
}
