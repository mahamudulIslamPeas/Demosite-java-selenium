package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ExcelDataReader;

import java.io.IOException;

public class TestFile2 extends LoginTest{
    @Test
    public void TestCaseTwo(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        driver.findElement(By.xpath("//span[contains(text(),'Organization ')]")).click();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @BeforeClass
    public void alertForExecutingTestCaseTwo(){
        System.out.println("TestCase-2 is Fired");
    }
    @AfterClass
    public void alertForCompletionTestCaseTwo(){
        System.out.println("TestCase-2 is Executed Successfully");
    }

    public static void main(String[] args) throws IOException {
        ExcelDataReader.getExcelData("Web");
    }

}
