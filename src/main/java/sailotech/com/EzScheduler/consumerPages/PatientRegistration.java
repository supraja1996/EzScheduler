package sailotech.com.EzScheduler.consumerPages;

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

public class PatientRegistration {
	
	WebDriver driver;
	
	public PatientRegistration(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
		
	}
	
	
	public byte[] login() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		
	}
	
	public void navigation_to_patient_registration_page() throws Exception{
		 WebDriverWait wait = new WebDriverWait(driver, 10); 
		  	PatientRepositoryClass page = new PatientRepositoryClass(driver);
		    Actions action = new Actions(driver); 
		    wait.until(ExpectedConditions.elementToBeClickable(page.buttonLoginRegister)).click();
            page.patientregisterOption.click();
			


		
	}
	public void registrationPage() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 10); 
	  	PatientRepositoryClass page = new PatientRepositoryClass(driver);
	    Actions action = new Actions(driver); 
	    String user_dir = System.getProperty("user.dir");
	    FileInputStream fis = new FileInputStream(user_dir+"\\inputFiles\\Patient_Login.xlsx");	
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Header Sheet
		XSSFSheet s = wb.getSheetAt(5);

		Thread.sleep(2000);
System.out.println(s.getLastRowNum());
		for (int i = 1; i < s.getLastRowNum() + 1; i++) {
			
			wait.until(ExpectedConditions.elementToBeClickable(page.registrationName)).sendKeys(s.getRow(i).getCell(0).getStringCellValue());
			wait.until(ExpectedConditions.elementToBeClickable(page.registrationEmail)).sendKeys(s.getRow(i).getCell(1).getStringCellValue());
			wait.until(ExpectedConditions.elementToBeClickable(page.registrationPhoneNumber)).sendKeys(s.getRow(i).getCell(2).getStringCellValue());

			
			String gender = s.getRow(i).getCell(3).getStringCellValue();
			if(gender.isEmpty() == false) {
			wait.until(ExpectedConditions.elementToBeClickable(page.gender(gender))).click();
			}
//			switch(gender) {
//			case "M":
//				action.moveToElement(page.registrationMale).click().perform();
//				break;
//			case "F":
//				wait.until(ExpectedConditions.elementToBeClickable(page.regis))
//				action.moveToElement(page.registrationFemale).click().perform();
//				break;
//			
//			default:
//				System.out.println("No Match for Gender Found");
//			}
			wait.until(ExpectedConditions.elementToBeClickable(page.registerButton)).click();
			try {
				wait.until(ExpectedConditions.elementToBeClickable(page.verifyotpButton)).isDisplayed();
				s.getRow(i).createCell(4).setCellValue("Navigated to OTP Page");
			}catch(Exception e) {
				try {
					wait.until(ExpectedConditions.elementToBeClickable(page.nameErrorRegistration)).isDisplayed();
					s.getRow(i).createCell(4).setCellValue(page.nameErrorRegistration.getText());

				}catch(Exception e1) {
					try {
						wait.until(ExpectedConditions.elementToBeClickable(page.emailErrorRegistration)).isDisplayed();
						s.getRow(i).createCell(4).setCellValue(page.emailErrorRegistration.getText());

					}catch(Exception e2) {
						try {
							wait.until(ExpectedConditions.elementToBeClickable(page.emailalreadyusedErrorRegistration)).isDisplayed();
							s.getRow(i).createCell(4).setCellValue(page.emailalreadyusedErrorRegistration.getText());
	
						}catch(Exception e3) {
							try {
							wait.until(ExpectedConditions.elementToBeClickable(page.invalidemailErrorRegistration)).isDisplayed();
							s.getRow(i).createCell(4).setCellValue(page.invalidemailErrorRegistration.getText());
							}catch(Exception e4){
								try {
									wait.until(ExpectedConditions.elementToBeClickable(page.phoneErrorRegistration)).isDisplayed();
									s.getRow(i).createCell(4).setCellValue(page.phoneErrorRegistration.getText());
								}catch(Exception e5) {
									try {
										wait.until(ExpectedConditions.elementToBeClickable(page.invalidphoneErrorRegistration)).isDisplayed();
										s.getRow(i).createCell(4).setCellValue(page.invalidphoneErrorRegistration.getText());

									}catch(Exception e6) {
										try {
											wait.until(ExpectedConditions.elementToBeClickable(page.phonealreadyusedErrorRegistration)).isDisplayed();
											s.getRow(i).createCell(4).setCellValue(page.phonealreadyusedErrorRegistration.getText());

										}catch(Exception e7) {
											try {
												wait.until(ExpectedConditions.elementToBeClickable(page.genderErrorRegistration)).isDisplayed();
												s.getRow(i).createCell(4).setCellValue(page.genderErrorRegistration.getText());
												
											}
											catch(Exception e8) {
												
											}
										}
									}
									
								}
							}
						}
					}
				}
				
			}
			//action.moveToElement(page.registerButton).click().perform();
//			wait.until(ExpectedConditions.elementToBeClickable(page.verifyotpButton)).isDisplayed();
//			Assert.assertTrue(page.verifyotpButton.isDisplayed());
//			wb.close();
			driver.navigate().refresh();
			Thread.sleep(2000);
		}
		FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Patient_Login.xlsx");
		wb.write(fout);
	}
		public void otpPage() throws Exception{
			WebDriverWait wait = new WebDriverWait(driver, 10); 
		  	PatientRepositoryClass page = new PatientRepositoryClass(driver);
		    Actions action = new Actions(driver); 
		    String user_dir = System.getProperty("user.dir");
		    FileInputStream fis = new FileInputStream(user_dir+"\\inputFiles\\Patient_Login.xlsx");	
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			// Header Sheet
			XSSFSheet s = wb.getSheetAt(2);

			Thread.sleep(2000);

			for (int i = 1; i < s.getLastRowNum() + 1; i++) {
				

	
				wait.until(ExpectedConditions.elementToBeClickable(page.otp)).sendKeys(s.getRow(i).getCell(0).getStringCellValue());
				wait.until(ExpectedConditions.elementToBeClickable(page.verifyotpButton)).click();

			
		}
		
	}

}
