package ATT.Selenium_FVT.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.PageCreator;

import ATT.Selenium_FVT.Utilities.Browser.WebPage;
import ATT.Selenium_FVT.Utilities.Component.Constants;
import ATT.Selenium_FVT.Utilities.Component.Headers;
import ATT.Selenium_FVT.Utilities.Component.PageTitleConstant;

public class APIMLoginPage extends WebPage {

	// Page Object "Support Oevrview"
	@FindBy(how = How.LINK_TEXT, using = "Support Overview")
	public WebElement support;

	// Page Object "Password Popup"
	@FindBy(how = How.ID, using = "g_signin_password")
	private WebElement passwordPopup;

	// Page Object "Username Popup"
	@FindBy(how = How.ID, using = "g_signin_username")
	private WebElement userNamePopup;

	// Page Object "Popup Signin button"
	@FindBy(how = How.NAME, using = "signIn")
	private WebElement popupSignInButton;

	// Page Object "Field Error"
	@FindBy(how = How.CLASS_NAME, using = "field_error")
	private WebElement fieldError;

	// Page Object "Sign In"
	@FindBy(how = How.CLASS_NAME, using = "login")
	public WebElement signIn;

	// Page Object "Get Started Free"
	@FindBy(how = How.XPATH, using = "//*[@id='att-header']/nav/a[3]")
	public WebElement getStartedFree;

	// Page Object "Sign In" Button
	@FindBy(how = How.NAME, using = "signIn")
	private WebElement signInButton;

	// Page Object "Username"
	@FindBy(id = "signin_username")
	private WebElement userName;

	// Page Object "Password"
	@FindBy(id = "signin_password")
	private WebElement password;

	// Page Object "APIs & Tools" link
	@FindBy(how = How.LINK_TEXT, using = "APIs & Tools")
	public WebElement aPIsTools;

	// Page Object "Submit A Ticket" link
	@FindBy(how = How.LINK_TEXT, using = "Submit A Ticket")
	private WebElement logTicket;

	// Page Object "Manage My Account" link
	@FindBy(how = How.LINK_TEXT, using = "Manage My Account")
	private WebElement manageMyAcct;

	// Page Object "Sign In"
	@FindBy(id = "signInLink")
	public WebElement signinLink;

	// Page Object "May Apps" button
	@FindBy(how = How.LINK_TEXT, using = "My Apps")
	public WebElement myApps;

	// Page Object "Logo"
	@FindBy(how = How.CLASS_NAME, using = "logo")
	private WebElement home;

	// Page Object "See more success stories" link
	@FindBy(how = How.LINK_TEXT, using = "See more success stories")
	private WebElement successStories;

	// Page Object "Contact an API Expert"
	@FindBy(how = How.LINK_TEXT, using = "Contact an API Expert")
	private WebElement contactExpert;

	// Page Object "Check out Events & Hackathons" Link
	@FindBy(how = How.LINK_TEXT, using = "Check out Events & Hackathons")
	private WebElement checkOutHackathonEvents;

	// Page Object "username" header
	@FindBy(how = How.XPATH, using = "//*[@id='att-header']/nav/form/div/a")
	private WebElement userNameHeader;

	/* Parameterized Constructor */
	public APIMLoginPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openURL() {
		driver.navigate().to(Constants.APIM_HOME_URL);
		waitForPageToLoad();
		PageFactory.initElements(driver, this);
	}
	

	/* Method to Initialize APIMLoginPage */
	public Headers headers() {
		waitForPageToLoad();
		return PageFactory.initElements(driver, Headers.class);
	}

	/* Method to Click hackathon and events from home page */
	public APIMLoginPage clickHackathonEventsButton() {
		checkOutHackathonEvents.click();
		waitForPageToLoad();
		return this;
	}

	/* Method to enter password in the popup */
	public APIMLoginPage enterPassword(String pwd) {
		passwordPopup.sendKeys(pwd);
		return this;	
	}

	/* Method to enter username in the popup */
	public APIMLoginPage enterUserName(String userName) {
		signinLink.click();
		implicitWait(Constants.PAGE_WAIT_AJAX);
		userNamePopup.sendKeys(userName);
		return this;
	}

	/* Playground Login Method for f3 Environment */
	public APIMLoginPage playGroundLogin() {

        signIn.click();
        waitForPageToLoad();        
        waitForElement(userNamePopup);           
        if(!elementExist(userNamePopup)){
               signIn.click();
               waitForElement(userNamePopup);                        
        }
		userNamePopup.click();
		userNamePopup.sendKeys(Constants.PG_USERNAME);
		waitForElement(password);
		passwordPopup.click();
		passwordPopup.sendKeys(Constants.PG_PASSWORD);
		waitForPageToLoad();
		popupSignInButton.click();
		return this;
	}

