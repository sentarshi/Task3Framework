package Tests;

import framework.BasePage;
import framework.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import java.io.IOException;


public class SteamFileDownload extends BaseTest {
	@Parameters({"Browser","Locale"})
	@Test
	public void runTest(String Browser,String Locale) throws Exception {

		browser.Getlocale(Locale);
		init(Browser);
		browser.navigate("http://steampowered.com");
		Mainpage main = new Mainpage();

		try {
			main.ChangeLocale();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		main.menunav();
		Categoriespage cat = new Categoriespage();
		cat.ChooseDiscount();
		AgePage age = new AgePage();
		try {
			age.passthroughtheage();
		} catch (Exception e) {
			System.out.println("No age page this time");
		}
		Gamepage gamep = new Gamepage();
		gamep.opensteamdownload();
		Steamdownloadpage download = new Steamdownloadpage();
		download.downloadinstall();
		BrowserDownloadPage dp = new BrowserDownloadPage();
		dp.checkdownloadstatus();
	}

}
