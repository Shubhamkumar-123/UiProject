package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import abstractcomponent.ReuseCode;
import base.BaseTestClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjectmodel.LandingPage;
import pageobjectmodel.AddCartMessege;
import pageobjectmodel.HomePage;
import org.testng.Assert;

public class AddCartMessegesDemo extends BaseTestClass {

	@Test()
	public void loginWebPageValidaUnaPw() throws IOException {

		String email = "shubhamnilamwar147@gmail.com";
		String pass = "S@147n@147";

		lp.loginApp(email, pass);
		AddCartMessege ac = new AddCartMessege(driver);
		ac.clickOnTablet();

		String cartMessege = ac.succesfullAddCartMessege();
		String succesfulMessege = "Samsung Galaxy Tab 10.1";
		boolean verifyAddCartMessege = cartMessege.contains(succesfulMessege);

		if (verifyAddCartMessege) {
			System.out.println("add product succesfully");

		} else {
			System.out.println("verification fail");

		}

	}

}