package jenkinscode;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
@Test
public class settinginvite{

	
		 public void cutomersettinginvite() throws InterruptedException, IOException {

			WebDriver driver = new ChromeDriver();
// premission setting by +icon for new invite new id
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

		Thread.sleep(5000);

		// click on Setting

		driver.findElement(By.xpath("//span[normalize-space()='Settings']")).click();

		// Thread.sleep(2000);

		// click on invite member

		driver.findElement(By.xpath("//div[text()='Invite Members']")).click();

		// Click on "+" Button

		driver.findElement(By.xpath("(//button[@class='add-btn-css ant-btn ant-btn-default ant-btn-round'])[1]"))
				.click();

		// Thread.sleep(2000);

		// Enter first name

		driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("Divya");

		// Enter last name

		driver.findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys("jain");

		// Enter Email address

		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("anil.thakur@loyalytics.in");

		// Click on custom

		driver.findElement(By.xpath("//label[@nzvalue='custom']")).click();

		Thread.sleep(2000);

		
		// Click On Uploads

		driver.findElement(By.xpath("//div[@role='tab'][normalize-space()='Uploads']")).click();

		Thread.sleep(2000);

		// click on set Granular access

		driver.findElement(By.xpath("(//p[@class='granular-access'])[2]")).click();

		Thread.sleep(2000);

		// click on check box item

		driver.findElement(By.xpath("(//span[@class='ant-checkbox'])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='ant-checkbox'])[3]")).click();
		driver.findElement(By.xpath("(//span[@class='ant-checkbox'])[6]")).click();
		

		Thread.sleep(2000);

		// click on Ok

		driver.findElement(By.xpath("//button[@class='ant-btn ng-star-inserted ant-btn-primary']")).click();

		// click on save

		driver.findElement(By.xpath(
				"//button[@class='drawer-footer-btn drawer-footer-btn--save ant-btn ng-star-inserted ant-btn-default']"))
				.click();

		// click on Send invite

		driver.findElement(
				By.xpath("//button[@class='form-button form-margin ant-btn ng-star-inserted ant-btn-primary']"))
				.click();

		Thread.sleep(2000);

		// click on logout

		driver.findElement(By.xpath("//i[@nztype='user']/..//span")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Logout']")).click();

		
		driver.close();

	}

}
