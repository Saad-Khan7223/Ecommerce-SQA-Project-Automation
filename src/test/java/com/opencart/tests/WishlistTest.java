package com.opencart.tests;

import com.opencart.pages.LoginPage;
import com.opencart.pages.WishlistPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class WishlistTest extends BaseTest {


    @Test
    public void verifyProductCanBeAddedToWishlist(){
        LoginPage loginPage = new LoginPage(driver);


        loginPage.clickMyAccount();
        loginPage.clickLogin();

        loginPage.enterEmail(config.getProperty("email"));
        loginPage.enterPassword(config.getProperty("password"));

        loginPage.clickLoginButton();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.titleIs("My Account"));

        Assert.assertEquals(driver.getTitle(), "My Account");

        WishlistPage wish = new WishlistPage(driver);

        wish.searchProduct("MacBook");
        wish.openProduct();
        wish.addToWishlist();

        Assert.assertTrue(wish.successMessage().contains("Success"));
    }

    @Test
    public void verifyWishlistPageOpensSuccessfully(){
        LoginPage loginPage = new LoginPage(driver);


        loginPage.clickMyAccount();
        loginPage.clickLogin();

        loginPage.enterEmail(config.getProperty("email"));
        loginPage.enterPassword(config.getProperty("password"));

        loginPage.clickLoginButton();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.titleIs("My Account"));

        Assert.assertEquals(driver.getTitle(), "My Account");

        WishlistPage wish = new WishlistPage(driver);

        wish.searchProduct("MacBook");
        wish.openProduct();
        wish.addToWishlist();
        wish.openWishlist();

        Assert.assertTrue(driver.getTitle().contains("Wish List"));
    }
}
