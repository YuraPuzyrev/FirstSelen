package org.itstep.qa.homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class First {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.google.com");
    }
}
