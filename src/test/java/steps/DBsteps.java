package steps;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DBUtils;

public class DBsteps {
	List<Map<String,String>> listOfData;

	@Given("I am connected to the database")
	public void ý_am_connected_to_the_database() {
		DBUtils.getConnection();
	}

	@When("I get top three customers by credit limit")
	public void ý_get_top_three_customers_by_credit_limit() {
		listOfData = DBUtils.storeDataFromDB("SELECT * FROM customers ORDER BY creditLimit DESC LIMIT 3;");
	}

	@Then("print their names and credit limit")
	public void print_their_names_and_credit_limit() {
		for (Map<String,String> customer:listOfData) {
			String name = customer.get("customerName");
			String creditLimit = customer.get("creditLimit");
			System.out.println(name+"--->"+creditLimit);
		}
	}

	@Then("I close conncetion")
	public void ý_close_the_database_connection(DataTable dataTable) {
		DBUtils.closeConnection();
		
	}

}
