package pageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	private final WebDriver driver;
	private WebElement continueButton;
	private WebElement confirmOrder;
	private WebElement orderConfirmation;
	
	private final By continueButtonLocator = By.cssSelector("input[value='Continue']");
	private final By confirmOrderLocator = By
			.xpath("//a[@href='/actions/Order.action?newOrder=&confirmed=true' and @class='Button']");	
	private final By orderConfirmationLocator = By.xpath("//ul[@class='messages']");
	

	

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void continueWithCheckout() {
		try {
			continueButton = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
			continueButton.click();
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
	
	public void confirmOrder() {
		try {
			confirmOrder = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(confirmOrderLocator));
			confirmOrder.click();
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
			
	}
	
	public void verifyOrderConfirmation() {
		try {
			orderConfirmation = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationLocator));

			String confirmationText = orderConfirmation.getText();
			Assert.assertEquals(confirmationText,"Thank you, your order has been submitted.");
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
}
