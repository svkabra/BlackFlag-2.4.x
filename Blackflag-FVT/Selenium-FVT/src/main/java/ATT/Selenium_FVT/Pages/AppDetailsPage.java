package ATT.Selenium_FVT.Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ATT.Selenium_FVT.Utilities.Browser.WebPage;

public class AppDetailsPage extends WebPage {

	
	// Page Object "00001TestApp"
	@FindBy(how = How.LINK_TEXT, using = "00001TestApp")
	public WebElement testAIPsApp;

	// Page Object "Advertising"
	@FindBy(xpath = "//*[@id='content']/div/div[3]/div[2]/div[2]/div[2]/span[2]/a[1]/div/span[2]")
	public WebElement advertising;

	// Page Object "DeviceCapabilities"
	@FindBy(xpath = "//*[@id='content']/div/div[3]/div[2]/div[2]/div[2]/span[2]/a[2]/div/span[2]")
	public WebElement deviceCapabilities;

	// Page Object " InAppMessagingIMMN"
	@FindBy(xpath = "//*[@id='content']/div/div[3]/div[2]/div[2]/div[2]/span[2]/a[3]/div/span[2]")
	public WebElement inAppMessagingIMMN;

	// Page Object "InAppMessagingMIM"
	@FindBy(xpath = "//*[@id='content']/div/div[3]/div[2]/div[2]/div[2]/span[2]/a[4]/div/span[2]")
	public WebElement inAppMessagingMIM;

	// Page Object "MultimediaMessagingService(MMS)"
	@FindBy(xpath = "//*[@id='content']/div/div[3]/div[2]/div[2]/div[2]/span[2]/a[5]/div/span[2]")
	public WebElement multimediaMessagingService;

	// Page Object " Payment "
	@FindBy(xpath = "//*[@id='content']/div/div[3]/div[2]/div[2]/div[2]/span[2]/a[6]/div/span[2]")
	public WebElement payment;

	// Page Object " ShortMessagingService(SMS) "
	@FindBy(xpath = "//*[@id='content']/div/div[3]/div[2]/div[2]/div[2]/span[2]/a[7]/div/span[2]")
	public WebElement shortMessagingService;

	// Page Object " Speech To Text Custom (STTC) "
	@FindBy(xpath = "//*[@id='content']/div/div[3]/div[2]/div[2]/div[2]/span[2]/a[8]/div/span[2]")
	public WebElement speechTTextCustomSTTC;

	// Page Object " Speech To Text (SPEECH) "
	@FindBy(xpath = "//*[@id='content']/div/div[3]/div[2]/div[2]/div[2]/span[2]/a[9]/div/span[2]")
	public WebElement speechToTextSpeech;

	// Page Object " Terminal Location "
	@FindBy(xpath = "//*[@id='content']/div/div[3]/div[2]/div[2]/div[2]/span[2]/a[10]/div/span[2]")
	public WebElement terminalLocation;

	// Page Object " Text to Speech (TTS) "
	@FindBy(xpath = "//*[@id='content']/div/div[3]/div[2]/div[2]/div[2]/span[2]/a[11]/div/span[2]")
	public WebElement textToSpeechTTS;

	// Page Object "Advertising"
	@FindBy(xpath = "//*[@id='app-list']/div[3]/div[1]/div[4]/a[1]/div/span[2]")
	public WebElement myAppAdvertising;

	// Page Object "DeviceCapabilities"
	@FindBy(xpath = "//*[@id='app-list']/div[3]/div[1]/div[4]/a[2]/div/span[2]")
	public WebElement myAppDeviceCapabilities;

	// Page Object " InAppMessagingIMMN"
	@FindBy(xpath = "//*[@id='app-list']/div[3]/div[1]/div[4]/a[3]/div/span[2]")
	public WebElement myAppInAppMessagingIMMN;

	// Page Object "InAppMessagingMIM"
	@FindBy(xpath = "//*[@id='app-list']/div[3]/div[1]/div[4]/a[4]/div/span[2]")
	public WebElement myAppInAppMessagingMIM;

	// Page Object "Notification"
	@FindBy(linkText = "Notifications")
	public WebElement notifications;

	// Page Object "MultimediaMessagingService(MMS)"
	@FindBy(xpath = "//*[@id='app-list']/div[3]/div[1]/div[4]/a[5]/div/span[2]")
	public WebElement myAppMultimediaMessagingService;

	// Page Object " Payment "
	@FindBy(xpath = "//*[@id='app-list']/div[3]/div[1]/div[4]/a[6]/div/span[2]")
	public WebElement myAppPayment;

	// Page Object "NotaryDocumentation"
	@FindBy(linkText = "Notary Documentation")
	public WebElement notaryDocumentation;

	// Page Object " ShortMessagingService(SMS) "
	@FindBy(xpath = "//*[@id='app-list']/div[3]/div[1]/div[4]/a[7]/div/span[2]")
	public WebElement myAppShortMessagingService;

