package com.stockfactory.tests.smoke.goods;

import com.stockfactory.pageobject.common.Header;
import com.stockfactory.tests.WarpTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriverException;

public class AddReviewTest extends WarpTest {

    @Before
    public void regTestUser(){
        mainPage.registrationDefault()
                .assertTrueIsDisplayed(Header.textWelcome);
    }

    @Test
    public void addReviewToTheGoodTest(){
        mainPage.navigatetoCategoriesPage()
                .navigatetoElectronicsPage()
                .navigateFirstGoodOnThePage()
                .addReview()
                .assertReviewSubmittedForModeration();
    }

    @After
    public void deleteAllTestNameUsers(){
        try{
            mainPage.openAdminLoginPage()
                    .loginAs()
                    .navigateToCustomersAllPage()
                    .deleteAllUsersByString("testname");
        }catch (WebDriverException e){
            e.printStackTrace();
        }
    }
}
