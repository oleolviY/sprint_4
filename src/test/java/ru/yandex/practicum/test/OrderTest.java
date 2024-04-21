package ru.yandex.practicum.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.page.Page.MainPage;
import ru.yandex.practicum.page.Page.OrderPage;
import ru.yandex.practicum.page.WebDriverFactory;

import static org.junit.Assert.assertTrue;


public class OrderTest {
    private static final String BROWSER = "firefox";
    private WebDriver webDriver;
    private final String firstName = "Северус";
    private final String lastName = "Снейп";
    private final String address = "Хогвартс";
    private final String subway = "Сокольники";
    private final String phone = "79901230909";
    private final String date = "09.01.2024";
    private final String comment = "Всегда!";



    @Before
    public void setUp() {
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        webDriver.get("https://qa-scooter.praktikum-services.ru");
    }

    @Test
    public void orderTest() {
        MainPage maimPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);
        maimPage.closeCookiesWindow();
        maimPage.createOrderBtnClick();
        orderPage.fillCustomerInfo(firstName, lastName, address, subway, phone);
        orderPage.fillRentalInfo(date, comment);
        orderPage.confirm();
        boolean orderIsSuccess = orderPage.orderIsSuccess();
        assertTrue(orderIsSuccess);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

}