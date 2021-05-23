package framework.elements;

import org.openqa.selenium.WebElement;
import org.testng.reporters.jq.Main;

import java.io.IOException;

import static framework.BasePage.loader;

public class MainMenu extends BaseElement {
	private static final String mainmenuitemdrop = "//div[@id='%s']";
	private static final String mainmenusubitem = "//*[@class='popup_menu_item'  and normalize-space (text())='%s' ]";

	public void navigate(String paramtop, String paramsub) throws IOException, CloneNotSupportedException {
		try {
			skiploader();
		} catch (Exception e) {
		}
		WebElement mainmenu = findelementplus(mainmenuitemdrop, loader(paramtop));
		hoverelement(mainmenu);
		WebElement submenu = findelementplus(mainmenusubitem, loader(paramsub));
		click(submenu);

	}
}
