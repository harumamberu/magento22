package com.stockfactory.pageobject.checkout;

import com.stockfactory.pageobject.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends MainPage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By fieldEmail = By.xpath("//*[@id='checkout-step-shipping']//input[@type='email']");
    By fieldName = By.xpath("//*[@id='checkout-step-shipping']//input[@name='firstname']");
    By fieldSurname = By.xpath("//*[@id='checkout-step-shipping']//input[@name='lastname']");
    By fieldPhone = By.xpath("//*[@id='checkout-step-shipping']//input[@name='telephone']");
    By buttonContinue = By.xpath("data-role='opc-continue'");

    public CheckoutPage fillFields(){
        fillField(fieldEmail, "");
        fillField(fieldName, "");
        fillField(fieldSurname, "");
        fillField(fieldPhone, "12345678");
        return this;
    }

    public PaymentMethodCheckoutPage clickContiniue(){
        click(buttonContinue);
        return new PaymentMethodCheckoutPage(driver);
    }
}
