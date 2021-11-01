package sailotech.com.EzScheduler.readMailsTest;

import org.testng.annotations.Test;

import sailotech.com.EzScheduler.readMails.Patient_Login_Credentials;

public class PatientLoginCredentialsTest {

	
	@Test()
	public void TC01_Navigate_to_Patient_Registration() throws Exception {

		Patient_Login_Credentials p = new Patient_Login_Credentials();
        p.readMail();

	}
}
