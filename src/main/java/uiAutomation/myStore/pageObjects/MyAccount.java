package uiAutomation.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uiAutomation.myStore.utility.Util;

public class MyAccount extends Util {
	public String  myAccountTitle = "My account - My Store";
	
	public MyAccount() {
		PageFactory.initElements(driver, this);
	}
	
	public @FindBy(css ="div.center_column>div>div:nth-child(1)>ul>li:nth-child(1)")
	WebElement orderHistory;
	
	public @FindBy(css ="div.center_column>div>div:nth-child(1)>ul>li:nth-child(2)")
	WebElement myCreditSlips;
	
	public @FindBy(css ="div.center_column>div>div:nth-child(1)>ul>li:nth-child(3)")
	WebElement myAddress;
	
	public @FindBy(css ="div.center_column>div>div:nth-child(1)>ul>li:nth-child(4)")
	WebElement mypersnlInfo;
	
	public @FindBy(css ="div.center_column>div>div:nth-child(2)>ul>li:nth-child(1)")
	WebElement myWishList;
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public OrderHistoryPage clickOnOrderHistory() {
		orderHistory.click();
		
		return new OrderHistoryPage();
	}
	
	public MyCreditSlipPage clickOnMyCreditSlips() {
		myCreditSlips.click();
		
		return new MyCreditSlipPage();
	}
	
	public MyAddressPage clickOnmyAddress() {
		myAddress.click();
		
		return new MyAddressPage();
	}
	
	public MyPersonalInfoPage clickOnmypersnlInfo() {
		mypersnlInfo.click();
		
		return new MyPersonalInfoPage();
	}
	
	public MyWishList clickOnmyWishList() {
		myWishList.click();
		
		return new MyWishList();
	}

}
