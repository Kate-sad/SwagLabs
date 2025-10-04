package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import tests.parent.BaseTest;
import user.UserFactory;

import static org.testng.Assert.*;

public class AddToCartTest extends BaseTest {

    @Epic("Модуль логин...")
    @Feature("Юридические лица")
    @Story("Stg-123")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Romashova Ekaterina, Kate.sky24@mail.ru")
    @TmsLink("изменяющаяся часть")
    @Issue("изменяющаяся часть")
    @Test(description = "проверка товаров")
    public void checkGoodsInCart() {
        System.out.println("AddGoods tests are running in thread:" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.loginThruZip(UserFactory.withAdminPermission());
        productsPage.addToCart(0);
        productsPage.addToCart(1);
        productsPage.addToCart(2);
        loginPage.open("/cart.html");
        assertTrue(cartPage.getProductNames().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductNames().size(), 3);
        assertFalse(cartPage.getProductNames().isEmpty());
        System.out.println(cartPage.getProductNames() + "!!");
    }
}
