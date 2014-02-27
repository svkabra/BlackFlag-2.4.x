package ATT.Selenium_FVT.Utilities.Browser;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.Hashtable;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import ATT.Selenium_FVT.Utilities.Component.Constants;

public abstract class WebPage extends PageSupport {

	public WebPage(WebDriver driver) {
		super(driver);
	}

	public enum Driver {
		FIREFOX, SAFARI, IE, CHROME, FFGRID, HTMLUNIT;

	}

	public static WebDriver getNewDriver(Driver driverType) {
		switch (driverType) {
		case FIREFOX:
			return new FirefoxDriver();
		case SAFARI:
			return new SafariDriver();
		case CHROME:
			File file = new File(
					"src/test/resources/ATT/Selenium_FVT/PageTest/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",
					file.getAbsolutePath());
			return new ChromeDriver();

		case IE:
			System.setProperty("webdriver.ie.driver",
					"C:\\Setups\\IEDriverServer.exe");
			// return new InternetExplorerDriver();
			DesiredCapabilities ieCapabilities = DesiredCapabilities
					.internetExplorer();
			ieCapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			ieCapabilities.setCapability("ensureCleanSession", true);
			return new InternetExplorerDriver(ieCapabilities);

		case FFGRID:
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			try {
				return new RemoteWebDriver(new URL(""), capability);
			} catch (MalformedURLException e) {
				e.printStackTrace();
				return null;
			}
		case HTMLUNIT:
			return new HtmlUnitDriver(true);
		default:
			throw new InvalidParameterException(
					"You must choose one of the defined driver types");
		}
	}

	/* Function to launch browser with download location configuration */
	public static WebDriver getNewDriverProfile(Driver driverType) {

		// Set the download location
		String filePathString;
		filePathString = Constants.FVTRESULTPATHADVERTISING;
		File file1 = new File("./" + filePathString);
		String dirPath = file1.getAbsolutePath();
		System.out.println(dirPath.replace(".\\", ""));
		filePathString = dirPath.replace(".\\", "");
		int in = filePathString.lastIndexOf("\\");
		String folderPathString = filePathString.substring(0, in);

		switch (driverType) {
		case FIREFOX:

			FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setPreference("browser.download.folderList", 2);
			firefoxProfile.setPreference(
					"browser.download.manager.showWhenStarting", false);
			firefoxProfile.setPreference("browser.download.dir",
					folderPathString);
			firefoxProfile.setPreference(
					"browser.helperApps.neverAsk.saveToDisk", "text/csv");

			WebDriver driver = new FirefoxDriver(firefoxProfile);
			return driver;

		case SAFARI:
			return new SafariDriver();
		case CHROME:

			// Set the Chrome driver location
			String strChromeRelativePath = Constants.CHROMEDRIVERLOCATION;
			File file2 = new File("./" + strChromeRelativePath);
			String dirPath2 = file2.getAbsolutePath();
			System.out.println(dirPath2.replace(".\\", ""));
			String filePathString1 = dirPath2.replace(".\\", "");
			filePathString1.lastIndexOf("\\");
			// String folderPathString1 = filePathString1.substring(0, in1);

			// //Set the download location for Chrome Exports
			// String filePathStringCh;
			// filePathStringCh = Constants.FVTRESULTPATHADVERTISINGCH;
			// File fileCh = new File("./" + filePathStringCh);
			// String dirPathCh = fileCh.getAbsolutePath();
			// System.out.println(dirPathCh.replace(".\\", ""));
			// filePathStringCh = dirPathCh.replace(".\\", "");
			// int inCh = filePathStringCh.lastIndexOf("\\");
			// String folderPathStringCh = filePathStringCh.substring(0, inCh);

			// System.setProperty("webdriver.chrome.driver",
			// file.getAbsolutePath());
			System.setProperty("webdriver.chrome.driver", filePathString1);

			Map<String, String> prefs = new Hashtable<String, String>();
			prefs.put("download.prompt_for_download", "false");

			prefs.put("download.default_directory", folderPathString);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setExperimentalOptions("prefs", prefs);
			WebDriver driver1 = new ChromeDriver(options);
			return driver1;
			// return new ChromeDriver();

		case IE:
			System.setProperty("webdriver.ie.driver",
					"C:\\Setups\\IEDriverServer.exe");
			// return new InternetExplorerDriver();
			DesiredCapabilities ieCapabilities = DesiredCapabilities
					.internetExplorer();
			ieCapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			ieCapabilities.setCapability("ensureCleanSession", true);
			return new InternetExplorerDriver(ieCapabilities);

		case FFGRID:
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			try {
				return new RemoteWebDriver(new URL(""), capability);
			} catch (MalformedURLException e) {
				e.printStackTrace();
				return null;
			}
		case HTMLUNIT:
			return new HtmlUnitDriver(true);
		default:
			throw new InvalidParameterException(
					"You must choose one of the defined driver types");
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static WebDriver getNewDriver(String Browser) {
		return getNewDriver(Driver.valueOf(Browser.toUpperCase()));
	}

	public static WebDriver getNewDriverProfile(String Browser) {
		return getNewDriverProfile(Driver.valueOf(Browser.toUpperCase()));
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public abstract void openURL();

	public void logout() {
		Hover(driver.findElement(By.cssSelector("a.logout")));
		// driver.findElement(By.name("signOut")).click();
		driver.findElement(By.id("logOut")).click();
		implicitWait(3);
		waitForAjaxInactivity();
		validateWebElementDisplayed(driver.findElement(By.linkText("Sign In")));
		// driver.findElement(By.id("dropdown-toggle-temp")).click();
		// driver.findElement(By.xpath("//*[@id='btn-nav-menu']/span")).click();
		// driver.findElement(By.xpath("//*[@id='dropown-menu-temp']/li[3]/a")).click();
		// driver.quit();
	}

	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
