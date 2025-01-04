package actions;
import base.Base;
import credentials.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class CoreMethods extends Base{
	static WebDriver driver;
	Credentials creds = new Credentials();
	public CoreMethods(WebDriver driver) {
		CoreMethods.driver = driver; //Could not use "this" keyword as the driver was initialized in a static way
	}
	JavascriptExecutor js = (JavascriptExecutor)driver;
	Logger logger = LoggerFactory.getLogger(CoreMethods.class);

	public static WebElement GetElement(String locator) {
		if (locator.startsWith("//") || locator.startsWith("(//"))
			return driver.findElement(By.xpath(locator));
		if (locator.startsWith("#")){
			return driver.findElement(By.id(locator));
		}
		if (locator.startsWith(".")){
			return driver.findElement(By.className(locator));
		}
		else
			return driver.findElement(By.cssSelector(locator));
	}
	public void hitUrl(String url) {
		driver.get(url);
		logger.info("Successfully landed on the url {}", creds.baseUrl("testEnvironment"));
		logger.info("Test Script is running at {}, zone = {}, java version = {}, java vm = {}", LocalDateTime.now(), ZonedDateTime.now()
				.getZone(), System.getProperty("java.version"), System.getProperty("java.vm.name"));
	}
	public void insertText(String locator, String inputText) {
		try {
			GetElement(locator).clear();
			GetElement(locator).sendKeys(inputText);
			logger.info("Inserted text: {}, For the Element- {}",inputText,locator);
		} catch (Exception e) {
			logger.error("Failed to insert text: {}",inputText +"exception-"+e);
		}

	}
	public void click(String locator) {
		try{
			GetElement(locator).click();
			logger.info("Clicked on the element-{}",locator);
		} catch (Exception e) {
			logger.error("Clicking on the element failed -{}",locator+ "exception-"+e);
		}

	}
	public void scrollSmooth(String locator){
		try{
			js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest',behavior: 'smooth'});", GetElement(locator));
			logger.info("Scrolled to the element-{}",locator);
		} catch (Exception e) {
			logger.error("Scrolled to the element failed-{}",locator+ "exception-"+e);
		}

	}

}
