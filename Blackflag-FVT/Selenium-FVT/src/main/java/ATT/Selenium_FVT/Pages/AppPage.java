package ATT.Selenium_FVT.Pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ATT.Selenium_FVT.Components.ManageShortCodeTab;
import ATT.Selenium_FVT.Utilities.Browser.WebPage;
import ATT.Selenium_FVT.Utilities.Component.Constants;

public class AppPage extends WebPage {

	// Page Object "Edit Button"
	@FindBy(css = "a.myappsinfo")
	public WebElement editApp;

	// Page Object "Client ID"
	@FindBys({
			@FindBy(css = "div#content div.inner div.full header.resourceheader div.details"),
			@FindBy(xpath = "p[2]/span") })
	public WebElement clientID;

	// Page Object "Icon Key"
	@FindBy(className = "icn-key")
	public WebElement key;

	// Page Object "Icon Secret"
	@FindBy(className = "icn-secret")
	public WebElement secret;

	// Page Object "Sign Out"
	@FindBy(className = "signout")
	public WebElement sign_out;

	// Page Object "Manage Short Codes"
	@FindBy(linkText = "Manage Shortcodes")
	public WebElement manageShortCode;

	// Page Object "Comma Separated Shortcode"
	@FindBy(id = "comma_separated_shortcodes")
	public WebElement commaSeparatedShortCode;

	// Page Object "Confirmation Delet Button"
	@FindBy(id = "confirmationDeleteButton")
	public WebElement confirmDelete;

	// Page Object "Request Production Access"
	@FindBy(xpath = "//input[@value='Request Production Access']")
	public WebElement requestProductionAccess;

	// Page Object "Production button"
	@FindBy(css = "li.production > a")
	public WebElement productionButton;

	// Page Object " Sandbox API Analytics" -Hemant
	@FindBy(xpath = "//*[@id='content']/div/div[3]/section[1]/ul/li[1]/a")
	public WebElement sandBoxAPIAnalytics;

	// Page Object " API Range From Date" -Hemant
	@FindBy(id = "adv-analytics-api-form-from")
	public WebElement dateRangeFromDetail;

	// Page Object "API Range To Date" -Hemant
	@FindBy(id = "adv-analytics-api-form-to")
	public WebElement dateRangeToDetail;

	// Page Object "Done button of calender object"- Hemant
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/button[2]")
	public WebElement buttonDoneCalendar;

	// Page Object "API Export CSV" -Hemant
	@FindBy(xpath = "//*[@id='app-list']/div[1]/div/form/div[1]/span[2]/div/div/span[1]/a")
	public WebElement buttonExportCSV;

	// Page Object "API Update Button" -Hemant
	@FindBy(className = "update")
	public WebElement buttonRefreshDetail;

	// Page Object "APIs DropDown" -Hemant
	@FindBy(id = "analytics-api-form-trend")
	public WebElement dropDownAPIs;

	// Page Object "ADV Analytics" - Hemant
	@FindBy(xpath = "//*[@id='content']/div/div[3]/section[2]/ul/li[3]/a")
	public WebElement buttonADVAnalytics;

	// Page Object "All Apps Advertising Analytics Heading" - Hemant
	@FindBy(className = "title")
	public WebElement lableAppADVAnalytics;

	// Page Object "ADV Export Button" -Hemant
	@FindBy(className = "export")
	public WebElement buttonADVExport;

	// Page Object "View DropDown" -Hemant
	@FindBy(id = "analytics-api-form-view")
	public WebElement dropDownView;

	// Page Object "By DropDown" -Hemant
	@FindBy(id = "chart")
	public WebElement dropDownByChart;

	// Page Object "API Export Excel" -Hemant
	@FindBy(xpath = "//*[@id='app-list']/div[1]/div/form/div[1]/span[2]/div/div/span[2]/a")
	public WebElement buttonExportExcel;

	// Page Object "Request For Production Access"
	@FindBy(xpath = "//*[@id='content']/div/div[2]/form[1]/input")
	public WebElement requestForProductionAccessCommit;

