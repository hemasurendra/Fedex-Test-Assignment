package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.TrackingModulePage;

public class TrackingModuleSteps {

    public TrackingModulePage trackingModulePage;

    @When("^he attempts to search for (.*) shipment using tracking number (\\d+) from HomePage$")
    public void searchTrackingFromHome(String userType, String trackingNumber) throws Throwable {
        trackingModulePage.searchForTrackingNumberFromHomePage(trackingNumber);
    }

    @When("^he attempts to search for (.*) shipment using tracking number (\\d+) from Search Option$")
    public void searchTrackingFromSearch(String userType, String trackingNumber) throws Throwable {
        trackingModulePage.searchForTrackingNumberFromSearch(trackingNumber);
    }

    @When("^he attempts to search for (.*) shipment using tracking number (\\d+) from MenuBar$")
    public void searchTrackingFromMenu(String userType, String trackingNumber) throws Throwable {
        trackingModulePage.searchForTrackingNumberFromMenu(trackingNumber);
    }

    @Then("^tracking error message is displayed$")
    public void tracking_error_message_is_displayed() throws Throwable {
        trackingModulePage.verifyTrackErrorMessageIsDisplayed();
    }
}
