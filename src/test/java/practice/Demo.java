package practice;

import org.openqa.selenium.By;

import utils.CommonMethods;

public class Demo extends CommonMethods {

	public static void main(String[] args) {
		setUp();
		sendText(login.user, "Admin");
		sendText(login.password, "admin123");
		click(login.loginButton);
		System.out.println(driver.findElement(By.xpath("//ul[@id='mainMenuFirstLevelUnorderedList']")).getText());

	}

}
