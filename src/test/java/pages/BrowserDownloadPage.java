package pages;

import framework.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


import java.io.IOException;


public class BrowserDownloadPage extends BasePage {
	public void checkdownloadstatus() throws IOException {
		WebDriver driver = browser.getDriver();
		String brname = browser.getbrowsername();
		if (brname.contains("Chrome") == Boolean.TRUE) {
			driver.get("chrome://downloads");
			JavascriptExecutor downloadWindowExecutor = (JavascriptExecutor) driver;
			Boolean completelyondisck = false;
			while (completelyondisck != Boolean.TRUE) {
				completelyondisck = (Boolean) downloadWindowExecutor.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').completelyOnDisk_");
			}
		} else {
			driver.get("about:downloads");
			JavascriptExecutor downloadWindowExecutor = (JavascriptExecutor) driver;
			Long completedownload = Long.valueOf(0);
			while (completedownload != 100) {
				;
				completedownload = (Long) downloadWindowExecutor.executeScript("return document.querySelector('#contentAreaDownloadsView .downloadMainArea .downloadContainer description:nth-of-type(1)').nextElementSibling.value");
			}

		}
		Reporter.log("File is successfully downloaded");
	}
}
