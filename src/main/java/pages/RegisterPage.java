package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import init.TestBase;

public class RegisterPage {

	WebDriver driver = TestBase.getDriver();
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement txtUserName;
	
	@FindBy(name="password")
	private WebElement txtPassword;
	
	@FindBy(name="confirmPassword")
	private WebElement txtConfirmPassword;
	
	@FindBy(xpath="//a[text()=' sign-in ']")
	private WebElement lnkSignIn;
	
	
	@FindBy(name="register")
	private WebElement btnRegister;
	
	
	public RegisterPage typeUserName(String txt) {
		txtUserName.sendKeys(txt);
		return this;
	}
	
	public RegisterPage typePassword(String txt) {
		txtPassword.sendKeys(txt);
		return this;
	}
	
	public RegisterPage typePasswordAgainForConfirmation(String txt) {
		txtConfirmPassword.sendKeys(txt);
		return this;
	}
	
	public void clickLogin() {
		btnRegister.click();
	}
	
	public RegisterPage Register(String userName, String password) {
		typeUserName(userName).typePassword(password).typePasswordAgainForConfirmation(password).clickLogin();
		return this;
	}
	
	public LoginPage clickSignIn() {
		lnkSignIn.click();
		return new LoginPage();
	}
}
