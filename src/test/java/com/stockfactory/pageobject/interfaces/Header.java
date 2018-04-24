package com.stockfactory.pageobject.interfaces;

import org.openqa.selenium.By;

public interface Header{
    int pi = 3;
    public By linkRegistration = By.className("register-link");
    public By linkLogIn = By.xpath("//a[contains(text(), 'Увійти') and contains(@href, 'open()')]");
    public By linkLogOut = By.xpath("//a[contains(@href, '/logout') and contains(text(), 'Вийти')]");
    public By textWelcome = By.xpath("//*[contains(text(), 'Раді бачити')]");

    //REGISTRATION
    public By fieldRegNameFirst = By.id("socialogin.firstname");
    By fieldRegNameLast = By.id("socialogin.lastname");
    By fieldRegEmail = By.id("socialogin.email");
    By fieldRegPass = By.id("socialogin.pass");
    By fieldRegPassConfirm = By.id("socialogin.pass.confirm");
    By ckeckboxRegContractOffer = By.id("socialogin.oferta");
    By buttonRegOffer = By.id("magestore-button-sociallogin-create");
    By buttonRegistrationFB = By.id("bt-loginfb");
    By buttonRegistrationGoogle = By.id("bt-logingo");

    //AUTHORIZATION
    public By fieldLoginEmail = By.xpath("//*[@id='magestore-sociallogin-popup-email']");
    public By fieldLoginPass = By.id("magestore-sociallogin-popup-pass");
    public By buttonLogin = By.xpath("//button[@title='Login']");

    By linkCartPopUp = By.xpath("//*[@class='action showcart']");
    By linkLookTheCart = By.xpath("//*[@class='action viewcart']");
    By buttonMakeOrderToCheckout = By.id("top-cart-btn-checkout");
}
