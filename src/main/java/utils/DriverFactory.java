package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

	public WebDriver getDriver() {
		return edriver;
	}

	public DriverFactory() {
		this.initializeDriver();
	}

	public void initializeDriver() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./config/app.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String browser = prop.getProperty("browser");
		switch (browser.toLowerCase()) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./resource/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
			break;
		}
		int pageLoadTimeout = Integer.valueOf(prop.getProperty("pageLoadTimeout", "60"));
		int scriptTimeOut = Integer.valueOf(prop.getProperty("scriptTimeOut", "60"));
		String url = prop.getProperty("url");

		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(scriptTimeOut, TimeUnit.MICROSECONDS);
		edriver = new EventFiringWebDriver(driver);
		listener = new WebDriverListener();
		edriver.register(listener);
		
		
	}

}
