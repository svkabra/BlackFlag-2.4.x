package ATT.Selenium_FVT.Utilities.Component;

import java.util.Iterator;
import java.util.Set;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.lift.find.PageTitleFinder;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.SupportOverviewPage;
import ATT.Selenium_FVT.Utilities.Browser.WebPage;

public class Footers extends WebPage{
	
	@FindBy(how = How.LINK_TEXT, using = "Terms of Use")
	public WebElement termConditions;

	// Page Object "Privacy Policy"
	@FindBy(how = How.LINK_TEXT, using = "Privacy Policy")
	public WebElement privacyPolicy;

	// Page Object "Log A Ticket"
	@FindBy(how = How.LINK_TEXT, using = "Submit a Ticket")
	public WebElement submitTicket;			
				
	// Page Object "Our APIs"
	@FindBy(how = How.LINK_TEXT, using ="Our APIs")
	public WebElement ourApis;
	
	// Page Object "AT&T Application Resource Optimizer"
	@FindBy(how = How.LINK_TEXT, using ="AT&T Application Resource Optimizer")
	public WebElement attAro;
		
	// Page Object "SDKs, Plugins, & More"
	@FindBy(how = How.LINK_TEXT, using ="SDKs, Plugins, & More")
	public WebElement sdk;
	
	// Page Object "AT&T Text Button"
	@FindBy(how = How.LINK_TEXT, using ="AT&T Text Button")
	public WebElement textButton;
		
	// Page Object "Contact Us"
	@FindBy(how = How.LINK_TEXT, using = "Contact Us")
	public WebElement contactUs;
	
	// Page Object "Technical Library"
	@FindBy(how = How.LINK_TEXT, using = "Technical Library")
	public WebElement techLib;
	
	// Page Object "2014 AT&T Intellectual Property"
	@FindBy(how = How.LINK_TEXT, using = "©2014 AT&T Intellectual Property.")
	public WebElement intProperty; 
	
	// Page Object "AT&T AppCenter for Consumer Apps"
	@FindBy(how = How.LINK_TEXT, using = "AT&T AppCenter for Consumer Apps")
	public WebElement consumerApp;
	
	// Page Object "AT&T Certified Solutions Catalog for B2B Apps"
	@FindBy(how = How.LINK_TEXT, using = "AT&T Certified Solutions Catalog for B2B Apps")
	public WebElement b2bApp;
	
	// Page Object "Device References and Specs"
	@FindBy(how = How.LINK_TEXT, using = "Device References and Specs")
	public WebElement device;
	
	// Page Object "Support Overview"
	@FindBy(how = How.LINK_TEXT, using = "Support Overview")
	public WebElement supportOverview;
    
	// Page Object "Live Chat"
	@FindBy(how = How.LINK_TEXT, using = "Live Chat")
	public WebElement liveChat;
    
	// Page Object "FAQs"
	@FindBy(how = How.LINK_TEXT, using = "FAQs")
	public WebElement faqs;
    
	// Page Object "Facebook"
	@FindBy(how = How.LINK_TEXT, using = "Facebook")
	public WebElement facebook;
	
	// Page Object "Twitter"
	@FindBy(how = How.LINK_TEXT, using = "Twitter")
	public WebElement twitter;
	
	// Page Object "GitHub"
	@FindBy(how = How.CLASS_NAME, using = "github")
	public WebElement github;
		
	public Footers(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}
	
	
	@Override
	public void openURL() {		
	//	PageFactory.initElements(driver,this);
	}
	
	/*Method to click on footer link "Facebook"*/	
	public Footers clickFacebookIcon(){	
		facebook.click();
		waitForPageToLoad();
		return this;
	}	
	
	/*Method to click on footer link "Twitter"*/	
	public Footers clickTwitterIcon(){		
		twitter.click();	
		waitForPageToLoad();	
		return this;
	}
	/*Method to click on footer link "Github"*/	
	public Footers clickGithubIcon(){	
		github.click();	
		waitForPageToLoad();
		return this;
	}	
	/*Method to click on footer link "Terms of Use"*/	
	public Footers clickTermsnCondition(){		
		 
		termConditions.click();	
		waitForPageToLoad();
		return this;
	}	
	
