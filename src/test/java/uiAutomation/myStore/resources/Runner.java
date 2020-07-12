package uiAutomation.myStore.resources;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import uiAutomation.myStore.utility.Util;

@CucumberOptions(
features = "src/test/java/uiAutomation/myStore/features",
glue = "uiAutomation/myStore/steps", 
monochrome = true, 
plugin = {"pretty", "html:target/cucumber-reports" },
strict = false, 
dryRun = false,
tags = {"@loginsuccess"}
)

public class Runner extends AbstractTestNGCucumberTests {

	Util util;

	@BeforeSuite
	public void setUp() {
		util = new Util();
		util.LaunchBrowser();
		util.openUrl();
		util.maximizeWindow();
		util.deleteCookies();
		util.implicitWait(4000);

	}

	@AfterSuite
	public void tearDown() {
		util.quit();
	}
	

		
	

}
