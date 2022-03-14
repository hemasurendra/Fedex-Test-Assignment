package pageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Siva Garjala on 13-Mar-2022
 */
public class BasePage extends PageObject {

    public void waitAndClick(WebElementFacade webElementFacade){
        webElementFacade.waitUntilVisible().then().click();
    }

    public boolean isElementPresent(WebElementFacade webElementFacade){
        try{
            return webElementFacade.withTimeoutOf(30, SECONDS).waitUntilVisible().isVisible();
        }catch (Exception e){
            return false;
        }
    }

    public void sendDataToTextField(WebElementFacade webElementFacade,String data){
        webElementFacade.waitUntilVisible().then().sendKeys(data);
    }

    public void selectValueFromDropDown(WebElementFacade webElementFacade, String data){
        webElementFacade.selectByValue(data);
    }

}
