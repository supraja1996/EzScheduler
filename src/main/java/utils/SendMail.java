package utils;

import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;


public class SendMail {

	static String user_dir = System.getProperty("user.dir");
	
	
// this method is to zip the folder
		
	 public static void zipFolder(final Path sourceFolderPath, Path zipPath) throws Exception {
		 
				    	
    final ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath.toFile()));
	Files.walkFileTree(sourceFolderPath, new SimpleFileVisitor<Path>() {
		    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
		    {
		       	zos.putNextEntry(new ZipEntry(sourceFolderPath.relativize(file).toString()));
		       	Files.copy(file, zos);
		        zos.closeEntry();
		        return FileVisitResult.CONTINUE;
            }
		});
		
	    zos.close();	
	    
	    //calling send email attachment method
	    //sendEmail_attachment();
	 }
		
	
  //this method is to send an email attachment to the intended recipients
	
	public static void sendEmail_attachment(ITestResult result) throws EmailException{
		
		
		
		 EmailAttachment attachment = new EmailAttachment();
		 
	
	//	  attachment.setPath(user_dir + "\\OldFailedScreens\\escreen.zip");
		  
	      attachment.setPath( user_dir + "\\FailedScreens\\errorscreen.png");
		 		
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
	//	  attachment.setDescription("WindowsError zip");
		  attachment.setName("Failed screen.png");
	   
		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("mail.sailotech.net");
		 email.setSmtpPort(465);
		 email.setAuthenticator(new DefaultAuthenticator("dev_stp@sailotech.net", "S@t@p$#2019"));
		  email.setSSLOnConnect(true);
		
		  email.setFrom("srilakshmi.supraja@sailotech.net", "Supraja");
	//	  email.addTo("krishna.chekuri@sailotech.com", "Krishna");
		  email.addTo("srilakshmi.supraja@sailotech.net", "Supraja");
	//	  email.addTo("rajasekhar.venati@sailotech.net", "Rajashekar");
		  
		  email.setSubject("EzScheduler Automation - Failed at Step : "+result.getName());
		  email.setMsg("\n Hi, \n\n Error Screenshot is attached for your reference. \n Please take the necessary action. \n\n Thank you, \n EzScheduler Team. ");
		  
		  // add the attachment
		  email.attach(attachment);

		  // send the email
		  email.send();
		  
		  System.out.println("email attachment sent");

	}
	
	public static void main(String[] args) throws Exception {
		
		
		//set up the folder to zip and destination zip file location
		String folderToZip = user_dir + "\\FailedScreens\\";
		String destzipName = user_dir + "\\OldFailedScreens\\escreen.zip";

		//Instantiate and call the parameterized zipFolder method
		SendMail zf = new SendMail();
	//	SendMail.zipFolder(Paths.get(folderToZip), Paths.get(destzipName));
	
}
	
}
