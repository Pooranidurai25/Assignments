package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException

	{
		// Chrome setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");

		// enter username and password

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		// click crm/sfa button
		driver.findElement(By.linkText("CRM/SFA")).click();

		// leads tab
		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.linkText("Create Lead")).click();

		// enter the details
		String cName = "Poorani";

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);

		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Anbudurai");

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Ananya");

		WebElement sourceId = driver.findElement(By.name("dataSourceId"));

		Select dpdn = new Select(sourceId);
		dpdn.selectByVisibleText("Employee");

		WebElement mCampaingn = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select dpdn2 = new Select(mCampaingn);
		dpdn2.selectByIndex(3);

		WebElement indStry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select dpdn3 = new Select(indStry);
		dpdn3.selectByValue("IND_HEALTH_CARE");

		WebElement cCode = driver.findElement(By.xpath("(//input[@name='primaryPhoneCountryCode'])[4]"));
		cCode.clear();
		Thread.sleep(2000);
		cCode.sendKeys("7");

		driver.findElement(By.xpath("//span[text()='To Name']/following::input")).sendKeys("Gomathi");

		driver.findElement(By.name("submitButton")).click();

		// verify the company name

		String verify = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		System.out.println(verify);

		if (cName.equals(verify)) 
		{
			System.out.println("Verified");
		}
		else 
		{ System.out.println(" Different");}
		
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		

	}

}
