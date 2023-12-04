package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.ReuseCode;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LandingPage extends ReuseCode {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id=\"input-email\"]")
	WebElement mail;

	@FindBy(xpath = "//input[@id=\"input-password\"]")
	WebElement password;

	@FindBy(xpath = "//input[@class=\"btn btn-primary\"]")
	WebElement loginBtn;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement verify;

	public void loginApp(String email, String pass) {
		mail.sendKeys(email);
		password.sendKeys(pass);
		loginBtn.click();
	}

	public void goToApp() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/account");

	}

	public String getErrorText() {
		waitForWebElementAppear(verify);
		String verifation = verify.getText();
		System.out.println(" Warning: No match for E-Mail Address and/or Password." + verifation);
		return verifation;
	}

}
