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


public class TC_ManageSandBoxButtonValidationOPA extends TestUtil{

	/**   Verify that OPA can view sandbox app detail page by clicking on Manage Sandbox button 
	 * Precondition : User should have atleast one app on my apps page*/	
	
	@Test
	public void testManageSandboxBtn() {
		
		APIMLoginPage apimLoginPage= new APIMLoginPage(getNewDriver(Constants.BROWSER));
		apimLoginPage.openURL();
		apimLoginPage.opaLogin();
		MyAppsPage myAppsPage = apimLoginPage.clickMyApps();
		apimLoginPage.validateMyAppsPage();
		//  Method to click Manage Sandbox button 
		myAppsPage.clickManageSandboxButton();		
		//  Method to verify that user can view sandbox app detail page by clicking on Manage Sandbox button 
		myAppsPage.validateManageSandboxButton();		
		//Method to publish test result
		apimLoginPage.publishTestResult();
		myAppsPage.publishTestResult();
		
	}
	@After
    public void takeScreenShot() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_ManageSandBoxButtonValidationOPA.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
}
