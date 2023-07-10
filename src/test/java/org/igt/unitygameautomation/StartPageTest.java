package org.igt.unitygameautomation;

import java.io.IOException;
import org.igt.annotations.FrameworkAnnotations;
import org.igt.config.ConfigFactory;
import org.igt.drivers.Driver;
import org.igt.enums.CategoryType;
import org.igt.enums.TestType;
import org.igt.pompages.MainMenuPage;
import org.igt.reports.ExtentReport;
import org.igt.utils.DateFormatUtils;
import org.igt.pompages.HomePage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.alttester.AltDriver;
import com.alttester.Commands.UnityCommand.AltLoadSceneParams;

public class StartPageTest extends BaseTest{

    private static HomePage startPage;
    private static MainMenuPage mainMenuPage;

    @BeforeMethod
    public void loadLevel(ITestResult result) throws Exception {
    	String description =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description();
		ExtentReport.createTest(description);
		  BaseTest.setUp().loadScene(new AltLoadSceneParams.Builder("Start").build());
//        startPage.load();
        startPage = new HomePage();
        mainMenuPage = new MainMenuPage();
        System.out.println("TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.currentDateTime() + "]");
    }
    
    @Test(description="Start page functionality")
   	@FrameworkAnnotations(author="John", category=CategoryType.SMOKE, baseType=TestType.DESKTOP)
    public void testStartPageLoadedCorrectly(){
        startPage.getUnityURLButton();
        startPage.getLogoImage();
        startPage.getStartText();
        startPage.getStartButton();
        Assert.assertTrue(startPage.isDisplayed());
    }

    @Test(description="Start button functionality")
   	@FrameworkAnnotations(author="Mandeep", category=CategoryType.SMOKE, baseType=TestType.DESKTOP)
    public void testStartButtonLoadMainMenu(){

        startPage.getUnityURLButton();
        startPage.getLogoImage();
        startPage.getStartText();
        startPage.getStartButton();
        startPage.pressStart();

        mainMenuPage.setCharacterName();
        mainMenuPage.setLeaderBoardButton();
        mainMenuPage.setMissionButton();
        mainMenuPage.setRunButton();
        mainMenuPage.setSettingsButton();
        mainMenuPage.setStoreButton();
        mainMenuPage.setThemeName();

        Assert.assertTrue(mainMenuPage.isDisplayed());
    }
}
