package steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class LoginSteps extends CommonMethods {
	// LoginPageWithFactory lp; we don not need this any more because we have
	// already initialized it in BaseClass!!!
	// DashboardPageWithFactory dp;

	@Given("I navigate to HRMS application")
	public void ý_navigate_to_hrms_application() {
		setUp();
		// lp = new LoginPageWithFactory();
		// dp = new DashboardPageWithFactory();
	}

	@When("I enter valid username")
	public void ý_enter_valid_username() {
		sendText(login.user, "Admin");
	}

	@When("I enter valid password")
	public void ý_enter_valid_password() {
		sendText(login.password, "admin123");
	}

	@When("I click login button")
	public void ý_click_login_button() {
		click(login.loginButton);
	}

	@Then("I validate that I am logged in")
	public void ý_validate_that_ý_am_logged_in() {
		String expectedMessage = "Welcome Paul";
		String actualMessage = dashboard.welcomeMessage.getText();
		if (expectedMessage.equals(expectedMessage)) {
			System.out.println("Login Validation Test Passed!");
		} else {
			System.out.println("Login Validation Test Failed!!!");
		}

	}

	@Then("I  quit the browser")
	public void ý_quit_the_browser() {
		tearDown();

	}

	@When("I enter invalid password")
	public void ý_enter_invalid_password() {
		sendText(login.password, "adlen123");
	}

	@Then("I validate that invalid credentials message is displayed.")
	public void ý_validate_that_invalid_credentials_message_is_displayed() {
		String expectedMessage = "Invalid credentials";
		String actualMessage = driver.findElement(By.id("spanMessage")).getText();
		if (expectedMessage.equals(expectedMessage)) {
			System.out.println("Invalid Credentials Test Passed!");
		} else {
			System.out.println("Invalid Credentials Test Failed!");
		}

	}

	@When("new user enter {string} and {string}")
	public void new_user_enter_leonardo_and(String string1, String string2) {
		sendText(login.user, string1);
		sendText(login.password, string2);

	}

	@When("clicks login button")
	public void clicks_login_button() {
		wait(1);
		jsClick(login.loginButton);

	}

	@Then("checks {string} welcmome message is displayed")
	public void checks_welcmome_message_is_displayed(String string3) {
		waitForVisibilty(dashboard.welcomeMessage);
		String expectedText = "Welcome " + string3;
		String actualText = dashboard.welcomeMessage.getText();

		Assert.assertEquals("Welcome message is not true", expectedText, actualText);
	}

	@When("user login with credentilas and checks  welcome message")
	public void login(DataTable table) {
		List<Map<String, String>> map = table.asMaps();
		for (Map<String, String> maps : map) {
			sendText(login.user, maps.get("username"));
			sendText(login.password, maps.get("password"));
			wait(1);
			jsClick(login.loginButton);
			waitForVisibilty(dashboard.welcomeMessage);
			String expectedText = "Welcome " + maps.get("firstname");
			String actualText = dashboard.welcomeMessage.getText();
			Assert.assertEquals("Welcome message is not true", expectedText, actualText);
		}

	}

	@When("user enters username and password and click login button")
	public void loginUser(DataTable dataTable) {
		//System.out.println(dataTable);
	
	List<Map<String,String>> ListOfMaps = dataTable.asMaps();
	
	//System.out.println(ListOfMaps);
	
	for(Map<String,String> map :ListOfMaps) {
		//System.out.println(map);
		
		//login step
		sendText(login.user,map.get("username"));
		sendText(login.password,map.get("password"));
		click(login.loginButton);
		// Assertion step
		String expectedMsg ="Welcome "+map.get("firstname");
		String actualMsg = dashboard.welcomeMessage.getText();
		Assert.assertEquals(expectedMsg,actualMsg);
		wait(1);
		
		//logout
		dashboard.welcomeMessage.click();
		dashboard.logout.click();
		
	}
	
	}
	
	
	
	
	
	
	

}
