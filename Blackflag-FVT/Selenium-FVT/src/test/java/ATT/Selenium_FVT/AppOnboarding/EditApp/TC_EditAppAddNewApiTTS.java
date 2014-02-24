package ATT.Selenium_FVT.AppOnboarding.EditApp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.AppPage;
import ATT.Selenium_FVT.Pages.EditAppPage;
import ATT.Selenium_FVT.Pages.MyAppsPage;
import ATT.Selenium_FVT.Pages.NewAppPage;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;


public class TC_EditAppAddNewApiTTS extends TestUtil{

	/* Verify that user can  Add TTS api to existing  sandbox Application */	
	
	public boolean flag = false;
	
	@Test
	public void testEditApp() {
		
		APIMLoginPage api= new APIMLoginPage(getNewDriver("FIREFOX"));
		api.openURL();
		api.developerLogin();
		MyAppsPage myapps = api.clickMyApps();
		
		//Creating a new app
		NewAppPage newApp =myapps.setUpNewApp();
		String appname =newApp.getNewAppName();
		newApp.enterAppName(appname);
		newApp.enterDescription(Constants.APP_DESCRIPTION);
		newApp.selectAPI(Constants.IN_APP_MESSAGING_IMMN);
		newApp.setOAuthUrl(Constants.OAUTH_URL);
		AppPage appPage =newApp.submitAppDetails();

		//Adding new APIs to created app
		EditAppPage edit = appPage.clickEditApp();	
		
		//Select TTS api
		edit.selectAPI(Constants.TTS);
		edit.submitAppDetails();
		
		// Validate if TTS API is added to scope  		
		appPage.valaidateIsApiEdited(Constants.TTS);
		
		flag = true;
	}
	@After
    public void takeScreenShot() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        // now save the screenshto to a file some place
        try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\EditApp_AddNewApi_TTS.png"));
		} catch (IOException e) {
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