	// Page Object " Speech To Text Custom (STTC) "
	@FindBy(xpath = "//*[@id='app-list']/div[3]/div[1]/div[4]/a[10]/div/span[2]")
	public WebElement myAppSpeechTTextCustomSTTC;

	// Page Object " Speech To Text (SPEECH) "
	@FindBy(xpath = "//*[@id='app-list']/div[3]/div[1]/div[4]/a[11]/div/span[2]")
	public WebElement myAppSpeechToTextSpeech;

	// Page Object " Terminal Location "
	@FindBy(xpath = "//*[@id='app-list']/div[3]/div[1]/div[4]/a[12]/div/span[2]")
	public WebElement myAppTerminalLocation;

	// Page Object " Text to Speech (TTS) "
	@FindBy(xpath = "//*[@id='app-list']/div[3]/div[1]/div[4]/a[13]/div/span[2]")
	public WebElement myAppTextToSpeechTTS;

	public AppDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	/* Method to Initialize APIMLoginPage */
	public APIMLoginPage apimLoginPage() {
		waitForPageToLoad();
		return PageFactory.initElements(driver, APIMLoginPage.class);
	}

	@Override
	public void openURL() {
		// PageFactory.initElements(driver,this);
	}

	// Function to click on Advertising API doc icon on App Details page
	public AppDetailsPage clickAdvertisingAPIDocumentation() {

		testAIPsApp.click();
		waitForPageToLoad();
		advertising.click();
		waitForPageToLoad();
		validatePageTitle("Advertising Documentation");
		return this;
	}

	// Function to click on Device Capabilities API doc icon on App Details page
	public AppDetailsPage clickDeviceCapabilitiesAPIDocumentation() {

		testAIPsApp.click();
		waitForPageToLoad();
		deviceCapabilities.click();
		waitForPageToLoad();
		validatePageTitle("AT&T Device Capabilities API  | AT&T Developer");
		return this;
	}

	// Function to click on In app Messaging IMMN API doc icon on App Details
	// page
	public AppDetailsPage clickInAppMessagingIMMNAPIDocumentation() {

		testAIPsApp.click();
		waitForPageToLoad();
		inAppMessagingIMMN.click();
		waitForPageToLoad();
		validatePageTitle("In-App Messaging Documentation");
		return this;
	}

	// Function to click on In ap Messaging MIM API doc icon on App Details page
	public AppDetailsPage clickInAppMessagingMIMAPIDocumentation() {

		testAIPsApp.click();
		waitForPageToLoad();
		inAppMessagingMIM.click();
		waitForPageToLoad();
		validatePageTitle("In-App Messaging Documentation");
		return this;
	}

	// Function to click on MMS API doc icon on App Details page
	public AppDetailsPage clickMMSAPIDocumentation() {
		testAIPsApp.click();
		waitForPageToLoad();
		multimediaMessagingService.click();
		waitForPageToLoad();
		validatePageTitle("MMS Documentation");
		return this;
	}

	// Function to click on Payment API doc icon on App Details page
	public AppDetailsPage clickPaymentAPIDocumentation() {
		
		testAIPsApp.click();
		waitForPageToLoad();
		payment.click();
		waitForPageToLoad();
		validatePageTitle("Payment Documentation");
		return this;
	}

	// Function to click on SMS API doc icon on App Details page
	public AppDetailsPage clickSMSAPIDocumentation() {

		testAIPsApp.click();
		waitForPageToLoad();
		shortMessagingService.click();
		waitForPageToLoad();
		validatePageTitle("SMS Documentation");
		return this;
	}

	// Function to click on Speech To Text Custom STTC API doc icon on App
	// Details page
	public AppDetailsPage clickSpeechToTextCustomAPIDocumentation() {
		
		testAIPsApp.click();
		waitForPageToLoad();
		speechTTextCustomSTTC.click();
		waitForPageToLoad();
		validatePageTitle("Speech Documentation");
		return this;
	}

	// Function to click on Speech To Text (speech) API doc icon on App Details
	// page
	public AppDetailsPage clickSpeechToTextAPIDocumentation() {
		
		testAIPsApp.click();
		waitForPageToLoad();
		speechToTextSpeech.click();
		waitForPageToLoad();
		validatePageTitle("Speech Documentation");
		return this;
	}

	// Function to click on Terminal Location API doc icon on App Details page
	public AppDetailsPage clickTerminalLocationAPIDocumentation() {
		
		testAIPsApp.click();
		waitForPageToLoad();
		terminalLocation.click();
		waitForPageToLoad();
		validatePageTitle("AT&T APIs | Build Speech, Messaging, & Payment into your mobile app | AT&T Developer");
		return this;
	}

	// Function to click on Text To Speech API doc icon on App Details page
	public AppDetailsPage clickTextToSpeechAPIDocumentation() {
		
		testAIPsApp.click();
		waitForPageToLoad();
		textToSpeechTTS.click();
		waitForPageToLoad();
		validatePageTitle("Speech Documentation");
		return this;
	}

