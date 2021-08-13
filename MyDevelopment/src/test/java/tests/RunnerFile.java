package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src/test/resources/features/TC04 Email Validation.feature", 
		glue = "stepdefintionfiles"
		
		)

public class RunnerFile extends AbstractTestNGCucumberTests{

}
