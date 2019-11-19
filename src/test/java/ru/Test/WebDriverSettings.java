package ru.Test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverSettings {
  public ChromeDriver driver;
  public WebDriverWait wait;

  @Before
  public void setUp() {
    // Тут потом можно в переменную завести проперти и в какой-нить конф. файл, чтобы там был указан PATH драйвера, удобно когда можно передать jar файл + сам драйвер.
    System.setProperty("webdriver.chorome.driver", "/Users/tynu4ok/Downloads/chromedriver_win32/");
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver,20);
    driver.manage().window().maximize();
  }

  @After
  public void closeTest() {
    driver.quit();
    driver = null;
  }
}
