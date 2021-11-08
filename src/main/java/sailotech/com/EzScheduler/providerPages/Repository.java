package sailotech.com.EzScheduler.providerPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sailotech.com.EzScheduler.basePages.BaseTest;

public class Repository extends BaseTest {
	
	

	
	public Repository(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//*[starts-with(text(),'Login/Register')]")
	public WebElement buttonLoginRegister;
	
	/*
	 * @FindBy(xpath = "//*[starts-with(text(),'Doctor')]") public WebElement
	 * doctorLabel;
	 */
	@FindBy(xpath = "//*[contains(text(),'Logout')]")
	public WebElement logoutButton;
	
	@FindBy(xpath = "//li[@class='pointer']//a[1]")
	public WebElement doctorLoginButton ;
	
	@FindBy(name = "email")
	public WebElement doctorUsername ;
	
	@FindBy(name = "password")
	public WebElement doctorPassword ;
	
	@FindBy(xpath = "//span[contains(text(),'Sign-In')]")
	public WebElement loginArrow; 
	
	/*
	 * @FindBy(xpath = "//*button[contains(text(),'Month')]") public WebElement
	 * verificationOfDcotorPage;
	 */
	
	@FindBy(xpath = "//*[contains(text(),'')]")
	public WebElement  doctorName;
	
	@FindBy(xpath = "//body[@id='body']/div[@id='app-site']/div/div/div/div/header/div/div[1]//*[local-name()='svg']")
	public WebElement  menu;
	
	
	@FindBy(xpath = "//div[contains(@class,'scrollbar')]//div[3]//a[1]")
	public WebElement  generateSlotsMenu;
	
	@FindBy(xpath = "//body//div[contains(@class,'scrollbar')]//div//div[1]//a[1]")
	public WebElement  myScheduleMenu;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/header[1]/div[1]/a[1]")
	public WebElement location;
	
	
	 @FindBy(name="facility") 
	 public WebElement facility;
	 
	 @FindBy(xpath = "//div[2]/div/div/div/div/input")
	 public WebElement facilitysize;
	
	
	
	@FindBy(xpath = "//input[@name = 'consultType']")
	public WebElement  consultType;
	
	@FindBy(xpath = "//*[contains(@name,'consultType') and contains(@value,'Video')]")
	public WebElement videoSlotType;
	
	
	@FindBy(xpath = "//*[contains(@name,'video') and contains(@value,'At Office')]")
	public WebElement atOfficeSlotType;
	
	
	
	
	@FindBy(xpath ="//form/div/div[2]/div[2]/div/div/input")
	public WebElement fromDate;

	@FindBy(xpath = "//form/div/div[2]/div[3]/div/div/input")
	public WebElement toDate;

	@FindBy(xpath = "//form/div/div[3]/div[2]/div/div/input")
	public WebElement fromTime;
	
	@FindBy(xpath = "//form/div/div[3]/div[3]/div/div/input")
	public WebElement toTime;
	
	@FindBy(xpath= "//body/div/div/div/div/div/div/div/div/span[1]")
    public WebElement oneClk;
	
	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/span[2]")
    public WebElement twoClk;
	
	@FindBy(xpath ="//body/div/div/div/div/div/div/div/div/span[3]")
    public WebElement threeClk;
	
	@FindBy(xpath = "//*[contains(text(),'4')]")
    public WebElement fourClk;
	
	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/span[5]")
    public WebElement fiveClk;
	
	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/span[6]")
    public WebElement sixClk;
	
	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/span[7]")
    public WebElement sevenClk;
	
	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/span[8]]")
    public WebElement eightClk;
	
	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/span[9]")
    public WebElement nineClk;
	
	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/span[10]")
    public WebElement tenClk;
	
	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/span[11]")
    public WebElement elevenClk;
	
	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/span[12]")
    public WebElement twelveClk;
	
	public WebElement hour(String hr) {
		   return driver.findElement(By.xpath("//buttton/span[text() = '"+hr+"']"));
			
	   } 
	
	
	@FindBy(xpath = "//body/div/div/div/div/div/div/div[1]/button[2]/span[1]")
	public WebElement minButton;
	
