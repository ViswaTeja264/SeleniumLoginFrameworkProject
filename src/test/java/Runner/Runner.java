package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src/test/java/Features",
		glue={"StepDefinitions"}
		
		)
public class Runner extends AbstractTestNGCucumberTests{
	
	

}
