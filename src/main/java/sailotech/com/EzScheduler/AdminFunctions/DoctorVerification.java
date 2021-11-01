package sailotech.com.EzScheduler.AdminFunctions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.lang.model.util.Elements;

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

import sailotech.com.EzScheduler.basePages.BaseTest;
import sailotech.com.EzScheduler.adminPages.AdminPageRepositoryClass;
import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import utils.DateParsing;

public class DoctorVerification extends BaseTest{

	
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

	public DoctorVerification(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);

	}
	//WebDriverWait wait = new WebDriverWait(driver, 60);

	public byte[] login() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

	}

	// Verification of the Doctor

	public void verifiy_particular_Doctor_withTrialDate() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
		Actions action = new Actions(driver);
		DateParsing p = new DateParsing();
		Navigations n = new Navigations(driver);
		wait.until(ExpectedConditions.elementToBeClickable(page.noofRowsinUnverified));
		//action.moveToElement();
		String rows = wait.until(ExpectedConditions.elementToBeClickable(page.noofRowsinUnverified)).getText();
		int rownumb = Integer.parseInt(rows);
		System.out.println("No.of rows" + rows);
		// Read the Web Table to find the particular email id to verify.
		List<WebElement> rowList = wait.until(ExpectedConditions.visibilityOfAllElements(page.unverifiedadminTable.findElements(By.tagName("tr"))));
		int row_count = rowList.size();
		System.out.println(row_count);

		String user_dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Header Sheet
		XSSFSheet s = wb.getSheetAt(1);

		Thread.sleep(2000);
