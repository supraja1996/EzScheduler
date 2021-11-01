package sailotech.com.EzScheduler.consumerPages;

import java.io.File;
import java.io.FileInputStream;

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

public class SearchDoctorUsingFilter {
WebDriver driver;
int rowvalue;

	
	public SearchDoctorUsingFilter(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
		
	}
	
	
	public byte[] login() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		
	}
	
	public void applyfilters() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 300); 
	  	PatientRepositoryClass page = new PatientRepositoryClass(driver);
	    Actions action = new Actions(driver);
	    String user_dir = System.getProperty("user.dir");
	    File src = new File(user_dir+"\\inputFiles\\Patient_Login.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Header Sheet
		XSSFSheet s = wb.getSheetAt(2);

		Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(page.searchIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(page.allAppointments)).isDisplayed();
       String noofdoctors = wait.until(ExpectedConditions.elementToBeClickable(page.noofDoctors)).getText();
       System.out.println("Before applying filter -" +noofdoctors);
       
       for (int i = 1; i < s.getLastRowNum() + 1; i++) {
    	   String appointmentType = s.getRow(i).getCell(1).getStringCellValue();
    	   wait.until(ExpectedConditions.elementToBeClickable(page.appointmentType(appointmentType))).click();
    	   Thread.sleep(5000);
    	   String slotsAvailability = s.getRow(i).getCell(2).getStringCellValue();
    	   if(slotsAvailability .isBlank() == false) {
//    		 String val = page.slotsAvailable.getAttribute("value");
    		  wait.until(ExpectedConditions.elementToBeClickable(page.slotsAvailable)).sendKeys(slotsAvailability);
    		  String val = page.slotsAvailable.getAttribute("value");
    		  System.out.println(val);
    		  wait.until(ExpectedConditions.elementToBeClickable(page.slotsAvailable)).sendKeys(Keys.DOWN);
    		  wait.until(ExpectedConditions.elementToBeClickable(page.slotsAvailable)).sendKeys(Keys.ENTER);

//             //action.moveToElement(page.slotsAvailable).sendKeys(slots[j]).perform();
//    		 action.sendKeys(Keys.ARROW_DOWN).perform();
//    		 Thread.sleep(2000);
//       		 action.sendKeys(Keys.ENTER).perform();
       		Thread.sleep(2000);
    		}
    	   
    	   String specialities = s.getRow(i).getCell(3).getStringCellValue();
    	   if(specialities.isBlank() == false) {
    		String [] speciality = specialities.split(",");
    		for (int k = 0; k < speciality.length + 1; k++) {
       		 wait.until(ExpectedConditions.elementToBeClickable(page.slotsAvailable)).sendKeys(speciality[k]);	
       		Thread.sleep(2000);
       		 action.sendKeys(Keys.ARROW_DOWN).perform();
       		Thread.sleep(2000);
       		 action.sendKeys(Keys.ENTER).perform();
       		Thread.sleep(2000);
       		}
    		
    	   }
    	   String conditions = s.getRow(i).getCell(4).getStringCellValue();
    	   if(conditions.isBlank() == false) {
    		String [] condition = conditions.split(",");
    		for (int l = 0; l < condition.length + 1; l++) {
       		 wait.until(ExpectedConditions.elementToBeClickable(page.slotsAvailable)).sendKeys(condition[l]);
       		Thread.sleep(2000);
       		action.sendKeys(Keys.ARROW_DOWN).perform();
       		Thread.sleep(2000);
       		 action.sendKeys(Keys.ENTER).perform();
       		Thread.sleep(2000);
       		}
    		
    	   }
    	   String nearby = s.getRow(i).getCell(5).getStringCellValue();
    	   if(nearby.isBlank() == false) {
       		String [] near = conditions.split(",");
       		for (int m = 0; m < near.length + 1; m++) {
          		 wait.until(ExpectedConditions.elementToBeClickable(page.slotsAvailable)).sendKeys(near[m]);
          		Thread.sleep(2000);
          		 action.sendKeys(Keys.ARROW_DOWN).perform();
          		Thread.sleep(2000);
           		 action.sendKeys(Keys.ENTER).perform();
           		Thread.sleep(2000);
          		}
       	   }
    	   String languages = s.getRow(i).getCell(6).getStringCellValue();
    	   if(languages.isBlank() == false) {
          		String [] language = conditions.split(",");
          		for (int n = 0; n < language.length + 1; n++) {
             		 wait.until(ExpectedConditions.elementToBeClickable(page.slotsAvailable)).sendKeys(language[n]);
             		Thread.sleep(2000);
             		 action.sendKeys(Keys.ARROW_DOWN).perform();
             		Thread.sleep(2000);
               		 action.sendKeys(Keys.ENTER).perform();
               		Thread.sleep(2000);
             		}
          	   }
    	   
    	   
       }
       
       
//       wait.until(ExpectedConditions.elementToBeClickable(page.selectedSpeciality)).sendKeys("Primary Care Physician");
//       action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
//       Thread.sleep(2000);
       String noofdoctors1 = wait.until(ExpectedConditions.elementToBeClickable(page.noofDoctors)).getText();
       System.out.println("After applying filter -" +noofdoctors1);
//       // action.moveToElement(page.searchButton).click().perform();
////	    action.moveToElement(page.menu).click().perform();
////		Thread.sleep(2000);
////	    action.moveToElement(page.homeMenu).click().perform();
////	    Thread.sleep(2000);
////		action.moveToElement(page.img).sendKeys(Keys.TAB).perform();
////		Thread.sleep(2000);
//		for (int i = 1; i < s.getLastRowNum() + 1; i++) {
//		
//		Thread.sleep(10000);
//        action.moveToElement(page.slotsAvailable).click().perform();
//        action.sendKeys(s.getRow(i).getCell(0).getStringCellValue()).perform();
//        action.sendKeys(Keys.ARROW_DOWN).perform();
//        action.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(5000);
//        action.moveToElement(page.selectedSpeciality).click().perform();
//        action.sendKeys(s.getRow(i).getCell(1).getStringCellValue()).perform();
//        action.sendKeys(Keys.ARROW_DOWN).perform();
//        action.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(5000);
//        action.moveToElement(page.slectedConditionsTreated).click().perform();
//        action.sendKeys(s.getRow(i).getCell(2).getStringCellValue()).perform();
//        action.sendKeys(Keys.ARROW_DOWN).perform();
//        action.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(5000);
//        action.moveToElement(page.gender).click().perform();
//        action.sendKeys(s.getRow(i).getCell(3).getStringCellValue()).perform();
//        action.sendKeys(Keys.ARROW_DOWN).perform();
//        action.sendKeys(Keys.ENTER).perform();
//        action.moveToElement(page.languagesSpoken).click().perform();
//        action.sendKeys(s.getRow(i).getCell(4).getStringCellValue()).perform();
//        action.sendKeys(Keys.ARROW_DOWN).perform();
//        action.sendKeys(Keys.ENTER).perform(); 
//        Thread.sleep(5000);
//        }
	}
       
}
