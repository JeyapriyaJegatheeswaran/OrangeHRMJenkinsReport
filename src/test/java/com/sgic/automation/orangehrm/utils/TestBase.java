package com.sgic.automation.orangehrm.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class TestBase extends PageBase {

    public SoftAssert softAssert;
    public static ExtentReports extentReport = new ExtentReports(System.getProperty("user.dir") + "/src/test/resources/reports/ExtentReportResults.html");
    public static ExtentTest extentTest;
    private static final Logger LOGGER = Logger.getLogger(TestBase.class);

    @BeforeTest
    public void beforeTest() {

        System.out.println("Test Running " + this.getClass().toString());
    }

    @BeforeMethod
    public void loadBrowser() {
        LOGGER.info("Initiate Browser");
        try {
            PageBase.initiateDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        LOGGER.info("Browser Initiated");
    }

    @BeforeMethod
    public void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void nameBefore(Method method) {

        LOGGER.info("Test name: " + method.getName());
    }
    @AfterMethod(alwaysRun=true)
    public void endTest(ITestResult result) throws Exception {
        if(!result.isSuccess()){
            extentReport.endTest(extentTest);
            extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(ExtentReportFunctions.getFilePath()));


        }
        LOGGER.info("Closing Browser");
        PageBase.closeDriver();
        LOGGER.info("Browser Closed");
        SendMail.SendEmail();
        extentReport.flush();


    }


    @AfterMethod
    public void afterMethod(Method method, ITestResult result) {
        LOGGER.info("Executed test case name:" + method.getName() + " Execution Results : " + result.toString());
    }

    //report generation

//    @AfterSuite
//    public void cleanUp() throws Exception {
//
//
//    }
}
