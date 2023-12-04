package flipkart.actions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import flipkart.elements.Elements;

public class Actions {

	public static void loginFn(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(Elements.loginUserName(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(Elements.loginUserName(driver)));
		Elements.loginUserName(driver).clear();
		Elements.loginUserName(driver).sendKeys("7899001677");
		Thread.sleep(3000);
		System.out.println("Entered Mobile Number");

		wait.until(ExpectedConditions.visibilityOf(Elements.loginContinueBtn(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(Elements.loginContinueBtn(driver)));
		Elements.loginContinueBtn(driver).click();
		Thread.sleep(3000);
		System.out.println("Clicked on Login Continue Button");

		Thread.sleep(10000);
		System.out.println("Added OTP manually");

		wait.until(ExpectedConditions.visibilityOf(Elements.loginBtn(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(Elements.loginBtn(driver)));
		Elements.loginBtn(driver).click();
		System.out.println("Clicked on Login Button");
		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOf(Elements.delivereHereBtn(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(Elements.delivereHereBtn(driver)));
		System.out.println("Logged in Successfully and Checkout Page is loaded");
	}

	public static void searchProduct(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(Elements.searchTextArea(driver)));
		Elements.searchTextArea(driver).clear();
		System.out.println("Searching  for the product apple");
		Elements.searchTextArea(driver).sendKeys("apple");
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOf(Elements.searchBtn(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(Elements.searchBtn(driver)));
		Elements.searchBtn(driver).click();
		Thread.sleep(3000);

		List<WebElement> applePrdcts = Elements.listFromSearchWindow(driver);
		wait.until(ExpectedConditions.visibilityOf(applePrdcts.get(0)));
		wait.until(ExpectedConditions.elementToBeClickable(applePrdcts.get(0)));
		applePrdcts.get(0).click();
		Thread.sleep(7000);
		System.out.println("clicked on 1st item for the products list");

		System.out.println("Opens new tab- handling windows");
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent Window : " + parentWindowHandle);

		Set<String> allWindowHandles = driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1 = allWindowHandles.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parentWindowHandle.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(
						"Switched to new tab with title : " + driver.switchTo().window(child_window).getTitle());
				wait.until(ExpectedConditions.visibilityOf(Elements.productName(driver)));
				wait.until(ExpectedConditions.visibilityOf(Elements.productPrice(driver)));
				System.out.println("Waiting till the Product Details page load");

				String productName = Elements.productName(driver).getText();
				String price = Elements.productPrice(driver).getText();
				System.out.println("Product Details - Name :" + productName + ", Price : " + price);
				Thread.sleep(3000);

				wait.until(ExpectedConditions.visibilityOf(Elements.addToCartBtn(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(Elements.addToCartBtn(driver)));
				Elements.addToCartBtn(driver).click();
				System.out.println("Click on 'Add to cart' Button");
				Thread.sleep(3000);
				System.out.println(" Product is added to cart- Loads CART page");

				String productNameiInCart = Elements.productNameInCart(driver, productName).getText();
				if (productName.contains(productNameiInCart)
						&& price.contains(Elements.productPriceInCart(driver).getText())) {
					System.out.println("Product Details are matching in the cart");

					wait.until(ExpectedConditions.visibilityOf(Elements.placeOrderBtn(driver)));
					wait.until(ExpectedConditions.elementToBeClickable(Elements.placeOrderBtn(driver)));
					Elements.placeOrderBtn(driver).click();
					System.out.println("Clicked on 'Place Order' Button");
					Thread.sleep(5000);

					System.out.println("Login Page Shows UP");
					loginFn(driver);
					Thread.sleep(5000);
					Elements.delivereHereBtn(driver).click();
					System.out.println("Clicked on 'Delive here' Button");

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,350)", "");

					wait.until(ExpectedConditions.visibilityOf(Elements.cartContinueBtn(driver)));
					wait.until(ExpectedConditions.elementToBeClickable(Elements.cartContinueBtn(driver)));
					Elements.cartContinueBtn(driver).click();
					System.out.println("Clicked on 'Continue' Button");
					Thread.sleep(7000);

					System.out.println("User validation Pop Up loads - Accept and Continue here");

					wait.until(ExpectedConditions.visibilityOf(Elements.popUpContinueBtn(driver)));
					wait.until(ExpectedConditions.elementToBeClickable(Elements.popUpContinueBtn(driver)));
					Elements.popUpContinueBtn(driver).click();
					System.out.println("Clicked on 'Accept and Continue' Button in the Pop-UP");

					Thread.sleep(5000);
					System.out.println(
							"Payment Options opened, Select any payment options from these 'Wallets', 'Credit / Debit / ATM Card' / 'Net Banking' /'EMI (Easy Installments)' ");

					wait.until(ExpectedConditions.visibilityOf(Elements.paymentOptionBtn(driver, "Wallets")));
					wait.until(ExpectedConditions.elementToBeClickable(Elements.paymentOptionBtn(driver, "Wallets")));
					Elements.paymentOptionBtn(driver, "Wallets").click();
					System.out.println("Clicked on 'Payment- wallets' Option Button");
					Thread.sleep(5000);

					System.out.println("Removing the added product from the CART");
					assertTrue(removeProduct(driver));
					/*
					 * Elements.cartRemoveBtn(driver).click();
					 * System.out.println("Clicked on Product 'Remove' Button"); Thread.sleep(5000);
					 */

				} else {
					System.out.println("Product Details are not matching - recheck again");
					Assert.fail("Product Details are not matching - recheck again");
				}

				driver.close();
			}

		}
	}

	public static boolean removeProduct(WebDriver driver) throws InterruptedException {
		System.out.println("Navigating to Previous page in the same window");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.navigate().back();
		Thread.sleep(3000);
		System.out.println("CART page shows up");

		wait.until(ExpectedConditions.visibilityOf(Elements.cartRemoveBtn(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(Elements.cartRemoveBtn(driver)));
		Elements.cartRemoveBtn(driver).click();
		System.out.println("Clicked on Product 'Remove' Button");
		Thread.sleep(5000);

		System.out.println(
				"Pop up loads with text -Are you sure to remove the product? with Options 'Cancel' and 'Remove'");

		List<WebElement> removePopUpElements = Elements.cartRemovePopUpListOptions(driver);
		for (WebElement element : removePopUpElements) {
			if (element.getText().contains("Remove")) {
				wait.until(ExpectedConditions.visibilityOf(element));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				System.out.println("Clicked on 'Remove' Button");
				Thread.sleep(5000);

				wait.until(ExpectedConditions.visibilityOf(Elements.emptyCartText(driver)));
				wait.until(ExpectedConditions.elementToBeClickable(Elements.emptyCartText(driver)));
				System.out.println("Element is removed from the cart and page reloads with empty page");

				assertEquals(Elements.emptyCartText(driver).getText(), "Add items to it now.",
						"Product is successfully removed from the CART");
				return true;
			}
		}
		return false;
	}
}
