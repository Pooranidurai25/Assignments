package assignments;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesIrctc {

	public static void main(String[] args) throws IOException
	{
WebDriverManager.chromedriver().setup();
// Disable Notifications
ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-notifications");
ChromeDriver driver = new ChromeDriver(options);

// Launch the url
driver.get("https://www.irctc.co.in/nget/train-search");

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.manage().window().maximize();

// capture screenshot

File screenshotAs = driver.getScreenshotAs(OutputType.FILE);

File save = new File("./snaps/irctc.png");

FileUtils.copyFile(screenshotAs, save);

driver.close();

		
	}

}
