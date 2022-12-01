package assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoOfFrames {

	public static void main(String[] args)
	{
		
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

driver.get("https://leafground.com/");

driver.findElement(By.xpath("//i[@class='pi pi-globe layout-menuitem-icon']")).click();
driver.findElement(By.xpath("//i[@class='pi pi-fw pi-stop layout-menuitem-icon']")).click();

//find the frame element

List<WebElement> count = driver.findElements(By.tagName("iframe"));

System.out.println("No of Frames: " + count.size());

driver.close();
	
	}

}
