package ATT.Selenium_FVT.Pages;

import java.io.File;
import java.util.List;

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
	@FindBy(xpath="//a[@title='Advertising Analytics']") 
	public WebElement sandBoxAPIAnalytics;

	//Page Object " API Range From Date" -Hemant
	@FindBy(id="adv-analytics-api-form-from")
	public WebElement dtRangeFromDetail;

	//Page Object "API Range To Date" -Hemant
	@FindBy(id="adv-analytics-api-form-to")
	public WebElement dtRangeToDetail;

	//Page Object "Done button of calender object"
	@FindBy(xpath = "//a[@class='ui-datepicker-close']")
	public WebElement btnDoneCal;

	//Page Object "API Export CSV" 
	@FindBy(xpath="//a[contains(text(),'Export CSV')]")
	public WebElement btnExportCSV;

	//Page Object "API Update Button" -Hemant
	@FindBy(css ="div.adv-headingsection > div.right > span.btn > a.update")
	public WebElement btnRefreshDetail;


	//Page Object "APIs DropDown" -Hemant
	@FindBy(id="analytics-api-form-trend")
	public WebElement ddAPIs;


	//Page Object "ADV Analytics" - Hemant
    @FindBy(linkText ="Advertising Analytics") 
    public WebElement btnADVAnalytics;

	//Page Object "All Apps Advertising Analytics Heading" - Hemant
	@FindBy(css = "div.adv-headingsection > div.left > span.title") 
	public WebElement lblAppADVAnalytics;


	//Page Object "ADV Export Button" -Hemant
