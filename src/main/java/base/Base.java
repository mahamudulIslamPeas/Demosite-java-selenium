package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import static  java.time.Duration.ofMillis;
import org.testng.annotations.*;

public class Base {
	WebDriver activeDriver; //initializing driver or setting the active driver
//	Choose any driver from this enum class
	enum browsers{
		ChromeDriver,
		EdgeDriver,
		FirefoxDriver,
		SafariDriver
	}
	@BeforeTest
	public void setUpBrowser() {
		setActiveDriver(browsers.FirefoxDriver); //Choose the browser from here
		activeDriver.manage().window().maximize();
		activeDriver.manage().timeouts().implicitlyWait(ofMillis(30000));
		activeDriver.manage().timeouts().pageLoadTimeout(ofMillis(30000));
	}

	@AfterTest
	public void closeBrowser() {
		activeDriver.close();
		System.out.println("Okay From Base");
	}

//	Object creation of driver
	private void setActiveDriver(browsers driver) {
		if (driver == browsers.ChromeDriver)
		{
			activeDriver = new ChromeDriver();
		}
		if (driver == browsers.EdgeDriver)
		{
			activeDriver = new EdgeDriver();
		}
		if (driver == browsers.FirefoxDriver)
		{
			activeDriver = new FirefoxDriver();
		}
		if (driver == browsers.SafariDriver)
		{
			activeDriver = new SafariDriver();
		}
	}
	public WebDriver getActiveDriver(){
        return activeDriver;
    }
}
