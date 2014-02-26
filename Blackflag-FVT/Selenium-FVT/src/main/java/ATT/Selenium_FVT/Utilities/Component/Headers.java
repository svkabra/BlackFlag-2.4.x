package ATT.Selenium_FVT.Utilities.Component;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Utilities.Browser.WebPage;

public class Headers extends WebPage {

	// Page Object "Logo"
	@FindBy(how = How.CLASS_NAME, using = "att-logo")
	public WebElement logo;

	// Page Object "Search Input"
	@FindBy(how = How.ID, using = "search")
	public WebElement searchInput;

	// Page Object "Stories"
	@FindBy(how = How.LINK_TEXT, using = "Stories")
	public WebElement stories;

	// Page Object "Pricing"
	@FindBy(how = How.LINK_TEXT, using = "Pricing")
	public WebElement pricing;

	// Page Object "APIs"
	@FindBy(how = How.LINK_TEXT, using = "APIs")
	public WebElement apis;

	// Page Object "Community"
	@FindBy(how = How.LINK_TEXT, using = "Community")
	public WebElement community;

	// Page Object "Advertising"
	@FindBy(how = How.LINK_TEXT, using = "Advertising")
	public WebElement advertising;

	// Page Object "Speech"
	@FindBy(how = How.LINK_TEXT, using = "Speech")
	public WebElement speech;

	// Page Object "Hackathon & Evenets"
	@FindBy(how = How.LINK_TEXT, using = "Hackathons & Events")
	public WebElement hackathonsEvents;

	// Page Object "Search button"
	@FindBy(how = How.XPATH, using = "//*[@id='quick-search']/button")
	public WebElement searchButton;

	// Page Object "Forums"
	@FindBy(how = How.LINK_TEXT, using = "Forums")
	public WebElement forums;

	// Page Object "Blog"
	@FindBy(how = How.LINK_TEXT, using = "Blog")
	public WebElement blog;

	// Page Object "AdvertisingDocs"
	@FindBy(how = How.XPATH, using = "//*[@id='att-header']/nav/div[1]/div/ul/li[1]/a[2]")
	public WebElement advertisingDocs;

	// Page Object "SpeechDocs"
	@FindBy(how = How.XPATH, using = "//*[@id='att-header']/nav/div[1]/div/ul/li[2]/a[2]")
	public WebElement speechDocs;

	// Page Object "InAppMessagingDocs"
	@FindBy(how = How.XPATH, using = "//*[@id='att-header']/nav/div[1]/div/ul/li[3]/a[2]")
	public WebElement inAppMessagingDocs;

	// Page Object "SMSDocs"
	@FindBy(how = How.XPATH, using = "//*[@id='att-header']/nav/div[1]/div/ul/li[4]/a[2]")
	public WebElement sMSDocs;

	// Page Object "PaymentDocs"
	@FindBy(how = How.XPATH, using = "//*[@id='att-header']/nav/div[1]/div/ul/li[5]/a[2]")
	public WebElement paymentDocs;

