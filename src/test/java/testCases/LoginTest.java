package testCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import credentials.Credentials;
import base.Base;
import page.loginPage;
import java.time.Duration;

//import page.loginPage;
public class LoginTest extends Base{
	WebDriver driver;
	loginPage page;
	Credentials cred = new Credentials();

	@Test(groups = {"LoginTest"})
	public void login() throws InterruptedException {

//		Initialization and object creation
		driver = getActiveDriver();
		page = new loginPage(driver);
		WebDriverWait explicitWait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

//		Test Steps
		page.homePage(cred.baseUrl("TestEnvironment")); //for reference: TestEnvironment
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
		System.out.println("Login Test Case is Fired");
	}
	@AfterClass
	public void loginTestCompletionAlert(){
		System.out.println("Login Test Case is Executed");
	}
}

