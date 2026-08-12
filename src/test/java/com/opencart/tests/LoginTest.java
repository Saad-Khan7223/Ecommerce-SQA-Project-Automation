package com.opencart.tests;

import com.opencart.pages.LoginPage;
import com.opencart.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {
    ConfigReader config = new ConfigReader();

    @Test
    public void verifyLoginWithValidCredentials() {

        LoginPage loginPage = new LoginPage(driver);


        loginPage.clickMyAccount();
        loginPage.clickLogin();

        loginPage.enterEmail(config.getProperty("email"));
        loginPage.enterPassword(config.getProperty("password"));

        loginPage.clickLoginButton();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.titleIs("My Account"));

        Assert.assertEquals(driver.getTitle(), "My Account");
    }
    @Test
    public void verifyLoginWithInvalidCredentials() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickMyAccount();
        loginPage.clickLogin();

        loginPage.enterEmail("abc@gmail.com");
        loginPage.enterPassword("123456");

        loginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert")));

        Assert.assertTrue(
                loginPage.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));
    }

    @Test
    public void verifyLoginWithBlankCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickMyAccount();
        loginPage.clickLogin();

        loginPage.enterEmail("");
        loginPage.enterPassword("");

        loginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert")));

        Assert.assertTrue(
                loginPage.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));
    }

    @Test
    public void verifyLoginWithInvalidEmailAndValidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickMyAccount();
        loginPage.clickLogin();

        loginPage.enterEmail("abc001@gmail.com");
        loginPage.enterPassword(config.getProperty("password"));

        loginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert")));

        Assert.assertTrue(
                loginPage.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));
    }

    @Test
    public void verifyLoginWithValidEmailAndInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickMyAccount();
        loginPage.clickLogin();

        loginPage.enterEmail(config.getProperty("email"));
        loginPage.enterPassword("password123");

        loginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert")));

        Assert.assertTrue(
                loginPage.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));
    }

    @Test
    public void verifyUserCanLogout() throws InterruptedException {

        LoginPage login=new LoginPage(driver);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickMyAccount();
        loginPage.clickLogin();

        loginPage.enterEmail(config.getProperty("email"));
        loginPage.enterPassword(config.getProperty("password"));

        loginPage.clickLoginButton();
        Thread.sleep(5000);

        login.clickLogout();

        Assert.assertTrue(driver.getTitle().contains("Account Logout"));
    }
}