	// Parameterized Constructors
	public Headers(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openURL() {
		// PageFactory.initElements(driver,this);

	}

	/* Method to Initialize APIMLoginPage */
	public APIMLoginPage apimLoginPage() {
		waitForPageToLoad();
		return PageFactory.initElements(driver, APIMLoginPage.class);
	}

	/* Method to click on logo */
	public Headers clickLogo() {
		logo.click();
		waitForPageToLoad();
		return this;
	}

	/* Method to click on header link "Hackathon" */
	public Headers clickHackathonsEvents() {

		Hover(community);
		hackathonsEvents.click();
		waitForPageToLoad();
		return this;
	}

	/* Method to search using search functionality */
	public Headers search() {
		searchInput.sendKeys("AT&T");
		searchButton.click();
		waitForPageToLoad();
		return this;

	}
	/* Method to click on header link "Blog" */
	public Headers clickBlog() {
		Hover(community);
		blog.click();
		driver.navigate().to(
				"javascript:document.getElementById('overridelink').click()");

		if (isAlertPresent(driver)) {

			Alert javascriptAlert = driver.switchTo().alert();
			System.out.println(javascriptAlert.getText()); // Get text on alert
															// box
			javascriptAlert.accept();
			waitForPageToLoad();
		}

		return this;
	}

	/* Method to click on header link "Forums" */
	public Headers clickForums() {
		Hover(community);
		forums.click();
		driver.navigate().to(
				"javascript:document.getElementById('overridelink').click()");
		if (isAlertPresent(driver)) {

			Alert javascriptAlert = driver.switchTo().alert();
			System.out.println(javascriptAlert.getText()); // Get text on alert
															// box
			javascriptAlert.accept();
			waitForPageToLoad();
			
		}
		return this;
	}

	/* Method to click on header link "Stories" */
	public Headers clickStories() {
		stories.click();
		waitForPageToLoad();
		return this;
	}

	/* Method to click on header link "Pricing" */
	public Headers clickPricing() {
		pricing.click();
		waitForPageToLoad();
		return this;
	}

	/* Method to click on header link "Community" */
	public Headers clickCommunity() {
		community.click();
		waitForPageToLoad();
		return this;
	}

	/* Method to click on header link "Advertising Docs" */
	public Headers clickAdvertisingDocs() {
		Hover(apis);
		advertisingDocs.click();
		waitForPageToLoad();
		return this;
	}

	/* Method to click on header link "Speech Docs" */
	public Headers clickSpeechDocs() {
		Hover(apis);
		speechDocs.click();
		waitForPageToLoad();
		return this;
	}
	
	/* Method to click on header link "In-app Messaging Docs" */
	public Headers clickInAppMessagingDocs() {
		Hover(apis);
		inAppMessagingDocs.click();
		waitForPageToLoad();
		return this;
	}
	
		
	/* Method to click on header link "SMS Documentation" */
	public Headers clickSMSDocs() {
		Hover(apis);
		sMSDocs.click();
		waitForPageToLoad();
		return this;
	}

	/* Method to click on header link "Payment Docs" */
	public Headers clickPaymentDocs() {
		Hover(apis);
		paymentDocs.click();
		waitForPageToLoad();
		return this;
	}

	//method to handle alert pop up
	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	} // isAlertPresent()
	
	/**********************Validations*******************/

	/* Method to Verify that logo is displayed */
	public boolean validateLogoDisplayed() {
		boolean result = false;
		if (validateWebElementDisplayed(logo)) {
			result = true;
		}
		return result;
	}

	// method to Verify on clicking logo leads to home page
	public boolean validateLogo() {
		String titleExpected = PageTitleConstant.HOME_PAGE;
		boolean result = validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}

	// method to validate hackathons page
	public boolean validateHackathonsEventsPage() {
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

	// method to validate search page
	public boolean validateSearchPage() {
		String titleExpected = PageTitleConstant.SEARCH_PAGE;
		boolean result = validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}

	// method to validate Blog page
	public boolean validateBlogPage() {
		String titleExpected = PageTitleConstant.BLOG_PAGE;
		boolean result = validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}

	// method to validate Forums page
	public boolean validateForumsPage() {
		String titleExpected = PageTitleConstant.FORUMS_PAGE;
		boolean result = validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}

	// method to validate Success Stories page
	public boolean validateSuccessStroiesPage() {
		String titleExpected = PageTitleConstant.SUCCESS_STORIES_PAGE;
		boolean result = validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}

	// method to validate Pricing page
	public boolean validatePricingPage() {
		String titleExpected = PageTitleConstant.PRICING_PAGE;
		boolean result = validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}

	// method to validate Community page
	public boolean validateCommunityPage() {
		String titleExpected = PageTitleConstant.COMMUNITY_PAGE;
		boolean result = validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}

	// method to validate Advertising Docs page
	public boolean validateAdvertisingDocsPage() {
		String titleExpected = PageTitleConstant.ADVERTISING_DOCS;
		boolean result = validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}

	// method to validate Speech Docs page
	public boolean validateSpeechDocsPage() {
		String titleExpected = PageTitleConstant.SPEECH_DOCS;
		boolean result = validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}

	// method to validate In-App Messaging Docs page
		public boolean validateInAppMessagingPage() {
			String titleExpected = PageTitleConstant.In_APP_MESSAGING_DOC;
			boolean result = validatePageTitle(titleExpected);
			if (result) {

				storeVerificationResults(true, "Page Title displayed");

			} else {

				storeVerificationResults(false, "Page Title not displayed");
			}
			return result;
		}

	// method to validate SMS Documentation page
	public boolean validateSMSDocumentation() {
		String titleExpected = PageTitleConstant.SMS_DOCUMENTATION;
		boolean result = validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}
	// method to validate Payment Docs page
		public boolean validatePaymentDocs() {
			String titleExpected = PageTitleConstant.PAYMENT_DOCUMENTATION;
			boolean result = validatePageTitle(titleExpected);
			if (result) {

				storeVerificationResults(true, "Page Title displayed");

			} else {

				storeVerificationResults(false, "Page Title not displayed");
			}
			return result;
		}

}
