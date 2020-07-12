package uiAutomation.myStore.pageObjects;

import uiAutomation.myStore.utility.Util;

public class OrderHistoryPage extends Util{
	
public String  orderHistoryPageTitle = "Order history - My Store";
	
	
	public String getTitle() {
		return driver.getTitle();
	}

}
