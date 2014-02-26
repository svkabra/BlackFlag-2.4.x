package ATT.Selenium_FVT.Developer_Analytics_Advertising;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ATT.Selenium_FVT.Pages.APIMLoginPage;
import ATT.Selenium_FVT.Pages.AppPage;
import ATT.Selenium_FVT.Pages.MyAppsPage;
import ATT.Selenium_FVT.Test.TestUtil;
import ATT.Selenium_FVT.Utilities.Browser.PageSupport;
import ATT.Selenium_FVT.Utilities.Component.Constants;
import ATT.Selenium_FVT.Utilities.Excel.FileHandling;

public class TC_OPA_ADV_Analytics_Production_Update_Date_Range extends TestUtil{

	@Test
	public void testAnalyticsGraphFor_My_Apps_Advertising_V1_ATTr2() {		

		//method to launch browser
		APIMLoginPage apimLoginPage= new APIMLoginPage(getNewDriver(Constants.BROWSER));

		//method to open URL
		apimLoginPage.openURL();

		//method to login
		apimLoginPage.apimLogin("F3", "OPA", "withApp");

		//method to click on MyApps button
		MyAppsPage myapps = apimLoginPage.clickMyApps();

		//method to validate MyApps page successfully loaded
		apimLoginPage.validateMyAppsPage();

		//Click on the already existing application with Advertising Analytics*/		
		String sAppName;
		sAppName = Constants.OPAAPPNAMEWITHADSINPROD;
		AppPage appPage = myapps.clickAppLink(sAppName);

		//verify Advertising Analytics is by default collapsed
		appPage.verifyADVAnalyticsAlreadyCollapsed();

		//Set the start and end date
		String sStartDate = Constants.START_DATE;
		String sEndDate = Constants.END_DATE;
		appPage.fnSetDateRangeInMyApps(sStartDate ,sEndDate );
		appPage.fnClickRefresh();



		//Verify the folder if exits, click the export button and verify file has been created
		String filePathString;	
		filePathString = Constants.FVTRESULTPATHADVERTISING;	
		myapps.fnExportFileADV(filePathString);

		//Check if file has been exported successfully			
		FileHandling file = new FileHandling();			
		boolean x = file.fnCheckFileExists(filePathString);

		//Get the Name of the current class
		String className = this.getClass().getSimpleName();

		String sOldFilePath, sNewFilePath;
		sNewFilePath = null;
		if(x){							
			sOldFilePath = filePathString;
			int in  = filePathString.lastIndexOf("\\");            
			String folderPathString =  filePathString.substring(0, in);
			sNewFilePath = folderPathString + "\\" + className+".csv";  
			file.fnCheckFileRenamed(sOldFilePath, sNewFilePath);

		}else{
			file.storeVerificationResults(false, "File does not exists");
		}

		// method to publish test result
		apimLoginPage.publishTestResult();
		myapps.publishTestResult();			
		file.publishTestResult();

	}	

	@After
	public void takeScreenShot() {
		// take the screenshot at the end of every test
		File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		// now save the screenshto to a file some place
		try {
			String className = this.getClass().getSimpleName();
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\" + className + ".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
