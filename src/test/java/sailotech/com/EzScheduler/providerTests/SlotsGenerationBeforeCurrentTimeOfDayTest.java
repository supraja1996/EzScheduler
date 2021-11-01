package sailotech.com.EzScheduler.providerTests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import sailotech.com.EzScheduler.providerPages.DoctorLogin;
import sailotech.com.EzScheduler.providerPages.GenerateSlots;
import sailotech.com.EzScheduler.providerPages.Repository;
import utils.ScreenRecording;

public class SlotsGenerationBeforeCurrentTimeOfDayTest extends BaseTest{
	
	ScreenRecording screenRecord = new ScreenRecording();

		@BeforeClass
		public void startRecording() throws Exception {
			screenRecord.startRecording();
		}
		
		@Test()
		public void TC01_DoctorLogin() throws Exception {

			 DoctorLogin d = new DoctorLogin(driver);
			 d.doctorLogin_Navigation();
			 d.doctorLogin();

		}

		 @Test(dependsOnMethods = { "TC01_DoctorLogin" }, description =
		 "Generate Slots for the Past time for the current day" ) 
		 public void TC02_GenerateSlots() throws Exception {
		 Repository r = new Repository(driver);
		 GenerateSlots d = new GenerateSlots(driver);
		 d.navigation_to_GenerateSlots();
		 d.generate_slots_page();
		 Assert.assertEquals(r.Alert.getText(), "You are not allowed to create schedule for old dates");

		 

		 }


			@AfterTest
			public void stopRecording() throws Exception {
				screenRecord.stopRecording();
			}

}
