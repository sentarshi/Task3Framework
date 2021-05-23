package pages;

import framework.BasePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class Gamepage extends BasePage {
	private static final String downloadbutton = ".header_installsteam_btn_content";
	private static final String gameheader = "//div[@class='apphub_AppName']";

	public void opensteamdownload() throws IOException, CloneNotSupportedException {
		Assert.assertNotNull(element.findelementsplus(title, loader("title.gamepage")));
		element.waitforelement(gameheader);
		WebElement downbutton = element.findelementcss(downloadbutton);
		element.click(downbutton);
	}
}
