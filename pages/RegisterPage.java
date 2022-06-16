package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public boolean fillRegistrationForm(String sName, String sEmail, String sPassword) {

		// fill registration form
		fillText(By.name("fullname"), sName);
		fillText(By.name("email"), sEmail);
		fillText(By.id("password"), sPassword);
		fillText(By.id("password1"), sPassword);

		return true;
	}

}
