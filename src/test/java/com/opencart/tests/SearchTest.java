package com.opencart.tests;

import com.opencart.pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTest extends BaseTest {

    @Test
    public void verifySearchWithValidProduct() {

        SearchPage searchPage = new SearchPage(driver);

        searchPage.enterSearchKeyword("MacBook");
        searchPage.clickSearchButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("MacBook")));

        Assert.assertEquals(searchPage.getProductTitle(), "MacBook");
    }


    @Test
    public void verifySearchWithInvalidProduct() {

        SearchPage searchPage = new SearchPage(driver);

        searchPage.enterSearchKeyword("Laptop123");
        searchPage.clickSearchButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[id='content'] p")));

        Assert.assertTrue(
                searchPage.getNoProductMessage()
                        .contains("There is no product"));
    }

    @Test
    public void verifySearchWithBlankKeyword() {

        SearchPage searchPage = new SearchPage(driver);

        searchPage.enterSearchKeyword("");
        searchPage.clickSearchButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[id='content'] p")));
        Assert.assertTrue(
                searchPage.getNoProductMessage()
                        .contains("There is no product"));
    }
}