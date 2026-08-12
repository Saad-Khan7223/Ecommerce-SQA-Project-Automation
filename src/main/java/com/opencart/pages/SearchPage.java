package com.opencart.pages;

import com.opencart.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By searchBox = By.name("search");
    private By searchButton = By.xpath("//button[@class='btn btn-light btn-lg']");
    private By productTitle = By.xpath("//body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/h4/a");
    private By noProductMessage = By.cssSelector("div[id='content'] p");

    // Actions
    public void enterSearchKeyword(String product) {
        type(searchBox, product);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public String getProductTitle() {
        return getText(productTitle);
    }

    public String getNoProductMessage() {
        return getText(noProductMessage);
    }
}