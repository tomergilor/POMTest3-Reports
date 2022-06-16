package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public boolean searchLocalTime(String local) {
		fillText(By.xpath("//div[@class='box-bottom']//input[@name='query']"), local);
		click(By.xpath("//div[@class='box-bottom']//i[@class='i-font i-search']"));
		return true;
	}

	public void navigate(String location) throws InterruptedException {
		boolean bResult = false;

		switch (location) {
		case ("custom"): {
			driver.findElement(By.xpath("//i[@class='i-font i-account_circle site-nav__desktop-title']")).click();
			break;
		}
		case ("register"): {
			driver.findElement(By.partialLinkText("Create a new account")).click();
			Thread.sleep(1000);
			// Verify the register window opens
			if (driver.findElement(By.xpath("//h2[@class='modal-title']")).isDisplayed());
				bResult = true;
				break;

		} 
		}

	}

}
