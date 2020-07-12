package uiAutomation.myStore.pageObjects;

import uiAutomation.myStore.utility.Util;

public class MyPersonalInfoPage extends Util{
	
public String  myPersonalInfoPageTitle = "Identity - My Store";
	
	
	public String getTitle() {
		return driver.getTitle();
	}


}
