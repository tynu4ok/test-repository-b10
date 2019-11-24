package ru.Test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverSettings {
  //public static ChromeDriver driver;
  public static WebDriverWait wait;
  //public InternetExplorerDriver driver;
  public FirefoxDriver driver;


  @Before
  public void setUp() {
    if (driver != null) {
      return;
  }
        // Тут потом можно в переменную завести проперти и в какой-нить конф. файл, чтобы там был указан PATH драйвера, удобно когда можно передать jar файл + сам драйвер.
    // System.setProperty("webdriver.chorome.driver", "C:/Tools/seleniumDrivers/chromedriver.exe");
    System.setProperty("webdriver.gecko.driver","C:/Tools/seleniumDrivers/geckodriver.exe");
    // System.setProperty("webdriver.ie.driver","C:/Tools/seleniumDrivers/IEDriverServer.exe");
    //driver = new ChromeDriver();
    /*
    ChromeOptions options = new ChromeOptions();
    options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
    options.addArguments("start-maximized");
    WebDriver driver = new ChromeDriver(options);
    */
   // ChromeOptions options = new ChromeOptions();
   // options.addArguments("start-fullscreen");
    //DesiredCapabilities caps = new DesiredCapabilities();
    //caps.setCapability(ChromeOptions.CAPABILITY, options);
    //System.out.println(((HasCapabilities) driver).getCapabilities());
    driver = new FirefoxDriver();
    wait = new WebDriverWait(driver,20);
    driver.manage().window().maximize();

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {driver.quit();driver = null;}));
  }

  @After
  public void closeTest() {
  //  driver.quit();
  //  driver = null;
  }
}
