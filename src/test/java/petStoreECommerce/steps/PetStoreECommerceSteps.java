package petStoreECommerce.steps;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.NavigationBar;
import pageObjects.ProductPage;
import pageObjects.ShoppingCartPage;
import pageObjects.SignInPage;
import pageObjects.SignUpPage;
import pageObjects.WelcomePage;
import setup.SetupBrowser;

public class PetStoreECommerceSteps {
	WebDriver driver;
	WelcomePage welcomePage;
	NavigationBar navigationBar;
	SignInPage signInPage;
	HomePage homePage;
	SignUpPage signUpPage;
	ProductPage productPage;
	ShoppingCartPage shoppingCartPage;
	CheckoutPage checkoutPage;


	@Given("I navigate to the PetStore login page with {string}")
	public void i_navigate_to_the_pet_store_login_page_with(String browser) {
		driver = SetupBrowser.startBrowser(browser);
		driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
	}

	@When("I enter the username {string} and password {string}")
	public void i_enter_the_username_and_password(String username, String password) {
		signInPage = new SignInPage(driver);
		signInPage.fillUsernameAndPassword(username, password);
	}

	@When("I click the Login button")
	public void i_click_the_login_button() {
		signInPage.clickLoginButton();
	}

	@Then("I should be logged in and see {string} on the page")
	public void i_should_be_logged_in_and_see_on_the_page(String welcomeName) {
		homePage = new HomePage(driver);
		homePage.confirmLoggedUser(welcomeName);
	}

	@Given("I navigate to the PetStore signup page with {string}")
	public void i_navigate_to_the_pet_store_signup_page_with(String browser) {
		driver = SetupBrowser.startBrowser(browser);
		driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
	}

	@When("I enter valid account information")
	public void i_enter_valid_account_information() {
		signUpPage = new SignUpPage(driver);
		signUpPage.fillUserId();
		signUpPage.fillNewPassword();
		signUpPage.fillFirstAndLastName();
		signUpPage.fillEmail();
		signUpPage.fillPhone();
		signUpPage.fillAddress();
	}

	@When("I click on Save Account")
	public void i_click_on_save_account() {
		signUpPage.clickSaveAccountInformation();
	}

	@Then("I should be redirected from sign up page to the home page")
	public void i_should_be_redirected_from_sign_up_page_to_the_home_page() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("https://petstore.octoperf.com/actions/Catalog.action"));
	}

	@Given("I navigate to the PetStore homepage with {string}")
	public void i_navigate_to_the_pet_store_homepage_with(String browser) {
		driver = SetupBrowser.startBrowser(browser);
		driver.get("https://petstore.octoperf.com/");
		welcomePage = new WelcomePage(driver);
		welcomePage.enterStore();
	}

	@When("I search by Persian")
	public void i_search_by_persian() {
		navigationBar = new NavigationBar(driver);
		navigationBar.search("Persian");
	}

	@When("I click on the product")
	public void i_click_on_the_product() {
		productPage = new ProductPage(driver);
		productPage.clickProductDescription();
	}

	@Then("I should see the product details")
	public void i_should_see_the_product_details() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl,
				"https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DLH-02");
	}

	
	@Given("I am logged as {string} with {string} on PetSore using {string}")
	public void i_am_logged_as_with_on_pet_sore_using(String username, String password, String browser) {
		driver = SetupBrowser.startBrowser(browser);
		driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
		signInPage = new SignInPage(driver);
		signInPage.fillUsernameAndPassword(username, password);
		signInPage.clickLoginButton();
	}

	@When("I add a product to cart")
	public void i_add_a_product_to_cart() {
		navigationBar = new NavigationBar(driver);
		navigationBar.search("Persian");
		productPage = new ProductPage(driver);
		productPage.clickProductDescription();
		productPage.addProductToCart();
	}

	@Then("I see the product added to the cart")
	public void i_see_the_product_added_to_the_cart() {
		navigationBar = new NavigationBar(driver);
		navigationBar.goToCart();
		shoppingCartPage = new ShoppingCartPage(driver);
		shoppingCartPage.verifyProductIsOnCart();
	}

	@Given("I search by Persian and add it to the cart")
	public void i_search_by_persian_and_add_it_to_the_cart() {
		navigationBar = new NavigationBar(driver);
		navigationBar.search("Persian");
		productPage = new ProductPage(driver);
		productPage.clickProductDescription();
		productPage.addProductToCart();
	}

	@When("I click on Proceed to checkout")
	public void i_click_on_proceed_to_checkout() {
		shoppingCartPage = new ShoppingCartPage(driver);
		shoppingCartPage.clickProceedToCheckout();
	}

	@When("I click to submit the order")
	public void i_click_to_submit_the_order() {
		checkoutPage = new CheckoutPage(driver);
		checkoutPage.continueWithCheckout();
		checkoutPage.confirmOrder();
	}

	@Then("I should see an order confirmation")
	public void i_should_see_an_order_confirmation() {
		checkoutPage = new CheckoutPage(driver);
		checkoutPage.verifyOrderConfirmation();
	}

	@After
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
