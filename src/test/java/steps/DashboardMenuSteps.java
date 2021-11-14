package steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import utils.CommonMethods;

public class DashboardMenuSteps  extends CommonMethods{
	

	@Then("I want to see these items in the menu")
	public void ý_want_to_see_these_items_in_the_menu(io.cucumber.datatable.DataTable dataTable) {
	    System.out.println(dataTable);
	    List<String> expectedList = dataTable.asList();
	    List<String> actualList = new ArrayList<>();
	    for(WebElement element: dashboard.dashboardMenu) {
	    	actualList.add(element.getText());
	    }
	    System.out.println(expectedList);
	    System.out.println(actualList);
	    Assert.assertEquals(expectedList,actualList);
	}
}