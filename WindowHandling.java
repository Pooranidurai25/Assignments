package assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// launch the url
		driver.get("http://leaftaps.com/opentaps/control/login");
		// enter username and password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// login button
		driver.findElement(By.className("decorativeSubmit")).click();

		// click crmsfa

		driver.findElement(By.linkText("CRM/SFA")).click();

		// contacts button
		driver.findElement(By.linkText("Contacts")).click();

		// merge button

		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		// widget button
		driver.findElement(By.xpath("//img[@alt='Lookup'][1]")).click();

		// window handle
		Set<String> mergeContact = driver.getWindowHandles();
		System.out.println(mergeContact.size());

		// to get window handles
		for (String handles : mergeContact) {
			System.out.println(handles);
		}
		// convert set to list

		List<String> winlist = new ArrayList<String>(mergeContact);
		// get the window handles
		driver.switchTo().window(winlist.get(1));
// Click on First Resulting Contact

		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();

		// switch to main window
		driver.switchTo().window(winlist.get(0));

		// Click on Widget of To Contact

		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winlist2 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winlist2.get(1));

		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[4]/a")).click();
		driver.switchTo().window(winlist2.get(0));
		// merge button
		driver.findElement(By.className("buttonDangerous")).click();

		// accept the alert
		Alert alert = driver.switchTo().alert();

		alert.accept();

		Thread.sleep(2000);

		// Verify the page title

		String title = driver.findElement(By.id("sectionHeaderTitle_contacts")).getText();
		String text = "View Contact";

		 if (title.equalsIgnoreCase(text) ){
		 System.out.println("Title verified");
		} else {
		System.out.println("Not verified");
		 }

		driver.close();

	}

}
