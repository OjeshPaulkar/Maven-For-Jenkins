package Jenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Interview_ques001 {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoblaze.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Login Into Demo Account*******************
		driver.findElement(By.id("login2")).click();
		driver.findElement(By.id("loginusername")).sendKeys("demo");
		driver.findElement(By.id("loginpassword")).sendKeys("demo");
		driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
		Thread.sleep(5000);
		
		//Viewing Mobile Product List*****************
		driver.findElement(By.xpath("(//a[@id='itemc'])[1]")).click();
		
		//selecting Product and going to Product Detail Page**********
		driver.findElement(By.linkText("Iphone 6 32gb")).click();
		
		//Adding Product to Cart********************
		driver.findElement(By.linkText("Add to cart")).click();
		Thread.sleep(3000);
		
		//Handling JavaScript Pop-up, Which appears after successful adding product to cart
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		
		//Opening cart to checkout
		driver.findElement(By.id("cartur")).click();
		Thread.sleep(7000); 
		
		//CheckOut
		driver.findElement(By.xpath("//button[@data-target='#orderModal']")).click();
		Thread.sleep(3000);
		
		//Payment Details
		
		driver.findElement(By.id("name")).sendKeys("Eva Adams");
		driver.findElement(By.id("country")).sendKeys("France");
		driver.findElement(By.id("city")).sendKeys("Paris");
		driver.findElement(By.id("card")).sendKeys("987456123987");
		driver.findElement(By.id("month")).sendKeys("JUNE");
		driver.findElement(By.id("year")).sendKeys("2069");
		driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();
		
		//Verification Of Purchase
		WebElement pop = driver.findElement(By.xpath("//div[@data-animation='pop']"));
		String text = pop.getText();
		System.out.println(text);
		Thread.sleep(2000);
		
		driver.close();
		
		
	}

}
