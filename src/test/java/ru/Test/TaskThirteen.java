package ru.Test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;




public class TaskThirteen extends WebDriverSettings {
    @Test
    public void taskThirteenTest() {
        driver.get("http://localhost/litecart/en/");
        WebElement link = driver.findElement(By.cssSelector("#box-account-login a"));
        link.click();

        driver.navigate().refresh();
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.name("tax_id")));

        WebElement nameTax = driver.findElement(By.name("tax_id"));
        nameTax.sendKeys("myTaxiD");

        WebElement company = driver.findElement(By.name("company"));
        company.sendKeys("myRealCompany");

        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Di");

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("FullRegrets");

        WebElement address1 = driver.findElement(By.name("address1"));
        address1.sendKeys("myFirstAddress");

        WebElement address2 = driver.findElement(By.name("address2"));
        address2.sendKeys("mySecondAddress");

        WebElement postcode = driver.findElement(By.name("postcode"));
        postcode.sendKeys("12345");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("LA");

        WebElement country = driver.findElement(By.cssSelector("span.selection"));

        Actions actions = new Actions(driver);
        actions.moveToElement(country);
        actions.click();
        actions.sendKeys("United States");
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();

        Select gender = new Select(driver.findElement(By.cssSelector("select[name=zone_code]")));
        gender.selectByValue("CA");

        int max = 10000;
        int marx = (int) (Math.random() * max);
        String knox = marx + "s@email.ru";
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(knox);

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("111111111");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("test12345");

        WebElement confPassword = driver.findElement(By.name("confirmed_password"));
        confPassword.sendKeys("test12345");

        WebElement createAcc = driver.findElement(By.name("create_account"));
        createAcc.click();

        logout();
        login(knox);

    }

    private void logout() {
        driver.navigate().refresh();
        WebElement exit = driver.findElement(By.cssSelector("div#box-account a[href*=logout]"));
        exit.click();
    }
    private void login(String knox){
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(knox);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("test12345");

        WebElement login = driver.findElement(By.name("login"));
        login.click();
    }
}