	/*Method to click on footer link "Privacy Policy"*/	
	public Footers clickPrivacynPolicy(){	
		String mwh=driver.getWindowHandle();
		privacyPolicy.click();		
		waitForPageToLoad();	
		Set s=driver.getWindowHandles();
		//this method will you handle of all opened windows

		Iterator ite=s.iterator();

		while(ite.hasNext())
		{
		    String popupHandle=ite.next().toString();
		    if(!popupHandle.contains(mwh))
		    {
		                driver.switchTo().window(popupHandle);
		                driver.close();
		                driver.switchTo().window(mwh);
		    }
		}
		return this;
	}
	
	/*Method to click on footer link "Our APIs"*/	
	public Footers clickOurApi(){	
		ourApis.click();
		waitForPageToLoad();
		return this;
	}	
	
	/*Method to click on footer link "AT&T AppCenter for Consumer Apps"*/	
	public Footers clickConsumerApp(){	
		consumerApp.click();
		waitForPageToLoad();
		return this;
	}	
	
	/*Method to click on footer link "AT&T Certified Solution Catalog for B2B Apps"*/	
	public Footers clickB2BApp(){	
		b2bApp.click();
		waitForPageToLoad();
		return this;
	}	
	
	/*Method to click on footer link "Device References and Specs"*/	
	public Footers clickDevice(){	
		device.click();
		waitForPageToLoad();
		return this;
	}	
	
	/*Method to click on footer link "Support Overview"*/	
	public SupportOverviewPage clickSupportOverview(){	
		supportOverview.click();
		waitForPageToLoad();
		return PageFactory.initElements(driver, SupportOverviewPage.class);
	}	
	
	/*Method to click on footer link "Live Chat"*/	
	public Footers clickLiveChat(){	
		liveChat.click();
		waitForPageToLoad();
		return this;
	}	
	
	/*Method to click on footer link "FAQs"*/	
	public Footers clickFaqs(){	
		faqs.click();
		waitForPageToLoad();
		return this;
	}	
	
	/*Method to click on footer link "AT&T Application Resource Optimizer"*/	
	public Footers clickAttAro(){	
		attAro.click();
		waitForPageToLoad();
		return this;
	}	
	
	/*Method to click on footer link "SDKs, Plugins & more"*/	
	public Footers clickSdkPlugin(){	
		sdk.click();
		waitForPageToLoad();
		return this;
	}	
	
	/*Method to click on footer link "AT&T TextButton"*/	
	public Footers clickTextButton(){	
		textButton.click();
		waitForPageToLoad();
		return this;
	}	
	/*Method to click on footer link "Technical Library"*/	
	public Footers clickTechnicalLib(){	
		techLib.click();
		waitForPageToLoad();
		return this;
	}	
	
	/*Method to click on footer link "Contact Us"*/	
	public Footers clickContactUs(){	
		contactUs.click();
		waitForPageToLoad();
		return this;
	}	
	/*Method to click on footer link "2014 AT&T Intellectual Property"*/
	public Footers clickCopyRight(){		
		String mwh=driver.getWindowHandle();
		intProperty.click();
		waitForPageToLoad();
		Set s=driver.getWindowHandles();
		//this method will you handle of all opened windows

		Iterator ite=s.iterator();

		while(ite.hasNext())
		{
		    String popupHandle=ite.next().toString();
		    if(!popupHandle.contains(mwh))
		    {
		                driver.switchTo().window(popupHandle);
		                driver.close();
		                driver.switchTo().window(mwh);
		    }
		}
		return this;
	}
	
	/* Method to click on Submit a Ticket tab from Dev portal page */	
	public Footers clickSubmitTicket(){	
		submitTicket.click();		
		waitForPageToLoad();
		return this;
	}		
	
	/*Method to validate page title on footer link "2014 AT&T Intellectual Property"*/
	public Boolean validateCopyRight(){	
		boolean result = false;
		String mwh = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite5 = s.iterator();

		while (ite5.hasNext()) {
			String popupHandle = ite5.next().toString();
			if (!popupHandle.contains(mwh)) {

				driver.switchTo().window(popupHandle);
				String titleExpected = PageTitleConstant.COPYRIGHT;
				String currentTitle = driver.getTitle();
				result = titleExpected.equalsIgnoreCase(currentTitle.trim());
				if (result) {

					storeVerificationResults(true, "Page Title displayed");

				} else {

					storeVerificationResults(false, "Page Title not displayed");
				}
				driver.close();
				driver.switchTo().window(mwh);

			}
		}

		return result;
	
	}
	
	/*Method to validate page title on footer link "Our APIs"*/	
	public Boolean validateOurApi(){	
		String titleExpected = PageTitleConstant.OUR_API;
		boolean result=validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}
	
