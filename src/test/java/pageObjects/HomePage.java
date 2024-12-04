package pageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private final WebDriver driver;
	private WebElement welcomeText;
	private final By welcomeTextLocator = By.xpath("//div[@id='WelcomeContent']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void confirmLoggedUser(String welcomeName) {
		try {
			welcomeText = new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.visibilityOfElementLocated(welcomeTextLocator));
			Assert.assertEquals(welcomeName, welcomeText.getText());
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
	}
}
