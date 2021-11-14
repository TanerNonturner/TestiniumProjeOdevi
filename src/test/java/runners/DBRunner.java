package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/resources/features", // You can specify the feature file, you can write which feature file to execute,we can also run all features
		glue ="steps" ,// shows where we can find implementation feature file steps.
		dryRun= false,// if true it does not really run the steps. it checks if every steps in feature file is defined in code
		tags ="@DB1",
		monochrome =true,
		plugin = {
				"pretty",//prints gherkin steps in console
				//"html: target/cucumber-default-report",//create a basic html report in target folderad
				"json:target/cucumber.json"	
		}
	
		)

public class DBRunner {

}
