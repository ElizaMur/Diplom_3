import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import stellarburgers.AccountPage;
import stellarburgers.LoginPage;
import stellarburgers.RegisterPage;

import static com.codeborne.selenide.Selenide.open;

public class RegisterTest {
    public String name;
    public String email;
    public String password;
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
    public void checkRegistration(){
        //test data
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

    @Test
    public void checkRegistrationWrongPassword(){
        //test data
        name = RandomStringUtils.randomAlphabetic(10);
        email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(5);
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register",
                RegisterPage.class);
        registerPage.registration(name, email, password);
        registerPage.checkErrorUncorrectPassword();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
