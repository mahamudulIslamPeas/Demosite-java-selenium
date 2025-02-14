package page;

import org.openqa.selenium.WebDriver;
import base.Base;
import genericClass.CoreMethods;
import locators.loginLocators;

public class loginPage extends Base{
	WebDriver driver;
	CoreMethods CoreMethods;
	public loginPage(WebDriver driver){
		this.driver = driver;
		CoreMethods = new CoreMethods(this.driver);
	}
	public void homePage( String insertUrl) {
		CoreMethods.hitUrl(insertUrl);
	}
	public void insertUserName(String userName) {
		CoreMethods.insertText(loginLocators.userNameLocator,userName);
	}
	public void insertPassword(String password) {
		CoreMethods.insertText(loginLocators.passwordLocator,password);
	}
	public void clickLoginButton() {
		CoreMethods.click(loginLocators.loginButtonLocator);
	}

}
