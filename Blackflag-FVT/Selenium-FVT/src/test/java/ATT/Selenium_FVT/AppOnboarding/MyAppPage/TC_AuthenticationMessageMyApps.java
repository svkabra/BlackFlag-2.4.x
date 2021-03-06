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


public class TC_AuthenticationMessageMyApps extends TestUtil{

	/* Verify that "Successfully authenticated from Att account. " message is displayed when the user logs in to My apps page after successful authentication
	 */
	@Test
	public void testAuthenticationMessage() {
		
		APIMLoginPage apimLoginPage= new APIMLoginPage(getNewDriver(Constants.BROWSER));	
		apimLoginPage.openURL();		
		apimLoginPage.developerLogin();
		MyAppsPage myapps = apimLoginPage.clickMyApps();
		apimLoginPage.validateMyAppsPage();
		// Method to validate Authentication message 
		myapps.validateAuthMessage();
		// Method to publish test result
		apimLoginPage.publishTestResult();
		myapps.publishTestResult();
	}
	
	@After
    public void takeScreenShot() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_CancelAppCreationDev.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }

}
