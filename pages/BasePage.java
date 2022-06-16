package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	WebDriverWait waitDriver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		waitDriver = new WebDriverWait(driver, Duration.ofSeconds(5));

	}

	public void fillText(By by, String str) {
		WebElement we = driver.findElement(by);
		we.clear();
		we.sendKeys(str);
	}

	public void click(By by) {
		waitDriver.until(ExpectedConditions.elementToBeClickable(by)); // wait until web element is clickable
		WebElement we = driver.findElement(by);

		we.click();

	}

}
