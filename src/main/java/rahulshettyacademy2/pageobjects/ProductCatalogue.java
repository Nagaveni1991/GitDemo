package rahulshettyacademy2.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy2.AbstractComponents.AbstactComponent;

public class ProductCatalogue extends AbstactComponent{
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)    //this is constructor and we are initializing WebDriver which is coming from Parent class and "driver" scope is with in this constructor only
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));	
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	
		
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException 
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
		
		
	}
	System.out.println("This is branch creation in Git Demo");
	
	
}
