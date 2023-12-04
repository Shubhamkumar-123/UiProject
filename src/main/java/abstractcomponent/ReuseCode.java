package abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReuseCode {
	WebDriver driver;

	public ReuseCode(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementAppear(By findBy) {
		WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(10));
		expwait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitForWebElementAppear(WebElement findBy) {
		WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(10));
		expwait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public void performAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.click(element).perform();
	}

	public Alert alert() {
		Alert alert = driver.switchTo().alert();
		return alert;

	}

	public void excuterScript(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(script);

	}

	public static void commonAction(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public static void implicitWait(int time, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

}
