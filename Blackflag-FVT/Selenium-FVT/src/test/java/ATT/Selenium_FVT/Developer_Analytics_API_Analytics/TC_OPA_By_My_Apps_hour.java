package ATT.Selenium_FVT.Developer_Analytics_API_Analytics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.ApiMatrixHomePage;
import ATT.Selenium_FVT.Pages.MyAppsPage;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Excel.FileHandling;
import ATT.Selenium_FVT.Utilities.Excel.ReadXLSX;

public class TC_OPA_By_My_Apps_hour extends TestUtil{

	@Test
	public void testAnalyticsGraphFor_My_Apps_1d() {		
		
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
			

//Temporary Step- Set the View 
			String sSelectBy; 

			sSelectBy = "hour";
			myapps.fnSetBy(sSelectBy);


			//Step5 -- Click on Refresh button			
			//Get the data for 1 week
			//Click on refresh and wait till the data gets loaded in analytics
			myapps.fnClickRefresh();
			

//Step 6 -- Check if the file has been exported successfully
			
			//Click on Export Button
			String filePathString;	
			filePathString = "C:\\Temp\\export.xlsx";	
			myapps.fnExportFile(filePathString);
			
			//Check if file has been exported successfully			
			FileHandling file = new FileHandling();			
			boolean x = file.fnCheckFileExists(filePathString);
			
			//Get the Name of the current class
			String className = this.getClass().getSimpleName();
			
			String sOldFilePath, sNewFilePath;
			sNewFilePath = null;
			if(x){							
				sOldFilePath = filePathString;
				sNewFilePath = "C:\\Temp\\"+className+".xlsx";  
				file.fnCheckFileRenamed(sOldFilePath, sNewFilePath);			
			}else{
				System.out.println("File does not exists");
			}

//Step 7 -- Validate the exported file
			
					
		} catch (IOException e) {
			e.printStackTrace();
			}
		
				
	}	
}
