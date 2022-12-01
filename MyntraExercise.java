package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MyntraExercise {

	public static void main(String[] args)
	
	
	{
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

driver.get("https://www.myntra.com/");
//Mouse hover on Men using Action class

Actions build = new Actions(driver);
WebElement men = driver.findElement(By.linkText("Men"));
build.moveToElement(men).perform();

driver.findElement(By.xpath("(//a[@class='desktop-categoryLink'])[1]")).click();
String count = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
System.out.println("Total items count "+ count);




	}

}
