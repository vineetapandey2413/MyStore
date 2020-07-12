package uiAutomation.myStore.pageObjects;

import uiAutomation.myStore.utility.Util;

public class MyCreditSlipPage extends Util{
	
public String  myCreditSlipPageTitle = "Order slip - My Store";
	
	
	public String getTitle() {
		return driver.getTitle();
	}


}
