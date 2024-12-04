package petStoreECommerce;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
	    tags = "@PetStore", 
	    features = "src/test/resources", 
	    glue = "petStoreECommerce.steps", 
	    plugin = {
	        "pretty", 
	        "html:target/cucumber/report.html", 
	        "junit:target/reports/cucumber.xml", 
	        "json:target/reports/cucumber.json", 
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    }
	 )
	 public class TestRunner extends AbstractTestNGCucumberTests {
	    @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
	 }

