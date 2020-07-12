package uiAutomation.myStore.pageObjects;

import uiAutomation.myStore.utility.Util;

public class MyWishList extends Util{
	
public String  myWishListPageTitle = "My Store";
	
	
	public String getTitle() {
		return driver.getTitle();
	}


}
