package sailotech.com.EzScheduler.readMails;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import utils.PropertiesReaderUtility;

public class OTP_for_Patient_Registration {
	
	 static String user_dir = System.getProperty("user.dir");
		protected  static  PropertiesReaderUtility prop = new PropertiesReaderUtility(user_dir + "\\selenium.properties");

	
	Properties properties = null;
    private Session session = null;
    private Store store;
    private Folder inbox;
    private String userName = prop.getProperty("email_id");// provide user name
    private String password = prop.getProperty("mail_pwd");
    private String saveDirectory = System.getProperty("user.dir") + "\\SaveEmails";
    
   
    @SuppressWarnings("unused")
    private boolean textIsHtml = false;
     
    private String getText(Part p) throws MessagingException,IOException {
        if (p.isMimeType("text/*")) 
        {
            String s = (String)p.getContent();
            textIsHtml = p.isMimeType("text/html");
            return s;
        }
        if (p.isMimeType("multipart/alternative")) {
            // prefer html text over plain text
            Multipart mp = (Multipart)p.getContent();
            String text = null;
            for (int i = 0; i < mp.getCount(); i++) {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain")) {
                    if (text == null)
                        text = getText(bp);
                    continue;
                } else if (bp.isMimeType("text/html")) {
                    String s = getText(bp);
                    if (s != null)
                        return s;
                } else {
                    return getText(bp);
                }
            }
            return text;
        } else if (p.isMimeType("multipart/*")) {
            Multipart mp = (Multipart)p.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                String s = getText(mp.getBodyPart(i));
                if (s != null)
                    return s;
            }
        }
        return null;
    }


    public void readMail() throws IOException {
    	
   	    String OTP ="" ;
      
    properties = new Properties();
    properties.setProperty("mail.store.protocol", "imaps");
    //properties.setProperty("mail.smtp.auth","true");
    //properties.setProperty("mail.smtp.port","587");
    
    try {
        session = Session.getDefaultInstance(properties, null);
       
		//Authenticator Authenticator;
		//session = Session.getInstance(properties, Authenticator);
         store = session.getStore("imaps");
        store.connect("imap.gmail.com", userName, password);
        
        inbox = store.getFolder("Inbox");
        inbox.open(Folder.READ_WRITE); 
        Flags seen = new Flags(Flags.Flag.SEEN);
        FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
        Message messages[] = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
		/*
		 * int unreadMailCount = inbox.getUnreadMessageCount();
		 * System.out.println("No. of Unread Mails = " + unreadMailCount); Message
		 * messages[] = inbox.getMessages(); int unreadMessages = messages.length -
		 * unreadMailCount; System.out.println("No. of Total Mails = " +
		 * inbox.getMessageCount()); System.out.println("No. of unread Mails = "
		 * +inbox.getUnreadMessageCount());
		 */
        String user_dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Patient_Login.xlsx");
    	XSSFWorkbook wb = new XSSFWorkbook(fis);

		
		int counter=0; 
		int rowCount = 1;
        for (int i = 0; i < messages.length; i++) {
        	
            Message message = messages[i];
            //Message emailMessage = inbox.getMessage(i);
            
            
            if(message.getSubject().equals("EZ Scheduler OTP for registration")) 
            {
            Address[] from = message.getFrom();
            System.out.println("====================================== Mail no.: " + i + " start ======================================");
            System.out.println("Date: " + message.getSentDate());
            System.out.println("From: " + from[0]);
            System.out.println("Subject: " + message.getSubject());
            String body = org.jsoup.Jsoup.parse(getText(message).toString()).text();
            System.out.println("Body:  "+body);
            Pattern pattern = Pattern.compile(":\s[0-9]+");
            Matcher matcher = pattern.matcher(body);
           
            if(matcher.find()) {
             String otp1 = matcher.group();
             String Otp2 = otp1.replaceAll(":", "");
             OTP =Otp2.replaceAll(" ", "");
             //row.createCell(0).setCellValue(LoginID);
               System.out.println(OTP); 
               
              
         }
          XSSFSheet s = wb.getSheetAt(2);
            Object[][] otpDetails = {
            		{OTP},
            		
            };
            
            for (Object[] patientRegistration : otpDetails) {
                Row row = s.createRow(rowCount);
                  System.out.println(rowCount);
                int columnCount = 0;
                  
                for (Object field : patientRegistration) {
                    Cell cell = row.createCell(columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                    columnCount++;
                }
                  
            }       	
           	
            rowCount++;
            System.out.println(rowCount);
            message.setFlag(Flags.Flag.SEEN, true);
       System.out.println("====================================== Mail no.: " + i + " end ======================================");
       }
       }
        System.out.println(counter);
        FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Patient_Login.xlsx");
    	wb.write(fout);
        inbox.close(true);
        store.close();
        wb.close();
        
        }catch (Exception e) {  
                System.out.println(e);    
            }
}}
	


