package ATT.Selenium_FVT.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ATT.Selenium_FVT.Utilities.Browser.WebPage;
import ATT.Selenium_FVT.Utilities.Component.Constants;

public class EditAppPage extends WebPage {

	// Page Object "App Name"
	@FindBy(id = "app_name")
	private WebElement app_Name;

	// Page Object "Speech"
	@FindBy(id = "app_service_ids_14")
	private WebElement speech;

	// Page Object "App Description"
	@FindBy(id = "app_description")
	private WebElement app_description;

	// Page Object "STTC"
	@FindBy(id = "app_service_ids_21")
	private WebElement STTC;

	// Page Object "MMS"
	@FindBy(id = "app_service_ids_1")
	private WebElement MMS;

	// Page Object "STT"
	@FindBy(id = "app_service_ids_25")
	private WebElement STT;

	// Page Object "MIM"
	@FindBy(id = "app_service_ids_23")
	private WebElement MIM;

	// Page Object "SMS"
	@FindBy(id = "app_service_ids_12")
	private WebElement SMS;

	// Page Object "TTS"
	@FindBy(id = "app_service_ids_20")
	private WebElement TTS;

	// Page Object "oAuth"
	@FindBy(id = "app_service_ids_6")
	private WebElement oAuth;

	// Page Object "ADS"
	@FindBy(id = "app_service_ids_5")
	private WebElement ADS;

	// Page Object "Notary"
	@FindBy(id = "app_service_ids_2")
	private WebElement Notary;

	// Page Object "MOBO"
	@FindBy(id = "app_service_ids_15")
	private WebElement MOBO;

	// Page Object "TL"
	@FindBy(id = "app_service_ids_3")
	private WebElement TL;

	// Page Object "DC"
	@FindBy(id = "app_service_ids_7")
	private WebElement DC;

	// Page Object "Payment"
	@FindBy(id = "app_service_ids_4")
	private WebElement Payment;

	// Page Object "STTA"
	@FindBy(id = "app_service_ids_29")
	private WebElement STTA;

	// Page Object "CallBackURL"
	@FindBy(id = "app_callback_url")
	private WebElement callBackURL;

	// Page Object "Setup Application"
	@FindBy(name = "commit")
	private WebElement Setup_Application;

	// Parameterized Constructor
	public EditAppPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openURL() {
		// TODO Auto-generated method stub

	}

	// method to submit app details
	public AppPage submitAppDetails() {
		waitForAjaxInactivity();
		Setup_Application.click();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_LONG);
		waitForPageToLoad();
		return PageFactory.initElements(driver, AppPage.class);

	}

	// method to click Or Cancel App
	public AppPage clickOrCancel() {
		waitForAjaxInactivity();
		driver.findElement(By.linkText("or Cancel")).click();
		waitForPageToLoad();
		return PageFactory.initElements(driver, AppPage.class);

	}

	/* Method to Select an API */
	public EditAppPage selectAPI(String api) {

		String strAPIX = "//label[contains(text()," + "\'" + api + "\'" + ")]";

		String strForPropOfAPI = driver.findElement(By.xpath(strAPIX))
				.getAttribute("for");

		if (!(driver.findElement(By.id(strForPropOfAPI))
				.getAttribute("checked") == "checked")) {

			driver.findElement(By.id(strForPropOfAPI)).click();
		}
		return this;
	}

	// method to check if oAuth element is displayed
	public boolean validateIsOauthDisplayed() {

		boolean result = validateWebElementDisplayed(callBackURL);
		return result;
	}

	// method to check if oAuth element is not displayed
	public boolean validateIsOauthNotDisplayed() {
		boolean result = validateWebElementNotDisplayed(callBackURL);
		return result;
	}

}
