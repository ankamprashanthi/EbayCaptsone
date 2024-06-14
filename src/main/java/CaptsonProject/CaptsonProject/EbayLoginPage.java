package CaptsonProject.CaptsonProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayLoginPage {
	WebDriver driver = null;
	
	By email = By.name("userid");
	By next=By.id("signin-continue-btn");
	By password = By.id("pass");
	By login = By.xpath("//button[@id='sgnBt']");
	/*
	 * By signup = By.xpath(""); 
	 * By home = By.xpath("");//span[@id='gh-ug']//a[contains(text(),'Sign in')]
	 */
	
	public EbayLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement email() {
		return driver.findElement(email);
	}
	public WebElement next() {
		return driver.findElement(next);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement login() {
		return driver.findElement(login);
	}
	

}
