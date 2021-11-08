package sailotech.com.EzScheduler.providerPages;

import utils.DateParsing;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import sailotech.com.EzScheduler.basePages.BaseTest;
import sailotech.com.EzScheduler.providerPages.Repository;

import java.text.ParseException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
public class GenerateSlots extends BaseTest{
	
	String romDate;
	String fromDate;
	String toDate;
	String openSlots;
	String upcomingSlots;
	String blockedSlots;
	String pastAppointments;
	String formattedDateonCalendar;
	Date FormattedDate;
	Date FormatedDate;
	Date calendarDate;
	Date dateOnCalendar;
	Date fromdate;
	Date todate;
	/* long daysDiff; */
	Date currentDate;
	String FromDate;
	String FromMonth;
	String ToMonth;
	String FromYear;
	String ToDate;
	String ToYear;
	String MonthonCalendar;
	int rowvalue;
	int div;
	int flag = 0;

	public GenerateSlots(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public byte[] login(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public void navigation_to_GenerateSlots() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 5);

		Repository page = new Repository(driver);
		Actions action = new Actions(driver);

		Thread.sleep(2000);

		/* wait.until(ExpectedConditions.visibilityOf(page.menu)).click(); */
		action.moveToElement(page.menu).click().perform();
		wait.until(ExpectedConditions.elementToBeClickable(page.menu));
		Thread.sleep(2000);
		openSlots = page.openSlots.getText();
		System.out.println("Open SLots -" + openSlots);
		upcomingSlots = page.upcomingAppointments.getText();
		System.out.println("Upcoming Appointments" + upcomingSlots);
		blockedSlots = page.blockedSlots.getText();
		System.out.println("Blocked Slots" + blockedSlots);
		pastAppointments = page.pastAppointments.getText();
		System.out.println("Past Appointments" + pastAppointments);
		action.moveToElement(page.menu).click().perform();
		wait.until(ExpectedConditions.elementToBeClickable(page.menu));
		Thread.sleep(2000);
		action.moveToElement(page.generateSlotsMenu).click().perform();

		// wait.until(ExpectedConditions.elementToBeClickable(page.generateSlotsMenu));
		Thread.sleep(2000);

	}

	public void generate_slots_page() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		Repository page = new Repository(driver);
		String user_dir = System.getProperty("user.dir");
		FileInputStream fis = null;
		fis = new FileInputStream(
				System.getProperty("user.dir") + envRelativePath("\\inputFiles\\Doctor_Login.xlsx"));

