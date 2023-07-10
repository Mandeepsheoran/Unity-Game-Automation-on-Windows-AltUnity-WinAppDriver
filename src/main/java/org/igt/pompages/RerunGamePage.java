package org.igt.pompages;

import static org.igt.enums.LogType.CONSOLEANDEXTENTINFO;
import static org.igt.reports.FrameworkLogger.log;

import org.igt.drivers.Driver;

import com.alttester.AltDriver;
import com.alttester.AltObject;
import com.alttester.Commands.FindObject.AltFindObjectsParams;
import com.alttester.Commands.FindObject.AltWaitForObjectsParams;

public class RerunGamePage extends BasePage{

    public AltObject gameOverButton;
    public AltObject premiumButton;
    public AltObject availableCurrency;

    public RerunGamePage() {
        super();
    }

    public void getGameOver(){
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Game/DeathPopup/GameOver").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        this.gameOverButton = getDriver().waitForObject(params);
    }

    public void getPremiumButton(){
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Game/DeathPopup/ButtonLayout/Premium Button").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        this.premiumButton = getDriver().waitForObject(params);
    }

    public void getAvailableCurrency(){
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Game/DeathPopup/PremiumDisplay/PremiumOwnCount").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        this.availableCurrency = getDriver().waitForObject(params);
        System.out.println("Available displaying currency is :"+ availableCurrency.getText());
        log(CONSOLEANDEXTENTINFO, "Available currency with user is :"+ availableCurrency.getText());
    }

    public boolean isDisplayed(){
        if(gameOverButton != null && premiumButton != null && availableCurrency != null)
            return true;
        return false;
    }

    public void pressGameOver(){
    	log(CONSOLEANDEXTENTINFO, "Game over!");
        gameOverButton.tap();
        log(CONSOLEANDEXTENTINFO, "Final score is displaying along with highest score");
    }

    public void pressPremiumBotton(){
        premiumButton.tap();
        log(CONSOLEANDEXTENTINFO, "Premium shop popup is opened.");
    }
}
