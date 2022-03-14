package stepDefinitions;

import cucumber.api.java.en.Given;
import pageObjects.HomePage;

public class HomePageSteps {

    public HomePage homePage;

    @Given("^A user is accessing Fedex portal$")
    public void accessPortal() throws Throwable {
        homePage.open();
        homePage.isPageLoaded();
        homePage.acceptCookiesOnHomePage();
    }
}
