package ru.yandex.practicum.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.page.Page.MainPage;
import ru.yandex.practicum.page.Page.OrderPage;
import ru.yandex.practicum.page.WebDriverFactory;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderTest extends TestHelper {
    private final String button;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String subway;
    private final String phone;
    private final String date;
    private final String color;
    private final String comment;

    public OrderTest(String button, String firstName, String lastName, String address, String subway, String phone, String date, String color, String comment) {
        this.button = button;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.subway = subway;
        this.phone = phone;
        this.date = date;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Header", "Северус", "Снейп", "Паучий тупик", "Сокольники", "79901230090", "09.01.2024", "grey", "Всегда!"},
                {"Middle", "Альбус", "Дамблдор", "Хогвартс", "Черкизовская", "79901231187", "30.06.2024", "black", "Лимонный щербет"},
        };
    }


    @Test
    public void orderTest() {
        MainPage maimPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);
        maimPage.closeCookiesWindow();
        maimPage.createOrderBtnClick(button);
        orderPage.fillCustomerInfo(firstName, lastName, address, subway, phone);
        orderPage.fillRentalInfo(date, color, comment);
        orderPage.confirm();
        boolean orderIsSuccess = orderPage.orderIsSuccess();
        assertTrue(orderIsSuccess);
    }

}
