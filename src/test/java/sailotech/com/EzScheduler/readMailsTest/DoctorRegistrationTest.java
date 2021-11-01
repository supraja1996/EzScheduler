package sailotech.com.EzScheduler.readMailsTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import sailotech.com.EzScheduler.readMails.DoctorRegistration;

public class DoctorRegistrationTest  {
	



	

	@Test()
	public void TC01_Navigate_to_Patient_Registration() throws Exception {

		DoctorRegistration l = new DoctorRegistration();
        l.readMail();

	}
	



}
