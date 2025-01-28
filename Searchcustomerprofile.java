package jenkinscode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Searchcustomerprofile {
	WebDriver driver = new ChromeDriver();

	@BeforeClass
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		// Set ChromeOptions to accept insecure certificates
		options.setAcceptInsecureCerts(true);

		// Initialize WebDriver with ChromeOptions
		driver = new ChromeDriver(options);
	}

	@Test
	public void loginsearchcustomerprofile() throws InterruptedException {

		// Maximize window
		driver.manage().window().maximize();

		// Open the Swan application
		driver.get("https://app.swan.cx/login");
		// Enter email address
		driver.findElement(By.id("email")).sendKeys("divya.jain@loyalytics.in");
		// Enter password
		driver.findElement(By.id("pass")).sendKeys("Divya@123456");

		// Click on the Login Button
		driver.findElement(By.xpath("//button[@id='btn']")).click();

		// Wait for the login process to complete
		Thread.sleep(2000);
		// Click on the customer profile
		driver.findElement(By.xpath("//span[normalize-space()='Customer Profile']")).click();
		// Wait for the profile page to load
		Thread.sleep(2000);
		// Search the customer by using the registered phone number
		driver.findElement(By.xpath("//input[@placeholder='Search By Phone Number, Email, Name']")).sendKeys("divya");
		// Wait for the profile page to load
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Signed up on')]")).click();
		// | Wait for the profile page to load
		Thread.sleep(2000);
		// click on eye icon
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).click();
		// | Wait for the profile page to load
		Thread.sleep(2000);

		// view customer profile
		driver.findElement(By.xpath(
				"//div[@class='profile-details__main__details ng-star-inserted']//button[@class='ant-btn ant-btn-default']"))
				.click();
		// | Wait for the profile page to load
		Thread.sleep(5000);
		// click on points statment
		driver.findElement(By.xpath("//div[normalize-space()='Points Statements']")).click();
		// | Wait for the profile page to load
		Thread.sleep(3000);
		// click on customer cupon
		driver.findElement(By.xpath("//div[normalize-space()='Customer Coupons']")).click();
		// | Wait for the profile page to load
		Thread.sleep(3000);
		// click on Customer Communications
		driver.findElement(By.xpath("//div[normalize-space()='Customer Communications']")).click();
		// | Wait for the profile page to load
		Thread.sleep(3000);
		// click on jounery report
		driver.findElement(By.xpath("//div[normalize-space()='Journey Reports']")).click();
		// | Wait for the profile page to load
		Thread.sleep(3000);
		// click on customer otp
		driver.findElement(By.xpath("//div[@role='tablist']//div[6]")).click();
		// | Wait for the profile page to load
		Thread.sleep(3000);
		// close the cutomer profile deatils
		driver.findElement(By.xpath("//button[@id='detailsDrawerClose']")).click();
		// | Wait for the profile page to load
		Thread.sleep(4000);
		driver.close();

	}
}
