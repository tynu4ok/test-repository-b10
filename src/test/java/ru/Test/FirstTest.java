package ru.Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class FirstTest extends WebDriverSettings {
  @Test
  public void firstTest() {
    driver.get("https://www.yandex.ru/");
  }
}

