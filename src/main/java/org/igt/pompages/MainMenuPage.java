package org.igt.pompages;

import static org.igt.enums.LogType.CONSOLEANDEXTENTINFO;
import static org.igt.reports.FrameworkLogger.log;

import org.igt.drivers.Driver;

import com.alttester.AltDriver;
import com.alttester.AltObject;
import com.alttester.Commands.FindObject.AltFindObjectsParams;
import com.alttester.Commands.FindObject.AltWaitForObjectsParams;
import com.alttester.Commands.UnityCommand.AltLoadSceneParams;

public class MainMenuPage extends BasePage {

	public AltObject storeButton;
	public AltObject leaderBoardButton;
	public AltObject settingsButton;
	public AltObject missionButton;
	public AltObject runButton;
	public AltObject characterName;
	public AltObject themeName;

	public MainMenuPage() {
		super();
	}

	public void setStoreButton() {
		AltFindObjectsParams par = new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//UICamera/Loadout/StoreButton")
				.build();
		AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(10).build();
		this.storeButton = getDriver().waitForObject(params);
	}

	public void setLeaderBoardButton() {
		AltFindObjectsParams par = new AltFindObjectsParams.Builder(AltDriver.By.NAME, "OpenLeaderboard").build();
		AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(10).build();
		this.leaderBoardButton = getDriver().waitForObject(params);
	}

	public void setSettingsButton() {
		AltFindObjectsParams par = new AltFindObjectsParams.Builder(AltDriver.By.PATH,
				"//UICamera/Loadout/SettingButton").build();
		AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(10).build();
		this.settingsButton = getDriver().waitForObject(params);
	}

	public void setMissionButton() {
		AltFindObjectsParams par = new AltFindObjectsParams.Builder(AltDriver.By.PATH,
				"//UICamera/Loadout/MissionButton").build();
		AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(10).build();
		this.missionButton = getDriver().waitForObject(params);
	}

	public void setRunButton() {
		AltFindObjectsParams par = new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//UICamera/Loadout/StartButton")
				.build();
		AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(10).build();
		this.runButton = getDriver().waitForObject(params);
	}

	public void setCharacterName() {
		AltFindObjectsParams par = new AltFindObjectsParams.Builder(AltDriver.By.PATH,
				"//UICamera/Loadout/CharZone/CharName").build();
		AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(10).build();
		this.characterName = getDriver().waitForObject(params);
		log(CONSOLEANDEXTENTINFO, "Character Name:" + characterName.getText());
	}

	public void setThemeName() {
		AltFindObjectsParams par = new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//UICamera/Loadout/ThemeZone")
				.build();
		AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(10).build();
		this.themeName = getDriver().waitForObject(params);
	}

	public void loadScene() {
		getDriver().loadScene(new AltLoadSceneParams.Builder("Main").build());
	}

	public boolean isDisplayed() {
		if (storeButton != null && leaderBoardButton != null && settingsButton != null && missionButton != null
				&& runButton != null && characterName != null && themeName != null) {
			return true;
		}
		return false;
	}

	public void pressRun() {
		log(CONSOLEANDEXTENTINFO, "Play button text is :" + runButton);
		runButton.tap();
		log(CONSOLEANDEXTENTINFO, "Play button is clicked");
	}

	public void pressStore() {
		log(CONSOLEANDEXTENTINFO, "Store menu text is :" + storeButton.getText());
		storeButton.tap();
		log(CONSOLEANDEXTENTINFO, "Store menu is opened");
	}
}
