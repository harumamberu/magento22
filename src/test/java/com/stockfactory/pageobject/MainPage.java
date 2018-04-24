package com.stockfactory.pageobject;

import com.stockfactory.pageobject.categories.AllCategoriesPage;
import com.stockfactory.pageobject.checkout.CartPage;
import com.stockfactory.pageobject.checkout.CheckoutPage;
import com.stockfactory.pageobject.interfaces.Header;
import com.stockfactory.pageobject.interfaces.NavigationBar;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainPage extends WarpPage implements Header, NavigationBar{

    //HEADER

    //TESTDATA(IN LOGIC LOL). NEED TO MOVE TO THE TESTING LAYER
    public String dateFormat = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
    String password = "q1w2E3R4";
    String email = "blackridgetester" + dateFormat + "COCOCO@gmail.com";


    //конструктор
    public MainPage(WebDriver driver){
        super(driver);
    }


    public void checkInfoPopUp(){
        try{
            if(isClickable(buttonCloseInfoPopUp, driver)){
                clickJS(buttonCloseInfoPopUp);
            }
        }catch (WebDriverException e){
            e.printStackTrace();
        }
    }


    //navigation--->
    public MainPage open(){
        driver.navigate().to(homeUrl);
        return this;
    }


    public AllCategoriesPage navigatetoCategoriesPage(){
        checkInfoPopUp();
        click(dropdownNavBarCatalog);
        click(linkNavBarCategories);
        return new AllCategoriesPage(driver);
    }
    //<---nav


    //Registration --->
    public MainPage registrationDefault(){
        checkInfoPopUp();
        click(linkRegistration);
        fillField(fieldRegNameFirst, "testname");
        fillField(fieldRegNameLast, "lastname");
        fillField(fieldRegEmail, email);
        fillField(fieldRegPass, password);
        fillField(fieldRegPassConfirm, password);
        if (driver.findElement(ckeckboxRegContractOffer).isSelected() == false){
            click(ckeckboxRegContractOffer);
        }
        click(buttonRegOffer);
        checkInfoPopUp();
        return this;
    }

    public MainPage registrationFacebook(){
        popUpCloseIfDisplayed(buttonCloseInfoPopUp);
        click(linkRegistration);
        click(buttonRegistrationFB);
        return this;
    }

    public MainPage registrationGoogle(){
        popUpCloseIfDisplayed(buttonCloseInfoPopUp);
        click(linkRegistration);
        click(buttonRegistrationGoogle);
        return this;
    }
    //<---- Registration//


    //Authorization--->>>
    public MainPage authorizationDefault(){
        popUpCloseIfDisplayed(buttonCloseInfoPopUp);
        click(linkLogIn);
        fillField(fieldLoginEmail, email);
        fillField(fieldLoginPass, password);
        click(buttonLogin);
        popUpCloseIfDisplayed(buttonCloseInfoPopUp);
        visibilityOf(textWelcome);
        return this;
    }

    public MainPage logOut(){
        checkInfoPopUp();
        click(linkLogOut);
        return this;
    }
    //<---Authorization

    //<Assertions--->>
    public MainPage assertTrueIsDisplayed(By by){
        Assert.assertTrue(driver.findElement(by).isDisplayed());
        return this;
    }

    public MainPage assertTrueIfSelected(By checkbox){
        Assert.assertTrue(driver.findElement(checkbox).isSelected());
        return this;
    }
    //<<---Assertions

    public MainPage clicknCartPopUp(){
        click(linkCartPopUp);
        return this;
    }

    public CartPage openCartPage(){
        click(linkCartPopUp);
        click(linkLookTheCart);
        return new CartPage(driver);
    }

    public CheckoutPage openCartGoToCheckout(){
        click(linkCartPopUp);
        click(buttonMakeOrderToCheckout);
        return new CheckoutPage(driver);
    }
}
