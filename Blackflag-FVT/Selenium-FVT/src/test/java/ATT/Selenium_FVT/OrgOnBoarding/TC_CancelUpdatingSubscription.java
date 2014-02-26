package ATT.Selenium_FVT.OrgOnBoarding;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.ManageMyAccount;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Component.Constants;
import org.junit.After;

public class TC_CancelUpdatingSubscription extends TestUtil {

	@Test
	public void cancelUpdatingSubscription_test() {
		
APIMLoginPage apimLoginPage = new APIMLoginPage(getNewDriver(Constants.BROWSER));
		
		//method to load the URL
		apimLoginPage.openURL();
		
		//method to log into Dev Portal as an OPA
		apimLoginPage.opaLogin();
		
		//method to click on Manage My Account Link
		ManageMyAccount manageMyAcct = apimLoginPage.clickManageMyAcctLink();
		
		//method to validate user lands on Manage My Account page
		apimLoginPage.validateManageMyAccountPage();
		
		//method to click on Manage My Credit Card link
		manageMyAcct.clickManageMyCreditCardLink();
		
		//method to validate user lands on Manage My Credit Card page
		manageMyAcct.validateManageMyCreditCardPage();
		
		//method to click cancel button
		manageMyAcct.clickCancelButtonUpdateMySubscriptionPage();
		
		//method to validate user lands on Account Setting page
		manageMyAcct.validateCancelButtonUpdateMySubscriptionPage();
		
		//method to publish Test result
		apimLoginPage.publishTestResult();
		manageMyAcct.publishTestResult();
		
	}

	@After

	public void takeScreenShot() {

	// take the screenshot at the end of every test

	File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);

	// now save the screenshot to a file some place

	try {

	FileUtils.copyFile(scrFile, new File("c:\\tmp\\TC_CancelUpdatingSubscription.png"));

	} catch (IOException e) {

	

	e.printStackTrace();

	}

	} 

}
