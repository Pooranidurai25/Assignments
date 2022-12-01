package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertFrames {

	public static void main(String[] args) 
	{
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();

driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// finding the element in the frame
WebElement tryit = driver.findElement(By.xpath("//div[@id='iframewrapper']/iframe"));
// switching to frame
driver.switchTo().frame(tryit);
// find the element inside the frame
driver.findElement(By.xpath("//button[text()='Try it']")).click();

// click on try it , handle using alert

Alert alert = driver.switchTo().alert();
alert.accept();

// Since the content is within the frame , so it continues as it is.
WebElement text = driver.findElement(By.id("demo"));

String text2 = text.getText();
System.out.println(text2);


	}

}
