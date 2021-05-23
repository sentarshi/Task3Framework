package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.HashMap;
import java.util.Map;


public class BaseDriverManager {
	private static BaseDriverManager instance;
	private final String enlocale = "src/test/Localization/loc.en.json";
	private final String rulocale = "src/test/Localization/loc.ru.json";

	private BaseDriverManager() {
	}

	private WebDriver driver;
	private static String timeoutForPageLoad = "60";
	public static String currentbro;

	public void Getlocale(String locale) {
		if (locale.equals("en")) {
			PropertiesLoader.pathloc(rulocale);
		} else {
			if (locale.equals("ru")) {
				PropertiesLoader.pathloc(enlocale);
			} else {
				Reporter.log("This language is not supported sorry");
			}
		}

	}

	public  WebDriver SetUp(String Browser) {
		if (Browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.prompt_for_download", false);
			prefs.put("download.extensions_to_open", "application/xml");
			prefs.put("safebrowsing.enabled", true);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.setAcceptInsecureCerts(true);
			options.addArguments("start-maximized");
			options.addArguments("--lang=en");
			options.addArguments("--safebrowsing-disable-download-protection");
			options.addArguments("safebrowsing-disable-extension-blacklist");
			driver = new ChromeDriver(options);
			currentbro = Browser;
			return driver;
		} else {
			if (Browser.equals("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("browser.download.folderList", 1);
				profile.setPreference("browser.download.manager.showWhenStarting", false);
				profile.setPreference("browser.download.manager.focusWhenStarting", false);
				profile.setPreference("browser.download.useDownloadDir", true);
				profile.setPreference("browser.helperApps.alwaysAsk.force", false);
				profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
				profile.setPreference("browser.download.manager.closeWhenDone", true);
				profile.setPreference("browser.download.manager.showAlertOnComplete", false);
				profile.setPreference("browser.download.manager.useWindow", false);
				// You will need to find the content-type of your app and set it here.
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setCapability(FirefoxDriver.PROFILE, profile);
				driver = new FirefoxDriver(firefoxOptions);
				driver.manage().window().maximize();
				currentbro = Browser;
				Reporter.log ("Test started with firefox Browser");
				return driver;
			} else {
				throw new java.lang.Error("Browser not supported");
			}
		}
	}

	public String getbrowsername() {
		return currentbro;
	}


	public void windowMaximize() {
		driver.manage().window().maximize();
	}

	public static BaseDriverManager getInstance() {
		if (instance == null) instance = new BaseDriverManager();
		return instance;
	}


	public void navigate(String url) {
		driver.navigate().to(url);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void teardown() {

		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

