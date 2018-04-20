package com.stockfactory.tests;

import com.stockfactory.pageobject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WarpTest {
    WebDriver driver;
    public MainPage mainPage;


    @Before
    public void initiateInstance(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        this.driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        mainPage = new MainPage(driver).open();
    }

    @After
    public void closeDriver(){
        driver.close();}

    public void deleteUser(){
        mainPage.openAdminLoginPage()
                .loginAs()
                .navigateToCustomersAllPage()
                .deleteUser("testname");
    }


    public void deleteAllTestNameUsers(){
        /*mainPage = new MainPage(driver).open();*/
        mainPage.openAdminLoginPage()
                .loginAs()
                .navigateToCustomersAllPage()
                .deleteAllUsersByString("testname");
    }


}