	// Function to click on Advertising API doc icon on My Apps page
	public AppDetailsPage clickAdvertisingAPIDocumentationMyApps() {

		myAppAdvertising.click();
		waitForPageToLoad();
		validatePageTitle("Advertising Documentation");
		return this;
	}

	// Function to click on Device Capabilities API doc icon on My Apps page
	public AppDetailsPage clickDeviceCapabilitiesAPIDocumentationMyApps() {

		myAppDeviceCapabilities.click();
		waitForPageToLoad();
		validatePageTitle("AT&T Device Capabilities API  | AT&T Developer");
		return this;
	}

	// Function to click on In app Messaging IMMN API doc icon on My Apps page
	public AppDetailsPage clickInAppMessagingIMMNAPIDocumentationMyApps() {

		myAppInAppMessagingIMMN.click();
		waitForPageToLoad();
		validatePageTitle("In-App Messaging Documentation");
		return this;
	}

	// Function to click on Notification on In app Messaging IMMN API doc
	public AppDetailsPage clickInAppMessagingIMMNAPIDocNotification() {

		myAppInAppMessagingIMMN.click();
		waitForPageToLoad();
		validatePageTitle("In-App Messaging Documentation");
		String mwh = driver.getWindowHandle();
		notifications.click();
		waitForPageToLoad();
		Set<String> s = driver.getWindowHandles();

		Iterator<String> ite = s.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			if (!popupHandle.contains(mwh)) {
				driver.switchTo().window(popupHandle);
				validatePageTitle("in-app-messaging.pdf");
				driver.close();
				driver.switchTo().window(mwh);
			}
		}
		return this;

	}

	// Function to click on In app Messaging MIM API doc icon on My Apps page
	public AppDetailsPage clickInAppMessagingMIMAPIDocumentationMyApps() {

		myAppInAppMessagingMIM.click();
		waitForPageToLoad();
		validatePageTitle("In-App Messaging Documentation");
		return this;
	}

	// Function to click on Notification on In app Messaging MIM API doc
	public AppDetailsPage clickInAppMessagingMIMAPIDocNotification() {

		myAppInAppMessagingMIM.click();
		waitForPageToLoad();
		validatePageTitle("In-App Messaging Documentation");
		String mwh = driver.getWindowHandle();
		notifications.click();
		waitForPageToLoad();
		Set<String> s = driver.getWindowHandles();

		Iterator<String> ite = s.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			if (!popupHandle.contains(mwh)) {
				driver.switchTo().window(popupHandle);
				validatePageTitle("in-app-messaging.pdf");
				driver.close();
				driver.switchTo().window(mwh);
			}
		}
		return this;
	}

	// Function to click on MMS API doc icon on My Apps page
	public AppDetailsPage clickMMSAPIDocumentationMyApps() {
		myAppMultimediaMessagingService.click();
		waitForPageToLoad();
		validatePageTitle("MMS Documentation");
		return this;
	}

	// Function to click on Payment API doc icon on My Apps page
	public AppDetailsPage clickPaymentAPIDocumentationMyApps() {

		myAppPayment.click();
		waitForPageToLoad();
		validatePageTitle("Payment Documentation");
		return this;
	}

	// Function to click on Notary Documentation icon on Payment API doc
	public AppDetailsPage clickPaymentAPIDocNotaryDoc() {
		myAppPayment.click();
		waitForPageToLoad();
		validatePageTitle("Payment Documentation");
		notaryDocumentation.click();
		waitForPageToLoad();
		validatePageTitle("Notary Management API v1");
		return this;

	}

	// Function to click on SMS API doc icon on My Apps page
	public AppDetailsPage clickSMSAPIDocumentationMyApps() {
		
		myAppShortMessagingService.click();
		waitForPageToLoad();
		validatePageTitle("SMS Documentation");
		return this;
	}

	// Function to click on Speech To Text Custom STTC API doc icon on My Apps
	// page
	public AppDetailsPage clickSpeechToTextCustomAPIDocumentationMyApps() {
		
		myAppSpeechTTextCustomSTTC.click();
		waitForPageToLoad();
		validatePageTitle("Speech Documentation");
		return this;
	}

	// Function to click on Speech To Text (speech) API doc icon on My Apps page
	public AppDetailsPage clickSpeechToTextAPIDocumentationMyApps() {
		myAppSpeechToTextSpeech.click();
		waitForPageToLoad();
		validatePageTitle("Speech Documentation");
		return this;
	}

	// Function to click on Terminal Location API doc icon on My Apps page
	public AppDetailsPage clickTerminalLocationAPIDocumentationMyApps() {

		myAppTerminalLocation.click();
		waitForPageToLoad();
		validatePageTitle("AT&T APIs | Build Speech, Messaging, & Payment into your mobile app | AT&T Developer");
		return this;
	}

	// Function to click on Text To Speech API doc icon on My Apps page
	public AppDetailsPage clickTextToSpeechAPIDocumentationMyApps() {

		myAppTextToSpeechTTS.click();
		waitForPageToLoad();
		validatePageTitle("Speech Documentation");
		return this;
	}
}
