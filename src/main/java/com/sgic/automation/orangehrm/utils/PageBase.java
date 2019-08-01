package com.sgic.automation.orangehrm.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class PageBase {
    public static WebDriver driver;
        private static String baseUrl="https://opensource-demo.orangehrmlive.com/";
        private static String driverPath="src"+ File.separator+"test"+ File.separator+"resources"+ File.separator+"drivers"+File.separator;
        protected static String uploadFilepath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"fileUpload";
        private static String osType=System.getProperty("os.Type",Constants.WINDOWS);
        private static String driverType=System.getProperty("browser.type",Constants.CHROME);

    public static void initiateDriver() throws MalformedURLException {
        switch (driverType) {
            case Constants.CHROME:
                if(osType.equals(Constants.UBUNTU)) {
                    System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
                } else
                    System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case Constants.FIREFOX:
                if(osType.equals(Constants.UBUNTU))
                    System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver");
                else System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }
        getDriver().manage().window().maximize();
        getDriver().get(baseUrl);
    }



    /**
     * Get web driver instance
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * * Close web driver instances
     * */
    public static void closeDriver()
    {

        getDriver().quit();
    }
    /** * Refresh web driver instances */
    public static void refreshDriver()
    {
        getDriver().navigate().refresh();
    }
    /**
     * * Navigate Back
     * */
    public static void navigateBack()
    {

        getDriver().navigate().back();
    }
    /**
     * * GetCurrent Window Details
     * */
    public static String getCurrentWindow()
    {
        return getDriver().getWindowHandle();
    }
    /**
     * * Navigate to Window By Title
     * * @param windowName*/
    public static void navigateToWindow(String windowName)
    {

        getDriver().switchTo().window(windowName);
    }

    /**
     * * Static Wait
     * */
    public static void staticWait(int seconds)
    {
        try {
            Thread.sleep(seconds*1000L);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    /**
     *  * Implicit Wait
     *  */
    public static void implicitWait(int seconds)
    {
        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
    /**
     * * Explicit Wait Clickable
     * */
    public static void waiTillClickable(By element ,int seconds)
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /**
     * * Explicit Wait Visible
     * */
    public static void waiTillVisible(By element ,int seconds)
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
