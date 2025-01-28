package jenkinscode;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
@Test
public class Editandpublishreward {
	public void createloyaltyreward() throws InterruptedException, IOException {
		// if invite already sent we not change the current premission customer
		WebDriver driver = new ChromeDriver();

		// Maximize window
		driver.manage().window().maximize();
		// open swan application
		driver.get("https://app.swan.cx/login");
		// implicit time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Enter email address.
		driver.findElement(By.id("email")).sendKeys("divya.jain@loyalytics.in");
		// Enter password
		driver.findElement(By.id("pass")).sendKeys("Divya@1234567");
		// click on Login Button .
		driver.findElement(By.xpath("//button[@id='btn']")).click();
		
		// click on Loyalty Rewards
		driver.findElement(By.xpath("//span[normalize-space()='Loyalty Rewards']")).click();
		//active and deactive using toggel button
		//driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		//click on 3 dots
		driver.findElement(By.xpath("(//span[@class='ng-star-inserted'])[49]")).click();
		//click on edit
		driver.findElement(By.xpath("//div[@class='cdk-overlay-container']//li[1]")).click();
		Thread.sleep(1000);
		//publish Loyalty Rewards
		driver.findElement(By.xpath("//button[@class='publish-voucher voucher-popover ant-btn ng-star-inserted ant-btn-primary']")).click();
		driver.findElement(By.xpath("//button[@class='publish-voucher ant-btn ant-btn-default']")).click();

		//click on view icon
		driver.findElement(By.xpath("(//span[@class='ng-star-inserted'])[49]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='View']")).click();
		Thread.sleep(1000);
		//click on save
		driver.findElement(By.xpath("//button[@class='create-voucher ant-btn ng-star-inserted ant-btn-primary']")).click();
		driver.close();
}}
