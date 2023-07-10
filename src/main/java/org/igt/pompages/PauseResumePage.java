package org.igt.pompages;

import static org.igt.enums.LogType.CONSOLEANDEXTENTINFO;
import static org.igt.reports.FrameworkLogger.log;

import org.igt.drivers.Driver;

import com.alttester.AltDriver;
import com.alttester.AltObject;
import com.alttester.Commands.FindObject.AltFindObjectsParams;
import com.alttester.Commands.FindObject.AltWaitForObjectsParams;

public class PauseResumePage extends BasePage{

    public AltObject resumeButton;
    public AltObject mainMenuButton;
    public AltObject title;

    public PauseResumePage() {
        super();
    }

    public void getResumeButton(){
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Game/PauseMenu/Resume").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        this.resumeButton = getDriver().waitForObject(params);
    }

    public void getMainMenuButton(){
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Game/PauseMenu/Exit").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        this.mainMenuButton = getDriver().waitForObject(params);
    }

    public void getTitle(){
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Game/PauseMenu/Text").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        this.title = getDriver().waitForObject(params);
        log(CONSOLEANDEXTENTINFO, "Title of the element is :"+ title.getText());
    }

    public boolean isDisplayed(){
        if(resumeButton != null && mainMenuButton != null && title != null){
            return true;
        }
        return false;
    }

    public void pressResume(){
        resumeButton.tap();
        log(CONSOLEANDEXTENTINFO, "Game is resumed");
    }

    public void pressMainMenu(){
        mainMenuButton.tap();
        log(CONSOLEANDEXTENTINFO, "Main menu is clicked");
    }
}
