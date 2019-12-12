package ru.Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class TaskBasket extends WebDriverSettings {
    @Test
    public void taskBasketTest() {
        driver.get("http://localhost/litecart/en/");
        wait.until(titleIs("Online Store | My Store"));

        for (int i = 1; i <= 3; i++) {
            addItem();
            driver.findElement(By.id("logotype-wrapper")).click();
        }
        driver.findElement(By.cssSelector("div#cart a.link")).click();
        clear();
    }

    boolean isElementNotPresent(By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return driver.findElements(locator).size() == 0;
        } finally {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    private void addItem() {
        WebElement quantity = driver.findElement(By.cssSelector("div#cart span.quantity"));
        By locator = By.cssSelector("div#cart span.quantity");
        String itemCount = quantity.getText();
        Integer next = Integer.parseInt(itemCount) + 1;
        itemCount = next.toString();
        WebElement name = driver.findElement(By.cssSelector("div.content div.name"));
        name.click();

        if (!(isElementNotPresent(By.xpath("//strong[text()=\"Size\"]")))) {
            Select category = new Select(driver.findElementByName("options[Size]"));
            category.selectByValue("Small");
        }

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebElement addProduct = driver.findElement(By.name("add_cart_product"));
        addProduct.click();

        wait.until(ExpectedConditions.textToBe(locator, itemCount));
        quantity = driver.findElement(locator);
        Assert.assertTrue(quantity.getText().equals(itemCount));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void clear() {
        int count = driver.findElements(By.cssSelector("li.shortcut")).size();
        for (int i = count; i > 1; i--) {
            WebElement li = driver.findElement(By.cssSelector("li.shortcut"));
            li.click();

            WebElement remove = driver.findElement(By.name("remove_cart_item"));
            remove.click();

            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("table.dataTable td.item"), i));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        WebElement rem = driver.findElement(By.name("remove_cart_item"));
        rem.click();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("table.dataTable"))));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
