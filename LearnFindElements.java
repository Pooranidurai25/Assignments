package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFindElements {

	public static void main(String[] args) throws InterruptedException 
	
	{
// launch AJIO page , where all the bag list and price list needs to be stored as list using findelements keyword
		
		// Launch the web browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Enter AJIO in search
		driver.get("https://www.ajio.com/");
		
		driver.manage().window().maximize();
		
		
		// Locate the search bar and enter the input
		WebElement bags = driver.findElement(By.name("searchVal"));	
		bags.sendKeys("bags");
		bags.sendKeys(Keys.ENTER);
		
		// Get all the bag names and store in list
		
		Thread.sleep(4000);
		List<WebElement> bagNames = driver.findElements(By.className("nameCls"));
		for (WebElement bags1 : bagNames) 
		{
			String text = bags1.getText();
			System.out.println(text);
		}
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='price  ']"));
		for (WebElement prices : price) 
		{
			String text1 = prices.getText();
			System.out.println(text1);
		}
		
		driver.close();
		
		}

}
