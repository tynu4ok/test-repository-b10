package ru.Test.NewTest19.app;

        import org.junit.After;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import ru.Test.NewTest19.pages.CartPage;
        import ru.Test.NewTest19.pages.ItemPage;
        import ru.Test.NewTest19.pages.MainPage;

public class Application {
    private WebDriver driver;
    private WebDriverWait wait;
    public MainPage mainPage;
    public CartPage cartPage;
    public ItemPage itemPage;

    public Application() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        itemPage = new ItemPage(driver);
    }

    @After
    public void quit() {
        driver.quit();
    }

}