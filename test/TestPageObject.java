package test;

import org.testng.annotations.Test;

import bsh.Console;
import dp.Data;
import graphql.Assert;
import pages.HomePage;
import pages.RegisterPage;

import java.io.File;
import java.io.IOException;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class TestPageObject {

	WebDriver driver;
	HomePage hp;
	RegisterPage rp;

	private static final Logger log = LogManager.getLogger(TestPageObject.class.getName());

	@BeforeClass
	public void beforeClass1() throws InterruptedException {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("Before Class...");
		// Open web browser
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\SeleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.out.println("Before method...");
		log.trace("Before method log");
		driver.manage().window().maximize();
		driver.get("https://www.timeanddate.com/");
		Thread.sleep(1000);
		hp = new HomePage(driver);
		rp = new RegisterPage(driver);
	}

	@Test(enabled = false, priority = 2)
	public void register() throws InterruptedException {
		System.out.println("Test1 !!!");
		hp.navigate("custom");
		Thread.sleep(1000);
		hp.navigate("register");
		// rp.fillRegistrationForm("Tomer", "test@test.com", "password");
		Assert.assertTrue(rp.fillRegistrationForm("Tomer1", "test1@test.com", "password1"));
		Thread.sleep(1000);

	}

	// The test get data from data provider method from another class
	@Test(enabled = false, priority = 1, dataProvider = "Details", dataProviderClass = Data.class)
	public void register2(String name, String email, String password) throws InterruptedException {
		System.out.println("Test2 !!!");
		hp.navigate("custom");
		Thread.sleep(1000);
		hp.navigate("register");
		Assert.assertTrue(rp.fillRegistrationForm(name, email, password));
		Thread.sleep(1000);

	}

	// The test get data from data provider from another class, with int and print
	// it
	@Test(enabled = false, priority = 1, dataProvider = "Details Int", dataProviderClass = Data.class)
	public void register3(int number1, int number2, int number3) throws InterruptedException {
		System.out.println("Test3 !!!");
		hp.navigate("custom");
		System.out.println("Number from dp: " + number1 + "," + number2 + ", " + number3);

	}

	// The test get data from Excel and registered according to list

	@Test(enabled = false, priority = 1, dataProvider = "dataFromExcel", dataProviderClass = Data.class)
	public void register5(String name, String email, String password) throws InterruptedException {
		System.out.println("Test5 !!!");
		hp.navigate("custom");
		Thread.sleep(1000);
		hp.navigate("register");
		Assert.assertTrue(rp.fillRegistrationForm(name, email, password));
		Thread.sleep(2000);
	}

	@Test(enabled = false, priority = 2)
	public void searchLocalTime() throws InterruptedException {
		System.out.println("Test4 !!!");
		// Assert.assertTrue(hp.searchLocalTime("New York City"), "Search local time");
		Assert.assertTrue(hp.searchLocalTime("New York City"));
		Thread.sleep(1000);
	}

	@Test(enabled = true, priority = 1)
	public void logSample() throws InterruptedException, IOException {
		String msg = "This is msg to send to the Report-NG";
		Reporter.log("<font size='4' color ='red'>" + msg);

		log.trace("1. log trace");
		log.debug("2. log debug");
		log.info("3. log info");
		log.info("4. log warn");
		log.error("5. log error");
		log.fatal("6. log fatal");

		// Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE); // if we want to fail the test
		// Reporter.getCurrentTestResult().setStatus(ITestResult.SUCCESS); // if we want to pass the test

		// Print screen
		addSnapShotToReport(printScreen(driver));
		log.info("Image location: " + printScreen(driver).getAbsolutePath());
				
	}

	public static void addSnapShotToReport(File file) {
		Reporter.log("<br/><p><img width='700' src='"+file.getAbsolutePath()+"'></p>");
	}
	
	// method which takes print screen
	public static File printScreen(WebDriver driver) throws IOException {
		// Take the image of webDriver
		File snap = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// method witch bring time stamp string
		DateFormat timestamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String strTimeStamp = timestamp.format(new Date());

		// set string as path of the file
		String imgPath = "C:\\images\\" + strTimeStamp + "_image.png";

		// create empty file
		File fImage = new File(imgPath);

		// copy image into our empty file
		FileUtils.copyFile(snap, fImage);

		// return image
		return fImage;

	} 

	@AfterClass
	public void afterClass() {

		System.out.println("After Class...");
		log.trace("After class log");
		driver.close();

	}

}
