package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By LOGIN_INPUT = By.xpath("//input[@placeholder='Username']");
    private static final By PASSWORD_INPUT = By.xpath("//input[@placeholder='Password']");
    private static final By LOGIN_BTN = By.cssSelector("*[value='Login']");
    private static final By ERROR = By.xpath("//*[@data-test='error']");

    @Step("Открытие браузера")
    public void open() {
        driver.get(BASE_URL);
    }

    public void open(String url) {
        driver.get(BASE_URL + url);
    }

    @Step("Логинимся под кредами пользователя")
    public void loginThruZip(User user) {
        fillLoginField(user.getEmail());
        fillPasswordField(user.getPassword());
        clickSubmit();
    }

    public void fillLoginField(String login) {
        driver.findElement(LOGIN_INPUT).sendKeys(login);
    }

    public void fillPasswordField(String password) {
            driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(LOGIN_BTN).click();
    }

    @Step("Проверяем соответствие сообщения об ошибке")
    public String checkErrorMsg() {
        return driver.findElement(ERROR).getText();
    }
}
