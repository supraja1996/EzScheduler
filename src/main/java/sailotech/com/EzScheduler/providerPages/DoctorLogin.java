package sailotech.com.EzScheduler.providerPages;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class DoctorLogin {

	WebDriver driver;
	
	
	  public DoctorLogin(WebDriver d) { this.driver = d;
	  PageFactory.initElements(d, this);
	  
	 }
	  
	 
	
	public byte[] NavigateToDoctorLogin(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	public void doctorLogin_Navigation() throws Exception
	{	
		
		WebDriverWait wait = new WebDriverWait(driver, 5); 
    	  	
    	
    	    	Repository page = new Repository(driver);
    	    	
    	    	Thread.sleep(2000);
    	    	
    	    
    	
    wait.until(ExpectedConditions.elementToBeClickable(page.buttonLoginRegister)).click();
    page.doctorLoginButton.click();
    wait.until(ExpectedConditions.elementToBeClickable(page.doctorLoginButton)).click();
    
	}
	
	public byte[] Login(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	public void doctorLogin() throws Exception
	{
    WebDriverWait wait = new WebDriverWait(driver, 5); 
	Actions action = new Actions(driver);
    Repository page = new Repository(driver);
    String user_dir = System.getProperty("user.dir");
	FileInputStream fis = new FileInputStream(user_dir+"\\inputFiles\\Doctor_Login.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	// Header Sheet
	XSSFSheet s = wb.getSheetAt(0);

	Thread.sleep(2000);

for (int i = 1; i < s.getLastRowNum() + 1; i++) {

	wait.until(ExpectedConditions.elementToBeClickable(page.doctorUsername)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(page.doctorUsername)).sendKeys(s.getRow(i).getCell(1).getStringCellValue());
	wait.until(ExpectedConditions.elementToBeClickable(page.doctorPassword)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(page.doctorPassword)).sendKeys(s.getRow(i).getCell(2).getStringCellValue());
    wait.until(ExpectedConditions.elementToBeClickable(page.loginArrow)).click();
    Thread.sleep(2000);
    try {
   String Url = driver.getCurrentUrl();
   if(Url.equals("https://demo.ezscheduler.io/myschedule")) {
	   s.getRow(i).createCell(3).setCellValue(Url);
	   s.getRow(i).createCell(5).setCellValue("Success");
      FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Doctor_Login.xlsx");
		wb.write(fout);   
   }
   else {
	   s.getRow(i).createCell(3).setCellValue(Url);
	   s.getRow(i).createCell(5).setCellValue("Fail");
      FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Doctor_Login.xlsx");
		wb.write(fout);   
   }
   
//    
    } catch(Exception e) {
    	e.printStackTrace();
    }

	}
	} 
    
	public void invalidUsername() throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver, 5); 
		Actions action = new Actions(driver);
	    Repository page = new Repository(driver);
	    String user_dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(user_dir+"\\inputFiles\\Doctor_Login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Header Sheet
		XSSFSheet s = wb.getSheetAt(0);

		Thread.sleep(2000);

		for (int i = 1; i < s.getLastRowNum() + 1; i++) {

	    try {
	    wait.until(ExpectedConditions.elementToBeClickable(page.doctorUsername)).sendKeys(s.getRow(i).getCell(1).getStringCellValue());
	    wait.until(ExpectedConditions.elementToBeClickable(page.doctorPassword)).sendKeys(s.getRow(i).getCell(2).getStringCellValue());
	    wait.until(ExpectedConditions.elementToBeClickable(page.loginArrow)).click();
	    Thread.sleep(2000);
	    String Url = driver.getCurrentUrl();
	    s.getRow(i).createCell(3).setCellValue(Url);
	    FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Doctor_Login.xlsx");
		wb.write(fout);
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }

		}

		
	}

    	
	}
