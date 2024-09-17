package com.workday.reusables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Testbase {
	public static WebDriver driver;
	public static Properties prop;

	/*
	 * Here inside the Testbase constructor we are creating the object for the prop
	 * and fileinputstream by providing the path of the config file
	 */
	public Testbase() {
		try {
			// how to read a property file
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"E:/Bhavani/Selenium_Workday_Project/src/main/java/com/workday/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	/*
	 * In Initialization method we are launching the browser by using if and else if
	 * condition, after launching the browser user is maximizing the window and
	 * waiting for sometime and later providing the required url by providing the config file path
	 */
	@SuppressWarnings("deprecation")
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("WebDriver.chrome.driver", "E:/Bhavani/chromedriver-win64/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("WebDriver.Fire.Fox", "E:/Bhavani/chromedriver-win64/chromedriver.exe");
			// driver = new GeekoDriver();
		}
		System.out.println("H");
		System.out.println("H");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(TestUtile.Page_Load_Timeout, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(TestUtile.Implicit_wait, TimeUnit.SECONDS);

		//driver.manage().timeouts().pageLoadTimeout(TestUtile.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtile.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}