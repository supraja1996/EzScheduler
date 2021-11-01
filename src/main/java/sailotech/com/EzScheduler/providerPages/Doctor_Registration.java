package sailotech.com.EzScheduler.providerPages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DateParsing;

public class Doctor_Registration {

	WebDriver driver;
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

	public Doctor_Registration(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
	}

	public byte[] login(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public void navigation_to_Registration() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		Repository page = new Repository(driver);

		Actions action = new Actions(driver);

		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(page.buttonLoginRegister)).click();

		wait.until(ExpectedConditions.elementToBeClickable(page.doctorRegisterMenu)).click();

		wait.until(ExpectedConditions.elementToBeClickable(page.buttonLoginRegister)).click();

	}

	public void registration_page() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		Repository page = new Repository(driver);

		Actions action = new Actions(driver);
		Navigations navigations = new Navigations(driver);
        DateParsing p = new DateParsing();
		Thread.sleep(2000);
		String user_dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Doctor_Login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Header Sheet
		XSSFSheet s = wb.getSheetAt(3);
		for (int i = 1; i < s.getLastRowNum() + 1; i++) {

			wait.until(ExpectedConditions.elementToBeClickable(page.namefield)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(page.namefield))
					.sendKeys(s.getRow(i).getCell(0).getStringCellValue());
			wait.until(ExpectedConditions.elementToBeClickable(page.emailfield)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(page.emailfield))
					.sendKeys(s.getRow(i).getCell(1).getStringCellValue());
			wait.until(ExpectedConditions.elementToBeClickable(page.mobileNumber)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(page.mobileNumber))
					.sendKeys(s.getRow(i).getCell(2).getRawValue());

			String gender = s.getRow(i).getCell(3).getStringCellValue();
			wait.until(ExpectedConditions.elementToBeClickable(page.gender(gender))).click();
			String specializations = s.getRow(i).getCell(4).getStringCellValue();
			String[] Specializations = specializations.split(",");
			System.out.println(Specializations.length);
			try {
				wait.until(ExpectedConditions.elementToBeClickable(page.specilaizationField)).click();
				if(page.clearSpecializations.isDisplayed() == true) {
				wait.until(ExpectedConditions.elementToBeClickable(page.clearSpecializations)).click();

			}
			}catch(Exception e) {
				}	
			
			for (int j = 0; j < Specializations.length; j++) {
				
				
						//action.moveToElement(page.specilaizationField).click().perform();
		    			Thread.sleep(2000);
						action.moveToElement(page.specilalizationsfield).sendKeys(Specializations[j]).perform();
//		    			action.sendKeys(Specializations[j]).perform();
						action.sendKeys(Keys.ARROW_DOWN).perform();
						Thread.sleep(2000);
						action.sendKeys(Keys.ENTER).perform();
						Thread.sleep(2000);
				}
				
//			}
			String education = s.getRow(i).getCell(5).getStringCellValue();
			String[] degree = education.split(",");
			for (int k = 0; k < degree.length; k++) {
				
				action.moveToElement(page.degreefield).click().perform();
				Thread.sleep(2000);
				action.sendKeys(degree[k]).perform();
				action.sendKeys(Keys.ARROW_DOWN).perform();
				Thread.sleep(2000);
				action.sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);
				
			}

			fromDate = s.getRow(i).getCell(6).getStringCellValue();
			try {
				FromDate = p.dateparsing(fromDate);
				FromMonth = p.monthparsing(fromDate);
				FromYear = p.yearparsing(fromDate);
//				wait.until(ExpectedConditions.elementToBeClickable(page.startDatefield)).click();
				action.moveToElement(page.startDatefield).click().perform();
				Thread.sleep(2000);
//				wait.until(ExpectedConditions.elementToBeClickable(page.yearSelectionButton)).click();
				action.moveToElement(page.yearSelectionButton).click().perform();
				Thread.sleep(2000);
//				wait.until(ExpectedConditions.elementToBeClickable(page.year(FromYear))).click();
				action.moveToElement(page.year(FromYear)).click().perform();
				Thread.sleep(2000);
				action.moveToElement(page.monthSelection);
				monthonCalendar = wait.until(ExpectedConditions.elementToBeClickable(page.monthSelection)).getText();
//				System.out.println("Month on the Calndar" + monthonCalendar);
				fromMonth = p.monthparsing(monthonCalendar);
				fromYear = p.yearparsing(monthonCalendar);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int inpmonth = Integer.parseInt(FromMonth);
			int calmonth = Integer.parseInt(fromMonth);
			if (inpmonth > calmonth) {
				while ((calmonth == inpmonth) == false) {
					try {
						wait.until(ExpectedConditions.elementToBeClickable(page.next)).click();
//						action.moveToElement(page.next).click().perform();
//						Thread.sleep(2000);
						wait.until(ExpectedConditions.elementToBeClickable(page.monthSelection));
						action.moveToElement(page.monthSelection);
						String monthonCalendar2 = wait.until(ExpectedConditions.elementToBeClickable(page.monthSelection)).getText();
//						System.out.println(monthonCalendar2);
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
						wait.until(ExpectedConditions.elementToBeClickable(page.previous)).click();
//						action.moveToElement(page.previous).click().perform();
//						Thread.sleep(2000);
						wait.until(ExpectedConditions.elementToBeClickable(page.monthSelection));
						//action.moveToElement(page.monthSelection);
						String monthonCalendar1 = wait.until(ExpectedConditions.elementToBeClickable(page.monthSelection)).getText();
//						System.out.println("Month on the Calendar " + monthonCalendar1);
						fromMonth = p.monthparsing(monthonCalendar1);
						fromYear = p.yearparsing(monthonCalendar1);
						calmonth = Integer.parseInt(fromMonth);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
			wait.until(ExpectedConditions.elementToBeClickable(page.Date(FromDate))).click();
//			action.moveToElement(page.Date(FromDate)).click().perform();
//			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(page.registerButton)).click();
//			action.moveToElement(page.registerButton).click().perform();
			Thread.sleep(2000);
			try {

				if (page.errorMessage.isDisplayed() == true) {
					action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(page.errorMessage)));
					Thread.sleep(2000);
					String error = wait.until(ExpectedConditions.elementToBeClickable(page.errorMessage)).getText();
					System.out.println(error);
					s.getRow(i).createCell(8).setCellValue(error);
					s.getRow(i).createCell(9).setCellValue("FAIL");
					Thread.sleep(2000);
					FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Doctor_Login.xlsx");
					wb.write(fout);
					
					

				} else {

					s.getRow(i).createCell(8).setCellValue("Success");
					s.getRow(i).createCell(9).setCellValue("SUCCESS");
					FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Doctor_Login.xlsx");
					wb.write(fout);
					
					

				}

			} catch (Exception e) {
				
			}
//			navigations.navigatetoLoginPage();
//			Thread.sleep(2000);
//			navigations.navigatetoRegistrationPage();
//			wait.until(ExpectedConditions.elementToBeClickable(page.specilaizationField));
//			driver.navigate().to("https://demo.ezscheduler.io/doctorsignup");;
			//driver.navigate().refresh();
			Thread.sleep(2000);
		}

	}
}

