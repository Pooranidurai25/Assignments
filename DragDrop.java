package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDrop {

	public static void main(String[] args) 
	{
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("https://leafground.com/drag.xhtml");	
		Actions builder = new Actions(driver);
		WebElement drag = driver.findElement(By.id("form:conpnl_header"));
		builder.dragAndDropBy(drag, 150, 200).perform();
		
		WebElement source = driver.findElement(By.id("form:drag_content"));
		WebElement target = driver.findElement(By.id("form:drop_header"));
		
		builder.dragAndDrop(source, target).perform();
		
		driver.close();
		

	}

}
