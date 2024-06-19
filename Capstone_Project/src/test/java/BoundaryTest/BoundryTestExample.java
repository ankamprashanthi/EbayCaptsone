package BoundaryTest;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BoundryTestExample {
	@Test
	public static void check() {
		
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://signin.ebay.com/signin/?sgfl=lgp");
        
        // Scenario: Test boundary values for a numeric input field
        WebElement username = driver.findElement(By.xpath("//input[@name='userid']"));
        username.sendKeys("p");
        username.clear();
        username.sendKeys("this will accept only 64 characters after 64 characters it won't accept");
        
        
       
    }
}