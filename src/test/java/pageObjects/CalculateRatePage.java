package pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Siva Garjala on 13-Mar-2022
 */
public class CalculateRatePage extends BasePage {

    @FindBy(css = "input[data-e2e-id='fromGoogleAddress']")
    private WebElementFacade fromAddress;

    @FindBy(css = "input[data-e2e-id='toGoogleAddress']")
    private WebElementFacade toAddress;

    @FindBy(id="package-details__package-type")
    public WebElementFacade packageDetailsDroDown;

    @FindBy(id="package-details__weight-0")
    public WebElementFacade packageWeightText;

    @FindBy(id="e2ePackageDetailsSubmitButtonRates")
    public WebElementFacade showRatesButtons;

    @FindBy(id="rateSummary")
    public WebElementFacade rateCalculationData;

    @FindBy(xpath = "//ul[@id='e2eGoogleAddressSuggestionList']//li[1]", timeoutInSeconds="10")
    public WebElementFacade fromAddressList;

    /**
     * Method to verify if rate calculation page is loaded
     */
    @Step
    public void verifyPageIsLoaded() {
        assertThat(isElementPresent(fromAddress)).as("Verify calculate Rate page is Loaded").isTrue();
    }

    /**
     * Method to innput Origin and destination for rate calculation
     * @param from Origin city
     * @param to Destination city
     */
    @Step
    public void enterRateCalculationDetails(String from, String to){
        selectFromAddressDropdown(fromAddress,from,fromAddressList);
        isElementPresent(fromAddress);
        fromAddress.waitUntilVisible().getText();
        selectFromAddressDropdown(toAddress,to,fromAddressList);
        isElementPresent(toAddress);
        toAddress.waitUntilVisible().getText();
    }

    /**
     * Method to select address from dropdown
     * @param element
     * @param location
     * @param fromAddressList
     */
    public void selectFromAddressDropdown(WebElementFacade element, String location,WebElementFacade fromAddressList){
        withAction().sendKeys(element,location).pause(3000).build().perform();
        withTimeoutOf(5, SECONDS).waitForPresenceOf(By.xpath("//ul[@id='e2eGoogleAddressSuggestionList']//li[1]"));
        withAction().pause(3000).click(fromAddressList).build().perform();
    }

    /**
     * Method to select baggage type for rate calculation
     * @param bagType Type of baggae value from dropdown in rate calculation
     */
    @Step
    public void selectBagType(String bagType){
        waitAndClick(packageDetailsDroDown);
        selectValueFromDropDown(packageDetailsDroDown,bagType);
        sendDataToTextField(packageWeightText,"1");
        waitAndClick(showRatesButtons);
    }

    /**
     * Method to verify Rate summary is displayed as expected
     */
    @Step
    public void verifyRateCalculationDetailsAreDisplayed(){
        assertThat(isElementPresent(rateCalculationData)).as("Verify Rate calculation summary is Displayed").isTrue();
    }

}
