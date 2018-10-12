package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import init.TestBase;

public class RegisterPage {

	EventFiringWebDriver driver = TestBase.getDriver();
	WebDriverWait wait= new WebDriverWait(driver, 30);;
	ExtentTest report=TestBase.getLogger().get();
	
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
		report.log(LogStatus.PASS, "Click on the button Register ", "Successfully Clicked the button Register");
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
