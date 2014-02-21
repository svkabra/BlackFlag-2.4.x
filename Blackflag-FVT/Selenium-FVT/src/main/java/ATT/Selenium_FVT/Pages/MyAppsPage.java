package ATT.Selenium_FVT.Pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ATT.Selenium_FVT.Utilities.Browser.WebPage;
import ATT.Selenium_FVT.Utilities.Component.Constants;
import ATT.Selenium_FVT.Utilities.Excel.ReadXLSX;

public class MyAppsPage extends WebPage {
		
	// Page Object "Upgrade to full access"
	@FindBy(css="input.btn-darkblue")	
	public WebElement upgardeToFullAccess;
	
	//Page Object "Setup New Application" link
	@FindBy(id= "add_an_resource")
	public WebElement setupNewApp;
	
	//Page Object "App Key"
	@FindBy(css = "span.appkey_label")
	public WebElement AppKey;
	
	//Page Object "App Secret"
	@FindBy(css= "span.appsecret_label")
	public WebElement AppSecret;

	//Page Object "Manage Sandbox button"
	@FindBy(css= "a.myappsinfo.sandboxstatus-active")
	public WebElement manageSandboxbutton;
	
	//Page Object "Delete Sandbox button"
	@FindBy(css= "a.Sandbox.myappsinfo")
	public WebElement deleteSandboxAppButton;
	
	//Page Object "Delete Production button"
	@FindBy(css= "a.Production.myappsinfo")
	public WebElement deleteProductionAppButton;
	
	@FindBy(css="span.futuristic_edit > a.myappsinfo")
	public WebElement editButton;
	
	//Page Object "API-Analytics" 
    @FindBy(id="all_apps_analytics")
    public WebElement buttonAppAnalytics;
    
    //Page Object "ADV Analytics" 
    @FindBy(id = "all_adv_apps_analytics") 
    public WebElement buttonAdvAnalytics;
    
    //Page Object "All Apps Advertising Analytics Heading" 
    @FindBy(xpath = "//*[@id='app-list']/div[1]/div/form/div[1]/span[1]") 
    public WebElement labelAllAppsAdvAnalytics;
           
    
    //Page Object " API Range From Date" 
    @FindBy(id="analytics-api-form-from")
    public WebElement dateRangeFrom;
    
    //Page Object "API Range To Date" 
    @FindBy(id="analytics-api-form-to")
    public WebElement dateRangeTo;
    
    //Page Object "APIs DropDown" 
    @FindBy(id="analytics-api-form-trend")
    public WebElement dropdownAPIs;
    
    //Page Object "View DropDown" 
    @FindBy(id="analytics-api-form-view")
    public WebElement dropdownView;
    
    //Page Object "By DropDown" 
    @FindBy(id="chart")
    public WebElement dropdownByChart;
    
    //Page Object "API Update Button" 
    //@FindBy(xpath="//a[contains(text(),'Export Excel')]/../../span[3]/a")
    @FindBy(xpath="//*[@id='app-list']/div[1]/div/form/div[1]/span[2]/div/div/span[3]/a")    
    public WebElement buttonRefresh;
           
    
    //Page Object "API Export Excel" 
    //@FindBy(xpath="//a[contains(text(),'Export Excel')]")
    @FindBy(xpath="//*[@id='app-list']/div[1]/div/form/div[1]/span[2]/div/div/span[2]/a")                                   
    public WebElement buttonExportExcel;


    //Page Object "API Export CSV" 
    //@FindBy(xpath="//a[contains(text(),'Export CSV')]")
    @FindBy(xpath="//*[@id='app-list']/div[1]/div/form/div[1]/span[2]/div/div/span[1]/a")
    public WebElement buttonExportCSV;


    //Page Object "Range From Date -Advertising Analytics" 
    @FindBy(id="adv-analytics-api-form-from")
    public WebElement dateAdvRangeFrom;
    

    //Page Object "Range To Date -Advertising Analytics" 
    @FindBy(id="adv-analytics-api-form-to")
    public WebElement dateAdvRangeTo;
    
    //Page Object "ADV Update Button" 
    @FindBy(xpath="//*[@id='app-list']/div[1]/div/form/div[1]/span[2]/div/div/span[2]/a")                           
    public WebElement buttonAdvRefresh;
    
    //Page Object "ADV Export Button" 
    @FindBy(xpath="//*[@id='app-list']/div[1]/div/form/div[1]/span[2]/div/div/span[1]/a")
    public WebElement buttonAdvExport;
    

    //Page Object "Estimated Revenue Head" 
    @FindBy(xpath="//*[@id='app-list']/div[2]/div/form/div[2]/div[3]/div[1]")
    public WebElement labelRevenueHead;
    
    
    //Page Object "Request Legend" 
    @FindBy(xpath="//*[@id='highcharts-2']/svg/g[6]/text[1]/tspan")
    public WebElement labelRequest;
    
