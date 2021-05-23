package framework;


import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.IOException;

import static framework.BaseDriverManager.getInstance;

public abstract class BaseTest {
	public static void init(String Browser) throws IOException {
		browser.SetUp(Browser);
		browser.windowMaximize();
	}

	protected static BaseDriverManager browser = getInstance();

	public abstract void runTest(String param, String param2) throws Exception;

	public void xTest(String param, String param2) throws Throwable {

		runTest(param, param2);
		Class<? extends BaseTest> currentClass = this.getClass();
	}


	@AfterTest
	public void stop() {
		getInstance().teardown();
	}
}
