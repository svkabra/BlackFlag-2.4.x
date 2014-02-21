package ATT.Selenium_FVT.Pages;

import java.util.Iterator;
import java.util.Set;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ATT.Selenium_FVT.Utilities.Browser.WebPage;
import ATT.Selenium_FVT.Utilities.Component.Constants;
import ATT.Selenium_FVT.Utilities.Component.PageTitleConstant;

public class SupportOverviewPage extends WebPage {

	// Page Object "Visit Forums"
	@FindBy(how = How.LINK_TEXT, using = "Visit Forums")
	private WebElement visitForums;

	// Page Object "Visit FAQS"
	@FindBy(how = How.LINK_TEXT, using = "Visit FAQs Page")
	private WebElement visitFaqs;

	// Page Object "Chat Live"
	@FindBy(how = How.LINK_TEXT, using = "Chat Live")
	private WebElement chatLive;

	// Parameterized Constructors
	public SupportOverviewPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openURL() {
		// TODO Auto-generated method stub

	}

	// method to go to Visit Forums
	public SupportOverviewPage clickVisitForums() {
		visitForums.click();
		waitForPageToLoad();

		return this;
	}

	// method to validate Visit forums page
	public boolean validateVisitForums() {
		boolean result = false;
		String mwh = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite5 = s.iterator();

		while (ite5.hasNext()) {
			String popupHandle = ite5.next().toString();
			if (!popupHandle.contains(mwh)) {

				driver.switchTo().window(popupHandle);
				String titleExpected = PageTitleConstant.FORUMS_PAGE;
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
}
