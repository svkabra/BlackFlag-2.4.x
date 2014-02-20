package ATT.Selenium_FVT.OrgOnBoarding;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.junit.After;
import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.AccountSettingsPage;
import ATT.Selenium_FVT.Pages.ManageMyAccount;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;


public class TC_AccountSettingsCompanyFieldValidation extends TestUtil {

	@Test
	public void accountSettingsCompanyFieldValidation_test() {
		
		APIMLoginPage apimLoginPage = new APIMLoginPage(getNewDriver(Constants.BROWSER));
		
		//method to load the URL
		apimLoginPage.openURL();
		
		//method to log into Dev Portal as an OPA
		apimLoginPage.opaLogin();
		
		//method to click on Manage My Account Link
		ManageMyAccount manageMyAcct = apimLoginPage.clickManageMyAcctLink();
		
		//method to validate user lands on Manage My Account page
		apimLoginPage.validateManageMyAccountPage();
					
		//method to click on Account Settings link
		AccountSettingsPage accountSettingsPage = manageMyAcct.clickAccountSettings();
		
		//method to validate user lands on Account Setting page
		manageMyAcct.validateAccountSettingsPage();
				
		//method to validate company name field
		accountSettingsPage.validateCompanyName();
		
		//method to publish test result
		apimLoginPage.publishTestResult();
		manageMyAcct.publishTestResult();
		accountSettingsPage.publishTestResult();
	}
	
	
	@After

	public void takeScreenShot() {

	// take the screenshot at the end of every test

	File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);

	// now save the screenshot to a file some place

	try {

	FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_AccountSettingsCompanyFieldValidation.png"));

	} catch (IOException e) {

	// TODO Auto-generated catch block

	e.printStackTrace();

	}

	} 


}
