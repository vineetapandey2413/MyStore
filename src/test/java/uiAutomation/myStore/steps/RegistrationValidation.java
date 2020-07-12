package uiAutomation.myStore.steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiAutomation.myStore.pageObjects.HomePage;
import uiAutomation.myStore.pageObjects.MyAccount;
import uiAutomation.myStore.pageObjects.Registration;
import uiAutomation.myStore.utility.Util;

public class RegistrationValidation extends Util{
	
	HomePage home;
	Registration reg;
	MyAccount acc;
	
	@Given("User is in Authentication screen")
	public void user_is_in_Authentication_screen() {
		openUrl();
		home = new HomePage();
		home.SingIn.click();
	    
	}

	@When("In Authentication section, user enters email address {string}")
	public void in_Authentication_section_user_enters_email_address(String email) {
	    reg = new Registration();
	    reg.email.sendKeys(email);
	}

	@When("User clicks on Create An Account button")
	public void user_clicks_on_Create_An_Account_button() {
	    reg.createAcc.click();
	}

	@Then("User redirects to Create An Account page")
	public void user_redirects_to_Create_An_Account_page() {
	    
	}

	@Then("User enters personal information {string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_enters_personal_information(String title, String firstname, String lastname, String email, String password, String day, String month, String year) {
	    reg.setPersonalInfo(title, firstname, lastname, email, password, day, month, year);
	}

	@Then("User enters address details {string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_enters_address_details(String fn, String ln, String compny, String add1, String add2, String cty, String state, String zipcode, String country) {
	   reg.setAddressDetails(fn, ln, compny, add1, add2, cty, state, zipcode, country);
		
	   
	}

	@Then("User enters additional info {string}")
	public void user_enters_additional_info(String info) {
	  reg.additonalInfo.sendKeys(info);
	}

	@Then("User enters home phone {string}")
	public void user_enters_home_phone(String homephone) {
	    reg.homePhone.sendKeys(homephone);
	}

	@Then("User enters mobile phone {string}")
	public void user_enters_mobile_phone(String mobile) {
	    reg.mobilePhone.sendKeys(mobile);
	}

	@Then("User enters address alias {string}")
	public void user_enters_address_alias(String alias) {
	    reg.addAlias.sendKeys(alias);
	}

	@Then("User clicks on register button")
	public void user_clicks_on_register_button() {
	   acc = reg.register();
	}

	@Then("User should be registered successfully")
	public void user_should_be_registered_successfully() {
	    Assert.assertEquals(acc.getTitle(), acc.myAccountTitle);
	}

}
