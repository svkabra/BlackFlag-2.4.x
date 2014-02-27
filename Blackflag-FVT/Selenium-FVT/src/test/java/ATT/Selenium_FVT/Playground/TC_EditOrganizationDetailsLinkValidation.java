package ATT.Selenium_FVT.Playground;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.ManageMyAccount;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;

public class TC_EditOrganizationDetailsLinkValidation extends TestUtil {

	@Test
	public void editOrganizationDetailsLinkValidation_test() {
		
		APIMLoginPage apimLoginPage = new APIMLoginPage(getNewDriver(Constants.BROWSER));
		
		//method to load the URL
		apimLoginPage.openURL();
		
		//method to log into Dev Portal as an Playground
		apimLoginPage.playGroundLogin();
			
		//method to validate LogIn
		apimLoginPage.validateLogin();
		
		//method to click on Manage My Account Link
		ManageMyAccount manageMyAcct = apimLoginPage.clickManageMyAcctLink();
		
		
		//method to click on Edit Organization Details link
		manageMyAcct.clickEditOrgDetails();
		
		// method to validate user land on Edit Organization Details page
		manageMyAcct.validateEditOrgDetailsPage();	
								
		//method to publish Test Result
		apimLoginPage.publishTestResult();
		manageMyAcct.publishTestResult();
		
				
	}
	
	@After

	public void takeScreenShot() {

	// take the screenshot at the end of every test

	File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);

	// now save the screenshot to a file some place

	try {

	FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_EditOrganizationDetailsLinkValidation .png"));

	} catch (IOException e) {

	

	e.printStackTrace();

	}

	} 


}