    @FindBy(xpath = "//*[contains(text(),'00')]" )
    public WebElement zeroMin;
    
    @FindBy(xpath = "//span[contains(text(),'05')]" )
    public WebElement fiveMin;
    
    @FindBy(xpath = "//span[contains(text(),'10')]" )
    public WebElement tenMin;
    
    @FindBy(xpath = "//span[contains(text(),'15')]" )
    public WebElement fifteenMin;
    
    @FindBy(xpath = "//span[contains(text(),'20')]" )
    public WebElement twentyMin;
    
    @FindBy(xpath = "//span[contains(text(),'25')]" )
    public WebElement twentyfiveMin;
	
    @FindBy(xpath = "//span[contains(text(),'30')]" )
    public WebElement thirtyMin;
	
    @FindBy(xpath = "//span[contains(text(),'35')]" )
    public WebElement thirtyfievMin;
    
    @FindBy(xpath = "//span[contains(text(),'40')]" )
    public WebElement fourtyMin;
    
    @FindBy(xpath = "//span[contains(text(),'45')]" )
    public WebElement fourtyfiveMin;
    
    @FindBy(xpath = "//span[contains(text(),'50')]" )
    public WebElement fiftyMin;
    
    @FindBy(xpath = "//span[contains(text(),'55')]" )
    public WebElement fiftyfiveMin;
    
    @FindBy(xpath = "//*[contains(text(),'AM')]")
    public WebElement amAMorPM;
    
    @FindBy(xpath = "//*[contains(text(),'PM')]")
    public WebElement pmAMorPM;
    
	
	
	@FindBy(xpath ="//*[contains(text(),'Mon')]") 
	public WebElement Monday;
	
	@FindBy(xpath ="//*[contains(text(),'Tue')]") 
	public WebElement Tuesday;
	
	@FindBy(xpath ="//*[contains(text(),'Wed')]") 
	public WebElement Wednesday;
	
	@FindBy(xpath ="//*[contains(text(),'Thu')]") 
	public WebElement Thursday;
	
	@FindBy(xpath ="//*[contains(text(),'Fri')]") 
	public WebElement Friday;
	
	@FindBy(xpath ="//*[contains(text(),'Sat')]") 
	public WebElement Saturday;
	
	@FindBy(xpath ="//*[contains(text(),'Sun')]") 
	public WebElement Sunday;
	
	@FindBy(xpath ="//*[contains(text(),'Daily')]") 
	public WebElement Daily;
	
	public WebElement day(String dy) {
		   return driver.findElement(By.xpath("//*[contains(text(),'"+dy+"')]"));
			
	   } 
	@FindBy(xpath = "//input[@name='slotTime']")
	public WebElement slotTime;
	
	/*
	 * @FindBy(xpath = "pr") public WebElement consultationFee;
	 */
	
	@FindBy(xpath ="//body/div/div/div/div/main/div/div/div/div/div/div/div/form/div/div/div/button[1]")
	public WebElement generateSlotButton;
	
	@FindBy(xpath ="/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/header[1]/div[1]/div[1]/*[local-name()='svg'][1]")
	public WebElement menuOnGenerateSlots;
	
	
   @FindBy(xpath = "//b[contains(text(),'Slots with given combination already exist please')]")
	public WebElement slotsExistsAlertMessage;
	
   @FindBy(xpath = "//b[contains(text(),'No slots created with given Combination.Please che')]")
   public WebElement wrongCombinationofWeek;
   
   @FindBy(xpath ="//b[contains(text(),'Slots Generated Successfully..!!')]")
   public WebElement slotsGeneratedSuccessfully;
   
   @FindBy(xpath ="//div[2]/button[1]/div[1]/div[2]")
   public WebElement openSlots;
   
   @FindBy(xpath ="//div[1]/button[1]/div[1]/div[2]")
   public WebElement upcomingAppointments;
   
   @FindBy(xpath ="//div[3]/button[1]/div[1]/div[2]")
   public WebElement blockedSlots;
   
   @FindBy(xpath ="//div[4]/button[1]/div[1]/div[2]")
   public WebElement pastAppointments;
   
   @FindBy(xpath ="//button[contains(text(),'Month')]")
   public WebElement monthButton;
   
