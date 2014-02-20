package ATT.Selenium_FVT.OrgOnBoarding;

import java.io.File;
import java.io.IOException;
import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.CommunityProfilePage;
import ATT.Selenium_FVT.Pages.ManageMyAccount;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.junit.After;


public class TC_CommunityProfileMySettingsLink extends TestUtil {

	@Test
	public void communityProfileMySettingsLink_test() {

		APIMLoginPage apimLoginPage = new APIMLoginPage(getNewDriver(Constants.BROWSER));
		
		//method to load the URL
		apimLoginPage.openURL();
		
		//method to log into Dev Portal as an OPA
		apimLoginPage.opaLogin();
		
		//method to click on Manage My Account Link
		ManageMyAccount manageMyAcct = apimLoginPage.clickManageMyAcctLink();
		
		//method to validate user lands on Manage My Account page
		apimLoginPage.validateManageMyAccountPage();
		
		//method to click community profile
		CommunityProfilePage communityProfilePage = manageMyAcct.clickCommunityProfile();
		
		//method to validate user lands on community profile page
		manageMyAcct.validateCommunityProfilePage();
		 
		//method to click on MySettings link
		communityProfilePage.clickMySettingsLink();
		
		//method to validate My Settings Page
		communityProfilePage.validateMySettingsPage();
		
		//method to publish test result
		apimLoginPage.publishTestResult();
		manageMyAcct.publishTestResult();
		communityProfilePage.publishTestResult();
		
		
	}
	
	@After

	public void takeScreenShot() {

	// take the screenshot at the end of every test

	File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);

	// now save the screenshot to a file some place

	try {

	FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_CommunityProfileMySettingsLink.png"));

	} catch (IOException e) {

	// TODO Auto-generated catch block

	e.printStackTrace();

	}

	} 


}
