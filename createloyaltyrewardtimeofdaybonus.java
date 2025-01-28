package jenkinscode;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class createloyaltyrewardtimeofdaybonus {

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
	public void transstoreid() throws Exception {

		// click on time of day is before
		driver.findElement(By.xpath("//nz-select[@formcontrolname='primary']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Time Of Day']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//nz-select[@formcontrolname='secondary']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='is before']")).click();
		Thread.sleep(2000);
		WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Select time']"));
		Actions actions = new Actions(driver);
		actions.sendKeys(searchInput, "111:37").build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

		// Close the dropdown
		driver.findElement(By.xpath(
				"//div[@class='cdk-overlay-backdrop nz-overlay-transparent-backdrop cdk-overlay-backdrop-showing']"))
		.click();
		Thread.sleep(2000); // Wait for dropdown closure
		// click on add
		driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']"))
		.click();

		// click on time of day is before
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[2]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Time Of Day']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondary'])[2]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='is after']")).click();
		Thread.sleep(2000);
		WebElement searchInput1 = driver
				.findElement(By.xpath("(//nz-time-picker[@formcontrolname='primaryMatchValue'])[2]"));
		Actions actions1 = new Actions(driver);
		actions.sendKeys(searchInput1, "155:37").build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

		// Close the dropdown
		driver.findElement(By.xpath(
				"//div[@class='cdk-overlay-backdrop nz-overlay-transparent-backdrop cdk-overlay-backdrop-showing']"))
		.click();
		Thread.sleep(2000); // Wait for dropdown closure
		// click on add
		driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']"))
		.click();

		// click on time of day is before
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[3]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Time Of Day']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondary'])[3]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='inBetween']")).click();
		Thread.sleep(2000);
		WebElement searchInput122 = driver
				.findElement(By.xpath("(//nz-time-picker[@formcontrolname='primaryMatchValue'])[3]"));
		Actions actions12 = new Actions(driver);
		actions.sendKeys(searchInput122, "115:37").build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(2000);
		WebElement searchInput22 = driver
				.findElement(By.xpath("//nz-time-picker[@formcontrolname='secondaryMatchValue']"));
		Actions actions2 = new Actions(driver);
		actions.sendKeys(searchInput22, "166:37").build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

		//configure for bonus point
		//click on bonus point
		driver.findElement(By.xpath("(//button[@class='ant-btn ant-btn-default'])[2]")).click();
		// click  on bonus type
		// click  on bonus type
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='operator'])[2]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Fixed']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter the number of points']")).sendKeys("12");
		driver.findElement(By.xpath("//nz-select[@formcontrolname='dateType']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Date']")).click();
		// Set Voucher Validity Start Date
		WebElement startDatePicker = driver.findElement(By.xpath("//input[@placeholder='Select date']"));
		startDatePicker.click();
		String checkInmonth = "DEC 2024";
		String dateval = "30";
		while (true) {
			String month = driver.findElement(By.xpath(
					"//div[@class='ant-calendar-header']//div"))
					.getText();
			if (month.equals(checkInmonth)) {
				break;
			} else {
				driver.findElement(By.xpath(
						"//a[@title='Next month (PageDown)']"))
				.click();
			}
			List<WebElement> ele = driver.findElements(By.xpath("(//tbody)[1]//tr//td/div"));
			for (WebElement element : ele) {
				String date = element.getText();
				if (date.equals(dateval)) {
					element.click();
					break;
				}
			}
		}		

	}
	@AfterTest
	public void saverewardn() throws Exception {
		Thread.sleep(2000);

		WebElement sv = driver
				.findElement(By.xpath("//button[@class='create-voucher ant-btn ng-star-inserted ant-btn-primary']"));
		sv.click();
		Thread.sleep(2000);
		// Click on the customer profile
		driver.findElement(By.xpath("//span[normalize-space()='Customer Profile']")).click();
		// Wait for the profile page to load
		Thread.sleep(2000);
		// Search the customer by using the registered phone number
		driver.findElement(By.xpath("//input[@placeholder='Search By Phone Number, Email, Name']")).sendKeys("divya");
		// Wait for the profile page to load
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Signed up on')]")).click();
		// | Wait for the profile page to load
		Thread.sleep(2000);
		// click on eye icon
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).click();
		// | Wait for the profile page to load
		Thread.sleep(2000);

		// view customer profile
		driver.findElement(By.xpath(
				"//div[@class='profile-details__main__details ng-star-inserted']//button[@class='ant-btn ant-btn-default']"))
				.click();
		Thread.sleep(3000);
		// | Wait for the profile page to load
		// click on customer cupon
		driver.findElement(By.xpath("//div[normalize-space()='Customer Coupons']")).click();
		Thread.sleep(3000);
		
		// click on create coupon 
		driver.findElement(By.xpath("//div[@class='tableBtn ng-star-inserted']//button[@class='ant-btn ng-star-inserted ant-btn-default']")).click();
		
		Thread.sleep(3000);

		 WebElement searchInput11= driver.findElement(By.xpath("//div[text()='Choose Campaign']"));
		 Actions actions11 =new Actions(driver);
	       actions11.sendKeys(searchInput11,"test").build().perform();
	       Thread.sleep(2000);
	       actions11.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	       Thread.sleep(2000);
	       driver.findElement(By.xpath("//button[@class='ant-btn ng-star-inserted ant-btn-primary']")).click();
	       System.out.println("voucher created successfully");
	     driver.close();
	}	



}


