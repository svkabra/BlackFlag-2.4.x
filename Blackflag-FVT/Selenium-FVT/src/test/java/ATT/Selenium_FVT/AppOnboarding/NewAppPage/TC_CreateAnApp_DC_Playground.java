package ATT.Selenium_FVT.AppOnboarding.NewAppPage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.AppPage;
import ATT.Selenium_FVT.Pages.MyAppsPage;
import ATT.Selenium_FVT.Pages.NewAppPage;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;


public class TC_CreateAnApp_DC_Playground extends TestUtil{

	/* Test case to verify that Playground User is able to create an application with the Device Capabilities API included in scope*/
	
	@Before
	public void setupPGEnvironment(){
		APIMLoginPage apimLoginPage= new APIMLoginPage(getNewDriver(Constants.BROWSER));
		apimLoginPage.openURL();
		apimLoginPage.playGroundLogin();
		MyAppsPage myAppsPage = apimLoginPage.clickMyApps();
		// Method to delete existing sandbox apps before creating new app since playground user can create upto 3 apps 
		myAppsPage.deleteSandboxAppPlayground();		
	}
	
	public boolean flag = false;
	
	@Test
	public void testAppCreation() {
		MyAppsPage myAppsPage = new MyAppsPage(getDriver());
		//Create a new app
		NewAppPage newAppPage =myAppsPage.setUpNewAppAfterCleanup();
		String appName =newAppPage.getNewAppName();
		newAppPage.enterAppName(appName);
		newAppPage.enterDescription(Constants.APP_DESCRIPTION);
		newAppPage.selectAPI(Constants.DEVICE_CAPABILITIES);		
		newAppPage.setOAuthUrl(Constants.OAUTH_URL);
		AppPage appPage =newAppPage.submitAppDetails();		
		// Method to validate App is created Successfully	
		appPage.validateAppCreation(appName);		
		// Method to validate if DC API is added to scope  		
		appPage.validateIsApiAdded(Constants.DEVICE_CAPABILITIES);		
		// Method to Publish Test Result
		appPage.publishTestResult();
				
		flag = true;	
				
	}

	@After
    public void takeScreenShot() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_CreateAnApp_DC_Playground.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }	

	@After
	public void deleteCreatedApp(){
		if (flag){
			AppPage appPage = new AppPage(getDriver());
			appPage.deleteSandboxApp();
		}

	}
}
