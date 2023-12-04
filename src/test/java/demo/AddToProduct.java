package demo;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractcomponent.ReuseCode;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToProduct {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/account");

		WebElement enterUserName = driver.findElement(By.xpath("//input[@id=\"input-email\"]"));
		enterUserName.sendKeys("shubhamnilamwar147@gmail.com");

		WebElement enterPassword = driver.findElement(By.xpath("//input[@id=\"input-password\"]"));
		enterPassword.sendKeys("S@147n@147");

		WebElement clickOnLoginBtn = driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]"));
		clickOnLoginBtn.click();

		WebElement btnElement = driver
				.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Tablets')]"));
		Actions actions = new Actions(driver);
		actions.doubleClick(btnElement).build().perform();

		/*
		 * String AddProductGetmessege = expwait .until(ExpectedConditions
		 * .visibilityOfElementLocated(By.
		 * xpath("//a[normalize-space()='Samsung Galaxy Tab 10.1']"))) .getText();
		 */

		String AddProductGetmessege = driver.findElement(By.xpath("//a[normalize-space()='Samsung Galaxy Tab 10.1']"))
				.getText();
		Thread.sleep(10);
		System.out.println("AddProductmessege " + AddProductGetmessege);

		ReuseCode Rc = new ReuseCode(driver);
		Rc.excuterScript("window.scrollTo(0, document.body.scrollHeight)");
		
		WebElement addCart = driver.findElement(By
				.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//button[1]"));
		addCart.click();

		WebElement clickOnLink = expwait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-loading-text=\"Loading...\"]")));

		// actions.doubleClick(clickOnLink).build().perform();

		String afterAddProductGetmessege = driver
				.findElement(By.xpath("//td[@class='text-left']//a[contains(text(),'Samsung Galaxy Tab 10.1')]"))
				.getText();
		System.out.println("afterAddProductGetmessege " + afterAddProductGetmessege);
		boolean verify = AddProductGetmessege.equalsIgnoreCase(afterAddProductGetmessege);
	}
}
