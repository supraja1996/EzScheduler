package sailotech.com.EzScheduler.adminTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sailotech.com.EzScheduler.AdminFunctions.AdminFunctions;
import sailotech.com.EzScheduler.AdminFunctions.HomePageofEzScheduler;
import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import utils.ScreenRecording;

public class HomePageVerficationTest extends BaseTest{
	ScreenRecording screenRecord = new ScreenRecording();
	@BeforeClass
	public void startRecording() throws Exception {
		screenRecord.startRecording();
	}


	@Test(description = "Navigate to Admin Login Page")
	public void TC01_VerifyHomepage() throws Exception {

		HomePageofEzScheduler h = new HomePageofEzScheduler(driver);
		h.verifyHomePage();

	}

	
	
	
	
	@AfterTest
	public void stopRecording() throws Exception {
		screenRecord.stopRecording();
	}

}
