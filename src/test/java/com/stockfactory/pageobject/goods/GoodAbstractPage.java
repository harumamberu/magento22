package com.stockfactory.pageobject.goods;

import com.stockfactory.pageobject.MainPage;
import com.stockfactory.pageobject.categories.ElectronicsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoodAbstractPage extends MainPage {
    public GoodAbstractPage(WebDriver driver){
        super(driver);
    }

    private By tabReviews = By.id("tab-label-reviews-title");
    private By fieldReviewName = By.id("nickname_field");
    private By fieldReviewSummary = By.id("summary_field");
    private By fieldReviewText = By.id("review_field");
    private By buttonPostReview = By.xpath("//*[@class='review-form']//button[@type='submit']");
    private By messageSubmittedReviewForModeration = By.xpath("//*[@class='page messages']//*[contains(text(), 'You submitted your review for moderation')]");
    private By buttonAddToCart = By.id("product-addtocart-button");

    public GoodAbstractPage addReview(){
        checkInfoPopUp();
        click(tabReviews);
        fillField(fieldReviewName, "testnick" + dateFormat);
        fillField(fieldReviewSummary, "testsummary" + dateFormat);
        fillField(fieldReviewText, "some pros and cons" + dateFormat);
        click(buttonPostReview);
        return new GoodAbstractPage(driver);
    }

    public GoodAbstractPage assertReviewSubmittedForModeration(){
        checkInfoPopUp();
        Assert.assertTrue(driver.findElement(messageSubmittedReviewForModeration).isDisplayed());
        return this;
    }

    public ElectronicsPage pressButtonAddToCart(){
        click(buttonAddToCart);
        return new ElectronicsPage(driver);
    }
}
