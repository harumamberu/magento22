package com.stockfactory.pageobject.interfaces;

import org.openqa.selenium.By;

public interface NavigationBar {
    int pi = 4;
    public By dropdownNavBarCatalog = By.xpath("//*[@class='navbar']//*[@class='dropdown-toggle']");
    public By linkNavBarCategories = By.xpath("//*[@class='navbar']//a[contains(@href, '/categories')]");
    public By linkNavBarElectronics = By.xpath("//*[@class='navbar']//*[contains(@href, '/elektronika')]");
    public By linkNavBarForBuyers = By.xpath("//*[@class='navbar']//a[contains(@href, '/agreement#2')]");
    public By linkNavBarForSellers = By.xpath("//*[@class='navbar']//a[contains(@href, '/for-sellers')]");
    public By linkNavBarCharity = By.xpath("//*[@class='navbar']//a[contains(@href, '/charity')]");
}
