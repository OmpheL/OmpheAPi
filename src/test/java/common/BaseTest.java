package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.ExtentManager;

public class BaseTest {

    protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.getInstance();
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}