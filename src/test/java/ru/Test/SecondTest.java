package ru.Test;

import org.junit.Test;
import org.openqa.selenium.By;

public class SecondTest extends WebDriverSettings{
    @Test
    public void mainTest()  {

      driver.get("http://localhost/litecart/en/");

      String[] boxType = {"box-most-popular", "box-campaigns", "box-latest-products"};
      String location, name, stickerName;
      int itemsCount, stickerCount;

      for (String box : boxType) {
        System.out.println(box);
        location = ".//div[@class='middle']//div[@id='" + box + "']//li[@class]";
        itemsCount = driver.findElements(By.xpath(location)).size();
        if (itemsCount > 0) {
          for (int i = 1; i <= itemsCount; i++) {
            item = driver.findElement(By.xpath(location + "[" + i + "]"));
            stickerCount = item.findElements(By.xpath(".//div[@class='image-wrapper']/div[@title]")).size();
            name = item.findElement(By.xpath(".//div[@class='name']")).getText();
            if (stickerCount == 1) {
              stickerName = item.findElement(By.xpath(".//div[@title]")).getText();
              System.out.println("Имя - " + name + " Стикер - " + stickerName);
            }
            else if (stickerCount > 1)
              System.out.println("Ошибка - " + name + " похоже более одного стикера!");
            else
              System.out.println("Ошибка ? " + name + " нет стикера");
          }
        }
      }
    }
}