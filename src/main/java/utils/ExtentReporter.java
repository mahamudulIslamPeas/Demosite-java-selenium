package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterTest;

public class ExtentReporter {

    public static ExtentReports getReportObj(){
        String path = System.getProperty("user.dir")+("//reports//index.html");

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation Result");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Test Result");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Mahamudul Islam Peas");
        return extent;
    }

}
