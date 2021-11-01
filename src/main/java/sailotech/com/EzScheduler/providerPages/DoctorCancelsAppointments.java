package sailotech.com.EzScheduler.providerPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DoctorCancelsAppointments {
	WebDriver driver;
	int rowvalue =1;
	
	public DoctorCancelsAppointments(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
		
	}
	
	
	public byte[] login() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		
	}
	public void cancel_open_slots() throws Exception{
		 WebDriverWait wait = new WebDriverWait(driver, 10); 
		 Repository page= new Repository(driver);
		 Actions action = new Actions(driver); 
		
		 String openslots_num = page.openSlots.getText();
		 int i=Integer.parseInt(openslots_num);  
		 page.openSlots.click();

			for (int j = 1; j < i; j++) {
				
				 String s =page.openslotcancel(j).getText();
				 if(s.contains("05:10 PM-")) {
				 System.out.println(s);
				 rowvalue = j;
				 break;
				 }
					}
		 System.out.println(rowvalue);
		 Thread.sleep(2000);
		 action.sendKeys(Keys.ARROW_DOWN).perform();
		action.moveToElement(page.opecancelbutton(rowvalue)).click().perform();
		Thread.sleep(2000);
		action.moveToElement(page.dialogbox);
		Thread.sleep(2000);
		action.moveToElement(page.reasonForCancelation).click().perform();
		action.sendKeys("test").perform();
		Thread.sleep(2000);
		action.moveToElement(page.yesForCancelation).click().perform();
		 
		
	}

}
