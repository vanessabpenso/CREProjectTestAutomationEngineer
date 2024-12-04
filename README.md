# Certificação Rumos Expert: Test Automation Engineer 


## Tools used for this project

**IDE**: Eclipse 

**Frameworks used**: Selenium, Cucumber

**Testing framework**: TestNG, Allure Report, JUnit

**Programming language**: JAVA

**Build tool**: Maven

**CI/CD Tool**: Jenkins

**Repository**: GitHub

## E-commerce website used

https://petstore.octoperf.com/


## Test Scenarios

 - User registration
 - User login
 - Search and visualize products
 - Add product to shopping cart
 - Purchase an item 


## Project organization

The project only has a feature file that was used to describe all the test scenarios mentioned above with Gherkin.
All scenarios have a tag so they can run independently but there is also a global tag @PetStore to run all the scenarios.
The test runner is currently set up with the tag @PetStore so all scenarios run.


To run the tests locally use `mvn clean test` command

To run a specific scenario from the feature file use
`mvn clean test -Dcucumber.filter.tags="@Login" -Dcucumber.glue="petStoreECommerce.steps"`

After, these steps run `allure serve target/surefire-reports` to have the allure report for the test runs.

The project can also run on Jenkins, for that the Jenkins needs to be installed and to verify the Allure report, Allure should be installed and setup on the Jenkins Pipeline.

![image](https://github.com/user-attachments/assets/746f7bb4-b11d-4843-a218-19e6f4df50c6)


The project uses Page Object Models so each page of the Pet Store website has its own class with the page elements and their interaction. All of the Java classes are in the Page Objects folder.
Additionally, there is a folder to set up the browser so the tests can run in several browsers and also in parallel.

There was no need to create a Util package since the Faker library was used to create the data needed.


## Author
**Name**: Vanessa Penso
