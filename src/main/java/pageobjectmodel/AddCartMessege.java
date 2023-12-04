package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.ReuseCode;

public class AddCartMessege extends ReuseCode {

	WebDriver driver;

	public AddCartMessege(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav navbar-nav']//a[contains(text(),'Tablets')]")
	WebElement tablet;

	@FindBy(xpath = "//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//button[1]")
	WebElement addCartBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//a[contains(text(),'Samsung Galaxy Tab 10.1')]")
	WebElement succesfullAddCart;

	public void clickOnTablet() {
		tablet.click();
		// performAction(tablet);
		addCartBtn.click();
	}

	public String succesfullAddCartMessege() {
		String messege = succesfullAddCart.getText();
		System.out.println("succesfullAddCart " + messege);
		return messege;

	}
}
