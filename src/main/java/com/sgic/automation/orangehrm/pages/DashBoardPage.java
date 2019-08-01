package com.sgic.automation.orangehrm.pages;

import com.sgic.automation.orangehrm.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * @Author Jeyapriya
 */
public class DashBoardPage extends PageBase {
    private static final Logger LOGGER = Logger.getLogger(LoginPage.class);
    private static By dashboardHeading=By.xpath("//*[@id=\"content\"]/div/div[1]/h1");
    private static By welcomeAdminbtn=By.id("welcome");
    private static By btnLogout=By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a");

    private static By btnBerformance=By.id("menu__Performance");
    private static By btnConfigure=By.id("menu_performance_Configure");
    private static By btnManageReview=By.id("menu_performance_ManageReviews");
    private static By btnEmployeeTrackers=By.id("menu_performance_viewEmployeePerformanceTrackerList");
    private static By btnKPIs=By.id("menu_performance_searchKpi");
    private static By btnTrackers=By.id("menu_performance_addPerformanceTracker");
    private static By btnManageReviews=By.id("menu_performance_searchPerformancReview");
    private static By btnTime=By.id("menu_time_viewTimeModule");
     /////admin Menu Page Click Theva Cash script
    private static By btnAdmin=By.id("menu_admin_viewAdminModule");
   //admim Menu Click Theva Test Cash script
    public static void clickAdmin(){
        getDriver().findElement(btnAdmin).click();
    }

    public static boolean isDashboardDisplayed(){

        return  getDriver().findElement(dashboardHeading).isDisplayed();

    }
    public static boolean isWelcomeAdminbtnDisplayed(){
       return getDriver().findElement(welcomeAdminbtn).isDisplayed();
    }
    public static void clickWelcomeAdminbtn(){
        getDriver().findElement(welcomeAdminbtn).click();
    }
    public static void clickLogoutbtn(){
        implicitWait(3);
        getDriver().findElement(btnLogout).click();
    }
    public static void clickTime(){
        getDriver().findElement(btnTime).click();
    }

    public static boolean isPerfomanceBtnDisplay(){
        return getDriver().findElement(btnBerformance).isDisplayed();
    }
    public static void clickPerfomance(){
        getDriver().findElement(btnBerformance).click();
    }
    public static boolean isConfigureBtnDisplay(){
        return getDriver().findElement(btnConfigure).isDisplayed();
    }
    public static void clickConfigure(){
        getDriver().findElement(btnConfigure).click();
    }
    public static boolean isKPIsBtnDisplay(){
        return getDriver().findElement(btnKPIs).isDisplayed();
    }
    public static void clickKPIs(){
        getDriver().findElement(btnKPIs).click();
    }
    public static void clickEmployeeTrackersbtn()
    {
        getDriver().findElement(btnEmployeeTrackers).click();
    }
    public static boolean isTrackerBtnDisplay(){
        return getDriver().findElement(btnTrackers).isDisplayed();
    }
    public static void clickTrackersbtn()
    {
        getDriver().findElement(btnTrackers).click();
    }
    public static void clickManageReviewbtn()
    {
        getDriver().findElement(btnManageReview).click();
    }
    public static void clickManageReviewsbtn()
    {
        getDriver().findElement(btnManageReviews).click();
    }

}
