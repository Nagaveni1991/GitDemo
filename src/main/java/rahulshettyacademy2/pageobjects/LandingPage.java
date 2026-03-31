package rahulshettyacademy2.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy2.AbstractComponents.AbstactComponent;

public class LandingPage extends AbstactComponent{
	
	WebDriver driver;
	public LandingPage(WebDriver driver)    //this is constructor and we are initializing WebDriver which is coming from Parent class and "driver" scope is with in this constructor only
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//PageFactory
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id= "userPassword")
	WebElement passwordEle;
	
	@FindBy(id= "login")
	WebElement submit;
	
	@FindBy(css= "[class*='FlyInOut']")
	WebElement errorMessage;
	
	public ProductCatalogue loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	//private LandingPage LandingPage() {
			// TODO Auto-generated method stub
			//return null;
		//}
	System.out.println("it is pull request");
}
