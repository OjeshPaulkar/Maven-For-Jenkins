package Jenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriot_PopUp {
	
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.linkText("Alert with OK ")).click();
		
		driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
		
		Alert alert = driver.switchTo().alert();
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		
		alert.dismiss();
		
		Thread.sleep(3000);
		
		// *************************************************************************************
		
		driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		alert.accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		alert.dismiss();
		Thread.sleep(3000);
		
		//  **************************************************************************************
		
		driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		alert.sendKeys("Ojesh");
		alert.accept();
		Thread.sleep(3000);
		driver.close();
		
	
		
	}

}
