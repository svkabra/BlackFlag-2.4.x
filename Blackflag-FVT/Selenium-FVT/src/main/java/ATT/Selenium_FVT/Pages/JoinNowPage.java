package ATT.Selenium_FVT.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ATT.Selenium_FVT.Utilities.Browser.WebPage;
import ATT.Selenium_FVT.Utilities.Component.Constants;
import ATT.Selenium_FVT.Utilities.Component.PageTitleConstant;

public class JoinNowPage extends WebPage {

	// Page Object "Text Email"
	@FindBy(how = How.ID, using = "text_email")
	private WebElement email;

	// Page Object "Join Now" button
	@FindBy(how = How.ID, using = "submitButton")
	private WebElement joinNow;

	// Page Object "Email Validity"
	@FindBy(how = How.ID, using = "email_validity_output")
	private WebElement emailValidity;

	// Parameterized Constructors
	public JoinNowPage(WebDriver driver) {
		super(driver);

	}

	@Override
	public void openURL() {
		driver.navigate().to(Constants.APIM_HOME_URL);
		waitForPageToLoad();
		PageFactory.initElements(driver, this);
	}

	// method to input email id
	public JoinNowPage enterEmailID() {
		email.sendKeys("afchoudhary@deloitte.com");
		return this;
	}

	public JoinNowPage signinFromErrorMsg() {
		emailValidity.findElement(By.linkText("Sign In")).click();
		return this;
	}

	public JoinNowPage resetPasswordFromErrorMsg() {
		emailValidity.findElement(By.linkText("Reset Your Password")).click();
		//emailValidity.findElement(By.xpath("a[contains(@href='/developer/resetpassword')]")).click();
		
		return this;
	}

	public JoinNowPage clickJoinNow() {
		joinNow.click();
		waitForPageToLoad();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_LONG);
		return this;
	}

	/********************** Validations ******************/
	// method to validate email id
	public boolean validateEmail() {
		String emailString = emailValidity.getText();
		String errorMsg = "Email in use.";
		boolean result = emailString.contains(errorMsg);
		if (result) {
			storeVerificationResults(true, "Email in use");
			result = true;
		} else {
			storeVerificationResults(false, "User able to reuse email id");
		}
		return result;
	}

	// method to validate sign in
	public boolean validateSignin() {
		String titleExpected = PageTitleConstant.SIGN_IN_PAGE;

		boolean result = validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");

		}

		return result;
	}

}
