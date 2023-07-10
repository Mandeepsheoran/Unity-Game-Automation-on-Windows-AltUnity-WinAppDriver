package org.igt.unitygameautomation;

import java.io.IOException;

import org.igt.annotations.FrameworkAnnotations;
import org.igt.config.ConfigFactory;
import org.igt.enums.CategoryType;
import org.igt.enums.TestType;
import org.igt.pompages.MainMenuPage;
import org.igt.pompages.StorePage;
import org.igt.reports.ExtentReport;
import org.igt.utils.DateFormatUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.alttester.AltDriver;

public class StoreFeatureTest extends BaseTest{

    private static AltDriver driver;
    private static MainMenuPage mainMenuPage;
    private static StorePage shopPage;

    private static void getAllObjectsShopPage(){
        shopPage.getStoreTitle();
        shopPage.getAccessoriesButton();
        shopPage.getCharactersButton();
        shopPage.getItemsButton();
        shopPage.getCloseButton();
        shopPage.getThemesButton();
        shopPage.getPremiumButton();
        shopPage.getCoinSection();
    }

    private static void getAllObjectsMainMenuPage(){
        mainMenuPage.setStoreButton();
        mainMenuPage.setThemeName();
        mainMenuPage.setSettingsButton();
        mainMenuPage.setRunButton();
        mainMenuPage.setMissionButton();
        mainMenuPage.setLeaderBoardButton();
        mainMenuPage.setCharacterName();
    }

    @BeforeMethod
    public void loadLevel(ITestResult result){
    	String description =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description();
		ExtentReport.createTest(description);
        mainMenuPage = new MainMenuPage();
        shopPage = new StorePage();
        shopPage.loadScene();
        System.out.println("TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.currentDateTime() + "]");
    }

    @Test(description="Shop page loading functionality")
   	@FrameworkAnnotations(author="Mandeep", category=CategoryType.QUICKREGRESSION, baseType=TestType.DESKTOP)
    public void ShopPageLoadedCorrectly(){
        getAllObjectsShopPage();
        Assert.assertTrue(shopPage.isDisplayedCorrectly());
        shopPage.pressClose();
    }

    @Test(description="Shop page close")
   	@FrameworkAnnotations(author="John", category=CategoryType.QUICKREGRESSION, baseType=TestType.DESKTOP)
    public void testShopPageCanBeClosed(){
        getAllObjectsShopPage();
        shopPage.pressClose();
        mainMenuPage.loadScene();
        getAllObjectsMainMenuPage();
        Assert.assertTrue(mainMenuPage.isDisplayed());
    }

    @Test(description="Premium popup functionality")
   	@FrameworkAnnotations(author="John", category=CategoryType.QUICKREGRESSION, baseType=TestType.DESKTOP)
    public void testPremiumPopUpOpen(){
        shopPage.getPremiumButton();
        shopPage.pressPremiumPopUp();
        shopPage.getPopup();
        Assert.assertTrue(shopPage.checkPopupOpen());
    }

    @Test(description="Premium popup close functionality")
   	@FrameworkAnnotations(author="John", category=CategoryType.QUICKREGRESSION, baseType=TestType.DESKTOP)
    public void testPremiumPopUpClosed(){
        shopPage.getPremiumButton();
        shopPage.pressPremiumPopUp();
        shopPage.getPopup();
        shopPage.getClosePopupButton();
        shopPage.pressClosePremiumPopup();
        Assert.assertFalse(shopPage.checkPopupOpen());
    }
}
