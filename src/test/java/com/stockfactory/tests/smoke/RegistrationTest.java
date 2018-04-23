package com.stockfactory.tests.smoke;

import com.stockfactory.pageobject.common.Header;
import com.stockfactory.tests.WarpTest;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;


public class RegistrationTest extends WarpTest{


    @Test
    public void DefaultRegistrationTest(){
        mainPage.registrationDefault()
                .assertTrueIsDisplayed(Header.textWelcome);
    }

    /*@Test
    public void FacebookRegTest(){
        mainPage.registrationFacebook();
    }

    @Test
    public void GoogleRegTest(){
        mainPage.registrationGoogle();
    }*/

    //@After
    public void delAllUsers(){
        try{
            deleteAllUsersByTestName();
        }catch(TimeoutException e){

        }
    }
}
