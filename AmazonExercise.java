package assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonExercise

{
	public static void main(String[] args) throws IOException, InterruptedException

	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.amazon.in/");
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("oneplus 9 pro");search.sendKeys(Keys.ENTER);
		
		
		// price of first product

		String price = driver.findElement(By.xpath("(//span[@aria-hidden='true'])[6]")).getText();
		System.out.println("Price of first Product " + price);
		
		// print the no of customer ratings
		
		String ratings = driver.findElement(By.xpath("(//a[@target='_blank'])[4]/span")).getText();
		System.out.println("Customer ratings "+ ratings);
		
		// mouse hover the ratings
		Actions build = new Actions(driver);
		WebElement percent = driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-3 aok-align-bottom'])[1]"));
		
		Thread.sleep(2000);
		build.moveToElement(percent).perform();
		
		
		String text = driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-3 aok-align-bottom'])/span")).getText();
		
		System.out.println("Customer ratings in percentage "+ text );
		
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		
		// since it moves to next window , do window handlng
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> next = new ArrayList<String>(windowHandles);
		driver.switchTo().window(next.get(1));
		
		// screenshot
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		
		File dst = new File("./snaps/phone.png");
		FileUtils.copyFile(screenshotAs, dst);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> popup = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(popup.get(1));
		
		// cart subtotal
		String a = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-price a-text-bold']/span")).getText();
		
		System.out.println("Cart subtotal "+ a);
		
		driver.quit();
		
		
		// 

	}

}
