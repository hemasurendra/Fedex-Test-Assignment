package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

public class LoginPageSteps {

    public LoginPage loginPage;
    public RegistrationPage registrationPage;

    @When("^He attempts to login using (.*) (.*) and (.*)$")
    public void login(String userType,String userName, String password) throws Throwable {
        loginPage.navigateToLoginForm();
        loginPage.isLoginFormLoaded();
        loginPage.login(userName,password);
    }

    @Then("^user login (.*) successful$")
    public void verifyLogin(String loginStatus) throws Throwable {
        if("is".equalsIgnoreCase(loginStatus))
            loginPage.assertLoginPageDisappeared();
        else
            loginPage.verifyErrorOnLoginPage();
    }

    @When("^he attempts register with (.*) details for (.*)$")
    public void userRegistration(String userType, String countryCode) throws Throwable {
        loginPage.navigateToRegistrationForm();
        registrationPage.isPageLoaded();
        registrationPage.defaultRegister(userType,countryCode);
    }

    @When("^user (.*) successfully registered$")
    public void userRegistrationVerification(String registrationStatus) throws Throwable {
        if("is".equalsIgnoreCase(registrationStatus))
            registrationPage.userIdCreationIsSuccessful();
        else
            registrationPage.isPageLoaded();
    }

}
