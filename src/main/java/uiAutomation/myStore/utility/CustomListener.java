package uiAutomation.myStore.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends Util implements ITestListener{
	
	public void onTestStart(ITestResult result) {
	    
	  }

	  @Override
	  public void onTestSuccess(ITestResult result) {
	    
	  }

	  
	  @Override
	  public void onTestFailure(ITestResult result) {
	    //getScreenshot();
	  }

	  
	  @Override
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	  
	  @Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  
	  @Override
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  
	  @Override
	  public void onStart(ITestContext context) {
	    // not implemented
	  }

	 
	  @Override
	  public void onFinish(ITestContext context) {
	    // not implemented
	  }
	

}
