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
public class createloyaltyrewardcampignstore {
	
	WebDriver driver;
	WebDriverWait wait;

	public void openBrowser() throws Exception  {
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
	public void transstoreid()throws Exception  {

		// Reward Earning Conditions attributes stores by store id
				driver.findElement(By.xpath("//nz-select[@formcontrolname='primary']")).click();
				driver.findElement(By.xpath("//li[normalize-space()='Stores']")).click();
				Thread.sleep(2000);
				/// select store by storeid
				driver.findElement(By.xpath("//nz-select[@formcontrolname='secondaryMatchValue']")).click();
				driver.findElement(By.xpath("//li[normalize-space()='storeId']")).click();
				Thread.sleep(2000);
				// enter storeid
				// Locate the search input field (modify selector if necessary)
		        WebElement searchInput = driver.findElement(By.xpath("//nz-select[@formcontrolname='primaryMatchValue']"));
		       Actions actions =new Actions(driver);
		       actions.sendKeys(searchInput,"test12344").build().perform();
		       Thread.sleep(2000);
		       actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		    // close the dropdown
				driver.findElement(By.xpath(
						"//div[@class='cdk-overlay-backdrop nz-overlay-transparent-backdrop cdk-overlay-backdrop-showing']"))
						.click();
		    // click on add
				driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']"))
						.click();
		   
				// Reward Earning Conditions attributes stores by store name
				driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[2]")).click();
				driver.findElement(By.xpath("//li[normalize-space()='Stores']")).click();
				Thread.sleep(2000);
				/// select store by storeid
				driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondaryMatchValue'])[2]")).click();
				driver.findElement(By.xpath("//li[normalize-space()='storeName']")).click();
				Thread.sleep(2000);
				// enter storeid
				// Locate the search input field (modify selector if necessary)
		        WebElement searchInput11 = driver.findElement(By.xpath("(//nz-select[@formcontrolname='primaryMatchValue'])[2]"));
		       Actions actions11 =new Actions(driver);
		       actions11.sendKeys(searchInput11,"test12").build().perform();
		       Thread.sleep(2000);
		       actions11.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		    // close the dropdown
				driver.findElement(By.xpath(
						"//div[@class='cdk-overlay-backdrop nz-overlay-transparent-backdrop cdk-overlay-backdrop-showing']"))
						.click();
		    // click on add
				driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']"))
						.click();
		      
		        
				// Reward Earning Conditions attributes stores by address
				driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[3]")).click();
				driver.findElement(By.xpath("//li[normalize-space()='Stores']")).click();
				Thread.sleep(2000);
				/// select store by storeid
				driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondaryMatchValue'])[3]")).click();
				driver.findElement(By.xpath("//li[normalize-space()='address']")).click();
				Thread.sleep(2000);
				// enter storeid
				// Locate the search input field (modify selector if necessary)
		        WebElement searchInput13 = driver.findElement(By.xpath("(//nz-select[@formcontrolname='primaryMatchValue'])[3]"));
		       Actions actions13 =new Actions(driver);
		       actions13.sendKeys(searchInput13,"test").build().perform();
		       Thread.sleep(2000);
		       actions13.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).build().perform();
		    // close the dropdown
				driver.findElement(By.xpath(
						"//div[@class='cdk-overlay-backdrop nz-overlay-transparent-backdrop cdk-overlay-backdrop-showing']"))
						.click();
		    // click on add
				driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']"))
						.click();
				
				// Reward Earning Conditions attributes stores by phonenumber
				driver.findElement(By.xpath("(//nz-select[@formcontrolname='primary'])[4]")).click();
				driver.findElement(By.xpath("//li[normalize-space()='Stores']")).click();
				Thread.sleep(2000);
				/// select store by storeid
				driver.findElement(By.xpath("(//nz-select[@formcontrolname='secondaryMatchValue'])[4]")).click();
				driver.findElement(By.xpath("//li[normalize-space()='phoneNumber']")).click();
				Thread.sleep(2000);
				
				// Locate the search input field (modify selector if necessary)
		        WebElement searchInput14 = driver.findElement(By.xpath("(//nz-select[@formcontrolname='primaryMatchValue'])[4]"));
		       Actions actions14 =new Actions(driver);
		       actions14.sendKeys(searchInput14,"9").build().perform();
		       Thread.sleep(2000);
		       actions14.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).build().perform();
		    // close the dropdown
				driver.findElement(By.xpath(
						"//div[@class='cdk-overlay-backdrop nz-overlay-transparent-backdrop cdk-overlay-backdrop-showing']"))
						.click();
				 // click on add
				driver.findElement(By.xpath("//button[@class='control-btn-add ant-btn ng-star-inserted ant-btn-default']"))
						.click();
		   
				
	}
		
	@AfterTest
		public void saverewardn() throws Exception {
		Thread.sleep(2000);
		// Configure Reward
				driver.findElement(By.xpath("//nz-select[@id='selectCamp']")).click();
				// select value for drop down
				driver.findElement(By.xpath("//li[normalize-space()='test19']")).click();// Reward Earning Conditions attributes
				// close the dropdow
				// Thread.sleep(2000);
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
				 Actions actions =new Actions(driver);
			       actions.sendKeys(searchInput11,"test").build().perform();
			       Thread.sleep(2000);
			       actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			       Thread.sleep(2000);
			       driver.findElement(By.xpath("//button[@class='ant-btn ng-star-inserted ant-btn-primary']")).click();
			       System.out.println("voucher created successfully");
			     driver.close();
	}
			
			
		}
	


