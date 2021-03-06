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


public class TC_EditButtonValidationDev extends TestUtil{

	/*  Validate that a Dev can edit Sandbox apps by clicking on edit button for Sandbox app on My apps page 
	 *  Precondition : User should have atleast one app on my apps page*/	
	
	@Test
	public void testEditBtn() {
		APIMLoginPage apimLoginPage= new APIMLoginPage(getNewDriver(Constants.BROWSER));
		apimLoginPage.openURL();
		apimLoginPage.developerLogin();
		apimLoginPage.validateLogin();
		MyAppsPage myAppsPage = apimLoginPage.clickMyApps();
		apimLoginPage.validateMyAppsPage();		
		// Method to click and validate edit button
		myAppsPage.clickEditSandboxButton();
		myAppsPage.validateEditSandboxButton();		
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
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_EditButtonValidationDev.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
}
