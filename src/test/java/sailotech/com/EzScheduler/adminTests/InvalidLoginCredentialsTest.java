package sailotech.com.EzScheduler.adminTests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import sailotech.com.EzScheduler.AdminFunctions.AdminFunctions;
import sailotech.com.EzScheduler.AdminFunctions.AdminLogin;
import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import utils.ScreenRecording;

public class InvalidLoginCredentialsTest extends BaseTest{
	
	ScreenRecording screenRecord = new ScreenRecording();

	@BeforeClass
	public void startRecording() throws Exception {
		screenRecord.startRecording();
	}
	@TestCaseId("TC_01")
	@Step("Navigate to Admin Login Page")
	@Description("Navigate to Admin Login Page")
	@Test()
	public void TC01_Navigate_to_AdminLogin() throws Exception {

		AdminLogin AdminLogin = new AdminLogin(driver);
		AdminLogin.adminLogin_Navigation();
		

	}

	@TestCaseId("TC_02")
	@Step("Login  with the Invalid Credentials")
	@Description("Login  with the Invalid Credentials")
	@Test(dependsOnMethods = { "TC01_Navigate_to_AdminLogin" }, description =
			 "Login  with the Invalid Credentials" ) 
			 public void TC03_AdminLogin() throws Exception {
			 
		    AdminLogin a = new AdminLogin(driver);
			a.adminLogin();
			Assert.assertEquals(driver.getCurrentUrl(), "https://demo.ezscheduler.io/adminLogin");
			 }
	 @AfterTest
	 
		public void stopRecording() throws Exception {
			screenRecord.stopRecording();
			driver.quit();
		}

}
