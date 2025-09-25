package tests;

import org.testng.annotations.Test;
import tests.parent.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "проверка корректной авторизации")
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.loginThruZip("standard_user", "secret_sauce");
        assertTrue(productsPage.isTitlePresent());
    }

    @Test(description = "проверка входа с неверным логином")
    public void checkLockedUserLogin() {
        loginPage.open();
        loginPage.loginThruZip("locked_out_user", "secret_sauce");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(description = "проверка входа с пустым логином")
    public void checkNoUserLogin() {
        loginPage.open();
        loginPage.loginThruZip("", "secret_sauce");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Username is required");
    }

    @Test(description = "проверка входа с пустым паролем")
    public void checkNoUserPassword() {
        loginPage.open();
        loginPage.loginThruZip("standard_user", "");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Password is required");
    }
}
