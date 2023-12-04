package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;

public class Test {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");

		// enterUserName
		WebElement enterUserName = driver.findElement(By.xpath("//input[@id='userEmail']"));
		enterUserName.sendKeys("shubhamnilamwar147@gmail.com");
		// enterPassword
		WebElement enterPassword = driver.findElement(By.xpath("//input[@id=\"userPassword\"]"));
		enterPassword.sendKeys("S@147n@147");
		// clickOnLoginBtn
		WebElement clickOnLoginBtn = driver.findElement(By.xpath("//input[@id='login']"));
		clickOnLoginBtn.click();
		// list of product
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals("zara coat 3")).findFirst()
				.orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	}
}
/*
 * List<WebElement> products = driver.findElements(By
 * .xpath("//div[@class=\"col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted\"]"
 * ));
 * 
 * for (WebElement product : products) { String getStatement =
 * product.findElement(By.xpath("//b[normalize-space()='zara coat 3']")).getText
 * ();
 * 
 * System.out.println("getStatement" + product.getText());
 * 
 * if (getStatement.equalsIgnoreCase("zara coat 3")) { //
 * product.findElement(By.xpath("//button[@class=\"btn w-10 rounded")).click();
 * driver.findElement(By.xpath(
 * "//div[@class='container']//div[1]//div[1]//div[1]//button[2]")).click();
 * break; } driver.close(); }
 */