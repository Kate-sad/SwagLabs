package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.parent.BaseTest;
import user.User;

import static enums.DepartmentNaming.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

@Listeners(AllureTestNg.class)
public class LoginTest extends BaseTest {

    @Epic("Модуль логин...")
    @Feature("Юридические лица")
    @Story("Stg-123")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Romashova Ekaterina, Kate.sky24@mail.ru")
    @TmsLink("изменяющаяся часть")
    @Issue("изменяющаяся часть")
    @Flaky
    @Test(description = "проверка корректной авторизации")
    public void checkCorrectLogin() {
        System.out.println("Login tests are running in thread:" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.loginThruZip(withAdminPermission());
        assertTrue(productsPage.isTitlePresent());
        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName(), "Название товара");
    }

    @DataProvider()
    public Object[][] loginData() {
        User lockUser = withLockUserPermission();
        User emptyUser = withEmptyUserPermission();
        User emptyPassword = withEmptyPasswordPermission();

        return new Object[][] {
                {lockUser, "Epic sadface: Sorry, this user has been locked out."},
                {emptyUser, "Epic sadface: Username is required"},
                {emptyPassword, "Epic sadface: Password is required"}
        };
    }

    @Epic("Модуль логин...")
    @Feature("Юридические лица")
    @Story("Stg-123")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Romashova Ekaterina, Kate.sky24@mail.ru")
    @TmsLink("изменяющаяся часть")
    @Issue("изменяющаяся часть")
    @Test(description = "проверка входа с неверными данными", dataProvider = "loginData")
    public void checkIncorrectLogin(User user, String errorMsg) {
        System.out.println("Login negative tests are running in thread:" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.loginThruZip(user);
        assertEquals(loginPage.checkErrorMsg(), errorMsg);
    }
}
