package sailotech.com.EzScheduler.AdminFunctions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sailotech.com.EzScheduler.adminPages.AdminPageRepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;

public class Navigations extends BaseTest{
	WebDriver driver;
	
	public Navigations(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
		
	}
	
	
	public byte[] login() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		
	}
	
public void Navigation_to_Doctor_Queue() throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver, 20); 
	  	AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
	    Actions action = new Actions(driver); 
	    try {
	    wait.until(ExpectedConditions.elementToBeClickable(page.Menu)).click();
	    }catch(Exception e) {
	     wait.until(ExpectedConditions.elementToBeClickable(page.Menu)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(page.DoctorQueue)).click();
	    }
	    wait.until(ExpectedConditions.elementToBeClickable(page.DoctorQueue)).click();

	}

public void navigation_to_unverified_doctors() throws Exception{

    WebDriverWait wait = new WebDriverWait(driver, 10); 
  	AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
    Actions action = new Actions(driver); 
    wait.until(ExpectedConditions.elementToBeClickable(page.unverifiedDoctors)).click();
  
	
}

public void navigation_to_verified_doctors() throws Exception{

    WebDriverWait wait = new WebDriverWait(driver, 10); 
  	AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
    Actions action = new Actions(driver); 
    wait.until(ExpectedConditions.elementToBeClickable(page.verifiedDoctors)).click();

    
	
}
public void navigationToPatientQueue() throws Exception{

    WebDriverWait wait = new WebDriverWait(driver, 10); 
  	AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
    //Actions action = new Actions(driver); 
    wait.until(ExpectedConditions.elementToBeClickable(page.Menu)).click();
    wait.until(ExpectedConditions.elementToBeClickable(page.PatientQueue)).click();
    wait.until(ExpectedConditions.elementToBeClickable(page.elementOnPatientQueue));


    
	
}
public void logout() throws Exception{

    WebDriverWait wait = new WebDriverWait(driver, 10); 
  	AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
    Actions action = new Actions(driver); 
    wait.until(ExpectedConditions.elementToBeClickable(page.Menu)).click();
    wait.until(ExpectedConditions.elementToBeClickable(page.Logout)).click();
   


    
	
}
}
