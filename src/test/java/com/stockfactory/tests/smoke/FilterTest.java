package com.stockfactory.tests.smoke;

import com.stockfactory.tests.WarpTest;
import org.junit.Test;

public class FilterTest extends WarpTest {

    //@Test
    public void ElectronicsPageFilterByCategoryTypeTest(){

    }

    @Test
    public void ElecronicsPageFilterByConditionTest(){
        mainPage.navigatetoCategoriesPage()
                .navigatetoElectronicsPage()
                .selectCheckboxConditionDiscount15Persent()
                .clickShowButton()
                .assertSelectedCheckboxConditionDiscount15Persent();
    }

    @Test
    public void ElectronicsPageFilterByPriceRange0to749(){
        mainPage.navigatetoCategoriesPage()
                .navigatetoElectronicsPage()
                .selectCheckboxPriceRange0to749()
                .clickShowButton()
                .assertSelectedCheckboxPriceRange0to749();
    }

    @Test
    public void ElectronicsPageFilterByPriceRange10500andOver(){
        mainPage.navigatetoCategoriesPage()
                .navigatetoElectronicsPage()
                .selectCheckboxPriceRange10500andOver()
                .clickShowButton()
                .assertSelectedCheckboxRange10500andOver();
    }
}
