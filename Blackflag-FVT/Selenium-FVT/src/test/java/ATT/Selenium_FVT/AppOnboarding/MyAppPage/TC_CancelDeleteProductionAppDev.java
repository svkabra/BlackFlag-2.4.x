package ATT.Selenium_FVT.AppOnboarding.MyAppPage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.MyAppsPage;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;


public class TC_CancelDeleteProductionAppDev extends TestUtil{

	/* To verify Dev can cancel deleting  a Production app
	 * * Precondition : User should have atleast one app on my apps page */	
	
	@Test
	public void testCancelDeletion() {
		
		APIMLoginPage apimLoginPage= new APIMLoginPage(getNewDriver(Constants.BROWSER));
		apimLoginPage.openURL();
		apimLoginPage.developerLogin();
		MyAppsPage myAppsPage = apimLoginPage.clickMyApps();
		apimLoginPage.validateMyAppsPage();		
		// Method to Click on delete Production button 
		myAppsPage.clickDeleteProduction();		
		// Method to click OrCancel button 
		myAppsPage.clickOrCancelButton();		
		// Method to validate OrCancel button 
		myAppsPage.validateCancelDeleteApp(Constants.CANCELDELETEAPP);		
		// Method to publish test result
		apimLoginPage.publishTestResult();
		myAppsPage.publishTestResult();		
	}

	@After
    public void takeScreenShot() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_CancelDeleteProductionAppDev.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
