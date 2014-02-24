package ATT.Selenium_FVT.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ATT.Selenium_FVT.Utilities.Browser.WebPage;
import ATT.Selenium_FVT.Utilities.Component.Constants;
import ATT.Selenium_FVT.Utilities.Component.PageTitleConstant;

public class CommunityProfilePage extends WebPage {

	/* Parameterized Constructor */
	public CommunityProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Page Object "Company Name" header
	@FindBy(how = How.ID, using = "text_company")
	private WebElement companyName;

	// Page Object "Job Title" header
	@FindBy(how = How.ID, using = "text_jobtitle")
	private WebElement jobTitle;

	// Page Object "City" header
	@FindBy(how = How.ID, using = "text_city")
	private WebElement city;

	// Page Object "State" header
	@FindBy(how = How.NAME, using = "state_dropdown")
	private WebElement state;

	// Page Object "Country" header
	@FindBy(how = How.ID, using = "country_dropdown")
	private WebElement country;

	// Page Object "Name" header
	@FindBy(how = How.ID, using = "text_name")
	private WebElement name;

	// Page Object "URL" header
	@FindBy(how = How.ID, using = "text_url")
	private WebElement url;

	// Page Object "Text Area Quotes"
	@FindBy(how = How.ID, using = "text_area_quotes")
	private WebElement favQuote;

	// Page Object "Submit"
	@FindBy(how = How.NAME, using = "submit")
	private WebElement updateInformation;

	// Page Object "View My Profile" link
	@FindBy(how = How.LINK_TEXT, using = "View my Profile")
	private WebElement viewMyProfile;

	// Page Object "My Settings" link
	@FindBy(how = How.CSS, using = "div.content > a")
	private WebElement mySettings;

	// Page Object "Upgrade To Premium Access" Button
	@FindBy(how = How.CSS, using = "div.floatRight.manageAccountItemCall > a.button > span")
	private WebElement upgradeToPremiumAccessButtonCommunityProfilePage;

	// Page Object "Company Name Validation Msg"
	@FindBy(how = How.CSS, using = "label[class=field_error][for=text_company][generated=true]")
	public WebElement CompanyNameValidationMsg;

	@FindBy(how = How.CSS, using = "label[class=field_error][for=text_jobtitle][generated=true]")
	public WebElement JobTitleValidationMsg;

	@Override
	public void openURL() {
		driver.navigate().to(Constants.APIM_HOME_URL);
		waitForPageToLoad();
		PageFactory.initElements(driver, this);

	}

	/* Method to return ApimLogin Page elements */
	public APIMLoginPage apimLoginPage() {
		waitForPageToLoad();
		return PageFactory.initElements(driver, APIMLoginPage.class);
	}

	/* Method to click ViewMyProfile */
	public ManageMyAccount clickViewMyProfile() {

		viewMyProfile.click();
		waitForPageToLoad();
		return PageFactory.initElements(driver, ManageMyAccount.class);
	}

	/* Method to check if alert pop up occurs when clicked on My Settings link */
	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	/* Method to click on MySettings Link */
	public CommunityProfilePage clickMySettingsLink() {

		mySettings.click();
		waitForPageToLoad();
		implicitWait(Constants.PAGE_WAIT_INTER_SYSTEM);
		// Below code handles pop up which occurs while navigating to My
		// settings page
		while (isAlertPresent(driver)) {
			Alert javascriptAlert = driver.switchTo().alert();
			System.out.println(javascriptAlert.getText()); // Get text on alert
															// box
			javascriptAlert.accept();
			waitForPageToLoad();
		}
		return this;
	}

	/* Method to return Elements of Manage My Account Page */
	public ManageMyAccount manageMyAccount() {
		waitForPageToLoad();
		return PageFactory.initElements(driver, ManageMyAccount.class);
	}

	/* Method to validate "Upgrade to Premium Access" Button is displayed */
	public void upgradeToPremiumAccessButtonValidation() {

		validateWebElementDisplayed(upgradeToPremiumAccessButtonCommunityProfilePage);
	}

	public CommunityProfilePage populateCompanyName() {

		companyName.sendKeys(Constants.INVALID_COMPANY_NAME);
		updateInformation.click();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_LONG);
		waitForPageToLoad();
		return this;
	}

	public CommunityProfilePage populateJobTitle() {
		jobTitle.sendKeys(Constants.INVALID_JOB_TITLE);
		updateInformation.click();
		waitForPageToLoad();
		return this;
	}

	/************* Validation Methods **********/

	/* Method to validate company name field */
	public boolean validateCompanyName() {

		String messageCaptured = CompanyNameValidationMsg.getText();

		String messageActual = "Company can not exceed 30 characters in length.";
		boolean result = messageCaptured.equalsIgnoreCase(messageActual);
		if (result) {

			storeVerificationResults(true, "Error Message is displayed");

		} else {

			storeVerificationResults(false, "Error Message is not displayed");
		}
		return result;
	}

	/* Method to validate Job Title field */
	public boolean validateJobTitle() {

		String messageCaptured = JobTitleValidationMsg.getText();

		String messageActual = "Job Title can not exceed 30 characters in length.";
		boolean result = messageCaptured.equalsIgnoreCase(messageActual);
		if (result) {

			storeVerificationResults(true, "Error Message is displayed");

		} else {

			storeVerificationResults(false, "Error Message is not displayed");
		}
		return result;
	}

	/* Method to validate My Settings Page */
	public boolean validateMySettingsPage() {
		String titleExpected = PageTitleConstant.MYSETTINGSPAGE;
		boolean result = validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}
}
