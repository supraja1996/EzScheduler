package sailotech.com.EzScheduler.consumerTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import sailotech.com.EzScheduler.basePages.BaseTest;
import sailotech.com.EzScheduler.consumerPages.PatientLogin;
import sailotech.com.EzScheduler.consumerPages.SearchDoctorUsingFilter;
import utils.ScreenRecording;

public class AppointmentBookingUsingFilters  extends BaseTest {
	
	ScreenRecording screenRecord = new ScreenRecording();

	@BeforeClass
	public void startRecording() throws Exception {
		screenRecord.startRecording();
	}
	@TestCaseId("TC_01")
	@Step("Naviagtion to Patient Login Page and Login with Patient Credentials")
	@Description("Naviagtion to Patient Login Page and Login with Patient Credentials")
    @Test(description = "Naviagtion to Patient Login Page and Login with Patient Credentials")
	public void TC01_Patient_Login() throws Exception {

		PatientLogin l = new PatientLogin(driver);
        l.patientLogin_Navigation();
        l.patientLogin();

	}
	@TestCaseId("TC_02")
	@Step("Apply Filters to serach for Dotor")
	@Description("Apply Filters to serach for Dotor")
	@Test(dependsOnMethods = { "TC01_Patient_Login" }, description =
			 "Apply Filters to serach for Dotor" ) 
	 public void TC02_ApplyFilters() throws Exception {
			 
		SearchDoctorUsingFilter d = new SearchDoctorUsingFilter(driver);
			 d.applyfilters();
			
			 

			 }



}
