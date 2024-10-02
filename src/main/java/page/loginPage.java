package page;

import org.openqa.selenium.Credentials;
import org.openqa.selenium.WebDriver;
import base.Base;
import actions.ActionMethods;
import locators.loginLocators;

public class loginPage extends Base{
	WebDriver driver;
	ActionMethods ActionMethods;
    public loginPage(WebDriver driver){
		this.driver = driver;
		ActionMethods = new ActionMethods(this.driver);
	}
	public void homePage( String insertUrl) {
		ActionMethods.hitUrl(insertUrl);
	}
	public void insertUserName(String userName) {
		ActionMethods.insertText(loginLocators.userNameLocator,userName);
	}
	public void insertPassword(String password) {
		ActionMethods.insertText(loginLocators.passwordLocator,password);
	}
	public void clickLoginButton() {
		ActionMethods.click(loginLocators.loginButtonLocator);
	}


}
