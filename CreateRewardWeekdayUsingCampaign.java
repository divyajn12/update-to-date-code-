package jenkinscode;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class CreateRewardWeekdayUsingCampaign {
    WebDriver driver;
    WebDriverWait wait;

    public void openBrowser() throws Exception {
        // Launch Chrome browser and navigate to the Swan application
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open Swan application
        driver.get("https://app.swan.cx/login");

        // Enter email and password, then log in
        driver.findElement(By.id("email")).sendKeys("divya.jain@loyalytics.in");
        driver.findElement(By.id("pass")).sendKeys("Divya@123456");
        driver.findElement(By.xpath("//button[@id='btn']")).click();

        // Maximize browser window and clear cookies
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        Thread.sleep(3000); // Pause to allow page loading

        // Navigate to Loyalty Rewards
        driver.findElement(By.xpath("//span[normalize-space()='Loyalty Rewards']")).click();
        Thread.sleep(2000);

        // Click on Create Rewards
        driver.findElement(By.xpath("//div[@class='dynamic-navbar__register ant-col ant-col-5']//button[@id='createBtn']")).click();

        // Wait for the voucher name input to appear, and fill it in
        WebElement voucherNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter voucher name']")));
        voucherNameInput.sendKeys("Discountsep2024");

        // Select the start date by navigating through the date picker
        // Set Voucher Validity Start Date
        WebElement startDatePicker = driver.findElement(By.xpath("//input[@placeholder='Start date']"));
        startDatePicker.click();
        String checkInMonth = "OCT 2025"; // Ensure correct capitalization
        String dateVal = "30";
        loopDatePicker(checkInMonth, dateVal);
    }

    private void loopDatePicker(String checkInMonth, String dateVal) throws InterruptedException {
        while (true) {
            String month = driver.findElement(By.xpath("//div[@class='ant-calendar-header']//div")).getText();
            if (month.equals(checkInMonth)) {
                break;
            } else {
                driver.findElement(By.xpath("//a[@title='Next month (PageDown)']")).click();
            }

            List<WebElement> ele = driver.findElements(By.xpath("(//tbody)[1]//tr//td/div"));
            for (WebElement element : ele) {
                String date = element.getText();
                if (date.equals(dateVal)) {
                    element.click();
                    break;
                }
            }
        }
    }

    

    @Test
    public void state() throws Exception {
        // Reward Earning Conditions attributes: Select Week Days
        driver.findElement(By.xpath("//nz-select[@formcontrolname='primary']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Week Days']")).click();

        // Select specific days (Wednesday, Tuesday)
        driver.findElement(By.xpath("//nz-select[@formcontrolname='primaryMatchValue']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Wednesday']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Tuesday']")).click();

        // Close the dropdown
        driver.findElement(By.xpath("//div[@class='cdk-overlay-backdrop nz-overlay-transparent-backdrop cdk-overlay-backdrop-showing']")).click();
        Thread.sleep(2000); // Wait for dropdown closure

        // Configure Reward: Select Campaign
        driver.findElement(By.xpath("//nz-select[@id='selectCamp']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='test19']")).click(); // Select the campaign

        // Click to create the reward
        WebElement saveButton = driver.findElement(By.xpath("//button[@class='create-voucher ant-btn ng-star-inserted ant-btn-primary']"));
        saveButton.click(); // Click the button to create the reward
        System.out.println("voucher created successfully");
     
    }
}
