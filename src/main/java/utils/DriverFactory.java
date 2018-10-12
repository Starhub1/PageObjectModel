package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

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
//			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "./resource/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
//			driver = new ChromeDriver();
			break;
		}
		
		edriver = new EventFiringWebDriver(driver);
		listener = new WebDriverListener();
		edriver.register(listener);
		int pageLoadTimeout = Integer.valueOf(PropReader.get(path, "pageLoadTimeout"));
		int scriptTimeOut = Integer.valueOf(PropReader.get(path, "scriptTimeOut"));
		edriver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		//edriver.manage().timeouts().setScriptTimeout(scriptTimeOut, TimeUnit.SECONDS);
		//edriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