    //Page Object "Impressions Legend" 
    @FindBy(xpath="//*[@id='highcharts-2']/svg/g[6]/text[2]/tspan")
    public WebElement labelImpressions;
    
    
    //Page Object "Clicks Legend" 
    @FindBy(xpath="//*[@id='highcharts-2']/svg/g[6]/text[3]/tspan")
    public WebElement labelClicks;
    
    //Page Object "Application list" 
    @FindBy(id ="app-list")
    public WebElement elementAppList;
    

    //Page Object "Loading Image" 
    @FindBy(xpath ="//*[@id='content-area']/div[4]/img")
    public WebElement elementLoadingImage;
    

	public MyAppsPage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void openURL() {
		//driver.get(MY_APPS_URL);
		PageFactory.initElements(driver, this);
	}
	
	  //***************************************Methods Created by Binny*******************************************************************
	/* metthod to click on Setup New App button */
	public NewAppPage setUpNewApp() {
		setupNewApp.click();
		waitForPageToLoad();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_SHORT);
		return PageFactory.initElements(driver, NewAppPage.class);
	}

	/*
	 * method to click on Setup App Button after deleting all the apps for a
	 * playground user
	 */

	public NewAppPage setUpNewAppAfterCleanup() {
		driver.findElement(By.id("add_an_resource")).click();
		waitForPageToLoad();
		implicitWait(3);
		return PageFactory.initElements(driver, NewAppPage.class);
	}
	
	/*
	 * Method to clicks on Key button on my apps page
	 */
	public MyAppsPage clickKeyIcon() {
		WebElement keyicon;

		// If the App Key and Secret Key section is already expanded
		if (driver
				.findElement(By
						.cssSelector("span.futuristic_key.button_depressed > a.myappsinfo")).isDisplayed()) {
			keyicon = driver
					.findElement(By
							.cssSelector("span.futuristic_key.button_depressed > a.myappsinfo"));
		}
		// If the App Key and Secret Key section is not expanded, click on the
		// Key Icon
		else {
			keyicon = driver.findElement(By
					.cssSelector("span.futuristic_key > a.myappsinfo"));
			keyicon.click();
			implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_SHORT);
		}

	return this;
	}
	
	/*
	 * Method to Validate Sandbox App Key and Secret key is displayed when Dev
	 * clicks on Sandbox Key button on my apps page
	 */

	public boolean validateAppKeyAppSecretDisplayed() {

		boolean result = false;

		if (validateWebElementDisplayed(AppKey)) {
			result = validateWebElementDisplayed(AppSecret);

		}
		return result;
	}

	/* Method to click on Manage Sandbox button */
	public MyAppsPage clickManageSandboxButton() {
		manageSandboxbutton.click();
		waitForPageToLoad();
		return this;
	}

	/*
	 * Method to verify that user can view sandbox app detail page by clicking
	 * on Manage Sandbox button
	 */
	public boolean validateManageSandboxButton() {

		WebElement appTitle = driver.findElement(By.className("title"));
		boolean result = validateWebElementDisplayed(appTitle);
		return result;
	}

	/* Method to click on delete sandbox app button */
	public MyAppsPage clickDeleteSandbox() {

		deleteSandboxAppButton.click();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_SHORT);
		return this;
	}

	/* Method to click on delete button below a particular production app */
	public MyAppsPage clickDeleteProduction() {

		deleteProductionAppButton.click();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_SHORT);
		return this;
	}

	public MyAppsPage deleteSandboxAppPlayground() {

		while (driver
				.findElements(
						By.xpath("//a[contains(@class,'Sandbox myappsinfo') and contains(@original-title,'Trash')]"))
				.size() > 0) {
			driver.findElement(
					By.xpath("//a[contains(@class,'Sandbox myappsinfo') and contains(@original-title,'Trash')]"))
					.click();
			implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_SHORT);
			driver.findElement(By.id("confirmationDeleteButton")).click();
			implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_LONG);
			waitForPageToLoad();
		}
		return this;
	}

	// Page Object "Edit Button"
	
	@FindBy(id="confirmationCancelButton")
	public WebElement orCancelButton;	
	
	/** Method to click on Orcancel delete button */
	public MyAppsPage clickOrCancelButton(){
		
		orCancelButton.click();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_SHORT);	
		return this;
	}
	
	/* Method to click on Orcancel delete button */
	public boolean validateCancelDeleteApp(String appName){
		boolean result =false;
		WebElement title = driver.findElement(By.id("location_header")).findElement(By.tagName("h1"));
		if(validateText(title, "My Apps") && driver.findElement(By.linkText(appName)).isDisplayed()){
		
			storeVerificationResults(true, "App is not Deleted on clicking OrCancel delete button");
			result = true;
		}	
		else{
	    storeVerificationResults(false, "App is Deleted on clicking OrCancel delete button");
		}	
		return result;
	
	}
	
	/* Method to click Edit Sandbox button */
	public EditAppPage clickEditSandboxButton(){			
		editButton.click();
		waitForPageToLoad();	
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_SHORT);
		return PageFactory.initElements(driver, EditAppPage.class);	
	}
	
	/* Method to verify that user can view Edit Sandbox app detail page by clicking on Edit Sandbox App button */
	public boolean validateEditSandboxButton(){			
		boolean result = false;
		WebElement apptitle  = driver.findElement(By.className("title"));
		if(validateWebElementDisplayed(apptitle)){
			result = true;
		}
		return result;	
	}
	
	public boolean validateAuthMessage(){
		WebElement authMessage = driver.findElement(By.cssSelector("div.alert-box.notice"));
		String expectedMessage = "Successfully authenticated from Att account.";
		String actualMessage = authMessage.getText().toString();
		boolean result = false;
		if (actualMessage.contains(expectedMessage)) {
			storeVerificationResults(true, "Authentication message is displayed");
			return true;
		}
		else{
		    storeVerificationResults(false, "Authentication message is not displayed");
		}		
		return result;		
	}
	
	public AppPage clickAppLink(String appname){

		try{

			driver.findElement(By.linkText(appname)).click(); 
			storeVerificationResults(false, "Application link is clicked");
			return PageFactory.initElements(driver, AppPage.class); 

		}catch(Exception e){
			e.printStackTrace();
			storeVerificationResults(false, "Application link not clicked");
			return PageFactory.initElements(driver, AppPage.class);
		}

		} 



	

	
    //***************************************Methods Created by Binny*******************************************************************
	
    //Function to click on API_Analytics button and verify before and after clicking -Hemant- 
    //***********************************************************************************************************************************                     
    public void clkAPIAnalyticsBtn(){

           //Verify Analytics is collapsed
           boolean x = driver.findElement(By.id("app-list")).findElement(By.className("analyticsHeading")).isDisplayed();
           if (!x){
                  System.out.println("Pass - API-Analytics is collapsed");
           }else{
                  System.out.println("Fail - API-Analytics is not collapsed");
           }
           
           //Click on API Analytics
           buttonAppAnalytics.click();
           
           //wait till data not displayed
           int i;
           i=0;
           while(driver.findElement(By.xpath("//html/body/div[2]/img")).isDisplayed() && i<20){
                  //System.out.println("Wait for trend");
                  wait(2000);
                  i=i+1;
           }
           
           
           //Verify Analytics is expanded
           x = driver.findElement(By.id("app-list")).findElement(By.className("analyticsHeading")).isDisplayed();
           if (x){
                  System.out.println("Pass - API-Analytics is expanded");
           }else{
                  System.out.println("Fail - API-Analytics is not expanded");
           }
                                      
    }
    //***********************************************************************************************************************************       

    
    //Function to check if API anlytics is collapsed-Hemant- 
    //***********************************************************************************************************************************                     
    public void fnCheckAPIAnlyticsIsCollapsed(){

           //Verify Analytics is collapsed
           boolean x = driver.findElement(By.id("app-list")).findElements(By.className("analyticsHeading")).isEmpty();
           
           if(!x){                    
                  boolean y = driver.findElement(By.id("app-list")).findElement(By.className("analyticsHeading")).isDisplayed();

                               if (!y){
                                      System.out.println("Pass - API-Analytics is collapsed");
                               }else{
                                      System.out.println("Fail - API-Analytics is not collapsed");
                               }
           }else{
                  
                  System.out.println("Pass - API-Analytics is collapsed");
           }
    }
    //***********************************************************************************************************************************       

    
    
           
    
    //Function to click on ADV_Analytics button and verify before and after clicking -Hemant- 
    //***********************************************************************************************************************************                     
    public void clkADVAnalyticsAlreadyCollapsed(){

           //Verify Analytics is collapsed
           String xyz = "//*[@id='app-list']/div[1]/div/form/div[1]/span[1]";
           boolean flagPresent =validateWebElementPresentBy(By.xpath(xyz));
            if (flagPresent){
	            boolean x =  labelAllAppsAdvAnalytics.isDisplayed();
	            if (!x){
	                   System.out.println("Pass - ADV-Analytics is collapsed");
	                   storeVerificationResults(true, "Pass - ADV-Analytics is collapsed");
	            }else{
	                   System.out.println("Fail - ADV-Analytics is not collapsed");
	                   storeVerificationResults(false, "Element is not present");
	            }                                                      
          }else{
        	  storeVerificationResults(false, "Element is not present");
          }
                  
           //Click on ADV Analytics
           flagPresent = validateWebElementPresentBy(By.id("all_adv_apps_analytics"));
           if (flagPresent){
                  buttonAdvAnalytics.click();
           }else{
        	   storeVerificationResults(false, "Element is not present");
           }
           
           //wait till data not displayed
           int i;
           i=0;
           //driver.findElements(By.xpath("//html/body/div[2]/img")).isEmpty() && 
           while(i<5){
                  //System.out.println("Wait for trend");
                  wait(2000);
                  i=i+1;
           }             
           
           //Verify Analytics is expanded
           //flagPresent = (!driver.findElements(By.xpath(xyz)).isEmpty());
           flagPresent = validateWebElementPresentBy(By.xpath(xyz));
           if(flagPresent ){
                  boolean y =  labelAllAppsAdvAnalytics.isDisplayed();
                  if (y){
                        System.out.println("Pass - ADV-Analytics is expanded");
                        storeVerificationResults(true, "ADV-Analytics is expanded");
                  }else{
                        System.out.println("Fail - ADV-Analytics is not expanded");
                        storeVerificationResults(false, "ADV-Analytics is not expanded");
                  }
           }else{
        	   storeVerificationResults(false, "Element is not present");
           }
    }
    //***********************************************************************************************************************************       



	//Function to check ADV_Analytics link is not displayed-Hemant- 
	//***********************************************************************************************************************************			
	public void clkADVAnalyticsLinkNotDisplayed(){
 
		    int size=  driver.findElements(By.id("all_adv_apps_analytics")).size();
		    
		    if (size==1){		    	
		    	if(driver.findElement(By.id("all_adv_apps_analytics")).isDisplayed()){
		    	    storeVerificationResults(false, "Advertising Analytics Link is visible");
		    	}else{
		    		storeVerificationResults(true, "Advertising Analytics Link is NOT visible");		    		
		    	}		    	
		    }else{
		    	storeVerificationResults(false, "Advertising Analytics Link is NOT visible");
		    }		
	}		
	//***********************************************************************************************************************************	


    //Function to check if ADV analytics is collapsed-Hemant 
    //***********************************************************************************************************************************                     
    public void fnCheckADVAnlyticsIsCollapsed(){

           //Verify Analytics is collapsed
           boolean x = driver.findElement(By.id("app-list")).findElements(By.className("adv-analyticsHeading")).isEmpty();
           
           if(!x){                    
                  boolean y = driver.findElement(By.id("app-list")).findElement(By.className("adv-analyticsHeading")).isDisplayed();

                               if (!y){
                                      System.out.println("Pass - ADV-Analytics is collapsed");
                               }else{
                                      System.out.println("Fail - ADV-Analytics is not collapsed");
                               }
           }else{
                  
                  System.out.println("Pass - ADV-Analytics is collapsed");
           }
    }
    //***********************************************************************************************************************************       

    
    
    //Function to click on ADV_Analytics button and verify before and after clicking -Hemant- 
    //***********************************************************************************************************************************                     
    public void clkADVAnalyticsExpandedCollapsed(){

           //Verify Analytics is collapsed
           String xyz = "//*[@id='app-list']/div[1]/div/form/div[1]/span[1]";
           boolean flagPresent =validateWebElementPresentBy(By.xpath(xyz));
            if (flagPresent){
	            boolean x =  labelAllAppsAdvAnalytics.isDisplayed();
	            if (!x){
	                   System.out.println("Pass - ADV-Analytics is collapsed");
	            }else{
	                   System.out.println("Fail - ADV-Analytics is not collapsed");
	                   storeVerificationResults(false, "Element is not present");
	            }                                                      
          }else{
        	  storeVerificationResults(false, "Element is not present");
          }
                  
           //Click on ADV Analytics
           flagPresent = validateWebElementPresentBy(By.id("all_adv_apps_analytics"));
           if (flagPresent){
                  buttonAdvAnalytics.click();
           }else{
        	   storeVerificationResults(false, "Element is not present");
           }
           
           //wait till data not displayed
           int i;
           i=0;
           //driver.findElements(By.xpath("//html/body/div[2]/img")).isEmpty() && 
           while(i<5){
                  //System.out.println("Wait for trend");
                  wait(2000);
                  i=i+1;
           }             
           
           //Verify Analytics is expanded
           //flagPresent = (!driver.findElements(By.xpath(xyz)).isEmpty());
           flagPresent = validateWebElementPresentBy(By.xpath(xyz));
           if(flagPresent ){
                  boolean y =  labelAllAppsAdvAnalytics.isDisplayed();
                  if (y){
                        System.out.println("Pass - ADV-Analytics is expanded");
                  }else{
                        System.out.println("Fail - ADV-Analytics is not expanded");
                  }
           }else{
        	   storeVerificationResults(false, "Element is not present");
           }
           
           //Click on ADV Analytics
           flagPresent = validateWebElementPresentBy(By.id("all_adv_apps_analytics"));
           if (flagPresent){
                  buttonAdvAnalytics.click();
           }else{
        	   storeVerificationResults(false, "Element is not present");
           }
           
           //wait till data not displayed

           i=0;
           //driver.findElements(By.xpath("//html/body/div[2]/img")).isEmpty() && 
           while(i<3){
                  //System.out.println("Wait for trend");
                  wait(2000);
                  i=i+1;
           }             

           //Verify Analytics is collapsed
           xyz = "//*[@id='app-list']/div[1]/div/form/div[1]/span[1]";
           flagPresent =validateWebElementPresentBy(By.xpath(xyz));
            if (flagPresent){
	            boolean x =  labelAllAppsAdvAnalytics.isDisplayed();
	            if (!x){
	                   System.out.println("Pass - ADV-Analytics is collapsed");
	            }else{
	                   System.out.println("Fail - ADV-Analytics is not collapsed");
	                   storeVerificationResults(false, "Element is not present");
	            }                                                      
          }else{
        	  storeVerificationResults(false, "Element is not present");
          }
   
    
    
    }
    //***********************************************************************************************************************************       

      
    
    //Function to select From Date from Range -Hemant 
    //***********************************************************************************************************************************                     
    public void fnSetFROMDateAPI(String sDate){            
           dateRangeFrom.clear();
           dateRangeFrom.sendKeys(sDate);
           driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();          
    }      
    //***********************************************************************************************************************************
    
    //Function to select To Date from Range -Hemant 
    //***********************************************************************************************************************************                     
    public void fnSetTODateAPI(String sDate){              
           dateRangeTo.clear();
           dateRangeTo.sendKeys(sDate);
           driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();          
    }      
    //***********************************************************************************************************************************

    
    
    //Function to select From Date from Range ADV-Hemant 
    //***********************************************************************************************************************************                     
    public void fnSetFROMDateAPIADV(String sDate){         
      
    	try{
    	
    		dateAdvRangeFrom.clear();
           dateAdvRangeFrom.sendKeys(sDate);
           driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/button[2]")).click();
    	}catch(Exception e){
    		storeVerificationResults(false, "From Date Range set failure");
    	}
    	
    }      
    //***********************************************************************************************************************************
    
    //Function to select To Date from Range -Hemant 
    //***********************************************************************************************************************************                     
    public void fnSetTODateAPIADV(String sDate){           
    	try{
            dateAdvRangeTo.clear();
            dateAdvRangeTo.sendKeys(sDate);
            driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/button[2]")).click();              		
    	}catch(Exception e){
    		storeVerificationResults(false, "To Date Range set failure");
    	}
    }      
    //***********************************************************************************************************************************

    
    
    //Function to Click on Refresh/Update -Hemant 
    //***********************************************************************************************************************************                     
    public void fnClickRefresh(){            
           
           //Click on Refresh Button
           buttonRefresh.click();

           //wait till data not displayed
           int i;
           i=0;
           while(driver.findElement(By.xpath("//html/body/div[2]/img")).isDisplayed() && i<20){
                  //System.out.println("Wait for trend");
                  wait(2000);
                  i=i+1;
           }                    
    }      
    //***********************************************************************************************************************************

    //Function to Click on Refresh/Update -Hemant 
    //***********************************************************************************************************************************                     
    public void fnClickRefreshADV(){         
           
    	try{
    		
    	
           //Click on Refresh Button
           wait(2000);
           buttonAdvRefresh.click();

           //wait till data not displayed
           int i;
           i=0;
           //elementLoadingImage.isDisplayed()
           while(i<5){
                  //System.out.println("Wait for trend");
                  wait(2000);
                  i=i+1;
           }
           
    	}catch(Exception e){
    		storeVerificationResults(false, "Element is not present");
    	}
    }      
    //***********************************************************************************************************************************
    
    
    
    //Function to select API from API dropdown-Hemant 
    //***********************************************************************************************************************************                     
    public void fnSetAPI(String sAPI){       
           
           try{
                  
                  Select s = new Select(dropdownAPIs);
                  s.selectByValue(sAPI);
                  
                  dropdownAPIs.sendKeys(sAPI);
                  
           }catch(Exception e){
                  
                  e.printStackTrace();
                  System.exit(0);
           }
           
           
    }      
    //***********************************************************************************************************************************
    
    
    //Function to select Duration from View dropdown-Hemant 
    //***********************************************************************************************************************************                     
    public void fnSetView(String sView){            
           Select s = new Select(dropdownView);
           s.selectByValue(sView);
    }      
    //***********************************************************************************************************************************
    
    
    //Function to select Daily, hourly from By dropdown-Hemant 
    //***********************************************************************************************************************************                     
    public void fnSetBy(String sBy){         
           Select s = new Select(dropdownByChart);
           s.selectByValue(sBy);
    }      
    //***********************************************************************************************************************************

    //Procedure to wait for specified milliseconds
    public static void wait(int ms){
           try {                             
                  Thread.sleep(ms);
           } catch (InterruptedException e) {

                  e.printStackTrace();
           }
    }

    
    //Function to Delete the existing export.xlsx from the Temp folder-Hemant 
    //***********************************************************************************************************************************                     
    public void DeleteFile(String filepath)
    {
           try{
                  File file = new File(filepath);
                  if(file.delete()){
                         System.out.println(file.getName() + " is deleted!");
                         //return true;
                  }else{
                         System.out.println("Delete operation is failed.");
                         //return false;
                  }
           }catch(Exception e){
                  e.printStackTrace();
                  //return false;
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

           
           buttonExportExcel.click();
           
                        
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

    //Function to Export the export.xlsx to Temp folder for Advertising-Hemant 
    //***********************************************************************************************************************************                     
    public void fnExportFileADV(String filePathString)
    {
           buttonAdvExport.click();
           
           //Code to create the folder
           int in  = filePathString.lastIndexOf("\\");            
           String folderPathString =  filePathString.substring(0, in);
                       
           System.out.println(folderPathString );
           
              File dir=new File(folderPathString );
              if(dir.exists()){
                  System.out.println("A folder with name" + folderPathString + "is already exist in the path");
              }else{
                  dir.mkdir();
              }
 
                        
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
                  storeVerificationResults(false, "file is created");
           }else{               
                  System.out.println("file not exists");
                  storeVerificationResults(false, "file does not exists");
           }

    }
    //***********************************************************************************************************************************
    
    
    //Function to Export the export.csv to Temp folder-Hemant 
    //***********************************************************************************************************************************                     
    public void fnExportcsv(String filePathString)
    {
           buttonExportCSV.click();
                                      
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

    
    
    
    //Function to verify dateAdvRangeFrom-Hemant 
    //***********************************************************************************************************************************                     
           public boolean fnVerifydtADVRangeFrom(){
                  
                  if(dateAdvRangeFrom.isDisplayed()){
                        System.out.println("Adv From Date is Visible");
                  }else{
                        System.out.println("Adv From Date is Not Visible");
                        return false;
                  }
                                      
                  if(!dateAdvRangeFrom.getAttribute("value").isEmpty()){
                        System.out.println("From Date is past 7 days");
                        return true;
                  }else{
                        System.out.println("From Date is Null");
                        return false;
                  }                          
           }
    //***********************************************************************************************************************************
           

           //Function to verify dateAdvRangeTo-Hemant 
           //***********************************************************************************************************************************                     
                  public boolean fnVerifydtADVRangeTo(){                        
                        if(dateAdvRangeTo.isDisplayed()){
                               System.out.println("Adv To Date is Visible");
                        }else{
                               System.out.println("Adv To Date is Not Visible");
                               return false;
                        }
                                             
                        if(!dateAdvRangeTo.getAttribute("value").isEmpty()){
                               System.out.println("From To is past 7 days");
                               return true;
                        }else{
                               System.out.println("From To is Null");
                               return false;
                        }                          
                  }
           //***********************************************************************************************************************************

           //Function to verify buttonAdvRefresh-Hemant 
           //***********************************************************************************************************************************                     
                  public boolean fnVerifybtnADVRefresh(){                       
                        if(buttonAdvRefresh.isDisplayed()){
                               System.out.println("Refresh is Visible");
                               return true;
                        }else{
                               System.out.println("Refresh is Not Visible");
                               return false;
                        }
                  }
           //***********************************************************************************************************************************

           //Function to verify fnVerifybtnADVExport-Hemant 
           //***********************************************************************************************************************************                     
                  public boolean fnVerifybtnADVExport(){                        
                        if(buttonAdvExport.isDisplayed()){
                               System.out.println("Pass - Export button is Visible");
                               return true;
                        }else{
                               System.out.println("Fail - Export button is Not Visible");
                               return false;
                        }
                  }
           //***********************************************************************************************************************************

           //Function to verify fnVerifylblRevnuHead-Hemant 
           //***********************************************************************************************************************************                     
                  public boolean fnVerifylblRevnuHead(){                        
                        if(labelRevenueHead.isDisplayed()){
                               System.out.println("Pass - Revenue heading is Visible");
                               return true;
                        }else{
                               System.out.println("Fail - Revenue heading is Not Visible");
                               return false;
                        }
                  }
           //***********************************************************************************************************************************

           //Function to verify dateRangeFrom API-Hemant 
           //***********************************************************************************************************************************                     
                  public boolean fnVerifydtRangeFrom(){                         
                        if(dateRangeFrom.isDisplayed()){
                               System.out.println("Pass - From Date text box is Visible");
                               return true;
                        }else{
                               System.out.println("Fail - From Date text box is Not Visible");
                               return false;
                        }
                  }
           //***********************************************************************************************************************************

           //Function to verify dateRangeTo API-Hemant 
           //***********************************************************************************************************************************                     
                  public boolean fnVerifydtRangeTo(){                           
                        if(dateRangeTo.isDisplayed()){
                               System.out.println("Pass - To Date text box is Visible");
                               return true;
                        }else{
                               System.out.println("Fail - To Date text box is Not Visible");
                               return false;
                        }
                  }
           //***********************************************************************************************************************************
                  
           //Function to verify dropdownAPIs API-Hemant 
           //***********************************************************************************************************************************                     
                  public boolean fnVerifyddAPIs(){                       
                        if(dropdownAPIs.isDisplayed()){
                               System.out.println("Pass - API dropdown box is Visible");
                               return true;
                        }else{
                               System.out.println("Fail - API dropdown box is Not Visible");
                               return false;
                        }
                  }
           //***********************************************************************************************************************************

           //Function to verify dropdownView API-Hemant 
           //***********************************************************************************************************************************                     
                  public boolean fnVerifyddView(){                       
                        if(dropdownView.isDisplayed()){
                               System.out.println("Pass - View box is Visible");
                               return true;
                        }else{
                               System.out.println("Fail - View box is Not Visible");
                               return false;
                        }
                  }
           //***********************************************************************************************************************************
                  
           //Function to verify dropdownByChart API-Hemant 
           //***********************************************************************************************************************************                     
                  public boolean fnVerifyddByChart(){                           
                        if(dropdownByChart.isDisplayed()){
                               System.out.println("Pass - By box is Visible");
                               return true;
                        }else{
                               System.out.println("Fail - By box is Not Visible");
                               return false;
                        }
                  }
           //***********************************************************************************************************************************

                  
           //Function to verify  buttonRefresh API-Hemant 
           //***********************************************************************************************************************************                     
                  public boolean fnVerifybtnRefresh(){                          
                        if( buttonRefresh.isDisplayed()){
                               System.out.println("Pass - Refresh button is Visible");
                               return true;
                        }else{
                               System.out.println("Fail - Refresh button is Not Visible");
                               return false;
                        }
                  }
           //***********************************************************************************************************************************
                  
                  
           //Function to verify  buttonExportCSV API-Hemant 
           //***********************************************************************************************************************************                     
                  public boolean fnVerifybtnExportCSV(){                        
                        if( buttonExportCSV.isDisplayed()){
                               System.out.println("Pass - Export button is Visible");
                               return true;
                        }else{
                               System.out.println("Fail - Export  button is Not Visible");
                               return false;
                        }
                  }
           //***********************************************************************************************************************************
                  
                  
                  
           
           //Function to verify  buttonExportCSV API-Hemant 
           //***********************************************************************************************************************************                     
                  public boolean fnVerifyAPIGraphIsDisplayed(){                        
                        if(driver.findElements(By.xpath("//*[@id='highcharts-7']/svg/g[10]/g/path")).size()>1){
                               System.out.println("Pass - Graph is Visible");
                               return true;
                        }else{
                               System.out.println("Fail - Graph is Not Visible");
                               return false;
                        }
                  }
           //***********************************************************************************************************************************
                        

           //Function to Set the start and end date API-Hemant 
           //***********************************************************************************************************************************                     
                  public boolean fnSetDateRangeInMyApps(String sStartDate ,String sEndDate){                                                                                   
                        try{
                               //Set the From Date in API Analytics filter
                               
                               //sDate = "8/1/2013 00:00";
                               fnSetFROMDateAPI(sStartDate);
                                                                        
                               //Set the To Date in API Analytics filter
                               //sDate = "9/1/2013 00:00";
                               fnSetTODateAPI(sEndDate);                                     
                               
                               return true;
                        }catch(Exception e){                                   
                               e.printStackTrace();
                               return false;
                        }
                        
                        
                  }
           //***********************************************************************************************************************************


                  //Function to Set the start and end date ADV Analytics-Hemant 
                  //***********************************************************************************************************************************                     
                        public boolean fnSetDateRangeInMyAppsADV(String sStartDate ,String sEndDate){                                                                                         
                               try{
                                      //Set the From Date in API Analytics filter
                                      
                                      //sDate = "8/1/2013 00:00";
                                      fnSetFROMDateAPIADV(sStartDate);
                                                                               
                                      //Set the To Date in API Analytics filter
                                      //sDate = "9/1/2013 00:00";
                                      fnSetTODateAPIADV(sEndDate);                                         
                                      
                                      return true;
                               }catch(Exception e){                                   
                                      e.printStackTrace();
                                      storeVerificationResults(false, "Date Range set failed");
                                      return false;
                               }
                               
                               
                        }
                  //***********************************************************************************************************************************

                  
                  
                  
                  //Function to Set the View dropdown-Hemant 
                  //***********************************************************************************************************************************                     
                        public boolean fnSetView(String sStartDate ,String sEndDate){                                                                                   
                               try{
                                      //Set the From Date in API Analytics filter
                                      
                                      //sDate = "8/1/2013 00:00";
                                      fnSetFROMDateAPI(sStartDate);
                                                                               
                                      //Set the To Date in API Analytics filter
                                      //sDate = "9/1/2013 00:00";
                                      fnSetTODateAPI(sEndDate);                                     
                                      
                                      return true;
                               }catch(Exception e){                                   
                                      e.printStackTrace();
                                      return false;
                               }
                               
                               
                        }
                  //***********************************************************************************************************************************

                  
           //Function to validate API specific details exists in the exported excel -Hemant 
           //***********************************************************************************************************************************                     

           public void fnVerifyExportedExcelAPISpecificMyApps(String sNewFilePath, String sAPI){
                               
                        ReadXLSX xl = new ReadXLSX();                   
                        String[][] cellValue = xl.readExcel(sNewFilePath);            
                        
                        //Validate the column names and API name in the Excel                
                        
                        //validate API  name
                        if(cellValue[2][1].equalsIgnoreCase(sAPI)){
                               System.out.println("pass - API name is correct " + sAPI);
                        }else{
                               System.out.println("fail - API name is in-correct " + "Excel Value : " + cellValue[2][1].toString() + "  Screen Value  " + sAPI);
                        }
                        
                        //validate API Usage Totals
                        if(cellValue[4][1].equalsIgnoreCase("API Usage Totals")){
                               System.out.println("pass - API Usage Totals column exists");
                        }else{
                               System.out.println("fail - API Usage Totals column does not exists");
                        }
                        
                        //validate Error Request Total
                        if(cellValue[4][2].equalsIgnoreCase("Error Request Total")){
                               System.out.println("pass - Error Request Total Exists");
                        }else{
                               System.out.println("fail - Error Request Total does not Exists");
                        }
                        
                        //validate Response Time
                        if(cellValue[4][3].equalsIgnoreCase("Response Time")){
                               System.out.println("pass - Response Time exists " );
                        }else{
                               System.out.println("fail -  Response Time does not exists ");
                        }
                        
                        
           }      
           //***********************************************************************************************************************************
           
           
           //Function to Search the app in MyApps-Hemant 
           //***********************************************************************************************************************************                     
                  public AppPage fnSearchNClickAnAppinMyApps(String sAppName){                                                                                    
                        //Set the From Date in API Analytics filter

                               if(fnFindAppInCurrentpage(sAppName)){
                               driver.findElement(By.linkText(sAppName)).click();
                               waitForPageToLoad();
                               System.out.println("The app  "+ sAppName + " has been selected");
                               return PageFactory.initElements(driver, AppPage.class);
                               
                               }

                               return PageFactory.initElements(driver, AppPage.class);
//                      do{
//                      
//                             if(fnFindAppInCurrentpage(sAppName)){
//                                    driver.findElement(By.linkText(sAppName)).click();
//                                    waitForPageToLoad();
//                                    System.out.println("The app  "+ sAppName + " has been selected");
//                                    return PageFactory.initElements(driver, AppPage.class);
//                             }
//                             
//                             if(driver.findElement(By.xpath("//*[@id='app-list']/nav/span[7]/a")).isDisplayed()){
//                                    driver.findElement(By.xpath("//*[@id='app-list']/nav/span[7]/a")).click();
//                             }
//                      }while(driver.findElement(By.xpath("//*[@id='app-list']/nav/span[7]/a")).isDisplayed());
                        
//                             return PageFactory.initElements(driver, AppPage.class);
                               
                        
                  }
           //***********************************************************************************************************************************


           //Function to Search the app on the current page-Hemant 
           //***********************************************************************************************************************************                     
           public boolean fnFindAppInCurrentpage(String sAppName){
                  int iNoOfApps;                    
                  iNoOfApps = driver.findElements(By.linkText(sAppName)).size();                           
                  if(iNoOfApps==1){
                        if(driver.findElement(By.linkText(sAppName)).isDisplayed()){                                    
                               //driver.findElement(By.linkText(sAppName)).click();
                               return true;
                        }                                        
                  }
                  return false;
           }
           //***********************************************************************************************************************************                     

           
           //Function to Verify, Request, Impresstions and Clicks, and Estimated Revenue Heading does displyed on ADv Analytics - Hemant
           //***********************************************************************************************************************************                            
                  public void fnVerifyADVAnalyticsGraph(){
                  
                  if(labelRevenueHead.isDisplayed()){
                        System.out.println("Pass - Revenue heading is Visible");                          
                  }else{
                        System.out.println("Fail - Revenue heading is Not Visible");                      
                  }
                  
//                if(labelRequest.isDisplayed()){
//                      System.out.println("Pass - Revenue heading is Visible");                          
//                }else{
//                      System.out.println("Fail - Revenue heading is Not Visible");                      
//                }
//                
//                if(labelImpressions.isDisplayed()){
//                      System.out.println("Pass - Revenue heading is Visible");                          
//                }else{
//                      System.out.println("Fail - Revenue heading is Not Visible");                      
//                }
//                
//                
//                if(labelClicks.isDisplayed()){
//                      System.out.println("Pass - Revenue heading is Visible");                          
//                }else{
//                      System.out.println("Fail - Revenue heading is Not Visible");                      
//                }                    
           }
           
           //***********************************************************************************************************************************                     
		
	
}		
