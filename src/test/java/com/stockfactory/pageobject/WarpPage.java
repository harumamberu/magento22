package com.stockfactory.pageobject;

import com.stockfactory.pageobject.adminpage.AdminLoginPage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.*;

public abstract class WarpPage{
    protected WebDriver driver;
    protected WebDriverWait wait;

    //GENERAL ELEMENTS
    public String homeUrl = "http://stage.stockproject.brsw.io/";
    public String adminUrl = "/admin";
    public By popUpInfoPopUp = By.xpath("//*[contains(@class,'info__modal')]");
    public By buttonCloseInfoPopUp = By.xpath("//*[contains(@class,'modal-inner-wrap')]//button[@class='action-close']");
    //public By buttonCloseInfoPopUp = By.xpath("//*[contains(@class,'info__modal')]//button[@class='action-close']");

    public WarpPage(WebDriver driver){this.driver = driver;}

    public AdminLoginPage openAdminLoginPage(){
        driver.navigate().to(homeUrl+adminUrl);
        return new AdminLoginPage(driver);
    }

    public void fillField(By by, String string){
        visibilityOf(by);
        clickableOf(by);
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(string);
    }

    public void click(By by){
        driver.findElement(by).isDisplayed();
        visibilityOf(by);
        clickableOf(by);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", driver.findElement(by));
    }

    public void visibilityOf(By locator){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public void invisibilityOf(By locator){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void clickableOf(By locator){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
    }

    public void selectCheckbox(By checkbox){
        if(driver.findElement(checkbox).isSelected() == false){
            clickableOf(checkbox);
            click(checkbox);
        }
        Assert.assertTrue(driver.findElement(checkbox).isSelected());
    }

    public static boolean isClickable(By by, WebDriver driver)
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    //POPUP -->
    // /driver.findElement(By.xpath("//*/div[@class='info-link-content']/../../*/button[@class='action-close']")).click();
    //*/div[@class='modal-inner-wrap']
    public void popUpCloseIfDisplayed(By by){
        if(driver.findElement(by).isDisplayed()){
            driver.findElement(by).click();
            //driver.findElement(By.xpath("//*")).sendKeys(Keys.ESCAPE);
        }
    }

    public void popUpOk(By by){
        if(driver.findElement(by).isDisplayed()){
            driver.findElement(by).click();
        }
    }

    public void popUpCancel(){
        if(driver.findElement(By.xpath("//*/div[@class='modal-inner-wrap']//*[contains(text(), 'Cancel')]")).isDisplayed()){
            driver.findElement(By.xpath("//*/div[@class='modal-inner-wrap']//*[contains(text(), 'Cancel')]")).click();
        }
    }
    //<-- POPUP
}
