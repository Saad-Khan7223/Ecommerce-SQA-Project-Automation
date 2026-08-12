package com.opencart.pages;

import com.opencart.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage {

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    private By searchBox = By.name("search");
    private By searchButton = By.xpath("//button[@class='btn btn-light btn-lg']");
    private By product = By.linkText("MacBook");
    private By wishlist = By.xpath("//button[@data-original-title='Add to Wish List']");
    private By success = By.cssSelector(".alert-success");
    private By wishlistLink = By.linkText("wish list");


    public void searchProduct(String name){
        type(searchBox,name);
        click(searchButton);
    }

    public void openProduct(){
        click(product);
    }

    public void addToWishlist(){
        click(wishlist);
    }

    public String successMessage(){
        return getText(success);
    }

    public void openWishlist(){
        click(wishlistLink);
    }
}