	/*Method to validate page title on footer link "AT&T AppCenter for Consumer Apps"*/	
	public Boolean validateConsumerApp(){	
		String titleExpected = PageTitleConstant.CONSUMER_APP;
		boolean result=validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}	
	/*Method to validate page title on footer link "AT&T Certified Solution Catalog for B2B Apps"*/	
	public Boolean validateB2BApp(){	
		String titleExpected = PageTitleConstant.B2B_APP;
		boolean result=validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}	
	
	/*Method to validate page title on footer link "Device References and Specs"*/	
	public Boolean validateDevice(){	
		String titleExpected = PageTitleConstant.DEVICE;
		System.out.println(driver.getTitle());
		boolean result=validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}	
	
	/*Method to validate page title on footer link "Support Overview"*/	
	public Boolean validateSupportOverview(){	
		String titleExpected = PageTitleConstant.SUPPORT;
		boolean result=validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}	
	
	/*Method to validate page title on footer link "Live Chat"*/	
	public Boolean validateLiveChat(){	
			boolean result = false;
			String mwh = driver.getWindowHandle();
			Set<String> s = driver.getWindowHandles();
			Iterator<String> ite5 = s.iterator();

			while (ite5.hasNext()) {
				String popupHandle = ite5.next().toString();
				if (!popupHandle.contains(mwh)) {

					driver.switchTo().window(popupHandle);
					String titleExpected = PageTitleConstant.LIVE_CHAT;
					String currentTitle = driver.getTitle();
					result = titleExpected.equalsIgnoreCase(currentTitle.trim());
					if (result) {

						storeVerificationResults(true, "Page Title displayed");

					} else {

						storeVerificationResults(false, "Page Title not displayed");
					}
					driver.close();
					driver.switchTo().window(mwh);

				}
			}

			return result;
	}	
	
	/*Method to validate page title on footer link "FAQs"*/	
	public Boolean validateFaqs(){	
		boolean result = false;
		String mwh = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite5 = s.iterator();

		while (ite5.hasNext()) {
			String popupHandle = ite5.next().toString();
			if (!popupHandle.contains(mwh)) {

				driver.switchTo().window(popupHandle);
				String titleExpected = PageTitleConstant.FAQ;
				String currentTitle = driver.getTitle();
				result = titleExpected.equalsIgnoreCase(currentTitle.trim());
				if (result) {

					storeVerificationResults(true, "Page Title displayed");

				} else {

					storeVerificationResults(false, "Page Title not displayed");
				}
				driver.close();
				driver.switchTo().window(mwh);

			}
		}

		return result;
         
	}	
	
	/*Method to validate page title on footer link "AT&T Application Resource Optimizer"*/	
	public Boolean validateAttAro(){
		String titleExpected = PageTitleConstant.ARO;
		boolean result=validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}	
	
	/*Method to validate page title on footer link "SDKs, Plugins & more"*/	
	public Boolean validateSdkPlugin(){	
		String titleExpected = PageTitleConstant.SDK_PLUGINS_TOOLS;
		boolean result=validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}	
	
	/*Method to validate page title on footer link "AT&T TextButton"*/	
	public Boolean validateTextButton(){	
		String titleExpected = PageTitleConstant.TEXT_BUTTON;
		boolean result=validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}	
	
	/*Method to validate page title on footer link "Technical Library"*/	
	public Boolean validateTechnicalLib(){	
		String titleExpected = PageTitleConstant.TECHNICAL_LIBRARY;
		boolean result=validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}	
	
