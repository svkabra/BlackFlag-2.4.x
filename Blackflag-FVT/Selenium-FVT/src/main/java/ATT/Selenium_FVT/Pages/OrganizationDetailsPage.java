package ATT.Selenium_FVT.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ATT.Selenium_FVT.Utilities.Browser.WebPage;
import ATT.Selenium_FVT.Utilities.Component.Constants;

public class OrganizationDetailsPage extends WebPage {

	// Page Object "Organization Details" header
	@FindBy(how = How.ID, using = "tier2header")
	private WebElement orgDetailsheader;

	// Page Object "Org Name" text box
	@FindBy(how = How.ID, using = "org_name")
	private WebElement orgNameTextBox;

	// Method to validate field is pre populated and non editable

	// Page Object "Org Address1" text box
	@FindBy(how = How.ID, using = "org_address_1")
	private WebElement orgAddress1;

	// Page Object "Org Address2" text box
	@FindBy(how = How.ID, using = "org_address_2")
	private WebElement orgAddress2;

	// Page Object "Org City" text box
	@FindBy(how = How.ID, using = "org_city")
	private WebElement orgCity;

	// Page Object "Org State" text box
	@FindBy(how = How.ID, using = "state_dropdown")
	private WebElement orgState;

	// Page Object "Org Country" text box
	@FindBy(how = How.ID, using = "country_dropdown")
	private WebElement orgCountry;

	// Page Object "Org Postal Code" text box
	@FindBy(how = How.ID, using = "org_postal_code")
	private WebElement orgPostalCode;

	// Page Object "Org Phone" text box
	@FindBy(how = How.ID, using = "org_phone")
	private WebElement orgPhone;

	// Page Object "Org Mobile Number" text box
	@FindBy(how = How.ID, using = "org_mobile_number")
	private WebElement orgMobileNumber;

	// Page Object "Org Business Email" text box
	@FindBy(how = How.ID, using = "org_business_email")
	private WebElement orgEmail;

	// Page Object "Org Website" text box
	@FindBy(how = How.ID, using = "org_website")
	private WebElement orgWebsite;

	// Page Object "Org Industry" text box
	@FindBy(how = How.ID, using = "industry_dropdown")
	private WebElement orgIndustry;

	// Page Object "Org Business Description" text box
	@FindBy(how = How.ID, using = "org_business_description")
	private WebElement orgDescription;

	// Page Object "Org Employee number" text box
	@FindBy(how = How.ID, using = "org_employee_number_dropdown")
	private WebElement orgEmployeeNumber;

	// Page Object "Org Duns Number" text box
	@FindBy(how = How.ID, using = "org_duns_dropdown")
	private WebElement orgDunsNumber;

	// Page Object "Org Revenue" text box
	@FindBy(how = How.NAME, using = "org_revenue_dropdown")
	private WebElement orgRevenue;

	// Page Object "Update Button" text box
	@FindBy(how = How.ID, using = "updateButton")
	private WebElement updateButton;

	// Page Object "Saved Changes Message" text box
	@FindBy(how=How.CLASS_NAME, using="blueboxBR")
	private WebElement savedChangesMessage;

	// Page Object Annual Revenue validate message
	@FindBy(how=How.CSS, using="label[class=field_error][for=org_revenue_dropdown][generated=true]")
	private WebElement annualRevenueValidateMessage;			

	// Page Object DUNS Validate Message
	@FindBy(how=How.CSS, using="label[class=field_error][for=org_duns_number][generated=true]")
	private WebElement dUNSValidateMessage;			

	// Page Object "Org Employee Number Dropdown" text box
	@FindBy(how = How.ID, using = "org_employee_number_dropdown")
	private WebElement orgEmpolyeeNumberDropdown;

	// Parameterized Constructors
	public OrganizationDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openURL() {
		// driver.get(APIM_URL);

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

		waitForPageToLoad();
		PageFactory.initElements(driver, this);

	}

	// method to select value from dropdown
	public OrganizationDetailsPage numberOfEmployeesDropdown(int a) {

		WebElement select = orgEmpolyeeNumberDropdown;
		Select s1 = new Select(select);
		s1.selectByIndex(a);
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_SHORT);
		return this;
	}

	// method to click on Update Button
	public OrganizationDetailsPage clickUpdate() {

		updateButton.click();
		waitForPageToLoad();
		return this;
	}

	// method to select value from Annual Revenue dropdown
	public OrganizationDetailsPage annualRevenueDropdown(int a) {
		waitForElement(orgRevenue);
		WebElement select = orgRevenue;
		Select s1 = new Select(select);
		s1.selectByIndex(a);
		implicitWait(Constants.PAGE_WAIT_INTRA_SYSTEM_SHORT);
		return this;
	}

	/**************************************Validation method**************************/
	
	// method to validate the saved changes
	public boolean validateSavedChangesMessage() {
		boolean result = false;
		if (validateWebElementDisplayed(savedChangesMessage)) {
			result = true;
		}
		return result;
	}

	// method to validate Annual Revenue field requires valid input
	public boolean validateAnnualRevenue() {

		String messageCaptured = annualRevenueValidateMessage.getText();

		String messageActual = "[Organization.revenue.Null.message]";

		boolean result = messageCaptured.equalsIgnoreCase(messageActual);

		if (result) {

			storeVerificationResults(true, "Error Message is displayed");

		} else {

			storeVerificationResults(false, "Error Message is not displayed");
		}
		return result;
	}

	// method to validate DUNS field is mandatory
	public boolean validateDUNS() {

		String messageCaptured = dUNSValidateMessage.getText();

		String messageActual = "Please enter a DUNS Number.";

		boolean result = messageCaptured.equalsIgnoreCase(messageActual);

		if (result) {

			storeVerificationResults(true, "Error Message is displayed");

		} else {

			storeVerificationResults(false, "Error Message is not displayed");
		}

		return result;
	}

	// method to validate Number of Employees Field is displayed
	public boolean validateFieldDisplayed() {
		boolean result = false;
		if (validateWebElementDisplayed(orgEmployeeNumber)) {
			if (validateWebElementDisplayed(updateButton)) {
				result = true;
			}
		}
		return result;
	}

	// method to validate Number of Employees Field and revenue field is enabled
	public boolean validateFieldEnabled() {
		boolean result = false;
		if (validateWebElementEnabled(orgEmployeeNumber)) {
			if (validateWebElementEnabled(orgRevenue)) {
				result = true;
			}
		}
		return result;
	}

	// method to check if the below fields are prepopulated
	public boolean validateFieldPrepopulated() {
		boolean result = false;
		if (validateWebElementPrepopulated(orgNameTextBox)) {
			if (validateWebElementPrepopulated(orgAddress1)) {
				if (validateWebElementPrepopulated(orgCity)) {
					if (validateWebElementPrepopulated(orgState)) {
						if (validateWebElementPrepopulated(orgCountry)) {
							if (validateWebElementPrepopulated(orgPostalCode)) {
								if (validateWebElementPrepopulated(orgPhone)) {
									if (validateWebElementPrepopulated(orgEmail)) {
										if (validateWebElementPrepopulated(orgWebsite)) {
											if (validateWebElementPrepopulated(orgIndustry)) {
												result = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;

	}

}
