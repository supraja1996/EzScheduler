package sailotech.com.EzScheduler.providerPages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navigations {
	WebDriver driver;
	public Navigations(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
	}

	public byte[] login(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

public void navigatetoMySchedule() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, 5);

	Repository page = new Repository(driver);
	Actions action = new Actions(driver);
	wait.until(ExpectedConditions.elementToBeClickable(page.menu)).click();
	wait.until(ExpectedConditions.elementToBeClickable(page.myScheduleMenu)).click();
}
public void navigatetoLoginPage() throws Exception{
	WebDriverWait wait = new WebDriverWait(driver, 5);

	Repository page = new Repository(driver);
	Actions action = new Actions(driver);
	wait.until(ExpectedConditions.elementToBeClickable(page.buttonLoginRegister)).click();
	wait.until(ExpectedConditions.elementToBeClickable(page.doctorLoginButton)).click();
	wait.until(ExpectedConditions.elementToBeClickable(page.loginArrow)).click();
}
public void navigatetoRegistrationPage() throws Exception{
	WebDriverWait wait = new WebDriverWait(driver, 5);

	Repository page = new Repository(driver);
	Actions action = new Actions(driver);
	wait.until(ExpectedConditions.elementToBeClickable(page.buttonLoginRegister)).click();
	wait.until(ExpectedConditions.elementToBeClickable(page.doctorRegisterMenu)).click();
}
}
