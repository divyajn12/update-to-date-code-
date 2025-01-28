package jenkinscode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
@Test
public class Deletecampaign {
	EdgeDriver driver = new EdgeDriver();

      public void Deletingit() throws InterruptedException {
    	 
    	    {
    	        // Maximize window
    	        driver.manage().window().maximize();
    	        // Open swan application
    	        driver.get("https://app.swan.cx/login");
    	        // Enter email address
    	        driver.findElement(By.id("email")).sendKeys("divya.jain@loyalytics.in");
    	        // Enter password
    	        driver.findElement(By.id("pass")).sendKeys("Divya@123456");
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
        // Hover over the three dots (actions icon)
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("(//i[@id='actionsIcon'])[1]"))).build().perform();
        
        // Click on the delete button
        driver.findElement(By.xpath("((//i[@id='actionsIcon'])/..//button[@nztooltiptitle='Delete'])[1]")).click();
        
        Thread.sleep(2000);
        
        // Click on OK button
        driver.findElement(By.xpath("//span[text()='OK']/..")).click();
        driver.close();
    }
}}