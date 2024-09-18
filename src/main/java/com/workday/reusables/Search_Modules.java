package com.workday.reusables;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.workday.testbase.Testbase;

/**
 * @FunctionName : Search for the Required module.
 * @Description  : Searching for the required modules to enter the vales from the excel sheet.
 * @CreationDate : 17-09-2024
 * @author       : Bhavani Y
 */
public class Search_Modules extends Testbase {

	// Object Repository for Search
	@FindBy(xpath = "//input[@data-automation-id='globalSearchInput']")
	WebElement searchInput;

	// Object Repository for SearchButton
	@FindBy(xpath = "//div[@data-automation-id='searchInputSearchIcon']")
	WebElement Button;

	// Object Repository for Adhoc_Link
	@FindBy(xpath = "//a[@data-automation-id='pex-search-results-header-title-link']")
	WebElement Adhoc_Link;

	// Initilizing the page object
	public Search_Modules() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * In the below code user is searching for the create ad hoc payment in the
	 * search bar after searching clicking on the create ad hoc payment and getting
	 * the title of the pageO
	 */
	public String Search_create(String Create) throws InterruptedException {
		try {
			Thread.sleep(4000);
			searchInput.click();
			Thread.sleep(6000);
			searchInput.sendKeys(Create); //Entering for the data
			Button.click();
			Thread.sleep(2000);
			Adhoc_Link.click();//Clicking on the link
			Thread.sleep(4000);
			return driver.getTitle();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
		