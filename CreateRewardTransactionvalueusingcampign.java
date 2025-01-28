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

public class CreateRewardTransactionvalueusingcampign {
	WebDriver driver;
	WebDriverWait wait;

	@Test
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
	public void trans() throws Exception {

		// Reward Earning Conditions attributes is greater then
		driver.findElement(By.xpath("//nz-select[@formcontrolname='primary']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Total Transaction Value']")).click();
		/// select condition
		driver.findElement(By.xpath("//nz-select[@formcontrolname='secondary']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='is Greater Than']")).click();
		// click on minimum input field
		driver.findElement(By.xpath("//input[@placeholder='Minimum']")).sendKeys("12");
		driver.findElement(By.xpath(
				"//body/app-root/app-layout/div[@class='insytio-layout']/div[@class='insytio-layout__container add-scroll']/div[@class='insytio-layout__container-content']/app-view-voucher/app-segment-details[@class='ng-star-inserted']/div[1]"))
				.click();

		// click on add
		driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']"))
				.click();
		Thread.sleep(2000);
		// Reward Earning Conditions attributes is greater then or equal to
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[2]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Total Transaction Value']")).click();
		/// select condition
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondary'])[2]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='is Greater Than or Equal To']")).click();
		// click on minimum input field
		driver.findElement(By.xpath("//input[@class='ant-input-number-input ng-untouched ng-pristine ng-valid']"))
				.sendKeys("14");
		driver.findElement(By.xpath(
				"//body/app-root/app-layout/div[@class='insytio-layout']/div[@class='insytio-layout__container add-scroll']/div[@class='insytio-layout__container-content']/app-view-voucher/app-segment-details[@class='ng-star-inserted']/div[1]"))
				.click();
		// click on add
		driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']"))
				.click();

		// Reward Earning Conditions attributes is less than
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[3]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Total Transaction Value']")).click();
		/// select condition
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondary'])[3]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='is less than']")).click();
		// click on minimum input field
		driver.findElement(By.xpath("(//input[@placeholder='Minimum'])[3]")).sendKeys("14");
		// driver.findElement(By.xpath("//body/app-root/app-layout/div[@class='insytio-layout']/div[@class='insytio-layout__container
		// add-scroll']/div[@class='insytio-layout__container-content']/app-view-voucher/app-segment-details[@class='ng-star-inserted']/div[1]")).click();
		// click on add
		driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']"))
				.click();

		// Reward Earning Conditions attributes is Less Than or Equal To
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[4]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Total Transaction Value']")).click();
		/// select condition
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondary'])[4]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='is Less Than or Equal To']")).click();
		// click on minimum input field
		driver.findElement(By.xpath("(//input[@placeholder='Minimum'])[4]")).sendKeys("10");
		// driver.findElement(By.xpath("//body/app-root/app-layout/div[@class='insytio-layout']/div[@class='insytio-layout__container
		// add-scroll']/div[@class='insytio-layout__container-content']/app-view-voucher/app-segment-details[@class='ng-star-inserted']/div[1]")).click();
		// click on add
		driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']"))
				.click();

		// Reward Earning Conditions attributes is Less To
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[5]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Total Transaction Value']")).click();
		/// select condition
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondary'])[5]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='is Equal To']")).click();
		// click on minimum input field
		driver.findElement(By.xpath("(//input[@placeholder='Minimum'])[5]")).sendKeys("5");
		// driver.findElement(By.xpath("//body/app-root/app-layout/div[@class='insytio-layout']/div[@class='insytio-layout__container
		// add-scroll']/div[@class='insytio-layout__container-content']/app-view-voucher/app-segment-details[@class='ng-star-inserted']/div[1]")).click();
		// click on add
		driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']"))
				.click();

		// Reward Earning Conditions attributes is Not Equal To
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[6]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Total Transaction Value']")).click();
		/// select condition
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondary'])[6]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='is Not Equal To']")).click();
		// click on minimum input field
		driver.findElement(By.xpath("(//input[@placeholder='Minimum'])[6]")).sendKeys("6");
		// driver.findElement(By.xpath("//body/app-root/app-layout/div[@class='insytio-layout']/div[@class='insytio-layout__container
		// add-scroll']/div[@class='insytio-layout__container-content']/app-view-voucher/app-segment-details[@class='ng-star-inserted']/div[1]")).click();
		// click on add
		driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']"))
				.click();

		// Reward Earning Conditions attributes is Between
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[7]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Total Transaction Value']")).click();
		/// select condition
		driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondary'])[7]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='is Between']")).click();
		// click on minimum input field
		driver.findElement(By.xpath("(//input[@placeholder='Minimum'])[7]")).sendKeys("6");
		// click on maximum
		driver.findElement(By.xpath("//input[@placeholder='Maximum']")).sendKeys("12");
		// driver.findElement(By.xpath("//body/app-root/app-layout/div[@class='insytio-layout']/div[@class='insytio-layout__container
		// add-scroll']/div[@class='insytio-layout__container-content']/app-view-voucher/app-segment-details[@class='ng-star-inserted']/div[1]")).click();

		// Configure Reward
		driver.findElement(By.xpath("//nz-select[@id='selectCamp']")).click();
		// select value for drop down
		driver.findElement(By.xpath("//li[normalize-space()='test19']")).click();// Reward Earning Conditions attributes
		// close the dropdow
		// Thread.sleep(2000);

		WebElement sv = driver
				.findElement(By.xpath("//button[@class='create-voucher ant-btn ng-star-inserted ant-btn-primary']"));
		sv.click();
		 System.out.println("voucher created successfully");
		driver.close();
	}

}