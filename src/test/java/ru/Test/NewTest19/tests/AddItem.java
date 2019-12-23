package ru.Test.NewTest19.tests;

import org.junit.Test;

public class AddItem extends WebDriverSettings {

    @Test
    public void mainTest()  {
        app.mainPage.open();
        for (int i = 1; i<=3; i++) {
            app.mainPage.chooseFirstItem();
            app.itemPage.addItemToCart();
            app.itemPage.goMainPage();
        }
        app.cartPage.open();
        app.cartPage.clearCart();
    }

}
