package loginPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC001VerifySuccessfullLogin {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gor-pathology.web.app/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//Login
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("test@kennect.io");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Qwerty@1234");
		driver.findElement(By.xpath("//span[text()=\"Login\"]")).click();
		
		//Verification of Dashboard Page
		WebElement Dashboard = driver.findElement(By.xpath("//div[text()=\"Dashboard\"]"));
		Dashboard.isDisplayed();
		System.out.println("Passed");
		
		
		driver.quit();
		
		
		
		
		
		

	}

}
