package sailotech.com.EzScheduler.AdminFunctions;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import sailotech.com.EzScheduler.adminPages.AdminPageRepositoryClass;

public class ViewDoctor {
	
WebDriver driver;

int rval = 1;
String s1 =null;
int rownum =1;
int colnum =1;
int flag = 1;
	
	public ViewDoctor(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
		
	}
	
	
	public byte[] login() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		
	}
	
	public void viewVerifiedDoctorProfile() throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver, 10); 
	  	AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
	    Actions action = new Actions(driver);
	    String rows = page.noofRowsVerified.getText();
		int rownumb = Integer.parseInt(rows);
		System.out.println("No.of rows" + rows);
//	    List <WebElement> rowList = page.verifiedadminTable.findElements(By.tagName("tr"));
//		   int row_count = rowList.size();
//		   System.out.println(row_count);
		  
		   String user_dir = System.getProperty("user.dir");
			FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			// Header Sheet
			XSSFSheet s = wb.getSheetAt(2);

			Thread.sleep(2000);

			for (int i = 1; i < s.getLastRowNum() + 1; i++) {
				while (flag == 1) {
				 int rowval = 1;
		   outer: for(int row = 0; row < rownumb; row++) {
			   
			   List<WebElement> rowList = page.verifiedadminTable.findElements(By.tagName("tr"));
				int row_count = rowList.size();
				Thread.sleep(2000);			   
			   List <WebElement> columnList = rowList.get(row).findElements(By.tagName("td"));
			   int column_count = columnList.size();
			   //System.out.println("Number of cells In Row " + rowval + " are " + column_count);
			   //rownum = row;
			   if(rowList.isEmpty()==false) {
			   for(int column = 1; column<column_count; column++) {
				   s1 = page.verifiedcellData(rowval, column).getText();
				   //System.out.println("Cell Value of row number " + rowval + " and column number " + column + " Is " + s1);
					   if(s1.contains(s.getRow(i).getCell(0).getStringCellValue())== true) {
						   
						  //action.moveToElement(page.editButtonforUnverified(row)).click().perform();
						  //System.out.println(rownumb);
						  rownumb = rowval;
						 wait.until(ExpectedConditions.elementToBeClickable(page.viewButtonforVerified(rownumb))).click();
						  Thread.sleep(2000);
						  flag=0;
						  break outer;
//						   action.moveToElement(page.editButtonforUnverified(rownum)).click().perform();
//						   Thread.sleep(2000);
//						   action.moveToElement(page.yesVerifyDoctor).click().perform();
//						   Thread.sleep(2000);
//						   action.moveToElement(page.saveProfile).click().perform();
						   
						  
					   }
					 
			      }  
			        rowval= rowval+1;
			   }
		   }
			if (flag == 1) {
				try {
					page.verifiedNextButton.click();
					flag = 1;
				}
				catch(Exception e) {
					System.out.println("The record is not available");	
				}
			}
				
			}
			
		}
		}
		
	    
	}
	


