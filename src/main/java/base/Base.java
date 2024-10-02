package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import static  java.time.Duration.ofMillis;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import utils.EventHandler;

public class Base {
	WebDriver activeDriver; //initializing driver or setting the active driver
	EventHandler handler = new EventHandler();
	EventFiringWebDriver eventDriver;


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


//		eventDriver.register(handler);
	}

	@AfterTest
	public void closeBrowser() {
		if (activeDriver != null){
			activeDriver.quit();
		}
		System.out.println("Closed From Base");
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
//		driver = activeDriver;
		return activeDriver;
    }

}
