package uiAutomation.myStore.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class Util {
	public static Properties prop = null;
	public static WebDriver driver = null;
	Logger log = Logger.getLogger(Util.class);
	
	public WebDriver getDriver() {
		return driver;
	}

	public Util() {
		log.info("calling constructor for loading config properties");
		prop = new Properties();
		String configPath = "/home/vinita/Documents/Practise/myStore/src/main/java/uiAutomation"
				+ "/myStore/config/config.properties";
		try {
			FileInputStream fis = new FileInputStream(configPath);
			prop.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void setDriverPath() {
		log.info("Setting the driver path ----");
		String path = System.getProperty("user.dir") + "/src/test/java/uiAutomation/myStore/drivers";

		if (System.getProperty("os.name").startsWith("Linux")) {
			System.setProperty("webdriver.gecko.driver", path + "/linux/geckodriver");
			System.setProperty("webdriver.chrome.driver", path + "/linux/chromedriver");
		} else if (System.getProperty("os.name").startsWith("Mac")) {
			System.setProperty("webdriver.gecko.driver", path + "/mac/geckodriver");
			System.setProperty("webdriver.chrome.driver", path + "/mac/chromedriver");
		} else if (System.getProperty("os.name").startsWith("Windows")) {
			System.setProperty("webdriver.gecko.driver", path + "/windows/geckodriver");
			System.setProperty("webdriver.chrome.driver", path + "/windows/chromedriver");
		}
		
	}

	public void LaunchBrowser() {
		log.info("Launching the browser ----");
		//loadConfigProperties();
		setDriverPath();
		String browser = prop.getProperty("browser");

		if (browser!=null && browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}
		

	}

	public void openUrl() {
		//loadConfigProperties();
		String url = prop.getProperty("url");
		log.info("Entering  the Url: " +url);
		driver.get(url);
		
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void explicitWait(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	@SuppressWarnings("deprecation")
	public void getScreenshot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String desc ="/home/vinita/Documents/Practise/myStore/src/test/java/uiAutomation/myStore/screenshots/Failure_Screenshot_"+scenario.getName()+".jpg";
		try {
			FileUtils.copyFile(file, new File(desc));
			scenario.embed(screenshot, "image/png");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		log.info("took the screenshot for failed scenarios: " +scenario.getName());
	}
	
	public void quit() {
		driver.quit();
	}

}
