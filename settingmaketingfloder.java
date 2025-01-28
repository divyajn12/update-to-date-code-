package jenkinscode;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class settingmaketingfloder {
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

			Thread.sleep(5000);

			// click on Setting

			driver.findElement(By.xpath("//span[normalize-space()='Settings']")).click();

			// click on marketing
			driver.findElement(By.xpath("//div[normalize-space()='Create various footers for your email']")).click();

			// click on + icon
			driver.findElement(By.xpath("//button[@class='add-btn-css ant-btn ant-btn-default ant-btn-round']"))
					.click();
			Thread.sleep(2000);
			// enter company name
			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("divya");
			Thread.sleep(2000);
			// enter Company Address
			driver.findElement(By.xpath("//textarea[@formcontrolname='address']")).sendKeys("bangolre head office");
			Thread.sleep(2000);
			// enter city
			driver.findElement(By.xpath("//input[@formcontrolname='city']")).sendKeys("bangolre");
			// enter Country
			driver.findElement(By.xpath("//input[@formcontrolname='country']")).sendKeys("India");
			// enter Phone Number
			driver.findElement(By.xpath("//input[@formcontrolname='phone']")).sendKeys("9125353553");
			// enter state
			driver.findElement(By.xpath("//input[@formcontrolname='state']")).sendKeys("M.P");
			// enter Company Url
			driver.findElement(By.xpath("//input[@formcontrolname='companyUrl']"))
					.sendKeys("https://app.swan.cx/app/settings/marketting-footer");
			//click on save button
			driver.findElement(By.xpath("//button[@class='form-button form-margin ant-btn ant-btn-primary']")).click();
			driver.close();

		}
	}
}
