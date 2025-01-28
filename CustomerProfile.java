package jenkinscode;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerProfile {
    WebDriver driver;
    WebDriverWait wait;

    private int phoneNumberSuffix = 100;  // Start suffix for the phone number (incremented for each run)

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Set ChromeOptions to accept insecure certificates
        options.setAcceptInsecureCerts(true);
        // Initialize WebDriver with ChromeOptions
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        // Initialize WebDriverWait with a timeout of 10 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void customerregistertation() {

        // Open swan application
        driver.get("https://app.swan.cx/app/customer-profile");

        // Wait for email input to be present, then enter email address
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("divya.jain@loyalytics.in");

        // Enter password
        driver.findElement(By.id("pass")).sendKeys("Divya@123456");

        // Click on Login Button
        driver.findElement(By.id("btn")).click();

        // Wait for customer profile to appear and click on it
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Customer Profile']"))).click();

        // Click on customer register
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ng-star-inserted ant-btn-default']"))).click();

        // Fill in first name, last name, and email address
        driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("Swan", Keys.TAB, "Automate", Keys.TAB, "automate@loyalytics.com");

        // Click and select country code
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@unselectable='unselectable'])[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@unselectable='unselectable'])[177]"))).click();

        // Enter phone number (incrementing the number on each run)
        String phoneNumber = "9589222200" + phoneNumberSuffix++;
        driver.findElement(By.xpath("(//input[@formcontrolname='mobile'])")).sendKeys(phoneNumber);

        // Select date of birth
        driver.findElement(By.xpath("//input[contains(@placeholder,'date')]")).click();
        driver.findElement(By.xpath("(//div[text()=' 10 '])[1]")).click();

        // Select nationality
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Nationality')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@unselectable='unselectable'])[9]"))).click();

        // Select gender
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Please select your Gender']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='Male']"))).click();

        // Select language
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Please select your Language']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ant-select-dropdown-menu-item ng-star-inserted'][7]"))).click();

        // Enter address
       // driver.findElement(By.xpath("(//input[@Placeholder='Please enter value'])[1]")).sendKeys("Bangalore Headquarters");

        // Select Join Bispro option
      //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Please select your option']"))).click();
       // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ant-select-dropdown-menu-item ng-star-inserted'][1]"))).click();

        // Enable WhatsApp preferences
        driver.findElement(By.xpath("(//nz-button-group[contains(@class,'preferences ant-btn-group')])[4]//button[1]")).click();

        // Click Register Button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='register-btn pull-right ant-btn ng-star-inserted ant-btn-default']"))).click();
        System.out.println("Successfully Registered");

        // Alert message after registration
        //((JavascriptExecutor) driver).executeScript("alert('Registration Successful!');");

        // Logout
       // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@nztype='user']/..//span"))).click();
      //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Logout']"))).click();
    }

  //  @AfterClass
   // public void tearDown() {
        // Close the browser and quit the driver
     //   if (driver != null) {
       //     driver.quit();
}
    
