package jenkinscode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class Editcampagin {
	
	EdgeDriver driver = new EdgeDriver();
    public void editcampagin() throws InterruptedException
    {
        // Maximize window
        driver.manage().window().maximize();
        // Open swan application
        driver.get("https://app.swan.cx/login");
        // Enter email address
        driver.findElement(By.id("email")).sendKeys("divya.jain@loyalytics.in");
        // Enter password
        driver.findElement(By.id("pass")).sendKeys("Diva@12345");
        // Click on Login Button
        driver.findElement(By.xpath("//button[@id='btn']")).click();
        // Explicit wait for the Create Campaigns element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        WebElement createCampaignButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Create Campaigns']")));
        // Use JavaScript to click the button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", createCampaignButton);
        // Wait for the page to load
       Thread.sleep(3500);
        // Click on the create button
        //driver.findElement(By.xpath("//div[@class='campaign_button ant-col ant-col-3']//button[@id='createBtn']")).click();
	
	// Click create campaign sidebar
    driver.findElement(By.xpath("//span[text()='Create Campaigns']")).click();
   Thread.sleep(1000);
    
    // Click on edit button
    driver.findElement(By.xpath("(//i[@id='actionsIcon'])[1]")).click();
    Thread.sleep(3000);
    
    // Click on General
    driver.findElement(By.xpath("(//div[@class='ant-steps-item-title'])[1]")).click();
    Thread.sleep(2000);
    
    // Edit new campaign name
    driver.findElement(By.cssSelector("input[placeholder='name']")).clear();
   Thread.sleep(1000);
    driver.findElement(By.cssSelector("input[placeholder='name']")).sendKeys("diva");
    Thread.sleep(1000);
    
    // Edit new coupon code
    driver.findElement(By.cssSelector("input[placeholder='MKT (Optional)']")).clear();
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("input[placeholder='MKT (Optional)']")).sendKeys("tdia");
    Thread.sleep(1000);
    
    // Click next button
    driver.findElement(By.cssSelector("button[class='next pull-right ant-btn ng-star-inserted ant-btn-default']")).click();
    Thread.sleep(1000);
    
    // Click next button again
    driver.findElement(By.cssSelector("button[class='next pull-right ant-btn ng-star-inserted ant-btn-default']")).click();
    Thread.sleep(1000);
    
    // Edit discount value
    driver.findElement(By.xpath("//input[@onkeypress='return event.charCode >= 48']")).clear();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@onkeypress='return event.charCode >= 48']")).sendKeys("20");
    Thread.sleep(1000);
    
    // Edit threshold value
    driver.findElement(By.xpath("//input[@formcontrolname='threshold']")).clear();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@formcontrolname='threshold']")).sendKeys("15");
    Thread.sleep(1000);
    
    // Edit max discount value
    driver.findElement(By.xpath("//input[@formcontrolname='maxDiscount']")).clear();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@formcontrolname='maxDiscount']")).sendKeys("5");
    Thread.sleep(1000);
    
    // Click next button
    driver.findElement(By.xpath("//button[@class='next pull-right ant-btn ng-star-inserted ant-btn-default']")).click();
    Thread.sleep(1000);
    
    // Click next button again
    driver.findElement(By.xpath("//button[@class='next pull-right ant-btn ng-star-inserted ant-btn-default']")).click();
    Thread.sleep(1000);
    
    // Click on update button
    driver.findElement(By.xpath("//button[@class='button pull-right ant-btn ng-star-inserted ant-btn-default']")).click();
    driver.close();
}

}
