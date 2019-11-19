package ru.Test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class WebDriverSettings {
  public ChromeDriver driver;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chorome.driver", "/Users/tynu4ok/Downloads/chromedriver_win32/");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @After
  public void closeTest() {
    driver.quit();
    driver = null;
  }
}
