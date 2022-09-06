package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.visible;


public class AccountPage {
    @FindBy(how = How.XPATH, using = "//nav/a[@href]")
    private SelenideElement linkToAccount;
    // локатор конструктора
    @FindBy(how = How.XPATH, using = "//li[1]/a[@href]")
    private SelenideElement constructor;
    // локатор логотипа
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoBurger;

    @FindBy(how =  How.CLASS_NAME, using = "AppHeader_header__link__3D_hX")
    private SelenideElement linkProfile;
    //локатор кнопки Выход
    @FindBy(how = How.CLASS_NAME, using = "Account_button__14Yp3")
    private SelenideElement logOutButton;

    @Step("Нажать на кнопку Личный кабинет")
    public void clickAccountButton() {
        linkToAccount.click();
    }

    @Step("Нажать на раздел Конструктор")
    public void clickConstructor() {
        constructor.click();
    }

    @Step("Нажать на лого")
    public void clickLogoBurger() {
        logoBurger.click();
    }

    @Step("Нажать на кнопку Выйти")
    public void clickLogOutButton() {
        logOutButton.click();
    }

    @Step("Проверить что октрыт профиль пользователя")
    public void checkProfile(){
        linkProfile.shouldBe(visible);
    }
}
