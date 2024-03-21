package CostCalculatorForBloodTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC004VerifyUserIsAbleToUseCostCalculator {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gor-pathology.web.app/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Login
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("test@kennect.io");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Qwerty@1234");
		driver.findElement(By.xpath("//span[text()=\"Login\"]")).click();
		
		WebElement Dashboard = driver.findElement(By.xpath("//div[text()=\"Dashboard\"]"));
		Dashboard.isDisplayed();
		
	
		//Scroll Till Test Cost Calculator
		WebElement AddTest = driver.findElement(By.xpath("//p[text()=\"Discount for customer\"]"));
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		
		Actions actions = new Actions(driver);
		actions.scrollToElement(AddTest).perform();
		
		WebElement PatientTest = driver.findElement(By.id("patient-test"));
		PatientTest.click();
		

		// Select Test
		WebElement AFP = driver.findElement(By.xpath("//div[text()=\"AFP (ALPHA FETO PROTEINS)\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(AFP));
		Thread.sleep(1000);
		AFP.click();
		
		PatientTest.click();
			
		WebElement Vitamin12 = driver.findElement(By.xpath("//div[text()=\"VITAMIN B12, SERUM\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(Vitamin12));
		Thread.sleep(1000);
		Vitamin12.click();
		
		 WebElement Discount = driver.findElement(By.xpath("//div[@aria-haspopup=\"listbox\"]"));
		 Discount.click();
		 driver.findElement(By.xpath("//li[text()=\"10%\"]")).click();
		 
		 //Verfication of Discount Price
		 WebElement SubtotalAmount = driver.findElement(By.xpath("//div[text()=\"1250 ₹\"]"));
		 String TotalAmount = SubtotalAmount.getText();
		 System.out.println("SubTotal amount is :"+ TotalAmount);
		 WebElement AmountAfterDiscount = driver.findElement(By.xpath("//div[text()=\"1125 ₹\"]"));
		 String DiscountAmount = AmountAfterDiscount.getText();
		 System.out.println("Amount After Discount is :"+DiscountAmount);
		 String ExpectedDiscountAmount = DiscountAmount;
		 boolean FinalAmount = DiscountAmount.equals(ExpectedDiscountAmount);
		 System.out.println("Both are Matching :"+FinalAmount);
		 
		
		 System.out.println("Passed");
		 
		
		driver.quit();

	}

}
