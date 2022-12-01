package assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("chkSelectDateOnly")).click();

		 WebElement from = driver.findElement(By.id("txtStationFrom"));
		 from.clear();
		 from.sendKeys("Tambaram",Keys.ENTER);
			
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("Rajapalaiyam",  Keys.ARROW_DOWN,Keys.ENTER);
		Thread.sleep(2000);
		
		
		List<WebElement> trainnum = driver.findElements(By.xpath("//table[contains(@class,'DataTable TrainList')]//td[1]"));
		int size = trainnum.size();
		
		System.out.println("Size of the list "+ size);
		
		for (int i = 0; i < size; i++)
		{
			String text = trainnum.get(i).getText();
			System.out.println("Display train num "+ text);
		}
		
		ArrayList<String> tnum = new ArrayList<String>();
		for (WebElement WE : trainnum)
		{
			tnum.add(WE.getText());
		}
		Collections.sort(tnum);
		System.out.println(tnum);
		List<WebElement> trainname = driver.findElements(By.xpath("//table[contains(@class,'DataTable TrainList')]//td[2]"));
		
		for (int i = 0; i < size; i++)
		{
			String text2 = trainname.get(i).getText();
			System.out.println("Display train names "+ text2);
		}
		
		ArrayList<String> sorting= new ArrayList<String>();
		for (WebElement str : trainname) 
		{
			sorting.add(str.getText());
		}
		
		Collections.sort(sorting);
		System.out.println(sorting);
		
		driver.close();
		
	}

}
