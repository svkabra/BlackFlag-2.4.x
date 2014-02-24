package ATT.Selenium_FVT.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ATT.Selenium_FVT.Utilities.Browser.WebPage;
import ATT.Selenium_FVT.Utilities.Component.Constants;

public class NewAppPage extends WebPage {

	@FindBy(id = "app_name")
	private WebElement appName;

	@FindBy(id = "app_description")
	private WebElement appDescription;

	@FindBy(id = "app_callback_url")
	private WebElement oAuthUrl;

	@FindBy(name = "commit")
	private WebElement setupApplication;

	@FindBy(className = "debuttonfy")
	private WebElement orCancel;

	@FindBy(css = "div.headingsection > span.title")
	private WebElement pageHeadingNewAppPage;

	public NewAppPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openURL() {
		// TODO Auto-generated method stub

	}

	/* Method to enter App Name */
	public NewAppPage enterAppName(String inputAppName) {
		appName.sendKeys(inputAppName);
		return this;
	}

	/* Method to enter Description */
	public NewAppPage enterDescription(String inputAppDescription) {
		appDescription.sendKeys(inputAppDescription);
		return this;
	}

	/* Method to Select an API */
	public NewAppPage selectAPI(String api) {

		String stringApix = "//label[contains(text()," + "\'" + api + "\'"
				+ ")]";

		String stringForPropOfApi = driver.findElement(By.xpath(stringApix))
				.getAttribute("for");
		// System.out.println(strForPropOfAPI );

		if (!(driver.findElement(By.id(stringForPropOfApi)).getAttribute(
				"checked") == "checked")) {

			driver.findElement(By.id(stringForPropOfApi)).click();
			implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_SHORT);
		} else {
			System.out.println("API is already selected");
		}

		return this;
	}

	/* Method to enter OAuth URL */
	public NewAppPage setOAuthUrl(String InputOAuthUrl) {
		oAuthUrl.sendKeys(InputOAuthUrl);
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_SHORT);
		return this;
	}

	/* Method to click on Setup App button */
	public AppPage submitAppDetails() {
		waitForAjaxInactivity();
		setupApplication.click();
		waitForPageToLoad();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_LONG);
		return PageFactory.initElements(driver, AppPage.class);

	}

	/*
	 * Method to validate OAuth url is displayed when Consentable API is
	 * selected
	 */
	public boolean isOauthDisplayed() {
		boolean result;

		result = validateWebElementDisplayed(oAuthUrl);
		return result;
	}

	/*
	 * Method to validate OAuth url is not displayed when Non Consentable API is
	 * selected
	 */

	public boolean isOauthNotDisplayed() {
		boolean result;
		result = validateWebElementNotDisplayed(oAuthUrl);
		return result;
	}

	/*
	 * Method to validate whether error message is displayed when Title field is
	 * kept blank
	 */
	public boolean validateIfTitleisBlank() {
		boolean result = false;
		String name = appName.getText();
		if (name.isEmpty()) {
			result = driver.findElement(By.cssSelector("small.help-inline"))
					.isDisplayed();
			if (result) {
				storeVerificationResults(true,
						"Title field is blank and error message is displayed");
			} else
				storeVerificationResults(false,
						"Title field is blank but error message is not displayed");

		} else {
			storeVerificationResults(false, "Title field is not blank");
		}
		return result;
	}

	/*
	 * Method to validate whether error message is displayed when Description
	 * field is kept blank
	 */
	public boolean validateIfDescriptionIsBlank() {
		boolean result = false;
		String description = appDescription.getText();
		if (description.isEmpty()) {
			result = driver.findElement(By.cssSelector("small.help-inline"))
					.isDisplayed();
			if (result)
				storeVerificationResults(true,
						"Description field is blank and Error Message is displayed");
			else
				storeVerificationResults(false,
						"Description field is blank but error message is not displayed");

		} else {
			storeVerificationResults(false, "Description field is not blank");
		}
		return result;
	}

	/*
	 * Method to Validate Dev will land on New app creation page on clicking
	 * setup new app button
	 */
	public boolean validateNewAppPage() {
		boolean result;
		pageHeadingNewAppPage.getText();
		result = validateText(pageHeadingNewAppPage, "Setup New App");
		return result;
	}

	/* Method to click Cancel button */
	public void clickOrCancel() {
		orCancel.click();
		waitForPageToLoad();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_SHORT);
	}

	/* Method to validate canceling an app creation */
	public boolean validateOrCancel(String appName) {
		boolean result = false;
		WebElement title = driver.findElement(By.id("location_header"))
				.findElement(By.tagName("h1"));
		if (validateText(title, "My Apps")) {

			if (driver.findElements(By.linkText(appName)).size() == 0) {
				storeVerificationResults(true, "App is not created");
				result=true;
			} else {
				storeVerificationResults(false, "App is created");
			}
		}
		else {
			storeVerificationResults(false, "My Apps Page is not displayed");
		}
		return result;
	}

	/* Method to Publish test result */

	public void displayTestResult() {
		publishTestResult();
	}

}
