package pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Siva Garjala on 13-Mar-2022
 */
@DefaultUrl("/home.html")
public class HomePage extends BasePage {

    @FindBy(xpath="//button[contains(text(),'ACCEPT ALL COOKIES')]")
    private WebElementFacade acceptCookiesBtn;

    @FindBy(id="btnSingleTrack")
    private WebElementFacade trackingBtn;

    @FindBy(css="a[data-analytics='link|GEO-EN-GB']")
    private WebElementFacade selectCountry;

    @FindBy(css="li[data-analytics='hero|cube|RATE & SHIP'] .fxg-cube__content")
    private WebElementFacade rateCalculationHeaderMenu;

    private void acceptCookies(){
        if(isElementPresent(acceptCookiesBtn))
            acceptCookiesBtn.click();
    }

    private void selectCountryOnHomePage(){
        waitAndClick(selectCountry);
    }

    /**
     * Method to verify Home page is loaded
     * @return loaded statys
     */
    @Step
    public void isPageLoaded(){
        assertThat(isElementPresent(trackingBtn)).as("Verify Home Page is Loaded").isTrue();
    }

    /**
     * Method to verify cookies on home page
     */
    @Step
    public void acceptCookiesOnHomePage(){
        selectCountryOnHomePage();
        acceptCookies();
    }

    /**
     * Method to navigate to rate calculation form
     */
    @Step
    public void navigateToRateCalculation(){
        waitAndClick(rateCalculationHeaderMenu);
    }


}
