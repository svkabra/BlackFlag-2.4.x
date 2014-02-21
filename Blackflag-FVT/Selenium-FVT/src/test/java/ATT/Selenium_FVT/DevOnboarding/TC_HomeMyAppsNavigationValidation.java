package ATT.Selenium_FVT.DevOnboarding;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;
import ATT.Selenium_FVT.Utilities.Component.Headers;


public class TC_HomeMyAppsNavigationValidation extends TestUtil{

	/* Test case to verify My apps navigation from home page*/	
	
	@Test
	public void testFooterNavigation() {
		
		Headers headers=new Headers(getNewDriver(Constants.BROWSER));
		APIMLoginPage apilogpage = headers.apimLoginPage();
		apilogpage.openURL();
		apilogpage.developerLogin();
		apilogpage.clickMyApps();	
		apilogpage.validateMyAppsPage();
		
		//publish result
		apilogpage.publishTestResult();
	}

	@After
    public void takeScreenShot() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_HomeMyAppsNavigationValidation.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
