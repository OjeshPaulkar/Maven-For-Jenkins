package flexiBus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FlexiBusHomePage {

	WebDriver driver;

	@FindBy (id ="searchInput-from")
	private WebElement sourceCityTextBox ;
	
	@FindBy (xpath = "//button[@class='ob_qZ']")
	private WebElement selectFirstCityInDropdown;
	
	@FindBy (id ="searchInput-to")
	private WebElement destinationCityTextbox;
	
	@FindBy (id ="dateInput-from")
	private WebElement clickDepartureDate;
	
	@FindBy (id ="dateInput-to")
	private WebElement clickReturnDate;
	
	@FindBy (xpath ="//label[text()='Departure']/ancestor::div[@class='jNQ9k']/descendant::h3[text()='October 2022']/parent::caption/following-sibling::tbody/descendant::span[text()='28']")
	private WebElement selectDepartureDate;
	
	@FindBy (xpath ="//label[text()='Return']/ancestor::div[@class='jNQ9k']/descendant::h3[text()='October 2022']/parent::caption/following-sibling::tbody/descendant::span[text()='28']")
	private WebElement selectReturnDate;
	
    @FindBy (id = "search-mask-trip-mode-roundtrip-toggle")
    private WebElement roundTripCheckBox;

	
	@FindBy (id ="productSummary")
	private WebElement passangerTextBox;
	
	@FindBy (xpath ="//div[text()='Adults']/../following-sibling::div/descendant::button[@class='hcr-btn-4-5-2 hcr-btn--square-4-5-2 hcr-quantity__button-4-5-2 hcr-quantity__button--plus-4-5-2']")
	private WebElement addAdultPassanger;
	
	@FindBy (xpath ="//div[text()='Children']/../following-sibling::div/descendant::button[@class='hcr-btn-4-5-2 hcr-btn--square-4-5-2 hcr-quantity__button-4-5-2 hcr-quantity__button--plus-4-5-2']")
	private WebElement addChildrenPassanger;
	
	@FindBy (xpath ="//div[text()='Bikes']/../following-sibling::div/descendant::button[@class='hcr-btn-4-5-2 hcr-btn--square-4-5-2 hcr-quantity__button-4-5-2 hcr-quantity__button--plus-4-5-2']")
	private WebElement addBike;
	
	@FindBy (xpath = "//button[text()='Search']")
	private WebElement searchButton;
	
	
	//CONSTRUCTOR
	public FlexiBusHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * select roundTrip Check Box
	 */
	public FlexiBusHomePage selectRoundTripCheckBox()
	{
		roundTripCheckBox.click();
		return this;
	}
	
	/*
	 * Select sourceCity
	 */ 
	public FlexiBusHomePage selectSourceCity(String cityName)
	{
		sourceCityTextBox.click();
		sourceCityTextBox.sendKeys(cityName);
		selectFirstCityInDropdown.click();
		return this;
	}
	
	
	
	/*
	 * Select destinationCity
	 */
		public FlexiBusHomePage selectDestinationCity(String cityName)
	{
		destinationCityTextbox.click();
		destinationCityTextbox.sendKeys(cityName);
		selectFirstCityInDropdown.click();
		return this;
	}
	
	
	
	
	/*
	 * select departureDate
	 */
	public FlexiBusHomePage selectDepartureDate(String month, String year, String date)
	{
		clickDepartureDate.click();
		driver.findElement(By.xpath("//label[text()='Departure']/ancestor::div[@class='jNQ9k']/descendant::h3[text()='" + month + " " +  year + "']/parent::caption/following-sibling::tbody/descendant::span[text()='" + date + "']")).click();
		return this;
	}
	
	
	
	/*
	 * select returnDate
	 */
	public FlexiBusHomePage selectReturnDate(String month, String year, String date)
	{
		clickReturnDate.click();
		driver.findElement(By.xpath("//label[text()='Return']/ancestor::div[@class='jNQ9k']/descendant::h3[text()='" + month + " " +  year + "']/parent::caption/following-sibling::tbody/descendant::span[text()='" + date + "']")).click();
		return this;
	}
	
	
	
	/*
	 * addPassangers and bike
	 */
	public void addPassengers(String adultPassanger, String childPassanger, String bike)
	{
		passangerTextBox.click();
		
		int adult = Integer.parseInt(adultPassanger);
		int child = Integer.parseInt(childPassanger);
		int bik = Integer.parseInt(bike);
		
		for (int i=0; i<adult-1; i++)
		{
			addAdultPassanger.click();
		}
		
		for (int i=0; i<child; i++)
		{
			addChildrenPassanger.click();
		}
		
		for (int i=0; i<bik; i++)
		{
			addBike.click();
		}
		
	}
	
	
	
	/*/
	 * Business Method to Book the Ticket
	 */
	
	public void bookTickets(String sourceCity, String destinationCity, String departureMonth, String departureYear, String departureDate, String returnMonth, String returnYear, String returnDate, String adultPassanger, String childPassanger, String bike )
	{
		this
		     .selectSourceCity(sourceCity)
	         .selectDestinationCity(destinationCity)
	         .selectDepartureDate(departureMonth, departureYear, departureDate)
	         .addPassengers(adultPassanger, childPassanger, bike);
	    if (roundTripCheckBox.isSelected())
	    {
	    	this.selectReturnDate(returnMonth, returnYear, returnDate);
	    } 
	    searchButton.click();
	}
}


