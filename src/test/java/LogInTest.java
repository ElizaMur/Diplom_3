import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import stellarburgers.*;
import static com.codeborne.selenide.Selenide.open;

public class LogInTest {
    public String email = "murzina@test.ru";
    public String password = "orange08+";
    WebDriver driver;
    public String name;

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
    @DisplayName("Проверка входа через кнопку «Личный кабинет»")
    public void checkLoginAccount(){
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
    @DisplayName("Проверка входа через кнопку «Войти в аккаунт»")
    public void checkLoginButton(){
        MainPage page = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        page.clickSignInButton();
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login",
                LoginPage.class);
        loginPage.logIn(email, password);
        page.clickAccountButton();
        AccountPage accountPage = open("https://stellarburgers.nomoreparties.site/account",
                AccountPage.class);
        accountPage.checkProfile();
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    public void checkLoginButtonInRecovery(){
        MainPage page = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        page.clickSignInButton();
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login",
                LoginPage.class);
        loginPage.clickRecoveryPasswordButton();
        RecoveryPasswordPage recoveryPasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password",
                RecoveryPasswordPage.class);
        recoveryPasswordPage.clickLogInButton();
        loginPage.logIn(email, password);
        page.clickAccountButton();
        AccountPage accountPage = open("https://stellarburgers.nomoreparties.site/account",
                AccountPage.class);
        accountPage.checkProfile();
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void checkLoginAfterRegistration(){
        name = RandomStringUtils.randomAlphabetic(10);
        email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(10);
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register",
                RegisterPage.class);
        registerPage.registration(name, email, password);
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login",
                LoginPage.class);
        loginPage.logIn(email, password);
        loginPage.clickAccountButton();
        AccountPage accountPage = open("https://stellarburgers.nomoreparties.site/account",
                AccountPage.class);
        accountPage.checkProfile();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
