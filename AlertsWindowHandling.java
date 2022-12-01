package assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsWindowHandling {

	public static void main(String[] args) throws IOException 
	{
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get(" https://www.irctc.co.in/ ");

driver.findElement(By.linkText("FLIGHTS")).click();

Set<String> flight = driver.getWindowHandles();
List<String> window1 = new ArrayList<String>(flight);
driver.switchTo().window(window1.get(1));

// get the mail id

driver.findElement(By.id("dropdown10")).click();
String email = driver.findElement(By.linkText("flights@irctc.co.in")).getText();
System.out.println(email);

// screenshot
File ss = driver.getScreenshotAs(OutputType.FILE);
File dst = new File("./snaps/filght.png");
FileUtils.copyFile(ss, dst);

driver.switchTo().window(window1.get(0));
driver.close();


	}

}
