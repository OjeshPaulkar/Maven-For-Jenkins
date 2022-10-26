package flexiBus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtilities.ExcelFile_Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FlexiNBusBookin_Test {

	@Test ()
	public void bookTicketsForOneWayTrip() throws Throwable
	{
		
		ExcelFile_Utilities eLib = new ExcelFile_Utilities();
		
		String sourceCity = eLib.getExcelData("Test Data", 15,0);
		String destinationCity = eLib.getExcelData("Test Data", 15,1);
		String departureMonth = eLib.getExcelData("Test Data", 15,2);
		String departureYear = eLib.getExcelData("Test Data", 15,3);
		String departureDate = eLib.getExcelData("Test Data", 15,4);
		String returnMonth = eLib.getExcelData("Test Data", 15,5);
		String returnYear = eLib.getExcelData("Test Data", 15,6);
		String returnDate = eLib.getExcelData("Test Data", 15,7);
		String adultPassanger = eLib.getExcelData("Test Data", 15,8);
		String childPassanger = eLib.getExcelData("Test Data", 15,9);
		String bike = eLib.getExcelData("Test Data", 15,10);
		
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://global.flixbus.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		FlexiBusHomePage homePage = new FlexiBusHomePage(driver);
		
		homePage
		        .bookTickets(sourceCity,destinationCity,departureMonth,departureYear,departureDate, returnMonth, returnYear, returnDate, adultPassanger,childPassanger, bike);

	}
	
	
	
	@Test ()
	public void bookTicketsForTwoWayTrip() throws Throwable
	{
		
		ExcelFile_Utilities eLib = new ExcelFile_Utilities();
		
		String sourceCity = eLib.getExcelData("Test Data", 15,0);
		String destinationCity = eLib.getExcelData("Test Data", 15,1);
		String departureMonth = eLib.getExcelData("Test Data", 15,2);
		String departureYear = eLib.getExcelData("Test Data", 15,3);
		String departureDate = eLib.getExcelData("Test Data", 15,4);
		String returnMonth = eLib.getExcelData("Test Data", 15,5);
		String returnYear = eLib.getExcelData("Test Data", 15,6);
		String returnDate = eLib.getExcelData("Test Data", 15,7);
		String adultPassanger = eLib.getExcelData("Test Data", 15,8);
		String childPassanger = eLib.getExcelData("Test Data", 15,9);
		String bike = eLib.getExcelData("Test Data", 15,10);
		
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://global.flixbus.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		FlexiBusHomePage homePage = new FlexiBusHomePage(driver);
		
		homePage
		        .selectRoundTripCheckBox()
		        .bookTickets(sourceCity,destinationCity,departureMonth,departureYear,departureDate, returnMonth, returnYear, returnDate, adultPassanger,childPassanger, bike);

	}


}
