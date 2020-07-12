
  package uiAutomation.myStore.steps;
  
  import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import
  org.testng.annotations.Test;
  
  public class Miscellaneous {
  
  @Test public void test() { WebDriver driver = new FirefoxDriver();
  driver.get("https://www.google.com"); Alert alert =
  driver.switchTo().alert(); System.out.println(alert.getText());
  
  //select the frame driver.switchTo().frame(1);
  
  Set<String> list = driver.getWindowHandles();
  
  Iterator<String> itr = list.iterator();
  
  String parentWindow = itr.next();
  driver.switchTo().window(parentWindow);
  
  String childWindoe = itr.next();
  driver.switchTo().window(childWindoe);
  
  driver.switchTo().defaultContent();
  
  //-------Wait coditions--------------
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  
  WebDriverWait wait = new WebDriverWait(driver,5);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
  
  //-----------MouseHover -------------
  WebElement source = driver.findElement(By.xpath(""));
  WebElement target = driver.findElement(By.xpath(""));
  
  Actions action = new Actions(driver);
  action.clickAndHold(source).moveToElement(target).build().perform(); //dragging
  action.dragAndDrop(source, target); //dragging
  action.moveToElement(target); //mouse hovering
  
  
  //----selecting data in the dropdown----
  Select data = new Select(source);
  String str = "";
  data.selectByIndex(0);
  data.selectByValue( str);
  data.selectByVisibleText(str);
  
  List<WebElement> lists = data.getOptions();
  
  //------Take Screenshot------------
  File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  try {
	FileUtils.copyFile(file, new File("destFile"));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
  
  // How to get the coordinates of a window ----------
  int xcord = driver.manage().window().getPosition().getX();
  int ycord = driver.manage().window().getPosition().getY();
  
  
  //How to get forward and backward in selenium
  
  driver.navigate().forward();
  driver.navigate().back();
  
  
  // How to count similar object present in the ui
  
  List <WebElement> elements = driver.findElements(By.id(""));
  System.out.println(elements.size());
  
  //-----------xpath---------
  driver.findElement(By.xpath("@id[@name='test']/following-siblings::td[2]"));
  driver.findElement(By.xpath("@id[@name='test']/preeciding-siblings::td[2]"));
  driver.findElement(By.xpath("@id[@name='test']/child::td[2]"));
  
  //to get 5th same element
  
  driver.findElements(By.xpath("")).get(5);
  
  //chchbox---
  driver.findElement(By.xpath("")).click();
  driver.findElement(By.xpath("")).isDisplayed();
  driver.findElement(By.xpath("")).isEnabled();
  
  // executing javascript in selenium --------------
  JavascriptExecutor js = ((JavascriptExecutor)driver);
  js.executeScript("arguments[0].click()", target);
  js.executeScript("window.scrollBy(0,500");
  
  driver.findElement(By.xpath("")).sendKeys(Keys.F5);
  
  }
  
  
  }
 