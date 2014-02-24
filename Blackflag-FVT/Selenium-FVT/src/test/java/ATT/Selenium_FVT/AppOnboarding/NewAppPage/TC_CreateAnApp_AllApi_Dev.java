package ATT.Selenium_FVT.AppOnboarding.NewAppPage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.AppPage;
import ATT.Selenium_FVT.Pages.MyAppsPage;
import ATT.Selenium_FVT.Pages.NewAppPage;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;


public class TC_CreateAnApp_AllApi_Dev extends TestUtil{

	/* Test case to verify that Dev is able to create application with all APIs in scope*/	
	
	public boolean flag = false;
	
	@Test
	public void testAppCreation() {
		
		APIMLoginPage apimLoginPage = new APIMLoginPage(getNewDriver(Constants.BROWSER));
		apimLoginPage.openURL();
		apimLoginPage.developerLogin();
		MyAppsPage myAppsPage = apimLoginPage.clickMyApps();
		apimLoginPage.validateMyAppsPage();		
		//Create a new app
		NewAppPage newAppPage =myAppsPage.setUpNewApp();
		String appName =newAppPage.getNewAppName();
		newAppPage.enterAppName(appName);
		newAppPage.enterDescription(Constants.APP_DESCRIPTION);
		newAppPage.selectAPI(Constants.IN_APP_MESSAGING_MIM);
		newAppPage.selectAPI(Constants.TERMINAL_LOCATION);
		newAppPage.selectAPI(Constants.MMS);
		newAppPage.selectAPI(Constants.DEVICE_CAPABILITIES);
		newAppPage.selectAPI(Constants.IN_APP_MESSAGING_IMMN);
		newAppPage.selectAPI(Constants.SPEECH_TO_TEXT_CUSTOM);
		newAppPage.selectAPI(Constants.TEXT_TO_SPEECH);
		newAppPage.selectAPI(Constants.PAYMENT);
		newAppPage.selectAPI(Constants.SPEECH_TO_TEXT);
		newAppPage.selectAPI(Constants.ADVERTISING);
		newAppPage.selectAPI(Constants.SMS);
		newAppPage.setOAuthUrl(Constants.OAUTH_URL);
		AppPage appPage =newAppPage.submitAppDetails();		
		// Method to validate App is created Successfully
		appPage.validateAppCreationForAdvertising(appName);		
		// Methods to validate if all the API is added to scope  		
		appPage.validateIsApiAdded(Constants.IN_APP_MESSAGING_MIM);
		appPage.validateIsApiAdded(Constants.TERMINAL_LOCATION);
		appPage.validateIsApiAdded(Constants.MMS);
		appPage.validateIsApiAdded(Constants.DEVICE_CAPABILITIES);
		appPage.validateIsApiAdded(Constants.IN_APP_MESSAGING_IMMN);
		appPage.validateIsApiAdded(Constants.SPEECH_TO_TEXT_CUSTOM);
		appPage.validateIsApiAdded(Constants.TEXT_TO_SPEECH);
		appPage.validateIsApiAdded(Constants.PAYMENT);
		appPage.validateIsApiAdded(Constants.SPEECH_TO_TEXT);
		appPage.validateIsApiAdded(Constants.ADVERTISING);
		appPage.validateIsApiAdded(Constants.SMS);
		// Method to Publish Test Result
		apimLoginPage.publishTestResult();
		appPage.publishTestResult();	
		flag = true;
	}

	@After
    public void takeScreenShot() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_CreateAnApp_AllApi_Dev.png"));
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
