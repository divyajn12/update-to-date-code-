package jenkinscode;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class Namingconventionjourney {

    public void customSettingInvite() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();

        // Maximize window and set implicit wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the application
        driver.get("https://app.swan.cx/app/setup");

        // Login to the application
        driver.findElement(By.id("email")).sendKeys("divya.jain@loyalytics.in");
        driver.findElement(By.id("pass")).sendKeys("Divya@123456");
        driver.findElement(By.xpath("//button[@id='btn']")).click();

        // Wait for login to complete
        Thread.sleep(5000);

        // Navigate to Settings and Naming Convention
        driver.findElement(By.xpath("//span[normalize-space()='Settings']")).click();
        driver.findElement(By.xpath("//a[@routerlink='/app/settings/naming-convention']//div[@class='ant-card-body']")).click();
        
        //click on journey setting 
        driver.findElement(By.xpath("//div[normalize-space()='Journey']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Check if reset is required
        boolean isResetAvailable = driver.findElements(By.xpath("//button[@class='btn btn--reset ant-btn ng-star-inserted ant-btn-default']")).size() > 0;

        if (isResetAvailable) {
            WebElement resetButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn--reset ant-btn ng-star-inserted ant-btn-default']")));
            js.executeScript("arguments[0].scrollIntoView(true);", resetButton);
            resetButton.click();

            WebElement confirmReset = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='popup-modal__btn ant-btn ant-btn-primary']")));
            confirmReset.click();

            System.out.println("Settings reset successfully.");
            //driver.navigate().refresh();
        }
     // select Separator
        // Click to open the dropdown
          driver.findElement(By.xpath("//div[@title='_ (Underscore)']")).click();
          driver.findElement(By.xpath("//li[normalize-space()='/ (Slash)']")).click();
          
        // Select the first element
        driver.findElement(By.xpath("//div[text()='Select an element'][1]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Number']")).click();

        // Click on Add button
        driver.findElement(By.xpath("//button[@class='add-element-btn ant-btn ant-btn-default']")).click();
        Thread.sleep(2000);

        // Select the second element
        driver.findElement(By.xpath("(//nz-select[@id='elementType'])[2]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Letters and Numbers']")).click();

        // Click on Add button
        driver.findElement(By.xpath("//button[@class='add-element-btn ant-btn ant-btn-default']")).click();
        Thread.sleep(2000);

        // Select the third element
        driver.findElement(By.xpath("(//nz-select[@id='elementType'])[3]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Date']")).click();



        // Click on Save button after adding all elements
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn ant-btn ng-star-inserted ant-btn-primary']")));
        js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
        saveButton.click();

        System.out.println("New naming convention successfully saved!");

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
     		// Enter Name 
     		driver.findElement(By.xpath("(//h5[@title ='Click To Edit'])")).clear();
     		driver.findElement(By.xpath("(//h5[@title ='Click To Edit'])")).sendKeys("1212/Diva/12122027");
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

    	
    		try {
                // Wait for the button to be visible and clickable
                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement saveButton1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ant-btn journey-header__form-save ng-star-inserted ant-btn-link']")));
                
                // Wait until the button is clickable
                wait1.until(ExpectedConditions.elementToBeClickable(saveButton1));

                // Ensure no overlapping element (modal, etc.) is blocking the button.
                WebElement overlay = driver.findElement(By.cssSelector(".ant-modal-mask"));
                if (overlay.isDisplayed()) {
                    System.out.println("Overlay detected, closing the overlay...");
                    WebElement closeButton = driver.findElement(By.cssSelector(".ant-modal-close"));
                    closeButton.click();
                    wait1.until(ExpectedConditions.invisibilityOf(overlay));
                }

                // Scroll into view to ensure it's within the viewport
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton1);
                Thread.sleep(500);  // Adding a short delay to ensure the element is in view

                // Click the button using JavaScript if normal click fails
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton1);
                System.out.println("Save button clicked successfully.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                driver.quit();
            }
        }
    }

