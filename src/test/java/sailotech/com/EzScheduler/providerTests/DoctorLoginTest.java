package sailotech.com.EzScheduler.providerTests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;
import sailotech.com.EzScheduler.AdminFunctions.AdminFunctions;
import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import sailotech.com.EzScheduler.providerPages.DoctorLogin;
import sailotech.com.EzScheduler.providerPages.Doctor_ReadDataProvider;
import sailotech.com.EzScheduler.providerPages.Repository;
import utils.ScreenRecording;

public class DoctorLoginTest extends BaseTest{

	ScreenRecording screenRecord = new ScreenRecording();

	@BeforeClass
	public void startRecording() throws Exception {
		screenRecord.startRecording();
	}
	Doctor_ReadDataProvider exceldata = new Doctor_ReadDataProvider();

	@DataProvider(name = "testData")
	public Object[][] DataMethod() throws IOException {

		Object[][] arrayObject = exceldata.ReadVariant();
		return arrayObject;
	}
	
	@TestCaseId("TCD_01")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Doctor should be logged in successfully")
	@Test(description = "Doctor should be logged in successfully")
	
	public void TC01_NavigatetoDoctorLogin() throws Exception {

		DoctorLogin l = new DoctorLogin(driver);
		l.doctorLogin_Navigation();
		
	}
	
	@TestCaseId("TCD_02")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Doctor should be logged in successfully")
    @Test(dependsOnMethods = { "TC01_NavigatetoDoctorLogin" }, description ="Click on Login/Register button on the HomePage of EzScheduler." ) 
	 public void TC02_DoctorLogin() throws Exception {
	    //Repository r = new Repository(driver); 
		DoctorLogin d = new DoctorLogin(driver);
		d.doctorLogin();


	}
		 @AfterTest
			public void stopRecording() throws Exception {
				screenRecord.stopRecording();
			}

}
