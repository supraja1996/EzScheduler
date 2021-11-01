package sailotech.com.EzScheduler.AdminFunctions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import sailotech.com.EzScheduler.adminPages.AdminPageRepositoryClass;

public class HomePageofEzScheduler {
	WebDriver driver;
	public HomePageofEzScheduler(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
		
	}
	
	
	public byte[] login() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		
	}
	public void verifyHomePage() throws Exception{
	WebDriverWait wait = new WebDriverWait(driver, 30); 
  	AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
    Actions action = new Actions(driver); 
    String url = driver.getCurrentUrl();
    Assert.assertEquals(url, "https://demo.ezscheduler.io/");
	}
}
