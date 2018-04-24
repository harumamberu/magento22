package com.stockfactory.pageobject.categories;

import com.stockfactory.pageobject.MainPage;
import com.stockfactory.pageobject.interfaces.Header;
import com.stockfactory.pageobject.interfaces.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllCategoriesPage extends MainPage implements Header, NavigationBar{
    public AllCategoriesPage(WebDriver driver){
        super(driver);
    }

    private By buttonElectronis = By.xpath("//*[@class='categories-title']//a[contains(@href, 'elektronika')]");
    private By buttonFood = By.xpath("//*[@class='categories-title']//a[contains(@href, '/produkti-harchuvannja-ta-sil-s-ke-gospodarstvo')]");
    private By linkAfterButtonElectronics = By.xpath("//*[@class='categories-list-level-1']//*[contains(@href, '/elektronika')]");
    private By linkAfterButtonFood = By.xpath("//*[@class='categories-list-level-1']//*[contains(@href, '/produkti-harchuvannja-ta-sil-s-ke-gospodarstvo')]");


    public ElectronicsPage  navigatetoElectronicsPage(){
        popUpCloseIfDisplayed(buttonCloseInfoPopUp);
        click(buttonElectronis);
        click(linkAfterButtonElectronics);
        return new ElectronicsPage(driver);
    }

    public FoodPage navigatetoFoodPage(){
        click(buttonFood);
        click(linkAfterButtonFood);
        return new FoodPage(driver);
    }

}
