package sailotech.com.EzScheduler.basePages;

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

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utils.WebEventListener;
//import com.sailotech.Infor_LN.order2cash.Order2CashPage;

import utils.PropertiesReaderUtility;
import utils.SendMail;

public class BaseTest {

	public static WebDriver driver;
	private static String EXECUTION_ENV = System.getProperty("os.name");
	private static String LINUX_ENV = "Linux";
	// public static String user_name, password;

	static String chrome = "chrome";
	static String firefox = "firefox";
	static String ie = "ie";
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	// public static EventFiringWebDriver e_driver;

//	public static WebEventListener eventListener;
//	

	static String user_dir = System.getProperty("user.dir");
	protected static PropertiesReaderUtility prop = new PropertiesReaderUtility(user_dir + "\\selenium.properties");

	@Parameters("browser")

	@BeforeClass
	public void beforeClass() throws Exception {
		// initBrowser();

		// loadCredentails();

	}

	@AfterClass
	public void afterClass() {
		// stopSession();

	}

	public BaseTest() {

		try {
			System.out.println("*** BaseTest initiated ***");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterMethod // AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result) {
		// using ITestResult.FAILURE is equals to result.getStatus then it enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				// Call method to capture screenshot
				File src = screenshot.getScreenshotAs(OutputType.FILE);

				filesMovetoFolder();

				// Copy files to specific location
				// result.getName() will return name of test case so that screenshot name will
				// be same as test case name

				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
				Date dt = new Date();

				FileUtils.copyFile(src,
						new File(user_dir + "\\FailedScreens\\" + result.getName() + dateFormat.format(dt) + ".png"));
				System.out.println("Successfully captured a screenshot");

				FileUtils.copyFile(src, new File(user_dir + "\\FailedScreens\\" + "errorscreen.png"));
				System.out.println("Successfully captured an error screenshot");

				SendMail sm = SendMail(driver);
				sm.main(null);
				sm.sendEmail_attachment(result);

				System.out.println("Error ScreenShot sent");

			} catch (Exception e) {
				System.out.println("Exception while taking screenshot: " + e.getMessage());
			}
		}
	}

	public static void filesMovetoFolder() {
		File destinationFolder = new File(user_dir + "\\OldFailedScreens");
		File sourceFolder = new File(user_dir + "\\FailedScreens");

		if (!destinationFolder.exists()) {
			destinationFolder.mkdirs();
		}

		// Check weather source exists and it is folder.
		if (sourceFolder.exists() && sourceFolder.isDirectory()) {
			// Get list of the files and iterate over them
			File[] listOfFiles = sourceFolder.listFiles();

			if (listOfFiles != null) {
				for (File child : listOfFiles) {
					// Move files to destination folder
					child.renameTo(new File(destinationFolder + "\\" + child.getName()));

					System.out.println("Files Moved Successfully");
				}

				// Add if you want to delete the source folder
				// sourceFolder.delete();
			}
		} else {
			System.out.println(sourceFolder + "Folder does not exists");
		}
	}

	private SendMail SendMail(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void startSession() {

		System.out.println("Launching Browser");
		String browserName = prop.getProperty("browser");
		String chromeDriverPath = (EXECUTION_ENV.equals(LINUX_ENV)) ? "/drivers/Linux/chromedriver_94"
				: "\\drivers\\chromedriver_89.exe";

		if (prop.getProperty("remoteWebdriver").equalsIgnoreCase("false")) {
			if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", user_dir + "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				System.setProperty("webdriver.chrome.driver", user_dir + "\\drivers\\chromedriver.exe");
				// driver = new ChromeDriver();
				if (EXECUTION_ENV.equals(LINUX_ENV)) {
					options.setBinary("/opt/google/chrome/google-chrome");
					options.addArguments("--no-sandbox"); // Bypass OS security model
					// options.addArguments("--disable-dev-shm-usage");
					options.addArguments("--headless");
					options.addArguments("--disable-extensions");
					/*
					 * options.addArguments("--no-proxy-server");
					 * options.addArguments("--proxy-server='direct://'");
					 * options.addArguments("--proxy-bypass-list=*");
					 */
					options.addArguments("--start-maximized");
					// options.addArguments("--disable-gpu");
					options.addArguments("--incognito");
					options.addArguments("--ignore-certificate-errors");
				} else {
					// close the pop-ups
					options.addArguments("--disable-notifications");
					System.setProperty("java.awt.headless", "false");
					// to enable screenShot and fix timeouts received from renderer
					options.addArguments("--disable-features=VizDisplayCompositor");
				}
				File file = new File(System.getProperty("user.dir") + chromeDriverPath);
				file.setExecutable(true);
				driver = new ChromeDriver(options);
				if (EXECUTION_ENV.equals(LINUX_ENV)) {
					driver.manage().window().setSize(new Dimension(1920, 1080));
				}
				// log.info("launching chrome browser");
				// ChromeOptions options = new ChromeOptions();

				/*
				 * String downloadFilepath = user_dir + "\\Warehouse_xls"; HashMap<String,
				 * Object> chromePrefs = new HashMap<String, Object>();
				 * chromePrefs.put("profile.default_content_settings.popups", 0);
				 * chromePrefs.put("download.default_directory", downloadFilepath);
				 * 
				 * 
				 * options.setExperimentalOption("prefs", chromePrefs);
				 */

//				DesiredCapabilities cap = DesiredCapabilities.chrome();
//				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//				cap.setCapability(ChromeOptions.CAPABILITY, options);

//				driver = new ChromeDriver(cap);

			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", user_dir + "\\drivers\\IEDriverServer_32.exe");
				driver = new InternetExplorerDriver();
//				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
//				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
//						true);
//				driver = new InternetExplorerDriver(ieCapabilities);
			}
		} else {
			System.out.println("No browser is initialized");
		}
//			URL gridUrl = null;
//			try {
//				gridUrl = new URL(prop.getProperty("gridHubURL"));
//			} catch (MalformedURLException e) {
//			}
//			if (prop.getProperty("browser").equalsIgnoreCase(firefox)) {
//
//				FirefoxProfile fp = new FirefoxProfile();
//				// set something on the profile...
//				DesiredCapabilities dc = DesiredCapabilities.firefox();
//				dc.setCapability(FirefoxDriver.PROFILE, fp);
//				driver = new RemoteWebDriver(gridUrl, dc);
//
//			} else if (prop.getProperty("browser").equals(chrome)) {
//				System.setProperty("webdriver.chrome.driver", user_dir + "\\drivers\\chromedriver.exe");
//				ChromeOptions options = new ChromeOptions();
//				// set some options
//				DesiredCapabilities dc = DesiredCapabilities.chrome();
//				dc.setCapability(ChromeOptions.CAPABILITY, options);
//				driver = new RemoteWebDriver(gridUrl, dc);
//
//			} else if (prop.getProperty("browser").equals(ie)) {
//				System.setProperty("webdriver.ie.driver", user_dir + "\\drivers\\IEDriverServer_32.exe");
//
//				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
//				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
//						true);
//				driver = new InternetExplorerDriver(ieCapabilities);
//			}

//		e_driver = new EventFiringWebDriver(driver);
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get(prop.getProperty("baseurl_qa"));
		// driver.manage().window.Size = new size(1024, 768);
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
	}

	public static void initBrowser() {

		/*
		 * System.out.println("Build Number:" + jenkinsBuildNumber);
		 * System.out.println("Job Name:" + jenkinsJobName);
		 */
		System.out.println("launching browser");

		String browserName = prop.getProperty("browser");
		String chromeDriverPath = (EXECUTION_ENV.equals(LINUX_ENV)) ? "/drivers/Linux/chromedriver_94"
				: "\\drivers\\chromedriver.exe";

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			options.setCapability(CapabilityType.TAKES_SCREENSHOT, true);

			if (EXECUTION_ENV.equals(LINUX_ENV)) {
				options.setBinary("/opt/google/chrome/google-chrome");
				options.addArguments("--no-sandbox"); // Bypass OS security model
				// options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--headless");
				options.addArguments("--disable-extensions");
				/*
				 * options.addArguments("--no-proxy-server");
				 * options.addArguments("--proxy-server='direct://'");
				 * options.addArguments("--proxy-bypass-list=*");
				 */
				options.addArguments("--start-maximized");
				// options.addArguments("--disable-gpu");
				options.addArguments("--incognito");
				options.addArguments("--ignore-certificate-errors");
			} else {
				// close the pop-ups
				options.addArguments("--disable-notifications");
				System.setProperty("java.awt.headless", "false");
				// to enable screenShot and fix timeouts received from renderer
				options.addArguments("--disable-features=VizDisplayCompositor");
			}
			File file = new File(System.getProperty("user.dir") + chromeDriverPath);
			file.setExecutable(true);
			driver = new ChromeDriver(options);
			if (EXECUTION_ENV.equals(LINUX_ENV)) {
				driver.manage().window().setSize(new Dimension(1920, 1080));
			}
//			log.info("launching chrome browser");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
//			log.info("launching firefox browser");
		} else {
			System.out.println("no proper browser initialized");
		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.get(prop.getProperty("baseurl_qa"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);

		// driver.get(prop.getProperty("inforLNUrl"));
	}
//	private ScreenRecorder screenRecorder;
//
//	public void startRecording() throws Exception {
//
//		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
//				.getDefaultConfiguration();
//
//		this.screenRecorder = new ScreenRecorder(gc, new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
//				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
//						CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
//						Rational.valueOf(50), QualityKey, 5.0f, KeyFrameIntervalKey, 50 * 60),
//				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
//				null);
//		this.screenRecorder.start();
//	}
//
//	
//	public void stopRecording() throws Exception {
//		this.screenRecorder.stop();
//	}

	public void SwitchTab() throws Exception {
		Actions act = new Actions(driver);
		{
			act.sendKeys(Keys.TAB).build().perform();
		}
	}

	public void click(By locator, String locatorName, WebDriver driver) {
		try {
//			log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//			log.info("Class name" + getCallerClassName() + "Method name : " + getCallerMethodName());
//			log.info("Method : click  ::  Locator : " + locatorName);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			new Actions(driver).moveToElement(driver.findElement(locator)).build().perform();
//			log.info("Waiting for element");
//			log.info("Locator is Visible :: " + locator);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
//			log.info("Clicked on the Locator");
			driver.findElement(locator).click();
//			log.info("identified the element :: " + locator);
//			log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void stopSession() {
		driver.close();
	}
}
