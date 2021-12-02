package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import pages.GittiGidiyorMainPageElements;
import utils.CommonMethods;

public class TestiniumGittiGidiyor extends CommonMethods {
	String productPrice;

	@Given("I navigate to www.gittigidiyor.com")
	public void ý_navigate_to_www_gittigidiyor_com() {
		setUp();
		wait(2);

	}

	@When("add search button {string} and click search button")
	public void add_search_button_and_click_search_button(String text) {
		sendText(gittiGidiyorMain.searchBlank, text);
		wait(2);
		jsClick(gittiGidiyorMain.searchButton);

	}

	@When("navigate the second result page")
	public void navigate_the_second_result_page() {
		scrollDown(200);
		wait(2);
		jsClick(gittiGidiyorResult.secondButton);
		wait(2);
	}

	@Then("validate opened if second result page")
	public void validate_opened_if_second_result_page() {
		String expectedPage = "2";
		String actualPage = gittiGidiyorSecond.secondButtonText.getText();
		Assert.assertEquals("This is not 2nd page!", expectedPage, actualPage);
	}

	@Then("according the result page choose any one product")
	public void according_the_result_page_choose_any_one_product() {
		waitForVisibilty(gittiGidiyorSecond.secondButtonText);
		wait(2);
		scrollDown(180);
		scrollToElement(gittiGidiyorSecond.product);
		jsClick(gittiGidiyorSecond.product);

	}

	@Then("chosen product info and price is written in txt file.")
	public void chosen_product_info_and_price_is_written_in_txt_file() throws Exception {
		String filePath = "C:\\Users\\P&B\\eclipse-workspace\\Cucumber-Framework\\src\\test\\resources\\configs\\testinium.txt";
		String productÝnfo = gittiGidiyorChosen.productÝnfo.getText();
		productPrice = gittiGidiyorChosen.productPrice.getText();

		writeTXTfile(filePath, "productInfo", productÝnfo);
		wait(2);
		writeTXTfile(filePath, "productPrice", productPrice);

	}

	@Then("chosen product is added to cart")
	public void chosen_product_is_added_to_cart() {
		wait(1);
		waitForClickability(gittiGidiyorChosen.addCart);
		jsClick(gittiGidiyorChosen.addCart);
	}

	@Then("compare  product price at  result page and price at cart")
	public void compare_product_price_at_result_page_and_price_at_cart() {
		wait(1);
		scrollToElement(gittiGidiyorChosen.cartImage);
		wait(1);
		scrollToElement(gittiGidiyorChosen.gotToCart);
		wait(1);
		jsClick(gittiGidiyorChosen.gotToCart);
		String cartPrice = gittiGidiyorCart.cartPrice.getText();
		Assert.assertEquals("Product price and cart price not equal!!",productPrice, cartPrice);
		
		
	}

	@Then("quality of the prodcut one increased")
	public void quality_of_the_prodcut_one_increased() {
		selectDropdown(gittiGidiyorCart.selectQuantity, 1);
	}

	@Then("validate quality of product one increased and equals to two")
	public void validate_quality_of_product_one_increased_and_equals_to_two() {
		String actualQuantity = gittiGidiyorCart.selectQuantity.getAttribute("value");
		String expectedQuantity= "2";
		Assert.assertEquals("Product quantity did not increase to 2!!!!",expectedQuantity, actualQuantity);
	}

	@Then("the product is deleted at cart")
	public void the_product_is_deleted_at_cart() {
		wait(1);
		jsClick(gittiGidiyorCart.deleteImage);
	}

	@Then("validate cart is empty")
	public void validate_cart_is_empty() {
		waitForVisibilty(gittiGidiyorCartEmpty.cartEmptyMessage);
		String actualText = gittiGidiyorCartEmpty.cartEmptyMessage.getText().toString();
		String expectedText="Sepetinizde ürün bulunmamaktadýr.";
		Assert.assertEquals("Cart is not empty!!! does not matches", expectedText, actualText);
	}

}
