package ru.yandex.practicum.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.page.WebDriverFactory;

public abstract class TestHelper {
    public static final String BROWSER = "firefox";
    public WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        webDriver.get("https://qa-scooter.praktikum-services.ru");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
