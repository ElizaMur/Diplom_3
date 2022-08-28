import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import stellarburgers.AccountPage;
import stellarburgers.LoginPage;
import stellarburgers.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class AccountTest {
    public String email = "murzina@test.ru";
    public String password = "orange08+";
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
    public void checkSwitchToAccount(){
        MainPage page = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        page.clickAccountButton();
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login",
                LoginPage.class);
        loginPage.logIn(email, password);
        page.clickAccountButton();
        AccountPage accountPage = open("https://stellarburgers.nomoreparties.site/account",
                AccountPage.class);
        accountPage.checkProfile();
    }

    @Test
    public void checkSwitchToConstructor(){
        MainPage page = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        page.clickAccountButton();
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login",
                LoginPage.class);
        loginPage.logIn(email, password);
        page.clickAccountButton();
        AccountPage accountPage = open("https://stellarburgers.nomoreparties.site/account",
                AccountPage.class);
        accountPage.clickConstructor();
        page.checkBuns();
    }

    @Test
    public void checkSwitchToConstructorClickLogo(){
        MainPage page = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        page.clickAccountButton();
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login",
                LoginPage.class);
        loginPage.logIn(email, password);
        page.clickAccountButton();
        AccountPage accountPage = open("https://stellarburgers.nomoreparties.site/account",
                AccountPage.class);
        accountPage.clickLogoBurger();
        page.checkBuns();
    }

    @Test
    public void checkLogOut(){
        MainPage page = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        page.clickAccountButton();
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login",
                LoginPage.class);
        loginPage.logIn(email, password);
        page.clickAccountButton();
        AccountPage accountPage = open("https://stellarburgers.nomoreparties.site/account",
                AccountPage.class);
        accountPage.clickLogOutButton();
        loginPage.checkVisibleButtonLogIn();
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
