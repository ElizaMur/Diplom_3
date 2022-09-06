package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.visible;

public class LoginPage {
    @FindBy(how = How.XPATH,using = "//input[@name=\"name\"]")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH,using = "//input[@name=\"Пароль\"]")
    private SelenideElement passwordField;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement buttonLogIn;

    @FindBy(how = How.CLASS_NAME, using = "//p[1]/a[@href]")
    private SelenideElement buttonRegister;

    @FindBy(how = How.XPATH, using = "//p[2]/a[@href]")
    private SelenideElement buttonRecoveryPassword;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__linkText__3q_va")
    private SelenideElement linkToAccount;

    @Step("Нажать на кнопку Войти в аккаунт")
    public void clickLogInButton() {
        buttonLogIn.click();
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        buttonRegister.click();
    }

    @Step("Нажать на кнопку Восстановить пароль")
    public void clickRecoveryPasswordButton() {
        buttonRecoveryPassword.click();
    }

    @Step("Ввести значание в поле Email")
    public void setEmailField(String email){
        emailField.setValue(email);
    }

    @Step("Ввести значение в поле Пароль")
    public void setPasswordField(String password){
        passwordField.setValue(password);
    }

    @Step("Авторизоваться")
    public void logIn(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        clickLogInButton();
    }

    @Step("Проверка видимости кнопки Войти в аккаунт")
    public void checkVisibleButtonLogIn(){
        buttonLogIn.shouldBe(visible).shouldHave(ownText("Войти"));
    }

    @Step("Нажать на кнопку Личный кабинет")
    public void clickAccountButton() {
        linkToAccount.click();
    }
}