   @FindBy(xpath ="//button[contains(text(),'Week')]")
   public WebElement weekButton;
   
   @FindBy(xpath ="//button[contains(text(),'Day')]")
   public WebElement dayButton;
   
   @FindBy(xpath ="//button[contains(text(),'List')]")
   public WebElement listButton;
   
   @FindBy(xpath = "//form/div[2]/div[1]")
   public WebElement Alert;
   
   @FindBy(xpath = "//h2[@class = 'fc-toolbar-title']")
   public WebElement dateOnCalendar;
   
   @FindBy(xpath = "//div[@class = 'fc-button-group']/button[2]")
   public WebElement nextButton;
   
   @FindBy(xpath = "//div[@class = 'fc-button-group']/button[1]")
   public WebElement previousButton;
   
   @FindBy(xpath = "//button[contains(text(),'Today')]")
   public WebElement todayButton;
   
   @FindBy(xpath = "//input[@name='price']")
   public WebElement consultationFees;
   
   @FindBy(linkText = "1")
   public WebElement oneDate;
   
   @FindBy(linkText = "2")
   public WebElement twoDate;
   
   @FindBy(linkText = "3")
   public WebElement threeDate;
   
   @FindBy(linkText = "4")
   public WebElement fourDate;
   
   @FindBy(linkText = "5")
   public WebElement fiveDate;
   
   @FindBy(linkText = "6")
   public WebElement sixDate;
   
   @FindBy(linkText = "7")
   public WebElement sevenDate;
   
   @FindBy(linkText = "8")
   public WebElement eightDate;
   
   @FindBy(linkText = "9")
   public WebElement nineDate;
   
   @FindBy(linkText = "10")
   public WebElement tenDate;
   
   @FindBy(linkText = "11")
   public WebElement elevenDate;
   
   @FindBy(linkText = "12")
   public WebElement twelveDate;
   
   @FindBy(linkText = "13")
   public WebElement thirteenDate;
   
   @FindBy(linkText = "14")
   public WebElement fourteenDate;
   
   @FindBy(linkText = "15")
   public WebElement fifteenDate;
   
   @FindBy(linkText = "16")
   public WebElement sixteenDate;
   
   @FindBy(linkText = "17")   
   public WebElement seventeenDate;
   
   @FindBy(linkText = "18")
   public WebElement eighteenDate;
   
   @FindBy(linkText = "19")
   public WebElement ninteenDate;
   
   @FindBy(linkText = "20")
   public WebElement twentyDate;
   
   @FindBy(linkText = "21")
   public WebElement twentyoneDate;
   
   @FindBy(linkText = "22")
   public WebElement twentytwoDate;
   
   @FindBy(linkText = "23")
   public WebElement twentythreeDate;
   
   @FindBy(linkText = "24")
   public WebElement twentyfourDate;
   
   @FindBy(linkText = "25")
   public WebElement twentyfiveDate;
   
   @FindBy(linkText = "26")
   public WebElement twentysixDate;
   
   @FindBy(linkText = "27")
   public WebElement twentysevenDate;
   
   @FindBy(linkText = "28")
   public WebElement twentyeightDate;
   
   @FindBy(linkText = "29")
   public WebElement twentynineDate;
   
   @FindBy(linkText = "30")
   public WebElement thirtyDate;
   
   @FindBy(linkText = "31")
   public WebElement thirtyoneDate;
   
 
	public WebElement date(String dt) {
		   
		   return driver.findElement(By.linkText(dt));
			
	   } 
	
   
   @FindBy(xpath = "//h5[1]//a[2]")
   public WebElement doctorRegisterButton;
   
   @FindBy(xpath = "//*[starts-with(text(),'Name')]")
   public WebElement nameField;
   
   @FindBy(xpath = "//*[starts-with(text(),'Email')]")
   public WebElement emailField;
   
   @FindBy(xpath = "//*[starts-with(text(),'Mobile Number')]")
   public WebElement phoneNumberField;
   
   @FindBy(xpath = "//span[contains(text(),'Male')]")
   public WebElement maleGenderField;
   
   @FindBy(xpath = "//span[contains(text(),'Female')]")
   public WebElement femaleGenderField;
   
