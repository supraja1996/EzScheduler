package sailotech.com.EzScheduler.AdminFunctions;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sailotech.com.EzScheduler.adminPages.AdminPageRepositoryClass;

public class AdminLogin {
	WebDriver driver;

	public AdminLogin(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);

	}
	


	public void adminLogin_Navigation()  throws Exception{

		WebDriverWait wait = new WebDriverWait(driver, 60);

		AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);

		Thread.sleep(2000);
  try {
	    wait.until(ExpectedConditions.elementToBeClickable(page.buttonLoginRegister)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(page.adminLogin)).click();
	   // driver.findElement(page.buttonLoginRegister).click();
//		wait.until(ExpectedConditions.elementToBeClickable(RepositoryClass.adminLogin)).click();
//		//driver.findElement(RepositoryClass.adminLogin).click();

		//page.adminLogin.click();

//
	}catch(Throwable e) {
//		e.printStackTrace();
	}
	}
	public void adminLogin() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
		Actions action = new Actions(driver);
		String user_dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Header Sheet
		XSSFSheet s = wb.getSheetAt(0);

		Thread.sleep(2000);

		for (int i = 1; i < s.getLastRowNum() + 1; i++) {

			try {

				wait.until(ExpectedConditions.elementToBeClickable(page.adminUserName))
						.sendKeys(s.getRow(i).getCell(1).getStringCellValue());
				wait.until(ExpectedConditions.elementToBeClickable(page.adminPassword))
						.sendKeys(s.getRow(i).getCell(2).getStringCellValue());

				wait.until(ExpectedConditions.elementToBeClickable(page.adminSignIN)).click();
				Thread.sleep(1000);
				String strUrl = driver.getCurrentUrl();
				//SoftAssert softAssertion= new SoftAssert();
				//softAssertion.assertEquals(strUrl, "https://demo.ezscheduler.io/doctorQueue");
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

//	public void adminInvalidUsername() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
//		Actions action = new Actions(driver);
//		String user_dir = System.getProperty("user.dir");
//		FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		// Header Sheet
//		XSSFSheet s = wb.getSheetAt(4);
//
//		Thread.sleep(2000);
//
//		for (int i = 1; i < s.getLastRowNum() + 1; i++) {
//try {
//			wait.until(ExpectedConditions.elementToBeClickable(page.adminUserName))
//					.sendKeys(s.getRow(i).getCell(1).getStringCellValue());
//			wait.until(ExpectedConditions.elementToBeClickable(page.adminPassword))
//					.sendKeys(s.getRow(i).getCell(2).getStringCellValue());
//			wait.until(ExpectedConditions.elementToBeClickable(page.adminSignIN)).click();
//			String error = page.invalidCredentials.getText();
//				Assert.assertEquals(page.invalidCredentials.getText(), "Invalid Credentials");
//				s.getRow(i).createCell(3).setCellValue(error);
//                s.getRow(i).createCell(5).setCellValue("Success");
//				FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
//				wb.write(fout);
//
//} catch(Exception e) {
//	e.printStackTrace();
//}
//}
//
//	}
//
//	public void adminInvalidPassord() throws Exception {
//
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
//		Actions action = new Actions(driver);
//		String user_dir = System.getProperty("user.dir");
//		FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		// Header Sheet
//		XSSFSheet s = wb.getSheetAt(4);
//
//		Thread.sleep(2000);
//
//		for (int i = 1; i < s.getLastRowNum() + 1; i++) {
//try {
//			wait.until(ExpectedConditions.elementToBeClickable(page.adminUserName))
//					.sendKeys(s.getRow(i).getCell(0).getStringCellValue());
//			wait.until(ExpectedConditions.elementToBeClickable(page.adminPassword))
//					.sendKeys(s.getRow(i).getCell(1).getStringCellValue());
//			wait.until(ExpectedConditions.elementToBeClickable(page.adminSignIN)).click();
//			Assert.assertEquals(page.invalidCredentials.getText(), "Invalid Credentials");
//		
//} catch (Exception e) {
//	e.printStackTrace();
//}
//}
//	}
//
//	public void missingUsername() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
//		Actions action = new Actions(driver);
//		String user_dir = System.getProperty("user.dir");
//		FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		// Header Sheet
//		XSSFSheet s = wb.getSheetAt(4);
//
//		Thread.sleep(2000);
//
//		for (int i = 1; i < s.getLastRowNum() + 1; i++) {
//try {
//			wait.until(ExpectedConditions.elementToBeClickable(page.adminUserName))
//					.sendKeys(s.getRow(i).getCell(0).getStringCellValue());
//			wait.until(ExpectedConditions.elementToBeClickable(page.adminPassword))
//					.sendKeys(s.getRow(i).getCell(1).getStringCellValue());
//			Assert.assertEquals(page.requirederror, page.requiredusernameError);
//			wait.until(ExpectedConditions.elementToBeClickable(page.adminSignIN)).click();
//} catch(Exception e) {
//	e.printStackTrace();
//}		
//}
//
//	}
//
//	public void missingPassword() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
//		Actions action = new Actions(driver);
//		String user_dir = System.getProperty("user.dir");
//		FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		// Header Sheet
//		XSSFSheet s = wb.getSheetAt(4);
//
//		Thread.sleep(2000);
//
//		for (int i = 1; i < s.getLastRowNum() + 1; i++) {
//try {
//			wait.until(ExpectedConditions.elementToBeClickable(page.adminUserName))
//					.sendKeys(s.getRow(i).getCell(0).getStringCellValue());
//			wait.until(ExpectedConditions.elementToBeClickable(page.adminPassword))
//					.sendKeys(s.getRow(i).getCell(1).getStringCellValue());
//			Assert.assertEquals(page.requirederror, page.requiredpasswordError);
//			wait.until(ExpectedConditions.elementToBeClickable(page.adminSignIN)).click();
//} catch (Exception e) {
//	e.printStackTrace();
//}
//			
//		}
//
//	}
}



