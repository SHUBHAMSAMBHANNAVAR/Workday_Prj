package com.workday.reusables;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.workday.testbase.Testbase;

	/**
	 * @FunctionName : Login into the application.
	 * @Description  : Identifying the objects using page factory framework
	 *                 Login into the application using valid credentials (i.e.., Username = lkumar , Password = Matryx1@2020)
	 * @CreationDate : 17-09-2024
	 * @author       : Bhavani Y
	 */

	public class LoginPage extends Testbase {
			
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
		
		public String login(String un, String pw) throws InterruptedException {
			try {
				username.sendKeys(un); //entering the username 
				password.sendKeys(pw); //entering the password 
				SignIn.click();
				Thread.sleep(2000);
				Skip.click();
				Thread.sleep(5000);
				return driver.getTitle();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}


