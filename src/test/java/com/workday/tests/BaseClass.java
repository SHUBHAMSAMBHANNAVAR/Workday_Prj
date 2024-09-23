package com.workday.tests;


import org.testng.annotations.BeforeTest;

import com.workday.reusables.AuthenticationPage;
import com.workday.reusables.LoginPage;
import com.workday.reusables.Search_Modules;
import com.workday.reusables.StartProxy;
import com.workday.testbase.Testbase;

public class BaseClass extends Testbase {
	// Declaring the variables
	LoginPage loginPage;
	StartProxy start_proxy;
	AuthenticationPage authenticate;
	Search_Modules Module;
	

	/**
	 * This super class will initialize the property and filestreaminput methods and
	 * will create the object of it.
	 */
	public BaseClass() {
		super();
	}

	/**
	 * Inside the base test user is launching the browser through initialize method
	 * and creating the objects for the each methods.
	 * 
	 * @throws InterruptedException
	 */
	@BeforeTest
	public void setUp() throws InterruptedException {
		// calling the method for launching the browser
		initialization();
		// Creating the object
		loginPage = new LoginPage();
		start_proxy = new StartProxy();
		authenticate = new AuthenticationPage();
	
	try {
		String Loginver_title = loginPage.LoginVerification();
	    Thread.sleep(1000);
	} catch (InterruptedException e) {
	    Thread.currentThread().interrupt(); // Preserve interrupt status
	    System.out.println("Thread was interrupted!");
	}
	

	/**
	 * Using valid credentials login to the application and verifying through the
	 * titles of the page
	 */	
	try {
		String LoginTest_title = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    Thread.sleep(1000);
	} catch (InterruptedException e) {
	    Thread.currentThread().interrupt(); // Preserve interrupt status
	    System.out.println("Thread was interrupted!");
	    
	}
}
}