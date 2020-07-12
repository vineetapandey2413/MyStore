package uiAutomation.myStore.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.apache.log4j.Logger;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import uiAutomation.myStore.pageObjects.HomePage;
import uiAutomation.myStore.pageObjects.Login;
import uiAutomation.myStore.utility.CustomListener;
import uiAutomation.myStore.utility.Util;
import io.cucumber.java.en.Then;

public class LoginValidation  extends Util{

	//Util util = new Util();
	//WebDriver driver = util.getDriver();
	Login login = new Login();
	HomePage home ;
	Logger log = Logger.getLogger(LoginValidation.class);
	
	public LoginValidation() {
		super();
	}

	@Given("User is in home page")
	public void user_is_in_home_page() {
		log.info("executing : " + this.getClass().getName());

		String title = "My Store";
		Assert.assertEquals(driver.getTitle(), title);

	}

	@When("User clicks on Sign in link")
	public void user_clicks_on_link() {
		login.SingInLink.click();
	}

	@When("User enters the {string} and {string}")
	public void user_enters_the_and(String email, String password) {
		home = login.Login(email, password);
	}

	@When("User clicks on Sign in button")
	public void user_clicks_on_Sign_in_button() {
		boolean logo = login.validateLogoIsDisplayed();
		Assert.assertTrue(logo);
		

	}

	@Then("User should gets logged in successfully")
	public void user_should_gets_logged_in_successfully() {
		String title = "My account - My Store";

		Assert.assertEquals(driver.getTitle(), title);

	}
	


	@After
	public void failure(Scenario scenario) {
		if (scenario.isFailed()) {
			getScreenshot(scenario);
		}

	}

}
