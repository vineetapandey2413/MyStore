package uiAutomation.myStore.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import uiAutomation.myStore.utility.Util;

public class Registration extends Util {

	Logger log = Logger.getLogger(Registration.class);
	 

	public Registration() {
		PageFactory.initElements(driver, this);
	}

	public @FindBy(css = "input#email_create")
	WebElement email;

	public @FindBy(css = "button#SubmitCreate	")
	WebElement createAcc;

	public @FindBy(css = "input#id_gender1")
	WebElement titleMr;

	public @FindBy(css = "input#id_gender2")
	WebElement titleMrs;

	public @FindBy(css = "input#customer_firstname")
	WebElement firstName;

	public @FindBy(css = "input#customer_lastname")
	WebElement lastName;

	public @FindBy(css = "input#email")
	WebElement accEmail;

	public @FindBy(css = "input#passwd")
	WebElement accPass;

	public @FindBy(css = "select#days")
	WebElement dobDay;

	public @FindBy(css = "select#months")
	WebElement dobMonth;

	public @FindBy(css = "select#years")
	WebElement dobYear;

	public @FindBy(css = "input#newsletter")
	WebElement newsLtrChkBox;

	public @FindBy(css = "input#optin")
	WebElement spclOffers;

	public @FindBy(css = "input#firstname")
	WebElement yourAddFirstName;

	public @FindBy(css = "input#lastname")
	WebElement yourAddLastName;

	public @FindBy(css = "input#company")
	WebElement company;

	public @FindBy(css = "input#address1")
	WebElement address1;

	public @FindBy(css = "input#address2")
	WebElement address2;

	public @FindBy(css = "input#city")
	WebElement city;

	public @FindBy(css = "select#id_state")
	WebElement state;

	public @FindBy(css = "input#postcode")
	WebElement zipCode;

	public @FindBy(css = "select#id_country")
	WebElement country;

	public @FindBy(css = "textarea#other")
	WebElement additonalInfo;

	public @FindBy(css = "input#phone")
	WebElement homePhone;

	public @FindBy(css = "input#phone_mobile")
	WebElement mobilePhone;

	public @FindBy(css = "input#alias")
	WebElement addAlias;

	public @FindBy(css = "button#submitAccount")
	WebElement registerBtn;
	
	public void setTitle(String title) {
		if(title.equals("Mr")) {
			titleMr.click();
		}
		else if(title.equals("Mrs")) {
			titleMrs.click();
		}
		else {
			titleMrs.click();
		}
		
	}

	public void setDateOfBirth(String dd, String mm, String yy) {
		Select day = new Select(dobDay);
		Select month = new Select(dobMonth);
		Select year = new Select(dobYear);
		try {
			day.selectByValue(dd);
			month.selectByValue(mm);
			year.selectByValue(yy);

		} catch (Exception e) {
			log.fatal(e.getMessage());
			day.selectByValue("15");
			month.selectByValue("4");
			year.selectByValue("1990");
		}
	}

	public void setState(String st) {
		
		Select sta = new Select(state);
		try {
			sta.selectByValue(st);;
		}
		catch(Exception e) {
			log.fatal(e.getMessage());
		}
		
	}

	public void setCountry(String cntry) {
		Select cou = new Select(country);
		try {
		cou.selectByVisibleText(cntry);
		}
		catch(Exception e) {
			log.fatal(e.getMessage());
		}
	}
	
	public void setPersonalInfo(String title, String firstname, String lastname, String email, String password, String day, String month, String year) {
		setTitle(title);
	    firstName.sendKeys(firstname);
	    lastName.sendKeys(lastname);
	    accEmail.clear();
	    accEmail.sendKeys(email);
	    accPass.sendKeys(password);
	    setDateOfBirth(day, month, year);
	}
	
	public void setAddressDetails(String fn, String ln, String compny, String add1, String add2, String cty, String state, String zipcode, String country) {
		yourAddFirstName.sendKeys(fn);
		   yourAddLastName.sendKeys(ln);
		   company.sendKeys(compny);
		   address1.sendKeys(add1);
		   address2.sendKeys(add2);
		   city.sendKeys(cty);
		   setState(state);
		   zipCode.sendKeys(zipcode);
		   setCountry(country);
	}
	
	public MyAccount register() {
		registerBtn.click();
		
		return new MyAccount();
	}

}
