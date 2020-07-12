package uiAutomation.myStore.pageObjects;

import uiAutomation.myStore.utility.Util;

public class MyAddressPage extends Util {
	
	public String  myAddressTitle = "Addresses - My Store";
	
	
	public String getTitle() {
		return driver.getTitle();
	}

}
