package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		WebElement enterUserName = driver.findElement(By.xpath("//input[@id='userEmail']"));
		enterUserName.sendKeys("shubhamnilamwar147@gmail.com");

		WebElement enterPassword = driver.findElement(By.xpath("//input[@id=\"userPassword\"]"));
		enterPassword.sendKeys("S@147n@147");

		WebElement clickOnLoginBtn = driver.findElement(By.xpath("//input[@id='login']"));
		clickOnLoginBtn.click();

		WebElement HomePageText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='zara coat 3']")));

		String value = HomePageText.getText();
		System.out.println("value " + value);
		WebElement addCartproduct = driver.findElement(By.xpath("(//button[@class=\"btn w-10 rounded\"])[1]"));
		addCartproduct.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@routerlink='/dashboard/cart']")))
				.click();

		WebElement CartText = driver.findElement(By.xpath("// h3[normalize-space()='zara coat 3']"));
		String addCart = HomePageText.getText();
		System.out.println("addCart " + addCart);
	}
}
