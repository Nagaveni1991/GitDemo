package rahulshettyacademy2.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy2.TestComponents.BaseTest;
import rahulshettyacademy2.pageobjects.CartPage;
import rahulshettyacademy2.pageobjects.CheckOutPage;
import rahulshettyacademy2.pageobjects.ConfirmationPage;
import rahulshettyacademy2.pageobjects.LandingPage;
import rahulshettyacademy2.pageobjects.OrderPage;
import rahulshettyacademy2.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{

	String productName = "ZARA COAT 3";	
	
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
			
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();  // here we no need to declare class object because child class can access parent class methods, so we are calling the method which is present in the parent class with the help of child class object
		
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckOutPage checkoutPage = cartPage.goTocheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
	
		String confirmMessage = confirmationPage.getConfirmationMessage();
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	

	}
	
	//To verify ZARA COAT 3 is displaying in orders page
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest()
	{
		ProductCatalogue productCatalogue = landingPage.loginApplication("nagaveni.k@gmail.com", "Nagaveni@143");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
		
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"src\\test\\java\\rahulshettyacademy2\\data\\PurchaseOrder.json");
		
		return new Object[][]  {{data.get(0)},{data.get(1)}};
	}

	
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "nagaveni.k@gmail.com");
//		map.put("password", "Nagaveni@143");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "shetty@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("product", "ADIDAS ORIGINAL");
	}
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		return new object[][] {{"nagaveni.k@gmail.com", "Nagaveni@143", "ZARA COAT 3"}, {"shetty@gmail.com", "Iamking@000", "ADIDAS ORIGINAL"}};
//	}
	
	

