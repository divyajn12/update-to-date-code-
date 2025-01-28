package jenkinscode;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Test
public class jouneryworkflow {

	public void testLogin() throws InterruptedException {

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

		driver.findElement(By.id("pass")).sendKeys("Divya@123456");

		// Thread.sleep(2000);

		// click on Login Button .

		driver.findElement(By.xpath("//button[@id='btn']")).click();

		Thread.sleep(5000);

		// Navigate to Journey Workflows
		WebElement sidebar = driver.findElement(By.xpath("//a[normalize-space()='']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(sidebar).perform();

		driver.findElement(By.xpath("//span[normalize-space()='Journey Workflows']")).click();

		// Search Journey
		WebElement searchJourney = driver.findElement(By.xpath("//input[@placeholder='Search Journeys']"));
		Thread.sleep(4000);
		actions.moveToElement(searchJourney).perform();

		// Create Journey
		WebElement createJourneyButton = driver.findElement(By.xpath(
				"//button[@class='view-journey-container-header__create-btn ant-btn ant-btn-default ant-btn-round']"));
		createJourneyButton.click();
		Thread.sleep(2000);

		// Start from Scratch
		WebElement startFromScratch = driver.findElement(By.xpath("//span[normalize-space()='Start From Scratch']"));
		Thread.sleep(2000);
		actions.moveToElement(startFromScratch).perform();
		driver.findElement(By.xpath("//app-templates-showcase-card[1]//div[2]//button[1]")).click();
		Thread.sleep(5000);

		// Drag and drop components to canvas
		Actions actions1 = new Actions(driver);
		WebElement segmentTrigger = driver.findElement(By.xpath("(//div[@draggable='true'])[1]"));
		actions1.dragAndDropBy(segmentTrigger, 300, 180).perform();

		WebElement attributeFilter = driver.findElement(By.xpath("(//div[@draggable='true'])[18]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", attributeFilter);
		actions1.dragAndDropBy(attributeFilter, 600, 130).perform();

		WebElement emailAction = driver.findElement(By.xpath("(//div[@draggable='true'])[9]"));
		actions1.dragAndDropBy(emailAction, 900, -200).perform();

		WebElement endJourney = driver.findElement(By.xpath("(//div[@draggable='true'])[24]"));
		actions1.dragAndDropBy(endJourney, 1250, -140).perform();
		// actions1.dragAndDropBy(endJourney, 900, -70).perform();

		// Connecting components
		Actions actions11 = new Actions(driver);
		WebElement segmentPointer = driver.findElement(By.xpath("//*[@port='Segment']"));
		WebElement attributeFilterInPort = driver.findElement(By.xpath("/descendant::*[@port='in_port_id'][1]"));
		actions11.dragAndDrop(segmentPointer, attributeFilterInPort).perform();
		Thread.sleep(2000);
		WebElement attributeFilterYesPointer = driver.findElement(By.xpath("//*[@port='On Send']"));
		WebElement emailInPort = driver.findElement(By.xpath("/descendant::*[@port='in_port_id'][2]"));
		actions11.dragAndDrop(attributeFilterYesPointer, emailInPort).perform();

		WebElement emailPointer = driver.findElement(By.xpath("(//*[@port='On Send'])[2]"));
		WebElement endJourney1InPort = driver.findElement(By.xpath("(/descendant::*[@port='in_port_id'])[3]"));
		actions11.dragAndDrop(emailPointer, endJourney1InPort).perform();

		System.out.println("Successfully Established connection between Components");

		// click on 3 dots of segment
		driver.findElement(By.xpath("/descendant::*[@port-group='config-btn'][1]")).click();
		TimeUnit.SECONDS.sleep(1);

		driver.findElement(By.xpath("//nz-select[@formcontrolname='segmentAction']")).click();
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.xpath("//ul[@tabindex='0']")).click();

		driver.findElement(By.xpath("//nz-select[@formcontrolname='segmentType']")).click();
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.xpath("//li[normalize-space()='Custom Segment']")).click();

		driver.findElement(By.xpath("//nz-select[@formcontrolname='segmentName']")).click();
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(
				By.xpath("(//span[@class='option option__tag1 ng-star-inserted'][normalize-space()='Static'])[1]"))
				.click();

		driver.findElement(By.xpath(
				"//button[@class='drawer-footer-btn drawer-footer-btn--save ant-btn ng-star-inserted ant-btn-default']"))
				.click();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Successfully Configured of Segment");

		// click on 3 dots of In APP
		driver.findElement(By.xpath("/descendant::*[@port-group='config-btn'][2]")).click();
		TimeUnit.SECONDS.sleep(1);
		// select templates
		WebElement templates = driver
				.findElement(By.xpath("(//div[@class='thumbnail-showcase-container--overlay-layer'])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(templates).build().perform();
		driver.findElement(By.xpath("(//button[@nztooltiptitle='Select Template'])[1]")).click();
		
		// click on save button
		driver.findElement(By.xpath(
				"//button[@class='drawer-footer-btn drawer-footer-btn--save ant-btn ng-star-inserted ant-btn-default']"))
				.click();
		System.out.println("Successfully Configured of IN APP");

		// Email action configuration
		driver.findElement(By.xpath("/descendant::*[@port-group='config-btn'][3]")).click();
		TimeUnit.SECONDS.sleep(1);

		driver.findElement(By.xpath("//div[normalize-space()='Published Emails']")).click();
		TimeUnit.SECONDS.sleep(3);

		WebElement publishedEmail = driver.findElement(By.xpath("//app-thumbnail-showcase-card[4]"));
		actions.moveToElement(publishedEmail).build().perform();
		TimeUnit.SECONDS.sleep(1);

		driver.findElement(By.xpath("//button[@nztooltiptitle='Select Template']")).click();
		System.out.println("Select Successfully");
		TimeUnit.SECONDS.sleep(1);

		driver.findElement(By.xpath(
				"//button[@class='drawer-footer-btn drawer-footer-btn--save ant-btn ng-star-inserted ant-btn-default']"))
				.click();
		System.out.println("Successfully Configured Email Action");
		TimeUnit.SECONDS.sleep(3);

		driver.findElement(By.xpath("//button[@class='ant-btn journey-header__form-save ng-star-inserted ant-btn-link']")).click();

		System.out.println("Successfully saved");
		
		//publish journey
        WebElement journeyName = driver.findElement(By.xpath("//h5[normalize-space()='New Journey']"));
        journeyName.clear();
        journeyName.sendKeys("Automation jounrey 1");
        TimeUnit.SECONDS.sleep(7);
        actions.moveToElement(journeyName).perform();
        TimeUnit.SECONDS.sleep(3);
        
        driver.findElement(By.xpath("(//button[@nztype='link'])[2]")).click();
        
        driver.findElement(By.xpath("//button[normalize-space()='Publish']")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//li[normalize-space()='Publish Now']")).click();
        //
       
       // TimeUnit.SECONDS.sleep(1);
        
     
        WebElement selectgoal1= driver.findElement(By.xpath("//nz-select[@nzplaceholder=\"Select Goal\"]"));
      //WebElement selectgoal1 = driver.findElement(By.xpath("//span[normalize-space()='Coupons']"));
       Actions actions13 =new Actions(driver);
       actions13.sendKeys(selectgoal1, "Coupons").sendKeys(Keys.ENTER).build().perform();
       //click on time check box
       driver.findElement(By.xpath("/descendant::*[@type='checkbox'][1]")).click();
       //click on publish button 
       driver.findElement(By.xpath("/descendant::*[normalize-space()='Publish'][4]")).click();
    
   		
       
        
        

       
        System.out.println("Successfully Saved and Published Journey");

	}

}
