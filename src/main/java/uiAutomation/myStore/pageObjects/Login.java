package uiAutomation.myStore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uiAutomation.myStore.utility.Util;

public class Login extends Util {
	//WebDriver driver = null;
	
	public Login(){
        //this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public @FindBy(xpath ="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement SingInLink;

	
	public @FindBy(css = "input#email")
	@CacheLookup
	WebElement email;
	
	public @FindBy(css = "input#passwd")
	WebElement password;
	
	public @FindBy(css = "button#SubmitLogin")
	WebElement signInBtn;
	
	public @FindBy(xpath = "//*[@id=\"header_logo\"]/a/img")
	WebElement logo;
	
	public HomePage Login(String un,String pwd) {
		email.sendKeys(un);
		password.sendKeys(pwd);
		signInBtn.click();
		
		return new HomePage();
	}
	
	public boolean validateLogoIsDisplayed() {
		return logo.isDisplayed();		
	}

}
