package sailotech.com.EzScheduler.adminPages;

//import static org.monte.media.FormatKeys.EncodingKey;
//import static org.monte.media.FormatKeys.FrameRateKey;
//import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
//import static org.monte.media.FormatKeys.MIME_AVI;
//import static org.monte.media.FormatKeys.MediaTypeKey;
//import static org.monte.media.FormatKeys.MimeTypeKey;
//import static org.monte.media.VideoFormatKeys.CompressorNameKey;
//import static org.monte.media.VideoFormatKeys.DepthKey;
//import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
//import static org.monte.media.VideoFormatKeys.QualityKey;

//import java.awt.GraphicsConfiguration;
//import java.awt.GraphicsEnvironment;
//
//import org.monte.media.Format;
//import org.monte.media.FormatKeys.MediaType;
//import org.monte.media.math.Rational;
//import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactory;

import sailotech.com.EzScheduler.basePages.BaseTest;


public class RepositoryClass  extends BaseTest{
	

	public RepositoryClass(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);

	}
	
	 public static By buttonLoginRegister = By.xpath("//span[text() = 'Login/Register']");

	 public static By adminLogin = By.xpath("//li[3]//h5[1]//a[1]");

	 public static By adminUserName = By.name("email");
	 
	 public static By adminPassword = By.name("password");
	 
	 public static By adminSignIN = By.xpath("//span[contains(text(),'Sign In')]");
	 
	 public static By elementAfterLogin = By.xpath("//h3[contains(text(),'Doctors Queue')]");
	 
	 public static By Logout = By.xpath("//span[contains(text(),'Logout')]");
	 
	 public static By InvalidCredentials = By.xpath("//span[contains(text(),'Invalid Credentials')]");

	 public static By unverifiedDoctors = By.xpath("//span[contains(text(),'UnVerified Doctors')]");
	 
	 public static By verifiedDoctors = By.xpath("//span[contains(text(),'Verified Doctors')]");

//	 public static By unverifiedadminTable = By.xpath("//div[2]/div/div/table/tbody[1]");

	 public  static WebElement unverifiedadminTable() {
		 return driver.findElement(By.xpath("//div[2]/div/div/table/tbody[1]"));
		}
//	 public static By unverifiedrows = By.xpath("//div[2]/div/div/table/tbody/tr");
	 
	 public  static WebElement unverifiedrows() {
		 return driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr"));
		}
