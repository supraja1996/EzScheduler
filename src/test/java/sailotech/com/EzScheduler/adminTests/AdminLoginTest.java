package sailotech.com.EzScheduler.adminTests;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import sailotech.com.EzScheduler.AdminFunctions.AdminFunctions;
import sailotech.com.EzScheduler.AdminFunctions.AdminLogin;
import sailotech.com.EzScheduler.basePages.BaseTest;
import utils.ScreenRecording;


public class AdminLoginTest extends BaseTest{
	
	
	
	ScreenRecording screenRecord = new ScreenRecording();

//	ScreenRecording screenRecord;
//    AdminLogin adminlogin;
//   ITestResult tr = null;
//    
//    public AdminLoginTest() {
//	       super();
//	   }
//
//    @BeforeMethod
//	   public void setUp(ITestResult tr) {
//	       tr.setAttribute("class", getClass().getName());
//	       tr.setAttribute("toString", tr.toString());
//	       this.tr = tr;
//
//	   }


		@BeforeClass
		public void startRecording() throws Exception {
			
			startSession();
			//adminlogin = new AdminLogin(driver);
			screenRecord.startRecording();
			
			
		}

//		   @TestCaseId("TC_01")
//		   @Test(description = "Naviagte to Admin Login Page from Home Page")
		@TestCaseId("TC_01")
		@Step("Naviagtion to Admin Login")
		@Description("Naviagte to Admin Login Page from Home Page")
		@Test(description = "Navigate to Admin Login Page for Login")
	
		public void TC01_Navigate_to_AdminLogin() throws Exception {
	//try {	  
			   AdminLogin adminlogin = new AdminLogin(driver);
			   adminlogin.adminLogin_Navigation();
//	}catch (Throwable e) {
//		
//		e.printStackTrace();
//	}	
        
		}
		@TestCaseId("TC_02")
		@Step("Login with Admin Credentials")
		@Description("Login with the Admin Credentials")
		@Test(dependsOnMethods = { "TC01_Navigate_to_AdminLogin" }, description =
		 "Login with the Admin Credentials" ) 
		 public void TC02_AdminLogin() throws Exception
		{
		 		   AdminLogin adminlogin = new AdminLogin(driver);

			adminlogin.adminLogin();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        // Assert.assertEquals(driver.getCurrentUrl(), "https://demo.ezscheduler.io/doctorQueue");
 

		 }

		@AfterTest
		public void stopRecording() throws Exception {
			screenRecord.stopRecording();
			driver.quit();
		}

	}



