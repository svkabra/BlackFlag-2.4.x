package ATT.Selenium_FVT.AppOnboarding.AppDetailPage;

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
import ATT.Selenium_FVT.Pages.NewAppPage;
import ATT.Selenium_FVT.Pages.RequestProductionAccessPage;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;


public class TC_PromoteAnAppMIMOPA extends TestUtil{

	/*	Verify that OPA is able to promote App containing  MIM to production */

	
	@Test
	public void testAppPromotion() {
		
		APIMLoginPage apimLoginPage= new APIMLoginPage(getNewDriver(Constants.BROWSER));
		apimLoginPage.openURL();
		apimLoginPage.opaLogin();
		MyAppsPage myAppsPage = apimLoginPage.clickMyApps();
		apimLoginPage.validateMyAppsPage();
		
		//Create a new app	
		NewAppPage newApp =myAppsPage.setUpNewApp();
		String appname =newApp.getNewAppName();
		newApp.enterAppName(appname);
		newApp.enterDescription(Constants.APP_DESCRIPTION);
		newApp.selectAPI(Constants.IN_APP_MESSAGING_MIM);
		newApp.setOAuthUrl(Constants.OAUTH_URL);
		AppPage appPage =newApp.submitAppDetails();
		appPage.validateAppCreation(appname);
		
		//Promote the created App 
		RequestProductionAccessPage req = appPage.clickRequestProductionAccess();
		req.clickProductionAccess();
		
		//Validate app is promoted 
		appPage.validateProdAccess();
		
		// Display Test Result
		apimLoginPage.publishTestResult();
		newApp.publishTestResult();
		appPage.publishTestResult();
								
	}
	@After
    public void takeScreenShot() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        // now save the screenshto to a file some place
        try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_PromoteAnAppMIMOPA.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}
