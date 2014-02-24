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


public class TC_CreateAnApp_AllApi_Playground extends TestUtil{

	/* Test case to verify that Playground User is able to create application with all APIs in scope*/	
	
	public boolean flag = false;
	
	@Before
	public void setupPGEnvironment(){
		APIMLoginPage apimLoginPage= new APIMLoginPage(getNewDriver(Constants.BROWSER));
		apimLoginPage.openURL();
		apimLoginPage.playGroundLogin();
		MyAppsPage myAppsPage = apimLoginPage.clickMyApps();
		// Method to delete existing sandbox apps before creating new app since playground user can create upto 3 apps 
		myAppsPage.deleteSandboxAppPlayground();		
	}
	
	@Test
	public void testAppCreation() {
		MyAppsPage myAppsPage = new MyAppsPage(getDriver());
		//Create a new app
		NewAppPage newAppPage =myAppsPage.setUpNewAppAfterCleanup();
		String appName =newAppPage.getNewAppName();
		newAppPage.enterAppName(appName);
		newAppPage.enterDescription(Constants.APP_DESCRIPTION);
		newAppPage.selectAPI(Constants.IN_APP_MESSAGING_MIM);
		newAppPage.selectAPI(Constants.TERMINAL_LOCATION);
		newAppPage.selectAPI(Constants.DEVICE_CAPABILITIES);
		newAppPage.selectAPI(Constants.IN_APP_MESSAGING_IMMN);
		newAppPage.selectAPI(Constants.SPEECH_TO_TEXT_CUSTOM);
		newAppPage.selectAPI(Constants.TEXT_TO_SPEECH);
		newAppPage.selectAPI(Constants.SPEECH_TO_TEXT);
		newAppPage.selectAPI(Constants.ADVERTISING);
		newAppPage.setOAuthUrl(Constants.OAUTH_URL);
		AppPage appPage =newAppPage.submitAppDetails();		
		// Validate App is created Successfully	
		appPage.validateAppCreationForAdvertising(appName);		
		// Methods to validate if all the API is added to scope 
		appPage.validateIsApiAdded(Constants.IN_APP_MESSAGING_MIM);
		appPage.validateIsApiAdded(Constants.TERMINAL_LOCATION);
		appPage.validateIsApiAdded(Constants.DEVICE_CAPABILITIES);
		appPage.validateIsApiAdded(Constants.IN_APP_MESSAGING_IMMN);
		appPage.validateIsApiAdded(Constants.SPEECH_TO_TEXT_CUSTOM);
		appPage.validateIsApiAdded(Constants.TEXT_TO_SPEECH);
		appPage.validateIsApiAdded(Constants.SPEECH_TO_TEXT);
		appPage.validateIsApiAdded(Constants.ADVERTISING);		
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
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_CreateAnApp_AllApi_Playground.png"));
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
