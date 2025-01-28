package jenkinscode;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

@Test
public class Namingconventionsegment2 {

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
        driver.findElement(By.xpath("//a[@routerlink='/app/settings/naming-convention']//div[@class='ant-card-body']"))
                .click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;
//driver.findElement(By.xpath("//button[@type='button']")).click();
        // Check if reset is required
        boolean isResetAvailable = driver
                .findElements(By.xpath("//button[@class='btn btn--reset ant-btn ng-star-inserted ant-btn-default']"))
                .size() > 0;

        if (isResetAvailable) {
            WebElement resetButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@class='btn btn--reset ant-btn ng-star-inserted ant-btn-default']")));
            js.executeScript("arguments[0].scrollIntoView(true);", resetButton);
            resetButton.click();

            WebElement confirmReset = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//button[@class='popup-modal__btn ant-btn ant-btn-primary']")));
            confirmReset.click();

            System.out.println("Settings reset successfully.");
            // Re-locate the elements after reset
            driver.findElement(By.xpath("//span[normalize-space()='Settings']")).click();
            driver.findElement(By.xpath("//a[@routerlink='/app/settings/naming-convention']//div[@class='ant-card-body']"))
                    .click();
        }
       // Thread.sleep(2000);

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
        WebElement saveButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[@class='btn ant-btn ng-star-inserted ant-btn-primary']")));
        js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
        saveButton.click();

        System.out.println("New naming convention successfully saved!");
        Thread.sleep(2000);

        // Click on Segment
        driver.findElement(By.xpath("//span[text()='Segment']")).click();
        Thread.sleep(2000);

        // Click on create segment
        driver.findElement(By.xpath(
                "//button[@class='segments-container__header__button ant-btn ng-star-inserted ant-btn-primary']"))
                .click();

        // Select the option from the dropdown
        driver.findElement(By.xpath("//div[text()='Select Attributes'][1]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Available Points')]")).click();
        Thread.sleep(2000);

        // Click on select
        driver.findElement(By.xpath("//div[text()='Select'][1]")).click();
        driver.findElement(By.xpath("(//div[contains(text(),'Is Less than')])[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='X']")).sendKeys("12");

        // Desired format: [Numbers]_[Letters]_[Date in DDMMYYYY]
        String baseSegmentName = "1212/Diva/12122027"; // Base name to start with
        String regexPattern = "\\d+/[A-Za-z]+/\\d{8}"; // Regular expression for the desired format

        String currentSegmentName = baseSegmentName;
        String middleChar = "y"; // Character to insert when a duplicate is found

        // Check if the entered segment name matches the format
        if (!currentSegmentName.matches(regexPattern)) {
            System.out.println("Invalid format. Updating segment name to match the desired format.");
            String defaultNumber = "1234";  // Default number
            String defaultLetters = "Default"; // Default letters
            String defaultDate = "01012025";  // Default date

            // Split the name and validate individual components
            String[] parts = currentSegmentName.split("/");
            String validNumber = (parts.length > 0 && parts[0].matches("\\d+")) ? parts[0] : defaultNumber;
            String validLetters = (parts.length > 1 && parts[1].matches("[A-Za-z]+")) ? parts[1] : defaultLetters;
            String validDate = (parts.length > 2 && parts[2].matches("\\d{8}")) ? parts[2] : defaultDate;

            // Construct a valid segment name
            currentSegmentName = validNumber + "/" + validLetters + "/" + validDate;
        }

        // Enter the segment name and handle duplicates
        while (true) {
            try {
                WebElement segmentNameInput = driver.findElement(By.xpath("//input[@placeholder='Segment Name']"));
                segmentNameInput.clear();
                segmentNameInput.sendKeys(currentSegmentName);

                // Attempt to save or move to the next step
                WebElement saveButton1 = new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.elementToBeClickable(By.xpath(
                                "(//button[@class='header__btn header__btn--save ant-btn ng-star-inserted ant-btn-primary'])[1]")));
                saveButton1.click();

                // Check for duplicate error message (modify XPath as per your application's error message)
                List<WebElement> errorMessages = driver.findElements(By.xpath("//div[contains(text(), 'already exists')]"));

                if (errorMessages.isEmpty()) {
                    // No error message means the name is unique and saved successfully
                    System.out.println("Segment name saved successfully: " + currentSegmentName);
                    break;
                } else {
                    // Name already exists; modify the segment name by adding a character in the middle
                    System.out.println("Duplicate name found. Modifying the segment name.");

                    // Split the name into parts and insert the middle character
                    String[] parts = currentSegmentName.split("/");
                    if (parts.length >= 2) {
                        parts[1] = parts[1] + middleChar; // Add the middle character to the second part
                    } else {
                        parts[1] = middleChar; // Fallback if parts are not as expected
                    }

                    // Reconstruct the segment name
                    currentSegmentName = String.join("/", parts);
                    System.out.println("Trying with updated segment name: " + currentSegmentName);

                }
            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException caught, refinding elements.");
            } catch (ElementClickInterceptedException e) {
                System.out.println("ElementClickInterceptedException caught, retrying the click operation.");
            }
        }}}
