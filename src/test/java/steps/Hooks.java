package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testbases.BaseClass;
import utils.CommonMethods;

public class Hooks  {

	@Before
	public void start(Scenario scenario) {
		System.out.println("Starting Test "+ scenario.getName());
		//BaseClass.setUp();
		
	}
	
	
	@After
	public void end(Scenario scenario) {
		
		byte[] picture;
		if(scenario.isFailed()) {
			//take screenshot and put it in failed folder
			picture = CommonMethods.CucumberTakesScreenshot("\\failed\\"+scenario.getName());
		}else {
			picture = CommonMethods.CucumberTakesScreenshot("\\passes\\"+scenario.getName());
		}
		 
		scenario.attach(picture, "image\\png",scenario.getName());
		
		
		
		
		System.out.println("Ending Test "+scenario.getName());
		System.out.println(scenario.getStatus());
		//BaseClass.tearDown();
	}
}
