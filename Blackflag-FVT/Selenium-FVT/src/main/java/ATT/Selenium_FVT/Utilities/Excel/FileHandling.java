package ATT.Selenium_FVT.Utilities.Excel;

import java.io.File;

import org.openqa.selenium.WebDriver;

import ATT.Selenium_FVT.Utilities.Browser.PageSupport;
import ATT.Selenium_FVT.Utilities.Browser.WebPage;

public class FileHandling extends PageSupport{

	

		//Function check if export file already exists or not-Hemant 
	//***********************************************************************************************************************************			
		public boolean fnCheckFileExists(String filePathString){													
			try{
				File f = new File(filePathString);

				if(f.exists()){
					storeVerificationResults(true, "File  " + filePathString + " Exists");
					return true;
				}else{
					storeVerificationResults(false, "File does not Exists");
					return false;
				}
				
			}catch(Exception e){						
				e.printStackTrace();
				return false;
			}												
		}
	//***********************************************************************************************************************************
	
	//Function to rename the file - Hemant
	//***********************************************************************************************************************************	
		public boolean fnCheckFileRenamed(String sOldFilePath, String sNewFilePath){

			File oldfile =new File(sOldFilePath);
			File newfile =new File(sNewFilePath);
	 
			if(oldfile.renameTo(newfile)){
				storeVerificationResults(true, "Rename of file succesful");
				return true;
			}else{
				storeVerificationResults(false, "Rename of file failed");
				return false;
			}		
			
		}
	//***********************************************************************************************************************************		


		
		
}
