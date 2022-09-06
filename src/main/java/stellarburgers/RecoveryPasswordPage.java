package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RecoveryPasswordPage {
    @FindBy(how = How.XPATH,using = "//input[@name=\"name\"]")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//p[2]/a[@href]")
    private SelenideElement buttonRecoveryPassword;

    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement buttonLogIn;

    @Step("Нажать на кнопку Восстановить пароль")
    public void clickButtonRecovery() {
        buttonRecoveryPassword.click();
    }

    @Step("Нажать на кнопку Войти в аккаунт")
    public void clickLogInButton() {
        buttonLogIn.click();
    }

    @Step("Ввести значание в поле Email")
    public void setEmailField(String email){
        emailField.setValue(email);
    }

    @Step("Восстановить пароль")
    public void recoveryPassword(String email, String password) {
        setEmailField(email);
        clickButtonRecovery();
    }
}
