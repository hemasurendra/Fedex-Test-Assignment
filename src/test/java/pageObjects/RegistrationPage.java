package pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import utils.GetTestProperties;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Siva Garjala on 13-Mar-2022
 */
public class RegistrationPage extends BasePage {

    @FindBy(css="input[autocomplete='given-name']")
    private WebElementFacade firstNameText;

    @FindBy(css="input[autocomplete='family-name']")
    private  WebElementFacade lastNameText;

    @FindBy(id="company")
    private  WebElementFacade companyText;

    @FindBy(id="country")
    private  WebElementFacade countryText;

    @FindBy(id="address")
    private WebElementFacade addressLineOneTxt;

    @FindBy(id="additional-street-line")
    private WebElementFacade additionalStreetTxt;

    @FindBy(id="postal-code")
    private WebElementFacade postalCodeTxt;

    @FindBy(id="city")
    private WebElementFacade cityTxt;

    @FindBy(id="email")
    private WebElementFacade emailTxt;

    @FindBy(id="phone")
    private WebElementFacade phoneTxt;

    @FindBy(css="button[data-test-id='contactFormSubmitButton']")
    private WebElementFacade submitRegistrationBtn;

    @FindBy(css="button[data-test-id='signupFormSubmitButton']")
    private WebElementFacade createUserIdButton;

    @FindBy(css="button[data-test-id='accountTypeSubmitButton']")
    private WebElementFacade openMyAccountButton;

    @FindBy(id="userIdTypeOption")
    private  WebElementFacade userIdTypeRadioBtn;

    @FindBy(css="label[for='acceptPrivacyPolicyAndTermsAndConditions']")
    private  WebElementFacade acceptConditionsBtn;

    @FindBy(id="userId")
    private  WebElementFacade userIdTxt;

    @FindBy(id="password")
    private  WebElementFacade passwordTxt;

    @FindBy(id="confirmPassword")
    private  WebElementFacade confirmPasswordTxt;

    @FindBy(css="#toast-container")
    private WebElementFacade countryChangeAlert;

    GetTestProperties getTestProperties =new GetTestProperties();

    /**
     * Method to verify Registration page is loaded
     */
    public void isPageLoaded(){
        assertThat(isElementPresent(firstNameText)).as("Verify Registration page form is loaded").isTrue();
    }

    /**
     * Method to provide all the required details to complete registration
     * @param firstName
     * @param lastName
     * @param companyValue
     * @param countryValue
     * @param addressLineOneValue
     * @param addressLineStreetValue
     * @param postCodeValue
     * @param cityValue
     * @param phoneValue
     * @param emailValue
     */
    public void register(String firstName, String lastName, String companyValue, String countryValue, String addressLineOneValue, String addressLineStreetValue, String postCodeValue, String cityValue, String phoneValue, String emailValue){
        sendDataToTextField(firstNameText,firstName);
        sendDataToTextField(lastNameText,lastName);
        sendDataToTextField(companyText,companyValue);
        selectCounty(countryValue);
        sendDataToTextField(addressLineOneTxt,addressLineOneValue);
        sendDataToTextField(additionalStreetTxt,addressLineStreetValue);
        sendDataToTextField(postalCodeTxt,postCodeValue);
        sendDataToTextField(cityTxt,cityValue);
        sendDataToTextField(phoneTxt,phoneValue);
        sendDataToTextField(emailTxt,emailValue);
        submitContactDetails();
    }

    private void submitContactDetails() {
        withTimeoutOf(12, SECONDS).waitForElementsToDisappear(By.id("toast-container"));
        submitRegistrationBtn.waitUntilClickable();
        waitAndClick(submitRegistrationBtn);
    }


    private void selectCounty(String countryValue) {
        selectValueFromDropDown(countryText,countryValue);
    }

    /**
     * Method to create UserId for registered user
     * @param idValue Id of choice
     * @param passwordValue password of choice
     */
    public void createUserId(String idValue,String passwordValue){
        userIdTypeRadioBtn.waitUntilClickable().click();
        sendDataToTextField(userIdTxt,idValue);
        sendDataToTextField(passwordTxt,passwordValue);
        sendDataToTextField(confirmPasswordTxt,passwordValue);
        submitUserId();
    }

    private void submitUserId() {
        waitAndClick(acceptConditionsBtn);
        createUserIdButton.waitUntilClickable();
    }

    /**
     * Method to verify userId creation is successful
     */
    public void userIdCreationIsSuccessful(){
         assertThat(createUserIdButton.waitUntilClickable().isCurrentlyEnabled()).as("Verify Registration successful").isTrue();
    }

    /**
     * Method to register with default values based on userType
     * @param userType valid or invalid usr
     * @param userCountry country code as per drop down value
     */
    public void defaultRegister(String userType, String userCountry){
        register(getTestProperties.getValue(userType+"firstName"),getTestProperties.getValue(userType+"lastName"),getTestProperties.getValue("company"),userCountry,getTestProperties.getValue("address"),getTestProperties.getValue("addressStreet"),getTestProperties.getValue("postalCode"),getTestProperties.getValue("city"),getTestProperties.getValue(userType+"phoneNumber"),getTestProperties.getValue(userType+"email"));
    }


}
