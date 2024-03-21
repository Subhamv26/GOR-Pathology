package AddingPatientsandCreatingTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC005VerifyUserIsAbleToAddPatientsAndCreateTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gor-pathology.web.app/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Login
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("test@kennect.io");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Qwerty@1234");
		driver.findElement(By.xpath("//span[text()=\"Login\"]")).click();

		WebElement Dashboard = driver.findElement(By.xpath("//div[text()=\"Dashboard\"]"));
		Dashboard.isDisplayed();

		WebElement Patients = driver.findElement(By.xpath("//span[text()=\"Patients\"]"));
		Patients.click();

		WebElement AddPatients = driver.findElement(By.xpath("(//span[text()=\"Add Patient\"])[1]"));
		AddPatients.click();

		WebElement AddPatientPage = driver.findElement(By.xpath("//div[text()=\"Add Patient\"]"));
		AddPatientPage.isDisplayed();

		// ContactName
		WebElement PatientName = driver.findElement(By.xpath("//input[@name=\"name\"]"));
		PatientName.sendKeys("Sishu");

		WebElement PatientEmail = driver.findElement(By.xpath("//input[@name=\"email\"]"));
		PatientEmail.sendKeys("sishu@gmail.com");

		WebElement PatientPhone = driver.findElement(By.name("phone"));
		PatientPhone.sendKeys("9878909876");

		Actions actions = new Actions(driver);
		WebElement GenerateDetails = driver.findElement(By.xpath("(//span[text()=\"General Details\"])[2]"));
		actions.scrollToElement(GenerateDetails).perform();
		GenerateDetails.click();

		// Secondary Details of Patient
		WebElement SecondaryDetails = driver.findElement(By.xpath("//h5[text()=\"Secondary details of Sishu\"]"));
		SecondaryDetails.isDisplayed();

		WebElement Height = driver.findElement(By.xpath("//input[@name=\"height\"]"));
		Height.sendKeys("157");

		WebElement Weight = driver.findElement(By.xpath("//input[@name=\"weight\"]"));
		Weight.sendKeys("65");

		WebElement Gender = driver.findElement(By.id("mui-component-select-gender"));
		Gender.click();

		WebElement Male = driver.findElement(By.xpath("//li[text()=\"Male\"]"));
		Male.click();

		WebElement Age = driver.findElement(By.name("age"));
		Age.sendKeys("27");

		// Blood Pressure Details of Patient
		WebElement systolicBP = driver.findElement(By.name("systolic"));
		systolicBP.sendKeys("100");

		WebElement diastolicBP = driver.findElement(By.name("diastolic"));
		diastolicBP.sendKeys("90");

		WebElement AddTest = driver.findElement(By.xpath("(//span[text()=\"Add Tests\"])[2]"));
		actions.scrollToElement(AddTest).perform();
		AddTest.click();

		AddTest = driver.findElement(By.id("patient-test"));
		AddTest.click();

		// Adding Test for Patient

		WebElement AFP = driver.findElement(By.xpath("//div[text()=\"AFP (ALPHA FETO PROTEINS)\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(AFP));
		Thread.sleep(1000);
		AFP.click();

		wait.until(ExpectedConditions.elementToBeClickable(AddTest));
		AddTest.click();

		WebElement Vitamin = driver.findElement(By.xpath("//div[text()=\"VITAMIN B12, SERUM\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(Vitamin));
		Thread.sleep(1000);
		Vitamin.click();

		WebElement Discount = driver.findElement(By.xpath("//em[text()=\"None\"]"));
		Discount.click();

		WebElement DiscountPercent = driver.findElement(By.xpath("//li[text()=\"10%\"]"));
		DiscountPercent.click();

		WebElement Labs = driver.findElement(By.id("patient-tests-labs"));
		Labs.click();

		WebElement HealthCarePathology = driver.findElement(By.xpath("//*[@id=\"patient-tests-labs-option-0\"]/div"));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(HealthCarePathology));
		HealthCarePathology.click();

		WebElement RecommendTest = driver.findElement(By.xpath("//input[@name=\"doctor_name\"]"));
		RecommendTest.click();

		WebElement Test = driver.findElement(By.xpath("//li[text()=\"kiran\"]"));
		Thread.sleep(1000);
		Test.click();

		WebElement DoctorCommission = driver.findElement(By.id("mui-component-select-doctor_commission"));
		DoctorCommission.click();

		WebElement DoctorsCommissionPercent = driver.findElement(By.xpath("//li[text()=\"20%\"]"));
		DoctorsCommissionPercent.click();

		WebElement ScrollTillEquipment = driver.findElement(By.xpath("//td[text()=\"Click on add button to add equipment.\"]"));
		actions.scrollToElement(ScrollTillEquipment);

		WebElement AddEquipment = driver.findElement(By.xpath("//span[text()=\"add_box\"]"));
		actions.scrollToElement(AddEquipment).perform();
		actions.doubleClick(AddEquipment).perform();

		WebElement EquipmentName = driver.findElement(By.xpath("//div[@aria-label=\"Eqipment Name\"]"));
		EquipmentName.click();

		WebElement Injection = driver.findElement(By.xpath("//li[text()=\"injection\"]"));
		Injection.click();

		WebElement Check = driver.findElement(By.xpath("//span[text()=\"check\"]"));
		Check.click();

		WebElement Subtotal = driver.findElement(By.xpath("//div[text()=\"1250 ₹\"]"));
		String ST = Subtotal.getText();
		System.out.println("Subtotal amount is :" + ST);

		WebElement AfterDiscount = driver.findElement(By.xpath("//div[text()=\"1125 ₹\"]"));
		String AD = AfterDiscount.getText();
		System.out.println("After Discount price is :" + AD);
		String ExpectedAmount = AD;
		boolean FinalAmount = AD.equals(ExpectedAmount);
		System.out.println(FinalAmount);

		WebElement AddThePatient = driver.findElement(By.xpath("//span[text()=\"Add Patient\"]"));
		actions.scrollToElement(AddThePatient).perform();
		AddThePatient.click();
		
		//Verifying Patient Added Successfully Popup
		WebElement Popup = driver.findElement(By.xpath("//div[text()=\"Patient added successfully.\"]"));
		wait.until(ExpectedConditions.visibilityOf(Popup));
		Popup.isDisplayed();
		
		//Verifying Previous Patient Name and Present Patient Name in the List of Patients
		WebElement AddedPatientName = driver.findElement(By.xpath("//td[text()=\"Sishu\"]"));
		String PresentPatientName = AddedPatientName.getText();
		System.out.println(PresentPatientName);
		String PatientNameAddedBefore = "Sishu";
		boolean BothNameMatched = PresentPatientName.equals(PatientNameAddedBefore);
		System.out.println("Both the Names are Matching :"+BothNameMatched);
		
		wait.until(ExpectedConditions.visibilityOf(AddedPatientName));
		AddedPatientName.isDisplayed();
		
////		Verifying SR number of Patient
////		Example: Locating a dynamic element with partial attribute value using XPath
//		String partialAttributeValue = "243";
//		WebElement PresentSRname = driver.findElement( By.xpath("//td[text()=\"243\"] "+partialAttributeValue));
//		WebElement element = PresentSRname;
//		String PresentValue = PresentSRname.getText();
//		System.out.println(PresentValue);
		
//		By xpathLocator = By.xpath("//input[contains(@id, '" + partialAttributeValue + "')]");

		System.out.println("Passed");
		
		driver.quit();

	}

}
