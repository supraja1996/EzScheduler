package sailotech.com.EzScheduler.adminTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import sailotech.com.EzScheduler.AdminFunctions.AdminFunctions;
import sailotech.com.EzScheduler.AdminFunctions.AdminLogin;
import sailotech.com.EzScheduler.AdminFunctions.ViewDoctor;
import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import utils.ScreenRecording;

public class ViewDcotorTest extends BaseTest{
	ScreenRecording screenRecord = new ScreenRecording();

	@BeforeClass
	public void startRecording() throws Exception {
		screenRecord.startRecording();
	}
	@TestCaseId("TC_01")
	@Step("Navigate to Admin Login Page and Login with the credentials")
	@Description("Naviagte to Admin Login Page from Home Page")
	@Test(description = "Navigate to Admin Login Page for Login")
	public void TC01_AdminLogin() throws Exception {

		AdminLogin AdminLogin = new AdminLogin(driver);
		AdminLogin.adminLogin_Navigation();
		AdminLogin.adminLogin();

	}
	@TestCaseId("TC_02")
	@Step("View Doctor from verified Queue")
	@Description("View Doctor from verified Queue")
	@Test(dependsOnMethods = { "TC01_AdminLogin" }, description =
			 "View Doctor from verified Queue" ) 
			 public void TC02_ViewProfile_OF_VerifiedDoctor() throws Exception {
			 
			ViewDoctor d = new ViewDoctor(driver);
			 d.viewVerifiedDoctorProfile();
			 

			 }

	
	
	@AfterTest
	public void stopRecording() throws Exception {
		screenRecord.stopRecording();
	}

}
