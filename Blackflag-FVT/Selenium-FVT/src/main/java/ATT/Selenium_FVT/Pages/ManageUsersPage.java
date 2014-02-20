package ATT.Selenium_FVT.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ATT.Selenium_FVT.Utilities.Browser.WebPage;
public class ManageUsersPage extends WebPage {

	// Page Object "Add User button"
	@FindBy(id = "addUserButton")
	public WebElement addUserButton;

	// Page Object "Approval"
	@FindBy(css = "div.dataTableResultsContainer > div > div[class*=dataTableColumn5] ")
	public WebElement approval;
	
	public ManageUsersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openURL() {
		// driver.get(APIM_URL);
		// driver.navigate().to(Constants.APIM_HOME_URL);
		// waitForPageToLoad();
		PageFactory.initElements(driver, this);

	}

	// method to click Add Users link
	public AddUsersPage clickAddUsers() {

		addUserButton.click();
		waitForPageToLoad();
		return PageFactory.initElements(driver, AddUsersPage.class);
	}

	public boolean validateStatusOfUser() {

		String messageCaptured =approval.getText();
		String messageActual = "Invited";
		boolean result = messageCaptured.equalsIgnoreCase(messageActual);
		if (result) {

			storeVerificationResults(true, "Status: Approved is displayed");

		} else {

			storeVerificationResults(false, "Status: Invited is not displayed");
		}
		return result;
	}

}
