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
        AssertionError assertError = new AssertionError();
        List<WebElement> list = driver.findElements(By.cssSelector("li.product"));

        for (int i = 0; i < list.size(); i++) {
            WebElement item = list.get(i);
            System.out.println("Проверяем элемент № " + (i + 1));
            // Если более одного класса sticker, выбрасываем ошибку
            if (!(item.findElements(By.cssSelector("div.sticker")).size() == 1 )) {
                System.out.println("Ошибка, стикеров более одного или вообще его нет, номер элемента - " + (i + 1) + " ." + assertError.getMessage());
                Assert.fail();
            }
        }
        System.out.println("Всё нормально, у всех есть стикеры.");
    }
}
