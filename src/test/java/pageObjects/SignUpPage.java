package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;

public class SignUpPage {
	private final WebDriver driver;
	private WebElement userId;
	private WebElement newPass;
	private WebElement repPass;
	private WebElement firstName;
	private WebElement lastName;
	private WebElement email;
	private WebElement phone;
	private WebElement address1;
	private WebElement address2;
	private WebElement city;
	private WebElement state;
	private WebElement zip;
	private WebElement country;
	private WebElement SaveAccountButton;
	
	Faker faker = new Faker();
	String firstNameValue = faker.name().firstName();
	String lastNameValue = faker.name().lastName();
	String address1Value= faker.address().streetAddress();
	String address2Value= faker.address().secondaryAddress();
	String cityValue = faker.address().city();
	String stateValue = faker.address().state();
	String zipValue = faker.address().zipCode();
	String countryValue = faker.address().country();
	String phoneValue = faker.phoneNumber().phoneNumber();
	String emailValue = faker.internet().emailAddress();
	String passwordValue = faker.internet().password();
	String userIdValue = faker.internet().slug();
	
	
	private By userIdLocator = By.name("username");
	private By newPassLocator = By.cssSelector("input[name='password']");
	private By repPassLocator = By.cssSelector("input[name='repeatedPassword']");
	private By firstNameLocator = By.name("account.firstName");
	private By lastNameLocator = By.name("account.lastName");
	private By emailLocator = By.name("account.email");
	private By phoneNameLocator = By.name("account.phone");
	private By address1Locator = By.name("account.address1");
	private By address2Locator = By.name("account.address2");
	private By cityLocator = By.name("account.city");
	private By stateLocator = By.name("account.state");
	private By zipLocator = By.name("account.zip");
	private By countryLocator = By.name("account.country");
	private By SaveAccountButtonLocator = By.name("newAccount");
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillUserId() {
		try {
			userId = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOfElementLocated(userIdLocator));		
			userId.sendKeys(userIdValue);
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
	
	public void fillNewPassword() {
		try {
			newPass = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(newPassLocator));
			newPass.sendKeys(passwordValue);
			
			repPass = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(repPassLocator));
			repPass.sendKeys(passwordValue);
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
	
	public void fillFirstAndLastName() {
		try {
			firstName = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(firstNameLocator));
			firstName.sendKeys(firstNameValue);
			
			lastName = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(lastNameLocator));
			lastName.sendKeys(lastNameValue);
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
	
	public void fillEmail() {
		try {
			email = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
			email.sendKeys(emailValue);
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
				
	}
	
	public void fillPhone() {	
		try {
			phone = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(phoneNameLocator));
			phone.sendKeys(phoneValue);
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
	
	public void fillAddress() {
		try {
			address1 = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOfElementLocated(address1Locator));
			address1.sendKeys(address1Value);
			
			address2 = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOfElementLocated(address2Locator));
			address2.sendKeys(address2Value);

			city = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOfElementLocated(cityLocator));
			city.sendKeys(cityValue);
			
			state = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOfElementLocated(stateLocator));
			state.sendKeys(stateValue);

			zip = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOfElementLocated(zipLocator));
			zip.sendKeys(zipValue);

			country = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOfElementLocated(countryLocator));
			country.sendKeys(countryValue);		
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
	
	public void clickSaveAccountInformation() {
		try {
			SaveAccountButton = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.elementToBeClickable(SaveAccountButtonLocator));
			SaveAccountButton.click();
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
}
