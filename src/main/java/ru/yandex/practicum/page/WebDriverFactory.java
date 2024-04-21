package ru.yandex.practicum.page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {
    public static WebDriver getWebDriver(String browserType) {
        if ("firefox".equalsIgnoreCase(browserType)) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
