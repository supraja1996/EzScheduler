package sailotech.com.EzScheduler.AdminFunctions;

//import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sailotech.com.EzScheduler.adminPages.AdminPageRepositoryClass;
//import org.testng.Assert;
//import org.testng.asserts.SoftAssert;
import sailotech.com.EzScheduler.adminPages.RepositoryClass;
//import ru.yandex.qatools.allure.annotations.Attachment;
import sailotech.com.EzScheduler.basePages.BaseTest;
import utils.DateParsing;

public class AdminFunctions extends BaseTest {

	
	WebDriverWait wait = new WebDriverWait(driver, 30);

	public void adminLogin_Navigation(WebDriver driver)  throws Throwable{

try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(RepositoryClass.buttonLoginRegister));
		wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.buttonLoginRegister)).click();
		System.out.println("Clicked on Login/Register Button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(RepositoryClass.adminLogin));
		wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.adminLogin)).click();
		System.out.println("Clicked on Admin Login Button");

	}catch(Throwable e) {
		System.out.println("Unable to Load the page");
	}
	}
	public void adminLogin() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Actions action = new Actions(driver);
		String user_dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Header Sheet
		XSSFSheet s = wb.getSheetAt(0);

		Thread.sleep(2000);

		for (int i = 1; i < s.getLastRowNum() + 1; i++) {

			try {
				
                wait.until(ExpectedConditions.visibilityOfElementLocated(RepositoryClass.adminUserName));
				wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.adminUserName))
						.sendKeys(s.getRow(i).getCell(1).getStringCellValue());
				System.out.println("Entered Username");
                wait.until(ExpectedConditions.visibilityOfElementLocated(RepositoryClass.adminPassword));
				wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.adminPassword))
						.sendKeys(s.getRow(i).getCell(2).getStringCellValue());
                System.out.println("Entered Password");
				wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.adminSignIN)).click();
				Thread.sleep(1000);
				String strUrl = driver.getCurrentUrl();
				if (strUrl.equals("https://demo.ezscheduler.io/doctorQueue")) {

					s.getRow(i).createCell(3).setCellValue(strUrl);
					// s.getRow(i).createCell(5).setCellValue("Success");
					FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
					wb.write(fout);
				} else {
					s.getRow(i).createCell(3).setCellValue(strUrl);
					// s.getRow(i).createCell(5).setCellValue("Success");
					FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
					wb.write(fout);
				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
	}
	
	public void doctorQueueNavigation(WebDriver driver) throws Exception{
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(RepositoryClass.Menu));
			wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.Menu)).click();
			System.out.println("Menu is clicked");
			wait.until(ExpectedConditions.visibilityOfElementLocated(RepositoryClass.DoctorQueue));
			wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.DoctorQueue)).click();
			System.out.println("DoctorQueue is clicked");
		}catch(Exception e) {
			
		}
		
	}
	
	public void patientQueueNaviagtion(WebDriver driver) throws Exception {
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(RepositoryClass.Menu));
			wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.Menu)).click();
			System.out.println("Menu is clicked");
			wait.until(ExpectedConditions.visibilityOfElementLocated(RepositoryClass.PatientQueue));
			wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.PatientQueue)).click();
			System.out.println("PatientQueue is clicked");
		    wait.until(ExpectedConditions.visibilityOfElementLocated(RepositoryClass.elementOnPatientQueue));

			
		}catch(Exception e) {
			
		}
	}

	public void unverifiedDoctorQueueNavigation(WebDriver driver) {
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(RepositoryClass.unverifiedDoctors));
			wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.unverifiedDoctors)).click();
			System.out.println("unverifiedDoctors is clicked");
		}catch(Exception e) {
			
		}
	}
	public void verifiedDoctorQueueNavigation(WebDriver driver) {
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(RepositoryClass.verifiedDoctors));
			wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.verifiedDoctors)).click();
			System.out.println("verifiedDoctors is clicked");
		}catch(Exception e) {
			
		}
	}
		public void verifyDoctor(WebDriver driver) throws Exception {
		int rval = 1;
		
		int rownum = 1;
		int colnum = 1;
		int flag = 1;
		Date FormattedDate;
		Date FormatedDate;
		Date FormattedMonth;
		String MonthonCalendar;
		String Month;
		String Year;
		String FromDate;
		String FromMonth;
		String FromYear;
		String ToDate;
		String ToMonth;
		String ToYear;
		int month;
		int frommonth;
		int tomonth;
	
		Actions action = new Actions(driver);
		String user_dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Header Sheet
		XSSFSheet s = wb.getSheetAt(1);

		Thread.sleep(2000);
		DateParsing p = new DateParsing();
		AdminFunctions adminfunctions =new AdminFunctions();
		//Navigations n = new Navigations(driver);
		wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.noofRowsinUnverified));
		//action.moveToElement();
		String rows = wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.noofRowsinUnverified)).getText();
		int rownumb = Integer.parseInt(rows);
		System.out.println("No.of rows" + rows);
		// Read the Web Table to find the particular email id to verify.
		List<WebElement> rowList = wait.until(ExpectedConditions.visibilityOfAllElements(RepositoryClass.unverifiedadminTable().findElements(By.tagName("tr"))));
		int row_count = rowList.size();
		System.out.println(row_count);

