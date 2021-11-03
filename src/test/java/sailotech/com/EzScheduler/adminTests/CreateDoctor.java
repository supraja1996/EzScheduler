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


public class CreateDoctor extends BaseTest{
	
	public CreateDoctor() {
		super();
		System.out.println("*** CreateDoctorTest instantiated ***");
		// TODO Auto-generated constructor stub
	}
	
	
	@Test
	public void test_login() {
		System.out.println("***** login test success ****");
	}
}
