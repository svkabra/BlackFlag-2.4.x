package ATT.Selenium_FVT.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ATT.Selenium_FVT.Utilities.Browser.WebPage;
import ATT.Selenium_FVT.Utilities.Component.Constants;

public class RequestProductionAccessPage extends WebPage{

	//Page Object "Request Production button"
	@FindBy(name = "commit")
	public WebElement requestProduction;
	
	//Parameterized Constructor
	public RequestProductionAccessPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub		
	}

	@Override
	public void openURL() {
		// TODO Auto-generated method stub
		
	}
	
	//method to click on Production Access
	public AppPage clickProductionAccess(){
		requestProduction.click();
		waitForPageToLoad();
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_LONG);
		return PageFactory.initElements(driver, AppPage.class);	
	}
	
}
