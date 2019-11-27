package ru.Test;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;



public class FirstTest extends WebDriverSettings {
  @Test
  public void firstTest() throws InterruptedException {
    driver.get("http://localhost/litecart/admin/");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();

    int numberOfListElements =  driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).size();
    int docN;
    String namePage;

    WebElement row, lk;
    for (int i=1; i<=numberOfListElements; i++)  {
      lk = refreshPage(driver, i);
      namePage = lk.findElement(By.xpath(".//span[@class='name']")).getText();
      lk.click();
      lk = refreshPage(driver, i);
      docN = lk.findElements(By.xpath("./ul[@class='docs']/li[@id]")).size();
      if (docN > 0) {
        for (int j=1; j<=docN; j++) {
          lk = refreshPage(driver, i);
          row = lk.findElement(By.xpath("./ul[@class='docs']/li[@id][" + j + "]"));
          namePage = row.findElement(By.xpath(".//span[@class='name']")).getText();
          row.click();
          checkH1(driver, namePage);
          Thread.sleep(250);
        }
      }
      else {
        checkH1(driver, namePage);
      }
      Thread.sleep(500);
    }
  }

  private void checkH1(WebDriver web, String pageName){
    String h1;
    String result = "Страница" + pageName;
    if ( isElementPresent(web, By.xpath(".//td[@id='content']/h1")) ) {
      h1 = web.findElement(By.xpath(".//td[@id='content']/h1")).getText();
      result = result + " is " + h1;
    }
    else
      result = result + " not";
    System.out.println(result);
  }

  private WebElement refreshPage(WebDriver web, int i){
    WebElement row = web.findElement(By.id("box-apps-menu"));
    WebElement link = row.findElement(By.xpath("./li[@id='app-'][" + i + "]"));
    return link;
  }

  boolean isElementPresent(WebDriver driver, By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}

