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
import sailotech.com.EzScheduler.AdminFunctions.CheckForTheVerifiedDoctor;
import sailotech.com.EzScheduler.AdminFunctions.ViewDoctor;
import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import utils.ScreenRecording;

public class CheckForVerifiedDoctorTest extends BaseTest{
	ScreenRecording screenRecord = new ScreenRecording();
	@BeforeClass
	public void startRecording() throws Exception {
		screenRecord.startRecording();
	}
	@TestCaseId("TC_01")
	@Step("Admin Login")
	@Description("Naviagte to Admin Login page and Login with the credentials")
	@Test()
	public void TC01_AdminLogin() throws Exception {

		AdminLogin adminlogin = new AdminLogin(driver);
		adminlogin.adminLogin_Navigation();
		adminlogin.adminLogin();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.ezscheduler.io/doctorQueue");

	}
	@TestCaseId("TC_02")
	@Step("Check for the Verified Doctor in the Queue")
	@Description("Check for the Verified Doctor in the Queue")
	@Test(dependsOnMethods = { "TC01_AdminLogin" }, description =
			 "Check for the Verified Doctor in the Queue" ) 
			 public void TC02_Check_For_VerifiedDoctor() throws Exception {
			 
			CheckForTheVerifiedDoctor d = new CheckForTheVerifiedDoctor(driver);
			 d.check_for_the_verfied_doctor_from_unverified();;
			 

			 }

	
	
	@AfterTest
	public void stopRecording() throws Exception {
		screenRecord.stopRecording();
	}


}
