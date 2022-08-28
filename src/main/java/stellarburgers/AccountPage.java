package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class AccountPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/header/nav/a/p")
    private SelenideElement linkToAccount;
    // локатор конструктора
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p")
    private SelenideElement constructor;
    // локатор логотипа
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/header/nav/div/a")
    private SelenideElement logoBurger;

    @FindBy(how = How.XPATH, using = " //*[@id=\"root\"]/div/main/div/nav/ul/li[1]/a")
    private SelenideElement linkProfile;

    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/div/div/ul/li[2]/div/div/input")
    private SelenideElement emailField;
    //локатор кнопки Выход
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button")
    private SelenideElement logOutButton;

    public void clickAccountButton() {
        linkToAccount.click();
    }

    public void clickConstructor() {
        constructor.click();
    }
    public void clickLogoBurger() {
        logoBurger.click();
    }

    public void clickLogOutButton() {
        logOutButton.click();
    }
    public void checkProfile(){
        linkProfile.shouldBe(visible);
    }
}
