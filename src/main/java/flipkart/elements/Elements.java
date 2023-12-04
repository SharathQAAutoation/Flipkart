package flipkart.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {

	
	public static WebElement loginPopUp(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='Login']"));
		
	}
	//form[@autocomplete='on']/div/input
	public static WebElement loginUserName(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@type='text']"));
		
	}
	public static WebElement requestOTPBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Request OTP']"));
		
	}
	public static WebElement verifyBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Verify']"));
		
	}
	public static WebElement loginContinueBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='CONTINUE']"));	
	}
	public static WebElement loginBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Login']"));	
	}
	public static WebElement searchTextArea(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));	
	}
	
	public static WebElement searchBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[@type='submit']"));	
	}
	
	public static List<WebElement> listFromSearchWindow(WebDriver driver) {
		return driver.findElements(By.xpath("//a[@rel='noopener noreferrer']"));	
	}
	
	public static WebElement productName(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@class='B_NuCI']"));	
	}
	
	public static WebElement productPrice(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='CEmiEU']/div/div[1]"));	
	}
	
	public static WebElement addToCartBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Add to cart']"));	
	}
	
	public static List<WebElement> listFromCart(WebDriver driver) {
		return driver.findElements(By.xpath("//a[contains(@class,'gBNbID')]"));	
	}
	
	public static WebElement placeOrderBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Place Order']"));	
	}
	
	public static WebElement cartContinueBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='CONTINUE']"));	
	}
	
	public static WebElement cartRemoveBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//div[text()='Remove']"));	
	}
	
	public static WebElement popUpContinueBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Accept & Continue']"));	
	}
	
	public static WebElement paymentOptionBtn(WebDriver driver,String label) {
		return driver.findElement(By.xpath("//label[text()='"+label+"']"));	
	}
	
	public static List<WebElement> cartRemovePopUpListOptions(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='td-FUv WDiNrH']/div"));	
	}
	
	public static WebElement emptyCartText(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='hKIFfL']"));	
	}
	
	public static WebElement delivereHereBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Deliver Here']"));	
	}
	
	public static WebElement productPriceInCart(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(@class,'fSRat')]/span[2]"));	
	}
	public static WebElement productNameInCart(WebDriver driver,String productName) {
		return driver.findElement(By.xpath("//div[contains(@class,'fSRat')]/div/a[contains(text(),'"+productName+"')]"));	
	}
	
	
}
