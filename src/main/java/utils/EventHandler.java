package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.Arrays;

public class EventHandler implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        System.out.println("Inside Method of beforeAlertAccept");
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to the url"+ url );
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("After navigating to the url"+ url );
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("Before navigating back" );
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("After navigating back" );
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("Before navigating forward" );
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        System.out.println("After navigating back" );
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        System.out.println("Before Refreshing" );
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
//        System.out.println("Before finding this element"+element.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found the Element"+element.toString());
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("After Clicking on the Element"+element.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Before Inserting the value:"+ Arrays.toString(keysToSend)+"In the element:"+element);
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("After Inserting the value:"+ Arrays.toString(keysToSend)+"In the element:"+element);
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }
}
