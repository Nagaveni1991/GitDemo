package rahulshettyacademy2.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy2.AbstractComponents.AbstactComponent;

public class OrderPage extends AbstactComponent{
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> ProductNames;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutEle;
	
	
	public Boolean VerifyOrderDisplay(String productName)
	{
		Boolean match = ProductNames.stream().anyMatch(Product-> Product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	

}