		//FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Doctor_Login.xlsx");
		Actions action = new Actions(driver);
		DateParsing p = new DateParsing();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Header Sheet
		XSSFSheet s = wb.getSheetAt(1);
		Thread.sleep(2000);
		String newOpenSlots;
		for (int i = 1; i < s.getLastRowNum() + 1; i++) {

			wait.until(ExpectedConditions.elementToBeClickable(page.facility))
					.sendKeys(s.getRow(i).getCell(1).getStringCellValue());
			wait.until(ExpectedConditions.elementToBeClickable(page.facility)).sendKeys(Keys.ARROW_DOWN);
			wait.until(ExpectedConditions.elementToBeClickable(page.facility)).sendKeys(Keys.ENTER);
			// wait.until(ExpectedConditions.elementToBeClickable(page.facility)).sendKeys(Keys.TAB);

			wait.until(ExpectedConditions.elementToBeClickable(page.consultType)).sendKeys(s.getRow(i).getCell(2).getStringCellValue());
			wait.until(ExpectedConditions.elementToBeClickable(page.consultType)).sendKeys(Keys.ARROW_DOWN);
			wait.until(ExpectedConditions.elementToBeClickable(page.consultType)).sendKeys(Keys.ENTER);
            // Enter From Date 
			fromDate = s.getRow(i).getCell(3).getStringCellValue();
			wait.until(ExpectedConditions.elementToBeClickable(page.fromDate)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(page.fromDate)).sendKeys(fromDate);
            // Enter To Date
			toDate = s.getRow(i).getCell(4).getStringCellValue();
		    wait.until(ExpectedConditions.elementToBeClickable(page.toDate)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(page.toDate)).sendKeys(toDate);
            // Enter From Time
			wait.until(ExpectedConditions.elementToBeClickable(page.fromTime)).clear();
		    wait.until(ExpectedConditions.elementToBeClickable(page.fromTime)).sendKeys(s.getRow(i).getCell(5).getStringCellValue());		
			// Enter To Time-------------------------
			wait.until(ExpectedConditions.elementToBeClickable(page.toTime)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(page.toTime))
					.sendKeys(s.getRow(i).getCell(6).getStringCellValue());
			// Select Days of the Week----------------
			String Days = s.getRow(i).getCell(7).getStringCellValue();
			String[] Day = Days.split(",");
			System.out.println(Day.length);
			for (int j = 0; j < Day.length; j++) {
				System.out.println(Day[j]);
				wait.until(ExpectedConditions.elementToBeClickable(page.day(Day[j]))).click();
			}
			String slotTime = s.getRow(i).getCell(8).getStringCellValue();
			
			if (slotTime.isBlank() == true) {
		    
			
			action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(page.slotTime))).doubleClick().perform();
			wait.until(ExpectedConditions.elementToBeClickable(page.slotTime)).sendKeys(Keys.BACK_SPACE);

			

			}
			else {
				
				wait.until(ExpectedConditions.elementToBeClickable(page.slotTime)).clear();
				wait.until(ExpectedConditions.elementToBeClickable(page.slotTime)).sendKeys(s.getRow(i).getCell(8).getStringCellValue());
	
      	    
			}

			wait.until(ExpectedConditions.elementToBeClickable(page.consultationFees)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(page.consultationFees)).sendKeys(s.getRow(i).getCell(9).getStringCellValue());
			try {
				if (wait.until(ExpectedConditions.elementToBeClickable(page.generateSlotButton)).isEnabled() == true) {
					wait.until(ExpectedConditions.elementToBeClickable(page.generateSlotButton)).click();
					flag = 1;
				}
			} catch (Exception ex) {
			
					if (wait.until(ExpectedConditions.elementToBeClickable(page.errorSlotTime)).isEnabled()) {
						String errorSlotTime = wait.until(ExpectedConditions.elementToBeClickable(page.errorSlotTime)).getText();
						s.getRow(i).createCell(10).setCellValue(errorSlotTime);
						flag = 0;
					}
			}
			
				if (flag == 1) {	
				try {
	
				if (wait.until(ExpectedConditions.elementToBeClickable(page.Alert)).isDisplayed() == true) {
					String AlertMessage = wait.until(ExpectedConditions.elementToBeClickable(page.Alert)).getText();
					System.out.println(AlertMessage);
					s.getRow(i).createCell(10).setCellValue(AlertMessage);
					wait.until(ExpectedConditions.elementToBeClickable(page.Alert)).click();

				}
							
			} catch (Exception e) {

				try {
					if (wait.until(ExpectedConditions.elementToBeClickable(page.errorLocation)).isDisplayed()) {
					String errorLocation = wait.until(ExpectedConditions.elementToBeClickable(page.errorLocation))
							.getText();
					s.getRow(i).createCell(10).setCellValue(errorLocation);
				}

					
				} catch (Exception e1) {
					try {
						if (wait.until(ExpectedConditions.elementToBeClickable(page.missingslotTime))
								.isDisplayed() == true) {
							String missingslotTime = wait
									.until(ExpectedConditions.elementToBeClickable(page.missingslotTime)).getText();
							s.getRow(i).createCell(10).setCellValue(missingslotTime);

						}
					} catch (Exception e2) {

						if (wait.until(ExpectedConditions.elementToBeClickable(page.missingconsultationFee))
								.isDisplayed() == true) {
							String missingconsultationFee = wait
									.until(ExpectedConditions.elementToBeClickable(page.missingconsultationFee))
									.getText();
							s.getRow(i).createCell(10).setCellValue(missingconsultationFee);

						}

					}

				}
			
			}
			}	
			driver.navigate().refresh();
			Thread.sleep(2000);
		}
		
		FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Doctor_Login.xlsx");
		wb.write(fout);
	}

	@SuppressWarnings("unused")
	public void check_the_slots() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 5);

		Repository page = new Repository(driver);
		Actions action = new Actions(driver);
		DateParsing p = new DateParsing();
		String user_dir = System.getProperty("user.dir");
		FileInputStream fis = null;
		fis = new FileInputStream(
				System.getProperty("user.dir") + envRelativePath("\\inputFiles\\Doctor_Login.xlsx"));

		
		//FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Doctor_Login.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Header Sheet
		XSSFSheet s = wb.getSheetAt(1);
		Thread.sleep(2000);
		for (int i = 1; i < s.getLastRowNum() + 1; i++) {
			// Get the input date from Excel and format date according to the format
			// mentioned on the Calendar
			fromDate = s.getRow(i).getCell(3).getStringCellValue();
			toDate = s.getRow(i).getCell(4).getStringCellValue();
			try {
				String FromDate = p.dateparsing(fromDate);			
				String FromMonth = p.monthparsing(fromDate);
				String ToDate = p.dateparsing(toDate);
				String ToMonth = p.monthparsing(toDate);
                wait.until(ExpectedConditions.elementToBeClickable(page.monthButton)).click();
                action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(page.DateOnTheMonthCalendar)));
				String DateOnMonthCalendar = page.DateOnTheMonthCalendar.getText();
				String[] DateOnCalendar = DateOnMonthCalendar.split("-");
				String CalendarDate = p.dateparsing(DateOnCalendar[0]);
				String CalendarMonth = p.monthparsing(DateOnCalendar[0]);
				int calMonth = Integer.parseInt(CalendarMonth);
				int fromMonth = Integer.parseInt(FromMonth);
