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


public class TC_CancelDeleteSandboxAppPlayground extends TestUtil{

	/* To verify Playground can cancel deleting  a Sandbox app
	 * * Precondition : Playground user should have an app with name "0001_CancelDeleteApp" on my apps page in F3 environment  */	
	
	@Test
	public void testCancelDeletion() {
		
		APIMLoginPage apimLoginPage= new APIMLoginPage(getNewDriver(Constants.BROWSER));
		apimLoginPage.openURL();
		apimLoginPage.testLogIn(Constants.PG_USERNAME_CANCELDELELTE, Constants.PG_PASSWORD__CANCELDELELTE);
		MyAppsPage myAppsPage = apimLoginPage.clickMyApps();
		apimLoginPage.validateMyAppsPage();			
		// Method to Click on delete Sandbox App button 
		myAppsPage.clickDeleteSandbox();		
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
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\CancelDeleteSandboxApp_Playground.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }

}
