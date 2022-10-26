package flexiBus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtilities.ExcelFile_Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FlexiNBusBookin_Test {
	
	int count = 0;
	ExcelFile_Utilities eLib = new ExcelFile_Utilities();

	@Test ()
	public void bookTicketsForOneWayTrip() throws Throwable
	{
		
		
		int rowCount = eLib.getRowCount("Sheet1");
		
		
		
		while (rowCount>=count)
		{
			startOneWayBookingTickets();
		}
	}
		
		public void startOneWayBookingTickets () throws EncryptedDocumentException, IOException 
		{
			String data[]= eLib.getAllCellDataOfOneRow("Sheet1",count++);
			String sourceCity = data[0];
			String destinationCity = data[1];
			String departureMonth = data[2];
			String departureYear = data[3];
			String departureDate = data[4];
			String returnMonth = data[5];
			String returnYear = data[6];
			String returnDate = data[7];
			String adultPassanger = data[8];
			String  childPassanger  = data[9];
			String bike = data[10];
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://global.flixbus.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		FlexiBusHomePage homePage = new FlexiBusHomePage(driver);
		
		homePage
		        .bookTickets(sourceCity,destinationCity,departureMonth,departureYear,departureDate, returnMonth, returnYear, returnDate, adultPassanger,childPassanger, bike);

	}
	


	@Test ()
	public void bookTicketsForTwoWayTrip() throws Throwable
	{
int rowCount = eLib.getRowCount("Sheet1");
		
		
		
		while (rowCount>=count)
		{
			startTwoWayBookingTickets();
		}
	}
		
		public void startTwoWayBookingTickets () throws EncryptedDocumentException, IOException 
		{
			String data[]= eLib.getAllCellDataOfOneRow("Sheet1",count++);
			String sourceCity = data[0];
			String destinationCity = data[1];
			String departureMonth = data[2];
			String departureYear = data[3];
			String departureDate = data[4];
			String returnMonth = data[5];
			String returnYear = data[6];
			String returnDate = data[7];
			String adultPassanger = data[8];
			String  childPassanger  = data[9];
			String bike = data[10];
	
		
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://global.flixbus.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		FlexiBusHomePage homePage = new FlexiBusHomePage(driver);
		
		homePage
		        .selectRoundTripCheckBox()
		        .bookTickets(sourceCity,destinationCity,departureMonth,departureYear,departureDate, returnMonth, returnYear, returnDate, adultPassanger,childPassanger, bike);

	}


}
