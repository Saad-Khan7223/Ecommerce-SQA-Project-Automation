package com.opencart.tests;

import com.opencart.tests.BaseTest;
import com.opencart.pages.ProductDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTest extends BaseTest {

    @Test
    public void verifyProductPageOpens() throws InterruptedException {

        ProductDetailsPage product = new ProductDetailsPage(driver);

        product.searchProduct("MacBook");
        Thread.sleep(3000);
        product.openProduct();

        Assert.assertEquals(product.getProductName(), "MacBook");
    }
    @Test
    public void verifyProductName() throws InterruptedException {

        ProductDetailsPage product = new ProductDetailsPage(driver);

        product.searchProduct("MacBook");
        Thread.sleep(3000);
        product.openProduct();

        Assert.assertEquals(product.getProductName(), "MacBook");
    }
    @Test
    public void verifyProductPrice() throws InterruptedException {

        ProductDetailsPage product = new ProductDetailsPage(driver);

        product.searchProduct("MacBook");
        Thread.sleep(3000);
        product.openProduct();

        Assert.assertTrue(product.getProductPrice().contains("$602"));
    }



}