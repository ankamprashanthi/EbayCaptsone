package CaptsonProject.CaptsonProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayCategory {
	WebDriver driver=null;
	By categories=By.id("gh-shop-a");
	By catName=By.linkText("Electronics");
	By mobile=By.linkText("Cell Phones, Smart Watches & Accessories");

	
	public EbayCategory(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement categories() {
		return driver.findElement(categories);
	}
	public WebElement catName() {
		return driver.findElement(catName);
	}
	public WebElement mobile() {
		return driver.findElement(mobile);
	}
	
}
