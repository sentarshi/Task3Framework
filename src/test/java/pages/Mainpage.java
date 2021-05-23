package pages;


import framework.BasePage;

import framework.elements.MainMenu;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class Mainpage extends BasePage {
	private static final String langdropdown = "//span[@id='language_pulldown']";
	private static final String langoption = "//a[contains(text(),'%s')]";

	public void ChangeLocale() throws CloneNotSupportedException, IOException, InterruptedException {
		Assert.assertNotNull(element.findelementsplus(title, loader("title.mainpage")));
		WebElement localemenu = element.findelementxpath(langdropdown);
		element.click(localemenu);
		element.waitforelementplus(langoption, loader("language"));
		WebElement langchoise = element.findelementplus(langoption, loader("language"));
		element.click(langchoise);

	}

	public void menunav() throws IOException, CloneNotSupportedException {
		MainMenu menu = new MainMenu();
		menu.navigate("mainmenuCategories", "submenuAction");

	}


}
