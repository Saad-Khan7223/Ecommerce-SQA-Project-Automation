package com.opencart.pages;

import com.opencart.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
      super(driver);
    }

    //locators
    private By myAccount = By.xpath("//span[normalize-space()='My Account']");
    private By login = By.xpath("//a[normalize-space()='Login']");
    private By email = By.id("input-email");
    private By password = By.id("input-password");
    private By loginButton = By.xpath("//button[normalize-space()='Login']");
    private By warningMessage = By.cssSelector(".alert.alert-danger");
    private By logout=By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']");

    // Actions
    public void clickMyAccount(){
        click(myAccount);
    }
    public void clickLogin() {
        click(login);
    }

    public void enterEmail(String userEmail) {
        type(email,userEmail);
    }

    public void enterPassword(String userPassword) {
        type(password,userPassword);
    }

    public void clickLoginButton() {
        click(loginButton);
    }
    public String getWarningMessage() {
        return getText(warningMessage);
    }
    public void clickLogout() {
        click(logout);
    }
}
