package sailotech.com.EzScheduler.providerPages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.allure.annotations.Attachment;
import sailotech.com.EzScheduler.basePages.BaseTest;

public class Navigations extends BaseTest{
	
	public Navigations(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
	@Attachment
	public byte[] navigateToMYSchedule() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

public void navigatetoMySchedule() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, 5);

	Repository page = new Repository(driver);
	Actions action = new Actions(driver);
	wait.until(ExpectedConditions.elementToBeClickable(page.menu)).click();
	wait.until(ExpectedConditions.elementToBeClickable(page.myScheduleMenu)).click();
	navigateToMYSchedule();
}

@Attachment
public byte[] navigateToLoginPage() {
	return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
}
public void navigatetoLoginPage() throws Exception{
	WebDriverWait wait = new WebDriverWait(driver, 5);

	Repository page = new Repository(driver);
	Actions action = new Actions(driver);
	wait.until(ExpectedConditions.elementToBeClickable(page.buttonLoginRegister)).click();
	wait.until(ExpectedConditions.elementToBeClickable(page.doctorLoginButton)).click();
	wait.until(ExpectedConditions.elementToBeClickable(page.loginArrow)).click();
	navigateToLoginPage();
}
@Attachment
public byte[] navigateToRegistrationPage() {
	return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
}

public void navigatetoRegistrationPage() throws Exception{
	WebDriverWait wait = new WebDriverWait(driver, 5);

	Repository page = new Repository(driver);
	Actions action = new Actions(driver);
	wait.until(ExpectedConditions.elementToBeClickable(page.buttonLoginRegister)).click();
	wait.until(ExpectedConditions.elementToBeClickable(page.doctorRegisterMenu)).click();
	navigateToRegistrationPage();
}
}
