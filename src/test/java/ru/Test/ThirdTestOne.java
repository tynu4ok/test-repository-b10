package ru.Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ThirdTestOne extends WebDriverSettings{
    @Test
    public void thirdTestOne() {

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        String previousCountryName = null;

        List<WebElement> country = driver.findElements(By.cssSelector("table.dataTable tr.row"));
        for (int i = 0; i < country.size(); i++) {
            String countryName = country.get(i).findElements(By.cssSelector("td")).get(4).findElement((By.cssSelector("a"))).getText();
            if (previousCountryName!=null && !(countryName.compareToIgnoreCase(previousCountryName) > 0)) {
                AssertionError assertError = new AssertionError("Не в алфавитном порядке !!!!");
                System.out.println("Ошибка: " + previousCountryName+ " "+ countryName+" "+assertError.getMessage());
                Assert.fail();
            }
            previousCountryName = countryName;
            System.out.println(countryName);

            String countryZone = country.get(i).findElements(By.cssSelector("td")).get(5).getText();
            if (!countryZone.equals("0")){
                System.out.println("Найдены "+countryName+" с "+countryZone+" зонами");
                WebElement countryLink = country.get(i).findElements(By.cssSelector("td")).get(4).findElement((By.cssSelector("a")));
                countryLink.click();

                String previousZone = null;
                List<WebElement> zones = driver.findElements(By.cssSelector("table#table-zones tr"));
                for (int j = 1; j < zones.size()-1; j++) {
                    String zone = zones.get(j).findElements(By.cssSelector("td")).get(2).getText();
                    if (previousZone!=null && !(zone.compareToIgnoreCase(previousZone) > 0)) {
                        AssertionError assertError = new AssertionError("Не в алфавитном порядке.");
                        System.out.println("Ошибка:" + previousZone+ " "+ zone+" "+assertError.getMessage());
                        Assert.fail();
                    }
                    previousZone = zone;
                }
                System.out.println(countryName +" в алфавитном порядке.");

                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
                country = driver.findElements(By.cssSelector("table.dataTable tr.row"));
            }
        }

        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        List<WebElement> geo = driver.findElements(By.cssSelector("table.dataTable tr.row"));
        for (int k = 0; k < geo.size(); k++) {
            WebElement geoZone = geo.get(k).findElements(By.cssSelector("td")).get(2).findElement((By.cssSelector("a")));
            String geoZoneName = geoZone.getText();
            geoZone.click();

            String geoZonesPrevious = null;
            List<WebElement> geoZonesCountryList = driver.findElements(By.cssSelector("table#table-zones tr"));
            for (int l = 1; l < geoZonesCountryList.size() - 1; l++) {
                String geoZones = geoZonesCountryList.get(l).findElements(By.cssSelector("td")).get(2).findElement((By.cssSelector("select option[selected='selected']"))).getText();

                if (geoZonesPrevious != null && !(geoZones.compareToIgnoreCase(geoZonesPrevious) > 0)) {
                    AssertionError assertError = new AssertionError("Не в алфавитном порядке.");
                    System.out.println("Ошибка:" + geoZonesPrevious + " " + geoZones + " " + assertError.getMessage());
                    Assert.fail();
                }
                geoZonesPrevious = geoZones;
            }
            System.out.println(geoZoneName + "'в алфавитном порядке.");
            driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
            geo = driver.findElements(By.cssSelector("table.dataTable tr.row"));
        }
    }
}
