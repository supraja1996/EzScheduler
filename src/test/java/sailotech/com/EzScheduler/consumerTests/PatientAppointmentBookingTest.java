package sailotech.com.EzScheduler.consumerTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import sailotech.com.EzScheduler.consumerPages.AppointmentBooking;
import sailotech.com.EzScheduler.consumerPages.PatientLogin;
import utils.ScreenRecording;


public class PatientAppointmentBookingTest extends BaseTest{
	
	ScreenRecording screenRecord = new ScreenRecording();

	@BeforeClass
	public void startRecording() throws Exception {
		screenRecord.startRecording();
		//startSession();
	}
	@TestCaseId("TC_01")
	@Step("Naviagtion to Patient Login")
	@Description("Naviagte to Patient Login Page from Home Page")
	@Test(description = "Naviagte to Patient Login Page from Home Page")
	public void TC01_Navigate_to_LoginRegister() throws Exception {

		PatientLogin l = new PatientLogin(driver);
        l.patientLogin_Navigation();

	}
	@TestCaseId("TC_02")
	@Step("Patient Login with credentials")
	@Description("Patient Login with credentials")
	 @Test(dependsOnMethods = { "TC01_Navigate_to_LoginRegister" }, description =
	 "Patient Login with credentials" ) 
	 public void TC02_PatientLogin() throws Exception {
	 
	 PatientLogin d = new PatientLogin(driver);
	 d.patientLogin();
	
	 

	 }
	 
	@TestCaseId("TC_03")
	@Step("Search For Doctor")
	@Description("Search For Doctor")	
    @Test(dependsOnMethods = { "TC02_PatientLogin" }, description =
		  "Search For Doctor" )
       public void TC03_serach_for_doctor() throws Exception {
		AppointmentBooking d = new AppointmentBooking(driver);
   	  d.slot_booking();
		  // d.aappointment_booking_with_filters();		 		  
		 }
//	@TestCaseId("TC_04")
//	@Step("Book an Appointment for a Doctor")
//	@Description("Book an Appointment for a Doctor")		  
//    @Test(dependsOnMethods = { "TC03_serach_for_doctor" },
//		  description = "Book an Appointment for a Doctor" ) 
//       public void TC04_slot_booking() throws Exception {
//	 
//		  AppointmentBooking d = new AppointmentBooking(driver);
//     	  d.slot_booking();
//		  
		  
// }
		  
		
     
	@AfterTest
	public void stopRecording() throws Exception {
		screenRecord.stopRecording();
		driver.quit();
	}


}
