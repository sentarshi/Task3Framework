package pages;

import framework.BasePage;
import framework.elements.BaseElement;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Categoriespage extends BasePage {
	private static final String discmenu = "//div[@class='%s']//div[contains (text(),'-')]";
	BaseElement element = new BaseElement();

	public void ChooseDiscount() throws IOException, CloneNotSupportedException {
		Assert.assertNotNull(element.findelementsplus(title, loader("title.title.categorypage")));
		int indexelement = 0;
		String arr = null;
		int max = 0;
		List<WebElement> Discounts = new BaseElement().findelementsplus(discmenu, loader("discmenu"));
		for (int i = 0; i < Discounts.size(); i++) {
			WebElement webElement = Discounts.get(i);
			String percent = webElement.getText();
			arr = arr + percent + " ";
			int value = Integer.parseInt(percent.replaceAll("[^0-9]", ""));
			if (max > value) {
				max = max;
			} else {
				if (max == value) {
					if (Math.random() < 0.5) {
						indexelement = indexelement;
					} else {
						indexelement = i;
					}
				} else {
					max = value;
					indexelement = i;
				}
			}
		}
		element.click(Discounts.get(indexelement));

	}
}