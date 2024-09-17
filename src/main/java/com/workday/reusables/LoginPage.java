package com.workday.reusables;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends Testbase {

	/**
	 * Here, we are locating the objects from the application utilizing the Object
	 * repository or Page Factory Framework.
	 */

	// page factory -Object Repository
	// Object Repository for Username
	@FindBy(xpath = "//input[@aria-label='Username']")
	WebElement username;

	// Object Repository for Password
	@FindBy(xpath = "//input[@aria-label='Password']")
	WebElement password;

	// Object Repository for Sign In
	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement SignIn;

	// Object Repository for Skip
	@FindBy(xpath = "//a[normalize-space()='Skip']")
	WebElement Skip;

	// Initilizing the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String LoginVerification() {
		return driver.getTitle();
	}
}