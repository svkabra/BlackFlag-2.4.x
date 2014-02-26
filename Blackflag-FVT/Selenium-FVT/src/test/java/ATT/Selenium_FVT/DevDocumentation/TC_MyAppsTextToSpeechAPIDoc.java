package ATT.Selenium_FVT.DevDocumentation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.AppDetailsPage;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;

public class TC_MyAppsTextToSpeechAPIDoc extends TestUtil{


/* Test case to verify that the Dev portal Page routes to correct link when clicked on Document icon against Text To Speech API on My Apps page*/
	
	
	@Test
	public void testHeaderNavigation() {
		AppDetailsPage appDetailsPage=new AppDetailsPage(getNewDriver(Constants.BROWSER));
		APIMLoginPage apilogpage = appDetailsPage.apimLoginPage();
		apilogpage.openURL();			 
		apilogpage.testLogIn("afrinatt", "welcome1");
		apilogpage.validateLogin();
		apilogpage.clickMyApps();
		apilogpage.validateMyAppsPage();
		appDetailsPage.clickTextToSpeechAPIDocumentationMyApps();				
	}

	@After
    public void takeScreenShot() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_MyAppsTextToSpeechAPIDoc.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
