package CaptsonProject.CaptsonProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EbayLogin {
	WebDriver driver=null;
	public static ExtentTest test; 
	  public static ExtentReports report;
	  
	  @BeforeClass 
	  public static void startTest() { 
		 
		  report = new ExtentReports("./ExtentReportResults.html");
		  test = report.startTest("ExtentJPetStore"); 
	  }
	 

	@Test
	@Parameters("browser")
    public void invoke(String browser) throws IOException {
        FileInputStream fs = new FileInputStream("./data.properties");
        Properties data = new Properties();
        data.load(fs);
 
        if (browser.toLowerCase().equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.toLowerCase().equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.toLowerCase().equals("firefox")) {
        	WebDriverManager.firefoxdriver().driverVersion("0.31.0").setup();
            driver = new FirefoxDriver();
        } else {
        	System.out.println("\nEnter chrome,edge or firefox only");
            throw new IllegalArgumentException("Invalid browser type: " + browser);
        }
 
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(data.getProperty("url"));
    }
	@Test(dependsOnMethods="invoke")
	public void login() throws IOException, InterruptedException {
		
		FileInputStream fs = new FileInputStream("./data.properties");
		Properties data = new Properties();
		data.load(fs);
		
		//driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
		
		EbayLoginPage eLogin = new EbayLoginPage(driver);
		eLogin.email().sendKeys(data.getProperty("email"));
		//eLogin.password().clear();
		eLogin.next().click();
		eLogin.password().sendKeys(data.getProperty("password"));
		eLogin.login().click();
		//driver.findElement(By.id("passkeys-cancel-btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(1000);
		ScreenShots();
		
		EbayCategory eCat=new EbayCategory(driver);
		eCat.categories().click();
		eCat.catName().click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		eCat.mobile().click();
		
		EbaySearch esearch = new EbaySearch(driver);
		esearch.search().sendKeys(data.getProperty("search"));
		esearch.inputtext().click();
		esearch.product().click();
		
		/*
		 * Set<String> windowHandles = driver.getWindowHandles(); Iterator<String>
		 * iterator = windowHandles.iterator(); String originalWindow = iterator.next();
		 * String newWindow = iterator.next(); driver.switchTo().window(newWindow);
		 */
        // Initialize EbayWishList
		 ArrayList<String> lst=new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(lst.get(1));
		 EbayWishList elist = new EbayWishList(driver); 
		 ScreenShots();
		 elist.colorOption().click();
		 elist.selectColor("Black");
		 
		 


	}
	public void ScreenShots() throws IOException {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("./Screenshots/"+"watch-"+System.currentTimeMillis()+".png"));
		System.out.println("Screenshot Successfully added to Images");
	}
		
    
}
