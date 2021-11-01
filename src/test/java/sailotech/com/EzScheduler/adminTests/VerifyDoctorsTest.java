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
import sailotech.com.EzScheduler.AdminFunctions.DoctorVerification;
import sailotech.com.EzScheduler.AdminFunctions.Navigations;
import sailotech.com.EzScheduler.adminPages.AdminPageRepositoryClass;
import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import utils.ScreenRecording;

public class VerifyDoctorsTest  extends BaseTest{
	


    ScreenRecording screenRecord = new ScreenRecording();


		@BeforeClass
		public void startRecording() throws Exception {
			
			screenRecord.startRecording();
	
		}
		@TestCaseId("TC_01")
		@Step("Admin Login")
		@Description("Admin Login")
		@Test(description = "Admin Login")
	
	public void TC01_Navigate_to_AdminLogin() throws Throwable {

	
			AdminLogin AdminLogin = new AdminLogin(driver);
			AdminLogin.adminLogin_Navigation();
			AdminLogin.adminLogin();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.ezscheduler.io/doctorQueue");

	}
	@TestCaseId("TC_02")
	@Step("Verify Doctor from Unverified Doctor Queue")
	@Description("Verify Doctor from Unverified Doctor Queue")
    @Test(dependsOnMethods = { "TC01_Navigate_to_AdminLogin" }, description =
   		 "Verify Doctor from the Unverified Queue" ) 
   		 public void TC02_VerifyDoctor() throws Throwable {
   		 
   		
   		 DoctorVerification doctorVerification = new DoctorVerification(driver);
   		doctorVerification.verifiy_particular_Doctor_withTrialDate();
   		//Assert.assertEquals(page.alertMessage.getText(), "Physician Saved");
   		 
   		 

   		 }
	 
	@TestCaseId("TC_03")
	@Step("Logout from Admin")
	@Description("Logout from Admin")
    @Test(dependsOnMethods = { "TC02_VerifyDoctor" }, description =
   		 "Logout from Admin" ) 
   		 public void TC03_Logout() throws Throwable {
   		 
   
   		 Navigations navigations = new Navigations(driver);
   		 navigations.logout();

   		
   		 
   		 

   		 }
	 

	
	
	
	

	@AfterTest
	public void stopRecording() throws Exception {
		screenRecord.stopRecording();
	}

}
