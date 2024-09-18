package com.workday.reusables;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.workday.testbase.Testbase;


/**
 * @FunctionName : In Authentication page entering the valid username or actas name 
 * @Description  : In Authentication entering the valid person name for further steps.
 * @CreationDate : 17-09-2024
 * @Parameter    : String Proxy
 * @author       : Bhavani Y
 */

public class AuthenticationPage extends Testbase {

	// page factory -Object Repository
	// Object Repository for Act As
	@FindBy(xpath = "//label[text()='Act As']")
	WebElement Authenticate;

	// Object Repository for UserId
	@FindBy(xpath = "//label[text()='Act As']/parent::div/following-sibling::div//input")
	WebElement UserId;

	// Object Repository for okButton
	@FindBy(xpath = "//button[@data-automation-id='wd-CommandButton_uic_okButton']")
	WebElement button;

	// Initilizing the page object
	public AuthenticationPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * In the following we are checking if the Act as label is present then we are
	 * entering the username 
	 */
	public String Authentication(String Proxy) throws InterruptedException {
		try {
			if (Authenticate.isDisplayed()) {
				UserId.sendKeys(Proxy);
				UserId.sendKeys(Keys.ENTER); //using the keyboard actions
				Thread.sleep(2000);
				button.click();
			} else {
				System.out.println("Invalid");
			}
			return driver.getTitle();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}