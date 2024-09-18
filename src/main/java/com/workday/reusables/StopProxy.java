package com.workday.reusables;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.workday.testbase.Testbase;

/**
 * @FunctionName : Searching for the stop proxy 
 * @Description  : Searching for the stop proxy and clicking on the stop proxy and click on ok button
 * @CreationDate : 17-09-2024
 * @Parameter    : String StopProxy
 * @author       : Bhavani Y
 */

public class StopProxy extends Testbase {

	// Object Repository for SearchButton
	@FindBy(xpath = "//span[@class='css-9gpxd9']//*[name()='svg']")
	WebElement Search_clear;

	// Object Repository for Search
	@FindBy(xpath = "//input[@data-automation-id='globalSearchInput']")
	WebElement Stop_Search;

	// Object Repository for SearchButton
	@FindBy(xpath = "//span[@class='css-10tjj0i']//*[name()='svg']")
	WebElement Search_Button;

	// Object Repository for SearchButton
	@FindBy(xpath = "//a[normalize-space()='Stop Proxy']")
	WebElement Stop_link;

	// Object Repository for OK_Button
	@FindBy(xpath = "//button[@title='OK']")
	WebElement OK_Button;

	// Initilizing the page object
	public StopProxy() {
		PageFactory.initElements(driver, this);
	}

	public void Stop(String StopProxy) {
		try {
			Thread.sleep(2000);
			Stop_Search.click();
			Thread.sleep(3000);
			Search_clear.click();
			Thread.sleep(3000);
			Stop_Search.click();
			Thread.sleep(2000);
			Stop_Search.sendKeys(StopProxy);
			Thread.sleep(2000);
			Search_Button.click();
			Thread.sleep(2000);
			Stop_link.click();
			Thread.sleep(2000);
			OK_Button.click();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}