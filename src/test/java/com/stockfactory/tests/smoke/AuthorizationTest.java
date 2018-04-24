package com.stockfactory.tests.smoke;

import com.stockfactory.pageobject.interfaces.Header;
import com.stockfactory.tests.WarpTest;
import org.junit.Test;

public class AuthorizationTest extends WarpTest {

    @Test
    public void DefaultAuthorizationPositiveTest(){
        mainPage.registrationDefault()
                .logOut()
                .authorizationDefault()
                .assertTrueIsDisplayed(Header.textWelcome);
    }

    /*@Test
    public void FacebookAuthorizationPositiveTest(){
        mainPage.open()
                .authorization("facebook");
    }

    @Test
    public void GooglePlusAuthorizationPositiveTest(){
        mainPage.open()
                .authorization("google");
    }*/

}
