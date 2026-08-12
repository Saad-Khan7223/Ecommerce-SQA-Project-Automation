package com.opencart.pages;

import com.opencart.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    // Search
    private By searchBox = By.name("search");
    private By searchButton = By.xpath("//button[@class='btn btn-light btn-lg']");

    // Product
    private By product = By.xpath("//img[@title='MacBook']");
    private By productName = By.cssSelector("#content h1");
    private By productPrice = By.cssSelector(".list-unstyled h2");
    private By productImage = By.cssSelector(".thumbnail img");

    // Quantity
    private By quantity = By.id("input-quantity");

    // Buttons
    private By addToCart = By.id("button-cart");
    private By addToWishlist = By.xpath("//button[@data-original-title='Add to Wish List']");
    private By compareProduct = By.xpath("//button[@data-original-title='Compare this Product']");

    // Success Message
    private By successAlert = By.cssSelector(".alert-success");

    // Review
    private By reviewTab = By.xpath("//a[text()='Reviews (0)']");
    private By writeReview = By.id("button-review");

    // Methods

    public void searchProduct(String productName) {
        type(searchBox, productName);
        click(searchButton);
    }

    public void openProduct() {
        click(product);
    }

    public String getProductName() {
        return getText(productName);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public boolean isProductImageDisplayed() {
        return driver.findElement(productImage).isDisplayed();
    }

    public void changeQuantity(String qty) {
        clear(quantity);
        type(quantity, qty);
    }

    public void clickAddToCart() {
        click(addToCart);
    }

    public void clickWishlist() {
        click(addToWishlist);
    }

    public void clickCompare() {
        click(compareProduct);
    }

    public String getSuccessMessage() {
        return getText(successAlert);
    }

    public void openReviewTab() {
        click(reviewTab);
    }

    public boolean isReviewButtonDisplayed() {
        return driver.findElement(writeReview).isDisplayed();
    }
}