   @FindBy(name = "specializations")
   public WebElement specilaizationField;
   
   @FindBy(xpath = "//*[contains(text(),'Degree')]")
   public WebElement DegreeField;
   
   @FindBy(xpath = "//h2[1]")
   public WebElement DateOnTheMonthCalendar;
   
   @FindBy(xpath = "//form/div[5]/div/div/div[2]/button[1]/span[1]")
   public WebElement clearSpecializations;
   
   public WebElement openslotcancel(int row) {
		return driver.findElement(By.xpath("//div[5]/div[1]/div["+row+"]"));
		
   	
   }
   public WebElement opecancelbutton(int row) {
	   return driver.findElement(By.xpath("//div[5]/div[1]/div["+row+"]/div[1]/div[1]/div[1]/span[1]/*[1]"));
		
   }
   
   @FindBy(xpath= "//div[@class = 'MuiPaper-root MuiDialog-paper MuiDialog-paperScrollPaper MuiDialog-paperWidthSm MuiPaper-elevation24 MuiPaper-rounded']")
   public WebElement dialogbox;
   
   @FindBy(xpath = "//input[@id = 'cancel']")
   public WebElement reasonForCancelation;
   
   @FindBy(xpath = "//span[contains(text(),'Yes , Cancel')]")
   public WebElement yesForCancelation;
   
   @FindBy(xpath = "//div[contains(@class,'scrollbar')]//div[8]//a[1]")
	public WebElement  logoutMenu;
	
   @FindBy(xpath = "//div[1]/ul/li[2]/div/h5/a[2]")
  	public WebElement  doctorRegisterMenu;
   
   @FindBy(name = "name")
	public WebElement namefield ;
   
   @FindBy(name = "email")
	public WebElement emailfield ;
   
   @FindBy(name = "mobileNo")
	public WebElement mobileNumber ;
   
   @FindBy(xpath = "//span[contains(text(),'Male')]")
 	public WebElement  maleregisterField;
   
   @FindBy(xpath = "//span[contains(text(),'Female')]")
	public WebElement  femaleregisterField;
   
   public WebElement gender(String gn) {
 	   return driver.findElement(By.xpath("//span[contains(text(),'"+gn+"')]"));
 		
    } 
   
   @FindBy(name = "specializations")
	public WebElement specilalizationsfield ;
   
   @FindBy(name = "education")
	public WebElement degreefield ;
   
   @FindBy(name = "startDate")
  	public WebElement startDatefield ;
   
   @FindBy(xpath = "//h6")
	public WebElement  yearSelectionButton;
   
   public WebElement year(String yr) {
	   return driver.findElement(By.xpath("//div[contains(text(),'"+yr+"')]"));
		
   } 
   @FindBy(xpath ="//p[text()='1']")
   public WebElement one;
   
   
   @FindBy(xpath ="//p[text()='2']")
   public WebElement two;
   
   @FindBy(xpath ="//p[text()='3']")
   public WebElement three;
   
   @FindBy(xpath ="//p[text()='4']")
   public WebElement four;
   
   @FindBy(xpath ="//p[text()='5']")
   public WebElement five;
   
   @FindBy(xpath ="//p[text()='6']")
   public WebElement six;
   
   @FindBy(xpath ="//p[text()='7']")
   public WebElement seven;
   
   @FindBy(xpath ="//p[text()='8']")
   public WebElement eight;
   
   @FindBy(xpath ="//p[text()='9']")
   public WebElement nine;
   
   @FindBy(xpath ="//p[text()='10']")
   public WebElement ten;
   
   @FindBy(xpath ="//p[text()='11']")
   public WebElement eleven;
   
   @FindBy(xpath ="//p[text()='12']")
   public WebElement tweleve;
   
   @FindBy(xpath ="//p[text()='13']")
   public WebElement thirteen;
   
   @FindBy(xpath ="//p[text()='14']")
   public WebElement fourteen;
   
   @FindBy(xpath ="//p[text()='15']")
   public WebElement fifteen;
   
   @FindBy(xpath ="//p[text()='16']")
   public WebElement sixteen;
   
