package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RecoveryPasswordPage {
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset/div/div/input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/button")
    private SelenideElement buttonRecovery;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div/p/a")
    private SelenideElement buttonLogIn;


    public void clickButtonRecovery() {
        buttonRecovery.click();
    }
    public void clickLogInButton() {
        buttonLogIn.click();
    }

    public void setEmailField(String email){
        emailField.setValue(email);
    }

    public void recoveryPassword(String email, String password) {
        setEmailField(email);
        clickButtonRecovery();
    }
}
