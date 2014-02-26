package ATT.Selenium_FVT.DevDocumentation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.APIPage;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;

public class TC_APIPaymentDocumentation extends TestUtil {

/* Test case to verify that the Dev portal Page routes to correct link when clicked on Documentation button for Payment*/
	
	
	@Test
	public void testHeaderNavigation() {
		APIPage aPIPage=new APIPage(getNewDriver(Constants.BROWSER));
		APIMLoginPage apilogpage = aPIPage.apimLoginPage();
		apilogpage.openURL();			 
		apilogpage.developerLogin();
		aPIPage.clickPaymentDocumentation();	
				
	}

	@After
    public void takeScreenShot() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_APIPaymentDocumentation.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
