package ATT.Selenium_FVT.DevOnboarding;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.SupportOverviewPage;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;
import ATT.Selenium_FVT.Utilities.Component.Footers;
import ATT.Selenium_FVT.Utilities.Component.Headers;


public class TC_NavigationForums extends TestUtil{

	/* Test case to verify that the Dev portal Page routes to correct link when clicked on Support Overview*/	
	
	@Test
	public void testFooterNavigation() {
		
		Footers footers=new Footers(getNewDriver(Constants.BROWSER));
		APIMLoginPage apilogpage = footers.apimLoginPage();
		apilogpage.openURL();			 
		apilogpage.developerLogin();
		Headers headers= apilogpage.headers();
		headers.clickLogo();
		SupportOverviewPage supportOverviewPage = footers.clickSupportOverview();
		footers.validateSupportOverview();
		supportOverviewPage.clickVisitForums();
		supportOverviewPage.validateVisitForums();
		
		//publish result
		apilogpage.publishTestResult();
		headers.publishTestResult();
		footers.publishTestResult();
		supportOverviewPage.publishTestResult();
	}

	@After
    public void takeScreenShot() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_NavigationForums.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
