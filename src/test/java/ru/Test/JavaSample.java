package ru.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class JavaSample {

    public static final String USERNAME = "dmitriy477";
    public static final String AUTOMATE_KEY = "J5LVkgzLP6ECBSSsYQoo";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static void main(String[] args) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "internet explorer");
       // caps.setCapability("browser_version", "62.0");
       // caps.setCapability("os", "Windows");
       // caps.setCapability("os_version", "10");
       // caps.setCapability("resolution", "1920x1080");
       // caps.setCapability("name", "Bstack-[Java] Sample Test");

        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.109:4444/wd/hub"), caps);
        driver.get("http://www.google.com/ncr");
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("BrowserStack");
        element.submit();

        System.out.println(driver.getTitle());
        driver.quit();

    }
}