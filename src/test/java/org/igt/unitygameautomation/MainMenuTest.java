package org.igt.unitygameautomation;

import java.io.IOException;

import org.igt.annotations.FrameworkAnnotations;
import org.igt.config.ConfigFactory;
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


public class MainMenuTest extends BaseTest{

    private static HomePage startPage;
    private static MainMenuPage mainMenuPage;

    @BeforeMethod
    public void loadLevel(ITestResult result){
    	String description =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description();
		ExtentReport.createTest(description); 
        mainMenuPage = new MainMenuPage();
        mainMenuPage.loadScene();
        System.out.println("TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.currentDateTime() + "]");
    }

    @Test(description="Home page load functionality")
	@FrameworkAnnotations(author="Mike", category=CategoryType.REGRESSION, baseType=TestType.DESKTOP)
    public void TestMainPageLoadedCorrectly(){
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
