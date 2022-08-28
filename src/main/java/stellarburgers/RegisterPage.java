package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.visible;

public class RegisterPage {
    // локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/button")
    private SelenideElement buttonSubmit;
    // локатор для поля name
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement nameField;
    // локатор для поля name
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH,using = " //*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p")
    private SelenideElement errorMessage;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div/p/a")
    private SelenideElement buttonLogIn;



    public void clickSubmitButton() {
        buttonSubmit.click();
    }

    public void clickLogIn() {
        buttonLogIn.click();
    }
    public void setNameField(String name){
        nameField.setValue(name);
    }
    public void setEmailField(String email){
        emailField.setValue(email);
    }
    public void setPasswordField(String password){
        passwordField.setValue(password);
    }

    public void registration(String name, String email, String password) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
        clickSubmitButton();
    }

    public void checkErrorUncorrectPassword(){
        errorMessage.shouldBe(visible).shouldHave(ownText("Некорректный пароль"));
    }



}
