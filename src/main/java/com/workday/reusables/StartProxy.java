package com.workday.reusables;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.workday.testbase.Testbase;

/**
 * @FunctionName : Searching for the start proxy 
 * @Description  : Identifying the objects using page factory framework.
 *                 Searching for the start proxy in the search bar and clicking on the start proxy link.
 * @CreationDate : 17-09-2024
 * @Parameter    : String SP
 * @author       : Bhavani Y
 */

public class StartProxy extends Testbase {

	// Object Repository for Search
	@FindBy(xpath = "//input[@data-automation-id='globalSearchInput']")
	WebElement searchInput;

	@FindBy(xpath = "//span[@class='css-10tjj0i']//*[name()='svg']")
	WebElement searchButton;

	@FindBy(xpath = "//a[text()='Start Proxy']")
	// "//input[@id='start-proxy']"
	WebElement startProxyButton;

	// Initilizing the page object
	public StartProxy() {
		PageFactory.initElements(driver, this);
	}

	
	public String startProxy(String SP) {
	    try {
	        Thread.sleep(10000);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); //Explict wait method
	        wait.until(ExpectedConditions.visibilityOf(searchInput));
	        searchInput.click(); //clicking on the search button
	        searchInput.sendKeys(SP); //Entering the data for search
	        Thread.sleep(2000);
	        searchButton.click();
	        Thread.sleep(2000);
	        startProxyButton.click(); //clicking on the startproxy link
	        Thread.sleep(2000);
	        return driver.getTitle();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
	