package ATT.Selenium_FVT.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ATT.Selenium_FVT.Utilities.Browser.WebPage;

public class ManageLegalAgreementPage extends WebPage {

	// Page Object "Organization Details" header
	@FindBy(how = How.LINK_TEXT, using = "Download ")
	private WebElement downloadLink;

	public ManageLegalAgreementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openURL() {
		PageFactory.initElements(driver, this);

	}

	// method to click Download link
	public ManageLegalAgreementPage clickDownloadLink() {

		downloadLink.click();
		waitForPageToLoad();
		return this;
	}
}
