package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class inValidSteps {
	WebDriver driver=null;

	@Given("User is on google page")
	public void user_is_on_google_page() {
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://signin.ebay.com/signin/?sgfl=lgp");
	}
	
	@When("User enters username as {string} and {string}")
	public void user_enters_username_as_and(String email, String password) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='userid']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@id='signin-continue-btn']")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("pass")).sendKeys(password);

        driver.findElement(By.xpath("//button[@id='sgnBt']")).click();
	}

	@Then("Usershould not able to login")
	public void usershould_not_able_to_login() {
		System.out.println("User should not be able to login with invalid credentials");
	}
	
	@Then("valid details should be given by user")
	public void valid_details_should_be_given_by_user() throws InterruptedException {
       Thread.sleep(2000);
	   driver.quit();

	}

}