//				
				System.out.println(CalendarMonth.equals(FromMonth));
				if(calMonth < fromMonth == true) {
				while (calMonth == fromMonth == false) {
                    wait.until(ExpectedConditions.elementToBeClickable(page.nextButton)).click();
                    action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(page.DateOnTheMonthCalendar)));

					DateOnMonthCalendar = page.DateOnTheMonthCalendar.getText();
					DateOnCalendar = DateOnMonthCalendar.split("-");
					System.out.println("Date on Calendar :" + DateOnCalendar[0]);
					CalendarDate = p.dateparsing(DateOnCalendar[0]);
					CalendarMonth = p.monthparsing(DateOnCalendar[0]);
					calMonth = Integer.parseInt(CalendarMonth);

				}
				}
				if(calMonth > fromMonth == true) {
					while (calMonth == fromMonth == false) {
	                    wait.until(ExpectedConditions.elementToBeClickable(page.previousButton)).click();
	                    action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(page.DateOnTheMonthCalendar)));

						DateOnMonthCalendar = page.DateOnTheMonthCalendar.getText();
						DateOnCalendar = DateOnMonthCalendar.split("-");
						System.out.println("Date on Calendar :" + DateOnCalendar[0]);
						CalendarDate = p.dateparsing(DateOnCalendar[0]);
						CalendarMonth = p.monthparsing(DateOnCalendar[0]);
						calMonth = Integer.parseInt(CalendarMonth);

					}
					}

				Thread.sleep(2000);
				action.moveToElement(page.date(FromDate)).click().perform();
				Thread.sleep(2000);
				action.moveToElement(page.openSlots).click().perform();
				String openSlots = page.openSlots.getText();
				System.out.println("Open Slots" + openSlots);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
