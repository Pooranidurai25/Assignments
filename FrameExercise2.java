package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameExercise2 {

	public static void main(String[] args) 
	{
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();

driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Nested frame with Check box

WebElement topic = driver.findElement(By.xpath("//div[@class='card mb-3']/iframe[1]"));

driver.switchTo().frame(topic);

driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Frames");


// switching to nested frame

  driver.switchTo().frame(0);
  
  //clicking the checkbox

 driver.findElement(By.xpath("//input[@id='a']")).click();
 
 

driver.switchTo().defaultContent();

WebElement dpdn = driver.findElement(By.xpath("//div[@class='card mb-3']/iframe[2]"));
driver.switchTo().frame(dpdn);

// dropdown
WebElement select = driver.findElement(By.id("animals"));

Select animals = new Select(select);
animals.selectByVisibleText("Avatar");

driver.switchTo().defaultContent();

driver.close();




	}

}