try {
		for (int i = 1; i < s.getLastRowNum() + 1; i++) {

			while (flag == 1) {
				List<WebElement> rowList1 = wait.until(ExpectedConditions
						.visibilityOfAllElements(page.unverifiedadminTable.findElements(By.tagName("tr"))));
				int rowval = 1;
				for (int row = 0; row < rownumb; row++) {
				try {
					wait.until(ExpectedConditions.elementToBeClickable(page.unverifiedadminTable)).isDisplayed();
					List<WebElement> columnList = rowList1.get(row).findElements(By.tagName("td"));

					int column_count = columnList.size();
					System.out.println("Number of cells In Row " + rowval + " are " + column_count);
					// rownum = row;
					if (rowList1.isEmpty() == false) {
						outer: for (int column = 1; column < column_count; column++) {
							wait.until(ExpectedConditions.elementToBeClickable(page.unverifiedcellData(rowval, column)));
							String s1 = wait.until(ExpectedConditions.elementToBeClickable(page.unverifiedcellData(rowval, column))).getText();
							System.out.println("Cell Value of row number " + rowval + " and column number " + column
									+ " Is " + s1);
							// Check each cell value row by row to find the desired value
							if (s1.contains(s.getRow(i).getCell(1).getStringCellValue()) == true) {

								// action.moveToElement(RepositoryClass.editButtonforUnverified(row)).click().perform();
								System.out.println(rownumb);
								rownumb = rowval;
								Thread.sleep(2000);
								action.moveToElement(wait.until(
										ExpectedConditions.elementToBeClickable(page.editButtonforUnverified(rownumb))))
										.click().perform();
								action.moveToElement(
										wait.until(ExpectedConditions.elementToBeClickable(page.yesVerifyDoctor)))
										.click().perform();
								String trailStartDate = s.getRow(i).getCell(2).getStringCellValue();
								String trailEndDate = s.getRow(i).getCell(3).getStringCellValue();
								try {
								if(trailStartDate.isBlank() == false) {
								action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(page.trailStartDate))).click().perform();
								                                
								

									FromDate = p.dateparsing(trailStartDate);
									FromMonth = p.monthparsing(trailStartDate);
									FromYear = p.yearparsing(trailStartDate);
//									
									ToDate = p.dateparsing(trailEndDate);
									ToMonth = p.monthparsing(trailEndDate);
									ToYear = p.yearparsing(trailEndDate);
//									
									wait.until(ExpectedConditions.elementToBeClickable(page.yearSelectionButton))
											.click();
									wait.until(ExpectedConditions.elementToBeClickable(page.year(FromYear))).click();
									MonthonCalendar = wait
											.until(ExpectedConditions.elementToBeClickable(page.dateOnCalendar))
											.getText();
									Month = p.monthparsing(MonthonCalendar);
									Year = p.yearparsing(MonthonCalendar);
									month = Integer.parseInt(Month);
									frommonth = Integer.parseInt(FromMonth);
									if (month < frommonth == true) {
										while (month == frommonth == false) {
											wait.until(ExpectedConditions.elementToBeClickable(page.nextButton))
													.click();
											MonthonCalendar = wait
													.until(ExpectedConditions.elementToBeClickable(page.dateOnCalendar))
													.getText();
											Month = p.monthparsing(MonthonCalendar);
											Year = p.yearparsing(MonthonCalendar);
											month = Integer.parseInt(Month);
											frommonth = Integer.parseInt(FromMonth);
										}
									}

									if (month > frommonth == true) {
										while (month == frommonth == false) {
											wait.until(ExpectedConditions.elementToBeClickable(page.previousButton))
													.click();
											MonthonCalendar = wait
													.until(ExpectedConditions.elementToBeClickable(page.dateOnCalendar))
													.getText();
											Month = p.monthparsing(MonthonCalendar);
											Year = p.yearparsing(MonthonCalendar);
											month = Integer.parseInt(Month);
											frommonth = Integer.parseInt(FromMonth);
										}
									}

									wait.until(ExpectedConditions.elementToBeClickable(page.Date(FromDate))).click();
								}
								if(trailEndDate.isBlank() == false) {
									action.moveToElement(
											wait.until(ExpectedConditions.elementToBeClickable(page.trailEndDate)))
											.click().perform();
									wait.until(ExpectedConditions.elementToBeClickable(page.yearSelectionButton))
											.click();
									wait.until(ExpectedConditions.elementToBeClickable(page.year(ToYear))).click();
									MonthonCalendar = wait
											.until(ExpectedConditions.elementToBeClickable(page.dateOnCalendar))
											.getText();
									Month = p.monthparsing(MonthonCalendar);
									Year = p.yearparsing(MonthonCalendar);
									month = Integer.parseInt(Month);
									tomonth = Integer.parseInt(ToMonth);
									if (month < tomonth == true) {
										while (month == tomonth == false) {
											wait.until(ExpectedConditions.elementToBeClickable(page.nextButton))
													.click();
											MonthonCalendar = wait
													.until(ExpectedConditions.elementToBeClickable(page.dateOnCalendar))
													.getText();
											Month = p.monthparsing(MonthonCalendar);
											Year = p.yearparsing(MonthonCalendar);
											month = Integer.parseInt(Month);
											tomonth = Integer.parseInt(ToMonth);
										}
									}

									if (month > tomonth == true) {
										while (month == tomonth == false) {
											wait.until(ExpectedConditions.elementToBeClickable(page.previousButton))
													.click();
											MonthonCalendar = wait
													.until(ExpectedConditions.elementToBeClickable(page.dateOnCalendar))
													.getText();
											Month = p.monthparsing(MonthonCalendar);
											Year = p.yearparsing(MonthonCalendar);
											month = Integer.parseInt(Month);
											tomonth = Integer.parseInt(ToMonth);
										}
									}

									wait.until(ExpectedConditions.elementToBeClickable(page.Date(ToDate))).click();
								}
									action.moveToElement(
											wait.until(ExpectedConditions.elementToBeClickable(page.yesVerifyDoctor)))
											.click().perform();
									action.moveToElement(
											wait.until(ExpectedConditions.elementToBeClickable(page.saveProfile)))
											.click().perform();
									String msg = wait.until(ExpectedConditions.elementToBeClickable(page.alertMessage))
											.getText();
									s.getRow(i).createCell(4).setCellValue(msg);
									s.getRow(i).createCell(6).setCellValue("Success");
									FileOutputStream fout = new FileOutputStream(
											user_dir + "\\inputFiles\\Admin_Login.xlsx");
									wb.write(fout);
									flag = 0;
									n.Navigation_to_Doctor_Queue();
									n.navigation_to_unverified_doctors();
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
					wait.until(ExpectedConditions.elementToBeClickable(page.unverifiedNextButton)).click();
					wait.until(ExpectedConditions.elementToBeClickable(page.unverifiedadminTable)).isDisplayed();
					flag = 1;
				} catch (Exception e) {
					System.out.println("The record is not available");
					s.getRow(i).createCell(4).setCellValue("The record is not available");
					//s.getRow(i).createCell(6).setCellValue("Fail");
					FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
					wb.write(fout);
					n.navigationToPatientQueue();
					n.Navigation_to_Doctor_Queue();
					n.navigation_to_unverified_doctors();
				break;

				}

			}
		
		}
			 flag = 1;
	}
	}catch(Exception e) {
		
	}
	}
}
