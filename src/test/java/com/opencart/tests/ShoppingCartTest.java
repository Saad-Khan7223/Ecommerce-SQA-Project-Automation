package com.opencart.tests;

import com.opencart.tests.BaseTest;
import com.opencart.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    @Test
    public void verifyShoppingCartOpensSuccessfully() throws InterruptedException {

        ShoppingCartPage cart = new ShoppingCartPage(driver);

        cart.searchProduct("MacBook");
        Thread.sleep(2000);
        cart.openProduct();
        Thread.sleep(2000);
        cart.addProductToCart();
        Thread.sleep(2000);
        cart.openShoppingCart();

        Assert.assertTrue(driver.getTitle().contains("Shopping Cart"));
    }

    @Test
    public void verifyProductCanBeAddedToCart() throws InterruptedException {

        ShoppingCartPage cart = new ShoppingCartPage(driver);

        cart.searchProduct("MacBook");
        Thread.sleep(2000);
        cart.openProduct();
        Thread.sleep(2000);
        cart.addProductToCart();
        Thread.sleep(2000);
        Assert.assertTrue(cart.getSuccessMessage().contains("Success"));
    }


}