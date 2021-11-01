package sailotech.com.EzScheduler.readMails;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Parameter;
import sailotech.com.EzScheduler.consumerPages.PatientLogin;
import utils.PropertiesReaderUtility;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;

public class DoctorRegistration {
	static String user_dir = System.getProperty("user.dir");
	protected static PropertiesReaderUtility prop = new PropertiesReaderUtility(user_dir + "\\selenium.properties");

	Properties properties = null;
	private Session session = null;
	private Store store;
	private Folder inbox;
	private String userName = prop.getProperty("email_id");
	private String password = prop.getProperty("mail_pwd");// provide password
	private String saveDirectory = System.getProperty("user.dir") + "\\SaveEmails";

	@SuppressWarnings("unused")
	private boolean textIsHtml = false;

	private String getText(Part p) throws MessagingException, IOException {
		if (p.isMimeType("text/*")) {
			String s = (String) p.getContent();
			textIsHtml = p.isMimeType("text/html");
			return s;
		}
		if (p.isMimeType("multipart/alternative")) {
			// prefer html text over plain text
			Multipart mp = (Multipart) p.getContent();
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
			Multipart mp = (Multipart) p.getContent();
			for (int i = 0; i < mp.getCount(); i++) {
				String s = getText(mp.getBodyPart(i));
				if (s != null)
					return s;
			}
		}
		return null;
	}

	public void readMail() throws IOException {

		String LoginID = "";
		String MailID = "";
		String Password = "";
		String Name = "";
		properties = new Properties();
		properties.setProperty("mail.store.protocol", "imaps");
		// properties.setProperty("mail.smtp.auth","true");
		// properties.setProperty("mail.smtp.port","587");

		try {
			session = Session.getDefaultInstance(properties, null);

			// Authenticator Authenticator;
			// session = Session.getInstance(properties, Authenticator);
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
			FileInputStream fis = new FileInputStream(user_dir + "\\inputFiles\\Doctor_Login.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			int counter = 0;
			int rowCount = 1;
			for (int i = 0; i < messages.length; i++) {

				Message message = messages[i];
				// Message emailMessage = inbox.getMessage(i);

				if (message.getSubject().equals("Account activated")) {
					Address[] from = message.getFrom();
					System.out.println("====================================== Mail no.: " + i
							+ " start ======================================");
					System.out.println("Date: " + message.getSentDate());
					System.out.println("From: " + from[0]);
					System.out.println("Subject: " + message.getSubject());
					String body = org.jsoup.Jsoup.parse(getText(message).toString()).text();
					System.out.println("Body:  " + body);
					Pattern pattern = Pattern.compile("\s[a-zA-Z]+[0-9]+");
					Matcher matcher = pattern.matcher(body);
					Pattern pattern1 = Pattern.compile("\s[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+");
					Matcher matcher1 = pattern1.matcher(body);
					Pattern pattern2 = Pattern.compile(":\s[a-zA-Z0-9]{8}");
					Matcher matcher2 = pattern2.matcher(body);
					Pattern pattern3 = Pattern.compile("Hello\s[A-Za-z\s]*,");
					Matcher matcher3 = pattern3.matcher(body);
					if (matcher.find()) {
						String LoginID1 = matcher.group();
						LoginID = LoginID1.replaceAll(" ", "");
						// row.createCell(0).setCellValue(LoginID);
						System.out.println(LoginID);

					}
					if (matcher1.find()) {
						String MailID1 = matcher1.group();
						MailID = MailID1.replaceAll(" ", "");
						// row.createCell(1).setCellValue(MailID);
						System.out.println(MailID);

					}

					if (matcher2.find()) {
						String Password1 = matcher2.group();
						String Password2 = Password1.replaceAll(":", "");
						Password = Password2.replaceAll(" ", "");
						// row.createCell(2).setCellValue(Password);

						System.out.println(Password);

					}
					if (matcher3.find()) {
						String name1 = matcher3.group();
						String name2 = name1.replaceAll("Hello", "");
						String name3 = name2.replaceAll(",", "");
						Name = name3.replaceAll(" ", "");
						// row.createCell(2).setCellValue(Password);

						System.out.println(Name);
					}
					XSSFSheet s = wb.getSheetAt(2);
					Object[][] loginDetails = { { Name, LoginID, MailID, Password },

					};

					for (Object[] aBook : loginDetails) {
						Row row = s.createRow(rowCount);
						System.out.println(rowCount);
						int columnCount = 0;

						for (Object field : aBook) {
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
					System.out.println("====================================== Mail no.: " + i
							+ " end ======================================");
				}
			}
			System.out.println(counter);
			FileOutputStream fout = new FileOutputStream(user_dir + "\\inputFiles\\Doctor_Login.xlsx");
			wb.write(fout);
			inbox.close(true);
			store.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
