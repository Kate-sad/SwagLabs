package tests;

import org.testng.annotations.Test;
import tests.parent.BaseTest;

import static org.testng.Assert.assertTrue;

public class AddToCartTest extends BaseTest {

    @Test(description = "проверка добавления товара в корзину")
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.loginThruZip("standard_user", "secret_sauce");
        assertTrue(productsPage.isTitlePresent());
        productsPage.addToCart(0);
        productsPage.addToCart(1);
        productsPage.addToCart(2);
    }
}
