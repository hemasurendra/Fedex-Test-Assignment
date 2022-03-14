package pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import utils.GetTestProperties;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Siva Garjala on 13-Mar-2022
 */
@DefaultUrl("/login")
public class LoginPage extends BasePage {

    @FindBy(id="userId")
    private WebElementFacade userIdInput;

    @FindBy(id="login-btn")
    private WebElementFacade loginBtn;

    @FindBy(id="password")
    private WebElementFacade passwordInput;

    @FindBy(id="fxg-dropdown-signIn")
    private WebElementFacade signUpBtn;

    @FindBy(id="invalidCredentials")
    private WebElementFacade errorForInvalidCredentials;

    @FindBy(css="a[data-analytics='link|Log In']")
    private WebElementFacade loginFromDropDown;

    @FindBy(css="a[title='OPEN A PERSONAL ACCOUNT']")
    private WebElementFacade openPersonalAccountBtn;


    @FindBy(xpath="//div[@class='fdx-utilityWrap']//a[@data-analytics='link|Open an Account']")
    private  WebElementFacade openAccountDropDown;

    private void clickSignUpButton(){
        waitAndClick(signUpBtn);
    }

    private  void  clickLoginFromDropDown(){
        waitAndClick(loginFromDropDown);
    }

    private void clickOnOpenAccountFromDropDown(){
        waitAndClick(openAccountDropDown);
    }

    private void clickOpenPersonalAccountButton(){
        waitAndClick(openPersonalAccountBtn);
    }

    public void isLoginFormLoaded(){
        assertThat(isElementPresent(loginBtn)).as("Verify login page is loaded").isTrue();
    }

    /**
     * Method to navigate to login form
     */
    @Step
    public void navigateToLoginForm(){
        clickSignUpButton();
        clickLoginFromDropDown();
    }

    /**
     * Method to navigate to Registration form
     */
    public void navigateToRegistrationForm(){
        clickSignUpButton();
        clickOnOpenAccountFromDropDown();
        clickOpenPersonalAccountButton();
    }

    /**
     * Method to login using data supplied in config file
     */
    public void login() {
        sendDataToTextField(userIdInput, GetTestProperties.getValue("username"));
        sendDataToTextField(passwordInput, GetTestProperties.getValue("password"));
        waitAndClick(loginBtn);
    }

    /**
     * Method to login using provided login details
     * @param useId
     * @param password
     */
    public void login(String useId, String password) {
        sendDataToTextField(userIdInput, useId);
        sendDataToTextField(passwordInput, password);
        waitAndClick(loginBtn);
    }

    /**
     * Method to verify if user moved out of login page
     */
    public void assertLoginPageDisappeared(){
        assertThat(loginBtn.waitUntilNotVisible().isVisible()).as("Verify login page is disappeared").isFalse();
    }

    /**
     * Method to verify errors on Login Form
     */
    public void verifyErrorOnLoginPage(){
        assertThat(isElementPresent(errorForInvalidCredentials)).as("Verify error on login page").isTrue();
    }

}
