package ATT.Selenium_FVT.DevOnboarding;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.CommunityProfilePage;
import ATT.Selenium_FVT.Pages.ManageMyAccount;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;

public class TC_CommunityProfileJobtitleFieldValidation extends TestUtil {

	@Test
	public void communitProfileJobTileValidation_test() {
		
		APIMLoginPage apimLoginPage = new APIMLoginPage(getNewDriver(Constants.BROWSER));
		
		//method to load the URL
		apimLoginPage.openURL();
		
		//method to log into Dev Portal as an Developer
		apimLoginPage.developerLogin();
		
		//method to click on Manage My Account Link
		ManageMyAccount manageMyAcct = apimLoginPage.clickManageMyAcctLink();
		
		//method to click community profile
		CommunityProfilePage communityProfilePage = manageMyAcct.clickCommunityProfile();
		
		//method to validate user lands on community profile page
		manageMyAcct.validateCommunityProfilePage();
		
		//method to populate Job title field
		communityProfilePage.populateJobTitle();
		
		//method to validate Job Title field validation
		communityProfilePage.validateJobTitle();
		
		//method to publish Test Result
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

	FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_CommunityProfileJobtitleFieldValidation.png"));

	} catch (IOException e) {

	

	e.printStackTrace();

	}

	} 

}
