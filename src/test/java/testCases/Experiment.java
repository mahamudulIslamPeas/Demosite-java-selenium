package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Experiment {
    @Test
    public void experimentalTest(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.com/");
        try{
            Thread.sleep(3000);
        } catch (InterruptedException a){
            throw new RuntimeException(a);
        }
        WebElement careersAmazon =  driver.findElement(By.xpath("//a[normalize-space()='Careers']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest',behavior: 'smooth'});", careersAmazon);
//        js.executeScript("arguments[0].scroll({top: arguments[0].scrollHeight, behavior: 'smooth'})",driver.findElement(By.xpath("//a[normalize-space()='Careers']")));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
