@PetStore
Feature: Verify main functionalities of Pet Store website

	@Login
  Scenario Outline: Login successfully with existing user on different browsers
    Given I navigate to the PetStore login page with "<browser>"
    When I enter the username "<username>" and password "<password>"
    And I click the Login button
    Then I should be logged in and see "Welcome <name>!" on the page

    Examples:
      | browser | username| password |   name  |
      | chrome  | JQuim_3 | Pass666  | Joaquim |
      | firefox | MariliaB| Pass999  | Marilia |

	@SignUp
	Scenario Outline: Register user with valid data
    Given I navigate to the PetStore signup page with "<browser>"
    When I enter valid account information
    And I click on Save Account
    Then I should be redirected from sign up page to the home page
  
  Examples:
      | browser |
      | chrome  |
      | firefox |
      
  @SearchAndVisualizeProducts
	Scenario Outline: Search by a product and view the details
    Given I navigate to the PetStore homepage with "<browser>"
    When I search by Persian
    And I click on the product
    Then I should see the product details
  
  Examples:
      | browser |
      | chrome  |
      | firefox |
      
  @AddProductToCart
	Scenario Outline: Add a product to the cart
    Given I am logged as "<username>" with "<password>" on PetSore using "<browser>"
    When I add a product to cart
    Then I see the product added to the cart
  
  Examples:
      | browser | username| password |   name  |
      | chrome  | JQuim_3 | Pass666  | Joaquim |
      | firefox | MariliaB| Pass999  | Marilia |
      
  @Purchase
  Scenario Outline: Make purchase on the PetStore website
    Given I am logged as "<username>" with "<password>" on PetSore using "<browser>"
    And I search by Persian and add it to the cart
    When I click on Proceed to checkout
    And I click to submit the order
    Then I should see an order confirmation
      
    Examples:
      | browser | username| password |   name  |
      | chrome  | JQuim_3 | Pass666  | Joaquim |
      | firefox | MariliaB| Pass999  | Marilia |