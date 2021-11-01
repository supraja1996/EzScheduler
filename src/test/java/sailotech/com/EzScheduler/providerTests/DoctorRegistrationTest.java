package sailotech.com.EzScheduler.providerTests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import sailotech.com.EzScheduler.providerPages.DoctorLogin;
import sailotech.com.EzScheduler.providerPages.Doctor_Registration;
import sailotech.com.EzScheduler.readMails.DoctorRegistration;
import utils.ScreenRecording;

public class DoctorRegistrationTest extends BaseTest {
	ScreenRecording screenRecord = new ScreenRecording();
	@BeforeClass
	public void startRecording() throws Exception {
		screenRecord.startRecording();
		startSession();
	}
	@TestCaseId("TC_01")
	@Step("Naviagtion to Doctor Registration Page")
	@Description("Naviagte to Doctor Registration Page from Home Page")
	@Test(description = "Navigate to Doctor Registration Page") 
	public void TC01_Naviagtion_to_Register() throws Exception {
	 Doctor_Registration d = new Doctor_Registration(driver);
	 d.navigation_to_Registration();
	 
	 }
	@TestCaseId("TC_02")
	@Step("Register with Doctor Details")
	@Description("Register with the Doctor Details")
	@Test(dependsOnMethods = { "TC01_Naviagtion_to_Register" }, description = "Register with the Doctor Details" ) 
	  public void TC02_DoctorRegisterPage() throws Exception {
		Doctor_Registration d = new Doctor_Registration(driver);
       d.registration_page();
      
	}
	
//	@Test(dependsOnMethods = { "TC02_DoctorRegisterPage" }, description = "Doctor Register Page" ) 
//	  public void TC03_ReadMailToGetCredentials() throws Exception {
//		DoctorRegistration d = new DoctorRegistration();
//        d.readMail();
//	}
	
	@AfterTest
	public void stopRecording() throws Exception {
		screenRecord.stopRecording();
	}

}
