package org.igt.pompages;

import static org.igt.enums.LogType.CONSOLEANDEXTENTINFO;
import static org.igt.reports.FrameworkLogger.log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alttester.AltDriver;
import com.alttester.AltObject;
import com.alttester.Commands.FindObject.AltFindObjectsParams;
import com.alttester.Commands.FindObject.AltWaitForObjectsParams;
import com.alttester.Commands.UnityCommand.AltLoadSceneParams;

public class StorePage extends BasePage {

    public AltObject storeTitle;
    public AltObject itemsButton;
    public AltObject charactersButton;
    public AltObject accessoriesButton;
    public AltObject themesButton;
    public AltObject premiumButton;
    public AltObject coinSection;
    public AltObject closeButton;
    public AltObject premiumPopup;
    public AltObject closePremiumPopup;

    public StorePage() {
        super();
    }

    public void loadScene(){
        getDriver().loadScene(new AltLoadSceneParams.Builder("Shop").build());
    }

    public void getStoreTitle() {
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Background/StoreTitle").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        storeTitle = getDriver().waitForObject(params);
        System.out.println("User's final score is : "+ storeTitle.getText());
    }

    public void getItemsButton() {
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Background/TabsSwitch/Item").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        itemsButton = getDriver().waitForObject(params);
    }

    public void getCharactersButton() {
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Background/TabsSwitch/Character").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        charactersButton = getDriver().waitForObject(params);
    }

    public void getAccessoriesButton() {
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Background/TabsSwitch/Accesories").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        accessoriesButton = getDriver().waitForObject(params);
    }

    public void getThemesButton() {
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Background/TabsSwitch/Themes").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        themesButton = getDriver().waitForObject(params);
    }

    public void getPremiumButton() {
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Background/Premium/Button").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        premiumButton = getDriver().waitForObject(params);
    }

    public void getCoinSection() {
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Background/Premium").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        coinSection = getDriver().waitForObject(params);
    }

    public void getCloseButton() {
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Background/Button").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        closeButton = getDriver().waitForObject(params);
    }

    public boolean isDisplayedCorrectly(){
        if(storeTitle != null && itemsButton != null && charactersButton != null && accessoriesButton != null && themesButton != null && premiumButton != null && coinSection != null && closeButton != null){
            return true;
        }
        return false;
    }

    public Integer getShopItemCount(int itemIndex){

        AltFindObjectsParams params = new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Icon/Count").build();
        List<AltObject> shopItemsCounts = new ArrayList<>(Arrays.asList(getDriver().findObjectsWhichContain(params)));

        return Integer.parseInt(shopItemsCounts.get(itemIndex).getText());
    }

    public void clickBuyButton(int index){
        AltFindObjectsParams params = new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//NamePriceButtonZone/PriceButtonZone/BuyButton").build();
        List<AltObject> itemsBuyButtons = new ArrayList<>(Arrays.asList(getDriver().findObjectsWhichContain(params)));
        itemsBuyButtons.get(index).tap();
        log(CONSOLEANDEXTENTINFO, "Buy button is clicked");
    }

    public void getPopup(){
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Background/IAPPopup").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        premiumPopup = getDriver().waitForObject(params);
    }

    public void getClosePopupButton(){
        AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Background/IAPPopup/Image/Close").build();
        AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
        closePremiumPopup = getDriver().waitForObject(params);
    }

    public void pressPremiumPopUp(){
        premiumButton.tap();
        log(CONSOLEANDEXTENTINFO, "Premium shop popup is opened.");
    }

    public void pressClosePremiumPopup(){
        closePremiumPopup.tap();
        log(CONSOLEANDEXTENTINFO, "Premium shop popup is closed.");
    }

    public boolean checkPopupOpen(){
        try{
            AltFindObjectsParams par=new AltFindObjectsParams.Builder(AltDriver.By.PATH, "//Background/IAPPopup").build();
            AltWaitForObjectsParams params = new AltWaitForObjectsParams.Builder(par).withTimeout(2).build();
            premiumPopup = getDriver().waitForObject(params);
            return true;

        }catch(Exception e){
            return false;
        }
    }

    public void pressClose(){
        closeButton.tap();
    }
}
