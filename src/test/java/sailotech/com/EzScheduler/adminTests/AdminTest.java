package sailotech.com.EzScheduler.adminTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import sailotech.com.EzScheduler.AdminFunctions.AdminFunctions;
import sailotech.com.EzScheduler.AdminFunctions.AdminLogin;
import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import utils.ScreenRecording;

public class AdminTest extends BaseTest {
	
	ScreenRecording screenRecord = new ScreenRecording();
   

	
	@BeforeClass
	public void startRecording() throws Exception {
		screenRecord.startRecording();
		
//		startSession();
		
	}
	
	@TestCaseId("TCA_01")
	@Description("Admin Login Naviagtion")
	@Test()
	
	public void TCA_01_LoginNavigation() throws Throwable{
//try {
			AdminFunctions adminfunctions = new AdminFunctions();
		adminfunctions.adminLogin_Navigation(driver);
//}catch(Exception e) {
//	e.printStackTrace();
//}
	
	
		}
		
	
	@TestCaseId("TC_02")
	@Description("Login with the Admin Credentials")
	@Test(dependsOnMethods = { "TCA_01_LoginNavigation" }, description =
	 "Login with the Admin Credentials" ) 
	 public void TC02_AdminLogin() throws Exception
	{
		AdminFunctions adminfunctions = new AdminFunctions();
	 		 adminfunctions.adminLogin(); 
	}
	

	@TestCaseId("TC_03")
	@Description("Verify the Doctors from the Unverified Queue")
	@Test(dependsOnMethods = { "TC02_AdminLogin" }, description =
	 "Login with the Admin Credentials" ) 
	 public void TC03_VerifyDoctor() throws Exception
	{
		AdminFunctions adminfunctions = new AdminFunctions();
	 		 adminfunctions.unverifiedDoctorQueueNavigation(driver);
	 		 adminfunctions.verifyDoctor(driver);
	}
	
	
	@AfterTest
	public void stopRecording() throws Exception {
		screenRecord.stopRecording();
	}

}
