package assignments;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotWebElement {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://leafground.com/");
		driver.findElement(By.xpath("//i[@class='pi pi-server layout-menuitem-icon']")).click();
		driver.findElement(By.xpath("//i[@class='pi pi-fw pi-mobile layout-menuitem-icon']")).click();
		
		// Capture the screenshot of a web element i.e a particular element in the webpage
		WebElement capture = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]"));
		
		// instead of driver. use the element.screenshotAs
		File screenshotAs = capture.getScreenshotAs(OutputType.FILE);
		
		File dst = new File("./capture/webelement.png");
		FileUtils.copyFile(screenshotAs, dst);
		
		driver.quit();
		
		
	}

}