try {
		for (int i = 1; i < s.getLastRowNum() + 1; i++) {

			while (flag == 1) {
				List<WebElement> rowList1 = wait.until(ExpectedConditions
						.visibilityOfAllElements(RepositoryClass.unverifiedadminTable().findElements(By.tagName("tr"))));
					int rowval = 1;
				for (int row = 0; row < rownumb; row++) {
				try {
					wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.unverifiedadminTable())).isDisplayed();
					List<WebElement> columnList = rowList1.get(row).findElements(By.tagName("td"));
					int column_count = columnList.size();
					System.out.println("Number of cells In Row " + rowval + " are " + column_count);
					// rownum = row;
					if (rowList1.isEmpty() == false) {
						outer: for (int column = 1; column < column_count; column++) {
							wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.unverifiedcellData(rowval, column)));
							String s1 = wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.unverifiedcellData(rowval, column))).getText();
							System.out.println("Cell Value of row number " + rowval + " and column number " + column
									+ " Is " + s1);
							// Check each cell value row by row to find the desired value
							if (s1.contains(s.getRow(i).getCell(1).getStringCellValue()) == true) {

								// action.moveToElement(RepositoryClass.editButtonforUnverified(row)).click().perform();
								System.out.println(rownumb);
								rownumb = rowval;
								Thread.sleep(2000);
								action.moveToElement(wait.until(
										ExpectedConditions.elementToBeClickable(RepositoryClass.editButtonforUnverified(rownumb))))
										.click().perform();
//								action.moveToElement(
//										wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.yesVerifyDoctor)))
//										.click().perform();
								String trailStartDate = s.getRow(i).getCell(2).getStringCellValue();
								String trailEndDate = s.getRow(i).getCell(3).getStringCellValue();
								try {
									
								if(trailStartDate.isBlank() == false) {
								wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.trailStartDate)).click();
								                                
								

									FromDate = p.dateparsing(trailStartDate);
									FromMonth = p.monthparsing(trailStartDate);
									FromYear = p.yearparsing(trailStartDate);
//									
									System.out.println(FromDate);
									wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.yearSelectionButton))
											.click();
									wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.year(FromYear))).click();
									MonthonCalendar = wait
											.until(ExpectedConditions.elementToBeClickable(RepositoryClass.dateOnCalendar))
											.getText();
									Month = p.monthparsing(MonthonCalendar);
									Year = p.yearparsing(MonthonCalendar);
									month = Integer.parseInt(Month);
									frommonth = Integer.parseInt(FromMonth);
									if (month < frommonth == true) {
										while (month == frommonth == false) {
											wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.nextButton))
													.click();
											MonthonCalendar = wait
													.until(ExpectedConditions.elementToBeClickable(RepositoryClass.dateOnCalendar))
													.getText();
											Month = p.monthparsing(MonthonCalendar);
											Year = p.yearparsing(MonthonCalendar);
											month = Integer.parseInt(Month);
											frommonth = Integer.parseInt(FromMonth);
										}
									}

									if (month > frommonth == true) {
										while (month == frommonth == false) {
											wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.previousButton)).click();
											MonthonCalendar = wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.dateOnCalendar)).getText();
											Month = p.monthparsing(MonthonCalendar);
											Year = p.yearparsing(MonthonCalendar);
											month = Integer.parseInt(Month);
											frommonth = Integer.parseInt(FromMonth);
										}
									}
                                    wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.Date(FromDate))).click();
								}
								if(trailEndDate.isBlank() == false) {
									ToDate = p.dateparsing(trailEndDate);
									ToMonth = p.monthparsing(trailEndDate);
									ToYear = p.yearparsing(trailEndDate);
//									
					
									wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.trailEndDate)).click();
									wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.yearSelectionButton)).click();
									wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.year(ToYear))).click();
									MonthonCalendar = wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.dateOnCalendar)).getText();
									Month = p.monthparsing(MonthonCalendar);
									Year = p.yearparsing(MonthonCalendar);
									month = Integer.parseInt(Month);
									tomonth = Integer.parseInt(ToMonth);
									if (month < tomonth == true) {
										while (month == tomonth == false) {
											wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.nextButton))
													.click();
											MonthonCalendar = wait
													.until(ExpectedConditions.elementToBeClickable(RepositoryClass.dateOnCalendar))
													.getText();
											Month = p.monthparsing(MonthonCalendar);
											Year = p.yearparsing(MonthonCalendar);
											month = Integer.parseInt(Month);
											tomonth = Integer.parseInt(ToMonth);
										}
									}

									if (month > tomonth == true) {
										while (month == tomonth == false) {
											wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.previousButton))
													.click();
											MonthonCalendar = wait
													.until(ExpectedConditions.elementToBeClickable(RepositoryClass.dateOnCalendar))
													.getText();
											Month = p.monthparsing(MonthonCalendar);
											Year = p.yearparsing(MonthonCalendar);
											month = Integer.parseInt(Month);
											tomonth = Integer.parseInt(ToMonth);
										}
									}

									wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.Date(ToDate))).click();
								}
								
											action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.yesVerifyDoctor))).click().perform();
											wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.saveProfile)).click();
									String msg = wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.alertMessage))
											.getText();
									s.getRow(i).createCell(4).setCellValue(msg);
									FileOutputStream fout = new FileOutputStream(
											user_dir + "\\inputFiles\\Admin_Login.xlsx");
									wb.write(fout);
									flag = 0;
									adminfunctions.doctorQueueNavigation(driver);
									adminfunctions.unverifiedDoctorQueueNavigation(driver);
									break outer;
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						rowval = rowval + 1;
					}
				
				}catch (Exception ex) {
					
				}
				}

			if (flag == 1) {
				try {
					wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.unverifiedNextButton)).click();
					wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.unverifiedadminTable())).isDisplayed();
					flag = 1;
				} catch (Exception e) {
					System.out.println("The record is not available");
					s.getRow(i).createCell(4).setCellValue("The record is not available");
					//s.getRow(i).createCell(6).setCellValue("Fail");
					FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
					wb.write(fout);
					flag = 0;
					adminfunctions.patientQueueNaviagtion(driver);
					adminfunctions.doctorQueueNavigation(driver);
					adminfunctions.unverifiedDoctorQueueNavigation(driver);
					
				break;

				}

			}
		
		}
			 flag = 1;
	}
	}catch(Exception e) {
		
	}

		
	}
		
		public void viewVerifiedDoctorProfile() throws Exception{
			
			WebDriverWait wait = new WebDriverWait(driver, 10); 
		  	
			int rval = 1;
			String s1 =null;
			int rownum =1;
			int colnum =1;
			int flag = 1;
				
		    Actions action = new Actions(driver);
		    String rows = RepositoryClass.unverifiedrows().getText();
			int rownumb = Integer.parseInt(rows);
			System.out.println("No.of rows" + rows);
//		    List <WebElement> rowList = page.verifiedadminTable.findElements(By.tagName("tr"));
//			   int row_count = rowList.size();
//			   System.out.println(row_count);
			  
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
				   
				   List<WebElement> rowList = RepositoryClass.unverifiedadminTable().findElements(By.tagName("tr"));
					int row_count = rowList.size();
					Thread.sleep(2000);			   
				   List <WebElement> columnList = rowList.get(row).findElements(By.tagName("td"));
				   int column_count = columnList.size();
				   //System.out.println("Number of cells In Row " + rowval + " are " + column_count);
				   //rownum = row;
				   if(rowList.isEmpty()==false) {
				   for(int column = 1; column<column_count; column++) {
					   s1 = RepositoryClass.verifiedcellData(rowval, column).getText();
					   //System.out.println("Cell Value of row number " + rowval + " and column number " + column + " Is " + s1);
						   if(s1.contains(s.getRow(i).getCell(0).getStringCellValue())== true) {
							   
							  //action.moveToElement(page.editButtonforUnverified(row)).click().perform();
							  //System.out.println(rownumb);
							  rownumb = rowval;
							 wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.viewButtonforVerified(rownumb))).click();
							  Thread.sleep(2000);
							  flag=0;
							  break outer;
//							   action.moveToElement(page.editButtonforUnverified(rownum)).click().perform();
//							   Thread.sleep(2000);
//							   action.moveToElement(page.yesVerifyDoctor).click().perform();
//							   Thread.sleep(2000);
//							   action.moveToElement(page.saveProfile).click().perform();
							   
							  
						   }
						 
				      }  
				        rowval= rowval+1;
				   }
			   }
				if (flag == 1) {
					try {
						((WebElement) RepositoryClass.verifiedNextButton).click();
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

