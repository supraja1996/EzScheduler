package sailotech.com.EzScheduler.AdminFunctions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

import sailotech.com.EzScheduler.adminPages.AdminPageRepositoryClass;

public class CheckForTheVerifiedDoctor {

	WebDriver driver;
	int rval = 1;
	String s1 = null;
	int rownum = 1;
	int colnum = 1;
	int flag = 1;

	public CheckForTheVerifiedDoctor(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);

	}

	public byte[] login() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

	}

	public void Navigation_to_Doctor_Queue() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
		Actions action = new Actions(driver);
		action.moveToElement(page.Menu).click().perform();
		Thread.sleep(2000);
		action.moveToElement(page.DoctorQueue).click().perform();
	}

	public void check_for_the_verfied_doctor_from_unverified() throws Exception {
try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
		Actions action = new Actions(driver);
		Navigations n = new Navigations(driver);
		String rows = page.noofRowsVerified.getText();
		int rownumb = Integer.parseInt(rows);
		System.out.println("No.of rows" + rows);
		//List<WebElement> rowList = wait.until(ExpectedConditions.visibilityOfAllElements(page.verifiedadminTable.findElements(By.tagName("tr"))));

//		List<WebElement> rowList = page.verifiedadminTable.findElements(By.tagName("tr"));
//		int row_count = rowList.size();
//		System.out.println(row_count);

		String user_dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Header Sheet
		XSSFSheet s = wb.getSheetAt(2);

		Thread.sleep(2000);

		for (int i = 1; i < s.getLastRowNum() + 1; i++) {
			int pageno = 1;
			String value = s.getRow(i).getCell(0).getStringCellValue();
			while (flag == 1) {
				List<WebElement> rowList = wait.until(ExpectedConditions.visibilityOfAllElements(page.verifiedadminTable.findElements(By.tagName("tr"))));
				int rowval = 1;
				for (int row = 0; row < rownumb; row++) {
				try {
					List<WebElement> rowList1 = wait.until(ExpectedConditions.visibilityOfAllElements(page.verifiedadminTable.findElements(By.tagName("tr"))));

					wait.until(ExpectedConditions.elementToBeClickable(page.verifiedadminTable)).isDisplayed();
					List<WebElement> columnList = rowList1.get(row).findElements(By.tagName("td"));

					int column_count = columnList.size();
					System.out.println("Number of cells In Row " + rowval + " are " + column_count);
					// rownum = row;
					if (rowList1.isEmpty() == false) {
						outer: for (int column = 1; column < column_count; column++) {
							wait.until(ExpectedConditions.elementToBeClickable(page.verifiedcellData(rowval, column)));
							String s1 = wait.until(ExpectedConditions.elementToBeClickable(page.verifiedcellData(rowval, column))).getText();
							System.out.println("Cell Value of row number " + rowval + " and column number " + column
									+ " Is " + s1);
							// Check each cell value row by row to find the desired value
							System.out.println(s1.equals(value));
	
							if (s1.equals(value) == true) {

								// action.moveToElement(page.editButtonforUnverified(row)).click().perform();
								//System.out.println(rownumb);
								rownumb = rowval;
								System.out.println("The Data is present in the rowno:" + rowval);
								//System.out.println("The record is not available");
								s.getRow(i).createCell(1).setCellValue("The Data is present in the rowno:" + rowval +"and page no is"+pageno);
								//s.getRow(i).createCell(6).setCellValue("Fail");
								FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
								wb.write(fout);
								flag = 0;
								n.navigationToPatientQueue();
								System.out.println("Navigated to Patient queue");
								n.Navigation_to_Doctor_Queue();
								System.out.println("Navigated to Doctor queue");
//								n.navigation_to_verified_doctors();
								break outer;
//					   action.moveToElement(page.editButtonforUnverified(rownum)).click().perform();
//					   Thread.sleep(2000);
//					   action.moveToElement(page.yesVerifyDoctor).click().perform();
//					   Thread.sleep(2000);
//					   action.moveToElement(page.saveProfile).click().perform();

							}

						}
						rowval = rowval + 1;
					}
				}catch (Exception ex) {
					
				}
				}
				if (flag == 1) {
					try {
						wait.until(ExpectedConditions.elementToBeClickable(page.verifiedNextButton)).click();
						Thread.sleep(2000);
						pageno++;
						wait.until(ExpectedConditions.elementToBeClickable(page.verifiedadminTable)).isDisplayed();
						//wait.wait(1000);
						flag = 1;
						
					} 
					catch (Exception e) {
						System.out.println("The record is not available");
						s.getRow(i).createCell(1).setCellValue("The record is not available");
						FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Admin_Login.xlsx");
						wb.write(fout);
						//s.getRow(i).createCell(6).setCellValue("Fail");
						
						n.navigationToPatientQueue();
						System.out.println("Navigated to Patient queue");
						n.Navigation_to_Doctor_Queue();
						System.out.println("Navigated to Doctor queue");
						n.navigation_to_verified_doctors();
					break;
						
					}
				}

			}
			flag = 1;
			Thread.sleep(2000);
		}
		
}catch(Exception e) {
	e.printStackTrace();
}
	}
	

}
