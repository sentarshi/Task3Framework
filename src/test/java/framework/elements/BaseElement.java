package framework.elements;

import framework.BaseDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class BaseElement {

	protected static WebElement element;
	protected static BaseDriverManager browser = BaseDriverManager.getInstance();
	public static WebDriver driver = BaseDriverManager.getInstance().getDriver();


	public WebElement getElement() {
		return element;
	}

	public void waitforelement(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitforelementplus(String locator, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(locator, value))));
	}

	public static WebElement findelementxpath(String locator) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath(locator));
		return element;
	}

	public static WebElement findelementcss(String locator) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.cssSelector(locator));
		return element;
	}

	public static WebElement findelementplus(String text, String text2) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.getCurrentUrl();
		return driver.findElement(By.xpath(String.format(text, text2)));
	}

	public List<WebElement> findelementsplus(String text, String text2) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.findElements(By.xpath(String.format(text, text2)));
	}

	public static void skiploader() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOf(findelementxpath("//div[@class='newmodal_background']")));
	}

	public static void hoverelement(WebElement element) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
		Actions act = new Actions(driver);
		act.moveToElement(element).moveToElement(element).build().perform();
	}

	public void click(WebElement element) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
		}
		element.click();
	}

}

