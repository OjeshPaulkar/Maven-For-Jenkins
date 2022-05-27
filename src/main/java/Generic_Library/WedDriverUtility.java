package Generic_Library;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WedDriverUtility {
	
	public static WebDriver driver;
	public void dropDown(WebElement ele, String text) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}
	
	public void mouseHover(WebDriver driver, WebElement ele2) {
		Actions a = new Actions(driver);
		a.moveToElement(ele2).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement ele3) {
		Actions a = new Actions(driver);
		a.doubleClick().perform();
	}
	
	public void switchFrames(WebDriver driver) {
		driver.switchTo().frame(0);
	}
	
	public void switchBackFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void alertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchTabs(WebDriver driver) {
		Set<String> window = driver.getWindowHandles();
		for(String wb:window) {
			driver.switchTo().window(wb);
		}
	}

}
