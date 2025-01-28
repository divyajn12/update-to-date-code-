package jenkinscode;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class settingcustomfiled {

	@Test
	public class settingmarketing {

		public void settingcustomfield() throws InterruptedException, IOException {
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

			Thread.sleep(1000);

			// click on Setting

			driver.findElement(By.xpath("//span[normalize-space()='Settings']")).click();
			//click on customer field
			driver.findElement(By.xpath("//div[normalize-space()='Create custom Fields']")).click();
			// click on + icon
			driver.findElement(By.xpath("//button[@class='add-btn-css ant-btn ant-btn-default ant-btn-round']")).click();
			//click on label
			driver.findElement(By.xpath("//input[@formcontrolname='label']")).sendKeys("test");
			//enter value on description
		driver.findElement(By.xpath("//textarea[@formcontrolname='description']")).sendKeys("test demo");
		Thread.sleep(1000);	
		
		//click on field type
		driver.findElement(By.xpath("//input[@class='ant-select-search__field ng-tns-c84-24 ng-valid ng-star-inserted ng-dirty ng-touched']")).click();
		Thread.sleep(1000);	
		driver.close();	
			
			
		}}}