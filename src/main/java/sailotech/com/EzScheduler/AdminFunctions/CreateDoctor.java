package sailotech.com.EzScheduler.AdminFunctions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import sailotech.com.EzScheduler.adminPages.AdminPageRepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import utils.DateParsing;

import org.testng.asserts.SoftAssert;
public class CreateDoctor extends BaseTest{
	
	
	String fromDate;
	Date FormattedDate;
	Date FromatedDate;
	String FromDate;
	String FromMonth;
	String FromYear;
	String fromMonth;
	String fromYear;
	String inputDate;
	String monthonCalendar;
	public CreateDoctor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public byte[] login() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		
	}
	
	public void naviagtionToDoctorForm() throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver, 30); 
	  	AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
	    Actions action = new Actions(driver); 
	    wait.until(ExpectedConditions.elementToBeClickable(page.createbutton)).click();
	    
	}
	public void createDoctorProfile() throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver, 10); 
	  	AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
	    Actions action = new Actions(driver); 
	    SoftAssert softAssertion= new SoftAssert();
	    String url = driver.getCurrentUrl();
	    Assert.assertEquals(url, "https://demo.ezscheduler.io/doctorView");
	    String user_dir = System.getProperty("user.dir");
	    FileInputStream fis = null;
		fis = new FileInputStream(
				System.getProperty("user.dir") + envRelativePath("\\inputFiles\\Admin_Login.xlsx"));

		//FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Header Sheet
		XSSFSheet s = wb.getSheetAt(3);
		for (int i = 1; i < s.getLastRowNum() + 1; i++) {
	   	
		wait.until(ExpectedConditions.elementToBeClickable(page.namefield)).sendKeys(s.getRow(i).getCell(1).getStringCellValue());
		wait.until(ExpectedConditions.elementToBeClickable(page.phonefield)).sendKeys(s.getRow(i).getCell(2).getStringCellValue());
		String gender =s.getRow(i).getCell(3).getStringCellValue();
		wait.until(ExpectedConditions.elementToBeClickable(page.gender(gender))).click();
		wait.until(ExpectedConditions.elementToBeClickable(page.emailfield)).sendKeys(s.getRow(i).getCell(4).getStringCellValue());
		String education = s.getRow(i).getCell(5).getStringCellValue();
		String[] degree = education.split(",");
		System.out.println(degree.length != 0);
		if((education.isEmpty()) == false) {
		for (int k = 0; k < degree.length; k++) {
			
			action.moveToElement(page.degreefield).click().perform();
			Thread.sleep(2000);
			action.sendKeys(degree[k]).perform();
			action.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(2000);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			}
		}
		String specializations = s.getRow(i).getCell(6).getStringCellValue();
		String[] specialization = specializations.split(",");
		if((specializations.isEmpty()) == false) {
		for (int k = 0; k < specialization.length; k++) {
		
			action.moveToElement(page.specilaizationsfield).click().perform();
			Thread.sleep(2000);
			action.sendKeys(specialization[k]).perform();
			action.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(2000);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			}
		}
		
		String conditionsTreated = s.getRow(i).getCell(7).getStringCellValue();
		String[] condition = conditionsTreated.split(",");
		if((conditionsTreated.isEmpty()) == false) {

		for (int k = 0; k < condition.length; k++) {
			action.moveToElement(page.conditiontreatedfield).click().perform();
			Thread.sleep(2000);
			action.sendKeys(condition[k]).perform();
			action.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(2000);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			}
		}
		
		String proceduredPerformed = s.getRow(i).getCell(8).getStringCellValue();
		String[] procedure = proceduredPerformed.split(",");
		if((proceduredPerformed.isEmpty()) == false) {
		for (int k = 0; k < procedure.length; k++) {
			
			action.moveToElement(page.proceduresPerformedfield).click().perform();
			Thread.sleep(2000);
			action.sendKeys(procedure[k]).perform();
			action.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(2000);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			}
		}
		String languagesSpoken = s.getRow(i).getCell(9).getStringCellValue();
		String[] Language = languagesSpoken.split(",");
		if((languagesSpoken.isEmpty()) == false) {
		for (int k = 0; k < Language.length; k++) {
			
			action.moveToElement(page.LanguagesSpokenfield).click().perform();
			Thread.sleep(2000);
			action.sendKeys(Language[k]).perform();
			action.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(2000);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			}
		}
		fromDate = s.getRow(i).getCell(10).getStringCellValue();
		DateParsing p = new DateParsing();
		FromDate = p.dateparsing(fromDate);
		System.out.println(FromDate);
		FromMonth = p.monthparsing(fromDate);
		System.out.println(FromMonth);
		FromYear = p.yearparsing(fromDate);
		System.out.println(FromYear);
	try {
      	    wait.until(ExpectedConditions.elementToBeClickable(page.startDate)).click();
      	    wait.until(ExpectedConditions.elementToBeClickable(page.yearSelectionButton)).click();

			//Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(page.year(FromYear))).click();
			//action.moveToElement(page.year(FromYear)).click().perform();
			Thread.sleep(2000);
			action.moveToElement(page.dateOnCalendar);
			monthonCalendar = page.dateOnCalendar.getText();
//			System.out.println("Month on the Calndar" + monthonCalendar);
            fromMonth = p.monthparsing(monthonCalendar);
            fromYear =p.yearparsing(monthonCalendar);

         } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int inpmonth = Integer.parseInt(FromMonth);
		int calmonth = Integer.parseInt(fromMonth);
		if (inpmonth > calmonth) {
			while ((calmonth == inpmonth) == false) {
				try {
					wait.until(ExpectedConditions.elementToBeClickable(page.nextButton)).click();
					//action.moveToElement(page.nextButton).click().perform();
					Thread.sleep(2000);
					action.moveToElement(page.dateOnCalendar);
					String monthonCalendar2 = page.dateOnCalendar.getText();
					fromMonth = p.monthparsing(monthonCalendar2);
					fromYear = p.yearparsing(monthonCalendar2);
					calmonth = Integer.parseInt(fromMonth);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} else {
			while ((calmonth == inpmonth) == false) {
				try {
					action.moveToElement(page.previousButton).click().perform();
					Thread.sleep(2000);
					action.moveToElement(page.dateOnCalendar);
					String monthonCalendar1 = page.dateOnCalendar.getText();
					//System.out.println("Month on the Calendar " + monthonCalendar1);
                    fromMonth = p.monthparsing(monthonCalendar1);
                    fromYear = p.yearparsing(monthonCalendar1);
					calmonth = Integer.parseInt(fromMonth);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		action.moveToElement(page.Date(FromDate)).click().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(page.consultationfeesfield)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(page.consultationfeesfield)).sendKeys(s.getRow(i).getCell(11).getStringCellValue());
	    String videoconsultation = s.getRow(i).getCell(12).getStringCellValue();
	    wait.until(ExpectedConditions.elementToBeClickable(page.videoConsultation(videoconsultation))).click();
		action.moveToElement(page.saveButton).click().perform();
		try {
			String message = wait.until(ExpectedConditions.elementToBeClickable(page.alertMessage)).getText();
			 s.getRow(i).createCell(13).setCellValue(message);
			}catch(Exception exp) {
				try {
					String message1 =wait.until(ExpectedConditions.elementToBeClickable(page.degreeRequired)).getText();
					 s.getRow(i).createCell(13).setCellValue(message1);
				}catch(Exception exp1) {
					try {
						String message2 =wait.until(ExpectedConditions.elementToBeClickable(page.experienceRequired)).getText();
					 s.getRow(i).createCell(13).setCellValue(message2);
					}catch(Exception exp2) {
						try {
						String message3 = wait.until(ExpectedConditions.elementToBeClickable(page.nameRequired)).getText();
						 s.getRow(i).createCell(13).setCellValue(message3);
						}catch(Exception exp3) {
							try {
							String message4 = wait.until(ExpectedConditions.elementToBeClickable(page.validMobileNumber)).getText();
							 s.getRow(i).createCell(13).setCellValue(message4);
							}catch(Exception exp4) {
								try {
								String message5 = wait.until(ExpectedConditions.elementToBeClickable(page.invalidEmailAddress)).getText();
								 s.getRow(i).createCell(13).setCellValue(message5);
								}catch(Exception e) {
									String message6 = wait.until(ExpectedConditions.elementToBeClickable(page.experienceRequired)).getText();
									 s.getRow(i).createCell(13).setCellValue(message6);
								}
							}
						}
					}
					}
			}
		//Thread.sleep(2000);
	
//		String message = wait.until(ExpectedConditions.elementToBeClickable(page.alertMessage)).getText();
//        s.getRow(i).createCell(12).setCellValue(message);
		FileOutputStream fout = null;
		fout = new FileOutputStream(
				System.getProperty("user.dir") + envRelativePath("\\inputFiles\\Admin_Login.xlsx"));

       // FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
		wb.write(fout);
		 driver.navigate().refresh();
		 Thread.sleep(5000);
//		softAssertion.assertEquals(message, "Physicican Saved");
		
	}

		}
	   
	    
	}
		