	// Page Object "Production"
	@FindBy(xpath = "//*[@id='content']/div/div[3]/section[1]/ul/li[2]/a")
	public WebElement production;

	// Page Object "Delete Sandbox app button"
	@FindBy(xpath = "//a[contains(@class,'Sandbox myappsinfo') and contains(@original-title,'Trash')]")
	public WebElement deleteSandBoxApp;

	// Page Object "Confirmation delete button"
	@FindBy(id = "confirmationDeleteButton")
	public WebElement confirmationDeleteButton;

	// Page Object "App Details"
	@FindBy(id = "app-details")
	public WebElement appDetails;

	// Page Object "App details Header"
	@FindBy(css = "div.details_header > span.title")
	public WebElement appDetailsHeader;

	// Page Object "Alert Box Notice"
	@FindBy(css = "div.alert-box.notice")
	public WebElement alertBoxNotice;

	// Page Object "Alert Box Notice"
	@FindBy(css = "div.alert-box.warning")
	public WebElement alertBoxWarning;

	//Page Object "Details Services
	@FindBy(css = "span.details_services")
	public WebElement detailsServices;
	//
	
	// Parameterized Constructor
	public AppPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openURL() {
		// TODO Auto-generated method stub

	}

	/* method to click on Edit App page */
	public EditAppPage clickEditApp() {
		editApp.click();
		waitForPageToLoad();
		return PageFactory.initElements(driver, EditAppPage.class);

	}

	// method to click on Request for production access
	public RequestProductionAccessPage clickRequestProductionAccess() {
		requestProductionAccess.click();
		waitForPageToLoad();
		return PageFactory.initElements(driver, RequestProductionAccessPage.class);
	}

	/* method to click on Delete an App page */
	public AppPage deleteSandboxApp() {
		deleteSandBoxApp.click();
		waitForAjaxInactivity();
		confirmationDeleteButton.click();
		waitForAjaxInactivity();
		waitForPageToLoad();
		return this;
	}

	// method to get secret object
	public String getAppSecret() {
		return waitForElement(secret).getText();
	}

	// method to return key object
	public String getAppKey() {
		return waitForElement(key).getText();

	}

	// method to get production access
	public AppPage requestForProductionAccess() {
		requestProductionAccess.click();
		waitForPageToLoad();
		requestForProductionAccessCommit.click();
		waitForPageToLoad();
		production.click();
		waitForPageToLoad();
		return this;
	}

