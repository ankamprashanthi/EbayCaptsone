package CaptsonProject.CaptsonProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EbayWishList {
WebDriver driver=null;
By colorOption=By.xpath("//select[@selectboxlabel='Color']");

public EbayWishList(WebDriver driver) {
	this.driver = driver;
}

public WebElement colorOption() {
	return driver.findElement(colorOption);
}
public void selectColor(String color) {
    Select dropdown = new Select(colorOption());
    dropdown.selectByVisibleText(color);
}
}
