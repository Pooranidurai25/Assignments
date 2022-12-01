package assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameExercise {

	public static void main(String[] args) 
	{
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();

driver.get("https://leafground.com/frame.xhtml");

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// find the frame element
WebElement first = driver.findElement(By.xpath("(//div[@class='card']/iframe)[1]"));

driver.switchTo().frame(first);
driver.findElement(By.id("Click")).click();

WebElement content = driver.findElement(By.id("Click"));
System.out.println(content.getText());


// out of the frame
driver.switchTo().defaultContent();

// Nested Frames

WebElement third = driver.findElement(By.xpath("(//div[@class='card']/iframe)[3]"));
driver.switchTo().frame(third);
// inside the parent frame
driver.switchTo().frame("frame2");

driver.findElement(By.id("Click")).click();



driver.switchTo().defaultContent();

// next frame
WebElement second = driver.findElement(By.xpath("(//div[@class='card']/iframe)[2]"));
driver.switchTo().frame(second);

driver.findElement(By.id("Click")).click();

driver.switchTo().defaultContent();

driver.close();



	}

}