//	 public static By unverifiedcolumns =By.xpath("//div[2]/div/div/table/tbody/tr[1]/th");
	 
	 public  static WebElement unverifiedcolumns() {
		 return driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr[1]/th"));
		}
	 
	 public  static WebElement unverifiedcellData(int rnum,int cnum) {
		 return driver.findElement(By.xpath("//div[2]/div/div/table/tbody[1]/tr["+rnum+"]/td["+cnum+"]"));
		}
		public static WebElement editButtonforUnverified(int rnum) {
			return driver.findElement(By.xpath("//div[2]/div/div/table/tbody[1]/tr["+rnum+"]/td[7]/a[1]/button"));
		}
		public static WebElement viewButtonforUnverified(int rnum) {
			return driver.findElement(By.xpath("//div[2]/div/div/table/tbody[1]/tr["+rnum+"]/td[7]/a[2]/button"));
		}
		public static WebElement editButtonforVerified(int rnum) {
			return driver.findElement(By.xpath("//div[1]/div/div/table/tbody[1]/tr["+rnum+"]/td[7]/a[1]/button"));
		
		}
		public static WebElement viewButtonforVerified(int rnum) {
			return driver.findElement(By.xpath("//div[1]/div/div/table/tbody[1]/tr["+rnum+"]/td[7]/a[2]/button"));
		
		}

	public static By elementOnDoctorProfile = By.xpath("//h4[text() = 'About']");
	
		
	 public static By yesVerifyDoctor = By.xpath("//div[8]/div[1]/div[1]/label[2]/span[contains(text(),'Yes')]");

	 public static By noVerifyDoctor = By.xpath("//div[8]/div[1]/div[1]/label[3]/span[contains(text(),'No')]");
	 
	 public static By saveProfile = By.xpath("//span[contains(text(),'Save Profile')]");

	 public static By Menu = By.xpath("//header/div[1]/div[1]/*[1]");
	 
	 public static By DoctorQueue = By.xpath("//div[1]/nav/div[2]");
	 
	 public static By PatientQueue = By.xpath("//span[contains(text(),'Patient Queue')]");

	 public static By elementOnPatientQueue = By.xpath("//h3[contains(text(),'Patient Queue')]");

	 public static By verifiedadminTable = By.xpath("//div[1]/div/div/table/tbody[1]");

	 public static By verifiedrows = By.xpath("//div[1]/div/div/table/tbody/tr");

	 public static By verifiedcolumns = By.xpath("//div[1]/div/div/table/tbody/tr[1]/th");

	 public static WebElement verifiedcellData(int rnum,int cnum) {
			return driver.findElement(By.xpath("//div[1]/div/div/table/tbody/tr["+rnum+"]/td["+cnum+"]"));
		}

	 public static By dateOnCalendar = By.xpath("//div[@class = 'MuiPickersSlideTransition-transitionContainer MuiPickersCalendarHeader-transitionContainer']");

	 public static By previousButton = By.xpath("//div[@class = 'MuiPickersCalendarHeader-switchHeader']/button[1]");

	 public static By nextButton = By.xpath("//div[@class = 'MuiPickersCalendarHeader-switchHeader']/button[2]");

	 public static By trailStartDate = By.name("trailStartDate");

	 public static By trailEndDate = By.name("trailEndDate");

	 public static By requiredusernameError = By.xpath("//form/fieldset/div/div[1]/div/p");

	 public static By requiredpasswordError = By.xpath("//form/fieldset/div/div[2]/div/p");

	 public static By requirederror = By.xpath("//p[@class = 'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-marginDense']");

	 public static By invalidCredentials = By.xpath("//span[@class = 'text-red']");
	
	 public static By createbutton = By.xpath("//span[contains(text(),'Create')]");

	 public static By namefield = By.name("name");
	 
	 public static By phonefield = By.name("mobileNo");
	 
	 public static WebElement gender(String gn) {
	 	   return driver.findElement(By.xpath("//span[contains(text(),'"+gn+"')]"));
	 		
	    } 
	 public static By emailfield = By.name("email");

	 public static By degreefield = By.name("education");

	 public static By specilaizationsfield = By.name("specializations");

	 public static By startDate = By.name("startDate");

	 public static By Date(String dat) {
	  	   return By.xpath("//p[text()='"+dat+"']");
	  		
	     } 
		 
	 public static By conditiontreatedfield = By.name("treatment");
	 
	 public static By proceduresPerformedfield = By.name("procedurePerformed");

	 public static By LanguagesSpokenfield = By.name("LanguagesSpoken");

	 public static By consultationfeesfield = By.name("price");
	 
	 public static WebElement videoConsultation(String vc) {
  	   return driver.findElement( By.xpath("//span[contains(text(),'"+vc+"')]"));
  		
     } 
	 public static By uploadImage = By.xpath("//span[text() = 'Upload Image']");
	 
	 public static By yearSelectionButton = By.xpath("//h6");
	 
	 public static WebElement year(String yr) {
	   	   return driver.findElement(By.xpath("//div[contains(text(),'"+yr+"')]"));
	   		
	      } 
	 

	 public static By saveButton = By.xpath("//span[text() = 'Save Profile & Add Location']");
	 
	 public static By alertMessage = By.xpath("//div[@class = 'MuiAlert-message']");

	 public static By lookingForDoctor = By.xpath("//h1[contains(text(),'Looking for a doctor?')]");

	 public static By generateslotsbutton = By.xpath("//span[text() = 'Generate Slots']");

	 public static By noofRowsinUnverified = By.xpath("//div[2]/div/div/table/tfoot/tr/td/div/div[2]/div[@class = 'MuiSelect-root MuiSelect-select MuiTablePagination-select MuiSelect-selectMenu MuiInputBase-input']");

	 public static By noofRowsVerified = By.xpath("//div[1]/div/div/table/tfoot/tr/td/div/div[2]/div[@class ='MuiSelect-root MuiSelect-select MuiTablePagination-select MuiSelect-selectMenu MuiInputBase-input']");

	 public static By unverifiedNextButton = By.xpath("//div[2]/div/div/table/tfoot/tr/td/div/div[3]/button[2]");

	 public static By verifiedNextButton = By.xpath("//div[1]/div/div/table/tfoot/tr/td/div/div[3]/button[2]");


 
	 


	 

	 

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
