package actions;
import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
public class ActionMethods extends Base{
	static WebDriver driver;
	public ActionMethods(WebDriver driver) {
		ActionMethods.driver = driver; //Could not use "this" keyword as the driver was initialized in a static way
	}
	JavascriptExecutor js = (JavascriptExecutor)driver;
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
	}
	public void insertText(String locator, String inputText) {
		GetElement(locator).sendKeys(inputText);
	}
	public void click(String locator) {
		GetElement(locator).click();
	}
	public void scrollSmooth(String locator){
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest',behavior: 'smooth'});", GetElement(locator));
	}
}
