package ru.Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTest extends WebDriverSettings {
  @Test
  public void firstTest() throws InterruptedException {
    driver.get("http://localhost/litecart/admin/");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
    wait.until(titleIs("My Store"));

    //WebElement finder = driver.findElementByCssSelector("ul#box-apps-menu");

    List<WebElement> elements = driver.findElements(By.cssSelector("#box-apps-menu a"));

    int numberOfListElements = elements.size();
    System.out.println(numberOfListElements);
    for (int i = 0; i < numberOfListElements; i++) {
      elements = driver.findElements(By.xpath("//a[contains(@href, '?app=')]"));
      Thread.sleep(1000);
      elements.get(i).click();
    }

  }
  public void secondTest(){

  }
}

