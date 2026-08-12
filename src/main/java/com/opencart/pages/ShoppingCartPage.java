package com.opencart.pages;

import com.opencart.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private By searchBox = By.name("search");
    private By searchButton = By.xpath("//button[@class='btn btn-light btn-lg']");
    private By product = By.linkText("MacBook");

    private By addToCart = By.id("button-cart");
    private By shoppingCart = By.linkText("shopping cart");

    private By quantity = By.cssSelector("input[name*='quantity']");
    private By update = By.cssSelector("button[data-original-title='Update']");
    private By remove = By.cssSelector("button[data-original-title='Remove']");

    private By successAlert = By.cssSelector(".alert-success");
    private By emptyCart = By.cssSelector("#content p");

    public void searchProduct(String productName){
        type(searchBox,productName);
        click(searchButton);
    }

    public void openProduct(){
        click(product);
    }

    public void addProductToCart(){
        click(addToCart);
    }

    public void openShoppingCart(){
        click(shoppingCart);
    }

    public void updateQuantity(String qty){
        clear(quantity);
        type(quantity,qty);
        click(update);
    }

    public String getQuantity(){
        return driver.findElement(quantity).getAttribute("value");
    }

    public void removeProduct(){
        click(remove);
    }

    public String getSuccessMessage(){
        return getText(successAlert);
    }

    public String getEmptyCartMessage(){
        return getText(emptyCart);
    }
}
