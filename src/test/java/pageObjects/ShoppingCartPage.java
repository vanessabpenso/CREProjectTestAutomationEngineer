package pageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShoppingCartPage {
	private final WebDriver driver;
	private WebElement proceedToCheckout;
	private WebElement productId;
	private final By proceedToCheckoutLocator = By
			.xpath("//a[@href='/actions/Order.action?newOrderForm=' and @class='Button']");
	private final By productIdLocator = By.cssSelector("a[href='/actions/Catalog.action?viewItem=&itemId=EST-16']");
	

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickProceedToCheckout() {
		try {
			proceedToCheckout = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutLocator));
			proceedToCheckout.click();
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
	
	public void verifyProductIsOnCart() {
		try {
			productId = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(productIdLocator));			
			Assert.assertTrue(productId.isDisplayed());
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}

}
