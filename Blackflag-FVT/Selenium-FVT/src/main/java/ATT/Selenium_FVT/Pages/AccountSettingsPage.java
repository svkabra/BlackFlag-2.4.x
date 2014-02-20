package ATT.Selenium_FVT.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ATT.Selenium_FVT.Utilities.Browser.WebPage;

public class AccountSettingsPage extends WebPage {

	// Page Object "Organization Details" header
	 @FindBy(how=How.CSS, using="label[class=field_error][for=text_current_password][generated=true]")
	private WebElement fieldErrorForCurrentPassword;
	 	 
	 @FindBy(how=How.CSS, using="label[class=field_error][for=text_verify_password][generated=true]")
	private WebElement fieldErrorForVerifyPassword;
	 
	// Page Object "Organization Details" header
	@FindBy(how = How.ID, using = "text_email")
	private WebElement Email;

	// Page Object "Organization Details" header
	@FindBy(how = How.ID, using = "text_verify_email")
	private WebElement VerifyEmail;

	// Page Object "Organization Details" header
	@FindBy(how = How.ID, using = "text_company")
	private WebElement Company;

	// Page Object "Organization Details" header
	@FindBy(how = How.NAME, using = "job_function_dropdown")
	private WebElement JobFunction;

	// Page Object "Organization Details" header
	@FindBy(how = How.NAME, using = "industry_dropdown")
	private WebElement Industry;

	// Page Object "Organization Details" header
	@FindBy(how = How.ID, using = "text_current_password")
	private WebElement Password;

	// Page Object "Organization Details" header
	@FindBy(how = How.ID, using = "text_new_password")
	private WebElement NewPassword;

	// Page Object "Organization Details" header
	@FindBy(how = How.NAME, using = "updateButton")
	private WebElement UpdateButton;

	// Page Object "Organization Details" header
	@FindBy(how = How.NAME, using = "text_verify_password")
	private WebElement VerifyNewPassword;

	// Page Object "Organization Details" header
	 @FindBy(how=How.CSS, using="div.floatRight.manageAccountItemCall > a.button > span")
	 private WebElement upgradeToPremiumAccessButtonAccoutsPage;

	/*
	 * AccountSettings constructor
	 */
	public AccountSettingsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openURL() {
		// driver.get(APIM_URL);
		//driver.navigate().to(Constants.APIM_HOME_URL);
		waitForPageToLoad();
		PageFactory.initElements(driver, this);

	}
	
	/*
	 * method to enter wrong password
	 */
	public AccountSettingsPage enterWrongPassword(){
		Password.sendKeys("aaaaaaaaa123456789012345");
		UpdateButton.click();
		waitForPageToLoad();
		return this;
	}
	

	/*
	 *  method to validate password field 
	 */
	public boolean validatePasswordField() {

		String messageActual = "Current Password can not exceed 14 characters in length.";
		boolean result = messageActual.equals(fieldErrorForCurrentPassword.getText());
		if (result) {

			storeVerificationResults(true, "Error Message is displayed");

		} else {

			storeVerificationResults(false, "Error Message is not displayed");
		}
		
		return result;
	}
	
	/*
	 * method to enter wrong Verify New Password
	 */
	
	public AccountSettingsPage enterWrongVerifyPassword(){
		Password.sendKeys("Abcd1234");
		implicitWait(1);
		NewPassword.sendKeys("ABcd1234");
		implicitWait(1);
		VerifyNewPassword.sendKeys("AAAAA4666456356AAAA");
		implicitWait(1);
		UpdateButton.click();
		waitForPageToLoad();
		
		return this;
	}

	/*********************** Validation methods****************************/
	/*
	 * method to validate password field
	 */
	public boolean validateVerifyPasswordField() {

			
		String messageActual = "Verify Password can not exceed 14 characters in length.";

		boolean result = messageActual.equals(fieldErrorForVerifyPassword.getText());
		if (result) {

			storeVerificationResults(true, "Error Message is displayed");

		} else {

			storeVerificationResults(false, "Error Message is not displayed");
		}
		
		return result;
	}

	/*
	 * method to validate "Upgrade to Premium Access" Button is displayed
	 */
	public boolean upgradeToPremiumAccessButtonValidation() {
		boolean result=false;
		if(validateWebElementDisplayed(upgradeToPremiumAccessButtonAccoutsPage)){
			result=true;
		}
		return result;
	}

	
	/*
	 * method to validate Job Function Dropdown
	 */
	public boolean validateJobFunction() {
		boolean result=false;
		if(validateWebElementDisplayed(JobFunction)){
		if(validateWebElementEnabled(JobFunction)){
			result=true;
		}
		}
		return result;
	}

	/*
	 * method to validate Industry Dropdown
	 */
	public boolean validateIndustry() {
		boolean result=false;
		if(validateWebElementDisplayed(Industry)){
			if(validateWebElementEnabled(Industry)){
				result=true;
			}
		}
		return result;
	}

	/*
	 * method to validate company name
	 */
	public boolean validateCompanyName() {
		boolean result = false;
		if (validateWebElementDisplayed(Company)) {
			if (validateWebElementPrepopulated(Company)) {
				result = validateWebElementDisabled(Company);
			}
		}
		return result;
	}

	/*
	 * method to validate email field is pre populated and enabled
	 */
	public boolean emailFieldvalidation() {
		
		boolean result = false;
		if (validateWebElementDisplayed(Email)) {
			if (validateWebElementPrepopulated(Email)) {
				result = validateWebElementEnabled(Email);
			}
		}
		return result;		
	}
	
	
	/*
	 * method to validate Verify Email field is pre populated and enabled
	 */
	public boolean verifyEmailFieldvalidation() {
		
		boolean result = false;
		if (validateWebElementDisplayed(VerifyEmail)) {
			if (validateWebElementPrepopulated(VerifyEmail)) {
				result = validateWebElementEnabled(VerifyEmail);
			}
		}
		return result;	
		
	}
	
}
