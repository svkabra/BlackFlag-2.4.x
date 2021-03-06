package ATT.Selenium_FVT.Developer_Analytics_Advertising;

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

public class TC_OPA_ADV_Analytics_By_Default_Collapsed_My_Apps extends TestUtil{


	@Test
	public void test_OPA_ADV_Analytics_By_Default_Collapsed_My_Apps() {		

		//method to launch browser
		APIMLoginPage apimLoginPage= new APIMLoginPage(getNewDriverProfile(Constants.BROWSER));

		//method to open URL
		apimLoginPage.openURL();

		//method to login
		apimLoginPage.apimLogin("F3", "OPA", "withApp");

		//method to click on MyApps button
		MyAppsPage myapps = apimLoginPage.clickMyApps();

		//Method to validate that ADV Analytics is already collapsed*/		
		myapps.validateADVAnalyticsAlreadyCollapsed();

		// method to publish test result
		apimLoginPage.publishTestResult();				

	}




	@After
	public void takeScreenShot() {
		// take the screenshot at the end of every test
		File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		// now save the screenshto to a file some place
		try {
			String className = this.getClass().getSimpleName();
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\" + className + ".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}




}
