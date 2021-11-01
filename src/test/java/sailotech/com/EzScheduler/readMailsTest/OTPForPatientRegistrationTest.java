package sailotech.com.EzScheduler.readMailsTest;

import org.testng.annotations.Test;

import sailotech.com.EzScheduler.readMails.OTP_for_Patient_Registration;

public class OTPForPatientRegistrationTest {

	@Test()
	public void TC01_Navigate_to_Patient_Registration() throws Exception {

		OTP_for_Patient_Registration o = new OTP_for_Patient_Registration();
        o.readMail();

	}
	
}
