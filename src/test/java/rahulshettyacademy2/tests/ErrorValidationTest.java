package rahulshettyacademy2.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy2.TestComponents.BaseTest;
import rahulshettyacademy2.TestComponents.Retry;
import rahulshettyacademy2.pageobjects.CartPage;
import rahulshettyacademy2.pageobjects.CheckOutPage;
import rahulshettyacademy2.pageobjects.ConfirmationPage;
import rahulshettyacademy2.pageobjects.ProductCatalogue;

public class ErrorValidationTest extends BaseTest{

	@Test(groups = {"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException
	{
		String productName = "ZARA COAT 3";		
		landingPage.loginApplication("nagave@gmail.com", "Nagaven143");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	
	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{
		String productName = "ZARA COAT 3";		
		ProductCatalogue productCatalogue = landingPage.loginApplication("nagaveni.k@gmail.com", "Nagaveni@143");
		
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();  // here we no need to declare class object because child class can access parent class methods, so we are calling the method which is present in the parent class with the help of child class object
		
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	}


}
