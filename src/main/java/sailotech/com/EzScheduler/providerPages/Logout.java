package sailotech.com.EzScheduler.providerPages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import sailotech.com.EzScheduler.basePages.BaseTest;

public class Logout extends BaseTest{
	
	
	
	 public Logout(WebDriver driver) { 
		 this.driver = driver;
	 PageFactory.initElements(driver, this); 
	 }
	 
	 
	 
	public byte[] doctorLogout() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public void dcotor_logout() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 5);

		Repository page = new Repository(driver);

		Actions action = new Actions(driver);
		
		action.moveToElement(page.menu).click().perform();
		Thread.sleep(2000);
		action.moveToElement(page.logoutMenu).click().perform();
		doctorLogout();
	}
}
