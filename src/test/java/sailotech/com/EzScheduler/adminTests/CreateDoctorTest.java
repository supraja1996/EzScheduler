package sailotech.com.EzScheduler.adminTests;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import sailotech.com.EzScheduler.basePages.BaseTest;
import utils.ScreenRecording;

import sailotech.com.EzScheduler.AdminFunctions.AdminLogin;
import sailotech.com.EzScheduler.AdminFunctions.CreateDoctor;


public class CreateDoctorTest extends BaseTest{
	
	public CreateDoctorTest() {
		super();
		System.out.println("*** CreateDoctorTest instantiated ***");
		// TODO Auto-generated constructor stub
	}
	
	
	//ScreenRecording screenRecord = new ScreenRecording();
	
	@BeforeClass
	public void startRecording() throws Exception {
		System.out.println("headless=>"+System.getProperty("java.awt.headless"));
		initBrowser();
		//startSession();
		//adminlogin = new AdminLogin(driver);
		//screenRecord.startRecording();
		
		
	}

@TestCaseId("TC_01")
@Step("Login as Admin with Admin Credentials")
@Description("Login as Admin with Admin Credentials")
@Test(description = "Login as Admin with Admin Credentials")

public void TC01_Navigate_to_AdminLogin() throws Exception {
	  
	   AdminLogin adminlogin = new AdminLogin(driver);
	   adminlogin.adminLogin_Navigation();
	   adminlogin.adminLogin();
	
//


}
@TestCaseId("TC_02")
	@Step("Create a Doctor")
	@Description("Create a Doctor")
	@Test(dependsOnMethods = { "TC01_Navigate_to_AdminLogin" }, description =
			 "Create a Doctor" ) 
	 public void TC02_CreateDoctor() throws Exception {
	 CreateDoctor createdoctor = new CreateDoctor(driver);
	 createdoctor.naviagtionToDoctorForm();
	 createdoctor.createDoctorProfile();
	 
	 }
//	@TestCaseId("TC_03")
//	@Step("Create a Doctor")
//	@Description("Create a Doctor")
//	@Test(dependsOnMethods = { "TC02_AdminLogin" }, description =
//	 "Create a Doctor" ) 
//	 public void TC03_CreateDoctor() throws Exception {
//	 
//	 CreateDoctor d = new CreateDoctor(driver);
//	 AdminPageRepositoryClass page = new AdminPageRepositoryClass(driver);
//
//	 d.naviagtionToDoctorForm();
//	 d.createDoctorProfile();
//
//
//
//	
//	 }
	
	
	
	
	
	
	
	
	@AfterTest
	public void stopRecording() throws Exception {
		//screenRecord.stopRecording();
		driver.quit();
	}
}
