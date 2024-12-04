package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {
	private final WebDriver driver;
	private WebElement enterStore;
	private final By enterStoreLocator = By.xpath("//a[normalize-space()='Enter the Store']");
	
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterStore() {
		try {
			enterStore = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(enterStoreLocator));
			enterStore.click();
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
}
