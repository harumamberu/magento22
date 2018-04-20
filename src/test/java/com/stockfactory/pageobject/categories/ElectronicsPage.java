package com.stockfactory.pageobject.categories;

import com.stockfactory.pageobject.MainPage;
import com.stockfactory.pageobject.goods.GoodAbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElectronicsPage extends MainPage{
    public ElectronicsPage(WebDriver driver) {super(driver);
    }

    //UNIVERSAL METHOD
    public ElectronicsPage selectFilterCheckbox(By checkbox){
        selectCheckbox(checkbox);
        return this;
    }

    private By buttonAddToCart = By.xpath("//*[@title='В кошик']");
    private By buttonToCartTheFirstGood = By.xpath("//button[@class='action primary']");
    private By filterCategoryType;
    private By filterPrice;
    public By checkboxPriceRange0to749 = By.id("aw-filter-option-price--750");
    private By checkboxPriceRange750to1499 = By.id("aw-filter-option-price-750-1500");
    private By checkboxPriceRange1500to2249 = By.id("aw-filter-option-price-1500-2250");
    private By checkboxPriceRange2250to2999 = By.id("aw-filter-option-price-2250-3000");
    private By checkboxPriceRange3000to3749 = By.id("aw-filter-option-price-3000-3750");
    private By checkboxPriceRange3750to4500;
    private By checkboxPriceRange4500to5249 = By.id("aw-filter-option-price-4500-5250");
    private By checkboxPriceRange5250to5999 = By.id("aw-filter-option-price-5250-6000");
    private By checkboxPriceRange6000to6749;
    private By checkboxPriceRange6750to7499;
    private By checkboxPriceRange7500to8249 = By.id("aw-filter-option-price-7500-8250");
    private By checkboxPriceRange8250to8999;
    private By checkboxPriceRange9000to9749;
    private By checkboxPriceRange9750to10500;
    private By checkboxPriceRange10500andOver = By.id("aw-filter-option-price-10500-");
    private By buttonShowByFilter = By.xpath("//*[@class='filter-options']//button[contains(@class, 'show-button')]");
    private By linkFirstGoodOnThePage = By.xpath("//a[@class='product-item-link']");


    //Filters checkbox--->
    public ElectronicsPage selectCheckboxPriceRange0to749() {
        selectCheckbox(checkboxPriceRange0to749);
        return this;
    }

    public ElectronicsPage selectCheckboxPriceRange750to1499() {
        selectCheckbox(checkboxPriceRange750to1499);
        return this;
    }

    public ElectronicsPage selectCheckboxPriceRange1500to2250() {
        selectCheckbox(checkboxPriceRange1500to2249);
        return this;
    }

    public ElectronicsPage selectCheckboxPriceRange2250to3000() {
        selectCheckbox(checkboxPriceRange2250to2999);
        return this;
    }

    public ElectronicsPage selectCheckboxPriceRange3000to3749() {
        selectCheckbox(checkboxPriceRange3000to3749);
        return this;
    }

    public ElectronicsPage selectCheckboxPriceRange4500to5249() {
        selectCheckbox(checkboxPriceRange4500to5249);
        return this;
    }

    public ElectronicsPage selectCheckboxPriceRange5250to5999() {
        selectCheckbox(checkboxPriceRange5250to5999);
        return this;
    }

    public ElectronicsPage selectCheckboxPriceRange10500andOver() {
        selectCheckbox(checkboxPriceRange10500andOver);
        return this;
    }

    public ElectronicsPage clickShowButton(){
        click(buttonShowByFilter);
        return new ElectronicsPage(driver);
    }
    //<--- filter checkbox




    private By checkboxConditionDamagedPackage = By.id("aw-filter-option-reason_for_stock-5");
    private By checkboxConditionMissingPackage = By.id("aw-filter-option-reason_for_stock-15");
    private By checkboxConditionNoDamage = By.id("aw-filter-option-reason_for_stock-19");
    public By checkboxConditionDiscount15Persent = By.id("aw-filter-option-reason_for_stock-20");

    public ElectronicsPage selectCheckboxConditionDamagedPackage() {
        selectCheckbox(checkboxConditionDamagedPackage);
        return this;
    }

    public ElectronicsPage selectCheckboxConditionMissingPackage() {
        selectCheckbox(checkboxConditionMissingPackage);
        return this;
    }

    public ElectronicsPage selectCheckboxConditionNoDamage() {
        selectCheckbox(checkboxConditionNoDamage);
        return this;
    }

    public ElectronicsPage selectCheckboxConditionDiscount15Persent() {
        selectCheckbox(checkboxConditionDiscount15Persent);
        return this;
    }

    private By filterOnSale;
    private By filterNew;
    private By filterAuction;
    private By checkboxAuctionYes;
    private By checkboxAuctionNo;

    //Assertions--->
    public ElectronicsPage assertSelectedCheckboxConditionDiscount15Persent(){
        Assert.assertTrue(driver.findElement(checkboxConditionDiscount15Persent).isSelected());
        return this;
    }

    public ElectronicsPage assertSelectedCheckboxPriceRange0to749(){
        Assert.assertTrue(driver.findElement(checkboxPriceRange0to749).isSelected());
        return this;
    }

    public ElectronicsPage assertSelectedCheckboxRange10500andOver(){
        Assert.assertTrue(driver.findElement(checkboxPriceRange10500andOver).isSelected());
        return this;
    }
    //<---Asserions

    //Goods--->
    public GoodAbstractPage navigateFirstGoodOnThePage(){
        click(linkFirstGoodOnThePage);
        return new GoodAbstractPage(driver);
    }

    public GoodAbstractPage pressButtonAddToCart(){
        click(buttonToCartTheFirstGood);
        return new GoodAbstractPage(driver);
    }
    //<---Goods
}
