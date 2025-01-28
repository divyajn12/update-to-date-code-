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
public class createLoyatlyrewardweekdaybonus {
	WebDriver driver;
	WebDriverWait wait;

	public void openBrowser() throws Exception {
		// Launch Chrome browser and navigate to Make My Trip Site
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open Swan application
		driver.get("https://app.swan.cx/login");
		// Enter email address.
		driver.findElement(By.id("email")).sendKeys("divya.jain@loyalytics.in");
		// Enter password
		driver.findElement(By.id("pass")).sendKeys("Divya@123456");
		// Click on Login Button
		driver.findElement(By.xpath("//button[@id='btn']")).click();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);

		// Click on Loyalty Rewards
		driver.findElement(By.xpath("//span[normalize-space()='Loyalty Rewards']")).click();
		Thread.sleep(2000);
		// Click on create rewards
		driver.findElement(
				By.xpath("//div[@class='dynamic-navbar__register ant-col ant-col-5']//button[@id='createBtn']"))
				.click();

		// Fill in Voucher Name
		WebElement voucherNameInput = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter voucher name']")));
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
	public void state() throws Exception {

		// Reward Earning Conditions attributes
		driver.findElement(By.xpath("//nz-select[@formcontrolname='primary']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Week Days']")).click();

		/// select days any day
		driver.findElement(By.xpath("//nz-select[@formcontrolname='primaryMatchValue']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Wednesday']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Tuesday']")).click();

		// close the dropdown
		driver.findElement(By.xpath(
				"//div[@class='cdk-overlay-backdrop nz-overlay-transparent-backdrop cdk-overlay-backdrop-showing']"))
				.click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		// click on bonus point
		driver.findElement(By.xpath("//body//app-root//button[3]")).click();
		// click on bonus type
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='operator'])[2]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Multiplier']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter Multipliter']")).sendKeys("12");
		driver.findElement(By.xpath("//nz-select[@formcontrolname='dateType']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Dynamic']")).click();
		driver.findElement(By.xpath("//input[@placeholder='1']")).sendKeys("12");
		WebElement sv = driver.findElement(By
				.xpath("//button[@class='publish-voucher voucher-popover ant-btn ng-star-inserted ant-btn-primary']"));
		sv.click();
		 System.out.println("voucher created successfully");
		// <---------------------------------------------------------------------------------------------------------->
		
	}
}