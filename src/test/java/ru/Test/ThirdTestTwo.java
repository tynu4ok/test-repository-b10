package ru.Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

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
        String oldPriceMainDecor = oldPriceMain.getCssValue("text-decoration");
        String oldPriceMainColor = oldPriceMain.getCssValue("color");
        String oldPriceMainSize = oldPriceMain.getCssValue("font-size");

        WebElement newPriceMain = campaignsMainName.findElement(By.cssSelector("strong"));
        String newPrice = newPriceMain.getAttribute("textContent");
        String newPriceClass = newPriceMain.getAttribute("class");
        String newPriceMainSize = newPriceMain.getCssValue("font-size");
        String newPriceMainColor = newPriceMain.getCssValue("color");

        campaignsMainName.click();

        WebElement hName = driver.findElement(By.cssSelector("h1"));
        String nameProduct = hName.getAttribute("textContent");

        WebElement boxProduct = driver.findElement(By.cssSelector("div#box-product"));

        WebElement oldPriceProduct = boxProduct.findElement(By.cssSelector("s"));
        String oldPriceProd = oldPriceProduct.getAttribute("textContent");
        String oldPriceClassProduct = oldPriceProduct.getAttribute("class");
        String oldPriceProductDecor = oldPriceProduct.getCssValue("text-decoration");
        String oldPriceProductColor = oldPriceProduct.getCssValue("color");
        String oldPriceProductSize = oldPriceProduct.getCssValue("font-size");

        WebElement newPriceProduct = boxProduct.findElement(By.cssSelector("strong.campaign-price"));
        String newPriceProd = newPriceProduct.getAttribute("textContent");
        String newPriceClassProduct = newPriceProduct.getAttribute("class");
        String newPriceProductSize = newPriceProduct.getCssValue("font-size");
        String newPriceProductColor = newPriceProduct.getCssValue("color");


        if (!(mName.equals(nameProduct)) ) {
            AssertionError assertError = new AssertionError();
            System.out.println("Ошибка: " + assertError.getMessage());
            System.out.println("Название с главной страницы ("+ mName +") отличается от названия с открытой в новой вкладке страницы ("+nameProduct+")" );
            Assert.fail();
        }
        System.out.println("Название с главной страницы ("+ mName +") не отличается от названия со страницы карточки товара ("+nameProduct+")" );

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


        System.out.println("Старая цена на главной странице(text decoration): " + oldPriceMainDecor);
        System.out.println("Старая цена в карточке товара(text decoration): " + oldPriceProductDecor);

        System.out.println("Старая цена в карточке товара(color): " + oldPriceMainColor);
        System.out.println("Старая цена в карточке товара(color): " + oldPriceProductColor);

        String result1;
        if (newPriceMainSize.compareTo(oldPriceMainSize) > 0)
            result1 = "больше";
        else
            result1 = "меньше";
        System.out.println("Акционная цена на главной странице " + result1 + " чем старая цена.");

        String result2;
        if (newPriceProductSize.compareTo(oldPriceProductSize) > 0)
            result2 = "больше";
        else
            result2 = "меньше";
        System.out.println("Акционная цена в карточке товара " + result2 + " чем старая цена.");

        // ########################################################################################## Вариант №1 Сделал только для Варианта ответа на в)
        String hexMain = Color.fromString(oldPriceMainColor).asHex();
        String oldPriceMainColorHex = "#777777"; // Hex представление RGB - 119, 119, 119
        if(!(hexMain.equals(oldPriceMainColorHex))){
            AssertionError assertError = new AssertionError();
            System.out.println("Ошибка: " + assertError.getMessage());
            System.out.println("Цвет серой цены не корректен." );
            Assert.fail();
        }
        System.out.println("Цвет серой цены на главной странице правильный !");

        String hexProduct = Color.fromString(oldPriceProductColor).asHex();
        String oldPriceProductColorHex = "#666666"; // Hex представление RGB - 102, 102, 102
        if(!(hexProduct.equals(oldPriceProductColorHex))){
            AssertionError assertError = new AssertionError();
            System.out.println("Ошибка: " + assertError.getMessage());
            System.out.println("Цвет серой цены не корректен." );
            Assert.fail();
        }
        System.out.println("Цвет серой цены в карточке товара правильный !");


        // ########################################################################################## Вариант №2 Сделал на вариант ответа в) и г)
        String[] numbersMain = oldPriceMainColor.replace("rgba(", "").replace(")", "").split(",");
        int a = Integer.parseInt(numbersMain[0].trim());
        int b = Integer.parseInt(numbersMain[1].trim());
        int c = Integer.parseInt(numbersMain[2].trim());
        if(!( (a == b) && (a == c) )){
            AssertionError assertError = new AssertionError();
            System.out.println("Ошибка: " + assertError.getMessage());
            System.out.println("Цвет на главной странице не серый." );
            Assert.fail();
        }
        System.out.println("Red: " + a + " Green: " + b + " Blue: " + c + " - Одинаковы !");

        String[] numbersProd = oldPriceProductColor.replace("rgba(", "").replace(")", "").split(",");
        int d = Integer.parseInt(numbersProd[0].trim());
        int e = Integer.parseInt(numbersProd[1].trim());
        int f = Integer.parseInt(numbersProd[2].trim());
        if(!( (d == e) && (d == f) )){
            AssertionError assertError = new AssertionError();
            System.out.println("Ошибка: " + assertError.getMessage());
            System.out.println("Цвет в карточке товара не серый." );
            Assert.fail();
        }
        System.out.println("Red: " + d + " Green: " + e + " Blue: " + f + " - Одинаковы !");
        
        String[] numbersMainRed = newPriceMainColor.replace("rgba(", "").replace(")", "").split(",");
        int b2 = Integer.parseInt(numbersMainRed[1].trim());
        int c3 = Integer.parseInt(numbersMainRed[2].trim());
        if(!((b2 == 0) && (c3 == 0))){
            AssertionError assertError = new AssertionError();
            System.out.println("Ошибка: " + assertError.getMessage());
            System.out.println("Цвет на главной странице не красный." );
            Assert.fail();
        }
        System.out.println("Green: " + b2 + " Blue: " + c3 + " - Одинаковы!");

        String[] numbersProdRed = newPriceProductColor.replace("rgba(", "").replace(")", "").split(",");
        int e2 = Integer.parseInt(numbersProdRed[1].trim());
        int f3 = Integer.parseInt(numbersProdRed[2].trim());
        if(!((e2 == 0) && (f3 == 0) )){
            AssertionError assertError = new AssertionError();
            System.out.println("Ошибка: " + assertError.getMessage());
            System.out.println("Цвет в карточке товара не красный." );
            Assert.fail();
        }
        System.out.println("Green: " + e2 + " Blue: " + f3 + " - Одинаковы !");



    }
}
