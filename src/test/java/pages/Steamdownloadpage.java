package pages;

import framework.BasePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class Steamdownloadpage extends BasePage {
	private static final String download = "//*[@class='about_install_steam_link']";

	public void downloadinstall() throws InterruptedException, IOException, CloneNotSupportedException {
		Assert.assertNotNull(element.findelementsplus(title, loader("title.steamdpage")));
		WebElement downbutton = element.findelementxpath(download);
		element.click(downbutton);
	}

}
