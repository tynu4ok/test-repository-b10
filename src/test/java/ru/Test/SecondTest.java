package ru.Test;

import org.junit.Test;
import org.openqa.selenium.By;

public class SecondTest extends WebDriverSettings{
    @Test
    public void mainTest()  {

      driver.get("http://localhost/litecart/en/");

      String[] boxType = {"box-most-popular", "box-campaigns", "box-latest-products"};
      String locator, itemName, stickerName;
      int itemsCount, stickerCount;

      for (String box : boxType) {
        System.out.println("*** " + box + " ***");
        locator = ".//div[@class='middle']//div[@id='" + box + "']//li[@class]";
        itemsCount = driver.findElements(By.xpath(locator)).size();
        if (itemsCount > 0) {
          for (int i = 1; i <= itemsCount; i++) {
            item = driver.findElement(By.xpath(locator + "[" + i + "]"));
            stickerCount = item.findElements(By.xpath(".//div[@class='image-wrapper']/div[@title]")).size();
            itemName = item.findElement(By.xpath(".//div[@class='name']")).getText();
            if (stickerCount == 1) {
              stickerName = item.findElement(By.xpath(".//div[@title]")).getText();
              System.out.println("*** ALL RIGHT!!! The item " + itemName + " has sticker " + stickerName.toUpperCase());
            }
            else if (stickerCount > 1)
              System.out.println("*** ERROR!!! The item " + itemName + " has MORE than one sticker");
            else
              System.out.println("*** ERROR!!! The item " + itemName + " WITHOUT sticker");
          }
        }
      }
    }
}