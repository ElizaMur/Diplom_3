package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    // локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/section[2]/div/button")
    private SelenideElement buttonSingIn;
    // локатор для ссылки перехода в аккаунт
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/header/nav/a/p")
    private SelenideElement linkToAccount;
    // локатор конструктора
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p")
    private SelenideElement constructor;
    //Раздел Булки
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]")
    private SelenideElement buns;
    //Раздел Соусы
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]")
    private SelenideElement sauces;
    //Раздел Начинки
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]")
    private SelenideElement filling;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[1]")
    private SelenideElement headerBuns;
    //Раздел Соусы
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[2]")
    private SelenideElement headerSauces;
    //Раздел Начинки
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[3]")
    private SelenideElement headerFilling;

    // локатор логотипа
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/header/nav/div/a")
    private SelenideElement logoBurger;

    public void clickSignInButton() {
        buttonSingIn.click();
    }


    public void clickAccountButton() {
        linkToAccount.click();
    }

    public void clickConstructor() {
        constructor.click();
    }
    public void clickLogoBurger() {
        logoBurger.click();
    }

    public void clickBuns() {
        buns.click();
    }
    public void clickSauces() {
        sauces.click();
    }
    public void clickFilling() {
        filling.click();
    }

    public void checkBuns(){
        headerBuns.shouldBe(visible).shouldHave(ownText("Булки"));
    }
    public void checkSauces(){
        headerSauces.shouldBe(visible).shouldHave(ownText("Соусы"));
    }
    public void checkFilling(){
        headerFilling.shouldBe(visible).shouldHave(ownText("Начинки"));
    }
    public void checkLinkAccount(){
        linkToAccount.shouldBe((visible), Duration.ofSeconds(3));
    }

}