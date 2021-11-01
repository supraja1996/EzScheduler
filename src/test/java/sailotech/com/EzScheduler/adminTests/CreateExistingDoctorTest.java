package sailotech.com.EzScheduler.adminTests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import sailotech.com.EzScheduler.AdminFunctions.AdminFunctions;
import sailotech.com.EzScheduler.AdminFunctions.AdminLogin;
import sailotech.com.EzScheduler.AdminFunctions.CreateDoctor;
import sailotech.com.EzScheduler.adminPages.AdminPageRepositoryClass;
import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import utils.ScreenRecording;

public class CreateExistingDoctorTest extends BaseTest{
	ScreenRecording screenRecord = new ScreenRecording();
	@BeforeClass
	public void startRecording() throws Exception {
		screenRecord.startRecording();
	}
	@TestCaseId("TC_01")
	@Step("Navigate to Admin Login Page")
	@Description("Naviagte to Admin Login Page from Home Page")
	@Test(description = "Navigate to Admin Login Page")
	public void TC01_Navigate_to_AdminLogin() throws Exception {

		AdminLogin adminlogin = new AdminLogin(driver);
		adminlogin.adminLogin_Navigation();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.ezscheduler.io/adminLogin");

	}
	@TestCaseId("TC_02")
	@Step("Admin Login with credentials")
	@Description("Admin Login with credentials")
	 @Test(dependsOnMethods = { "TC01_Navigate_to_AdminLogin" }, description =
	 "Login as Admin" ) 
	 public void TC02_AdminLogin() throws Exception {
	 
	AdminLogin adminlogin = new AdminLogin(driver);
	adminlogin.adminLogin();
     Assert.assertEquals(driver.getCurrentUrl(), "https://demo.ezscheduler.io/doctorQueue");

	 }

     @TestCaseId("TC_03")
     @Step("Create Doctor with the exsisting doctor Details")
     @Description("Create Doctor with the exsisting doctor Details")
	 @Test(dependsOnMethods = { "TC02_AdminLogin" }, description =
	 "Create Doctor Using Existing Doctor Details" ) 
	 public void TC03_CreateDoctorWithExistingDetaiils() throws Exception {
	 
	 CreateDoctor d = new CreateDoctor(driver);
	  	AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);

	 d.naviagtionToDoctorForm();
	 d.createDoctorProfile();
	 Assert.assertNotEquals(page.alertMessage.getText(), "Physician Saved");

	
	 }
	
	
	
	
	
	
	
	
	@AfterTest
	public void stopRecording() throws Exception {
		screenRecord.stopRecording();
	}

}