   @FindBy(xpath ="//p[text()='17']")
   public WebElement seventeen;
   
   @FindBy(xpath ="//p[text()='18']")
   public WebElement eighteen;
   
   @FindBy(xpath ="//p[text()='19']")
   public WebElement nineteen;
   
   @FindBy(xpath ="//p[text()='20']")
   public WebElement twenty;
   
   @FindBy(xpath ="//p[text()='21']")
   public WebElement twentyone;
   
   @FindBy(xpath ="//p[text()='22']")
   public WebElement twentytwo;
   
   @FindBy(xpath ="//p[text()='23']")
   public WebElement twentythree;
   
   @FindBy(xpath ="//p[text()='24']")
   public WebElement twentyfour;
   
   @FindBy(xpath ="//p[text()='25']")
   public WebElement twentyfive;
   
   @FindBy(xpath ="//p[text()='26']")
   public WebElement twentysix;
   
   @FindBy(xpath ="//p[text()='27']")
   public WebElement twentyseven;
   
   @FindBy(xpath ="//p[text()='28']")
   public WebElement twentyeight;
   
   @FindBy(xpath ="//p[text()='29']")
   public WebElement twentynine;
   
   @FindBy(xpath ="//p[text()='30']")
   public WebElement thirty;
   
   @FindBy(xpath ="//p[text()='31']")
   public WebElement thirtyone;
  
   public WebElement Date(String dat) {
	   return driver.findElement(By.xpath("//*[text() ='"+dat+"']"));
		
   } 
    
   
   @FindBy(xpath ="//div[@class = 'MuiPickersSlideTransition-transitionContainer MuiPickersCalendarHeader-transitionContainer']")
   public WebElement monthSelection;

   @FindBy(xpath="//*[@id='body']/div[3]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[2]/span[1]")
   public WebElement next;
   
   @FindBy(xpath="//*[@id='body']/div[3]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[1]/span[1]")
   public WebElement previous;
   
 
   @FindBy(xpath = "//span[starts-with(text(),'Register')]")
   public WebElement registerButton;
   
   @FindBy(xpath = "//form/fieldset/div/div[2]")
   public WebElement errorMessage;
   
   @FindBy(xpath = "//div[contains(text(),'Registration Success')]")
   public WebElement successMessage;
  
   @FindBy(xpath = "//p[contains(text(),'Please enter email')]")
   public WebElement useridMissing;
   
   @FindBy(xpath = "//p[contains(text(),'Please enter password')]")
   public WebElement psdMissing;
   
   @FindBy(xpath ="//div[@class = 'shadow-lg alert alert-success fade show']")
   public WebElement registrationSuccess;
   
   @FindBy(xpath ="//div[@class ='MuiPickersCalendar-week' ]")
   public List<WebElement> week;
   
   
   @SuppressWarnings("unchecked")
public WebElement dates(int row) {
		return driver.findElement(By.xpath("//div[@class ='MuiPickersSlideTransition-transitionContainer MuiPickersCalendar-transitionContainer' ]/div/div["+row+"]"));


}
   public WebElement Date(int row ,int div) {
	   return driver.findElement(By.xpath("//div[@class ='MuiPickersSlideTransition-transitionContainer MuiPickersCalendar-transitionContainer' ]/div/div["+row+"]/div["+div+"]"));
		
   } 
   
   
   @FindBy(xpath ="//div[@class = 'MuiPickersBasePicker-pickerView']/div/div/span")
   public List<WebElement> hours;
   
 
   @FindBy(xpath = "//div[@class = 'MuiDialogActions-root MuiDialogActions-spacing']/button[1]")
   public WebElement cancelOnCalendar;   
   
   
  @FindBy(xpath = "//p[text() = 'Please select a location for Visit']")
  public WebElement errorLocation;
  
  @FindBy(xpath ="//form/div/div[3]/div[2]/div[1]/p[1]")
   public WebElement errorSlotTime;
   
  
  @FindBy(xpath = "//p[text() = 'Slot Time is Required ']")
  public WebElement missingslotTime;
  
  
  @FindBy(xpath = "//p[contains(text(),'Consultation Fee is Required')]")
  public WebElement missingconsultationFee;
  
  
  
}  
