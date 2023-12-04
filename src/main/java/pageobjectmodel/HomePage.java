package pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.ReuseCode;

public class HomePage extends ReuseCode {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id=\"content\"]/h2")
	List<WebElement> content;

	@FindBy(xpath = "//input[@class=\"btn btn-primary\"]")
	WebElement loginBtn;

	@FindBy(xpath = "//a[normalize-space()='Edit your account information']")
	WebElement elment;

	public void loginApp() {

		loginBtn.click();
	}

	public void clickOneOfTheLink() {

		for (WebElement oneOfContent : content) {
			String text = oneOfContent.getText();
			System.out.println(text);

			if (text.equals("My Account")) {
				elment.click();

			}
		}
	}

}
