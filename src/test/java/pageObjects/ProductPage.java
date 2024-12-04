package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	private final WebDriver driver;
	private WebElement productDescription;
	private WebElement addToChart;
	private final By productDescriptionLocator = By
			.xpath("//a[@href='/actions/Catalog.action?viewProduct=&productId=FL-DLH-02']");
	private final By addToChartLocator = By
			.xpath("//a[@href='/actions/Cart.action?addItemToCart=&workingItemId=EST-16']");
	
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickProductDescription() {
		try {
			productDescription = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(productDescriptionLocator));
			productDescription.click();
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
	
	public void addProductToCart() {
		try {
			addToChart = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(addToChartLocator));
			addToChart.click();
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
	

}
