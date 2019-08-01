package com.sgic.automation.orangehrm.tests.performance;

import com.relevantcodes.extentreports.LogStatus;
import com.sgic.automation.orangehrm.TestData.LoginJPData;
import com.sgic.automation.orangehrm.pages.DashBoardPage;
import com.sgic.automation.orangehrm.pages.LoginPage;
import com.sgic.automation.orangehrm.utils.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * @author:jeyapriya
 */
public class LoginTestJP extends TestBase {
    private static final Logger LOGGER = Logger.getLogger(LoginTestJP.class);


    @Test(groups = "REGRESSION", priority = 13,dataProviderClass = LoginJPData.class,dataProvider = "loginValid")
    public void login(String username,String password ,String status,String alertMSg) {
        extentTest =extentReport.startTest("login with userName: "+username+", password : "+password);
        LOGGER.info("Login page is displayed");
        softAssert.assertTrue(LoginPage.isLoginPageDisplay(), "Login Page is not Displayed");
        LOGGER.info("Login with  " + "UserName: " + username + " , Password: " + password);
        LoginPage.login(username, password);


        LOGGER.info("login status: "+status);
        if(status.equals("valid")) {
            softAssert.assertTrue(DashBoardPage.isDashboardDisplayed(), "Dashboard page is not displayed");
            LOGGER.info("DashboardPage is displayed");
            softAssert.assertTrue(DashBoardPage.isWelcomeAdminbtnDisplayed(), "Welcom admin button  is not Displayed");
            extentTest.log(LogStatus.PASS, "Login with Username: " + username + " and Password: " + password,alertMSg);

            DashBoardPage.clickWelcomeAdminbtn();
            DashBoardPage.clickLogoutbtn();
            softAssert.assertTrue(LoginPage.isLoginPageDisplay(), "Login Page is not Displayed");
            LOGGER.info("logout success");
        }
        else {

            LOGGER.info(alertMSg);
            softAssert.assertEquals(LoginPage.getLoginAlert(), alertMSg,
                    "alert msg is not displayed");
            extentTest.log(LogStatus.PASS, "Login with Username: " + username + " and Password: " + password,alertMSg);
        }
        extentReport.endTest(extentTest);
        softAssert.assertAll();
    }
}
