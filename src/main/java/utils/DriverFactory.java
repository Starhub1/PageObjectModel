package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverFactory {
	private EventFiringWebDriver edriver;
	private WebDriver driver;
	private WebDriverListener listener;

	public EventFiringWebDriver getDriver() {
		return edriver;
	}

	public DriverFactory() {
		this.initializeDriver();
	}

	public void initializeDriver() {
		String path = "./config/app.properties";
		String browser = PropReader.get(path, "browser");
		switch (browser.toLowerCase()) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./resource/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
			break;
		}
		int pageLoadTimeout = Integer.valueOf(PropReader.get(path, "pageLoadTimeout"));
		int scriptTimeOut = Integer.valueOf(PropReader.get(path, "scriptTimeOut"));
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(scriptTimeOut, TimeUnit.MICROSECONDS);
		edriver = new EventFiringWebDriver(driver);
		listener = new WebDriverListener();
		edriver.register(listener);

	}

}
