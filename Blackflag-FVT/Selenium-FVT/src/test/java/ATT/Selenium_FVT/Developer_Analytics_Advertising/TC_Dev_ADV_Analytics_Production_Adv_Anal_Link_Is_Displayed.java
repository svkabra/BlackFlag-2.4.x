package ATT.Selenium_FVT.Developer_Analytics_Advertising;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.AppPage;
import ATT.Selenium_FVT.Pages.MyAppsPage;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;

public class TC_Dev_ADV_Analytics_Production_Adv_Anal_Link_Is_Displayed extends TestUtil{

	@Test
	public void testAnalyticsGraphFor_My_Apps_Advertising_V1_ATTr2() {		

		//method to launch browser
		APIMLoginPage apimLoginPage= new APIMLoginPage(getNewDriverProfile(Constants.BROWSER));

		//method to open URL
		apimLoginPage.openURL();

		//method to login
		apimLoginPage.apimLogin("F3", "Developer", "withApp");

		//method to click on MyApps button
		MyAppsPage myapps = apimLoginPage.clickMyApps();

		//method to validate MyApps page successfully loaded
		apimLoginPage.validateMyAppsPage();

		//Click on the already existing application with Advertising Analytics*/		
		String sAppName;
		sAppName = Constants.DEVAPPNAMEWITHADSINPROD ;		
		AppPage appPage = myapps.clickAppLink(sAppName);
		
				
		//method to validate if Advertising Analytics link is displayed
		appPage.validateADVAnalyticsLinkDisplayed();
		
		//Publish result
		apimLoginPage.publishTestResult();
		myapps.publishTestResult();
		appPage.publishTestResult();
	}
	
	@After
    public void takeScreenShot() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        try {
			String className = this.getClass().getSimpleName();
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\" + className + ".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
	
}
