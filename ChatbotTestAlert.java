package jenkinscode;

import java.io.FileWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ChatbotTestAlert {
    @Test
    public void testChatbotResponses() {
        WebDriver driver = new ChromeDriver();

        try (FileWriter writer = new FileWriter("chatbot_responsess.csv")) {
            // Write CSV headers
            writer.append("Question,Response\n");

            // Maximize the browser window
            driver.manage().window().maximize();
            driver.get("https://app.swan.cx/");

            // Log in to the application
            driver.findElement(By.id("email")).sendKeys("divya.jain@loyalytics.in");
            driver.findElement(By.id("pass")).sendKeys("Divya@123456");
            driver.findElement(By.xpath("//button[@id='btn']")).click();

            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Customer Profile']")));

            // Navigate to Customer Profile
            driver.findElement(By.xpath("//span[normalize-space()='Customer Profile']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search By Phone Number, Email, Name']")));

            driver.findElement(By.xpath("//input[@placeholder='Search By Phone Number, Email, Name']")).sendKeys("919589532707");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Signed up on')]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-default ant-btn-icon-only']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='nuron__btn default border']"))).click();

            WebElement chatInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Ask Nuron...']")));

            String[] questions = {
                "please share transaction details?",
                "most expensive product bought",
                "Total available point?",
                "last transaction?",
                "share the transaction b/w Nov to Dec 2024?",
                "share total number of coupon available?",
                "share the list of total redeemed coupon?",
                "share the list of total non-redeemed coupon?",
                "share the line item of this transaction id r12333000001?",
                "share the details of this message id SMa71c5447f57566712e082dc913e1aa68?",
                "filter my points by created date?",
                "view only redeemed points?",
                "check all my available coupons?",
                "coupon code is QEWR1ABUB find campaign name?",
                "share the validity of coupon code?",
                "maximum discount of this QEWR1ABUB coupon?",
                "list of expired coupons?",
                "share the highest discount applied in coupon"
            };

            for (String question : questions) {
                // Enter the question
                Actions actions = new Actions(driver);
                actions.sendKeys(chatInput, question).sendKeys(Keys.ENTER).build().perform();

                // Wait for the chatbot response
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'chat-message') and contains(@class, 'bg-white')]")));

                // Fetch the last response
                List<WebElement> responseElements = driver.findElements(By.xpath("//div[contains(@class, 'chat-message') and contains(@class, 'bg-white')]"));
                String response = responseElements.get(responseElements.size() - 1).getText(); // Get the latest response

                // Save the question and response to the CSV file
                writer.append("\"").append(question).append("\",\"").append(response.replace("\n", " ")).append("\"\n");

                // Print to console for debugging
                System.out.println("Question: " + question);
                System.out.println("Response: " + response);

                Thread.sleep(7000); // Wait between questions
            }

            // Display an alert after all questions are processed and saved
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("alert('All questions have been processed and responses are saved successfully!');");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser after the test
            driver.quit();
        }
    }
}
