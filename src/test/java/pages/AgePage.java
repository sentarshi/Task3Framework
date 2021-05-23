package pages;

import framework.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public class AgePage extends BasePage {
	private final static String Yeardropdown = "//select[@id='ageYear']";
	private final static String viewPage = "[onclick='ViewProductPage()']";


	public static void passthroughtheage() {
		Select yearc = new Select(element.findelementxpath(Yeardropdown));
		yearc.selectByValue("1974");
		WebElement gobtn = element.findelementcss(viewPage);
		element.click(gobtn);
	}
}
