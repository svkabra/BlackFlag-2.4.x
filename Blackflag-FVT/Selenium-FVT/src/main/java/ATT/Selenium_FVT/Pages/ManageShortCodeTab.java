package ATT.Selenium_FVT.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import ATT.Selenium_FVT.Utilities.Component.Component;
import ATT.Selenium_FVT.Utilities.Component.Constants;

public class ManageShortCodeTab extends Component {

	// WebElement shortCodeNewForm =
	// me.findElement(By.id("shortcode_form_cont")).findElement(By.id("new_shortcode"));

	// Page Object "Short Code Description"
	@FindBy(id = "shortcode_description")
	WebElement shortCodeDescription;

	// Page Object "SMS Mo Uri
	@FindBy(id = "shortcode_sms_mobile_originated_uri")
	WebElement smsMoUri;

	// Page Object "SMS Delivery Notification URI
	@FindBy(id = "shortcode_sms_delivery_notification_uri")
	WebElement smsDeliveryNotificationUri;

	// Page Object "MMS MO URI"
	@FindBy(id = "shortcode_mms_mobile_originated_uri")
	WebElement mmsMoUri;

	// Page Object "MMS Delivery Notification URI"
	@FindBy(id = "shortcode_mms_delivery_notification_uri")
	WebElement mmsDeliveryNotificationUri;

	// Page Object "Custom Short Code"
	@FindBy(id = "shortcode_shortcode")
	WebElement customShortCode;

	// Page Object "Short Code Type"
	@FindBy(id = "shortcode_shortcode_type")
	WebElement shortCodeType;

	// Page Object "Short Code Rating"
	@FindBy(id = "shortcode_rating")
	WebElement shortCodeRating;

