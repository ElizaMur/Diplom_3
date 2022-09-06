package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.visible;

public class RegisterPage {
    // локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement buttonSubmit;
    // локатор для поля name
    @FindBy(how = How.XPATH,using = "//fieldset[contains(., \"Имя\")]/descendant::input")
    private SelenideElement nameField;
    // локатор для поля почты
    @FindBy(how = How.XPATH,using = "//fieldset[contains(., \"Email\")]/descendant::input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH,using = "//input[@name=\"Пароль\"]")
    private SelenideElement passwordField;

    @FindBy(how = How.CLASS_NAME,using = "input__error")
    private SelenideElement errorMessage;

    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement buttonLogIn;

    @Step("Нажать на кнопку подтверждения регистрации")
    public void clickSubmitButton() {
        buttonSubmit.click();
    }

    @Step("Нажать на кнопку Войти")
    public void clickLogIn() {
        buttonLogIn.click();
    }

    @Step("Ввести значание в поле Имя")
    public void setNameField(String name){
        nameField.setValue(name);
    }

    @Step("Ввести значание в поле Email")
    public void setEmailField(String email){
        emailField.setValue(email);
    }

    @Step("Ввести значание в поле Пароль")
    public void setPasswordField(String password){
        passwordField.setValue(password);
    }

    @Step("Зарегистроваться")
    public void registration(String name, String email, String password) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
        clickSubmitButton();
    }

    @Step("Проверка сообщения о невалидном пароле для регистрации")
    public void checkErrorUncorrectPassword(){
        errorMessage.shouldBe(visible).shouldHave(ownText("Некорректный пароль"));
    }
}
