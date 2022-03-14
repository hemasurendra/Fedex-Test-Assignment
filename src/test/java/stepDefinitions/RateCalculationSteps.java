package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CalculateRatePage;
import pageObjects.HomePage;

public class RateCalculationSteps {

    public HomePage homePage;
    public CalculateRatePage calculateRatePage;

    @And("^He attempts to calculate shipping price between (.*) and (.*) cities$")
    public void rateCalculation(String fromCity, String toCity) throws Throwable {
        homePage.navigateToRateCalculation();
        calculateRatePage.verifyPageIsLoaded();
        calculateRatePage.enterRateCalculationDetails(fromCity,toCity);
    }

    @When("^For a packaging (.*) with single package$")
    public void selectPackageType(String boxType) throws Throwable {
        calculateRatePage.selectBagType(boxType);
    }

    @Then("^Approximate rates along with delivery dates are displayed$")
    public void verifyRateSummary() throws Throwable {
        calculateRatePage.verifyRateCalculationDetailsAreDisplayed();
    }

}
