package framework;

import framework.elements.BaseElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BasePage {
	public final String title = "//title[contains (text(),'%s')]";
	public static BaseElement element = new BaseElement();
	protected static BaseDriverManager browser = BaseDriverManager.getInstance();

	public static String loader(String name) throws CloneNotSupportedException, IOException {
		String loader = new PropertiesLoader().getsource(name);
		return loader;
	}
}


