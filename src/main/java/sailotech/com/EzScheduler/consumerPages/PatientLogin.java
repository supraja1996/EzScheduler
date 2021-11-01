package sailotech.com.EzScheduler.consumerPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PatientLogin {
WebDriver driver;
	
	public PatientLogin(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
		
	}
	
	
	public byte[] login() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	public void patientLogin_Navigation() throws Exception
	{	
		
		WebDriverWait wait = new WebDriverWait(driver, 5); 
    	  	
    	
    	    	PatientRepositoryClass page = new PatientRepositoryClass(driver);
    	    	
    	    	Thread.sleep(2000);
    	    	
    	    
    	
    wait.until(ExpectedConditions.elementToBeClickable(page.buttonLoginRegister)).click();
    
    page.patientLogin.click();
    
    //wait.until(ExpectedConditions.elementToBeClickable(page.patientLogin)).click();
    
	}
	
	public void patientLogin() throws Exception
	{
	WebDriverWait wait = new WebDriverWait(driver, 5); 
    PatientRepositoryClass page = new PatientRepositoryClass(driver);
    Actions action = new Actions(driver); 
    String user_dir = System.getProperty("user.dir");
	FileInputStream fis = new FileInputStream(user_dir+"\\inputFiles\\Patient_Login.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook(fis);



	// Header Sheet
	XSSFSheet s = wb.getSheetAt(0);

	Thread.sleep(2000);

	for (int i = 1; i < s.getLastRowNum() + 1; i++) {

    Thread.sleep(2000);

    wait.until(ExpectedConditions.elementToBeClickable(page.patientUserName)).sendKeys(s.getRow(i).getCell(0).getStringCellValue());
    wait.until(ExpectedConditions.elementToBeClickable(page.patientPassword)).sendKeys(s.getRow(i).getCell(1).getStringCellValue());
    Thread.sleep(2000);
    action.moveToElement(page.patientArrowButton).click().perform();
    Thread.sleep(2000);
//    String strUrl = driver.getCurrentUrl();
//    if(strUrl.equals("https://demo.ezscheduler.io/")) {
//    	action.moveToElement(page.menuOnPatientPage).click().perform();
//        Thread.sleep(2000);
//        action.moveToElement(page.logouButton).click().perform();
//        Thread.sleep(2000);
//		s.getRow(i).createCell(2).setCellValue("Logged in Successfully");
//    	FileOutputStream fout = new FileOutputStream(src);
//    	wb.write(fout);
//    	Thread.sleep(2000);
    	
    	
//    }
//    else {
//    	System.out.println(strUrl);
//    	action.moveToElement(page.patientUserName).doubleClick().perform();
//    	action.sendKeys(Keys.DELETE).perform();
//    	Thread.sleep(2000);
//    	action.moveToElement(page.patientPassword).doubleClick().perform();
//    	action.sendKeys(Keys.DELETE).perform();
//    	s.getRow(i).createCell(2).setCellValue("Invalid credentials");
//    	FileOutputStream fout = new FileOutputStream(src);
//    	wb.write(fout);
//    	Thread.sleep(2000);
//    	
//    }
    //wait.until(ExpectedConditions.elementToBeClickable(page.patientArrowButton)).click();
	/*
	 * wait.until(ExpectedConditions.visibilityOf(page.verificationOfDcotorPage));
	 */
  
	}
    
	}
	
}
   
   
    

    	
	

