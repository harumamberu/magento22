package com.stockfactory.tests.smoke.goods;

import com.stockfactory.tests.WarpTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddReviewTest extends WarpTest {

    @Before
    public void regTestUser(){
        regTestNameUser();
    }

    //Разбить тест на отправку
    @Test
    public void addReviewToTheGoodTest(){
        mainPage.navigatetoCategoriesPage()
                .navigatetoElectronicsPage()
                .navigateFirstGoodOnThePage()
                .addReview()
                .assertReviewSubmittedForModeration();
    }

    @After
    public void deleteTestData(){
        deleteAllUsersByTestName();
        deleteAllReviewsByTestNickname();
    }
}
