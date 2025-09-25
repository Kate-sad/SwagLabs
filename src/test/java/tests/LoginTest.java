package tests;

import org.testng.annotations.DataProvider;
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

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][] {
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test(description = "проверка входа с неверными данными", dataProvider = "loginData")
    public void checkIncorrectLogin(String user, String password, String errorMsg) {
        loginPage.open();
        loginPage.loginThruZip(user, password);
        assertEquals(loginPage.checkErrorMsg(), errorMsg);
    }
}
