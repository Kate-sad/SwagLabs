package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By LOGIN_INPUT = By.xpath("//input[@placeholder='Username']");
    private static final By PASSWORD_INPUT = By.xpath("//input[@placeholder='Password']");
    private static final By LOGIN_BTN = By.cssSelector("*[value='Login']");
    private static final By ERROR = By.xpath("//*[@data-test='error']");

    public void open() {
        driver.get(BASE_URL);
    }

    public void openPath(String path) {
        driver.get(BASE_URL + path);
    }

    public void loginThruZip(String login, String password) {
         driver.findElement(LOGIN_INPUT).sendKeys(login);
         driver.findElement(PASSWORD_INPUT).sendKeys(password);
         driver.findElement(LOGIN_BTN).click();
    }

    public String checkErrorMsg() {
        return driver.findElement(ERROR).getText();
    }
}
