package sailotech.com.EzScheduler.consumerPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientRepositoryClass {
WebDriver driver;

	
	public PatientRepositoryClass(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
	}

	
	@FindBy(xpath = "//*[starts-with(text(),'Login/Register')]")
	public WebElement buttonLoginRegister;
	
	
	
	@FindBy(xpath = "//li//li[1]//div[1]//h5[1]//a[1]")
	public WebElement patientLogin;
	
	@FindBy(name = "email")
	public WebElement patientUserName;

	
	@FindBy(name = "password")
	public WebElement patientPassword;
	
	
	@FindBy(xpath = "//span[contains(text(),'Sign-In')]")
	public WebElement patientArrowButton;
	
	@FindBy(xpath = "//body/div/div/div/div/div/header/div/div[1]")
	public WebElement img;
	
	@FindBy(xpath = "//div[1]/div/div/div/div/input")
    public WebElement searchInput;
	
	@FindBy(xpath = "//div[@class = 'col-md-6 col-sm-12 d-flex flex-row mb-3']/button")
    public WebElement searchIcon;	
	
    @FindBy(className = "doctor-slots-items")
	public WebElement slotSelection;
	
    @FindBy(xpath = "//body/div/div/div/div/main/div/div/div/div/div/div/div[2]/div[1]/div[3]")
    public WebElement slotsList;
    
    @FindBy(xpath ="//body/div/div/div/div/main/div/div/div/div[2]/div[1]/div[1]/div[1]")
    public WebElement doctorLocation;
    
    @FindBy(xpath = "//textarea[@placeholder='Reason cannot be more than 200 characters']")
	public WebElement reasonForVIsit;
	
    @FindBy(xpath = "//span[contains(text(),'I Agree')]")
	public WebElement iAgreeButton;
    
    @FindBy(xpath = "//span[contains(text(),'I do not Agree')]")
	public WebElement iDoNotAgreeButton;
    
    @FindBy(xpath = "//span[contains(text(),'Confirm and Continue for Payment')]")
	public WebElement confirmAndContinueForPaymentButton;
    
    @FindBy(xpath = "//span[contains(text(),'Back')]")
	public WebElement backButton;
    
   // @FindBy(xpath = "//*[contains(text(),'Netbanking - State Bank of India')]")
	
    
    
    @FindBy(xpath = "//*[@id=\"footer-cta\"]")
	public WebElement paymentButton;
    
	
	  @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[8]/div[2]/form/div[2]/span")
	  public WebElement netBankPaymentButton;
	 
    
    @FindBy(xpath = "//button[contains(text(),'Success')]")
	public WebElement successButton;
    
    @FindBy(xpath = "/html[1]/body[1]/div[1]/iframe[1]")
	public WebElement patientForm;
	
    @FindBy(xpath = "//*[starts-with(text(),'SBI')]")
    public WebElement stateBank;
    
    @FindBy(xpath = "//*[starts-with(text(),'Axis')]")
    public WebElement axisBank;
    
    @FindBy(xpath = "//*[starts-with(text(),'HDFC')]")
    public WebElement hdfcBank;
    
    @FindBy(xpath = "//*[starts-with(text(),'ICICI')]")
    public WebElement iciciBank;
    
    @FindBy(xpath = "//*[starts-with(text(),'Kotak')]")
    public WebElement kotakBank;
    
    @FindBy(xpath = "//*[starts-with(text(),'Yes')]")
    public WebElement yesBank;
	
    @FindBy(xpath = "//*[contains(text(),'Netbanking - State Bank of India')]")
	public WebElement stateBankNetBanking;
    
    @FindBy(xpath = "//*[starts-with(text(),'All Indian banks')]")
	public WebElement netBanking;
    
    @FindBy(xpath = "//span[contains(text(),'Confirm and Pay after visit')]")
   	public WebElement payAfterVisitButton;
	
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/header[1]/div[1]/div[1]/*[local-name()='svg'][1]")
	public WebElement  menu;
    
    @FindBy(xpath = "//span[contains(text(),'My Appointments')]")
	public WebElement  myAppointments;
    
    @FindBy(xpath = "//div[2]/button[1]")
   	public WebElement  searchButton;
    
    @FindBy(xpath = "//span[contains(text(),'All Appointments')]")
   	public WebElement  allAppointments;
    
    @FindBy(xpath = "//span[contains(text(),'In-person')]")
   	public WebElement  inPerson;

    @FindBy(xpath = "//span[contains(text(),'Video Visit')]")
   	public WebElement  videoVisit;
    
    public WebElement appointmentType(String str) {
		return driver.findElement(By.xpath("//span[contains(text(),'"+str+"')]"));
		
    	
    }
    
    
    @FindBy(xpath = "//input[@name='slotsAvailable']")
   	public WebElement  slotsAvailable;
    
    @FindBy(xpath = "//input[@name='selectedSpeciality']")
   	public WebElement  selectedSpeciality;
    
    @FindBy(xpath = "//input[@name='selectedCondtionsTreated']")
   	public WebElement  slectedConditionsTreated;
    
    @FindBy(xpath = "//label[contains(text(),'Gender')]")
   	public WebElement  gender;
    
    @FindBy(xpath = "//input[@name='selectedLanguages']")
   	public WebElement  languagesSpoken;
    
    @FindBy(xpath = "//body//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[2]//div[1]//div[1]//a[1]//h3[1]")
    public WebElement doctorName;
    
    @FindBy(xpath = "//span[contains(text(),'Home')]")
    public WebElement homeMenu;
    
    @FindBy(xpath = "//*[contains(text(),'Visa, MasterCard, RuPay & More')]")
    public WebElement cardOption;
    
    @FindBy(xpath = "//*[@id=\"card_number\"]")
    public WebElement cardNumber;
    
    @FindBy(xpath = "//*[@id=\"card_cvv\"]")
    public WebElement cvvNumber;
    
    @FindBy(xpath = "//*[@id=\"card_expiry\"]")
    public WebElement expiry;
    
    @FindBy(xpath = "//*[@id='otp-sec']")
    public WebElement skipSavedCards;
    
    @FindBy(className = "card-bodydoctor-content")
    public WebElement locations;
    
    @FindBy(xpath = "//*[contains(text(),'Video')]")
    public WebElement videoButton;
    
    @FindBy(xpath = "//*[contains(text(),'Office Visit')]")
    public WebElement officeVisitButton;
    
    public WebElement slottype(String str) {
		return driver.findElement(By.xpath("//*[contains(text(),'"+str+"')]"));
		
    	
    }
    
    @FindBy(xpath = "//span[contains(text(),'Others')]")
    public WebElement otherOption;
    
    @FindBy(xpath = "//span[text() = 'Self']")
    public WebElement selfOption;
    
    @FindBy(name = "familyMemberRelation")
    public WebElement familyMemberRelation;
    
    @FindBy(name = "familyMemberName")
    public WebElement familyMemberName;
    
    @FindBy(xpath = "//button[contains(text(),'Failure')]")
    public WebElement failButton;
    
    @FindBy(xpath = "//button[contains(text(),'Success')]")
    public WebElement successButton1;
    
    @FindBy(xpath ="//b[contains(text(),'FAILED')]")
    public WebElement failedStatus;
    
    @FindBy(xpath = "//p[contains(text(),'Booking Successful')]")
    public WebElement successStatus;
    
    @FindBy(xpath = "//*[contains(text(),'Please select the preferred consultation type')]")
    public WebElement consultationTypeTitle;
    
    @FindBy(xpath = "//*[contains(@class,'d-flex flex-column slot-navigation-day justify-content-center align-items-center')]")
    public List <WebElement> slotDate;
    
    @FindBy(xpath ="/div[1]/*[local-name()='svg'][1]")
	public WebElement menuOnPatientPage;
    
    @FindBy(xpath = "//div[6]//a[1]")
    public WebElement logouButton;
    
    @FindBy(xpath ="//div[@class='card product-item-vertical hoverable animation comp-bg flipInX']/div[@class='row d-flex align-items-start']/div[@class='doctor-list-wrapper col-xl-5 col-lg-5 col-md-5 col-12']/div[@class='card-body doctor-content']/div[8]")
    public List<WebElement> Location;
    
//    public WebElement slotBooking(int row,int div) {
//    	//return element("//*[@id="+row+"]/div/div[3]/div/div/div["+div+"]/span");
//    }}}
//  ​​​​​
    public WebElement slotBooking(int row,int div) {
		return driver.findElement(By.xpath("//*[@id="+row+"]/div/div[3]/div/div/div["+div+"]/span"));
		
    	
    }
    public WebElement moreSlots(int row,int div) {
				return driver.findElement(By.xpath("//*[@id="+row+"]/div/div[3]/div/div/div["+div+"]/span/b[contains(text(),'More')]"));

    	
    }
    public WebElement slotTIme(int row, int div, int slotnum) {
    	return driver.findElement(By.xpath("//*[@id="+row+"]/div/div[3]/div/div/div["+div+"]/span["+slotnum+"]"));
    }
    public WebElement slotsAvailability(int row) {
		return driver.findElement(By.xpath("//*[@id="+row+"]/div/div[3]/div/span/div"));
		
    	
    }
    public WebElement nextArrow(int row) {
		return driver.findElement(By.xpath("//*[@id="+row+"]/div/div[3]/div/div/div[6]/span/b/i"));
		
    	
    }
    @FindBy(name = "name")
    public WebElement registrationName;
    
    @FindBy(name = "email")
    public WebElement registrationEmail;
    
    @FindBy(name ="mobileNo")
    public WebElement registrationPhoneNumber;
    
    @FindBy(xpath = " //span[contains(text(),'Male')]")
    public WebElement registrationMale;
    
    @FindBy(xpath = " //span[contains(text(),'Female')]")
    public WebElement registrationFemale;
    
    public WebElement gender(String gen) {
		return driver.findElement(By.xpath("//span[contains(text(),'"+gen+"')]"));
		
    	
    }
    
    @FindBy(xpath ="//ul/li[1]/div/h5/a[2]")
    public WebElement patientregisterOption;
    
    @FindBy(xpath = "//button/span[contains(text(),'Register')]")
    public WebElement registerButton;
    
    @FindBy(name ="otp")
    public WebElement otp;
    
    @FindBy(xpath = "//button/span[contains(text(),'Verify OTP')]")
    public WebElement verifyotpButton;
    
    @FindBy(xpath = "//span[contains(text(),'No Slots Available')]")
    public WebElement noSlosAvailable;
    
    @FindBy(xpath = "//span[contains(text(),'All Appointments')]")
    public WebElement allAppointments1;
    
    @FindBy(xpath = "//div[@class = 'MuiChip-root mx-2 m-3 bg-primary text-white']")
    public WebElement noofDoctors;
    
    @FindBy(xpath ="//span[contains(text(),'Clear')]")
    public WebElement clearButton;
    
    @FindBy(xpath = "div[@class = 'MuiCircularProgress-root MuiCircularProgress-indeterminate']")
    public WebElement pageLoad;
    
    @FindBy(xpath = "//p[text() = 'Please enter Name']")
    public WebElement nameErrorRegistration;
    
    @FindBy(xpath = "//p[text() = 'Please enter Email']")
    public WebElement emailErrorRegistration;

    @FindBy(xpath = "//p[text() = 'Invalid email address']")
    public WebElement invalidemailErrorRegistration;
    
    @FindBy(xpath = "//p[text() = 'Email Already Used']")
    public WebElement emailalreadyusedErrorRegistration;
    
    @FindBy(xpath = "//p[text() = 'Please enter Mobile Number']")
    public WebElement  phoneErrorRegistration;
    
    @FindBy(xpath = "//p[text() = 'Please Enter a valid Mobile Number']")
    public WebElement  invalidphoneErrorRegistration;
    
    @FindBy(xpath = "//p[text() = 'Mobile Number Already Used']")
    public WebElement  phonealreadyusedErrorRegistration;
    
    @FindBy(xpath = "//div[text() = 'Please select the Gender']")
    public WebElement  genderErrorRegistration;

    
    

    
}
