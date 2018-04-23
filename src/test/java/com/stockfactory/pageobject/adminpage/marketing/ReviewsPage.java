package com.stockfactory.pageobject.adminpage.marketing;

import com.stockfactory.pageobject.adminpage.MenuAdminPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ReviewsPage extends MenuAdminPage{
    public ReviewsPage(WebDriver driver){
        super(driver);
    }

    //ACTIONS
    private By dropdownActions = By.xpath("//select[@id='reviwGrid_massaction-select']");
    private By dropdownActionsDelete = By.xpath("//option[@value='delete']");
    private By buttonSumbitAction = By.xpath("//*[@id='reviwGrid_massaction']//button[@title='Submit']");

    //GRID
    //filter
    private By fieldName = By.xpath("//input[@name='nickname']");
    private By dropdownMultiSelect = By.xpath("//*[@id='reviwGrid_massaction-mass-select']");
    private By dropdownMultiSelectAll = By.xpath("//option[@value='selectAll']");
    //output grid
    By checkboxReview = By.xpath("//*[@id='page:main-container']//input[@name='reviews']");
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@id='page:main-container']//input[@name='reviews']")
    })private List<WebElement> checkboxesReviews;

    public ReviewsPage searchByNickname(String nickname){
        fillField(fieldName, nickname);
        driver.findElement(fieldName).sendKeys(Keys.ENTER);
        return new ReviewsPage(driver);
    }

    public ReviewsPage selectAllReviews(){
        click(dropdownMultiSelect);
        click(dropdownMultiSelectAll);
        return new ReviewsPage(driver);
    }

    public ReviewsPage deleteSelectedReviews(){
        click(dropdownActions);
        click(dropdownActionsDelete);
        click(buttonSumbitAction);
        click(buttonOkActionPopUp);
        return new ReviewsPage(driver);
    }


}
