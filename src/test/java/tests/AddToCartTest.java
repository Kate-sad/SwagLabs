package tests;

import org.testng.annotations.Test;
import tests.parent.BaseTest;

import static org.testng.Assert.*;

public class AddToCartTest extends BaseTest {

    @Test(description = "проверка товаров")
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.loginThruZip("standard_user", "secret_sauce");
        productsPage.addToCart(0);
        productsPage.addToCart(1);
        productsPage.addToCart(2);
        //productsPage.openCart();
        loginPage.open("cart.html");
        assertTrue(cartPage.getProductNames().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductNames().size(), 3);
        assertFalse(cartPage.getProductNames().isEmpty());
        System.out.println(cartPage.getProductNames() + "!!");
    }
}
