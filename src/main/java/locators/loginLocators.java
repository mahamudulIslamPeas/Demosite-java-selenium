package locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginLocators {
	WebDriver driver;
	public loginLocators(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this); //For PageFactory Approach
	}
	public static String userNameLocator  = "input[placeholder='Username']";
	public static String passwordLocator  = "input[placeholder='Password']";
	public static String loginButtonLocator  = "button[type='submit']";

//		PageFactory approach
	@FindBy(css = "button[type='submit']")
	WebElement loginButton;

//	public static By loginEmailField = By.xpath("//input[@name='email']");
}
