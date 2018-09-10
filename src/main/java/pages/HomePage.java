package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import init.TestBase;

public class HomePage {
	
	WebDriver driver = TestBase.getDriver();
	WebDriverWait wait;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
		"test".replace("test", "");
	}
	
	@FindBy(xpath="//a[text()='REGISTER']")
	private WebElement lnkRegister;
	
	@FindBy(name="userName")
	private WebElement txtUserName;
	
	@FindBy(name="password")
	private WebElement txtPassword;
	
	@FindBy(name="login")
	private WebElement btnSignIn; 
	
	public HomePage typeUserName(String txt) {
		wait.until(ExpectedConditions.visibilityOf(txtUserName));
		txtUserName.sendKeys(txt);
		return this;
	}
	
	public HomePage typePassword(String txt) {
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