package homepage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC003VerifyTodoListDisplay {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gor-pathology.web.app/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Login
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("test@kennect.io");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Qwerty@1234");
		driver.findElement(By.xpath("//span[text()=\"Login\"]")).click();

		WebElement TODO = driver.findElement(By.xpath("//div[text()=\"TODO\"]"));
		TODO.isDisplayed();

		// Validation of TODO Test Profile information
		WebElement ViewPatientDetails = driver.findElement(By.xpath("(//span[text()=\"view\"])[4]"));
		ViewPatientDetails.click();

		// Verifying Patient Name
		WebElement PatientName = driver.findElement(By.xpath("//div[text()=\"pankaj jha\"]"));
		PatientName.isDisplayed();

		// Verifying due date and time of Patient
		WebElement DueDateandTime = driver.findElement(By.xpath("//span[text()=\"2 - 11 - 2023  19:46:39\"]"));
		DueDateandTime.isDisplayed();

		// Verifying Test Request
		WebElement TestText = driver.findElement(By.xpath("//h6[text()=\"Tests\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", TestText);

		WebElement TestName = driver.findElement(By.xpath("//p[text()=\"AFP (ALPHA FETO PROTEINS)\"]"));
		TestName.isDisplayed();

		System.out.println("Passed");

		driver.quit();

	}

}