	/* Playground Login Method for f3 Environment */
	public APIMLoginPage playGroundLogInCancelDelete() {

		signIn.click();
		waitForPageToLoad();
		signIn.click();
		userNamePopup.click();
		userNamePopup.sendKeys(Constants.PG_USERNAME_CANCELDELELTE);
		waitForElement(password);
		passwordPopup.click();
		passwordPopup.sendKeys(Constants.PG_PASSWORD__CANCELDELELTE);
		waitForPageToLoad();
		popupSignInButton.click();
		return this;
	}

	/* Developer Login Method for f3 Environment */
	public APIMLoginPage developerLogin() {

		signIn.click();
		waitForPageToLoad();
		signIn.click();
		userNamePopup.click();
		userNamePopup.sendKeys(Constants.DEV_USERNAME);
		waitForElement(password);
		passwordPopup.click();
		passwordPopup.sendKeys(Constants.DEV_PASSWORD);
		waitForPageToLoad();
		popupSignInButton.click();
		return this;
	}

	/* OPA Login Method for f3 Environment */
	public APIMLoginPage opaLogin() {

		signIn.click();
		waitForPageToLoad();
		signIn.click();
		waitForElement(userNamePopup);
	      if(!elementExist(userNamePopup)){
              signIn.click();
              waitForElement(userNamePopup);                        
       }
		userNamePopup.click();
		userNamePopup.sendKeys(Constants.OPA_USERNAME);
		waitForElement(password);
		passwordPopup.click();
		passwordPopup.sendKeys(Constants.OPA_PASSWORD);
		waitForPageToLoad();
		popupSignInButton.click();
		return this;
	}

	/*
	 * Developer Login Method for f3 Environment for verifying account with
	 * applications- Hemant
	 */
	public APIMLoginPage devLogInADVWITHAPP() {
		signIn.click();
		waitForPageToLoad();
		signIn.click();
		userNamePopup.click();
		userNamePopup.sendKeys(Constants.DEV_USERNAME_ADV);
		waitForElement(password);
		passwordPopup.click();
		passwordPopup.sendKeys(Constants.DEV_PASSWORD_ADV);
		waitForPageToLoad();
		popupSignInButton.click();
		return this;
	}

	/*
	 * OPA Login Method for f3 Environment for verifying account with
	 * applications - Hemant
	 */
	public APIMLoginPage opaLogInADVWITAPP() {
		signIn.click();
		waitForPageToLoad();
		signIn.click();
		userNamePopup.click();
		userNamePopup.sendKeys(Constants.OPA_USERNAME_ADV);
		waitForElement(password);
		passwordPopup.click();
		passwordPopup.sendKeys(Constants.OPA_PASSWORD_ADV);
		waitForPageToLoad();
		popupSignInButton.click();
		return this;
	}


	/* Developer Login Method for developer account without application- Hemant */
	public APIMLoginPage devLogInADVWOAPP() {
		signIn.click();
		waitForPageToLoad();
		signIn.click();
		implicitWait(Constants.PAGE_WAIT_AJAX);
		userNamePopup.click();
		userNamePopup.sendKeys(Constants.DEV_USERNAME_ADV_NO_APP);
		waitForElement(password);
		passwordPopup.click();
		passwordPopup.sendKeys(Constants.DEV_PASSWORD_ADV_NO_APP);
		waitForPageToLoad();
		popupSignInButton.click();
		return this;
	}

	/* OPA Login Method for OPA account without application- Hemant */
	public APIMLoginPage opaLogInADVWOAPP() {
		signIn.click();
		waitForPageToLoad();
		signIn.click();
		userNamePopup.click();
		userNamePopup.sendKeys(Constants.OPA_USERNAME_ADV_NO_APP);
		waitForElement(password);
		passwordPopup.click();
		passwordPopup.sendKeys(Constants.OPA_PASSWORD_ADV_NO_APP);
		waitForPageToLoad();
		popupSignInButton.click();
		return this;
	}

	/* Method to go to My Apps Page */
	public MyAppsPage login() {
		signIn.click();
		waitForPageToLoad();
		myApps.click();
		waitForPageToLoad();
		return PageFactory.initElements(driver, MyAppsPage.class);
	}

