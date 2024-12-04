package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
	private final WebDriver driver;
	private WebElement usernameField;
	private WebElement passwordField;
	private WebElement loginButton;
	private By usernameLocator = By.name("username");
	private By passwordLocator = By.name("password");
	private By loginLocator = By.xpath("//input[@name='signon']");
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillUsernameAndPassword(String username, String password) {
		try {
			usernameField = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
			usernameField.clear();
			usernameField.sendKeys(username);
					
			passwordField = new WebDriverWait(driver, Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));				
			passwordField.clear();
			passwordField.sendKeys(password);
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	public void clickLoginButton() {
		try {
		loginButton = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(loginLocator));
			loginButton.click();
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
}
