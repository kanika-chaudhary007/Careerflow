package LearningSelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("window.chrome.driver",
				"C:\\repo\\PDAutomation\\AutomationDemoSelenium\\resources\\drivers\\windows\\chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();

		driver.get("https://app.careerflow.ai/login");

		// =====================================
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("kanikachaudhary2606@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("P@ssw0rd");

		WebElement button = driver.findElement(By.xpath("//button[@id='login_submit']"));
		button.click();

		Thread.sleep(5000);

//# 1.  Wait for the modal to appear

		By modalLocator = By.xpath("//div[@class='ant-modal-body']"); // Or any appropriate locator
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement modalElement = waits.until(ExpectedConditions.visibilityOfElementLocated(modalLocator));

		WebElement Started = driver.findElement(By.xpath("(//div[@class='ant-modal-body']//button)[1]"));
		Started.click();

		WebElement Networking = driver.findElement(By.xpath("//*[contains(text(),'Networking')]"));
		Networking.click();
		
		Thread.sleep(5000);

		WebElement Recruiters = driver.findElement(By.xpath("//*[contains(text(),'Find Recruiters')]"));
		String originalWindow = driver.getWindowHandle();
		Recruiters.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Increased wait
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> handles = driver.getWindowHandles();
		List<String> windowHandles = new ArrayList<String>(handles);

		String newWindow = "";
		for (String handle : windowHandles) {
			if (!handle.equals(originalWindow)) {
				newWindow = handle;
				break;
			}
		}
		if (newWindow.isEmpty()) {
			System.out.println("New tab/window did not open within the specified time.");
			driver.quit();
			return;
		}

		driver.switchTo().window(newWindow);

		System.out.println("Switched to new window: " + driver.getTitle());
		
        WebElement element = driver.findElement(By.xpath("//div[@class='HorizontalCard green']"));  
        String actualText = element.getText().replaceAll("[^a-zA-Z0-9]", " ");

        String expectedText = "Saved Searches Once you save your queries they will show up here!";

        if (actualText.equals(expectedText)) {
            System.out.println("Texts match!");
        } else {
            System.out.println("CASE 1: We expected it is logged in automatically Texts do not match. Expected: '" + expectedText + "', Actual: '" + actualText + "'");
        }

        WebElement Feedback = driver.findElement(By.xpath("//button[@aria-label='Feedback - Show survey']"));
        Feedback.click();
        Thread.sleep(5000);
        //CASE 2 FOR FEEDBACK
//        WebElement FeedbackHappy = driver.findElement(By.xpath("//div[@class='css-nsl2qw']"));
//        FeedbackHappy.click();
//        Thread.sleep(5000);
//        WebElement FeedbackNext = driver.findElement(By.xpath("//button[@aria-label='Next question']"));
//        FeedbackNext.click();
//        
//        Thread.sleep(5000);
//        WebElement FeedbackInput = driver.findElement(By.xpath("  //textarea[@type='text']"));
//        FeedbackInput.sendKeys("  ");
//        Thread.sleep(5000);
//        WebElement FeedbackNext2 = driver.findElement(By.xpath("//button[@aria-label='Next question']"));
//        FeedbackNext2.click();
//        
//        WebElement FeedbackClose = driver.findElement(By.xpath("  //button[@kind='primary']"));
//        FeedbackClose.click();
        
        
        
    
      
        
		driver.quit();

	}

}
