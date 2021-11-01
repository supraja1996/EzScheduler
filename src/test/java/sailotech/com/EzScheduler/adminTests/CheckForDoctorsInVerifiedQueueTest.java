package sailotech.com.EzScheduler.adminTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import sailotech.com.EzScheduler.AdminFunctions.AdminLogin;
import sailotech.com.EzScheduler.AdminFunctions.CheckForTheVerifiedDoctor;
import sailotech.com.EzScheduler.basePages.BaseTest;
import utils.ScreenRecording;

public class CheckForDoctorsInVerifiedQueueTest extends BaseTest{
	
	ScreenRecording screenRecord = new ScreenRecording();
	
	@BeforeClass
	public void startRecording() throws Exception {
		
		startSession();
		//adminlogin = new AdminLogin(driver);
		screenRecord.startRecording();
		
		
	}
	@TestCaseId("TC_01")
	@Step("Login as Admin with Admin Credentials")
	@Description("Login as Admin with Admin Credentials")
	@Test(description = "Login as Admin with Admin Credentials")

	public void TC01_Navigate_to_AdminLogin() throws Exception {
//try {	  
		   AdminLogin adminlogin = new AdminLogin(driver);
		   adminlogin.adminLogin_Navigation();
		   adminlogin.adminLogin();
//}catch (Throwable e) {
//	
//	e.printStackTrace();
//}	
    
	}
	@TestCaseId("TC_02")
	@Step("Check for the Doctors in the Verified Doctor Queue")
	@Description("Check for the Doctors in the Verified Doctor Queue")
	@Test(dependsOnMethods = { "TC01_Navigate_to_AdminLogin" }, description =
	 "Check for the Doctors in the Verified Doctor Queue" ) 
	 public void TC02_AdminLogin() throws Exception
	{
	 		   CheckForTheVerifiedDoctor verifieddoctor = new CheckForTheVerifiedDoctor(driver);
               verifieddoctor.check_for_the_verfied_doctor_from_unverified();
	 }

	@AfterTest
	public void stopRecording() throws Exception {
		screenRecord.stopRecording();
		//driver.quit();
	}


}
