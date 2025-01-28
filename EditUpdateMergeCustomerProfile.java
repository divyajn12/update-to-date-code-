package jenkinscode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class EditUpdateMergeCustomerProfile {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
    	ChromeOptions options = new ChromeOptions();
        // Set ChromeOptions to accept insecure certificates
        options.setAcceptInsecureCerts(true);

        // Initialize WebDriver with ChromeOptions
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
  
       

    @Test
    public void Editupdatemergecustomerprofile() {
        try {
            // Open the application
            driver.get("https://app.swan.cx/login");

            // Create WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Enter email address
            WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
            emailField.sendKeys("divya.jain@loyalytics.in");

            // Enter password
            WebElement passwordField = driver.findElement(By.id("pass"));
            passwordField.sendKeys("Diva@12345");

            // Click on the Login Button
            WebElement loginButton = driver.findElement(By.id("btn"));
            loginButton.click();

            // Click on the customer profile
            WebElement customerProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Customer Profile']")));
            customerProfile.click();

            // Search the customer by using the registered phone number
            WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search By Phone Number, Email, Name']")));
            searchField.sendKeys("divya");

            // Wait for customer profile to load and click it
            WebElement signedUpOn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Signed up on')]")));
            signedUpOn.click();

            // Click on the first profile in the list
            WebElement firstProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[1]")));
            firstProfile.click();

            // Click on the edit icon
            WebElement editIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='editBtn ant-btn ng-star-inserted ant-btn-default ant-btn-circle ant-btn-icon-only']")));
            editIcon.click();

            // Update the first name
            WebElement firstNameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='First Name']")));
            firstNameField.clear();
            firstNameField.sendKeys("jainnew");

            // Save changes
            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='default']")));
            saveButton.click();

            // Deactivate the customer
            WebElement deactivateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-col ant-col-6 deactivate-btn ng-star-inserted']//button")));
            deactivateButton.click();

            // Process deactivation
            WebElement processButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-result-extra ng-star-inserted']//button")));
            processButton.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
   }

   @AfterTest
  public void tearDown() {
        // Close the browser
     if (driver != null) {
            driver.quit();
       }
    }
}
