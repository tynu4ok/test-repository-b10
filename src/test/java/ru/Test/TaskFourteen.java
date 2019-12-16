package ru.Test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TaskFourteen extends WebDriverSettings {
    @Test
    public void linkTest() {
        login();

        driver.navigate().refresh();
        WebElement country = driver.findElementByXPath("//span[text()=\"Countries\"]");
        country.click();

        WebElement addNewCountry = driver.findElementByCssSelector("a.button");
        addNewCountry.click();

        testWindow();
    }

    public void testWindow(){
        String newWindow;
        String mainWindow = driver.getWindowHandle();

        Set<String> oldWindows = driver.getWindowHandles();

        List<WebElement> list = driver.findElements(By.cssSelector("i.fa-external-link"));
        for (WebElement element:list) {
            element.click();
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            newWindow = wait.until(thereIsWindowOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
            String title = driver.getTitle();
            if (title.contains("Wikipedia"))
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
            else
                list();
                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#acct_btn")));

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }

    public void list(){
        WebElement sd = driver.findElementByCssSelector("button.nab_closebtn");
        sd.click();
    }

    public void login(){
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    public ExpectedCondition<String> thereIsWindowOtherThan (Set<String> oldWindows) {
        return drive -> {
            Set<String> handles = drive.getWindowHandles();
            handles.removeAll(oldWindows);
            return handles.size() > 0 ? handles.iterator().next() : null;
        };
    }
}
