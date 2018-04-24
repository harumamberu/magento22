package com.stockfactory.tests;

import com.stockfactory.pageobject.MainPage;
import com.stockfactory.pageobject.interfaces.Header;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
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

//HELPERS DELETING TEST DATA
    public void regTestNameUser(){
        mainPage.registrationDefault()
                .assertTrueIsDisplayed(Header.textWelcome);
    }

    public void deleteAllUsersByTestName(){
        /*mainPage = new MainPage(driver).open();*/
        try{
            mainPage.openAdminLoginPage()
                    .loginAs()
                    .navigateToCustomersAllPage()
                    .deleteAllUsersByString("testname");
        }catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    public void deleteAllReviewsByTestNickname(){
        try{
            mainPage.openAdminLoginPage()
                    .loginAs()
                    .navigateToReviewsPage()
                    .searchByNickname("testnick")
                    .selectAllReviews()
                    .deleteSelectedReviews();
        }catch (WebDriverException e){
            e.printStackTrace();
        }
    }
}
