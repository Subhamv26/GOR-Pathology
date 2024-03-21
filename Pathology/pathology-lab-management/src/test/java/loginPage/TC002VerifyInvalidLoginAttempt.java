package loginPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC002VerifyInvalidLoginAttempt {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gor-pathology.web.app/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Invalid Login Credentials
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("test@kennect.i");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Qwerty@12");
		driver.findElement(By.xpath("//span[text()=\"Login\"]")).click();

		// Error Message
		WebElement Alert = driver.findElement(By.xpath(
				"//div[text()=\"There is no user record corresponding to this identifier. The user may have been deleted.\"]"));
		Alert.isDisplayed();

		// Ensure that the user remains on the login page
		WebElement Login = driver.findElement(By.xpath("//span[text()=\"Login\"]"));
		Login.isDisplayed();

		System.out.println("Passed");

		driver.quit();

	}

}
