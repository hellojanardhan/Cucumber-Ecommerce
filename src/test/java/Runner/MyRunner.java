package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Janardhan\\eclipse-workspace\\Ecommerce\\Features\\AddCustomer.feature",
		dryRun = false,
		glue = "stepDefinitions",
		plugin = {"pretty","html:test-output"})
public class MyRunner {
	
}
