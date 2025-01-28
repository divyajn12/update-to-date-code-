package jenkinscode;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class settingstore {
	
	
	@Test
	public class settingmarketing {

		public void cutomersettinginvite() throws InterruptedException, IOException {
			// if invite already sent we not change the current premission customer
			WebDriver driver = new ChromeDriver();

			// Maximize window

			driver.manage().window().maximize();

			// implicit time

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// open swan application

			driver.get("https://app.swan.cx/login");

			// Thread.sleep(2000);

			// Enter email address.

			driver.findElement(By.id("email")).sendKeys("divya.jain@loyalytics.in");

			// Thread.sleep(1000);

			// Enter password

			driver.findElement(By.id("pass")).sendKeys("Divya@1234567");

			// Thread.sleep(2000);

			// click on Login Button .

			driver.findElement(By.xpath("//button[@id='btn']")).click();

			// click on Setting

			driver.findElement(By.xpath("//span[normalize-space()='Settings']")).click();
			
		//click on store
			driver.findElement(By.xpath("//div[normalize-space()='Manage stores here']")).click();
			
			//click on + icon
			driver.findElement(By.xpath("//button[@class='add-btn-css ant-btn ant-btn-default ant-btn-round']")).click();
			Thread.sleep(1000);
			//Create Store click on storeId
			driver.findElement(By.xpath("//input[contains(@class, 'ant-input') and contains(@class, 'ng-invalid')]")).sendKeys("12345");
			
			Thread.sleep(1000);
			// click on storeName
		driver.findElement(By.xpath("//input[contains(@class, 'ant-input') and contains(@class, 'ng-invalid')]")).sendKeys("Divyatst");
		Thread.sleep(1000);
		//click on create store button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.quit();
		
		}}
}
