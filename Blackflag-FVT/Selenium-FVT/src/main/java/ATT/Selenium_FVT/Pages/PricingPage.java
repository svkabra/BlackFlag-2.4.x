package ATT.Selenium_FVT.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ATT.Selenium_FVT.Utilities.Browser.WebPage;

public class PricingPage extends WebPage {

	// Page Object "APIs"
	@FindBy(how = How.LINK_TEXT, using = "Go to My Apps")
	public WebElement goToMyAppLink;

	// Page Object "Pricing"
	@FindBy(how = How.LINK_TEXT, using = "Pricing")
	public WebElement pricing;

	// Page Object "SpeechPricingInformation"
	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/pricing/details#pricingDetails-speech')]")
	public WebElement speechPricingInformation;

	// Page Object "DeviceCapabilitiesPricingInformation"
	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/pricing/details#pricingDetails-deviceCapability')]")
	public WebElement deviceCapabilitiesPricingInformation;

	// Page Object "InAppMessagingPricingInformation"
	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/pricing/details#pricingDetails-inAppMessaging')]")
	public WebElement inAppMessagingPricingInformation;

	// Page Object "SMSMMSPricingInformation"
	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/pricing/details#pricingDetails-messaging')]")
	public WebElement sMSMMSPricingInformation;

	// Page Object "AdvertisingPricingInformation"
	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/pricing/details#pricingDetails-advertising')]")
	public WebElement advertisingPricingInformation;

	// Page Object "PaymentPricingInformation"
	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/pricing/details#pricingDetails-payment')]")
	public WebElement paymentPricingInformation;

	// Page Object "ATTmHealthPricingInformation"
	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/pricing/details#pricingDetails-mHealth')]")
	public WebElement aTTmHealthPricingInformation;

	// Page Object "ATTM2XPricingInformation"
	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/pricing/details#pricingDetails-m2x')]")
	public WebElement aTTM2XPricingInformation;

	// Page Object "ATTUverseEnabledPricingInformation"
	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/pricing/details#pricingDetails-uverseEnabled')]")
	public WebElement aTTUverseEnabledPricingInformation;

	// Page Object "ATTAROPricingInformation"
	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/pricing/details#pricingDetails-aro')]")
	public WebElement aTTAROPricingInformation;

	// Page Object "MobileIdentityAPIToolkitPricingInformation"
	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/pricing/mobile-identity-toolkit-pricing-details')]")
	public WebElement mobIdAPITlktPricingInformation;

	// Page Object "ATTSponsoredDataPricingInformation"
	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/pricing/sponsored-data-pricing-details')]")
	public WebElement aTTSponsoredDataPricingInformation;

	// Parameterized Constructor
	public PricingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openURL() {
		// TODO Auto-generated method stub

	}

	/* Method to Initialize APIMLoginPage */
	public APIMLoginPage apimLoginPage() {
		waitForPageToLoad();
		return PageFactory.initElements(driver, APIMLoginPage.class);
	}

	public PricingPage clickGoToMyApp() {

		goToMyAppLink.click();
		waitForPageToLoad();
		validatePageTitle("API Matrix");
		return this;
	}

	/* Method to click on Pricing Information for Speech */
	public PricingPage clickSpeechPricingInformation() {
		pricing.click();
		waitForPageToLoad();
		speechPricingInformation.click();
		waitForPageToLoad();
		validatePageTitle("AT&T API Platform Pricing Details | AT&T Developer");
		return this;
	}

	/* Method to click on Pricing Information for Device Capabilities */
	public PricingPage clickDeviceCapabilitiesPricingInformation() {
		pricing.click();
		waitForPageToLoad();
		deviceCapabilitiesPricingInformation.click();
		waitForPageToLoad();
		validatePageTitle("AT&T API Platform Pricing Details | AT&T Developer");
		return this;
	}

	/* Method to click on Pricing Information for In-App Messaging */
	public PricingPage clickInAppMessagingPricingInformation() {
		pricing.click();
		waitForPageToLoad();
		inAppMessagingPricingInformation.click();
		waitForPageToLoad();
		validatePageTitle("AT&T API Platform Pricing Details | AT&T Developer");
		return this;
	}

	/* Method to click on Pricing Information for SMS/MMS */
	public PricingPage clickSMSMMSPricingInformation() {
		pricing.click();
		waitForPageToLoad();
		sMSMMSPricingInformation.click();
		waitForPageToLoad();
		validatePageTitle("AT&T API Platform Pricing Details | AT&T Developer");
		return this;
	}

	/* Method to click on Pricing Information for Payment */
	public PricingPage clickPaymentPricingInformation() {
		pricing.click();
		waitForPageToLoad();
		paymentPricingInformation.click();
		waitForPageToLoad();
		validatePageTitle("AT&T API Platform Pricing Details | AT&T Developer");
		return this;
	}

	/* Method to click on Pricing Information for Advertising */
	public PricingPage clickAdvertisingPricingInformation() {
		pricing.click();
		waitForPageToLoad();
		advertisingPricingInformation.click();
		waitForPageToLoad();
		validatePageTitle("AT&T API Platform Pricing Details | AT&T Developer");
		return this;
	}

	/* Method to click on Pricing Information for AT&T mHealth */
	public PricingPage clickATTmHealthPricingInformation() {
		pricing.click();
		waitForPageToLoad();
		aTTmHealthPricingInformation.click();
		waitForPageToLoad();
		validatePageTitle("AT&T API Platform Pricing Details | AT&T Developer");
		return this;
	}

	/* Method to click on Pricing Information for AT&T M2X */
	public PricingPage clickATTM2XPricingInformation() {
		pricing.click();
		waitForPageToLoad();
		aTTM2XPricingInformation.click();
		waitForPageToLoad();
		validatePageTitle("AT&T API Platform Pricing Details | AT&T Developer");
		return this;
	}

	/* Method to click on Pricing Information for AT&T U-verse Enabled */
	public PricingPage clickATTUverseEnabledPricingInformation() {
		pricing.click();
		waitForPageToLoad();
		aTTUverseEnabledPricingInformation.click();
		waitForPageToLoad();
		validatePageTitle("AT&T API Platform Pricing Details | AT&T Developer");
		return this;
	}

	/* Method to click on Pricing Information for AT&T ARO */
	public PricingPage clickATTAROPricingInformation() {
		pricing.click();
		waitForPageToLoad();
		aTTAROPricingInformation.click();
		waitForPageToLoad();
		validatePageTitle("AT&T API Platform Pricing Details | AT&T Developer");
		return this;
	}

	/* Method to click on Pricing Information for Mobile Identity Toolkit */
	public PricingPage clickMobIdTlktPricingInformation() {
		pricing.click();
		waitForPageToLoad();
		mobIdAPITlktPricingInformation.click();
		waitForPageToLoad();
		validatePageTitle("AT&T API Platform Pricing Details | AT&T Developer");
		return this;
	}

	/* Method to click on Pricing Information for AT&T Sponsored Data */
	public PricingPage clickATTSponsoredDataPricingInformation() {
		pricing.click();
		waitForPageToLoad();
		aTTSponsoredDataPricingInformation.click();
		waitForPageToLoad();
		validatePageTitle("AT&T API Platform Pricing Details | AT&T Developer");
		return this;
	}
}
