package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationBar {
	private final WebDriver driver;
	private WebElement signInButton;
	private WebElement searchBox;
	private WebElement shoppingCart;
	private final By signInLocator = By.xpath("//a[normalize-space()='Sign In']");
	private final By searchBoxLocator = By.xpath("//input[@name='keyword']");
	private final By shoppingCartLocator = By.xpath("//img[@name='img_cart']");
	
	public NavigationBar(WebDriver driver) {
		this.driver = driver;
	}
	
	public void signIn() {
		try {
			signInButton = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(signInLocator));
			signInButton.click();
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
	
	public void search(String product) {
		try {
			searchBox = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(searchBoxLocator));
			searchBox.clear();
			searchBox.sendKeys(product);
			searchBox.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
	
	public void goToCart() {
		try {
			shoppingCart = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(shoppingCartLocator));
			shoppingCart.click();
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
				
	}
}
