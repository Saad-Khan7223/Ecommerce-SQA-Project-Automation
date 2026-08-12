package com.opencart.tests;

import com.opencart.pages.RegistrationPage;
import com.opencart.utilities.RandomDataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTest extends BaseTest {

    @Test
    public void verifyRegistrationWithValidDetails() throws InterruptedException {

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickMyAccount();
        registrationPage.clickRegister();

        registrationPage.enterFirstName("Saad");
        registrationPage.enterLastName("Khan");
        registrationPage.enterEmail(RandomDataGenerator.getRandomEmail());
        registrationPage.enterPassword("saad123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        registrationPage.acceptPrivacyPolicy();
        Thread.sleep(5000);
        registrationPage.clickContinue();


        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Your Account Has Been Created!']")));

        Assert.assertEquals(
                registrationPage.getSuccessMessage(),
                "Your Account Has Been Created!"
        );
    }

    @Test
    public void verifyRegistrationWithExistingEmail() throws InterruptedException {

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickMyAccount();
        registrationPage.clickRegister();

        registrationPage.enterFirstName("Saad");
        registrationPage.enterLastName("Khan");
        registrationPage.enterEmail("ahmed@gmail.com"); // Existing Email
        registrationPage.enterPassword("ahmed123");

        registrationPage.acceptPrivacyPolicy();
        Thread.sleep(2000);
        registrationPage.clickContinue();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert")));

        Assert.assertTrue(
                registrationPage.getWarningMessage().contains("Warning: E-Mail Address is already registered!")
        );
    }

    @Test
    public void verifyRegistrationWithBlankFields() throws InterruptedException {

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickMyAccount();
        registrationPage.clickRegister();

        registrationPage.acceptPrivacyPolicy();
        Thread.sleep(2000);

        registrationPage.clickContinue();

        Assert.assertTrue(driver.getPageSource().contains("First Name"));
    }
    @Test
    public void verifyNewsletterYes() throws InterruptedException {

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickMyAccount();
        registrationPage.clickRegister();

        registrationPage.enterFirstName("Saad");
        registrationPage.enterLastName("Khan");
        registrationPage.enterEmail(RandomDataGenerator.getRandomEmail());
        registrationPage.enterPassword("saad123");

        registrationPage.selectNewsletter();
        registrationPage.acceptPrivacyPolicy();

        Thread.sleep(2000);

        registrationPage.clickContinue();

        Assert.assertEquals(
                registrationPage.getSuccessMessage(),
                "Register Account"
        );
    }
}