	/* Method for Testing login functionality */
	public APIMLoginPage testLogIn(String aUsername, String aPassword) {

		signIn.click();
		waitForPageToLoad();
		signIn.click();
		userNamePopup.click();
		userNamePopup.sendKeys(aUsername);
		waitForElement(password);
		passwordPopup.click();
		passwordPopup.sendKeys(aPassword);
		waitForPageToLoad();
		popupSignInButton.click();
		return this;
	}

	/* Method to open join now page */
	public JoinNowPage clickGetStartedFree() {
		getStartedFree.click();
		waitForPageToLoad();
		driver.findElement(By.linkText("close")).click();
		waitForPageToLoad();
		return PageFactory.initElements(driver, JoinNowPage.class);
	}

	/* Method to logout (Overriden Method) */
	public void logout() {
		waitForElement(userNameHeader);
		Hover(userNameHeader);
		driver.findElement(By.id("logOut")).click();
		waitForAjaxInactivity();
		validateLogout();
		
	}



	/* Method to check if alert pop up occurs */
	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	/* Method to click on Manage My Account link */
	public ManageMyAccount clickManageMyAcctLink() {

		waitForElement(userNameHeader);
		Hover(userNameHeader);
		manageMyAcct.click();
		waitForPageToLoad();
		implicitWait(Constants.PAGE_WAIT_INTER_SYSTEM);

		while (isAlertPresent(driver)) {

			Alert javascriptAlert = driver.switchTo().alert();
			System.out.println(javascriptAlert.getText()); // Get text on alert
															// box
			javascriptAlert.accept();
			waitForPageToLoad();
		}
		return PageFactory.initElements(driver, ManageMyAccount.class);
	}

	/* Method to go to "API Matrix" Page */
	public MyAppsPage clickMyApps() {
		waitForElement(myApps);
		myApps.click();
		waitForPageToLoad();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_LONG);
		return PageFactory.initElements(driver, MyAppsPage.class);
	}

	/* Method to click on See more Success Stories page */
	public APIMLoginPage clkSeeMoreSuccessStories() {
		successStories.click();
		waitForPageToLoad();
		return this;
	}

	/* Method to login */
	public MyAppsPage logInLink(String username, String pwd) {

		signIn.click();
		waitForPageToLoad();
		userNamePopup.sendKeys(username);
		passwordPopup.sendKeys(pwd);
		waitForPageToLoad();
		popupSignInButton.click();
		return PageFactory.initElements(driver, MyAppsPage.class);
	}

	/************ Validation Methods ***********/

	/* Method to validate Hackathon Events Page */
	public Boolean validateHackathonEventsPage() {
		String titleExpected1 = PageTitleConstant.HACKATHONS_EVENTS_PAGE1;
		String titleExpected2 = PageTitleConstant.HACKATHONS_EVENTS_PAGE2;
		boolean result = validatePageTitle(titleExpected1)||validatePageTitle(titleExpected2);
	
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");

		}
		
		return result;
	}

	/* Method to validate LogIn Page */
	public boolean validateLogin() {
		boolean result=false;
		String titleExpected = PageTitleConstant.LOGINPAGE;
		int size = driver.findElements(By.className("field_error")).size();
		if (size != 0) {
			if (fieldError.isDisplayed()) {
				validateWebElementDisplayed(fieldError);
			}
		}
		 else {
				if (validatePageTitle(titleExpected)) {

					storeVerificationResults(true, "Page Title displayed api");
					result=true;
				} else {

					storeVerificationResults(false, "Page Title not displayed");

				}
			}
		return result;

	}

	/* Method to validate Get Started Free */
	public boolean validateGetStartedFree() {
		String titleExpected = PageTitleConstant.GETSTARTEDFREEPAGE;
		
		boolean result=validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");

		}
		
		return result;
	}

	/* Method to validate Manage My Account Page */
	public boolean validateManageMyAccountPage() {
		String titleExpected =PageTitleConstant.MANAGEMYACCOUNTPAGE;
		boolean result=validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}

	/* Method to validate My Apps Page */
	public boolean validateMyAppsPage() {
		String titleExpected = PageTitleConstant.MYAPPSPAGE;
		boolean result=validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}

	/* Method to validate Success Stories Page */
	public boolean validateSuccessStoriesPage() {
		String titleExpected = PageTitleConstant.SUCCESSSTORIESPAGE;
		boolean result=validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}
	
	/*Method to validate Logout*/
	public boolean validateLogout() {
		
		boolean result=validateWebElementDisplayed(driver.findElement(By.linkText("Sign In")));
		return result;
	}

}
