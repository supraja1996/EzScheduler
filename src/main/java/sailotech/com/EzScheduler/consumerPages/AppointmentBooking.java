package sailotech.com.EzScheduler.consumerPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DateParsing;




public class AppointmentBooking {
	
WebDriver driver;
int rowvalue;
int div;
Date FormattedDate;
String searchdate;
String searchmonth;
String searchweek;
String slotdate;
String slotmonth;
String slotdayofWeek;
String slottype;
int slotnumber;
int flag = 0;
boolean flag1 = false;
boolean flag2 = false;
int Searchdate ;

	public AppointmentBooking(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
		
	}
	
	
	public byte[] login() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		
	}
	public void search_for_doctor() throws Exception
	{
        WebDriverWait wait = new WebDriverWait(driver, 60); 
	  	PatientRepositoryClass page = new PatientRepositoryClass(driver);
	    Actions action = new Actions(driver); 
	    String user_dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(user_dir+"\\inputFiles\\Patient_Login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Header Sheet
		XSSFSheet s = wb.getSheetAt(1);

		Thread.sleep(2000);

		for (int i = 1; i < s.getLastRowNum() + 1; i++) {

	    wait.until(ExpectedConditions.elementToBeClickable(page.searchInput)).isDisplayed();	 
	    wait.until(ExpectedConditions.elementToBeClickable(page.searchInput)).sendKeys((s.getRow(i).getCell(0).getStringCellValue()));
	    wait.until(ExpectedConditions.elementToBeClickable(page.searchIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(page.allAppointments));
//		action.moveToElement(page.img).sendKeys(Keys.TAB).perform();
//		action.sendKeys(s.getRow(i).getCell(0).getStringCellValue());
//		action.sendKeys(Keys.ENTER).perform();
//		try {
//		wait.until(ExpectedConditions.urlToBe("https://demo.ezscheduler.io/?searchTerm="+s.getRow(i).getCell(0).getStringCellValue()));
//		}catch(TimeoutException e) {
//			wait.until(ExpectedConditions.urlToBe("https://demo.ezscheduler.io/?searchTerm="+s.getRow(i).getCell(0).getStringCellValue()));
//
//		}
		}
		
		}

	@SuppressWarnings("unlikely-arg-type")
	public void slot_booking() throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 60); 
	  	PatientRepositoryClass page = new PatientRepositoryClass(driver);
	    Actions action = new Actions(driver);
	    DateParsing p = new DateParsing();
	    String user_dir = System.getProperty("user.dir");
		//FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Ptient_Login.xlsx");
	    File src = new File(user_dir+"\\inputFiles\\Patient_Login.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Header Sheet
		XSSFSheet s = wb.getSheetAt(1);

		Thread.sleep(2000);
		

		for (int i = 1; i < s.getLastRowNum() + 1; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(page.searchInput));
			wait.until(ExpectedConditions.elementToBeClickable(page.searchInput)).sendKeys((s.getRow(i).getCell(0).getStringCellValue()));
		    wait.until(ExpectedConditions.elementToBeClickable(page.searchIcon)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(page.allAppointments));
		
	        String[] locationDetails = null;
		for (int j = 0; j < page.Location.size(); j++) {
			 
			
			 locationDetails=page.Location.get(j).getText().split(":");
			 System.out.println(locationDetails.length);
			if(locationDetails.length > 1) {
				if(locationDetails[1].trim().contains(s.getRow(i).getCell(1).getStringCellValue())) {
					System.out.println(locationDetails[1]);
					rowvalue=j;
					break;
				}
			}
			else {
				System.out.println(locationDetails[0]);
				rowvalue=j;
				break;
			}
			}
			
				
			
		
			
		
          try {
        	  String slotDate =page.slotBooking(rowvalue, 2).getText();
        	  String slotdate =p.dateparsing(slotDate);
        	  String slotmonth = p.monthparsing(slotDate);
        	  int Slotdate = Integer.parseInt(slotdate);
        	  int Slotmonth = Integer.parseInt(slotmonth);
        	  System.out.println(Slotdate);
        	  System.out.println(Slotmonth);
        	  String searchDate = s.getRow(i).getCell(2).getStringCellValue();
        	  searchdate = p.dateconversion(searchDate);
		    	String searchdate1 = p.dateparsing(searchdate);
		    	 searchmonth = p.monthparsing(searchdate);
		       int Searchmonth = Integer.parseInt(searchmonth);	 
	           Searchdate = Integer.parseInt(searchdate1);  
				System.out.println(Searchdate);
				System.out.println(Searchmonth);
			if((Searchdate < Slotdate) || (Searchdate > Slotdate) == true) {
				if((Searchmonth < Slotmonth) || (Searchmonth == Slotmonth) == true) {
				System.out.println("Cannot book for old dates");
				flag = 1;
				s.getRow(i).createCell(18).setCellValue("Cannot book for old dates");
				}
				else {
					flag = 0;
				}
				
			}
			else {
				flag = 0;
			}
				
        	  
          }catch(Exception e) {
        	  
          }
          if(flag == 0) {
		  try {
			wait.until(ExpectedConditions.elementToBeClickable(page.slotsAvailability(rowvalue))).isDisplayed();  
	        //page.slotsAvailability(rowvalue).isDisplayed();
			String s1 =page.slotsAvailability(rowvalue).getText();
			
			if(s1.contains("Next Available" )) {
				
				String[] splitString = s1.split("-");
				String[] splitString1 = splitString[1].split("nd");
				System.out.println(splitString1[0].stripLeading());
				String nextslotdate = p.dateparsing(splitString1[0].stripLeading());
				System.out.println(nextslotdate);
				int nextSlotDate = Integer.parseInt(nextslotdate);	 
				
				if(Searchdate > nextSlotDate ) {
				wait.until(ExpectedConditions.elementToBeClickable(page.slotsAvailability(rowvalue))).click();
				}
//			//page.slotsAvailability(rowvalue).click();
				
			while(flag ==0 ) {
				 for(int k=2;k<=5;k++) {
						String searchDate = s.getRow(i).getCell(2).getStringCellValue();
//						SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
//						SimpleDateFormat formatter2=new SimpleDateFormat("E\n"+"dd-MMM");
						try {
							//FormattedDate = formatter1.parse(searchDate);
							
					    	searchdate = p.dateconversion(searchDate);
					    	String searchdate1 = p.dateparsing(searchdate);
							System.out.println(searchdate1);
						   }catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						flag1 = false;
				       String slotDate =page.slotBooking(rowvalue, k).getText();
                       System.out.println(slotDate);
						if(slotDate.equals(searchdate) == true) 
						{ 
						 try {
		                 if(page.slotsAvailability(rowvalue).isDisplayed()) {
							String s2 =page.slotsAvailability(rowvalue).getText();
							if(s2.equals("No Slots Available")) {
						  s.getRow(i).createCell(18).setCellValue(s2);

								
								flag1 = true;
								flag= 1;
								break;
							}
							if(s2.contains("Next Available")) {
								  s.getRow(i).createCell(18).setCellValue(s2);

										
										flag1 = true;
										flag= 1;
										break;
									}
		                 }
						 }catch (NoSuchElementException e2) {
							
						 }
						 try {
		                 if(page.moreSlots(rowvalue, k).isDisplayed()== true) {
							wait.until(ExpectedConditions.elementToBeClickable(page.moreSlots(rowvalue, k))).click();	
		                	 //page.moreSlots(rowvalue,k).click();	
						        div=k;
						        flag=1;
						        flag1 = false;
						        break; 
		                 }
		                 }
							catch (NoSuchElementException e2) {
							
								flag = 1;
								break;
						}
						 }
							 }
						 if(flag==0 && flag1==false) {
						try {
						wait.until(ExpectedConditions.elementToBeClickable(page.nextArrow(rowvalue))).click();	
						// page.nextArrow(rowvalue).click();
						 flag = 0;
						}catch(Exception e2) {
							wait.until(ExpectedConditions.elementToBeClickable(page.slotsAvailability(rowvalue))).click();	
							//page.slotsAvailability(rowvalue).click();
							flag = 0;
						}
						 }
			
			}
			}
			if(s1.equals("No Slots Available")) {
				  s.getRow(i).createCell(18).setCellValue(s1);

						
						flag1 = true;
						flag= 1;
						
					}
			
		  }
		 catch (NoSuchElementException e1) { 
			while(flag == 0) {
				 for(int k=2;k<=5;k++) {
				String searchDate = s.getRow(i).getCell(2).getStringCellValue();
//				SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
//				SimpleDateFormat formatter2=new SimpleDateFormat("E\n"+"dd-MMM");
				try {
					//FormattedDate = formatter1.parse(searchDate);
					searchdate = p.dateconversion(searchDate);
//					String searchdate1 = p.dateparsing(searchdate);
					System.out.println(searchdate);
			        

				   }catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   flag1 = false;
		       String slotDate =page.slotBooking(rowvalue, k).getText();
//		       slotdate = p.dateparsing(slotDate);
//		       slotmonth = p.monthparsing(slotDate);
//		       slotdayofWeek = p.weekparsing(slotDate);
//				System.out.println(slotdayofWeek);
				System.out.println(slotDate);
				
				if(slotDate.equals(searchdate) == true) 
				{ 
				 try {
                 if(page.slotsAvailability(rowvalue).isDisplayed()) {
					String s1 =page.slotsAvailability(rowvalue).getText();
					if(s1.equals("No Slots Available")) {
						 s.getRow(i).createCell(18).setCellValue(s1);
						flag1 = true;
						flag= 1;
						break;
					}
                 }
				 }catch (NoSuchElementException e2) {
					
					 }
				 try {
					 if(page.slotsAvailability(rowvalue).isDisplayed()) {
							String s1 =page.slotsAvailability(rowvalue).getText();
							if(s1.contains("Next Available")) {
								 s.getRow(i).createCell(18).setCellValue(s1);
								flag1 = true;
								flag= 1;
								break;
							}
		                 }
					 }catch(Exception e) {
						 
				 }
				 try {
                 if(page.moreSlots(rowvalue, k).isDisplayed()== true) {
                	 page.moreSlots(rowvalue,k).click();	
				        div=k;
				        flag=1;
				        flag1 = false;
				        break; 
                 }
                 }
					catch (NoSuchElementException e2) {
					
						flag = 1;
						break;
				}
				 }
					 }
				 if(flag==0 && flag1==false) {
				try {	
				wait.until(ExpectedConditions.elementToBeClickable(page.nextArrow(rowvalue))).click();		
				 //page.nextArrow(rowvalue).click();
				 flag = 0;
				 flag1 = false;
				}catch(Exception e2) {
					wait.until(ExpectedConditions.elementToBeClickable(page.slotsAvailability(rowvalue))).click();	
					//page.slotsAvailability(rowvalue).click();
					flag = 0;
					flag1 = false;
				}
				 }
			}
		 }
		
		if (flag1 ==false || flag == 0) {			
		for (int l =2; l <1000; l++) {
			String time =s.getRow(i).getCell(3).getStringCellValue();
			try {
			wait.until(ExpectedConditions.elementToBeClickable(page.slotTIme(rowvalue, div, l))).isDisplayed();	
	        //page.slotTIme(rowvalue, div, l).isDisplayed();
			String SlotTime = page.slotTIme(rowvalue, div, l).getText(); 
			
			if(SlotTime.contains(time) == true) {
			 slottype = page.slotTIme(rowvalue, div, l).getAttribute("title");
				wait.until(ExpectedConditions.elementToBeClickable(page.slotTIme(rowvalue, div, l))).click();
				flag2 = false;
               //page.slotTIme(rowvalue, div, l).click();
				break;
			}
			}catch(NoSuchElementException e2) {
			 System.out.println("No Such slot time available" + time);
			 s.getRow(i).createCell(18).setCellValue("No Such slot time available" + time);
				FileOutputStream fout2 = new FileOutputStream(src);
				wb.write(fout2);
				flag = 1;
			 flag1 = true;
			 flag2 = true;
		     	break;
			}  
			}
		if (flag2 == false) {
			
		if (slottype.equals("Office/Video")== true) {
		String typeSelection= s.getRow(i).getCell(5).getStringCellValue();
		wait.until(ExpectedConditions.elementToBeClickable(page.slottype(typeSelection))).click();
//		Thread.sleep(2000);
//		System.out.println(typeSelection.contentEquals("Office Visit"));
//		
		}
		
		Thread.sleep(2000);
	    String AppointmentFor = s.getRow(i).getCell(6).getStringCellValue();
	    
	    switch (AppointmentFor) {
	    
	    case "Self":
	    	//wait.until(ExpectedConditions.elementToBeClickable(page.selfOption)).click();
	       // action.moveToElement(page.selfOption).click().perform();
	    	break;
	    case "Others":
	    	wait.until(ExpectedConditions.elementToBeClickable(page.otherOption)).click();
	    	wait.until(ExpectedConditions.elementToBeClickable(page.familyMemberRelation)).sendKeys(s.getRow(i).getCell(7).getStringCellValue());
	    	wait.until(ExpectedConditions.elementToBeClickable(page.familyMemberName)).sendKeys(s.getRow(i).getCell(8).getStringCellValue());

//	    	action.moveToElement(page.otherOption).click().perform();
//	    	Thread.sleep(2000);
//	    	action.moveToElement(page.familyMemberRelation).sendKeys(s.getRow(i).getCell(7).getStringCellValue()).perform();
//	    	Thread.sleep(2000);
//	    	action.moveToElement(page.familyMemberName).sendKeys(s.getRow(i).getCell(8).getStringCellValue()).perform();
          break;
          
          default:
        	  System.out.println("Appoinmtment For Does not Match");
	    	
	    }
		try {
	    wait.until(ExpectedConditions.elementToBeClickable(page.reasonForVIsit)).sendKeys(s.getRow(i).getCell(9).getStringCellValue());
		// action.moveToElement(page.reasonForVIsit).click().perform();
		//Thread.sleep(2000);
//		action.sendKeys(s.getRow(i).getCell(7).getStringCellValue()).perform();
//		Thread.sleep(2000);
		String Terms=s.getRow(i).getCell(10).getStringCellValue() ;
		 switch (Terms) {
		   
		 case "I Agree":
				wait.until(ExpectedConditions.elementToBeClickable(page.iAgreeButton)).click();
			 //action.moveToElement(page.iAgreeButton).click().perform();;
		     break;
		 case "I do not Agree":
			wait.until(ExpectedConditions.elementToBeClickable(page.iDoNotAgreeButton)).click();
			// action.moveToElement(page.iDoNotAgreeButton).click().perform();
			 break;
		default:
			System.out.println("No Agreement Button Found");
		 }
		 
		 String buttonToMove =s.getRow(i).getCell(11).getStringCellValue();
		 switch (buttonToMove) {
		 
		 case "Confirm And Continue For Payment":
			 action.moveToElement(page.confirmAndContinueForPaymentButton).click().perform();
			 Thread.sleep(2000);
		     String paymentMode = s.getRow(i).getCell(12).getStringCellValue();
		     System.out.println("Payment Method ---->"+paymentMode);
              switch (paymentMode) {
              case "Card":
     		        driver.switchTo().frame(page.patientForm);
            	    action.moveToElement(page.cardOption).click().perform();
					Thread.sleep(2000);
					action.moveToElement(page.skipSavedCards).click().perform();
					Thread.sleep(2000);
					action.moveToElement(page.cardNumber).sendKeys(s.getRow(i).getCell(13).getStringCellValue()).perform();
					Thread.sleep(2000);
					action.moveToElement(page.expiry).click().perform();
					action.sendKeys(s.getRow(i).getCell(14).getStringCellValue()).perform();
				    Thread.sleep(2000);
					action.moveToElement(page.cvvNumber).click().perform();
					action.sendKeys(s.getRow(i).getCell(15).getStringCellValue()).perform();
					Thread.sleep(2000);
					action.moveToElement(page.paymentButton).click().perform();
					Thread.sleep(2000);
					action.moveToElement(page.skipSavedCards).click().perform();
					
					break;
              case "Net Banking":
            	   action.sendKeys(Keys.ARROW_DOWN);
            	   driver.switchTo().frame(page.patientForm);
            	   //Thread.sleep(2000);
       			   wait.until(ExpectedConditions.elementToBeClickable(page.netBanking)).click();
//            	   action.moveToElement(page.netBanking).click().perform();
//            	   Thread.sleep(2000);
            	   String bankName =s.getRow(i).getCell(16).getStringCellValue();
            	   switch (bankName) {
            	   case "SBI":
            		   action.moveToElement(page.stateBank).click().perform();
                	   break;
            	   case "Axis":
            		   action.moveToElement(page.axisBank).click().perform();
                	   break;	   
            	   case "HDFC":
            		   action.moveToElement(page.hdfcBank).click().perform();
                	   break;   
            	   case "ICICI":
            		   wait.until(ExpectedConditions.elementToBeClickable(page.iciciBank)).click();
            		   //action.moveToElement(page.iciciBank).click().perform();
                	   break;	 
            	   case "Kotak":
            		   action.moveToElement(page.kotakBank).click().perform();
                	   break;   
            	   case "Yes":
            		   action.moveToElement(page.yesBank).click().perform();
                	   break;	
                	default :
                		System.out.println("Bank Unavailable");
            	   }
            	   
            	   action.moveToElement(page.paymentButton).click().perform();
            	  break;
            	  
             default :
            	System.out.println("No Payment Mode is matched");
              
              }
				break;	
				/*
				 * action.moveToElement(page.netBanking).click().perform(); Thread.sleep(1000);
				 * action.moveToElement(page.stateBank).click(); Thread.sleep(1000);
				 * action.moveToElement(page.paymentButton).click(); break;
				 */
			 
		 case "Confirm And Pay After Visit":
			 Thread.sleep(2000);
			 action.moveToElement(page.payAfterVisitButton).click().perform();
			 break;
		default:
			System.out.println("No Button to move found");
			 
		 }
		
		String successOrNot = s.getRow(i).getCell(17).getStringCellValue();
		wait.until(ExpectedConditions.elementToBeClickable(page.successButton));
		//Thread.sleep(2000);
		if (buttonToMove.equals("Confirm And Continue For Payment") == true) {
			wait.until(ExpectedConditions.elementToBeClickable(page.successButton));
		switch (successOrNot) {
		case "Success":
			wait.until(ExpectedConditions.elementToBeClickable(page.successButton)).isDisplayed();
			wait.until(ExpectedConditions.elementToBeClickable(page.successButton)).click();
			//action.moveToElement(page.successButton).click().perform();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.elementToBeClickable(page.successStatus)).isDisplayed();
//			wait.until(ExpectedConditions.elementToBeClickable(page.successStatus));
			String Status = page.successStatus.getText();
			s.getRow(i).createCell(18).setCellValue(Status);
			
			
			break;
		case "Failure":
			wait.until(ExpectedConditions.elementToBeClickable(page.failButton)).isDisplayed();
			wait.until(ExpectedConditions.elementToBeClickable(page.failButton)).click();
			wait.until(ExpectedConditions.elementToBeClickable(page.failedStatus)).isDisplayed();
			wait.until(ExpectedConditions.elementToBeClickable(page.failedStatus));

//			action.moveToElement(page.failButton).click().perform();
//			Thread.sleep(10000);
			String Status1 = page.failedStatus.getText();
			s.getRow(i).createCell(18).setCellValue(Status1);
			
			
			break;
		}	
		}
		else {
			Thread.sleep(10000);
			String Status = page.successStatus.getText();
			s.getRow(i).createCell(18).setCellValue(Status);
			
			
			
		}


	}
catch(Exception e){
			
		}
}
	}
          }
		driver.navigate().to("https://demo.ezscheduler.io/");
		wait.until(ExpectedConditions.urlToBe
				("https://demo.ezscheduler.io/"));
		
	
		}
		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
		fout.close();
}
}