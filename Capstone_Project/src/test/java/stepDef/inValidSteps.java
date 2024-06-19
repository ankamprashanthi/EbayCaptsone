package stepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class inValidSteps {
	WebDriver driver=null;
	public static ExtentTest test; 
	public static ExtentReports report;
	
	@Given("User is on google page")
	public void user_is_on_google_page() {
		report = new ExtentReports("./target/ExtentReportResultsInvalid.html");
	    test = report.startTest("InvalidCreditinals"); 
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://signin.ebay.com/signin/?sgfl=lgp");
	}
	
	@When("User enters username as {string} and {string}")
	public void user_enters_username_as_and(String email, String password) throws InterruptedException {
		test.log(LogStatus.INFO, "User should Not be able login to application with invalid credentials");
		driver.findElement(By.xpath("//input[@name='userid']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@id='signin-continue-btn']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#pass")));
        pass.sendKeys(password);
        
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);

        driver.findElement(By.xpath("//button[@id='sgnBt']")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//p[@id='errormsg']"));
        if(errorMessage.isDisplayed()) {
            System.out.println("Negative test for invalid credentials passed.");
        } else {
            System.out.println("Negative test failed. Expected error message not displayed.");
        }
        test.log(LogStatus.PASS, "User Failed to login to the application");
	}

	@Then("Usershould not able to login")
	public void usershould_not_able_to_login() {
		System.out.println("User should not be able to login with invalid credentials");
	}
	
	@Then("valid details should be given by user")
	public void valid_details_should_be_given_by_user() throws InterruptedException {
       Thread.sleep(2000);
       report.endTest(test);
	      report.flush();
	   driver.quit();

	}

}