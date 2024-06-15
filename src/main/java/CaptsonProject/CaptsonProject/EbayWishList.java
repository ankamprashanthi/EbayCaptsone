package CaptsonProject.CaptsonProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EbayWishList {
WebDriver driver=null;
By wishCheck=By.xpath("//button[@id='watchBtn_btn_1']");

public EbayWishList(WebDriver driver) {
	this.driver = driver;
}

public WebElement wishCheck() {
	return driver.findElement(wishCheck);
}
}
