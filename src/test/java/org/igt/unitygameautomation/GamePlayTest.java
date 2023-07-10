package org.igt.unitygameautomation;

import java.io.IOException;
import org.igt.annotations.FrameworkAnnotations;
import org.igt.enums.CategoryType;
import org.igt.enums.TestType;
import org.igt.pompages.GamePlayPage;
import org.igt.pompages.RerunGamePage;
import org.igt.reports.ExtentReport;
import org.igt.utils.DateFormatUtils;
import org.igt.utils.ScreenShotUtils;
import org.igt.pompages.MainMenuPage;
import org.igt.pompages.PauseResumePage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.alttester.AltDriver;
import com.alttester.Commands.FindObject.AltFindObjectsParams;
import com.alttester.Commands.InputActions.AltPressKeyParams;
import com.alttester.UnityStruct.AltKeyCode;

public class GamePlayTest extends BaseTest{

    private static MainMenuPage mainMenuPage;
    private static PauseResumePage PauseResumePage;
    private static RerunGamePage getAntoherChancePage;
    private static GamePlayPage gamePlayPage;

    @BeforeMethod
    public void loadLevel(ITestResult result) throws Exception {
    	String description =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description();
		ExtentReport.createTest(description); 
        mainMenuPage = new MainMenuPage();
        mainMenuPage.loadScene();
        mainMenuPage.setCharacterName();
        mainMenuPage.setLeaderBoardButton();
        mainMenuPage.setMissionButton();
        mainMenuPage.setRunButton();
        mainMenuPage.setSettingsButton();
        mainMenuPage.setStoreButton();
        mainMenuPage.setThemeName();

        gamePlayPage = new GamePlayPage();
        PauseResumePage = new PauseResumePage();
        getAntoherChancePage = new RerunGamePage();
        System.out.println("TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.currentDateTime() + "]");
    }

	@Test(description="Check game start functionality",priority=5)
	@FrameworkAnnotations(author="Mandeep", category=CategoryType.SMOKE, baseType=TestType.DESKTOP)
    public void testGamePlayDisplayedCorrectly() throws InterruptedException, IOException{
        mainMenuPage.pressRun();
        Thread.sleep(4000);
        BaseTest.setUp().pressKey(new AltPressKeyParams.Builder(AltKeyCode.RightArrow).withDuration(1).withPower(2)
                .withWait(false).build());
        Thread.sleep(4000);
        BaseTest.setUp().pressKey(new AltPressKeyParams.Builder(AltKeyCode.LeftArrow).build());
        BaseTest.setUp().pressKey(new AltPressKeyParams.Builder(AltKeyCode.LeftArrow).build());
        Thread.sleep(4000);
        BaseTest.setUp().pressKey(new AltPressKeyParams.Builder(AltKeyCode.RightArrow).build());
        BaseTest.setUp().pressKey(new AltPressKeyParams.Builder(AltKeyCode.UpArrow).build());
        BaseTest.setUp().pressKey(new AltPressKeyParams.Builder(AltKeyCode.UpArrow).build());
        BaseTest.setUp().pressKey(new AltPressKeyParams.Builder(AltKeyCode.UpArrow).build());
        BaseTest.setUp().pressKey(new AltPressKeyParams.Builder(AltKeyCode.UpArrow).build());
        BaseTest.setUp().pressKey(new AltPressKeyParams.Builder(AltKeyCode.DownArrow).build());
        BaseTest.setUp().pressKey(new AltPressKeyParams.Builder(AltKeyCode.DownArrow).build());
        Thread.sleep(2000);
        BaseTest.setUp().pressKey(new AltPressKeyParams.Builder(AltKeyCode.RightArrow).build());
        BaseTest.setUp().pressKey(new AltPressKeyParams.Builder(AltKeyCode.UpArrow).build());
        BaseTest.setUp().pressKey(new AltPressKeyParams.Builder(AltKeyCode.UpArrow).build());       
  //      gamePlayPage.getPauseButton();
    //    gamePlayPage.getCharacter();
    //    Assert.assertTrue(gamePlayPage.isDisplayed());
    }

	@Test(description="Verify Pause and Resume feature",priority=1)
	@FrameworkAnnotations(author="Mandeep", category=CategoryType.SMOKE, baseType=TestType.DESKTOP)
    public void testGameCanBePausedAndResumed(){
        mainMenuPage.pressRun();
        gamePlayPage.getCharacter();
        gamePlayPage.getPauseButton();
        gamePlayPage.pressPause();
        PauseResumePage.getTitle();
        PauseResumePage.getMainMenuButton();
        PauseResumePage.getResumeButton();
        Assert.assertTrue(PauseResumePage.isDisplayed());
        PauseResumePage.pressResume();
        Assert.assertTrue(gamePlayPage.isDisplayed());
    }

	@Test(description="Check game pause and stop",priority=2)
	@FrameworkAnnotations(author="Mandeep", category=CategoryType.SMOKE, baseType=TestType.DESKTOP)
    public void testGameCanBePausedAndStopped(){
        mainMenuPage.pressRun();
        gamePlayPage.getCharacter();
        gamePlayPage.getPauseButton();
        gamePlayPage.pressPause();
        PauseResumePage.getTitle();
        PauseResumePage.getMainMenuButton();
        PauseResumePage.getResumeButton();
        PauseResumePage.pressMainMenu();
        Assert.assertTrue(mainMenuPage.isDisplayed());
    }

	@Test(description="Verify if user can avoid the obstacles",priority=3)
	@FrameworkAnnotations(author="Mandeep", category=CategoryType.SMOKE, baseType=TestType.DESKTOP)
    public void testAvoidingObstacles() throws Exception {
        mainMenuPage.pressRun();
        gamePlayPage.getCharacter();
        gamePlayPage.getPauseButton();
        gamePlayPage.avoidObstacles(0);
        Assert.assertTrue(gamePlayPage.getCurrentLife()>=0);
    }

    @Test(description="Test without avoiding obstacles",priority=4)
	@FrameworkAnnotations(author="Mandeep", category=CategoryType.REGRESSION, baseType=TestType.DESKTOP)
    public void testWithoutAvoidingObstacles() throws Exception {
        mainMenuPage.pressRun();
        gamePlayPage.getCharacter();
        gamePlayPage.getPauseButton();
        float timeout = 20;
        while(timeout>0){
            try {
                getAntoherChancePage.getGameOver();
                getAntoherChancePage.getAvailableCurrency();
                getAntoherChancePage.getPremiumButton();
                getAntoherChancePage.isDisplayed();
                break;
            }catch(Exception e){
                timeout -= 1;
            }
        }
        Assert.assertTrue(getAntoherChancePage.isDisplayed());
    }
}
