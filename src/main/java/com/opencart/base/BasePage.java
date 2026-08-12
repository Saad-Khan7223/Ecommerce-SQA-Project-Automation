package com.opencart.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){

        this.driver = driver;

    }

    public void click(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    public void clickWhenClickable(By locator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator));

        element.click();
    }

    public void type(By locator,String text){

        driver.findElement(locator).clear();

        driver.findElement(locator).sendKeys(text);

    }

    public String getText(By locator){

        return driver.findElement(locator).getText();

    }
    public void clear(By locator){
        driver.findElement(locator).clear();
    }

}