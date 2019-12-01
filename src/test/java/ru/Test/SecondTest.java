package ru.Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SecondTest extends WebDriverSettings {
    @Test
    public void secondTest() {

        driver.get("http://localhost/litecart/en/");

        List<WebElement> list = driver.findElements(By.cssSelector("li.product"));

        for (int i = 0; i < list.size(); i++) {
            WebElement item = list.get(i);
            System.out.println("Проверяем элемент № " + i);
            if (!(item.findElements(By.cssSelector("div[class='sticker sale']")).size() > 0 || item.findElements(By.cssSelector("div[class='sticker new']")).size() > 0)) {
                AssertionError assertError = new AssertionError();
                System.out.println("Ошибка, стикеров более одного или вообще его нет, номер элемента - " + i + " ." + assertError.getMessage());
                Assert.fail();
            }
        }
        System.out.println("Всё нормально, у всех есть стикеры.");
    }
}
