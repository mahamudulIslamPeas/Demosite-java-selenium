package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import static java.time.Duration.ofSeconds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

	private static final Logger log = LoggerFactory.getLogger(Base.class);
	WebDriver activeDriver;

	//	Fetching the data from the global properties file
	Properties prop = new Properties();
	FileInputStream fis;
	{
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//project_config//GlobalData.properties");
			prop.load(fis);
		} catch (IOException e) {
			log.info(e.toString());
		}
	}
	String browserName = prop.getProperty("browser");

	//	Object creation of driver
	private void setActiveDriver(String driver) {
		if (driver.equalsIgnoreCase("chrome"))
		{
			activeDriver = new ChromeDriver();
		}
		if (driver.equalsIgnoreCase("edge"))
		{
			activeDriver = new EdgeDriver();
		}
		if (driver.equalsIgnoreCase("firefox"))
		{
			activeDriver = new FirefoxDriver();
		}
		if (driver.equalsIgnoreCase("safari"))
		{
			activeDriver = new SafariDriver();
		}
	}
	public WebDriver getActiveDriver(){
		return activeDriver;
	}
	@BeforeTest
	public void setUpBrowser() {
		setActiveDriver(browserName); //Choose the browser from here
		activeDriver.manage().window().maximize();
		activeDriver.manage().timeouts().implicitlyWait(ofSeconds(30));
		activeDriver.manage().timeouts().pageLoadTimeout(ofSeconds(30));
	}
	@AfterTest
	public void closeBrowser() {
		try {
			if (activeDriver != null){
				activeDriver.quit();
			}
			log.info("Successfully Terminated");
		} catch (Exception e) {
			log.error("Could not terminate the driver properlyException-",e);
		}

	}

}
