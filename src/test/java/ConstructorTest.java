import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import stellarburgers.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {

    WebDriver driver;

    //    @Before
//    public void yandexBrowser() {
//        ChromeOptions options = new ChromeOptions();
//        System.setProperty("webdriver.yandex.driver", "/usr/local/bin/yandexdriver");
//        options.setBinary("/Applications/Yandex.app");
//        options.addArguments("--no-sandbox", "chromeoptions.args", "test-type=browser");
//        driver = new ChromeDriver(options);
//        WebDriverRunner.setWebDriver(driver);
//        driver.manage().window().maximize();
//    }

    @Before
    public void chromeBrowser() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        options.setBinary("/Applications/Google\\ Chrome.app");
        options.addArguments("--no-sandbox", "chromeoptions.args", "test-type=browser");
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();

    }

    @Test
    public void checkSwitchToBuns(){
        MainPage page = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        page.clickFilling();
        page.clickBuns();
        page.checkBuns();
    }
    @Test
    public void checkSwitchToSauces(){
        MainPage page = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        page.clickSauces();
        page.checkSauces();
    }
    @Test
    public void checkSwitchToFilling(){
        MainPage page = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        page.clickFilling();
        page.checkFilling();
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
