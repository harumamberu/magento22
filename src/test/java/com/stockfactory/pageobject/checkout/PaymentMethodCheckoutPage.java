package com.stockfactory.pageobject.checkout;

import com.stockfactory.pageobject.WarpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentMethodCheckoutPage extends WarpPage{
    PaymentMethodCheckoutPage(WebDriver driver){
        super(driver);
    }

    By buttonCheckout = By.xpath("//*[@class='action primary checkout']");

    public void clickCheckout(){
        click(buttonCheckout);
    }
}
