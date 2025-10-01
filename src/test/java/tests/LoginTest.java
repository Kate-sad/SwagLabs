package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.parent.BaseTest;
import user.User;
import user.UserFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

public class LoginTest extends BaseTest {

    @Test(description = "проверка корректной авторизации")
    public void checkCorrectLogin() {
        System.out.println("Login tests are running in thread:" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.loginThruZip(withAdminPermission());
        assertTrue(productsPage.isTitlePresent());
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

    @Test(description = "проверка входа с неверными данными", dataProvider = "loginData")
    public void checkIncorrectLogin(User user, String errorMsg) {
        System.out.println("Login negative tests are running in thread:" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.loginThruZip(user);
        assertEquals(loginPage.checkErrorMsg(), errorMsg);
    }
}
