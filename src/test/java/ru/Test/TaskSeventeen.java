package ru.Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import java.util.List;

public class TaskSeventeen extends WebDriverSettings {
    @Test
    public void testLogs() {
        login();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        List<WebElement> duckList = driver.findElements(By.xpath("//a[contains(text(),'Duck')]"));
        for (int i = 1; i < duckList.size(); i++) {
            WebElement element = driver.findElements(By.xpath("//a[contains(text(),'Duck')]")).get(i);
            element.click();
            System.out.println("Проверяем следующий товар: " + driver.getTitle());

            List<LogEntry> log = driver.manage().logs().get("browser").getAll();
            if (log.size() > 0) {
                AssertionError assertError = new AssertionError("Ошибки присутствуют \n");
                System.out.println(assertError.getMessage() + "" + log);
                Assert.fail();
            }
            driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        }
    }
    public void login() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }
}