	//method to click on manage short codes
	public ManageShortCodeTab selectManageShortCodeTab() {
		manageShortCode.click();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_LONG);
		return new ManageShortCodeTab(driver, manageShortCode);
	}

	/*
	 * Method to validate that Added API via Edit App page is successfully
	 * displayed on App detail page
	 */
	public boolean valaidateIsApiEdited(String api) {

		boolean result = false;
		List<WebElement> myApi = driver.findElements(By
				.cssSelector("span.details_services"));
		String s = myApi.get(0).getText();
		if (s.contains(api.toUpperCase())) {
			storeVerificationResults(true, "API - " + api + " Added");
			result = true;
		} else {
			storeVerificationResults(false, "API - " + api + " not Added");
		}

		return result;

	}

	// method to check if App is promoted to Production or not.
	public boolean validateProdAccess() {
		boolean result = false;
		if (productionButton.isDisplayed()) {
			productionButton.click();
			waitForPageToLoad();

			if (appDetails.isDisplayed()) {

				storeVerificationResults(true, "App is promoted to Production");
				result = true;

			} else {
				storeVerificationResults(false,
						"There was some error while Promoting app to Production");
			}

		} else {
			storeVerificationResults(false,
					"There was some error while Promoting app to Production");
		}

		return result;
	}

	/* Method to Validate App Creation */
	public boolean validateAppCreation(String appname) {

		boolean result = false;
		String name = appDetailsHeader.getText();
		String successMsg = alertBoxNotice.getText();

		if (successMsg.contains(Constants.APP_CREATION_SUCCESS_MESSAGE)
				&& name.equalsIgnoreCase(appname)) {

			storeVerificationResults(true, "App Successfully Created");
			result = true;

		} else {
			storeVerificationResults(false, "App is not created");
		}
		return result;
	}

	/* Method to Validate App Creation for Advertising */
	public boolean validateAppCreationForAdvertising(String appname) {
		boolean result = false;
		String name = appDetailsHeader.getText();
		String successMsg = alertBoxWarning.getText();
		if (successMsg.contains(Constants.APP_CREATION_MESSAGE_FOR_ADVERTISING)
				&& name.equalsIgnoreCase(appname)) {
			storeVerificationResults(true, "App Successfully Created");
			result = true;
		} else {
			storeVerificationResults(false, "App is not created");
		}
		return result;
	}

	/*
	 * Method to validate that Added API via Edit App page is successfully
	 * displayed on App detail page
	 */
	public boolean validateIsApiAdded(String api) {
		boolean result = false;
		List<WebElement> myApi = driver.findElements(By
				.cssSelector(""));
		String s = myApi.get(0).getText();

		if (s.contains(api.toUpperCase())) {
			storeVerificationResults(true, "API - " + api + " Added");
			result = true;
		} else {
			storeVerificationResults(false, "API - " + api + " not Added");
		}

		return result;
	}

	/* Method to Publish test result */

	public void displayTestResult() {
		publishTestResult();
	}

		public void printResult() {
		publishTestResult();

	}

	// Procedure to wait for specified milliseconds
	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	// Function to Click on Sandbox Tab or Production Tab based on selection-
	// Heamnt
	// ***********************************************************************************************************************************
	public boolean fnSelectSandboxProdTabAppDetails(String sTabName) {

		if (driver.findElement(By.linkText(sTabName)).isDisplayed()) {
			driver.findElement(By.linkText(sTabName)).click();
			waitForPageToLoad();
			System.out.println("The tab  " + sTabName + " has been selected");
			storeVerificationResults(true, "The tab  " + sTabName
					+ " has been selected");
			return true;
		} else {
			System.out.println("The tab  " + sTabName + "does not exists");
			storeVerificationResults(false, "The tab  " + sTabName
					+ "does not exists");
			return false;
		}
	}

	// Function to Click on any link - Hemant
	// ***********************************************************************************************************************************
	public boolean fnClickOnSpecifiedLink(String sLinkName) {

		if (driver.findElements(By.linkText(sLinkName)).size() > 1
				&& driver.findElement(By.linkText(sLinkName)).isDisplayed()) {
			driver.findElement(By.linkText(sLinkName)).click();
			waitForPageToLoad();
			System.out.println("The tab  " + sLinkName + " has been selected");
			return true;
		} else {
			System.out.println("The tab  " + sLinkName + "does not exists");
			return false;
		}

	}

	// Function to Export the export.csv to Temp folder-Hemant
	// ***********************************************************************************************************************************
	public void fnExportcsv(String filePathString) {
		buttonExportCSV.click();

		// wait for the file to get created
		File f = new File(filePathString);
		f = new File(filePathString);
		int iw;
		iw = 0;
		while (!f.exists() && iw < 10) {
			System.out.println("waiting ");
			wait(2000);
			iw = iw + 1;
		}

		if (f.exists()) {
			System.out.println("file is created");
		} else {
			System.out.println("file not exists");
		}

	}

	// ***********************************************************************************************************************************

	// Function to Click Sandbox API Analytics- Hemant
	// ***********************************************************************************************************************************
	public boolean fnClickOnSandAPIAnalytics() {

		if (sandBoxAPIAnalytics.isDisplayed()) {
			sandBoxAPIAnalytics.click();
			wait(5000);
			System.out.println("Sanbox API Analytics has been clicked");
			return true;
		} else {
			System.out.println("The Sandbox Analytics tab does not exists");
			return false;
		}
	}

	// ***********************************************************************************************************************************

	// Function to select From Date from Range -Hemant
	// ***********************************************************************************************************************************
	public void fnSetFROMDateAppDetail(String sDate) {

		try {
			dateRangeFromDetail.clear();
			dateRangeFromDetail.sendKeys(sDate);

			if (buttonDoneCalendar.isDisplayed()) {
				buttonDoneCalendar.click();
			}
			wait(2000);
			System.out.println("From date has been selected");
			storeVerificationResults(true, "From date has been selected");

		} catch (Exception e) {
			e.printStackTrace();
			storeVerificationResults(false, "Error selecting from date");
		}
	}

	// ***********************************************************************************************************************************

	// Function to select To Date from Range -Hemant
	// ***********************************************************************************************************************************
	public void fnSetTODateAppDetail(String sDate) {

		try {
			dateRangeToDetail.clear();
			dateRangeToDetail.sendKeys(sDate);

			if (buttonDoneCalendar.isDisplayed()) {
				buttonDoneCalendar.click();
			}
			wait(2000);
			System.out.println("To date has been selected");
			storeVerificationResults(true, "To date has been selected");
		} catch (Exception e) {
			storeVerificationResults(false, "Error selecting To date");
		}

	}

	// ***********************************************************************************************************************************

	// Function to Set the start and end date API-Hemant
	// ***********************************************************************************************************************************
	public boolean fnSetDateRangeInMyApps(String sStartDate, String sEndDate) {
		try {
			// Set the From Date in API Analytics filter

			// sDate = "8/1/2013 00:00";
			fnSetFROMDateAppDetail(sStartDate);

			// Set the To Date in API Analytics filter
			// sDate = "9/1/2013 00:00";
			fnSetTODateAppDetail(sEndDate);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			storeVerificationResults(false, "Date Range set error");
			return false;
		}
	}

	// ***********************************************************************************************************************************

	// Function to Click on Refresh/Update -Hemant
	// ***********************************************************************************************************************************
	public void fnClickRefresh() {

		try {
			// Click on Refresh Button
			buttonRefreshDetail.click();
			int i;
			i = 0;
			while (i < 5) {
				// System.out.println("Wait for trend");
				wait(2000);
				i = i + 1;
				storeVerificationResults(true,
						"Successfully clicked on Refresh");
			}

		} catch (Exception e) {
			e.printStackTrace();
			storeVerificationResults(false, "Error on click Refresh");
		}
	}

	// ***********************************************************************************************************************************

	// Function to select API from API dropdown-Hemant
	// ***********************************************************************************************************************************
	public void fnSetAPI(String sAPI) {

		try {

			Select s = new Select(dropDownAPIs);
			s.selectByValue(sAPI);

			dropDownAPIs.sendKeys(sAPI);

		} catch (Exception e) {

			e.printStackTrace();
			System.exit(0);
		}

	}

	// ***********************************************************************************************************************************

	// Function to select Duration from View dropdown-Hemant
	// ***********************************************************************************************************************************
	public void fnSetView(String sView) {
		Select s = new Select(dropDownView);
		s.selectByValue(sView);
	}

	// ***********************************************************************************************************************************

	// Function to select Daily, hourly from By dropdown-Hemant
	// ***********************************************************************************************************************************
	public void fnSetBy(String sBy) {
		Select s = new Select(dropDownByChart);
		s.selectByValue(sBy);
	}

	// ***********************************************************************************************************************************

	// Function to click on ADV_Analytics link on App Details page and verify
	// before and after clicking -Hemant-
	// ***********************************************************************************************************************************
	public void clkADVAnalyticsAlreadyCollapsed() {

		// Verify Analytics is collapsed

		boolean flagPresent = validateWebElementPresentBy(By.className("title"));
		if (flagPresent) {

			boolean x = lableAppADVAnalytics.isDisplayed();
			if (!x) {
				System.out.println("Pass - ADV-Analytics is collapsed");
				storeVerificationResults(false, "ADV-Analytics is collapsed");
			} else {
				System.out.println("Fail - ADV-Analytics is not collapsed");
				storeVerificationResults(false,
						"ADV-Analytics is not collapsed");
			}
		} else {
			storeVerificationResults(false,
					"Advertising Analytics Title is not visible");
		}

		// Click on ADV Analytics

		buttonADVAnalytics.click();

		// wait till data not displayed
		int i;
		i = 0;
		while (i < 5) {
			// System.out.println("Wait for trend");
			wait(2000);
			i = i + 1;
		}

		// Verify Analytics is expanded
		flagPresent = validateWebElementPresentBy(By.className("title"));
		if (flagPresent) {
			boolean y = lableAppADVAnalytics.isDisplayed();
			if (y) {
				System.out.println("Pass - ADV-Analytics is expanded");
				storeVerificationResults(true, "ADV-Analytics is expanded");
			} else {
				System.out.println("Fail - ADV-Analytics is not expanded");
				storeVerificationResults(false, "ADV-Analytics is not expanded");
			}
		}
	}

	// ***********************************************************************************************************************************

	// Function to check ADV_Analytics link is NOT displayed-Hemant-
	// ***********************************************************************************************************************************
	public void clkADVAnalyticsLinkNotDisplayed() {
		int size = driver
				.findElements(
						By.xpath("//*[@id='content']/div/div[3]/section[2]/ul/li[3]/a"))
				.size();

		if (size == 1) {

			if (driver
					.findElement(
							By.xpath("//*[@id='content']/div/div[3]/section[2]/ul/li[3]/a"))
					.isDisplayed()) {
				storeVerificationResults(false,
						"Advertising Analytics Link is visible");
			} else {
				storeVerificationResults(true,
						"Advertising Analytics Link is NOT visible");
			}

		} else {
			storeVerificationResults(true,
					"Advertising Analytics Link is NOT visible");
		}
	}

	// ***********************************************************************************************************************************

	// Function to check ADV_Analytics link is displayed-Hemant-
	// ***********************************************************************************************************************************
	public void clkADVAnalyticsLinkDisplayed() {

		int size = driver
				.findElements(
						By.xpath("//*[@id='content']/div/div[3]/section[2]/ul/li[3]/a"))
				.size();

		if (size == 1) {

			if (driver
					.findElement(
							By.xpath("//*[@id='content']/div/div[3]/section[2]/ul/li[3]/a"))
					.isDisplayed()) {
				storeVerificationResults(true,
						"Advertising Analytics Link is visible");
			} else {
				storeVerificationResults(false,
						"Advertising Analytics Link is NOT visible");
			}

		} else {
			storeVerificationResults(false,
					"Advertising Analytics Link is NOT visible");
		}
	}

	// ***********************************************************************************************************************************

	// Function to Export the export.xlsx to Temp folder for Advertising-Hemant
	// ***********************************************************************************************************************************
	public void fnExportFileADV(String filePathString) {
		buttonADVExport.click();

		// wait for the file to get created
		File f = new File(filePathString);
		f = new File(filePathString);
		int iw;
		iw = 0;
		while (!f.exists() && iw < 10) {
			System.out.println("waiting ");
			wait(2000);
			iw = iw + 1;
		}

		if (f.exists()) {
			System.out.println("file is created");
		} else {
			System.out.println("file not exists");
		}

	}

	// ***********************************************************************************************************************************

	// Function to Export the export.xlsx to Temp folder-Hemant
	// ***********************************************************************************************************************************
	public void fnExportFile(String filePathString) {

		// Delete the existing export.xlsx file from Temp Folder
		// String filePathString ;
		// filePathString = "C:\\Temp\\export.xlsx";
		// DeleteFile(filePathString);

		buttonExportExcel.click();

		// wait for the file to get created
		File f = new File(filePathString);
		f = new File(filePathString);
		int iw;
		iw = 0;
		while (!f.exists() && iw < 10) {
			System.out.println("waiting ");
			wait(2000);
			iw = iw + 1;
		}

		if (f.exists()) {
			System.out.println("file is created");
		} else {
			System.out.println("file not exists");
		}

	}
	// ***********************************************************************************************************************************

}