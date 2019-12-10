package ru.Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TaskTwelve extends WebDriverSettings {
    @Test
    public void taskTwelvetest() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        login();
        driver.navigate().refresh();

        WebElement nCatalog = driver.findElementByXPath("//span[@class=\"name\" and text()=\"Catalog\"]");
        nCatalog.click();

        driver.navigate().refresh();
        WebElement addNewProductButton = driver.findElementByXPath("//a[@class=\"button\" and text()=\" Add New Product\"]");
        addNewProductButton.click();

        String name = "Tovar";
        addNewProduct(name);
      


    }

    public void addNewProduct(String name) throws InterruptedException {
        WebElement general = driver.findElementByCssSelector("a[href='#tab-general']");
        general.click();

        Thread.sleep(1000);
        WebElement status = driver.findElementByCssSelector("input[type=radio][value='1']");
        status.click();


        WebElement nameEn = driver.findElementByName("name[en]");
        nameEn.clear();
        nameEn.sendKeys(name);

        WebElement code = driver.findElementByName("code");
        code.clear();
        code.sendKeys("123123");

        WebElement categories = driver.findElementByCssSelector("input[type=checkbox][value='1']");
        categories.click();

        WebElement gender = driver.findElementByCssSelector("input[type=checkbox][value='1-3']");
        gender.click();

        Select category = new Select(driver.findElementByName("default_category_id"));
        category.selectByValue("1");

        WebElement quantity = driver.findElementByName("quantity");
        quantity.clear();
        quantity.sendKeys("10");

        String current = System.getProperty("user.dir");
        System.out.println("Current working directory in Java : " + current);

        WebElement upload = driver.findElementByName("new_images[]");
        upload.sendKeys(current + "\\lonelyduck.jpg");

        WebElement dateValidFrom = driver.findElementByName("date_valid_from");
        dateValidFrom.clear();
        dateValidFrom.sendKeys("04.02.2003");

        WebElement dateValidTo = driver.findElementByName("date_valid_to");
        dateValidTo.clear();
        dateValidTo.sendKeys("10.12.2020");

        WebElement information = driver.findElementByCssSelector("a[href='#tab-information']");
        information.click();

        Select manufacturer = new Select(driver.findElementByName("manufacturer_id"));
        manufacturer.selectByValue("1");

        WebElement keywords = driver.findElementByName("keywords");
        keywords.clear();
        keywords.sendKeys("Keywords");

        WebElement shortDesc = driver.findElementByName("short_description[en]");
        shortDesc.clear();
        shortDesc.sendKeys("Description");

        WebElement desc = driver.findElementByCssSelector("div.trumbowyg-editor");
        desc.clear();
        desc.sendKeys("Test text Odin 103");

        WebElement headTitle = driver.findElementByName("head_title[en]");
        headTitle.clear();
        headTitle.sendKeys("Title Head");

        WebElement meta = driver.findElementByName("meta_description[en]");
        meta.clear();
        meta.sendKeys("Meta Description");

        WebElement prices = driver.findElementByCssSelector("a[href='#tab-prices']");
        prices.click();

        WebElement purchasePrice = driver.findElementByName("purchase_price");
        purchasePrice.clear();
        purchasePrice.sendKeys("1005");

        Select currencyCode = new Select(driver.findElementByName("purchase_price_currency_code"));
        currencyCode.selectByValue("USD");

        WebElement priceUsd = driver.findElementByName("prices[USD]");
        priceUsd.clear();
        priceUsd.sendKeys("100");

        WebElement priceEur = driver.findElementByName("prices[EUR]");
        priceEur.clear();
        priceEur.sendKeys("150");

        WebElement save = driver.findElementByName("save");
        save.click();

        WebElement newProduct = driver.findElementByXPath("//a[text()=" + "\"" + name + "\"]");
        String product = newProduct.getText();
        if (!(product.equals(name)) ) {
            AssertionError assertError = new AssertionError();
            System.out.println("Ошибка: " + assertError.getMessage());
            System.out.println("Название ("+ product +") отличается от ожидаемого названия ("+name+")" );
            Assert.fail();
        }
        System.out.println("Название ("+ product +") не отличается от ожидаемого названия ("+name+"), а значит всё ок." );

    }

    public void login() {
        WebElement userName = driver.findElementByName("username");
        userName.clear();
        userName.sendKeys("admin");

        WebElement passWord = driver.findElementByName("password");
        passWord.clear();
        passWord.sendKeys("admin");

        WebElement login = driver.findElementByName("login");
        login.click();
    }
}
