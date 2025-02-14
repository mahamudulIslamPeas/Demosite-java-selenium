package testCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import credentials.Credentials;
import base.Base;
import page.loginPage;
import java.time.Duration;

@Listeners(testComponents.customTestNGListeners.class)
public class LoginTest extends Base {

	private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
	WebDriver driver;
	loginPage page;
	Credentials cred = new Credentials();

	@Test(groups = {"LoginTest"},priority = 1)
	public void login() throws InterruptedException {

//		Initialization and object creation
		driver = getActiveDriver();
		page = new loginPage(driver);
		WebDriverWait explicitWait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
		String expectedUrl = cred.AppUrls("dashboard");

//		Test Steps
		page.homePage(cred.baseUrl("TestEnvironment")); //for reference: TestEnvironment`
		page.insertUserName(cred.userName());
		page.insertPassword(cred.password());
		page.clickLoginButton();

//		Assertion of Login
		explicitWait.until(ExpectedConditions.urlToBe(expectedUrl));
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,expectedUrl);
		Thread.sleep(3000);
		System.out.println("Successfully Logged in to OrangeHRM Demo Site");
	}
	@BeforeClass
	public void loginTestFireAlert(){
		log.info("Login Test Case is Fired");
	}
	@AfterClass
	public void loginTestCompletionAlert(){
		log.info("Login Test Case is Executed");
	}
}

