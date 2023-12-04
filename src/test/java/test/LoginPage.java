package test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTestClass;
import io.github.bonigarcia.wdm.WebDriverManager;

import pageobjectmodel.LandingPage;
import pageobjectmodel.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPage extends BaseTestClass {

	@Test(enabled = false)
	public void loginWebPageValidaUnaPw() throws IOException {

		String email = "shubhamnilamwar147@gmail.com";
		String pass = "S@147n@147";

		lp.loginApp(email, pass);
		System.out.println(email + " " + pass);
		HomePage hp = new HomePage(driver);
		hp.clickOneOfTheLink();

	}

	@Test
	public void loginWebPageInvalidaUnaPw() throws IOException {

		String email = "shubhamnilamwar14@gmail.com";
		String pass = "S@147n@147";

		lp.loginApp(email, pass);
		System.out.println(email + " " + pass);

		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", lp.getErrorText());
	}
}
