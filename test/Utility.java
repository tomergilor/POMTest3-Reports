package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {

	// Check if element list including element, which means the element exists
	public static boolean isWebElementExist(By by, WebDriver driver) {
		
		List<WebElement> list = driver.findElements(by);
		if (list.size() > 0)
			return true;
		else
			return false;

	} 

}
