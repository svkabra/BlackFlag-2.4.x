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
import ATT.Selenium_FVT.Pages.NewAppPage;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;


public class TC_SetupAppValidationDev extends TestUtil{

	/*  Verify that Dev will land on New app creation page when  Setup Application button is clicked on My apps page */	
	
	@Test
	public void testSetupAppButton() {
		
		APIMLoginPage apimLoginPage= new APIMLoginPage(getNewDriver(Constants.BROWSER));
		apimLoginPage.openURL();
		apimLoginPage.developerLogin();
		MyAppsPage myAppsPage = apimLoginPage.clickMyApps();
		apimLoginPage.validateMyAppsPage();
		// Method to click Setup new App link
		NewAppPage newAppPage =myAppsPage.setUpNewApp();
		// Method to Validate Dev will land on New app creation page on clicking setup new app button
		newAppPage.validateNewAppPage();
		// Method to Publish test result
		apimLoginPage.publishTestResult();
		newAppPage.publishTestResult();
	}
	
	@After
    public void takeScreenShot() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_SetupAppValidationDev.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
}
