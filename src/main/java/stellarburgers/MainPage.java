package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.time.Duration;
import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.visible;

public class MainPage {
    // локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement buttonSingIn;
    // локатор для ссылки перехода в аккаунт
    @FindBy(how = How.XPATH, using = "//nav/a[@href]")
    private SelenideElement linkToAccount;
    // локатор конструктора
    @FindBy(how = How.XPATH, using = "//li[1]/a[@href]")
    private SelenideElement constructor;
    //Раздел Булки
    @FindBy(how = How.XPATH, using = "//span[contains(., \"Булки\")]")
    private SelenideElement buns;
    //Раздел Соусы
    @FindBy(how = How.XPATH, using = "//span[contains(., \"Соусы\")]")
    private SelenideElement sauces;
    //Раздел Начинки
    @FindBy(how = How.XPATH, using = "//span[contains(., \"Начинки\")]")
    private SelenideElement filling;
    //Раздел Булки
    @FindBy(how = How.XPATH, using = "//h2[contains(., \"Булки\")]")
    private SelenideElement headerBuns;
    //Раздел Соусы
    @FindBy(how = How.XPATH, using = "//h2[contains(., \"Соусы\")]")
    private SelenideElement headerSauces;
    //Раздел Начинки
    @FindBy(how = How.XPATH, using = "//h2[contains(., \"Начинки\")]")
    private SelenideElement headerFilling;
    // локатор логотипа
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoBurger;

    public void clickSignInButton() {
        buttonSingIn.click();
    }

    @Step("Нажать на кнопку Личный кабинет")
    public void clickAccountButton() {
        linkToAccount.click();
    }

    @Step("Нажать на кнопку Войти в аккаунт")
    public void clickConstructor() {
        constructor.click();
    }

    @Step("Нажать на лого")
    public void clickLogoBurger() {
        logoBurger.click();
    }

    @Step("Нажать на раздел Булки")
    public void clickBuns() {
        buns.click();
    }

    @Step("Нажать на раздел Соусы")
    public void clickSauces() {
        sauces.click();
    }

    @Step("Нажать на раздел Начинки")
    public void clickFilling() {
        filling.click();
    }

    @Step("Проверить отображение раздела Булки")
    public void checkBuns(){
        headerBuns.shouldBe(visible).shouldHave(ownText("Булки"));
    }

    @Step("Проверить отображение раздела Соусы")
    public void checkSauces(){
        headerSauces.shouldBe(visible).shouldHave(ownText("Соусы"));
    }

    @Step("Проверить отображение раздела Начинки")
    public void checkFilling(){
        headerFilling.shouldBe(visible).shouldHave(ownText("Начинки"));
    }

    @Step("Проверка видимости кнопки Личный кабинет")
    public void checkLinkAccount(){
        linkToAccount.shouldBe((visible), Duration.ofSeconds(3));
    }
}