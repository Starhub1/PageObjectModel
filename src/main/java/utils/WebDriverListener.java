package utils;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebDriverListener extends AbstractWebDriverEventListener {

	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("WebListener");

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		String message = String.format("[%s] : %s", driver.getClass(), "Before Alert Accept");
		logger.info(message);
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		String message = String.format("[%s] : %s", driver.getClass(), "Alert Accepted");
		logger.info(message);
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		String message = String.format("[%s] : %s", driver.getClass(), "Alert Dissmissed");
		logger.info(message);
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		String message = String.format("[%s] : %s", driver.getClass(), "Navigating to the URL : " + url);
		logger.info(message);

	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		String message = String.format("[%s] : %s", driver.getClass(), "Successfuly navigated to the URL : " + url);
		logger.info(message);
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		String message = String.format("[%s] : %s", by.getClass(), "Finding the element " + by.toString());
		logger.info(message);
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		String message = String.format("[%s] : %s", by.getClass(), "Found the element " + by.toString());
		logger.info(message);
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		String message = String.format("[%s] : %s", element.getClass(),
				"Trying to Click on the element : " + element.toString().replaceAll(".*->", ""));
		logger.info(message);
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		String message = String.format("[%s] : %s", element.getClass(),
				"Clicked on the element :  " + element.toString().replaceAll(".*->", ""));
		logger.info(message);
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
//		element.clear();
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// System.out.println(Arrays.stream(keysToSend).map(s->s.toString()));
		String message = String.format("[%s] : %s", driver.getClass(), "Value Entered in the element : "
				+ element.toString().replaceAll(".*->", "") + "is " + Arrays.toString(keysToSend));
		logger.info(message);
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
	}

}
