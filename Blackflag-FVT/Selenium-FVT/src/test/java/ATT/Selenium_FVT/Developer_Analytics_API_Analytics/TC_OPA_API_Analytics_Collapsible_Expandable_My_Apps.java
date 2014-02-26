package ATT.Selenium_FVT.Developer_Analytics_API_Analytics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.ApiMatrixHomePage;
import ATT.Selenium_FVT.Pages.MyAppsPage;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Excel.FileHandling;
import ATT.Selenium_FVT.Utilities.Excel.ReadXLSX;

public class TC_OPA_API_Analytics_Collapsible_Expandable_My_Apps extends TestUtil{

	@Test
	public void testAnalyticsGraphFor_My_Apps_Advertising_V1_ATTr2() {		
		
		Properties prop = new Properties();
		ApiMatrixHomePage apimpage = null;
		try {
			prop.load(new FileInputStream("src//test//java//configuration.properties"));				
			apimpage = new ApiMatrixHomePage(getNewDriver(prop.get("browser").toString()));

			APIMLoginPage api= 	apimpage.apimLoginPage();

//Step1 -- Login to APIM as Developer and click on My Apps link			
			api.openURL();
			api.enterUserName(prop.getProperty("OPA.USERNAME"));
			api.enterPasword(prop.getProperty("OPA.PASSWORD"));
			MyAppsPage myapps = api.login();

			
//Step2 -- Click on API Analytics button			
			//Verify Analytics collapsed before and expanded after and click on ADV Analytics	
			myapps.clkAPIAnalyticsBtn();
			
			

			//Click on API Analytics
			myapps.buttonAppAnalytics.click();
			
			
			myapps.fnCheckAPIAnlyticsIsCollapsed();
				
					
		} catch (IOException e) {
			e.printStackTrace();
			}
		
				
	}	
}
