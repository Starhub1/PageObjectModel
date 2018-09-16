package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import init.TestBase;
import reports.AppLogger;

public class WebDriverListener extends AbstractWebDriverEventListener{

	@Override
	public void beforeAlertAccept(WebDriver driver) {
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		AppLogger.logInfo(driver.getClass(), "Alert Accepted");
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		AppLogger.logInfo(driver.getClass(), "Alert Dissmissed");
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		AppLogger.logInfo(driver.getClass(), "Navigated to the URL"+ url);
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
			AppLogger.logInfo(by.getClass(), "Finding the element "+ by);
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
			AppLogger.logInfo(by.getClass(), "Found the element "+ by);
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
			AppLogger.logInfo(element.getClass(), "Clicking on the element "+ element);
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
			AppLogger.logInfo(element.getClass(), "Clicked on the element "+ element);
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
//		element.clear();
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		AppLogger.logInfo(element.getClass(), "Navigated to the URL");
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
		AppLogger.logFatal(driver.getClass(), "Exception Thrown", throwable);
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
