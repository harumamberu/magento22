package com.stockfactory.pageobject.adminpage;

import com.stockfactory.pageobject.WarpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage extends WarpPage{
    private By fieldUser = By.id("username");
    private By fieldPass = By.id("login");
    private By buttonLogin = By.className("action-login");

    public AdminLoginPage(WebDriver driver){super(driver);}

    public MenuAdminPage loginAs(String adminName, String adminPass){
        fillField(fieldUser, adminName);
        fillField(fieldPass, adminPass);
        return new MenuAdminPage(driver);
    }

    public MenuAdminPage loginAs(){
        fillField(fieldUser, "admin");
        fillField(fieldPass, "admin123");
        click(buttonLogin);
        return new MenuAdminPage(driver);
    }
}
