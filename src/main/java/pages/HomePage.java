package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import init.TestBase;
import utils.PropReader;

public class HomePage {
	WebDriver driver = TestBase.getDriver();
	WebDriverWait wait;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
		"test".replace("test", "");
	}
	
	@FindBy(xpath="//a[text()='REGISTERa']")
	private WebElement lnkRegister;
	
	@FindBy(name="userName")
	private WebElement txtUserName;
	
	@FindBy(name="password")
	private WebElement txtPassword;
	
	@FindBy(name="login")
	private WebElement btnSignIn; 
	
	public HomePage open() {
		String url =PropReader.get("./config/app.properties", "url");
		driver.get(url);
		return this;
		
	}
	
	public HomePage typeUserName(String txt) {
		//LOGGER.info("waiting for the visibility of the Username field");
		wait.until(ExpectedConditions.visibilityOf(txtUserName));
		txtUserName.sendKeys(txt);
		return this;
	}
	
	public HomePage typePassword(String txt) {
		//LOGGER.info("Type the password in the field");
		txtPassword.sendKeys(txt);
		return this;
	}
	
	public HomePage clickLogin() {
		btnSignIn.click();
		return this;
	}
	
	public void Login(String userName, String Password) {
		typeUserName(userName).typePassword(Password).clickLogin();
	}
	
	public RegisterPage clickRegister() {
		lnkRegister.click();
		return new RegisterPage();
	}
}
