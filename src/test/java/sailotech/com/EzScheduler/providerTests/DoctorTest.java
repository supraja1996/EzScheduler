package sailotech.com.EzScheduler.providerTests;




import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import sailotech.com.EzScheduler.basePages.BaseTest;
import sailotech.com.EzScheduler.providerPages.DoctorLogin;
import utils.ScreenRecording;

public class DoctorTest extends BaseTest{
	ScreenRecording screenRecord;
	
	 public DoctorTest() {
	       super();
	   }

	  @BeforeClass
	   public void screenRecord() throws Exception {
	       startSession();
	  }
	    @TestCaseId("TC_01")
	   	@Step("Naviagtion to Doctor Login")
	   	@Description("Naviagte to Doctor Login Page from Home Page")
	   	@Test(description = "Navigate to Doctor Login Page") 
	   	public void TC01_Naviagtion_to_Login() throws Exception {
	   	 DoctorLogin d = new DoctorLogin(driver);
	   	 d.doctorLogin_Navigation();
	   	 
	   	 }
}