	/*Method to validate page title on footer link "Contact Us"*/	
	public Boolean validateContactUs(){	
		System.out.println(driver.getTitle());
		String titleExpected = PageTitleConstant.CONTACT_US;
		boolean result=validatePageTitle(titleExpected);
		if (result) {

			storeVerificationResults(true, "Page Title displayed");

		} else {

			storeVerificationResults(false, "Page Title not displayed");
		}
		return result;
	}	
	/*Method to validate page title on footer link "AT&T Terms and Conditions"*/	
	public Boolean validateTermsConditions(){	
		boolean result = false;
		String mwh = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite5 = s.iterator();

		while (ite5.hasNext()) {
			String popupHandle = ite5.next().toString();
			if (!popupHandle.contains(mwh)) {

				driver.switchTo().window(popupHandle);
				String titleExpected = PageTitleConstant.TERMS_OF_USE;
				String currentTitle = driver.getTitle();
				result = titleExpected.equalsIgnoreCase(currentTitle.trim());
				if (result) {

					storeVerificationResults(true, "Page Title displayed");

				} else {

					storeVerificationResults(false, "Page Title not displayed");
				}
				driver.close();
				driver.switchTo().window(mwh);

			}
		}

		return result;
	}	
	/*Method to validate page title on footer link "Facebook"*/	
	public Boolean validateFacebookIcon(){		
		boolean result = false;
		String mwh = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite5 = s.iterator();

		while (ite5.hasNext()) {
			String popupHandle = ite5.next().toString();
			if (!popupHandle.contains(mwh)) {

				driver.switchTo().window(popupHandle);
				String titleExpected = PageTitleConstant.FACEBOOK;
				String currentTitle = driver.getTitle();
				result = titleExpected.equalsIgnoreCase(currentTitle.trim());
				if (result) {

					storeVerificationResults(true, "Page Title displayed");

				} else {

					storeVerificationResults(false, "Page Title not displayed");
				}
				driver.close();
				driver.switchTo().window(mwh);

			}
		}

		return result;
         
	}
	/*Method to validate page title on footer link "Twitter"*/	
	public Boolean validateTwitterIcon(){
		boolean result = false;
		String mwh = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite5 = s.iterator();

		while (ite5.hasNext()) {
			String popupHandle = ite5.next().toString();
			if (!popupHandle.contains(mwh)) {

				driver.switchTo().window(popupHandle);
				String titleExpected = PageTitleConstant.TWITTER;
				String currentTitle = driver.getTitle();
				result = titleExpected.equalsIgnoreCase(currentTitle.trim());
				if (result) {

					storeVerificationResults(true, "Page Title displayed");

				} else {

					storeVerificationResults(false, "Page Title not displayed");
				}
				driver.close();
				driver.switchTo().window(mwh);

			}
		}

		return result;

	}
	
	/*Method to validate page title on footer link "Github"*/	
	public Boolean validateGithubIcon(){		
		boolean result = false;
		String mwh = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite5 = s.iterator();

		while (ite5.hasNext()) {
			String popupHandle = ite5.next().toString();
			if (!popupHandle.contains(mwh)) {

				driver.switchTo().window(popupHandle);
				String titleExpected = PageTitleConstant.GITHUB;
				String currentTitle = driver.getTitle();
				result = titleExpected.equalsIgnoreCase(currentTitle.trim());
				if (result) {

					storeVerificationResults(true, "Page Title displayed");

				} else {

					storeVerificationResults(false, "Page Title not displayed");
				}
				driver.close();
				driver.switchTo().window(mwh);

			}
		}

		return result;
         
	}
	/*Method to validate page title on footer link "Privacy Policy"*/	
	public Boolean validatePrivacyPolicy(){
		boolean result = false;
		String mwh = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite5 = s.iterator();

		while (ite5.hasNext()) {
			String popupHandle = ite5.next().toString();
			if (!popupHandle.contains(mwh)) {

				driver.switchTo().window(popupHandle);
				String titleExpected = PageTitleConstant.PRIVACY_POLICY;
				String currentTitle = driver.getTitle();
				result = titleExpected.equalsIgnoreCase(currentTitle.trim());
				if (result) {

					storeVerificationResults(true, "Page Title displayed");

				} else {

					storeVerificationResults(false, "Page Title not displayed");
				}
				driver.close();
				driver.switchTo().window(mwh);

			}
		}

		return result;
	}
	/* Method to validate page title on Submit a Ticket tab from Dev portal page */	
	public Boolean validateSubmitTicket(){	
		boolean result = false;
		String mwh = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite5 = s.iterator();

		while (ite5.hasNext()) {
			String popupHandle = ite5.next().toString();
			if (!popupHandle.contains(mwh)) {

				driver.switchTo().window(popupHandle);
				String titleExpected = PageTitleConstant.PRIVACY_POLICY; //this functionality is not working. A ticket has been logged for the same. 
				String currentTitle = driver.getTitle();
				result = titleExpected.equalsIgnoreCase(currentTitle.trim());
				if (result) {

					storeVerificationResults(true, "Page Title displayed");

				} else {

					storeVerificationResults(false, "Page Title not displayed");
				}
				driver.close();
				driver.switchTo().window(mwh);

			}
		}

		return result;
	}
	
	/* Method to Initialize APIMLoginPage */
	public APIMLoginPage apimLoginPage(){
		waitForPageToLoad();
		return PageFactory.initElements(driver, APIMLoginPage.class);
	}	
	
	
	
}

