package pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Siva Garjala on 13-Mar-2022
 */
public class TrackingModulePage extends BasePage {


    @FindBy(css=".notification__message")
    private WebElementFacade trackErrorMessage;

    @FindBy(css="input[name='trackingnumber']")
    private WebElementFacade trackingNumberTxt;

    @FindBy(id = "btnSingleTrack")
    private WebElementFacade trackingBtn;

    @FindBy(css=".fxg-mouse img[alt='Search']")
    private WebElementFacade searchIcon;

    @FindBy(id="fxg-search-text")
    public  WebElementFacade trackingNumberSearchTxt;

    @FindBy(id="fxg-search-icon")
    public  WebElementFacade searchTrackingNumber;

    @FindBy(css="a[data-analytics='hdr|tab|2|Tracking']")
    public  WebElementFacade trackingMenuOption;

    @FindBy(id="trackingModuleTrackingNum")
    public WebElementFacade TrackingNumberMenuText;

    @FindBy(css="button[data-analytics='hdr|tab2|Track']")
    public WebElementFacade searchTrackingMenuOption;

    /**
     * Method for tracking the shipment from tracking option on Home page
     * @param trackingNumber
     */
    public void searchForTrackingNumberFromHomePage(String trackingNumber){
        sendDataToTextField(trackingNumberTxt,trackingNumber);
        waitAndClick(trackingBtn);
    }

    /**
     * Method for tracking the shipment from tracking option on from search option in top right corner
     * @param trackingNumber
     */
    public void searchForTrackingNumberFromSearch(String trackingNumber){
        waitAndClick(searchIcon);
        sendDataToTextField(trackingNumberSearchTxt,trackingNumber);
        waitAndClick(searchTrackingNumber);
    }

    /**
     * Method for tracking the shipment from tracking option on menu option under tracking menu
     * @param trackingNumber
     */
    public void searchForTrackingNumberFromMenu(String trackingNumber){
        waitAndClick(trackingMenuOption);
        sendDataToTextField(TrackingNumberMenuText,trackingNumber);
        waitAndClick(searchTrackingMenuOption);
    }

    /**
     * Method to verify error on tracking Id
     */
    public void verifyTrackErrorMessageIsDisplayed(){
         assertThat(isElementPresent(trackErrorMessage)).as("Tracking error Message is Displayed").isTrue();
    }


}
