package jenkinscode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Test
public class CreateLoyaltyRewardTransactionsBonusMultiple {
    WebDriver driver;
    WebDriverWait wait;

    public void openBrowser() throws Exception {
        // Launch Chrome browser and navigate to Swan application
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://app.swan.cx/login");

        // Enter email address and password, then click on Login Button
        driver.findElement(By.id("email")).sendKeys("divya.jain@loyalytics.in");
        driver.findElement(By.id("pass")).sendKeys("Divya@123456");
        driver.findElement(By.xpath("//button[@id='btn']")).click();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);

        // Navigate to Loyalty Rewards and create rewards
        driver.findElement(By.xpath("//span[normalize-space()='Loyalty Rewards']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='dynamic-navbar__register ant-col ant-col-5']//button[@id='createBtn']")).click();

        // Fill in Voucher Name
        WebElement voucherNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter voucher name']")));
        voucherNameInput.sendKeys("Discountsep2024");
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
    public void trans() throws Exception {
        // Add Reward Earning Conditions

        // 1. Total Transaction Value is Greater Than 12
        driver.findElement(By.xpath("//nz-select[@formcontrolname='primary']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Total Transaction Value']")).click();
        driver.findElement(By.xpath("//nz-select[@formcontrolname='secondary']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='is Greater Than']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Minimum']")).sendKeys("12");
        driver.findElement(By.xpath("//body/app-root/app-layout/div[@class='insytio-layout']/div[@class='insytio-layout__container add-scroll']/div[@class='insytio-layout__container-content']/app-view-voucher/app-segment-details[@class='ng-star-inserted']/div[1]")).click();
        driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']")).click();
        Thread.sleep(2000);

        // 2. Total Transaction Value is Greater Than or Equal To 14
        driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[2]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Total Transaction Value']")).click();
        driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondary'])[2]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='is Greater Than or Equal To']")).click();
        driver.findElement(By.xpath("//input[@class='ant-input-number-input ng-untouched ng-pristine ng-valid']")).sendKeys("14");
        driver.findElement(By.xpath("//body/app-root/app-layout/div[@class='insytio-layout']/div[@class='insytio-layout__container add-scroll']/div[@class='insytio-layout__container-content']/app-view-voucher/app-segment-details[@class='ng-star-inserted']/div[1]")).click();
        driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']")).click();

        // 3. Total Transaction Value is Less Than 14
        driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[3]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Total Transaction Value']")).click();
        driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondary'])[3]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='is less than']")).click();
        driver.findElement(By.xpath("(//input[@placeholder='Minimum'])[3]")).sendKeys("14");
        driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']")).click();

        // 4. Total Transaction Value is Less Than or Equal To 10
        driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[4]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Total Transaction Value']")).click();
        driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondary'])[4]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='is Less Than or Equal To']")).click();
        driver.findElement(By.xpath("(//input[@placeholder='Minimum'])[4]")).sendKeys("10");
        driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']")).click();

        // 5. Total Transaction Value is Equal To 5
        driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[5]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Total Transaction Value']")).click();
        driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondary'])[5]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='is Equal To']")).click();
        driver.findElement(By.xpath("(//input[@placeholder='Minimum'])[5]")).sendKeys("5");
        driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']")).click();

        // 6. Total Transaction Value is Not Equal To 6
        driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[6]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Total Transaction Value']")).click();
        driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondary'])[6]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='is Not Equal To']")).click();
        driver.findElement(By.xpath("(//input[@placeholder='Minimum'])[6]")).sendKeys("6");
        driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']")).click();

        // 7. Total Transaction Value is Between 6 and 12
        driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[7]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Total Transaction Value']")).click();
        driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondary'])[7]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='is Between']")).click();
        driver.findElement(By.xpath("(//input[@placeholder='Minimum'])[7]")).sendKeys("6");
        driver.findElement(By.xpath("//input[@placeholder='Maximum']")).sendKeys("12");

        // Click on Bonus Point settings
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body//app-root//button[3]")).click();

        // Configure Bonus Type as Multiplier
        driver.findElement(By.xpath("(//nz-select[@formcontrolname='operator'])[2]")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Multiplier']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Enter Multipliter']")).sendKeys("12");
        driver.findElement(By.xpath("//nz-select[@formcontrolname='dateType']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Dynamic']")).click();
        driver.findElement(By.xpath("//input[@placeholder='1']")).sendKeys("12");

        // Submit the Voucher
        WebElement sv = driver.findElement(By.xpath("//button[@class='create-voucher ant-btn ng-star-inserted ant-btn-primary']"));
        sv.click();
        System.out.println("voucher created successfully");
        // Close the browser
        driver.close();
    }
}
