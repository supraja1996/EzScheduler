package sailotech.com.EzScheduler.providerTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import sailotech.com.EzScheduler.providerPages.DoctorCancelsAppointments;
import sailotech.com.EzScheduler.providerPages.DoctorLogin;
import sailotech.com.EzScheduler.providerPages.GenerateSlots;
import utils.ScreenRecording;

public class DoctorCancellation extends BaseTest{
	ScreenRecording screenRecord = new ScreenRecording();
	@BeforeClass
	public void startRecording() throws Exception {
		screenRecord.startRecording();
	}
	
	@Test() 
	public void TC01_Naviagtion_to_Login() throws Exception {
	 DoctorLogin d = new DoctorLogin(driver);
	 d.doctorLogin_Navigation();
	 
	 }
	
	  @Test(dependsOnMethods = { "TC01_Naviagtion_to_Login" }, description = "Doctor Login" ) 
	  public void TC02_DoctorLogin() throws Exception {
       DoctorLogin d = new DoctorLogin(driver);
       d.doctorLogin();
  
	  
	  }
	 
	@Test(dependsOnMethods = { "TC02_DoctorLogin" },
	description = "Navigates to the slot generation screen" )
	public void TC03_DoctorCancelsOpenSlots() throws Exception { 
		DoctorCancelsAppointments f = new DoctorCancelsAppointments(driver); 
		f.cancel_open_slots();
	 
	  }
	 
	
	
	@AfterTest
	public void stopRecording() throws Exception {
		screenRecord.stopRecording();
	}

}
