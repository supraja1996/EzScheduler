package sailotech.com.EzScheduler.consumerTests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import sailotech.com.EzScheduler.consumerPages.PatientLogin;
import sailotech.com.EzScheduler.consumerPages.PatientRegistration;
import sailotech.com.EzScheduler.consumerPages.PatientRepositoryClass;
import sailotech.com.EzScheduler.providerPages.DoctorLogin;
import sailotech.com.EzScheduler.readMails.OTP_for_Patient_Registration;
import utils.ScreenRecording;

public class PatientRegistrationTest extends BaseTest {

	ScreenRecording screenRecord = new ScreenRecording();

	@BeforeClass
	public void startRecording() throws Exception {
		screenRecord.startRecording();
		startSession();
		}
	@TestCaseId("TC_01")
	@Step("Naviagtion to Patient Registration")
	@Description("Naviagte to Patient Registration Page from Home Page")
	@Test(description = "Naviagte to Patient Registration Page from Home Page")
	public void TC01_Navigate_to_Patient_Registration() throws Exception {

		PatientRegistration l = new PatientRegistration(driver);
        l.navigation_to_patient_registration_page();

	}
	@TestCaseId("TC_02")
	@Step("Patient to register")
	@Description("Patient to register")
	@Test(dependsOnMethods = { "TC01_Navigate_to_Patient_Registration" }, description = "Patient to register" ) 
	  public void TC02_Patient_Registration() throws Exception {
	PatientRepositoryClass c= new PatientRepositoryClass(driver);
     PatientRegistration r = new PatientRegistration(driver);
     r.registrationPage();
     
	  }
	
//	 @Test(dependsOnMethods = { "TC02_Patient_Registration" }, description = "Patient Registration Page")
//	    public void TC03_ReadMailforOtp() throws Exception {
//           Thread.sleep(20000);
//			OTP_for_Patient_Registration l = new OTP_for_Patient_Registration();
//	        l.readMail();
//
//		}
//	
//	 @Test(dependsOnMethods = { "TC03_ReadMailforOtp" }, description = "Patient Registration Page" ) 
//	  public void TC04_otpPage() throws Exception {
//    PatientRegistration r = new PatientRegistration(driver);
//     r.otpPage();
//	  
//	  }
//	
//	
	
	
	
	
	
	@AfterTest
	public void stopRecording() throws Exception {
		screenRecord.stopRecording();
	}


}