	// Default Constructor
	public ManageShortCodeTab(WebDriver driver, WebElement manageShortCode) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDispalyed() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * method to click Add button
	 */
	public ManageShortCodeTab clickAddShortCode() {
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_LONG);
		driver.findElement(By.className("add_shortcode")).click();
		waitForAjaxInactivity();
		return this;

	}

	/*
	 * method to click Edit button
	 */
	public ManageShortCodeTab clickEditShortCode() {
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_LONG);
		driver.findElement(By.id("edit_shortcode_btn_4255")).click();
		waitForAjaxInactivity();
		return this;

	}

	/*
	 * method to select ShortCode Rating
	 */
	public ManageShortCodeTab selectShortCodeRating(String ratingOption) {
		Select rating = new Select(
				driver.findElement(By.id("shortcode_rating")));
		rating.selectByValue(ratingOption);
		waitForAjaxInactivity();
		return this;
	}

	/*
	 * method to select ShortCode Type
	 */
	public ManageShortCodeTab selectShortCodeType(String typeOption) {
		Select rating = new Select(driver.findElement(By
				.id("shortcode_shortcode_type")));
		rating.selectByValue(typeOption);
		waitForAjaxInactivity();
		return this;
	}

	/*
	 * method to enter ShortCode Description
	 */
	public ManageShortCodeTab enterShortCodeDescription(String description) {

		driver.findElement(By.id("shortcode_rating")).sendKeys(Keys.TAB);
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_LONG);
		shortCodeDescription.click();
		shortCodeDescription.sendKeys(description);
		return this;
	}

	/*
	 * method to enter Custom Shortcode
	 */
	public ManageShortCodeTab enterCustomShortCode(String customShortCodes) {

		customShortCode.sendKeys(customShortCodes);
		return this;

	}

	/*
	 * method to validate short code description field is displayed
	 */
	public ManageShortCodeTab ShortCodeDescriptionDisplayed() {

		validateWebElementDisplayed(shortCodeDescription);
		return this;

	}

	/*
	 * method to enter SMS MO URI
	 */
	public ManageShortCodeTab enterSMSMobileOriginatedURI(String originatedURI) {

		smsMoUri.sendKeys(originatedURI);
		return this;

	}

	/*
	 * method to validate SMS MO URI field is displayed
	 */
	public ManageShortCodeTab SMSMobileOriginatedURIValidation() {

		validateWebElementDisplayed(smsMoUri);
		return this;

	}

	/*
	 * method to enter SMS Delivery Notification URI
	 */
	public ManageShortCodeTab enterSMSNotificationURI(String notificationURI) {

		smsDeliveryNotificationUri.sendKeys(notificationURI);
		return this;
	}

	/*
	 * method to validate SMS Delivery Notification URI is displayed
	 */
	public ManageShortCodeTab SMSNotificationURIDisplayed() {

		validateWebElementDisplayed(smsDeliveryNotificationUri);
		return this;
	}

	/*
	 * method to enter MMS MO URI
	 */
	public ManageShortCodeTab enterMMSMobileOriginatedURL(String originatedURI) {

		mmsMoUri.sendKeys(originatedURI);
		return this;

	}

	/*
	 * method to validate MMS MO URI is displayed
	 */
	public ManageShortCodeTab MMSMobileOriginatedURL() {
		validateWebElementDisplayed(mmsMoUri);
		return this;

	}

	/*
	 * method to enter MMS Delivery Notification URI
	 */
	public ManageShortCodeTab enterMMSNotificationURI(String notificationURI) {

		driver.findElement(By.xpath("String")).sendKeys(Keys.TAB);
		mmsDeliveryNotificationUri.sendKeys(notificationURI);
		return this;
	}

	/*
	 * method to validate MMS Delivery Notification URI is displayed
	 */
	public ManageShortCodeTab MMSNotificationURIDisplayed() {
		validateWebElementDisplayed(mmsDeliveryNotificationUri);
		return this;
	}

	/*
	 * method to return offline Shortcode
	 */
	public String getOfflineShortCode() {
		implicitWait(Constants.PAGE_WAIT_INTER_SYSTEM);
		return driver.findElement(By.className("shortcodetable"))
				.findElement(By.xpath("table/tbody/tr[2]/td[4]")).getText();

	}

	/*
	 * method to return online Shortcode
	 */
	public String getOnlineShortCode() {
		implicitWait(Constants.PAGE_WAIT_INTER_SYSTEM);
		return driver.findElement(By.className("shortcodetable"))
				.findElement(By.xpath("table/tbody/tr[3]/td[4]")).getText();
	}

	/*
	 * method to return Type of Shortcode
	 */
	public String getTypeOfShortCode() {
		implicitWait(Constants.PAGE_WAIT_INTER_SYSTEM);
		return driver.findElement(By.className("shortcodetable"))
				.findElement(By.xpath("table/tbody/tr/td")).getText();

	}

	/*
	 * method to return Type of Shortcode
	 */
	public String getRatingOfShortCode() {
		implicitWait(Constants.PAGE_WAIT_INTER_SYSTEM);
		return driver.findElement(By.className("shortcodetable"))
				.findElement(By.xpath("table/tbody/tr/td[2]")).getText();

	}

	/*
	 * method to validate the Type of ShortCode
	 */
	public ManageShortCodeTab validateTypeOfShortCode(String typeGenerated,
			String typeActual) {

		if (typeGenerated.equalsIgnoreCase(typeActual))
			storeVerificationResults(true, "ShortCode Type matched");
		else
			storeVerificationResults(false, "ShortCode Type not matched");

		return this;

	}

	/*
	 * method to validate the Type of ShortCode
	 */
	public ManageShortCodeTab validateRatingOfShortCode(String ratingGenerated,
			String ratingActual) {

		if (ratingGenerated.equalsIgnoreCase(ratingActual))
			storeVerificationResults(true, "ShortCode Rating matched");
		else
			storeVerificationResults(false, "ShortCode Rating not matched");

		return this;

	}

	/*
	 * method to validate ShortCode Added
	 */
	public ManageShortCodeTab validateShortCodeAdded(String shortCode) {

		if (shortCode != "")
			storeVerificationResults(true, "ShortCode Added");
		else
			storeVerificationResults(false, "ShortCode not Added");

		return this;

	}

	/*
	 * method to verify that only Standard Present in the Rating DropDown box
	 */
	public boolean verifyRatingStandardMmsApp() {
		try {
			selectShortCodeRating("zero_rated");
			storeVerificationResults(false, "zero_rated Rating Found");
			return false;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			selectShortCodeRating("standard");
			storeVerificationResults(true, "zero_rated Rating not Found");
			return true;
		}
	}

	/*
	 * method to save ShortCode details
	 */
	public ManageShortCodeTab clickCSCA_Link() {
		driver.findElement(By.linkText("CSCA")).click();

		waitForAjaxInactivity();

		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_LONG);
		String titleCaptured = driver.getTitle();

		String titleActual = "Common Short Codes | Get a Short Code & Grow Mobile Marketing Revenue";
		if (titleCaptured.equalsIgnoreCase(titleActual)) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}

		return this;
	}

	/*
	 * method to save ShortCode details
	 */
	public ManageShortCodeTab saveShortCodeDetails() {
		driver.findElement(By.id("submit_shortcode")).click();
		waitForAjaxInactivity();
		return this;
	}

	/*
	 * method to save ShortCode details
	 */
	public ManageShortCodeTab cancelShortCodeDetails() {
		driver.findElement(By.id("cancel_shortcode")).click();
		waitForAjaxInactivity();
		return this;
	}

}
