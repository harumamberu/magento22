package com.stockfactory.pageobject.adminpage;

import com.stockfactory.pageobject.WarpPage;
import com.stockfactory.pageobject.adminpage.customers.CustomersAllPage;
import com.stockfactory.pageobject.adminpage.customers.CustomersOnlinePage;
import com.stockfactory.pageobject.adminpage.marketing.ReviewsPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuAdminPage extends WarpPage{
    public MenuAdminPage(WebDriver driver){super(driver);}
    //

    //Menu customers
    public By customersMenu = By.xpath("//li[@id='menu-magento-customer-customer']/*/span[contains(text(), 'Customers')]/..");
    public By customersAll = By.xpath("//*/li[@id='menu-magento-customer-customer']//*/span[contains(text(), 'All Customers')]");
    public By customersOnline = By.xpath("//*/li[@id='menu-magento-customer-customer']//*/span[contains(text(), 'Online')]");
    public By helpDeskMX = By.xpath("//*/li[@id='menu-magento-customer-customer']//*/span[contains(text(), 'Help Desk')]");

    //Menu merketing
    public By marketingMenu = By.xpath("//li[@id='menu-magento-backend-marketing']/*/span[contains(text(), 'Marketing')]/..");
    public By marketingReviews = By.xpath("//*[@id='menu-magento-backend-marketing']//*[contains(text(), 'Reviews')]/..");

    //
    public By spinner = By.className("admin__data-grid-loading-mask");

    //ActionsList
    public By buttonCloseActionPopUp = By.xpath("//*/div[@class='modal-inner-wrap']/*/button[@class='action-close']')]");
    public By buttonOkActionPopUp = By.xpath("//*/div[@class='modal-inner-wrap']//*[contains(text(), 'OK')]");

    public void checkPopUp(){
        if(isClickable(buttonCloseInfoPopUp, driver)){
            click(buttonCloseInfoPopUp);
        }
    }

    public CustomersAllPage navigateToCustomersAllPage(){
        checkPopUp();
        click(customersMenu);
        click(customersAll);
        return new CustomersAllPage(driver);
    }

    public CustomersOnlinePage navigateToCustomersOnlinePage(){
        click(customersMenu);
        return new CustomersOnlinePage(driver);
    }

    public ReviewsPage navigateToReviewsPage(){
        click(marketingReviews);
        return new ReviewsPage(driver);
    }

}
