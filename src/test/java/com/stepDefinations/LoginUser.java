package com.stepDefinations;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginUser {

	WebDriver driver;

	@Given("user open the application login page")
	public void user_open_the_application_login_page() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	}

	@When("user enter valid username and password\\(Username:{string},Password:{string})")
	public void user_enter_valid_username_and_password_username_password(String email, String password) {

		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
	}

	@When("click on login button")
	public void click_on_login_button() {

		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	}

	@Then("user should be on Homepage")
	public void user_should_be_on_homepage() {

		boolean status = driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).isDisplayed();

		Assert.assertEquals(status, true);
		System.out.println(status);

	}

}
