package sailotech.com.EzScheduler.providerTests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;
import sailotech.com.EzScheduler.adminPages.RepositoryClass;
import sailotech.com.EzScheduler.basePages.BaseTest;
import sailotech.com.EzScheduler.providerPages.DoctorLogin;
import sailotech.com.EzScheduler.providerPages.GenerateSlots;
import sailotech.com.EzScheduler.providerPages.Logout;
import sailotech.com.EzScheduler.providerPages.Navigations;
import utils.ScreenRecording;

public class SlotGenerationTest extends BaseTest {
	
	public SlotGenerationTest() {
	       super();
	   }
	@BeforeClass
	   public void screenRecord() throws Exception {
		initBrowser();
	  }
	
	@TestCaseId("TC_01")
	@Step("Naviagtion to Doctor Login")
	@Description("Naviagte to Doctor Login Page from Home Page")
	@Test(description = "Navigate to Doctor Login Page") 
	public void TC01_Naviagtion_to_Login() throws Exception {
	 DoctorLogin d = new DoctorLogin(driver);
	 d.doctorLogin_Navigation();
	 
	 }
	@TestCaseId("TC_02")
	@Step("Login with Doctor Credentials")
	@Description("Login with Doctor Credentials")
    @Test(dependsOnMethods = { "TC01_Naviagtion_to_Login" }, description = "Login with Doctor Credentials" ) 
	  public void TC02_DoctorLogin() throws Exception {
       DoctorLogin d = new DoctorLogin(driver);
       d.doctorLogin();
  
	  
	  }

	@TestCaseId("TC_03")
	@Step("Navigate to Slot Generation Page")
	@Description("Navigate to Slot Generation Page") 
	@Test(dependsOnMethods = { "TC02_DoctorLogin" },
	description = "Navigate to Slot Generation Page after Login and Generate Slots" )
	public void TC03_Navigation_to_the_GenerateSLots_Page() throws Exception { 
		GenerateSlots f = new GenerateSlots(driver); 
		f.navigation_to_GenerateSlots();
		f.generate_slots_page();
	 
	  }
	@TestCaseId("TC_04")
	@Step("Check the dates for which the slots generated")
	@Description("Check the dates for which the slots generated") 
	@Test(dependsOnMethods = { "TC03_Navigation_to_the_GenerateSLots_Page" },
			description = "Check the Slots generated for the Dates" )
			public void TC04_Generate_slots_on_GenerateSlots_Page() throws Exception { 
				GenerateSlots f = new GenerateSlots(driver); 
				Navigations n = new Navigations(driver);
				n.navigatetoMySchedule();
				f.check_the_slots();
			 
			  }
	@TestCaseId("TC_05")
	@Step("Logout after slot generation")
	@Description("Logout after slot generation") 
	@Test(dependsOnMethods = { "TC04_Generate_slots_on_GenerateSlots_Page" },
					description = "Logout after slots Generation" )
					public void TC05_Doctor_Logout() throws Exception { 
						Logout l = new Logout(driver); 
						l.dcotor_logout();
					 
					  }
		
	
	@AfterTest
	public void stopRecording() throws Exception {
		//screenRecord.stopRecording();
		driver.close();
	}

}
