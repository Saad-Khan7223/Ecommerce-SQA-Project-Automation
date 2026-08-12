package com.opencart.tests;
import com.opencart.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    ConfigReader config=new ConfigReader();
    protected WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(config.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

}
