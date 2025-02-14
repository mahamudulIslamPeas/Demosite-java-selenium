package genericClass;
import base.Base;
import credentials.Credentials;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * The {@code CoreMethods} class provides reusable utility methods for Selenium WebDriver automation.
 * It extends the {@link Base} class and acts as a core framework component for interacting with web elements.
 *
 * <p>
 * This class includes methods for common browser actions such as:
 * <ul>
 *   <li>Locating elements dynamically using different selectors.</li>
 *   <li>Navigating to a URL.</li>
 *   <li>Interacting with input fields.</li>
 *   <li>Clicking elements.</li>
 *   <li>Scrolling smoothly to an element.</li>
 * </ul>
 * </p>
 *
 * <p><b>Note:</b> This class requires a valid WebDriver instance for execution.</p>
 *
 * @author Mahamudul Islam
 * @version 1.0
 * @since 2025-02-14
 */
public class CoreMethods extends Base{
	static WebDriver driver;
	Credentials creds = new Credentials();
	/**
     * Constructor for CoreMethods class.
     *
     * @param driver The WebDriver instance used for interacting with web elements.
     */
	public CoreMethods(WebDriver driver) {
		CoreMethods.driver = driver; //Could not use "this" keyword as the driver was initialized in a static way
	}
	JavascriptExecutor js = (JavascriptExecutor)driver;
	static Logger logger = LoggerFactory.getLogger(CoreMethods.class);

	/**
	 * Finds a web element based on the provided locator.
	 *
	 * <p>
	 * The method determines the locator type dynamically:
	 * <ul>
	 *   <li>XPath: If the locator starts with "//" or "(//".</li>
	 *   <li>ID: If the locator starts with "#".</li>
	 *   <li>Class Name: If the locator starts with ".".</li>
	 *   <li>CSS Selector: Default fallback.</li>
	 * </ul>
	 * </p>
	 *
	 * @param locator The locator string representing the web element.
	 * @return The {@link WebElement} found using the specified locator.
	 */
	public static WebElement GetElement(String locator) {
		WebElement element = null;
		try {
			if (locator.startsWith("//") || locator.startsWith("(//")) {
				element = driver.findElement(By.xpath(locator));
			} else if (locator.startsWith("#")) {
				element = driver.findElement(By.id(locator.substring(1))); // Remove '#' before using ID
			} else if (locator.startsWith(".")) {
				element = driver.findElement(By.className(locator.substring(1))); // Remove '.' before using class
			} else {
				element = driver.findElement(By.cssSelector(locator));
			}

			logger.info("Successfully found the element: {}", locator);
			return element;
		} catch (Exception e) {
			logger.error("Failed to locate element: {}. Exception: {}", locator, e.getMessage());
			throw new NoSuchElementException("Element not found: " + locator, e);
		}
	}

	/**
	 * Navigates to the specified URL in the browser.
	 *
	 * @param url The URL to navigate to.
	 */
	public void hitUrl(String url) {
		try{
			driver.get(url);
			logger.info("Successfully landed on the url {}", creds.baseUrl("testEnvironment"));
			logger.info("Test Script is running at {}, zone = {}, java version = {}, java vm = {}", LocalDateTime.now(), ZonedDateTime.now()
					.getZone(), System.getProperty("java.version"), System.getProperty("java.vm.name"));
		} catch (Exception e) {
			logger.error("Exception while navigating to URL: {}", e.getMessage());
        }

    }

	/**
	 * Inserts text into an input field or text box.
	 *
	 * @param locator   The locator string representing the input field.
	 * @param inputText The text to be inserted.
	 */
	public void insertText(String locator, String inputText) {
		WebElement element = GetElement(locator);
		try {
			element.click();
			element.clear();
			element.sendKeys(inputText);
			logger.info("Inserted text: {}, For the Element- {}",inputText,locator);
		} catch (Exception e) {
			logger.info("Inserted text: '{}' into the element: {}", inputText, locator);
		}

	}
	/**
	 * Clicks on a web element.
	 *
	 * @param locator The locator string representing the clickable element.
	 */
	public void click(String locator) {
		try{
			GetElement(locator).click();
			logger.info("Clicked on the element-{}",locator);
		} catch (Exception e) {
			logger.error("Clicking on the element failed -{}",locator+ "exception-"+e);
		}

	}
	/**
	 * Smoothly scrolls to an element, bringing it to the center of the viewport.
	 * @param locator The locator string representing the element to scroll to.
	 */
	public void scrollSmooth(String locator){
		WebElement element = GetElement(locator);
		try{
			js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest',behavior: 'smooth'});", element);
			logger.info("Scrolled to the element-{}",locator);
		} catch (Exception e) {
			logger.error("Scrolled to the element failed-{}",locator+ "exception-"+e);
		}

	}

}
