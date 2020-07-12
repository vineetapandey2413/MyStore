package uiAutomation.myStore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uiAutomation.myStore.utility.Util;

public class HomePage extends Util{
	//WebDriver driver = null;
	
	public HomePage(){
        //this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	
	public @FindBy(xpath ="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement SingIn;
}
