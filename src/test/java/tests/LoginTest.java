package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import parent.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void checkLogin() {
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        browser.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("*[value='Login']")).click();
        boolean isPresent = browser.findElement(By.xpath("//*[@class='title']")).isDisplayed();
        assertTrue(isPresent);
    }

    @Test
    public void checkErrorLogin() {
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("locked_out_user");
        browser.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("*[value='Login']")).click();
        String errorMsg = browser.findElement(By.xpath("//*[@data-test='error']")).getText();
        assertEquals(errorMsg, "Epic sadface: Sorry, this user has been locked out.");
    }
}
