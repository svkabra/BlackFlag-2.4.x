package ATT.Selenium_FVT.AppOnboarding.NewAppPage;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.MyAppsPage;
import ATT.Selenium_FVT.Pages.NewAppPage;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;


public class TC_CreateApp_BlankTitle_Dev extends TestUtil{

	/* Verify that user is not able to Submit an Application with blank App Name field */	
	
	@Test
	public void testAppCreation() {
		
		APIMLoginPage apimLoginPage= new APIMLoginPage(getNewDriver(Constants.BROWSER));
		apimLoginPage.openURL();
		apimLoginPage.developerLogin();
		MyAppsPage myAppsPage = apimLoginPage.clickMyApps();
		apimLoginPage.validateMyAppsPage();
		//Create a new app
		NewAppPage newAppPage =myAppsPage.setUpNewApp();
		newAppPage.enterDescription(Constants.APP_DESCRIPTION);
		newAppPage.selectAPI(Constants.SPEECH_TO_TEXT_CUSTOM);
		newAppPage.submitAppDetails();			
		//Method to validate that user gets an error message "Can't be blank" under App Name field 
		newAppPage.validateIfTitleisBlank();
		// Method to Publish Test Result
		apimLoginPage.publishTestResult();
		newAppPage.publishTestResult();			
	}
	
	@After
    public void takeScreenShot() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_CreateApp_BlankTitle_Dev.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }	
	
}
