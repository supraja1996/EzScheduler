package sailotech.com.EzScheduler.providerPages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
	
	WebDriver driver;
	
	 public Logout(WebDriver d) { 
		 this.driver = d;
	 PageFactory.initElements(d, this); 
	 }
	 
	 
	 
	public byte[] login(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public void dcotor_logout() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 5);

		Repository page = new Repository(driver);

		Actions action = new Actions(driver);
		
		action.moveToElement(page.menu).click().perform();
		Thread.sleep(2000);
		action.moveToElement(page.logoutMenu).click().perform();
		
	}
}
