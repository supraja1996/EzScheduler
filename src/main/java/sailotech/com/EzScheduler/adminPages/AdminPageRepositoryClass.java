package sailotech.com.EzScheduler.adminPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPageRepositoryClass {
	
	WebDriver driver;
	
	public AdminPageRepositoryClass(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);

	}
	
	@FindBy(xpath = "//span[contains(text(),'Login/Register')]")
	public WebElement buttonLoginRegister;
	
	@FindBy(xpath = "//li[3]//h5[1]//a[1]")
	public WebElement adminLogin;
	
	@FindBy(name = "email")
	public WebElement adminUserName;
	
	@FindBy(name = "password")
	public WebElement adminPassword;
	
	@FindBy(xpath = "//span[contains(text(),'Sign In')]")
	public WebElement adminSignIN;
	
	@FindBy(xpath = "//h3[contains(text(),'Doctors Queue')]")
	public WebElement elementAfterLogin;
	
	@FindBy(xpath = "//span[contains(text(),'Logout')]")
	public WebElement Logout;
	
	@FindBy(xpath = "//span[contains(text(),'Invalid Credentials')]")
	public WebElement InvalidCredentials;
	
	@FindBy(xpath = "//span[contains(text(),'UnVerified Doctors')]")
	public WebElement unverifiedDoctors;
	
	@FindBy(xpath = "//span[contains(text(),'Verified Doctors')]")
	public WebElement verifiedDoctors;
	
	@FindBy(xpath = "//div[2]/div/div/table/tbody[1]")
	public WebElement unverifiedadminTable;
	
	@FindBy(xpath = "//div[2]/div/div/table/tbody/tr")
	public WebElement unverifiedrows;

	@FindBy(xpath = "//div[2]/div/div/table/tbody/tr[1]/th")
	public WebElement unverifiedcolumns;

	public  WebElement unverifiedcellData(int rnum,int cnum) {
		return driver.findElement(By.xpath("//div[2]/div/div/table/tbody[1]/tr["+rnum+"]/td["+cnum+"]"));
	}
	public WebElement editButtonforUnverified(int rnum) {
		return driver.findElement(By.xpath("//div[2]/div/div/table/tbody[1]/tr["+rnum+"]/td[7]/a[1]/button"));
	}
	public WebElement editButtonforVerified(int rnum) {
		return driver.findElement(By.xpath("//div[1]/div/div/table/tbody[1]/tr["+rnum+"]/td[7]/a[1]/button"));
	
	}
	public WebElement viewButtonforVerified(int rnum) {
		return driver.findElement(By.xpath("//div[1]/div/div/table/tbody[1]/tr["+rnum+"]/td[7]/a[2]/button"));
	
	}
	
	@FindBy(xpath = "//div[8]/div[1]/div[1]/label[2]/span[contains(text(),'Yes')]")
	public WebElement yesVerifyDoctor;
	
	@FindBy(xpath = "//div[8]/div[1]/div[1]/label[3]/span[contains(text(),'No')]")
	public WebElement noVerifyDoctor;
	
	@FindBy(xpath = "//span[contains(text(),'Save Profile')]")
	public WebElement saveProfile;
	
	@FindBy(xpath = "//header/div[1]/div[1]/*[1]")
	public WebElement Menu;
	
	@FindBy(xpath = "//div[1]/nav/div[2]")
	public WebElement DoctorQueue;
	
	@FindBy(xpath = "//span[contains(text(),'Patient Queue')]")
	public WebElement PatientQueue;
	
	@FindBy(xpath ="//h3[contains(text(),'Patient Queue')]")
	public WebElement elementOnPatientQueue;
	
	@FindBy(xpath = "//div[1]/div/div/table/tbody[1]")
	public WebElement verifiedadminTable;
	
	@FindBy(xpath = "//div[1]/div/div/table/tbody/tr")
	public WebElement verifiedrows;

	@FindBy(xpath = "//div[1]/div/div/table/tbody/tr[1]/th")
	public WebElement verifiedcolumns;
	
	public WebElement verifiedcellData(int rnum,int cnum) {
		return driver.findElement(By.xpath("//div[1]/div/div/table/tbody/tr["+rnum+"]/td["+cnum+"]"));
	}
	
	@FindBy(xpath = "//p[text() = '1']")
	public WebElement oneDate;
	
	@FindBy(xpath = "//p[text() = '2']")
	public WebElement twoDate;
	
	@FindBy(xpath = "//p[text() = '3']")
	public WebElement threeDate;
	
	@FindBy(xpath = "//p[text() = '4']")
	public WebElement fourDate;
	
	@FindBy(xpath = "//p[text() = '5']")
	public WebElement fiveDate;
	
	@FindBy(xpath = "//p[text() = '6']")
	public WebElement sixDate;
	
	@FindBy(xpath = "//p[text() = '7']")
	public WebElement sevenDate;
	
	@FindBy(xpath = "//p[text() = '8']")
	public WebElement eightDate;
	
	@FindBy(xpath = "//p[text() = '9']")
	public WebElement nineDate;
	
	@FindBy(xpath = "//p[text() = '10']")
	public WebElement tenDate;
	
	@FindBy(xpath = "//p[text() = '11']")
	public WebElement elevenDate;
	
	@FindBy(xpath = "//p[text() = '12']")
	public WebElement twelveDate;
	
	@FindBy(xpath = "//p[text() = '13']")
	public WebElement thirteenDate;
	
	@FindBy(xpath = "//p[text() = '14']")
	public WebElement forteenDate;
	
	@FindBy(xpath = "//p[text() = '15']")
	public WebElement fifteenDate;
	
	@FindBy(xpath = "//p[text() = '16']")
	public WebElement sixteenDate;
	
	@FindBy(xpath = "//p[text() = '17']")
	public WebElement seventeenDate;
	
	@FindBy(xpath = "//p[text() = '18']")
	public WebElement eighteenDate;
	
	@FindBy(xpath = "//p[text() = '19']")
	public WebElement nineteenDate;
	
	@FindBy(xpath = "//p[text() = '20']")
	public WebElement twentyDate;
	
	@FindBy(xpath = "//p[text() = '21']")
	public WebElement twentyoneDate;
	
	@FindBy(xpath = "//p[text() = '22']")
	public WebElement twentytwoDate;
	
	@FindBy(xpath = "//p[text() = '23']")
	public WebElement twentythreeDate;
	
	@FindBy(xpath = "//p[text() = '24']")
	public WebElement twentyfourDate;
	
	@FindBy(xpath = "//p[text() = '25']")
	public WebElement twentyfiveDate;
	
	@FindBy(xpath = "//p[text() = '26']")
	public WebElement twentysixDate;
	
	@FindBy(xpath = "//p[text() = '27']")
	public WebElement twentysevenDate;
	
	@FindBy(xpath = "//p[text() = '28']")
	public WebElement twentyeightDate;
	
	@FindBy(xpath = "//p[text() = '29']")
	public WebElement twentynineDate;
	
	@FindBy(xpath = "//p[text() = '30']")
	public WebElement thirtyDate;
	
	@FindBy(xpath = "//p[text() = '31']")
	public WebElement thirtyoneDate;
	
	@FindBy(xpath = "//div[@class = 'MuiPickersSlideTransition-transitionContainer MuiPickersCalendarHeader-transitionContainer']")
	public WebElement dateOnCalendar;
	
	@FindBy(xpath = "//div[@class = 'MuiPickersCalendarHeader-switchHeader']/button[1]")
	public WebElement previousButton;
	
	@FindBy(xpath = "//div[@class = 'MuiPickersCalendarHeader-switchHeader']/button[2]")
	public WebElement nextButton;
	
	
	@FindBy(xpath = "//label[text() = 'Trail Start Date']")
	public WebElement trailStartDate;
	
	@FindBy(xpath = "//label[text() = 'Trail End Date']")
	public WebElement trailEndDate;
	
	@FindBy(xpath = "//form/fieldset/div/div[1]/div/p")
	public WebElement requiredusernameError;
	
	@FindBy(xpath = "//form/fieldset/div/div[2]/div/p")
	public WebElement requiredpasswordError;
	
	@FindBy(xpath = "//p[@class = 'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-marginDense']")
	public WebElement requirederror;
	
	@FindBy(xpath = "//span[@class = 'text-red']")
	public WebElement invalidCredentials;
	
	@FindBy(xpath ="//span[contains(text(),'Create')]")
	public WebElement createbutton;
	
    @FindBy(name = "name")
	public WebElement namefield ;
    
    @FindBy(name = "mobileNo")
   	public WebElement phonefield ;
    
    public WebElement gender(String gn) {
 	   return driver.findElement(By.xpath("//span[contains(text(),'"+gn+"')]"));
 		
    } 
    
    @FindBy(name = "email")
   	public WebElement emailfield ;
    
    @FindBy(name = "education")
   	public WebElement degreefield ;
    
    @FindBy(name = "specializations")
   	public WebElement specilaizationsfield ;
    
    @FindBy(name = "startDate")
    public WebElement startDate;
    
    public WebElement Date(String dat) {
 	   return driver.findElement(By.xpath("//p[text()='"+dat+"']"));
 		
    } 
    
    @FindBy(name = "treatment")
    public WebElement conditiontreatedfield;
    
    
    @FindBy(name = "procedurePerformed")
    public WebElement proceduresPerformedfield;
    
    @FindBy(name = "LanguagesSpoken")
    public WebElement LanguagesSpokenfield;
    
    @FindBy(name = "price")
    public WebElement consultationfield;
    
    @FindBy(name = "price")
    public WebElement consultationfeesfield;
    
    public WebElement videoConsultation(String vc) {
    	   return driver.findElement(By.xpath("//span[contains(text(),'"+vc+"')]"));
    		
       } 
    
    @FindBy(xpath ="//span[text() = 'Upload Image']")
	public WebElement uploadImage;
	
    
    @FindBy(xpath = "//h6")
   	public WebElement  yearSelectionButton;
      
      public WebElement year(String yr) {
   	   return driver.findElement(By.xpath("//div[contains(text(),'"+yr+"')]"));
   		
      } 
      
     @FindBy(xpath = "//span[text() = 'Save Profile & Add Location']")
     public WebElement saveButton; 
     
     @FindBy(xpath ="//div[@class = 'MuiAlert-message']")
     public WebElement alertMessage;
     
     @FindBy(xpath = "//h1[contains(text(),'Looking for a doctor?')]")
     public WebElement lookingForDoctor;
     
     @FindBy(xpath = "//span[text() = 'Generate Slots']")
     public WebElement generateslotsbutton;
     
     @FindBy(xpath = "//div[2]/div/div/table/tfoot/tr/td/div/div[2]/div[@class = 'MuiSelect-root MuiSelect-select MuiTablePagination-select MuiSelect-selectMenu MuiInputBase-input']")
     public WebElement noofRowsinUnverified;
     
     @FindBy(xpath = "//div[1]/div/div/table/tfoot/tr/td/div/div[2]/div[@class ='MuiSelect-root MuiSelect-select MuiTablePagination-select MuiSelect-selectMenu MuiInputBase-input']")
     public WebElement noofRowsVerified;
     
     @FindBy(xpath ="//div[2]/div/div/table/tfoot/tr/td/div/div[3]/button[2]")
     public WebElement unverifiedNextButton;
     
     @FindBy(xpath ="//div[1]/div/div/table/tfoot/tr/td/div/div[3]/button[2]")
     public WebElement verifiedNextButton;
     
     @FindBy(xpath = "//p[text() = 'Experience is Required ']")
     public WebElement experienceRequired;
     
     @FindBy(xpath = "//p[text() = 'Degree is Required ']")
     public WebElement degreeRequired;
     
     @FindBy(xpath = "//p[text() = 'Name is Required ']")
     public WebElement nameRequired;
     
     @FindBy(name = "experience")
     public WebElement experiencefeild;
     
     @FindBy(xpath = "//p[text() = 'Please enter a Valid Mobile Number ']")
     public WebElement validMobileNumber;
     
     @FindBy(xpath = "//p[text() = 'Invalid email address']")
     public WebElement invalidEmailAddress;
     
     
	/*public void readTable() {
		WebElement table = driver.findElement(By.xpath("//table[@class='default-table table-unbordered table table-sm table-hover']"));
		List<WebElement> rowList = table.findElements(By.tagName("tr"));
		
		for(int rnum=0; rnum < rowList.size();rnum++) {
	 
			List<WebElement> columns = rowList.get(rnum).findElements(By.tagName("th"));
		    
			for(int cnum =0; cnum < columns.size();cnum++) {
				
				System.out.println(columns.get(cnum).getText());
			}
	
		}
		
    	*/
    
	
}	
	
	
