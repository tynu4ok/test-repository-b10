package ru.Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ThirdTestTwo extends WebDriverSettings {
    @Test
    public void thirdTestTwo()  {
        driver.get("http://localhost/litecart/en/");
        WebElement campaignsMainName = driver.findElement(By.cssSelector("#box-campaigns li"));

        WebElement mainName = campaignsMainName.findElement(By.cssSelector("div.name"));
        String mName = mainName.getAttribute("textContent");

        WebElement oldPriceMain = campaignsMainName.findElement(By.cssSelector("s"));
        String oldPrice = oldPriceMain.getAttribute("textContent");
        String oldPriceClass = oldPriceMain.getAttribute("class");

        WebElement newPriceMain = campaignsMainName.findElement(By.cssSelector("strong"));
        String newPrice = newPriceMain.getAttribute("textContent");
        String newPriceClass = newPriceMain.getAttribute("class");

        campaignsMainName.click();

        WebElement hName = driver.findElement(By.cssSelector("h1"));
        String nameProduct = hName.getAttribute("textContent");

        WebElement boxProduct = driver.findElement(By.cssSelector("div#box-product"));

        WebElement oldPriceProduct = boxProduct.findElement(By.cssSelector("s"));
        String oldPriceProd = oldPriceProduct.getAttribute("textContent");
        String oldPriceClassProduct = oldPriceProduct.getAttribute("class");

        WebElement newPriceProduct = boxProduct.findElement(By.cssSelector("strong.campaign-price"));
        String newPriceProd = newPriceProduct.getAttribute("textContent");
        String newPriceClassProduct = newPriceProduct.getAttribute("class");


        if (!(mName.equals(nameProduct)) ) {
            AssertionError assertError = new AssertionError();
            System.out.println("Ошибка: " + assertError.getMessage());
            System.out.println("Название с главной страницы ("+ mName +") отличается от названия с открытой в новой вкладке страницы ("+nameProduct+")" );
            Assert.fail();
        }
        System.out.println("Название с главной страницы ("+ mName +") не отличается от названия со страницы открытой ("+nameProduct+")" );

        if (!(oldPrice.equals(oldPriceProd)) ) {
            AssertionError assertError = new AssertionError();
            System.out.println("Ошибка: " + assertError.getMessage());
            System.out.println("Цена с главной страницы ("+ oldPrice +") отличается от цена с открытой в новой вкладке страницы ("+oldPriceProd+")" );
            Assert.fail();
        }
        System.out.println("Старая цена с главной страницы ("+ oldPrice +") аналогична цене в карточке товара ("+oldPriceProd+")" );

        if (!(oldPriceClass.equals(oldPriceClassProduct)) ) {
            AssertionError assertError = new AssertionError();
            System.out.println("Ошибка: " + assertError.getMessage());
            System.out.println("Класс старой цены ("+ oldPriceClass +") откличается от класса старой цены в карточке товара ("+oldPriceClassProduct+")" );
            Assert.fail();
        }
        System.out.println("Класс старой цены ("+ oldPriceClass +") аналоничен карточке товара ("+oldPriceClassProduct+")" );

        if (!(newPrice.equals(newPriceProd)) ) {
            AssertionError assertError = new AssertionError();
            System.out.println("Ошибка: " + assertError.getMessage());
            System.out.println("Текущая цена ("+ newPrice +") отличается от текущей цены в карточке товара ("+newPriceProd+")" );
            Assert.fail();
        }
        System.out.println("Текущая цена на главной странице("+ newPrice +") аналогична текущей цены в карточке товара ("+newPriceProd+")" );

        if (!(newPriceClass.equals(newPriceClassProduct)) ) {
            AssertionError assertError = new AssertionError();
            System.out.println("Ошибка: " + assertError.getMessage());
            System.out.println("Класс новой цены на главной странице ("+ newPriceClass +") отличается от класса в карточке товара ("+newPriceClassProduct+")" );
            Assert.fail();
        }
        System.out.println("Класс новой цены на главной странице ("+ newPriceClass +") аналогичен классу в карточке товара ("+newPriceClassProduct+")" );
    }
}