//	@FindBy(className = "export")
//	public WebElement btnADVExport;
	public boolean clickButtonExport(){
		boolean flag = false;
		String btnName = "Export";
		for(WebElement e:driver.findElements(By.xpath("//*[@class='export']"))){
			if(e.getText().equalsIgnoreCase(btnName)){
				e.click();
				flag = true;
				break;
			}		
		}
		return flag;
	}

	

	//Page Object "View DropDown" -Hemant
	@FindBy(id="analytics-api-form-view")
	public WebElement ddView;

	//Page Object "By DropDown" -Hemant
	@FindBy(id="chart")
	public WebElement ddByChart;


	//Page Object "API Export Excel"
	@FindBy(xpath="//a[@class='export']")
	public WebElement btnExportExcel;

	//Page Object "Request Production Access"
	@FindBy(css ="input[value='Request Production Access']")
	public WebElement reqForProdAccess;

	//Page Object "Commit button"
	@FindBy(xpath="//*[@name='commit']") 
	public WebElement reqForProdAccessCommit;

	@FindBy(xpath = "//*[@id='content']/div/div[2]/form[1]/input")
	public WebElement requestForProductionAccessCommit;

	//Page Object "Production"
	@FindBy(linkText = "Production") 
	public WebElement production;

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

	//Page Object "Advertising Analytics"
	@FindBy(linkText = "Advertising Analytics")
	public WebElement lnkAdvertisingAnalytics;

	//Page Object "Loading Image" 
	@FindBy(xpath ="//*[@src='/images/ajax-loader.gif']")
	public WebElement elementLoadingImage;

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
		WebElement deleteSandBoxApp = driver
				.findElement(By
						.xpath("//a[contains(@class,'Sandbox myappsinfo') and contains(@original-title,'Trash')]"));

		deleteSandBoxApp.click();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_SHORT);
		WebElement confirmationDeleteButton = driver.findElement(By
				.id("confirmationDeleteButton"));

		confirmationDeleteButton.click();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_LONG);
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

	//Function to Click on Sandbox Tab or Production Tab based on selection- Heamnt 
	//***********************************************************************************************************************************                     
	public boolean fnSelectSandboxProdTabAppDetails(String sTabName){

		try{


			if(driver.findElement(By.linkText(sTabName)).isDisplayed()){
				driver.findElement(By.linkText(sTabName)).click();                   
				waitForPageToLoad(); 
				//System.out.println("The tab  "+ sTabName + " has been selected");
				storeVerificationResults(true, "The tab  "+ sTabName + " has been selected");
				return true;
			}else{
				//System.out.println("The tab  "+ sTabName + "does not exists");
				storeVerificationResults(false, "The tab  "+ sTabName + "does not exists");
				return false;
			}
		}catch(Exception e){
			storeVerificationResults(true, "The tab  "+ sTabName + " has alresdy been selected");
			return true;
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
		btnExportExcel.click();

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



	//Function to select From Date from Range -Hemant 
	//***********************************************************************************************************************************                     
	public boolean fnSetFROMDateAppDetail(String sDate){      

		try{
			//enter date value
			dtRangeFromDetail.clear();
			dtRangeFromDetail.sendKeys(sDate);

			//click calender done button
			try{
				if(btnDoneCal.isDisplayed()){
					btnDoneCal.click();}
			}catch(Exception e){
			}

		}catch(Exception e){
			storeVerificationResults(false, "From Date Range set failure");
			return false;
		}
		return true;

	}      
	//***********************************************************************************************************************************


	//Function to select To Date from Range -Hemant 
	//***********************************************************************************************************************************                     
	public boolean fnSetTODateAppDetail(String sDate){ 
		try{
			//enter date value
			dtRangeToDetail.clear();
			dtRangeToDetail.sendKeys(sDate);
			implicitWait(1);

			//click calender done button
			try{
				if(btnDoneCal.isDisplayed()){
					btnDoneCal.click();}

			}catch(Exception e){
			}
		}catch(Exception e){
			storeVerificationResults(false, "To Date Range set failure");
			return false;
		}
		return true;
		
	}      
	//***********************************************************************************************************************************

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

	//Function to Click on Refresh/Update -Hemant 
	//***********************************************************************************************************************************                     
	public void fnClickRefresh(){   

		//Click on Refresh Button
		btnRefreshDetail.click();
		
		//wait till data not displayed
		int i;
		i=0;
		while(elementLoadingImage.isDisplayed() && i<20){
			//System.out.println("Wait for trend");
			implicitWait(PAGE_WAIT_AJAX);
			i=i+1;
		}                    
	}      
	//***********************************************************************************************************************************

	// Function to select API from API dropdown-Hemant
	// ***********************************************************************************************************************************
	public void fnSetAPI(String sAPI) {

		try{

			Select s = new Select(ddAPIs);
			s.selectByValue(sAPI);

			ddAPIs.sendKeys(sAPI);

		}catch(Exception e){

			e.printStackTrace();
			System.exit(0);
		}


	}      
	//***********************************************************************************************************************************

	// Function to select Duration from View dropdown-Hemant
	// ***********************************************************************************************************************************
	public void fnSetView(String sView) {
		Select s = new Select(ddView);
		s.selectByValue(sView);
	}

	// ***********************************************************************************************************************************

	// Function to select Daily, hourly from By dropdown-Hemant
	// ***********************************************************************************************************************************
	public void fnSetBy(String sBy) {
		Select s = new Select(ddByChart);
		s.selectByValue(sBy);
	}

	// ***********************************************************************************************************************************

	// Function to click on ADV_Analytics link on App Details page and verify
	// before and after clicking -Hemant-
	// ***********************************************************************************************************************************
	public void verifyADVAnalyticsAlreadyCollapsed() {

		//code to check heading already collapsed
		boolean x =  lblAppADVAnalytics.isDisplayed();
		if (!x){	                
			storeVerificationResults(true, "Pass - ADV-Analytics is collapsed by default in Application Details page");
		}else{
			storeVerificationResults(false, "Fail - ADV-Analytics is expanded by default in Application Details page");
		}

		//Click on ADV Analytics
		btnADVAnalytics.click();

		try{
			//code to wait till data not displayed
			int i;
			i=0;         
			while(elementLoadingImage.isDisplayed() && i<20){
				//System.out.println("Wait for trend");  
				implicitWait(PAGE_WAIT_AJAX);
				i=i+1;
				//System.out.println("waiting for ajax to load");
			}             
		}catch(Exception e){
			storeVerificationResults(false, "error while loading the data");
			publishTestResult();
		}

		//Verify Analytics is expanded
		boolean y =  lblAppADVAnalytics.isDisplayed();
		if (y){
			storeVerificationResults(true, "ADV-Analytics is expanded on clicking Advertising Analytics link");
		}else{
			storeVerificationResults(false, "ADV-Analytics does not expands on clicking Advertising Analytics link");
		}
	}

	// ***********************************************************************************************************************************

	//Function to check ADV_Analytics link is NOT displayed-Hemant- 
	//***********************************************************************************************************************************			
	public boolean validateADVAnalyticsLinkNotDisplayed(){

		boolean flag = true;
		try{
			if(lnkAdvertisingAnalytics.isDisplayed()){
				storeVerificationResults(false, "Advertising Analytics Link is visible, when user has no application with Adv API");
			}else{			    		
				storeVerificationResults(true, "Advertising Analytics Link is NOT visible, when user has application with Advertising API");
				flag = false;
			}

		}catch(Exception e){
			storeVerificationResults(true, "Advertising Analytics Link is visible, when user has no application with Adv API");
			flag = false;
		}
		return flag;
	}
	//***********************************************************************************************************************************	

	//Function to check ADV_Analytics link is displayed-Hemant- 
	//***********************************************************************************************************************************			
	public boolean validateADVAnalyticsLinkDisplayed(){

		boolean flag = true;
		try{
			if(lnkAdvertisingAnalytics.isDisplayed()){
				storeVerificationResults(true, "Advertising Analytics Link is visible, when user has application with Adv");
			}else{			    		
				storeVerificationResults(false, "Advertising Analytics Link is NOT visible, when user has application with Advertising API");
				flag = false;
			}

		}catch(Exception e){
			storeVerificationResults(false, "Advertising Analytics Link is NOT visible, when user has application with Advertising API");
			flag = false;
		}
		return flag;
	}
	//***********************************************************************************************************************************	







	//Function to Export the export.xlsx to Temp folder for Advertising-Hemant 
	//***********************************************************************************************************************************                     
	public void fnExportFileADV(String filePathString)
	{
		//btnADVExport.click();
		
		clickButtonExport();


		//wait for the file to get created
		File f = new File(filePathString);
		f = new File(filePathString);
		int iw;
		iw = 0;
		while(!f.exists() && iw <10){
			System.out.println("waiting ");
			wait(2000);
			iw = iw + 1;
		}

		if(f.exists()){                   
			System.out.println("file is created");
		}else{               
			System.out.println("file not exists");
		}

	}
	//***********************************************************************************************************************************


	//Function to Export the export.xlsx to Temp folder-Hemant 
	//***********************************************************************************************************************************                     
	public void fnExportFile(String filePathString)
	{

		//Delete the existing export.xlsx file from Temp Folder
		//String filePathString ;
		//filePathString = "C:\\Temp\\export.xlsx";
		//DeleteFile(filePathString);


		btnExportExcel.click();


		//wait for the file to get created
		File f = new File(filePathString);
		f = new File(filePathString);
		int iw;
		iw = 0;
		while(!f.exists() && iw <10){
			System.out.println("waiting ");
			wait(2000);
			iw = iw + 1;
		}

		if(f.exists()){                   
			System.out.println("file is created");
		}else{               
			System.out.println("file not exists");
		}

	}
	//***********************************************************************************************************************************

}