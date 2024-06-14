package CaptsonProject.CaptsonProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbaySearch {
	WebDriver driver = null;

	By search = By.xpath("//input[@id='gh-ac']");
	By inputtext=By.id("gh-btn");
	By product=By.xpath("//li[@id='item428884ef9f']//img[@alt='1.6 Inch IPS Display Long Standby Watches HD Voice Call Waterproof Smartwatch']");
	
	public EbaySearch(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement search() {
		return driver.findElement(search);
	}
	
	public WebElement inputtext() {
		return driver.findElement(inputtext);
	}
	public WebElement product() {
		return driver.findElement(product);
	}
	

}
