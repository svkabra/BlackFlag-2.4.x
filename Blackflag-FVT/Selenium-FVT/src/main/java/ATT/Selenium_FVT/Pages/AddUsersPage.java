package ATT.Selenium_FVT.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ATT.Selenium_FVT.Utilities.Browser.WebPage;
import ATT.Selenium_FVT.Utilities.Component.Constants;

public class AddUsersPage extends WebPage {

	// Page Object "Email ID" field
	@FindBy(how = How.ID, using = "emailAddresses_0")
	private WebElement EmailId;

	// Page Object "Submit" button
	@FindBy(how = How.ID, using = "submitButton")
	private WebElement Submit;

	// Page Object "Cancel" button
	@FindBy(how = How.ID, using = "cancelButton")
	private WebElement cancelButton;

	// Page Object "Yes" button
	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement Yes_Button;

	// Page Object "Organization Details" header
	 @FindBy(how=How.CSS, using="label[class=field_error][for=emailAddresses_0][generated=true]")
	private WebElement fieldErrorForEmailAddress;
	 
	public AddUsersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openURL() {
		// driver.get(Constants.APIM_HOME_URL);
		// driver.navigate().to("");
		// waitForPageToLoad();
		PageFactory.initElements(driver, this);

	}

	/* method to enter email ID */
	public AddUsersPage enterEmailId() {
		String emailId = "testuser.com";
		EmailId.click();
		EmailId.sendKeys(emailId);
		return this;
	}

	/* method to send an email invite */
	public AddUsersPage sendInvite() {
		Submit.click();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_SHORT);
		return this;
	}

	/* method to cancel sending a email invite */
	public AddUsersPage cancelInvite() {
		cancelButton.click();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_SHORT);
		return this;
	}

	/* method to click Yes button */
	public AddUsersPage clickYes() {

		Yes_Button.click();
		waitForPageToLoad();
		return this;
	}

	/* method to validate cancel button */
	public boolean validateCancelButton() {
		String titleExpected = "Manage Users";
		boolean result = validatePageTitle(titleExpected);

		if (result) {

			storeVerificationResults(true,
					"Manage User page is displayed on clicking Cancel button");

		} else {

			storeVerificationResults(false,
					"Manage User page is not displayed on clicking Cancel button");
		}
		return result;
	}

	/* method to validate error message on invalid email id */
	public boolean validateEmailIdErrorMesaage() {

		String error_message = fieldErrorForEmailAddress.getText();
		boolean result = error_message
				.equalsIgnoreCase("Must contain a valid e-mail.");
		if (result) {

			storeVerificationResults(true, "Error Message is displayed");

		} else {

			storeVerificationResults(false, "Error Message is not displayed");
		}
		return result;

	}
}
