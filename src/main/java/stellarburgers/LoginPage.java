package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.visible;

public class LoginPage {
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/button")
    private SelenideElement buttonLogIn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div/p[1]/a")
    private SelenideElement buttonRegister;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div/p[2]/a")
    private SelenideElement buttonRecoveryPassword;

    public void clickLogInButton() {
        buttonLogIn.click();
    }
    public void clickRegisterButton() {
        buttonRegister.click();
    }
    public void clickRecoveryPasswordButton() {
        buttonRecoveryPassword.click();
    }

    public void setEmailField(String email){
        emailField.setValue(email);
    }
    public void setPasswordField(String password){
        passwordField.setValue(password);
    }

    public void logIn(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        clickLogInButton();
    }
    public void checkVisibleButtonLogIn(){
        buttonLogIn.shouldBe(visible).shouldHave(ownText("Войти"));
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/header/nav/a/p")
    private SelenideElement linkToAccount;
    public void clickAccountButton() {
        linkToAccount.click();
    }
}
