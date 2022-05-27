package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryLoginPage {
	
	//ECAPSULATION
	
	//   1--Declaration Process ***************Creating Private Variables*******************
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement passWord;
	
	@FindBy(id="last")
	private WebElement loginButton;
	
	//   2--Initialization Process  **********************Public One Param Constructor With driver as an Local Variable*********************
	
	public SkillraryLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//    3-- Utilization Process    ***********************Creating Public Methods**********************
	
	public void un(String userid) {
		userName.sendKeys(userid);
	}
	
	public void pw(String pass) {
		passWord.sendKeys(pass);
	}
	
	public void cl() {
		loginButton.click();
	}

}
