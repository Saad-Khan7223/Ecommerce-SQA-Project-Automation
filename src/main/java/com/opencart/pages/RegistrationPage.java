package com.opencart.pages;

import com.opencart.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Navigation
    private By myAccount = By.xpath("//span[normalize-space()='My Account']");
    private By register = By.xpath("//a[normalize-space()='Register']");

    // Form
    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By password = By.id("input-password");
    private By privacyPolicy = By.cssSelector("input[value='1'][name='agree']");
    private By continueButton = By.cssSelector("button[type='submit'][class='btn btn-primary']");

    // Newsletter
    private By newsletterYes = By.cssSelector("input[value='1'][name='newsletter']");

    // Success Message
    private By successHeading = By.cssSelector("div[id='content'] h1");

    // Warning
    private By warningMessage = By.cssSelector(".alert");

    // Actions

    public void clickMyAccount() {
        click(myAccount);
    }

    public void clickRegister() {
        click(register);
    }

    public void enterFirstName(String value) {
        type(firstName, value);
    }

    public void enterLastName(String value) {
        type(lastName, value);
    }

    public void enterEmail(String value) {
        type(email, value);
    }

    public void enterPassword(String value) {
        type(password, value);
    }


    public void acceptPrivacyPolicy() {

        WebElement checkbox = driver.findElement(privacyPolicy);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", checkbox);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", checkbox);
    }

    public void clickContinue() {
        clickWhenClickable(continueButton);
    }

    public void selectNewsletter() {
        WebElement checkbox = driver.findElement(newsletterYes);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", checkbox);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", checkbox);
    }


    public String getSuccessMessage() {
        return getText(successHeading);
    }

    public String getWarningMessage() {
        return getText(warningMessage);
    }
}