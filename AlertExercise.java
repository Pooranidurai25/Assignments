package assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertExercise {

	public static void main(String[] args) throws InterruptedException

	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://leafground.com/alert.xhtml");

		driver.manage().window().maximize();

		// Simple Alert

		driver.findElement(By.id("j_idt88:j_idt91")).click();
		Thread.sleep(2000);
		// Switch to alert---alert can be initialized once and used multiple times since
		// it has no arguments
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// Confirmation alert

		driver.findElement(By.name("j_idt88:j_idt93")).click();

		Thread.sleep(2000);

		// get the text from the pop up

		System.out.println("Text derived from alert  " + alert.getText());

		alert.dismiss();

		// check if ok or dismiss is clicked

		WebElement check = driver.findElement(By.xpath("//span[@id='result']"));
		String text = check.getText();

		if (text.equalsIgnoreCase("User Clicked : OK")) {
			System.out.println(text);

		} else {
			System.out.println(text);
		}

		// prompt box
		driver.findElement(By.id("j_idt88:j_idt104")).click();
		
		alert.sendKeys(" prompt box filled");
		Thread.sleep(1000);
		alert.accept();
		
		// Sweet alert confirmation
		
		driver.findElement(By.xpath("(//div[@class='card'])[6]/button")).click();
		
		
		driver.findElement(By.id("j_idt88:j_idt108")).click();
		

		driver.close();

	}

}
