package com.stockfactory.pageobject.adminpage.marketing;

import com.stockfactory.pageobject.adminpage.MenuAdminPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ReviewsPage extends MenuAdminPage{
    public ReviewsPage(WebDriver driver){
        super(driver);
    }

    By fieldName = By.xpath("//input[@name='nickname']");

    public ReviewsPage searchByNickname(String nickname){
        fillField(fieldName, nickname);
        driver.findElement(fieldName).sendKeys(Keys.ENTER);
        return new ReviewsPage(driver);
    }
}
