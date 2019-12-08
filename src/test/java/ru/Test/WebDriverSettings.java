package ru.Test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class WebDriverSettings {
  public static ChromeDriver driver;
  public static WebDriverWait wait;

  //public InternetExplorerDriver driver;
  //public FirefoxDriver driver;

  public boolean areElementsPresent(By locator) {
    return driver.findElements(locator).size() > 0;
  }

  @Before
  public void setUp() {
    if (driver != null) {
      return;
  }
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver,10);
    driver.manage().window().maximize();
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {driver.quit();driver = null;}));
  }

    @After
  public void closeTest() {
  //  driver.quit();
  //  driver = null;
  }
}
