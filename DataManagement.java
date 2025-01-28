package jenkinscode;
import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class DataManagement 
{   
	@Test
	public void Landingpage() throws InterruptedException
	{   
		// Create a random number generator
		Random unique = new Random();
		// Generate a unique display name using a random number
		String uniqueDisplayNameAttribute = " Automation Test " + unique.nextInt(5000);
		String uniqueDisplayNameEvent = "Automation Test " + unique.nextInt(5000);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.swan.cx/login?next=%2F");
	    driver.manage().window().maximize();
	    
	    // Login 
	   driver.findElement(By.xpath("//input[@id='email']")).sendKeys("anil.thakur@loyalytics.in");
	   driver.findElement(By.id("pass")).sendKeys("Anil#@1999");
	   driver.findElement(By.xpath("//button[@id='btn']")).click();
	   
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	   
	   
	   Actions act = new Actions(driver);
	   act.moveToElement(driver.findElement(By.xpath("//span[text()='Data Management']"))).build().perform();
	   driver.findElement(By.xpath("//span[text()='Data Management']")).click();
	   
	   // Create Attribute 
	  driver.findElement(By.xpath("//button[@class='management__button ant-btn ng-star-inserted ant-btn-primary']")).click();
	  // Use the unique display name generated
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("(//input[@placeholder='Enter Name'])[1]")).sendKeys(uniqueDisplayNameAttribute);
	  // Description 
	  driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']")).sendKeys("Testing The Description Through Automation");
	  // DataType 
	  driver.findElement(By.xpath("//div[text()='Select Data Type']")).click();
	  // Select data type 
	  driver.findElement(By.xpath("//li[@class='ant-select-dropdown-menu-item ng-star-inserted'][1]")).click();
	   
	  act.moveToElement(driver.findElement(By.xpath("(//span[@class='anticon info-icon anticon-info-circle'])[7]"))).build().perform();
	  
	  
	  // Validation
	  driver.findElement(By.xpath("//div[text()='Select Validation']")).click();
	  // Select validation (Required)
	  driver.findElement(By.xpath("//li[@class='ant-select-dropdown-menu-item ng-star-inserted'][1]")).click();
	  // Select validation (Range)
	  driver.findElement(By.xpath("//li[@class='ant-select-dropdown-menu-item ng-star-inserted']")).click();
	// Close the dropdown
		driver.findElement(By.xpath(
				"//div[@class='cdk-overlay-backdrop nz-overlay-transparent-backdrop cdk-overlay-backdrop-showing']"))
				.click();
		
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Cancel']"))).build().perform();
		
		// Enter from Range Value 
		driver.findElement(By.xpath("(//input[@class='ant-input-number-input ng-untouched ng-pristine ng-valid'])[1]")).sendKeys("100");
		// Enter To Range Value 	                                  
		driver.findElement(By.xpath("//input[@class='ant-input-number-input ng-untouched ng-pristine ng-valid']")).sendKeys("500");
		
		//click on save 
		driver.findElement(By.xpath("//button[@class='drawer-footer-btn drawer-footer-btn--save ant-btn ant-btn-default']")).click();
		Thread.sleep(2000);
		//click on got it 
		driver.findElement(By.xpath("//button[@class='popup-modal__btn ant-btn ant-btn-primary']")).click();
		
		// Creation of Custom Event
		
		//Custom Event 
		driver.findElement(By.xpath("//div[@class='ant-tabs-tab ng-star-inserted'][1]")).click();
		//create Event 
		driver.findElement(By.xpath("//button[@class='management__button ant-btn ng-star-inserted ant-btn-primary']")).click();
		//Display Name 
		driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys(uniqueDisplayNameEvent);
		//Description 
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']")).sendKeys("Testing The description through Automation");
		//save 
		driver.findElement(By.xpath("//button[@class='drawer-footer-btn drawer-footer-btn--save ant-btn ant-btn-default']")).click();
		 //Got it popup
		driver.findElement(By.xpath("//button[@class='popup-modal__btn ant-btn ant-btn-primary']")).click();
		//close the browser
	    //driver.close();
		  
	}
}